/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package application;

import entities.CurrentFile;
import java.io.IOException;
import javax.swing.JOptionPane;
import utilities.Util;

/**
 *
 * @author UnderDevs Team
 */
public class TelaSaidaTeste extends javax.swing.JFrame {

    private CurrentFile currentFile;

    /**
     * Creates new form TelaSaidaTeste
     *
     * @param currentFile
     */
    public TelaSaidaTeste(CurrentFile currentFile) {
        initComponents();
        this.currentFile = currentFile;
        this.setVisible(true);
    }

    public void setContent(String content) {
        this.currentFile.content = content;
        this.jTextPane1.setText(content);
    }

    public void setFileName(String fileName) {
        this.currentFile.setFileName(fileName);
        this.setTitle(this.getTitle() + " " + fileName);
    }

    public void setFilePath(String filePath) {
        this.currentFile.setFilePath(filePath);
    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnRun = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Teste");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Teste Unitário");
        jPanel1.add(jLabel1);

        btnRun.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRun.setText("Executar");
        btnRun.setToolTipText("");
        btnRun.setMargin(new java.awt.Insets(3, 14, 3, 14));
        btnRun.setMaximumSize(new java.awt.Dimension(77, 32));
        btnRun.setMinimumSize(new java.awt.Dimension(77, 32));
        btnRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRunActionPerformed(evt);
            }
        });
        jPanel1.add(btnRun);

        btnSalvar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setMargin(new java.awt.Insets(3, 14, 3, 14));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalvar);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jPanel1, gridBagConstraints);

        jTextPane1.setName(""); // NOI18N
        jScrollPane1.setViewportView(jTextPane1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 372;
        gridBagConstraints.ipady = 232;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 6, 6, 6);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRunActionPerformed
        try {
            if (currentFile.hasModifications(jTextPane1.getText()) || !currentFile.isSaved()) {
                if (Util.saveFile(currentFile)) {
                    Util.runPython(currentFile.getFileName());
                }
            } else {
                Util.runPython(jTextPane1.getText());
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
    }//GEN-LAST:event_btnRunActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSalvarActionPerformed
        currentFile.content = jTextPane1.getText();
        if (Util.saveFile(currentFile)) {
            this.setTitle("Saved " + currentFile.getFileName().replace(".py", ""));
        }
    }// GEN-LAST:event_btnSalvarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
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
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRun;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
