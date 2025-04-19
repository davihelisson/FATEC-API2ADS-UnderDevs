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

    private static final FileNameExtensionFilter filter1 = new FileNameExtensionFilter("Python files (*.py)", "py");
    private static final FileNameExtensionFilter filter2 = new FileNameExtensionFilter("Text files (*.txt)", "txt");

    /**
     * Encapsulamento do método writeFile que escreve o arquivo no disco.
     *
     * @param newFileToSave
     * @param fileToSave
     * @return
     */
    private static boolean writeFile(File newFileToSave, CurrentFile fileToSave) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(newFileToSave))) {
            fileToSave.setFileName(newFileToSave.getName());
            fileToSave.setFilePath(newFileToSave.getParent());
            fileToSave.setSaved(true);
            writer.write(fileToSave.content);
            JOptionPane.showMessageDialog(null, "Arquivo " + fileToSave.getFileName() + " salvo com sucesso!");
            return true;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o arquivo.", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * SaveFile Esse método faz o salvamento do arquivo de texto no disco.
     *
     * @param fileToSave
     * @param type
     * @return
     */
    public static boolean saveFile(CurrentFile fileToSave, int type) {
        // Verifica se o arquivo é novo para instanciar a janela Save.
        if (fileToSave.getFullPath() == null || fileToSave.getFileName() == null || !fileToSave.isSaved()) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.addChoosableFileFilter(filter1);
            fileChooser.addChoosableFileFilter(filter2);
            fileChooser.setFileFilter(type == 0 ? filter1 : filter2);
            fileChooser.setDialogTitle("Salvar Arquivo");

            // Setar o diretório do arquivo atual no JFileChooser
            if (fileToSave.getFilePath() != null) {
                fileChooser.setCurrentDirectory(new File(fileToSave.getFilePath()));
            }

            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                if (type == 0) {
                    if (!fileChooser.getSelectedFile().getName().endsWith(".py")) {
                        fileChooser.setSelectedFile(new File(fileChooser.getSelectedFile().getAbsolutePath() + ".py"));
                    }
                } else if (type == 1) {
                    if (!fileChooser.getSelectedFile().getName().endsWith(".txt")) {
                        fileChooser.setSelectedFile(new File(fileChooser.getSelectedFile().getAbsolutePath() + ".txt"));
                    }
                }
                File newFileToSave = fileChooser.getSelectedFile();
                if (newFileToSave.exists()) {
                    int resposta = JOptionPane.showConfirmDialog(null, "O arquivo já existe. Deseja sobrescrever?",
                            "Confirmação", JOptionPane.YES_NO_OPTION);
                    if (resposta != JOptionPane.YES_OPTION) {
                        return false;
                    }
                }
                // Encapsulamento do método writeFile()
                return writeFile(newFileToSave, fileToSave);
            }
        } else {
            File oldFileToSave = new File(fileToSave.getFullPath());
            return writeFile(oldFileToSave, fileToSave);
        }
        return false;
    }

    /**
     * OpenFile Método que executa a abertura do arquivo de texto do disco.
     *
     * @return CurrentFile currentFile
     * @throws IOException
     */
    public static CurrentFile openFile() throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(filter1);
        fileChooser.addChoosableFileFilter(filter2);
        fileChooser.setFileFilter(filter1);
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            CurrentFile currentFile = new CurrentFile(file.getName(), file.getParent(), true);

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

    /**
     * Python Installed? Verifica se o Python está instalado na máquina
     *
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    private static String isPythonInstalled() throws IOException, InterruptedException {
        Process process1 = null;
        Process process2 = null;
        try {
            // Tenta executar python3 --version
            process1 = new ProcessBuilder("python3", "--version").start();
            process2 = new ProcessBuilder("python", "--version").start();

            // Espera o processo terminar com timeout
            boolean test1 = process1.waitFor(2, TimeUnit.SECONDS);
            if (!test1) {
                process1.destroyForcibly();
            }
            boolean test2 = process2.waitFor(2, TimeUnit.SECONDS);
            if (!test2) {
                process2.destroyForcibly();
            }

            // Retorna true apenas se o processo terminou com sucesso (exit code 0)
            if (process1.exitValue() == 0) {
                return "python3";
            } else if (process2.exitValue() == 0) {
                return "python";
            } else {
                return null;
            }

        } finally {
            // Garante que o processo seja destruído
            if (process1 != null && process1.isAlive()) {
                process1.destroyForcibly();
            }
            if (process2 != null && process2.isAlive()) {
                process2.destroyForcibly();
            }
        }
    }

    /**
     * Run Code! Executa o código Python enviado como parâmetro
     *
     * @param absolutePath
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public static StringBuilder runPython(String absolutePath) throws IOException, InterruptedException {

        String pythonName = isPythonInstalled();

        if (pythonName != null) {
            File file = new File(absolutePath);

            // 2. Executar o arquivo Python
            ProcessBuilder pb = new ProcessBuilder(pythonName, file.getAbsolutePath());
            pb.redirectErrorStream(true); // junta stdout e stderr
            Process process = pb.start();

            // 3. Ler a saída do Python
            BufferedReader leitor = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String linha;
            while ((linha = leitor.readLine()) != null) {
                sb.append(linha);
            }

            // 4. Esperar o processo terminar
            process.waitFor();
            return sb;
        } else {
            JOptionPane.showMessageDialog(null,
                    "Python não foi encontrado no sistema.\nPor favor, instale Python e tente novamente.",
                    "Python Não Instalado",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
