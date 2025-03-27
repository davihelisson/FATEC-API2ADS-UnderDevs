package entities;

/* Classe exclusivamente para testes, desativar após funcinamento pleno */
public class RunTest {
    public static void main (String[] args){
        try{
            OllamaInterface olm = new OllamaInterface();
            String result = olm.GenerateTest("crie um teste unitário em python para o código", "def soma (a, b): return a + b?");
            System.out.println(result);
        }
        catch (Exception e){
            System.out.println("Deu erro.");
        }
    }
}
