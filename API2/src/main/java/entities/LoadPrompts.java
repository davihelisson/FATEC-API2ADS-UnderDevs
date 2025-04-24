/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.BufferedReader;
import java.io.FileReader;
import io.github.ollama4j.utils.PromptBuilder;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Family
 */
public class LoadPrompts {

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
            JOptionPane.showMessageDialog(null,
                    "Erro de I/O " + ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return "";
        }

    }
    
    public static void main(String[] args) {
        System.out.println(loadPrompt("PromptUnitTest.txt", "def soma(a, b): return a + b"));
    }
}
