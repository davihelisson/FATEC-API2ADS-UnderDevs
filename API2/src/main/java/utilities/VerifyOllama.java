package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class VerifyOllama {

    public static boolean isOllamaInstalled(String nomeModelo) throws IOException, InterruptedException {
        Process process = null;
        try {
            // Verifica se o modelo já está instalado
            process = new ProcessBuilder("ollama", "list").start();
            boolean finished = process.waitFor(2, TimeUnit.SECONDS);
            if (!finished) {
                process.destroyForcibly();
                return false;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.toLowerCase().startsWith(nomeModelo.toLowerCase() + " ")) {
                    return true;
                }
            }

            // Se chegou aqui, o modelo não está instalado — tenta baixar
            System.out.println("Modelo '" + nomeModelo + "' não encontrado. Tentando baixar...");

            Process pullProcess = new ProcessBuilder("ollama", "pull", nomeModelo)
                    .inheritIO() // mostra o progresso no console
                    .start();

            boolean pullFinished = pullProcess.waitFor(5, TimeUnit.MINUTES); // tempo maior pra baixar o modelo
            if (!pullFinished) {
                pullProcess.destroyForcibly();
                System.out.println("Timeout ao tentar baixar o modelo.");
                return false;
            }

            return pullProcess.exitValue() == 0;

        } finally {
            if (process != null && process.isAlive()) {
                process.destroyForcibly();
            }
        }
    }
}
