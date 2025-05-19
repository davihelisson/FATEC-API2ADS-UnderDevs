package entities;

import java.io.BufferedReader;
import java.io.FileReader;
import io.github.ollama4j.utils.PromptBuilder;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * Carrega um prompt de um arquivo e o combina com código de usuário.
 */
public class LoadPrompts {

    /**
     * Carrega um prompt de um arquivo, concatena com o código do usuário e retorna o resultado.
     *
     * @param fileName Nome do arquivo contendo o prompt.
     * @param userCode Código do usuário a ser adicionado ao prompt.
     * @return O prompt combinado como uma String. Retorna "" em caso de erro.
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

    public static void main(String[] args) {
        System.out.println(loadPrompt("PromptUnitTest.txt", "def soma(a, b): return a + b"));
    }
}
