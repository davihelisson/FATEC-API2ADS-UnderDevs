package application;

import entities.CurrentFile;
import entities.OllamaInterface;
import entities.Prompts;
import java.awt.event.WindowAdapter;
import java.io.IOException;
import javax.swing.JOptionPane;
import utilities.Util;

/**
 * @author UnderDevs DevTeam
 */
public class ApiInterface extends javax.swing.JFrame {

    private CurrentFile currentFile = new CurrentFile(null, null, false);

    public ApiInterface() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuOpen = new javax.swing.JMenuItem();
        jMenuSave = new javax.swing.JMenuItem();
        jMenuExit = new javax.swing.JMenuItem();
        jMenuHelp = new javax.swing.JMenu();
        jMenuAbout = new javax.swing.JMenuItem();

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

        jMenu1.setText("Arquivo");

        jMenuOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O,
                java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuOpen.setText("Abrir");
        jMenuOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuOpenActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuOpen);

        jMenuSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S,
                java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuSave.setText("Salvar");
        jMenuSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSaveActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuSave);

        jMenuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q,
                java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuExit.setText("Sair");
        jMenuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuExitActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuExit);

        jMenuBar1.add(jMenu1);

        jMenuHelp.setText("Ajuda");

        jMenuAbout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuAbout.setText("Sobre");
        jMenuAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAboutActionPerformed(evt);
            }
        });
        jMenuHelp.add(jMenuAbout);

        jMenuBar1.add(jMenuHelp);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método privado para abertura de arquivos Python
     */
    private void openFile() {
        try {
            currentFile = Util.openFile();
            setTitle(currentFile.getFileName() == null ? currentFile.getFileName() : "Untitled.py");
            TxtPrompt.setText(currentFile.content);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao abrir o arquivo: " + ex.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método privado para salvamento dos arquivos Python
     */
    private void saveFile() {
        currentFile.content = TxtPrompt.getText();
        Util.saveFile(currentFile, currentFile.getFileName().endsWith(".py") ? 0 : 1);
    }

    /**
     * Método privado para enviar os dados para Ollama
     *
     * @return reponse
     */
    private String runOllama() {
        Prompts prompt = new Prompts(TxtPrompt.getText());
        OllamaInterface ollamaInterface = new OllamaInterface();

        try {
            String promptWithCode = prompt.generateCode();
            if (currentFile.getFileName() != null && !currentFile.getFileName().isEmpty()) {
                promptWithCode = promptWithCode.replace("my_module", currentFile.getFileName());
            }
            String response = ollamaInterface.GenerateTest(promptWithCode);
            return response;

        } catch (Exception ex) {
            return "Error generating test cases: " + ex.getMessage();
        }
    }

    /**
     * Método privado para executar o código escrito em Python
     */
    private void runCode() {
        try {
            if (!currentFile.hasModifications(TxtPrompt.getText()) || currentFile.isSaved()) {
                String pythonOutput = Util.runPython(currentFile.getFullPath()).toString();
                TelaSaidaTeste tst = new TelaSaidaTeste(new CurrentFile(null, currentFile.getFilePath(), false), 1);
                tst.setContent(pythonOutput);
            } else {
                int aswer = JOptionPane.showConfirmDialog(
                        null,
                        "Salvar mudanças no arquivo?",
                        "Salvar mudanças?",
                        JOptionPane.YES_NO_OPTION
                );

                if (aswer == JOptionPane.YES_OPTION) {
                    saveFile();
                    runCode();
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao verificar o Python: " + ex.getMessage(),
                    "Erro de I/O",
                    JOptionPane.ERROR_MESSAGE);
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null,
                    "Operação interrompida ao verificar o Python",
                    "Operação Interrompida",
                    JOptionPane.WARNING_MESSAGE);
            Thread.currentThread().interrupt(); // Restaura o flag de interrupção
        }
    }

    // Eventos dos botões da interface do usuário.    
    private void btnRunActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnRunActionPerformed
        runCode();
    }// GEN-LAST:event_btnRunActionPerformed

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAbrirActionPerformed
        openFile();
    }// GEN-LAST:event_btnAbrirActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        saveFile();
    }

    private void btnCreateTestActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSalvar2ActionPerformed
        btnCreateTest.setEnabled(false);
        String testOutput = runOllama();

        TelaSaidaTeste telaSaida = new TelaSaidaTeste(new CurrentFile(null, null, false), 0);
        telaSaida.setContent(testOutput);
        telaSaida.setTitle("Unit Test - " + currentFile.getFileName());
        telaSaida.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                btnCreateTest.setEnabled(true);
            }

            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                telaSaida.dispose();
            }

        });
        telaSaida.setVisible(true);
    }// GEN-LAST:event_btnSalvar2ActionPerformed

    // Main menu options
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel1MouseClicked
        About about = new About();
        about.setVisible(true);
    }// GEN-LAST:event_jLabel1MouseClicked

    private void jMenuOpenActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuOpenActionPerformed
        openFile();
    }// GEN-LAST:event_jMenuOpenActionPerformed

    private void jMenuSaveActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuSaveActionPerformed
        saveFile();
    }// GEN-LAST:event_jMenuSaveActionPerformed

    private void jMenuExitActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuExitActionPerformed
        System.exit(0);
    }// GEN-LAST:event_jMenuExitActionPerformed

    private void jMenuAboutActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuAboutActionPerformed
        About about = new About();
        about.setVisible(true);
    }// GEN-LAST:event_jMenuAboutActionPerformed

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
            java.util.logging.Logger.getLogger(ApiInterface.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuAbout;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuExit;
    private javax.swing.JMenu jMenuHelp;
    private javax.swing.JMenuItem jMenuOpen;
    private javax.swing.JMenuItem jMenuSave;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
