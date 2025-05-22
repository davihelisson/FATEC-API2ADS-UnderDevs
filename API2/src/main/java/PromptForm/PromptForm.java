package PromptForm;

public class PromptForm {
    private int id;
    private String descricao;
    private String codigo;

    // Construtor com ID
    public PromptForm(int id, String descricao, String codigo) {
        this.id = id;
        this.descricao = descricao;
        this.codigo = codigo;
    }

    // Construtor sem ID
    public PromptForm(String descricao, String codigo) {
        this.descricao = descricao;
        this.codigo = codigo;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}



