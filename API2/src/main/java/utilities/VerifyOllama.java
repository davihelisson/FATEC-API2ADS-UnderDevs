package utilities;

import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.exceptions.OllamaBaseException;
import io.github.ollama4j.models.response.Model;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;

/**
 * Classe para verificar se o Ollama está em execução.
 */
public class VerifyOllama {

    /**
     * Verifica se o Ollama está rodando na porta padrão
     * (http://localhost:11434/).
     *
     * @param model
     * @return {@code true} se o Ollama estiver rodando e acessível,
     * {@code false} caso contrário.
     */
    public static boolean isOllamaRunning(String model) {
        try {
            String host = "http://localhost:11434/";;
            OllamaAPI ollamaAPI = new OllamaAPI(host);
            if (!ollamaAPI.ping()) {
                return false;
            } else {
                for (Model m : ollamaAPI.listModels()) {
                    if (m.getModelName().equals(model)) {
                        return true;
                    }
                }
                int result = JOptionPane.showConfirmDialog(
                        null,
                        "Modelo não encontrado, deseja tentar o Download?",
                        "Confirmação",
                        JOptionPane.YES_NO_OPTION
                );
                if(result == JOptionPane.YES_OPTION){
                    ollamaAPI.pullModel(model);
                }
                else{
                    return false;
                }

            }
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "Erro de comunicação com Ollama: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (OllamaBaseException | InterruptedException | URISyntaxException | IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}
