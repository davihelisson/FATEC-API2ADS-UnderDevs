package application;

import entities.CurrentFile;
import entities.OllamaInterface;
import entities.Prompts;
import java.awt.event.WindowAdapter;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import enums.FileOptions;
import enums.PromptType;
import java.awt.event.WindowEvent;
import java.util.Objects;
import utilities.FileUtils;
import utilities.VerifyOllama;

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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtPrompt = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuNew = new javax.swing.JMenuItem();
        jMenuOpen = new javax.swing.JMenuItem();
        jMenuSave = new javax.swing.JMenuItem();
        jMenuExit = new javax.swing.JMenuItem();
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
        try {
            if (VerifyOllama.isOllamaInstalled("qwen2.5-coder")) {
                btnImprove.setEnabled(false);
                btnCreateTest.setEnabled(false);
                runOllama(PromptType.IMPROVEMENT, TxtPrompt.getText());
            }
        }  catch (IOException e) {
            System.out.println("Erro ao verificar Ollama: " + e.getMessage());;
            JOptionPane.showMessageDialog(null,
                    "Ollama não está instalado ou contém um erro.",
                    "Erro ao verificar Ollama",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (InterruptedException e){
            System.out.println("Outro erro: " + e.getMessage());
            JOptionPane.showMessageDialog(null,
                    "Erro ao verificar Ollama",
                    "Operação Interrompida: " + e.getMessage(),
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnImproveActionPerformed

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
            if (promptType == PromptType.UNITTEST) {
                promptWithCode = prompt.generateCode();
                if (!"".equals(currentFile.getFileName())) {
                    promptWithCode = promptWithCode.replace("my_module", currentFile.getFileName());
                    title = "Teste Unitário";
                }
            } else if (promptType == PromptType.IMPROVEMENT) {
                promptWithCode = prompt.improveCode();
                title = "Sugestão de melhoria";
            }
            Objects.requireNonNull(promptWithCode, "O código fonte não pode ser nulo");
            String result = ollamaInterface.GenerateTest(promptWithCode);

            TelaSaidaTeste telaSaida = new TelaSaidaTeste(new CurrentFile(), FileOptions.SOURCE, title);
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
        try {
            if (!currentFile.hasModifications(TxtPrompt.getText())
                    && !"".equals(currentFile.getFileName())
                    && !"".equals(currentFile.getFilePath())) {
                String pythonOutput = FileUtils.runPython(new File(currentFile.getFilePath(), currentFile.getFileName()).toString()).toString();
                OutputUI outUI = new OutputUI(pythonOutput);
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
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null,
                    "Nenhum arquivo a ser executado.",
                    "Arquivo inexistente",
                    JOptionPane.INFORMATION_MESSAGE);
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
        try {
            if (VerifyOllama.isOllamaInstalled("qwen2.5-coder")) {
                btnImprove.setEnabled(false);
                btnCreateTest.setEnabled(false);
                runOllama(PromptType.UNITTEST, TxtPrompt.getText());
            }
        } catch (IOException e) {
            System.out.println("Erro ao verificar Ollama: " + e.getMessage());
            JOptionPane.showMessageDialog(null,
                    "Ollama não está instalado ou contém um erro.",
                    "Erro ao verificar Ollama",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (InterruptedException e){
            System.out.println("Outro erro: " + e.getMessage());
            JOptionPane.showMessageDialog(null,
                    "Erro ao verificar Ollama",
                    "Operação Interrompida: " + e.getMessage(),
                    JOptionPane.WARNING_MESSAGE);
        }
            

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
    private javax.swing.JButton btnImprove;
    private javax.swing.JButton btnRun;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuAbout;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuExit;
    private javax.swing.JMenu jMenuHelp;
    private javax.swing.JMenuItem jMenuNew;
    private javax.swing.JMenuItem jMenuOpen;
    private javax.swing.JMenuItem jMenuSave;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
