/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author Fatec
 */
public class PromptManager {
    private SugestaoDAO dao;

    public PromptManager(SugestaoDAO dao) {
        this.dao = dao;
    }

    public String gerarTextoComSugestoes() {
        List<Sugestao> sugestoes = dao.buscarSugestoesNaoUtilizadas();
        StringBuilder promptAdicional = new StringBuilder();
        
        if (sugestoes.isEmpty()) {
            promptAdicional.append("Nenhuma sugestão de melhoria pendente.");
        } else {
            promptAdicional.append("Melhorias sugeridas:\n");
            for (Sugestao sugestao : sugestoes) {
                promptAdicional.append("------------------------------\n");
                promptAdicional.append("Código Original:\n")
                              .append(sugestao.getCodigoOriginal())
                              .append("\n");
                promptAdicional.append("Melhoria Sugerida:\n")
                              .append(sugestao.getMelhoriaSugerida())
                              .append("\n");
                promptAdicional.append("Data: ")
                              .append(sugestao.getDataSugestao().toLocalDateTime())
                              .append("\n");
            }
        }
        return promptAdicional.toString();
    }
    
    public void atualizarArquivoPrompt() {
        String textoPrompt = gerarTextoComSugestoes();
        try (FileWriter writer = new FileWriter("prompt_sugestoes.txt")) {
            writer.write(textoPrompt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String construirPromptFinal(String promptBase) {
        String melhorias = gerarTextoComSugestoes();
        return promptBase + "\n\n" + "Sugestões anteriores:\n" + melhorias;
    }
}