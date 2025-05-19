package utilities;

import entities.CurrentFile;
import enums.FileOptions;
import java.io.*;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Utilitários para manipulação de arquivos.
 */
public class FileUtils {

    private static final FileNameExtensionFilter filter1 = new FileNameExtensionFilter("Arquivos Python (*.py)", "py");
    private static final FileNameExtensionFilter filter2 = new FileNameExtensionFilter("Arquivos de Texto (*.txt)", "txt");

    /**
     * Escreve o conteúdo fornecido em um arquivo.
     *
     * @param fileToSave  O objeto CurrentFile contendo informações sobre o arquivo.
     * @param newContent  O conteúdo a ser escrito no arquivo.
     * @param fileName    O nome do arquivo.
     * @param filePath    O caminho do diretório onde o arquivo será salvo.
     * @return {@code true} se a escrita for bem-sucedida, {@code false} em caso de erro.
     * @throws NullPointerException Se algum dos argumentos for nulo.
     */
    private static boolean writeFile(CurrentFile fileToSave, String newContent, String fileName, String filePath) {
        Objects.requireNonNull(fileToSave, "O objeto CurrentFile não pode ser nulo.");
        Objects.requireNonNull(fileName, "O nome do arquivo não pode ser nulo.");
        Objects.requireNonNull(filePath, "O local do arquivo não pode ser nulo");
        File file = new File(filePath, fileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(newContent);
            fileToSave.setFileName(fileName);
            fileToSave.setFilePath(filePath);
            fileToSave.setContent(newContent);
            return true;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro de I/O: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * Salva o conteúdo em um arquivo. Se o conteúdo foi alterado, exibe um diálogo
     * para selecionar o arquivo se o arquivo original não tiver nome/caminho,
     * ou sobrescreve o arquivo existente.
     *
     * @param fileToSave O arquivo a ser salvo.
     * @param newContent O novo conteúdo a ser salvo.
     * @param op         O tipo de arquivo (SOURCE ou TEXT).
     * @return {@code true} se o arquivo foi salvo com sucesso, {@code false} caso contrário.
     */
    public static boolean saveFile(CurrentFile fileToSave, String newContent, FileOptions op) {
        if (!fileToSave.getContent().equals(newContent)) {
            if ("".equals(fileToSave.getFilePath()) || "".equals(fileToSave.getFileName())) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.addChoosableFileFilter(filter1);
                fileChooser.addChoosableFileFilter(filter2);
                fileChooser.setFileFilter(op.equals(FileOptions.SOURCE) ? filter1 : filter2);
                fileChooser.setDialogTitle("Salvar Arquivo");
                if (!"".equals(fileToSave.getFilePath())) {
                    fileChooser.setCurrentDirectory(new File(fileToSave.getFilePath()));
                }
                if (!"".equals(fileToSave.getFileName())) {
                    fileChooser.setSelectedFile(new File(fileToSave.getFileName()));
                }
                int userSelection = fileChooser.showSaveDialog(null);
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File newFile = fileChooser.getSelectedFile();
                    if (op.equals(FileOptions.SOURCE) && !newFile.getName().endsWith(".py")) {
                        newFile = new File(newFile.getAbsolutePath() + ".py");
                    } else if (op.equals(FileOptions.TEXT) && !newFile.getName().endsWith(".txt")) {
                        newFile = new File(newFile.getAbsolutePath() + ".txt");
                    }
                    if (newFile.exists() && JOptionPane.showConfirmDialog(null, "O arquivo já existe. Deseja sobrescrever?", "Confirmação", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
                        return false;
                    }
                    return writeFile(fileToSave, newContent, newFile.getName(), newFile.getParent());
                }
            } else {
                return writeFile(fileToSave, newContent, fileToSave.getFileName(), fileToSave.getFilePath());
            }
        } else {
            System.out.println("Sem alterações"); // debug
            return false;
        }
        return false;
    }

    /**
     * Abre um arquivo via diálogo, retornando suas informações (nome, caminho e
     * conteúdo) em um {@code CurrentFile}.
     *
     * Apresenta um {@code JFileChooser} com filtros {@code filter1} (inicial) e
     * {@code filter2}. Se um arquivo for selecionado e aprovado, seu conteúdo é
     * lido. Em caso de erro na leitura ou cancelamento, retorna {@code null}.
     *
     * @return Um {@code CurrentFile} com nome, caminho e conteúdo do arquivo
     * aberto, ou {@code null} em caso de cancelamento ou erro de leitura.
     * @see CurrentFile
     * @see javax.swing.JFileChooser
     * @see javax.swing.filechooser.FileFilter
     */
    public static CurrentFile openFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(filter1);
        fileChooser.addChoosableFileFilter(filter2);
        fileChooser.setFileFilter(filter1);
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                CurrentFile currentFile = new CurrentFile(file.getName(), file.getParent());
                StringBuilder conteudo = new StringBuilder();
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String linha;
                    while ((linha = reader.readLine()) != null) {
                        conteudo.append(linha).append('\n');
                    }
                }
                currentFile.setContent(conteudo.toString());
                return currentFile;
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        }
        return null;
    }

    /**
     * Verifica se o Python (versão 3 ou padrão) está instalado no sistema,
     * executando os comandos "python3 --version" e "python --version".
     * A execução de cada comando tem um timeout de 2 segundos.
     *
     * @return Uma string indicando a versão do Python instalada ("python3" ou
     * "python"), ou {@code null} se nenhuma versão for detectada ou ocorrer um
     * erro durante a verificação. Em caso de erro de I/O ou interrupção, uma
     * caixa de diálogo de erro é exibida ao usuário.
     */
    private static String isPythonInstalled() {
        Process process1 = null;
        Process process2 = null;
        try {
            process1 = new ProcessBuilder("python3", "--version").start();
            process2 = new ProcessBuilder("python", "--version").start();

            boolean test1 = process1.waitFor(2, TimeUnit.SECONDS);
            if (!test1) {
                process1.destroyForcibly();
            }
            boolean test2 = process2.waitFor(2, TimeUnit.SECONDS);
            if (!test2) {
                process2.destroyForcibly();
            }

            if (process1.exitValue() == 0) {
                return "python3";
            } else if (process2.exitValue() == 0) {
                return "python";
            } else {
                return null;
            }
        } catch (IOException | InterruptedException e) {
            JOptionPane.showMessageDialog(null, "Erro ao verificar o Python: " + e.getMessage(), "Erro de I/O", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            if (process1 != null && process1.isAlive()) {
                process1.destroyForcibly();
            }
            if (process2 != null && process2.isAlive()) {
                process2.destroyForcibly();
            }
        }
    }

    /**
     * Executa um script Python localizado no caminho absoluto especificado.
     * Primeiro, verifica se o Python está instalado no sistema utilizando o
     * método {@link #isPythonInstalled()}. Se o Python for encontrado, o script
     * é executado e a saída do script (stdout e stderr combinados) é capturada
     * e retornada. Se o Python não for encontrado, uma caixa de diálogo de erro
     * é exibida ao usuário e {@code null} é retornado. Em caso de IOException
     * ou InterruptedException durante a execução do script, uma caixa de
     * diálogo de erro é exibida e {@code null} é retornado.
     *
     * @param absolutePath O caminho absoluto para o arquivo Python a ser
     * executado.
     * @return Um {@code StringBuilder} contendo a saída do script Python, com
     * cada linha terminada por uma quebra de linha. Retorna {@code null} se o
     * Python não estiver instalado ou se ocorrer um erro durante a execução do
     * script.
     */
    public static StringBuilder runPython(String absolutePath) {
        String pythonName = isPythonInstalled();
        if (pythonName != null) {
            try {
                File file = new File(absolutePath);
                ProcessBuilder pb = new ProcessBuilder(pythonName, file.getAbsolutePath());
                pb.redirectErrorStream(true);
                Process process = pb.start();
                StringBuilder sb = new StringBuilder();
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                    String linha;
                    while ((linha = reader.readLine()) != null) {
                        sb.append(linha).append('\n');
                    }
                }
                process.waitFor();
                return sb;
            } catch (IOException | InterruptedException e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Python não foi encontrado no sistema.\nPor favor, instale Python e tente novamente.", "Python não encontrado", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
