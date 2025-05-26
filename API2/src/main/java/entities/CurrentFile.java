package entities;

import java.util.Objects;

/**
 * Representa um arquivo aberto no editor, incluindo nome, caminho e conteúdo.
 */
public class CurrentFile {

    private String fileName;
    private String filePath;
    private String content;

    /**
     * Construtor padrão. Inicializa nome, caminho e conteúdo como strings
     * vazias.
     */
    public CurrentFile() {
        this.fileName = "";
        this.filePath = "";
        this.content = "";
    }

    /**
     * Construtor com nome e caminho do arquivo.
     *
     * @param fileName Nome do arquivo.
     * @param filePath Caminho do arquivo.
     */
    public CurrentFile(String fileName, String filePath) {
        this.fileName = Objects.requireNonNull(fileName, "O nome do arquivo não pode ser nulo.");
        this.filePath = Objects.requireNonNull(filePath, "O caminho do arquivo não pode ser nulo.");
        this.content = "";
    }

    /**
     * Retorna o nome do arquivo.
     *
     * @return O nome do arquivo.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Define o nome do arquivo.
     *
     * @param fileName O nome do arquivo.
     */
    public void setFileName(String fileName) {
        this.fileName = Objects.requireNonNull(fileName, "O nome do arquivo não pode ser nulo.");
    }

    /**
     * Retorna o caminho do arquivo.
     *
     * @return O caminho do arquivo.
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Define o caminho do arquivo.
     *
     * @param filePath O caminho do arquivo.
     */
    public void setFilePath(String filePath) {
        this.filePath = Objects.requireNonNull(filePath, "O caminho do arquivo não pode ser nulo.");
    }

    /**
     * Retorna o conteúdo do arquivo.
     *
     * @return O conteúdo do arquivo.
     */
    public String getContent() {
        return content;
    }

    /**
     * Define o conteúdo do arquivo.
     *
     * @param content O conteúdo do arquivo.
     */
    public void setContent(String content) {
        this.content = content != null ? content : "";
    }

    /**
     * Verifica se o conteúdo fornecido é diferente do conteúdo atual do
     * arquivo.
     *
     * @param content O conteúdo para comparação.
     * @return true se houver modificações, false caso contrário.
     */
    public boolean hasModifications(String content) {
        Objects.requireNonNull(content, "O conteúdo para comparação não pode ser nulo.");
        return !this.content.equals(content);
    }
}
