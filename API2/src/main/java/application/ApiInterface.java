package application;

import entities.OllamaInterface;
import entities.Prompts;
import java.awt.event.WindowAdapter;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

/**
 * @author UnderDevs DevTeam
 */
public class ApiInterface extends javax.swing.JFrame {

    private String nomeArquivoAberto;
    private String diretorioSelecionado;

    public ApiInterface() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        btnOpen = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnRun = new javax.swing.JButton();
        btnCreateTest = new javax.swing.JButton();
        btnImprove = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtPrompt = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UnderDevs IDE");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        btnOpen.setText("Abrir");
        btnOpen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOpen.setMinimumSize(new java.awt.Dimension(80, 23));
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });
        jPanel1.add(btnOpen);

        btnSave.setText("Salvar");
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSave.setMinimumSize(new java.awt.Dimension(80, 23));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave);

        btnRun.setText("Executar");
        btnRun.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRun.setMinimumSize(new java.awt.Dimension(80, 23));
        btnRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRunActionPerformed(evt);
            }
        });
        jPanel1.add(btnRun);

        btnCreateTest.setText("Criar Teste");
        btnCreateTest.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCreateTest.setMinimumSize(new java.awt.Dimension(80, 23));
        btnCreateTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateTestActionPerformed(evt);
            }
        });
        jPanel1.add(btnCreateTest);

        btnImprove.setText("Melhorar");
        btnImprove.setMinimumSize(new java.awt.Dimension(80, 23));
        jPanel1.add(btnImprove);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jPanel1, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("UNDERDEVS IDE");
        jLabel1.setToolTipText("About UnderDevs IDE.");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.setIconTextGap(1);
        jLabel1.setName(""); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        getContentPane().add(jLabel1, gridBagConstraints);

        TxtPrompt.setBorder(null);
        TxtPrompt.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(TxtPrompt);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 744;
        gridBagConstraints.ipady = 424;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRunActionPerformed

    /**
     * Método que realiza a abertura do arquivo python.
     */
    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivos Python (*.py)", "py"));
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            diretorioSelecionado = file.getParent();
            String completeFileName = file.getName();
            nomeArquivoAberto = file.getName().replace(".py", "");

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                StringBuilder conteudo = new StringBuilder();
                String linha;
                while ((linha = reader.readLine()) != null) {
                    conteudo.append(linha).append('\n');
                }
                TxtPrompt.setText(conteudo.toString());
                setTitle("Editor de Código - " + completeFileName);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao abrir o arquivo: " + ex.getMessage(), "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    /**
     * Método que salva o arquivo python aberto no editor.
     */
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser fileChooser = new JFileChooser();

        if (diretorioSelecionado != null) {
            fileChooser.setCurrentDirectory(new File(diretorioSelecionado));
        }

        if (nomeArquivoAberto != null && !nomeArquivoAberto.isEmpty()) {
            fileChooser.setSelectedFile(new File(diretorioSelecionado, nomeArquivoAberto + ".py"));
        }

        fileChooser.setDialogTitle("Salvar Arquivo");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Python Files", "py"));

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            if (!fileToSave.getAbsolutePath().endsWith(".py")) {
                fileToSave = new File(fileToSave.getAbsolutePath() + ".py");
            }

            if (fileToSave.exists()) {
                int resposta = JOptionPane.showConfirmDialog(null, "O arquivo já existe. Deseja sobrescrever?",
                        "Confirmação", JOptionPane.YES_NO_OPTION);
                if (resposta != JOptionPane.YES_OPTION) {
                    return;
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))) {
                writer.write(TxtPrompt.getText());
                JOptionPane.showMessageDialog(null, "Arquivo salvo com sucesso!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar o arquivo.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }                                          

    /**
     * Método que executa a funcionalidade de gerar testes unitários no arquivo
     * Python.
     */
    private void btnCreateTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvar2ActionPerformed
        btnCreateTest.setEnabled(false);
        Prompts prompt = new Prompts(TxtPrompt.getText());
        OllamaInterface ollamaInterface = new OllamaInterface();
        String testOutput;

        try {
            String promptWithCode = prompt.generateCode();
            if (nomeArquivoAberto != null && !nomeArquivoAberto.isEmpty()) {
                promptWithCode = promptWithCode.replace("my_module", nomeArquivoAberto);
            }
            String response = ollamaInterface.GenerateTest(promptWithCode);
            testOutput = response;

        } catch (Exception ex) {
            testOutput = "Error generating test cases: " + ex.getMessage();
        }
        TelaSaidaTeste telaSaida = new TelaSaidaTeste(diretorioSelecionado, nomeArquivoAberto);
        telaSaida.setContent(testOutput);
        telaSaida.addWindowListener(new WindowAdapter(){
        @Override
        public void windowClosed(java.awt.event.WindowEvent e){
            btnCreateTest.setEnabled(true);
        }
        
        @Override
        public void windowClosing(java.awt.event.WindowEvent e){
            telaSaida.dispose();
        }
        
        
        });
        telaSaida.setVisible(true);
    }//GEN-LAST:event_btnSalvar2ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        About about = new About();
        about.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            boolean windowsFound = false;
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    windowsFound = true;
                    break;
                }
            }
            if (!windowsFound) {
                javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApiInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ApiInterface().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane TxtPrompt;
    private javax.swing.JButton btnCreateTest;
    private javax.swing.JButton btnImprove;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnRun;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}