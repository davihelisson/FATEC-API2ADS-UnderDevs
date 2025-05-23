package application;

import entities.CurrentFile;
import entities.OllamaInterface;
import entities.Prompts;
import enums.FileOptions;
import enums.PromptType;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Objects;
import javax.swing.JOptionPane;
import utilities.FileUtils;

/**
 * @author UnderDevs DevTeam
 */
public class MainInterface extends javax.swing.JFrame {

    private CurrentFile currentFile = new CurrentFile();

    public MainInterface() {
        initComponents();
        // Adicionando o WindowListener para lidar com o fechamento da janela principal
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (currentFile.hasModifications(TxtPrompt.getText())) {
                    int resposta = JOptionPane.showConfirmDialog(
                            MainInterface.this,
                            "Deseja salvar as alterações antes de sair?",
                            "Salvar",
                            JOptionPane.YES_NO_CANCEL_OPTION
                    );
                    switch (resposta) {
                        case JOptionPane.YES_OPTION -> {
                            saveFile();
                            if (!currentFile.hasModifications(TxtPrompt.getText())) {
                                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                                dispose();
                            }
                        }
                        case JOptionPane.NO_OPTION -> {
                            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                            dispose();
                        }
                        default -> // Se CANCEL_OPTION, não fazer nada (a janela permanece aberta)
                            setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
                    }
                } else {
                    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                    dispose();
                }
            }
        });

        // Definir o comportamento padrão de fechamento para DO_NOTHING_ON_CLOSE
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        btnRun = new javax.swing.JButton();
        btnCreateTest = new javax.swing.JButton();
        btnImprove = new javax.swing.JButton();
        btnDocumentation = new javax.swing.JButton();
        btnExplanation = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtPrompt = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuNew = new javax.swing.JMenuItem();
        jMenuOpen = new javax.swing.JMenuItem();
        jMenuSave = new javax.swing.JMenuItem();
        jMenuExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuRun = new javax.swing.JMenuItem();
        jMenuCreateTest = new javax.swing.JMenuItem();
        jMenuImproveCode = new javax.swing.JMenuItem();
        jMenuAutoDoc = new javax.swing.JMenuItem();
        jMenuExplanation = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuPromptManager = new javax.swing.JMenuItem();
        jMenuHelp = new javax.swing.JMenu();
        jMenuAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UnderDevs IDE");
        getContentPane().setLayout(new java.awt.GridBagLayout());

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
        btnImprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImproveActionPerformed(evt);
            }
        });
        jPanel1.add(btnImprove);

        btnDocumentation.setText("Documentar");
        btnDocumentation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocumentationActionPerformed(evt);
            }
        });
        jPanel1.add(btnDocumentation);

        btnExplanation.setText("Explique-me");
        btnExplanation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExplanationActionPerformed(evt);
            }
        });
        jPanel1.add(btnExplanation);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jPanel1, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("UNDERDEVS IDE");
        jLabel1.setToolTipText("About UnderDevs IDE.");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        jMenuNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuNew.setText("Novo");
        jMenuNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuNewActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuNew);

        jMenuOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuOpen.setText("Abrir");
        jMenuOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuOpenActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuOpen);

        jMenuSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuSave.setText("Salvar");
        jMenuSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSaveActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuSave);

        jMenuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuExit.setText("Sair");
        jMenuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuExitActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ações");

        jMenuRun.setText("Executar");
        jMenuRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRunActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuRun);

        jMenuCreateTest.setText("Criar teste ...");
        jMenuCreateTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCreateTestActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuCreateTest);

        jMenuImproveCode.setText("Melhorar ...");
        jMenuImproveCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuImproveCodeActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuImproveCode);

        jMenuAutoDoc.setText("Documentar");
        jMenuAutoDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAutoDocActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuAutoDoc);

        jMenuExplanation.setText("Explique-me ...");
        jMenuExplanation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuExplanationActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuExplanation);
        jMenu2.add(jSeparator1);

        jMenuPromptManager.setText("Gerenciar Prompts");
        jMenuPromptManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPromptManagerActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuPromptManager);

        jMenuBar1.add(jMenu2);

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

    private void jMenuNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuNewActionPerformed
        if (currentFile.hasModifications(TxtPrompt.getText())) {
            int answer = JOptionPane.showConfirmDialog(null, "Salvar alterações?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (answer != JOptionPane.YES_OPTION) {
                newFile();
            } else {
                saveFile();
                if (!currentFile.hasModifications(TxtPrompt.getText())) {
                    newFile();
                }
            }
        }
        newFile();
    }//GEN-LAST:event_jMenuNewActionPerformed

    private void btnImproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImproveActionPerformed
        btnImprove.setEnabled(false);
        btnCreateTest.setEnabled(false);
        runOllama(PromptType.IMPROVEMENT, TxtPrompt.getText());
    }//GEN-LAST:event_btnImproveActionPerformed

    private void jMenuRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRunActionPerformed
        runCode();
    }//GEN-LAST:event_jMenuRunActionPerformed

    private void jMenuCreateTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCreateTestActionPerformed
        btnImprove.setEnabled(false);
        btnCreateTest.setEnabled(false);
        runOllama(PromptType.UNITTEST, TxtPrompt.getText());
    }//GEN-LAST:event_jMenuCreateTestActionPerformed

    private void jMenuImproveCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuImproveCodeActionPerformed
        btnImprove.setEnabled(false);
        btnCreateTest.setEnabled(false);
        runOllama(PromptType.IMPROVEMENT, TxtPrompt.getText());
    }//GEN-LAST:event_jMenuImproveCodeActionPerformed

    private void jMenuAutoDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAutoDocActionPerformed
        runOllama(PromptType.DOCUMENTATION, TxtPrompt.getText());
    }//GEN-LAST:event_jMenuAutoDocActionPerformed

    private void jMenuExplanationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuExplanationActionPerformed
        runOllama(PromptType.EXPLANATION, TxtPrompt.getText());
    }//GEN-LAST:event_jMenuExplanationActionPerformed

    private void jMenuPromptManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPromptManagerActionPerformed
        PromptManager pm = new PromptManager();
        pm.setVisible(true);
    }//GEN-LAST:event_jMenuPromptManagerActionPerformed

    private void btnExplanationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExplanationActionPerformed
        runOllama(PromptType.EXPLANATION, TxtPrompt.getText());
    }//GEN-LAST:event_btnExplanationActionPerformed

    private void btnDocumentationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocumentationActionPerformed
        runOllama(PromptType.DOCUMENTATION, TxtPrompt.getText());
    }//GEN-LAST:event_btnDocumentationActionPerformed

    private void newFile() {
        currentFile = new CurrentFile();
        this.setTitle("UnderDevs IDE");
        TxtPrompt.setText("");
    }

    /**
     * Método privado para abertura de arquivos Python
     */
    private void openFile() {

        CurrentFile fileToOpen = FileUtils.openFile();
        if (fileToOpen != null) {
            currentFile = fileToOpen;
            this.setTitle("UnderDevs IDE - " + currentFile.getFileName());
            TxtPrompt.setText(currentFile.getContent());
        }
    }

    /**
     * Método privado para salvamento dos arquivos Python
     */
    private void saveFile() {
        boolean saveFile = FileUtils.saveFile(currentFile, TxtPrompt.getText(), FileOptions.SOURCE);
        if (saveFile) {
            this.setTitle("UnderDevs IDE - " + currentFile.getFileName());
            JOptionPane.showMessageDialog(this, currentFile.getFileName() + " salvo com sucesso!", "Salvo",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Método privado para enviar os dados para Ollama
     *
     * @return reponse
     */
    private void runOllama(PromptType promptType, String sourceCode) {
        Prompts prompt = new Prompts(sourceCode);
        OllamaInterface ollamaInterface = new OllamaInterface();

        try {
            String promptWithCode = null;
            String title = "";
            if (null != promptType) {
                switch (promptType) {
                    case UNITTEST -> {
                        promptWithCode = prompt.getPromptFromDb(0);
                        System.out.println(promptWithCode);
                        if (!"".equals(currentFile.getFileName())) {
                            promptWithCode = promptWithCode.replace("my_module", currentFile.getFileName().replace(".py", ""));
                            title = "Teste Unitário";
                        }
                    }
                    case IMPROVEMENT -> {
                        promptWithCode = prompt.improveCode();
                        title = "Sugestão de melhoria";
                    }
                    case EXPLANATION -> {
                        promptWithCode = prompt.explanationCode();
                        title = "Explicação do código";
                    }
                    case DOCUMENTATION -> {
                        promptWithCode = prompt.documentCode();
                        title = "Documentação do código";
                    }
                    default -> {
                        // TODO: Implement alternative here.
                    }
                }
            }

            Objects.requireNonNull(promptWithCode, "O código fonte não pode ser nulo");
            String result = ollamaInterface.GenerateTest(promptWithCode);

            if (!result.isEmpty()) {
                if (promptType == promptType.EXPLANATION) {
                    OutputUI ou = new OutputUI(title, result);
                    ou.setVisible(true);
                } else {
                    OutputTest telaSaida = new OutputTest(new CurrentFile(), FileOptions.SOURCE, title);
                    telaSaida.setContent(result);
                    telaSaida.setTitle("Output " + currentFile.getFileName());
                    telaSaida.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(java.awt.event.WindowEvent e) {
                            btnCreateTest.setEnabled(true);
                            btnImprove.setEnabled(true);
                        }

                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            telaSaida.dispose();
                        }

                    });
                    telaSaida.setVisible(true);
                }

            }

        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null,
                    "Erro: " + ex.getMessage(),
                    "Erro de parâmetros",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Erro: " + ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            btnImprove.setEnabled(true);
            btnCreateTest.setEnabled(true);
        }
    }

    /**
     * Método privado para executar o código escrito em Python
     */
    private void runCode() {
        if (!currentFile.hasModifications(TxtPrompt.getText())
                && !"".equals(currentFile.getFileName())
                && !"".equals(currentFile.getFilePath())) {
            String pythonOutput = FileUtils.runPython(new File(currentFile.getFilePath(), currentFile.getFileName()).toString()).toString();
            OutputUI outUI = new OutputUI("Resultados", pythonOutput);
            outUI.setVisible(true);
        } else if (!TxtPrompt.getText().equals("")) {
            int aswer = JOptionPane.showConfirmDialog(
                    null,
                    "Salvar mudanças no arquivo?",
                    "Salvar mudanças?",
                    JOptionPane.YES_NO_OPTION
            );

            if (aswer == JOptionPane.YES_OPTION) {
                saveFile();
                if (!currentFile.hasModifications(TxtPrompt.getText())) {
                    runCode();
                }
            }
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
        btnImprove.setEnabled(false);
        btnCreateTest.setEnabled(false);
        runOllama(PromptType.UNITTEST, TxtPrompt.getText());
    }

    // Main menu options
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel1MouseClicked
        About about = new About();
        about.setVisible(true);
    }

    private void jMenuOpenActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuOpenActionPerformed
        openFile();
    }

    private void jMenuSaveActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuSaveActionPerformed
        saveFile();
    }

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
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainInterface().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane TxtPrompt;
    private javax.swing.JButton btnCreateTest;
    private javax.swing.JButton btnDocumentation;
    private javax.swing.JButton btnExplanation;
    private javax.swing.JButton btnImprove;
    private javax.swing.JButton btnRun;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuAbout;
    private javax.swing.JMenuItem jMenuAutoDoc;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuCreateTest;
    private javax.swing.JMenuItem jMenuExit;
    private javax.swing.JMenuItem jMenuExplanation;
    private javax.swing.JMenu jMenuHelp;
    private javax.swing.JMenuItem jMenuImproveCode;
    private javax.swing.JMenuItem jMenuNew;
    private javax.swing.JMenuItem jMenuOpen;
    private javax.swing.JMenuItem jMenuPromptManager;
    private javax.swing.JMenuItem jMenuRun;
    private javax.swing.JMenuItem jMenuSave;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
