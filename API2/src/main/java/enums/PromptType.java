package enums;

public enum PromptType {
    UNITTEST(0),
    IMPROVEMENT(1),
    DOCUMENTATION(2),
    EXPLANATION(3);
    
    private final int code;

    // Construtor do enum
    PromptType(int code) {
        this.code = code;
    }

    // Getter para o código
    public int getCode() {
        return code;
    }

    // Método estático para encontrar o enum pelo código
    public static PromptType getByCodigo(int code) {
        for (PromptType status : values()) {
            if (status.code == code) {
                return status;
            }
        }
        // Lançar uma exceção ou retornar null se o código não for encontrado
        throw new IllegalArgumentException("Invalid PromptCode: " + code);
    }
    
}
