package entities;

import DaoManager.PromptDao;

/**
 * A classe `Prompts` é responsável por gerar diferentes tipos de prompts de
 * texto para interagir com um modelo de linguagem, utilizando um código de
 * usuário como base. Os prompts são carregados de arquivos de texto
 * predefinidos e podem ser usados para gerar testes de unidade, melhorar o
 * código, documentar o código ou explicar o código.
 */
public class Prompts {

    private final String userCode;

    /**
     * Construtor da classe `Prompts`.
     *
     * @param userCode O código do usuário a ser utilizado na geração dos
     * prompts.
     */
    public Prompts(String userCode) {
        this.userCode = userCode;
    }

    /**
     * Gera um prompt para criação de testes de unidade para o código do
     * usuário. O prompt é carregado do arquivo "PromptUnitTest.txt".
     *
     * @return Uma String contendo o prompt para geração de testes de unidade.
     * @throws Exception Se ocorrer um erro ao carregar o prompt do arquivo.
     */
    public String generateCode() throws Exception {
        return LoadPrompts.loadPrompt("PromptUnitTest.txt", userCode);
    }

    /**
     * Gera um prompt para melhoria do código do usuário. O prompt é carregado
     * do arquivo "PromptImprovement.txt".
     *
     * @return Uma String contendo o prompt para melhoria do código.
     * @throws Exception Se ocorrer um erro ao carregar o prompt do arquivo.
     */
    public String improveCode() throws Exception {
        return LoadPrompts.loadPrompt("PromptImprovement.txt", userCode);
    }

    /**
     * Gera um prompt para documentação do código do usuário. O prompt é
     * carregado do arquivo "PromptDocumentation.txt".
     *
     * @return Uma String contendo o prompt para documentação do código.
     * @throws Exception Se ocorrer um erro ao carregar o prompt do arquivo.
     */
    public String documentCode() throws Exception {
        return LoadPrompts.loadPrompt("PromptDocumentation.txt", userCode);
    }

    /**
     * Gera um prompt para explicação do código do usuário. O prompt é carregado
     * do arquivo "PromptExplanation.txt".
     *
     * @return Uma String contendo o prompt para explicação do código.
     * @throws Exception Se ocorrer um erro ao carregar o prompt do arquivo.
     */
    public String explanationCode() throws Exception {
        return LoadPrompts.loadPrompt("PromptExplanation.txt", userCode);
    }

    public String getPromptFromDb(int type) {
        PromptDao pd = new PromptDao();
        String result = pd.getPrompt(type);
        return (new StringBuilder().append(result).append("\ntarget code\n").append(userCode).toString());
    }
}
