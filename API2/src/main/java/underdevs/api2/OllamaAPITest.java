/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package underdevs.api2;

import io.github.ollama4j.OllamaAPI;
// import io.github.ollama4j.models.response.Model;
import io.github.ollama4j.models.response.OllamaResult;
import io.github.ollama4j.utils.OptionsBuilder;

// import java.util.List;

public class OllamaAPITest {
    public static void main(String[] args) {
        OllamaAPI ollamaAPI = new OllamaAPI(); // Cria o objeto principal

        // boolean isOllamaServerReachable = ollamaAPI.ping();
        // System.out.println("Is Ollama server running: " + isOllamaServerReachable);
        
        try{
            // List<Model> models = ollamaAPI.listModels();
            // models.forEach(model -> System.out.println(model.getName()));
            OllamaResult result;
            ollamaAPI.setRequestTimeoutSeconds(120); // setando tempo de resposta
            result = ollamaAPI.generate("qwen2.5-coder", "diga: olá", false, new OptionsBuilder().build()); // envia uma pergunta simples
            System.out.println("Result: " + result.getResponse());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }    
}
