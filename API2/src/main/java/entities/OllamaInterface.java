/* UNDERDEVS ADS2 - PYTHONT IDE WITH JAVA AND OLLAMA.
 - Entidade responsável pela conexão com OLLAMA 
 - Essa classe é responsável por permitir a criação de um objetido OllamaInterface
 - cujos único método é generateTest que recebe como parâmetro uma string contendo
 - os prompts e o código definido pelo usuário e retorna o resultado produzido pelo
 - LLM como uma string que deve ser capturada como saída para o Teste Unitário.
 - by Wesley and Team.
 */
package entities;

import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.models.response.OllamaAsyncResultStreamer;
import io.github.ollama4j.models.response.OllamaResult;
import io.github.ollama4j.utils.OptionsBuilder;
import java.io.IOException;

public class OllamaInterface {

    private String host = "http://localhost:11434/";
//  private String host = "http://192.168.15.13:11434";
    private int requestTimeOut = 240;
    OllamaAPI ollamaAPI = new OllamaAPI(host);

    public OllamaInterface() {

    }

    // Construtor com host personalizado
    public OllamaInterface(String host) {
        this.host = host;
    }

    // Construtor com hots e request time out personalizado.
    public OllamaInterface(String host, int requestTimeOut) {
        this.host = host;
        this.requestTimeOut = requestTimeOut;
    }

    /**
     * Gera um caso de teste utilizando um modelo de linguagem através da API
     * Ollama.
     *
     * Envia um prompt contendo código para o modelo "qwen2.5-coder" hospedado
     * pela API Ollama e retorna a resposta gerada, após remover quaisquer
     * formatações de bloco de código Markdown.
     *
     * @param promptWithCode O prompt contendo o código para o qual o caso de
     * teste deve ser gerado.
     * @return O caso de teste gerado pelo modelo, sem as linhas delimitadoras
     * de bloco de código Markdown.
     * @throws Exception Se ocorrer um erro de comunicação com a API Ollama ou
     * um erro de entrada/saída durante a requisição.
     *
     * @see #removeMarkdown(String)
     */
    public String GenerateTest(String promptWithCode) throws Exception {
        try {
            ollamaAPI.setRequestTimeoutSeconds(requestTimeOut);
//            OllamaResult result = ollamaAPI.generate(
//                    "qwen2.5-coder",
//                    promptWithCode,
//                    false,
//                    new OptionsBuilder().build());
//            String prompt = "List all cricket world cup teams of 2019.";
            OllamaAsyncResultStreamer streamer = ollamaAPI.generateAsync("qwen2.5-coder", promptWithCode, false);

            // Set the poll interval according to your need.
            // Smaller the poll interval, more frequently you receive the tokens.
            int pollIntervalMilliseconds = 1000;
            StringBuilder sb = new StringBuilder();
            String result;
            while (true) {
                String tokens = streamer.getStream().poll();
                System.out.print(tokens);
                sb.append(tokens);
                if (!streamer.isAlive()) {
                    break;
                }
                Thread.sleep(pollIntervalMilliseconds);
            }
            result = sb.toString();
            if (result != null) {
//                return result.getResponse();
                return removeMarkdown(result);
            } else {
                throw new Exception("Erro de comunicação: ");
            }
        } catch (IOException e) {
            throw new IOException("Erro ao tentar realizar a operação de I/O", e);
        } catch (Exception e) {
            throw new Exception("Erro inesperado ao gerar o teste", e);
        }
    }

    /**
     * Remove as linhas delimitadoras de blocos de código Markdown (` ``` `) do
     * início e do fim de uma String.
     *
     * @param output A String contendo o texto potencialmente formatado com
     * Markdown.
     * @return Uma nova String com as linhas delimitadoras de bloco de código
     * removidas, se existirem.
     */
    private String removeMarkdown(String output) {
        String[] lines = output.split("\n");
        if (lines[0].trim().startsWith("`")) {
            lines = java.util.Arrays.copyOfRange(lines, 1, lines.length);
        }
        if (lines[lines.length - 1].trim().startsWith("`")) {
            lines = java.util.Arrays.copyOfRange(lines, 0, lines.length - 1);
        }
        StringBuilder result = new StringBuilder();
        for (String line : lines) {
            result.append(line).append("\n");
        }
        return result.toString();
    }
}
