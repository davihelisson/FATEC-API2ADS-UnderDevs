package entities;

public class Prompts {

    private final String userCode;

    public Prompts(String userCode) {
        this.userCode = userCode;
    }

    public String generateCode() throws Exception {
        return LoadPrompts.loadPrompt("PromptUnitTest.txt", userCode);
    }

    public String improveCode() throws Exception {
        return LoadPrompts.loadPrompt("PromptImprovement.txt", userCode);
    }
}
