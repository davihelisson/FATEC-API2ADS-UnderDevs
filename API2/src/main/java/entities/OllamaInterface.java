package entities;

import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.models.response.OllamaResult;
import io.github.ollama4j.utils.OptionsBuilder;
import java.io.IOException;

public class OllamaInterface {
    private String host = "http://localhost:11434/";
    private int requestTimeOut = 240;
    OllamaAPI ollamaAPI = new OllamaAPI(host);
    
    public OllamaInterface(){
        
    }
    
    public OllamaInterface(String host){
        this.host = host;
    }
    
    public OllamaInterface(String host, int requestTimeOut){
        this.host = host;
        this.requestTimeOut = requestTimeOut;
    }

    public String GenerateTest(String prompt, String sourceCode) throws Exception {
        try {
            ollamaAPI.setRequestTimeoutSeconds(requestTimeOut);
            OllamaResult result = ollamaAPI.generate(
                "qwen2.5-coder",
                new StringBuilder(prompt).append(" ").append(sourceCode).toString(),
                false,
                new OptionsBuilder().build()
            );

            if (result != null) {
                return result.getResponse();
            } else {
                return null; // ou lançar uma exceção personalizada
            }
        } catch (IOException e) {
            throw new Exception("Erro de IO", e);
        }
    }
}