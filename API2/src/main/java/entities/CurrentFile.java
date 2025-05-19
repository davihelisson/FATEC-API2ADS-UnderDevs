package entities;

import java.util.Objects;

/**
 * Representa um arquivo atualmente aberto no editor de texto.
 *
 * Esta classe mantém informações essenciais sobre o arquivo em edição, como nome,
 * caminho e conteúdo, e fornece métodos para acessá-las e modificá-las.
 */
public class CurrentFile {

    private String fileName;
    private String filePath;
    private String content;

    /**
     * Construtor padrão.
     *
     * Inicializa o nome, caminho e conteúdo do arquivo com strings vazias.
     */
    public CurrentFile() {
        this.fileName = "";
        this.filePath = "";
        this.content = "";
    }

    /**
     * Construtor com nome e caminho do arquivo.
     *
     * @param fileName Nome do arquivo (não nulo).
     * @param filePath Caminho do arquivo (não nulo).
     * @throws NullPointerException Se fileName ou filePath forem nulos.
     */
    public CurrentFile(String fileName, String filePath) {
        this.fileName = Objects.requireNonNull(fileName, "O nome do arquivo não pode ser nulo.");
        this.filePath = Objects.requireNonNull(filePath, "O caminho do arquivo não pode ser nulo.");
        this.content = "";
    }

    /**
     * Obtém o nome do arquivo.
     *
     * @return O nome do arquivo.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Define o nome do arquivo.
     *
     * @param fileName O nome do arquivo (não nulo).
     * @throws NullPointerException Se fileName for nulo.
     */
    public void setFileName(String fileName) {
        this.fileName = Objects.requireNonNull(fileName, "O nome do arquivo não pode ser nulo.");
    }

    /**
     * Obtém o caminho do arquivo.
     *
     * @return O caminho do arquivo.
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Define o caminho do arquivo.
     *
     * @param filePath O caminho do arquivo (não nulo).
     * @throws NullPointerException Se filePath for nulo.
     */
    public void setFilePath(String filePath) {
        this.filePath = Objects.requireNonNull(filePath, "O caminho do arquivo não pode ser nulo.");
    }

    /**
     * Obtém o conteúdo do arquivo.
     *
     * @return O conteúdo do arquivo.
     */
    public String getContent() {
        return content;
    }

    /**
     * Define o conteúdo do arquivo.
     *
     * @param content O conteúdo do arquivo (pode ser nulo).
     */
    public void setContent(String content) {
        this.content = content != null ? content : ""; // Garante que content nunca seja nulo
    }

    /**
     * Verifica se o conteúdo fornecido é diferente do conteúdo atual do arquivo.
     *
     * @param content O conteúdo a ser comparado (não nulo).
     * @return {@code true} se o conteúdo for diferente, {@code false} caso contrário.
     * @throws NullPointerException Se o conteúdo for nulo.
     */
    public boolean hasModifications(String content) {
        Objects.requireNonNull(content, "O conteúdo para comparação não pode ser nulo.");
        return !this.content.equals(content);
    }
}
