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
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;
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
     * 
     * @param diretorioSelecionado
     * @param nomeArquivoAberto
     * @param content
     */
    public static void saveFile(String diretorioSelecionado, String nomeArquivoAberto, String content) {
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
     * 
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

    public static String isPython3Installed() throws IOException, InterruptedException {
        Process process1 = null;
        Process process2 = null;
        Process process3 = null;
        try {
            // Tenta executar python3 --version
            process1 = new ProcessBuilder("python3", "--version").start();
            process2 = new ProcessBuilder("py", "--version").start();
            process3 = new ProcessBuilder("python", "--version").start();
            

            // Espera o processo terminar com timeout
            boolean test1 = process1.waitFor(2, TimeUnit.SECONDS);
            if (!test1) process1.destroyForcibly();
            boolean test2 = process2.waitFor(2, TimeUnit.SECONDS);
            if (!test2) process2.destroyForcibly();
            boolean test3 = process3.waitFor(2, TimeUnit.SECONDS);
            if (!test3) process3.destroyForcibly();

            // Retorna true apenas se o processo terminou com sucesso (exit code 0)
            if(process1.exitValue() == 0) return "python3";
            else if(process2.exitValue() == 0) return "py";
            else if(process3.exitValue() == 0) return "python";
            
            else return null;

        } finally {
            // Garante que o processo seja destruído
            if (process1 != null && process1.isAlive()) process1.destroyForcibly();
            if (process2 != null && process2.isAlive()) process2.destroyForcibly();
            if (process3 != null && process3.isAlive()) process3.destroyForcibly();
        }
    }

    public static StringBuilder runPython(String pythonName, String codigoPython) throws IOException, InterruptedException {

        // 1. Salvar o código Python num arquivo temporário
        File arquivo = new File("codigo_temp.py");
        try (FileWriter escritor = new FileWriter(arquivo)) {
            escritor.write(codigoPython);
        }

        // 2. Executar o arquivo Python
        // Obs: pode ser "python3" dependendo do sistema
        ProcessBuilder pb = new ProcessBuilder(pythonName, arquivo.getAbsolutePath());
        pb.redirectErrorStream(true); // junta stdout e stderr
        Process processo = pb.start();

        // 3. Ler a saída do Python
        BufferedReader leitor = new BufferedReader(new InputStreamReader(processo.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String linha;
        while ((linha = leitor.readLine()) != null) {
            sb.append(linha);
        }

        // 4. Esperar o processo terminar
        processo.waitFor();
        return sb;

    }

}