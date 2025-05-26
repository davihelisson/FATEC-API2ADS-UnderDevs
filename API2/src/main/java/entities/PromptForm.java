package entities;

/**
 * Representa um formulário de prompt com ID, descrição e código.
 */
public class PromptForm {

    private int id;
    private String descricao;
    private String codigo;

    /**
     * Construtor para PromptForm com ID.
     *
     * @param id O ID do prompt.
     * @param descricao A descrição do prompt.
     * @param codigo O código/conteúdo do prompt.
     */
    public PromptForm(int id, String descricao, String codigo) {
        this.id = id;
        this.descricao = descricao;
        this.codigo = codigo;
    }

    /**
     * Construtor para PromptForm sem ID (para novos prompts).
     *
     * @param descricao A descrição do prompt.
     * @param codigo O código/conteúdo do prompt.
     */
    public PromptForm(String descricao, String codigo) {
        this.descricao = descricao;
        this.codigo = codigo;
    }

    /**
     * Retorna o ID do prompt.
     *
     * @return O ID do prompt.
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna a descrição do prompt.
     *
     * @return A descrição do prompt.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Retorna o código/conteúdo do prompt.
     *
     * @return O código/conteúdo do prompt.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Define o ID do prompt.
     *
     * @param id O novo ID do prompt.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Define a descrição do prompt.
     *
     * @param descricao A nova descrição do prompt.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Define o código/conteúdo do prompt.
     *
     * @param codigo O novo código/conteúdo do prompt.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
