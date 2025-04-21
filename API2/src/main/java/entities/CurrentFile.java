package entities;

import java.util.Objects;

/**
 * Representa um arquivo atualmente aberto na interface do editor de texto.
 *
 * Esta classe mantém informações essenciais sobre o arquivo em edição,
 * como seu nome, caminho completo e o conteúdo atual em memória.
 * Ela fornece métodos para acessar e modificar essas informações,
 * além de verificar se o arquivo foi alterado.
 *
 * Atributos principais:
 * <ul>
 * <li>{@code fileName}: O nome base do arquivo (sem o caminho).</li>
 * <li>{@code filePath}: O caminho completo para o arquivo no sistema de arquivos.</li>
 * <li>{@code content}: O conteúdo do arquivo atualmente carregado na memória.</li>
 * </ul>
 *
 * @author XvierDev
 */
public class CurrentFile {

    private String fileName;
    private String filePath;
    private String content;

    public CurrentFile() {
        this.fileName = "";
        this.filePath = "";
        this.content = "";
    }

    public CurrentFile(String fileName, String filePath) {
        this.fileName = Objects.requireNonNull(fileName, "O nome do arquivo não pode ser nulo.");
        this.filePath = Objects.requireNonNull(filePath, "O caminho do arquivo não pode ser nulo.");
        this.content = "";
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = Objects.requireNonNull(fileName, "O nome do arquivo não pode ser nulo.");
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = Objects.requireNonNull(filePath, "O caminho do arquivo não pode ser nulo.");
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content != null ? content : ""; // Garante que content nunca seja nulo
    }

    /**
     * Verifica se o conteúdo fornecido é diferente do conteúdo atual do
     * arquivo.
     *
     * Este método compara o conteúdo atual do arquivo (armazenado internamente)
     * com a String fornecida para verificar se houve alguma alteração.
     *
     * @param content O conteúdo com o qual comparar. Não pode ser nulo.
     * @return {@code true} se o conteúdo fornecido for diferente do conteúdo
     * atual do arquivo, indicando que houve modificações; {@code false} caso
     * contrário.
     * @throws NullPointerException Se o parâmetro {@code content} for
     * {@code null}.
     */
    public boolean hasModifications(String content) throws NullPointerException {
        Objects.requireNonNull(content, "O conteúdo para comparação não pode ser nulo.");
        return !this.content.equals(content);
    }
}
