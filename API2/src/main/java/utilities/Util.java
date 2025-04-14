/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import entities.CurrentFile;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author XvierDev
 */
public class Util {
    /**
     * Esse método faz o salvamento do arquivo de texto no disco.
     * @param diretorioSelecionado
     * @param nomeArquivoAberto
     * @param content 
     */
    public static void saveFile (String diretorioSelecionado, String nomeArquivoAberto, String content){
        JFileChooser fileChooser = new JFileChooser();

        if (diretorioSelecionado != null) {
            fileChooser.setCurrentDirectory(new File(diretorioSelecionado));
        }

        if (nomeArquivoAberto != null && !nomeArquivoAberto.isEmpty()) {
            fileChooser.setSelectedFile(new File(diretorioSelecionado, nomeArquivoAberto + ".py"));
        }

        fileChooser.setDialogTitle("Salvar Arquivo");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Python Files", "py"));

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            if (!fileToSave.getAbsolutePath().endsWith(".py")) {
                fileToSave = new File(fileToSave.getAbsolutePath() + ".py");
            }

            if (fileToSave.exists()) {
                int resposta = JOptionPane.showConfirmDialog(null, "O arquivo já existe. Deseja sobrescrever?",
                        "Confirmação", JOptionPane.YES_NO_OPTION);
                if (resposta != JOptionPane.YES_OPTION) {
                    return;
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))) {
                writer.write(content);
                JOptionPane.showMessageDialog(null, "Arquivo salvo com sucesso!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar o arquivo.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    /**
     * Método que executa a abertura do arquivo de texto do disco.
     * @return CurrentFile currentFile
     * @throws IOException 
     */
    public static CurrentFile openFile() throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivos Python (*.py)", "py"));
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            CurrentFile currentFile = new CurrentFile(file.getName().replace(".py", ""), file.getParent());

            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder conteudo = new StringBuilder();
            String linha;
            while ((linha = reader.readLine()) != null) {
                conteudo.append(linha).append('\n');
            }
            currentFile.content = conteudo.toString();
            return currentFile;
        }
        return null;
    }
    
}
