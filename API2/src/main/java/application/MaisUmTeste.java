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
            String model = "qwen2.5-coder";

            // Criando o Prompt
            PromptBuilder promptBuilder = new PromptBuilder()
                .addLine("You are an expert in unit testing and software quality assurance.")
                .addLine("Your task is to generate a complete Python unit test script for a given function.")
                .addLine("The function will be provided below, and you must analyze its parameters and return type.")
                .addLine("Ensure that the generated test cases cover multiple valid scenarios.")
                .addLine("Your response must be a valid Python script using the 'unittest' module.")
                .addLine("Strictly follow these guidelines:")
                .addLine("- DO NOT include any comments in the generated code.")
                .addLine("- Use 'unittest.TestCase' to structure the test class.")
                .addLine("- Define multiple test methods to verify different valid inputs.")
                .addLine("- If the function expects integers, use only valid integers (no floats, strings, or special characters).")
                .addLine("- If the function expects positive numbers, do not include negative values.")
                .addLine("- If the function expects a list, ensure the test values are properly formatted as a list.")
                .addLine("- Ensure that the generated test cases do not cause the function to fail.")
                .addLine("- The function should be imported in the test script to allow execution.")
                .addLine("- Include a 'if __name__ == \"__main__\"' block to allow running the tests.")
                .addSeparator()
                .addLine("import unittest")
                .addLine("from my_module import function_name")
                .addLine("")
                .addLine("class TestFunction(unittest.TestCase):")
                .addLine("")
                .addLine("    def test_case_1(self):")
                .addLine("        self.assertEqual(function_name(val1, val2), expected_output)")
                .addLine("")
                .addLine("    def test_case_2(self):")
                .addLine("        self.assertEqual(function_name(val3, val4), expected_output)")
                .addLine("")
                .addLine("    def test_case_3(self):")
                .addLine("        self.assertEqual(function_name(val5, val6), expected_output)")
                .addLine("")
                .addLine("if __name__ == \"__main__\":")
                .addLine("    unittest.main()")
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



