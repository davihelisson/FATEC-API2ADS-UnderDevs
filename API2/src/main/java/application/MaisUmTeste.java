package application;

// import das classes para criar obter o prompts e enviar ao Ollama
import entities.Prompts;
import entities.OllamaInterface;

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

public class MaisUmTeste extends JFrame {
    private final JTextArea codeInput;
    private final JTextArea testOutput;
    private final JButton generateButton;

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
            
            Prompts prompt = new Prompts(userCode);
            OllamaInterface ollamaInterface = new OllamaInterface();

            try {
                // Enviando o prompt para o modelo
                String promptWithCode = prompt.generateCode(userCode);
                String response = ollamaInterface.GenerateTest(promptWithCode);

                // Exibindo a resposta na área de saída
                testOutput.setText(response);

            } catch (Exception ex) {
                testOutput.setText("Error generating test cases: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MaisUmTeste().setVisible(true));
    }
}



