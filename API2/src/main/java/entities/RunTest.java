package entities;

public class RunTest {
    public static void main (String[] args){
        try{
            OllamaInterface olm = new OllamaInterface();
            String result = olm.GenerateTest("diga", "olá");
            System.out.println(result);
        }
        catch (Exception e){
            System.out.println("Deu erro.");
        }
    }
}
