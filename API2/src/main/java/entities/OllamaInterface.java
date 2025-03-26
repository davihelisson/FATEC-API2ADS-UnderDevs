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

// Parte responsável pela abertura de arquivos.
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OllamaAPITest {
    public static void main(String[] args) {
        OllamaAPI ollamaAPI = new OllamaAPI(); // Cria o objeto principal

        // boolean isOllamaServerReachable = ollamaAPI.ping();
        // System.out.println("Is Ollama server running: " + isOllamaServerReachable);
        
        try{
            String content = new String(Files.readAllBytes(Paths.get("test.py")));
            // List<Model> models = ollamaAPI.listModels();
            // models.forEach(model -> System.out.println(model.getName()));
            OllamaResult result;
            ollamaAPI.setRequestTimeoutSeconds(120); // setando tempo de resposta
            result = ollamaAPI.generate("qwen2.5-coder", "create a unit test for the script showing only the text code without any additional text without markdown: " + content, false, new OptionsBuilder().build()); // envia uma pergunta simples
            System.out.println("Result: " + result.getResponse());
            Files.write(Paths.get("output.py"), result.getResponse().getBytes());
        }
        catch (IOException e){
            System.err.println("Erro ao abrir o arquivo: " + e.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }    
}
