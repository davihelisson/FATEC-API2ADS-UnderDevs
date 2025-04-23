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
import io.github.ollama4j.models.response.OllamaResult;
import io.github.ollama4j.utils.OptionsBuilder;
import java.io.IOException;

public class OllamaInterface {
    private String host = "http://localhost:11434/";
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

    public String GenerateTest(String promptWithCode) throws Exception {
        try {
            ollamaAPI.setRequestTimeoutSeconds(requestTimeOut);
            OllamaResult result = ollamaAPI.generate(
                    "qwen2.5-coder",
                    promptWithCode,
                    false,
                    new OptionsBuilder().build());

            if (result != null) {
                return result.getResponse();
            //  return removeMarkdown(result.getResponse());
            } else {
                throw new Exception("Erro de comunicação: ");
            }
        } catch (IOException e) {
            throw new Exception("Erro de IO", e);
        }
    }
    
    private String removeMarkdown (String output){
        String[] lines = output.split("\n");
        if (lines[0].trim().startsWith("`")){
            lines = java.util.Arrays.copyOfRange(lines, 1, lines.length);
        }
        if (lines[lines.length - 1].trim().startsWith("`")){
            lines = java.util.Arrays.copyOfRange(lines, 0, lines.length - 1);
        }
        StringBuilder result = new StringBuilder();
        for (String line : lines){
            result.append(line).append("\n");
        }
        return result.toString();
    }
}