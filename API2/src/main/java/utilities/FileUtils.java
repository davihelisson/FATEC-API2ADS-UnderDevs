package utilities;

import enums.FileOptions;
import entities.CurrentFile;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author XvierDev
 */
public class FileUtils {

    private static final FileNameExtensionFilter filter1 = new FileNameExtensionFilter("Python files (*.py)", "py");
    private static final FileNameExtensionFilter filter2 = new FileNameExtensionFilter("Text files (*.txt)", "txt");

    /**
     * Escreve o conteúdo fornecido no arquivo representado pelo objeto
     * {@code CurrentFile}.
     *
     * Este método encapsula a lógica de escrita do conteúdo em disco. Ele
     * utiliza as informações de caminho e nome de arquivo presentes no objeto
     * {@code fileToSave} para localizar o arquivo e, em seguida, escreve o
     * conteúdo especificado.
     *
     * @param fileToSave O objeto {@code CurrentFile} que contém as informações
     * do arquivo (caminho e nome) a ser escrito. Não pode ser {@code null}.
     * @param newContent O conteúdo a ser escrito no arquivo. Se for
     * {@code null}, nada será escrito.
     * @throws NullPointerException Se o parâmetro {@code fileToSave} for
     * {@code null}.
     * @throws IOException Se ocorrer um erro durante a operação de escrita no
     * arquivo (por exemplo, problemas de permissão, disco cheio, arquivo não
     * encontrado, etc.).
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
            JOptionPane.showMessageDialog(null,
                    "Erro de I/O " + ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * Salva o conteúdo atual no arquivo associado ao objeto
     * {@code CurrentFile}.
     *
     * Este método verifica se o conteúdo atual do {@code fileToSave} difere do
     * {@code newContent} fornecido. Se houver alterações, ele procede com a
     * operação de salvar.
     *
     * Se o arquivo ainda não tiver um caminho e nome definidos, um diálogo
     * {@code JFileChooser} será apresentado ao usuário para escolher o local e
     * o nome do arquivo. A extensão do arquivo será forçada para ".py" se
     * {@code op} for {@code FileOptions.SOURCE} e para ".txt" se for
     * {@code FileOptions.TEXT}.
     *
     * Se o arquivo selecionado já existir, uma caixa de diálogo de confirmação
     * será exibida perguntando ao usuário se deseja sobrescrevê-lo.
     *
     * Se o arquivo já tiver um caminho e nome definidos, o conteúdo será
     * diretamente gravado nesse local, sem exibir o diálogo de seleção de
     * arquivo.
     *
     * @param fileToSave O objeto {@code CurrentFile} representando o arquivo a
     * ser salvo. Não pode ser {@code null}.
     * @param newContent O novo conteúdo a ser gravado no arquivo.
     * @param op Uma enumeração {@code FileOptions} indicando o tipo do arquivo
     * (SOURCE ou TEXT), usada para definir o filtro e a extensão padrão no
     * diálogo de seleção de arquivo. Não pode ser {@code null}.
     * @return {@code true} se o arquivo foi salvo com sucesso (ou se não houve
     * alterações); {@code false} se a operação de salvar foi cancelada pelo
     * usuário, ocorreu um erro durante o processo de salvamento ou se o usuário
     * optou por não sobrescrever um arquivo existente.
     * @throws NullPointerException Se {@code fileToSave} ou {@code op} forem
     * {@code null}.
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
                    if (op.equals(FileOptions.SOURCE)) {
                        if (!fileChooser.getSelectedFile().getName().endsWith(".py")) {
                            fileChooser.setSelectedFile(new File(fileChooser.getSelectedFile().getAbsolutePath() + ".py"));
                        }
                    } else if (op.equals(FileOptions.TEXT)) {
                        if (!fileChooser.getSelectedFile().getName().endsWith(".txt")) {
                            fileChooser.setSelectedFile(new File(fileChooser.getSelectedFile().getAbsolutePath() + ".txt"));
                        }
                    }
                    File newFile = fileChooser.getSelectedFile();
                    if (newFile.exists()) {
                        int resposta = JOptionPane.showConfirmDialog(null, "O arquivo já existe. Deseja sobrescrever?",
                                "Confirmação", JOptionPane.YES_NO_OPTION);
                        if (resposta != JOptionPane.YES_OPTION) {
                            return false;
                        }
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
     * Abre um arquivo usando um diálogo de seleção de arquivo e retorna um
     * objeto {@code CurrentFile} contendo as informações do arquivo (nome,
     * caminho e conteúdo).
     *
     * Este método apresenta um diálogo {@code JFileChooser} ao usuário,
     * permitindo que ele navegue pelo sistema de arquivos e selecione um
     * arquivo para abrir. Dois filtros de arquivo ({@code filter1} e
     * {@code filter2}) são adicionados ao diálogo, com {@code filter1} sendo o
     * filtro inicial selecionado.
     *
     * Se o usuário aprovar a seleção de um arquivo, o método tenta ler o
     * conteúdo desse arquivo linha por linha e armazena-o no atributo
     * {@code content} de um novo objeto {@code CurrentFile}. O nome e o caminho
     * do arquivo selecionado também são armazenados nesse objeto.
     *
     * Em caso de erro durante a leitura do arquivo (por exemplo, arquivo não
     * encontrado, permissão negada), uma mensagem de erro é exibida ao usuário
     * através de um {@code JOptionPane}, e o método retorna {@code null}.
     *
     * Se o usuário cancelar o diálogo de seleção de arquivo, o método também
     * retorna {@code null}.
     *
     * @return Um novo objeto {@code CurrentFile} contendo o nome, caminho e
     * conteúdo do arquivo aberto, ou {@code null} se o usuário cancelar a
     * seleção ou ocorrer um erro durante a leitura do arquivo.
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

                BufferedReader reader = new BufferedReader(new FileReader(file));
                StringBuilder conteudo = new StringBuilder();
                String linha;
                while ((linha = reader.readLine()) != null) {
                    conteudo.append(linha).append('\n');
                }
                currentFile.setContent(conteudo.toString());
                return currentFile;
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo: " + ex.getMessage(), "Erro",
                        JOptionPane.ERROR_MESSAGE);
                return null;
            }
        }
        return null;
    }

    /**
     * Verifica se o interpretador Python (versão 3 ou padrão) está instalado no
     * sistema.
     *
     * Este método tenta executar os comandos "python3 --version" e "python
     * --version" para verificar a presença dos interpretadores Python. Cada
     * tentativa tem um tempo limite de 2 segundos.
     *
     * O método retorna a string "python3" se o comando "python3 --version" for
     * executado com sucesso (código de saída 0). Se essa tentativa falhar, ele
     * tenta o comando "python --version". Se este último for bem-sucedido, o
     * método retorna a string "python".
     *
     * Se nenhuma das tentativas de executar os comandos for bem-sucedida dentro
     * do tempo limite, o método retorna {@code null}, indicando que nenhum
     * interpretador Python foi detectado.
     *
     * Em caso de falha ao iniciar os processos ou interrupção durante a espera,
     * as exceções {@code IOException} ou {@code InterruptedException} são
     * lançadas. O bloco {@code finally} garante que quaisquer processos ainda
     * em execução sejam destruídos forçosamente.
     *
     * @return "python3" se o Python 3 for detectado, "python" se o Python
     * padrão (geralmente 2.x ou um link para 3.x) for detectado, ou
     * {@code null} se nenhum interpretador Python for encontrado.
     * @throws IOException Se ocorrer um erro de E/S ao iniciar os processos.
     * @throws InterruptedException Se o thread atual for interrompido enquanto
     * espera pelos processos terminarem.
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
     * Executa um script Python especificado pelo caminho absoluto e retorna a
     * saída do script.
     *
     * Este método primeiro tenta determinar o nome do executável Python
     * disponível no sistema chamando o método {@code isPythonInstalled()}. Se
     * um interpretador Python for encontrado (seja "python3" ou "python"), ele
     * prossegue com a execução do script.
     *
     * O script Python é executado como um processo separado usando
     * {@code ProcessBuilder}. A saída padrão (stdout) e o fluxo de erros padrão
     * (stderr) do processo Python são redirecionados para o mesmo fluxo, que é
     * então lido linha por linha.
     *
     * O método aguarda a conclusão do processo Python antes de retornar a saída
     * coletada em um objeto {@code StringBuilder}.
     *
     * Se nenhum interpretador Python for encontrado no sistema, uma mensagem de
     * erro é exibida ao usuário através de um {@code JOptionPane}, e o método
     * retorna {@code null}.
     *
     * @param absolutePath O caminho absoluto para o arquivo de script Python a
     * ser executado. Não pode ser {@code null} ou vazio.
     * @return Um {@code StringBuilder} contendo toda a saída gerada pelo script
     * Python, ou {@code null} se nenhum interpretador Python for encontrado ou
     * se o {@code absolutePath} for inválido.
     * @throws IOException Se ocorrer um erro de E/S ao iniciar o processo
     * Python.
     * @throws InterruptedException Se o thread atual for interrompido enquanto
     * espera a conclusão do processo Python.
     * @throws NullPointerException Se {@code absolutePath} for {@code null}.
     * @throws IllegalArgumentException Se {@code absolutePath} for uma string
     * vazia.
     */
    public static StringBuilder runPython(String absolutePath) throws IOException, InterruptedException {

        String pythonName = isPythonInstalled();

        if (pythonName != null) {
            File file = new File(absolutePath);

            // 1. Executar o arquivo Python
            ProcessBuilder pb = new ProcessBuilder(pythonName, file.getAbsolutePath());
            pb.redirectErrorStream(true); // junta stdout e stderr
            Process process = pb.start();

            // 2. Ler a saída do Python
            BufferedReader leitor = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String linha;
            while ((linha = leitor.readLine()) != null) {
                sb.append(linha);
                sb.append('\n');
            }

            // 3. Esperar o processo terminar
            process.waitFor();
            return sb;
        } else {
            JOptionPane.showMessageDialog(null,
                    "Python não foi encontrado no sistema.\nPor favor, instale Python e tente novamente.",
                    "Python não encontrado",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
