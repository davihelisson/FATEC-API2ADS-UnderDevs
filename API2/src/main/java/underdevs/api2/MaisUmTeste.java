package underdevs.api2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.models.response.OllamaResult;
import io.github.ollama4j.types.OllamaModelType;
import io.github.ollama4j.utils.OptionsBuilder;
import io.github.ollama4j.utils.PromptBuilder;

public class MaisUmTeste extends JFrame {
    private JTextArea codeInput;
    private JTextArea testOutput;
    private JButton generateButton;

    public MaisUmTeste() {
        setTitle("Test Generator");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Área de entrada do código
        codeInput = new JTextArea(10, 50);
        codeInput.setBorder(BorderFactory.createTitledBorder("Enter Python Function"));
        add(new JScrollPane(codeInput), BorderLayout.CENTER);

        // Botão para gerar os testes
        generateButton = new JButton("Generate Test");
        generateButton.addActionListener(new GenerateTestListener());
        add(generateButton, BorderLayout.SOUTH);

        // Área de saída dos valores de teste
        testOutput = new JTextArea(5, 50);
        testOutput.setEditable(false);
        testOutput.setBorder(BorderFactory.createTitledBorder("Generated Test Cases"));
        add(new JScrollPane(testOutput), BorderLayout.NORTH);
    }

    private class GenerateTestListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userCode = codeInput.getText().trim();
            if (userCode.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a Python function!");
                return;
            }

            // Configurando o Ollama API
            String host = "http://localhost:11434/";
            OllamaAPI ollamaAPI = new OllamaAPI(host);
            ollamaAPI.setRequestTimeoutSeconds(120);
            String model = OllamaModelType.PHI3;

            // Criando o Prompt
            PromptBuilder promptBuilder = new PromptBuilder()
                    .addLine("You are an expert in unit test generation and software quality assurance.")
                    .addLine("Your task is to generate valid test values for a given Python function.")
                    .addLine("The function will be provided below, and you must analyze its parameters and return type.")
                    .addLine("Ensure that the test values match the expected input type of the function parameters.")
                    .addLine("For example:")
                    .addLine("- If the function expects integers, use only valid integers (no floats, strings, or special characters).")
                    .addLine("- If the function expects positive numbers, do not include negative values.")
                    .addLine("- If the function expects a list, ensure the test values are properly formatted as a list.")
                    .addLine("Make sure that the generated test values do not cause the function to fail.")
                    .addLine("Generate test cases that cover different valid scenarios while keeping them logically valid.")
                    .addLine("Format your response as follows:")
                    .addLine("\"\"\" Valores para teste: val1, val2; val3, val4; val5, val6 \"\"\"")
                    .addSeparator()
                    .addLine("Python function:")
                    .add(userCode);

            try {
                // Enviando o prompt para o modelo
                OllamaResult response = ollamaAPI.generate(model, promptBuilder.build(), false, new OptionsBuilder().build());

                // Exibindo a resposta na área de saída
                testOutput.setText(response.getResponse());

            } catch (Exception ex) {
                testOutput.setText("Error generating test cases: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MaisUmTeste().setVisible(true));
    }
}



