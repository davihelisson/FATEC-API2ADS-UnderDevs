package entities;

import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.models.response.OllamaResult;
import io.github.ollama4j.utils.OptionsBuilder;
import java.io.IOException;
import javax.swing.JOptionPane;
import utilities.VerifyOllama;

/**
 * Conecta e interage com a API do Ollama para geração de texto.
 */
public class OllamaInterface {

    private String host = "http://localhost:11434/";
    private int requestTimeOut = 240;
    private final OllamaAPI ollamaAPI = new OllamaAPI(host);

    /**
     * Construtor padrão da OllamaInterface.
     */
    public OllamaInterface() {
    }

    /**
     * Construtor com host personalizado.
     *
     * @param host O endereço do host da API Ollama.
     */
    public OllamaInterface(String host) {
        this.host = host;
    }

    /**
     * Construtor com host e timeout de requisição personalizados.
     *
     * @param host O endereço do host da API Ollama.
     * @param requestTimeOut O tempo limite da requisição em segundos.
     */
    public OllamaInterface(String host, int requestTimeOut) {
        this.host = host;
        this.requestTimeOut = requestTimeOut;
    }

    /**
     * Gera uma resposta usando o modelo "qwen2.5-coder" do Ollama. Envia um
     * prompt completo e retorna a resposta gerada, removendo a formatação
     * Markdown.
     *
     * @param completePrompt O prompt completo a ser enviado ao modelo.
     * @return A resposta gerada pelo Ollama, sem formatação Markdown.
     */
    public String GenerateTest(String completePrompt) {
        try {
            String model = "qwen2.5-coder";
            if (VerifyOllama.isOllamaRunning(model)) {
                ollamaAPI.setRequestTimeoutSeconds(requestTimeOut);
                OllamaResult result = ollamaAPI.generate(
                        model,
                        completePrompt,
                        false,
                        new OptionsBuilder().build());
                if (result != null) {
                    return removeMarkdown(result.getResponse());
                } else {
                    throw new Exception("Erro de comunicação com Ollama");
                }
            } else {
                return null;
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro de E/S: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return "";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return "";
        }
    }

    /**
     * Remove a formatação de bloco de código Markdown (` ```) de uma string.
     *
     * @param output A string com formatação Markdown.
     * @return A string sem a formatação Markdown.
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
