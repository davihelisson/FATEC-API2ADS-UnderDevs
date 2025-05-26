package entities;

import java.io.BufferedReader;
import java.io.FileReader;
import io.github.ollama4j.utils.PromptBuilder;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * Carrega prompts de arquivos e os combina com código do usuário.
 */
public class LoadPrompts {

    /**
     * Carrega um prompt de um arquivo e o anexa ao código do usuário.
     *
     * @param fileName O nome do arquivo do prompt.
     * @param userCode O código do usuário a ser anexado.
     * @return O prompt completo. Retorna uma string vazia em caso de erro.
     */
    public static String loadPrompt(String fileName, String userCode) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            PromptBuilder pb = new PromptBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                pb.addLine(line);
            }
            pb.addLine(userCode);
            return pb.build();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro de E/S: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return "";
        }
    }
}
