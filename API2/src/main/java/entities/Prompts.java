package entities;

import daoManager.PromptDao;

/**
 * Gerencia prompts para interação com modelos de linguagem.
 */
public class Prompts {

    private final String userCode;

    /**
     * Construtor para Prompts.
     *
     * @param userCode O código do usuário a ser incluído nos prompts.
     */
    public Prompts(String userCode) {
        this.userCode = userCode;
    }

    /**
     * Recupera um prompt predefinido do banco de dados e o combina com o código
     * do usuário.
     *
     * @param type O tipo/ID do prompt a ser recuperado.
     * @return O prompt completo formatado com o código do usuário.
     */
    public String getPromptFromDb(int type) {
        PromptDao pd = new PromptDao();
        String result = pd.getPrompt(type);
        return (new StringBuilder().append(result).append(userCode).toString());
    }
}
