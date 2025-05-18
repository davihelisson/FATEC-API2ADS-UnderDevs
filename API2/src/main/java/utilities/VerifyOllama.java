package utilities;

import io.github.ollama4j.OllamaAPI;

public class VerifyOllama {

    public static boolean isOllamaRunning() {
        try {
            String host = "http://localhost:11434/";

            OllamaAPI ollamaAPI = new OllamaAPI(host);

            return ollamaAPI.ping();
        } catch (RuntimeException e) {
            System.out.println("Erro de comunicação com Ollama: " + e.getMessage());
            return false;
        }
    }
}
