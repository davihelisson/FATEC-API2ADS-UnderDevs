/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package underdevs.api2;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
// CÓDIGO RESPONSÁVEL PELO FUNCIONAMENTO DO OLLAMA: PRECISA IMPLEMENTAR
import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.models.response.OllamaResult;
import io.github.ollama4j.utils.OptionsBuilder;
*/

/*
// Parte responsável pela abertura de arquivos no modo terminal
// Talvez isso não seja necessário
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
*/



/**
 *
 * @author Fatec
 */
public class ApiInterface extends javax.swing.JFrame {

    /**
     * Creates new form ApiInterface
     */
    public ApiInterface() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        TxtPrompt = new javax.swing.JTextPane();
        btnAbrir = new javax.swing.JButton();
        btnSalvar2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSalvar3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Arial Narrow", 0, 10)); // NOI18N
        setForeground(new java.awt.Color(102, 102, 102));
        setIconImages(null);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        TxtPrompt.setBorder(null);
        TxtPrompt.setCaretColor(new java.awt.Color(255, 255, 255));
        TxtPrompt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(TxtPrompt);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 744;
        gridBagConstraints.ipady = 424;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        getContentPane().add(btnAbrir, gridBagConstraints);

        btnSalvar2.setText("Run");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 0, 0);
        getContentPane().add(btnSalvar2, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("UNDERDEVS IDE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 348, 0, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        btnSalvar3.setText("Salvar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 0, 0);
        getContentPane().add(btnSalvar3, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        // Ação de clicar no botão para abrir arquivos.
        JFileChooser fileChooser = new JFileChooser();
                
                // Definir o filtro para arquivos .py
                fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Arquivos Python (*.py)", "py"));
                Component frame = null;
                
                // Mostrar o diálogo de abertura de arquivo
                int returnValue = fileChooser.showOpenDialog(frame);
                
                // Se o usuário selecionar um arquivo
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    // Exibir o caminho do arquivo selecionado
                    // JOptionPane.showMessageDialog(frame, "Foi selecionado o arquivo: " + file.getAbsolutePath());
                    
                    // Aqui você pode abrir e ler o arquivo, por exemplo:
                    BufferedReader reader = null;
                    try {
                        reader = new BufferedReader(new FileReader(file));
                        String linha;
                        StringBuilder conteudo = new StringBuilder();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(ApiInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }   
                    String linha;
                    StringBuilder conteudo = new StringBuilder();
                    try {
                        while ((linha = reader.readLine()) != null) {
                            conteudo.append(linha).append("\n");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(ApiInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        reader.close();
                        TxtPrompt.setText(conteudo.toString());
                    } catch (IOException ex) {
                        Logger.getLogger(ApiInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    // Exibir o conteúdo do arquivo em um JTextArea
                    JTextArea textArea = new JTextArea(conteudo.toString());
                    textArea.setEditable(true);
                    JScrollPane scrollPane = new JScrollPane(textArea);
                    JFrame contentFrame = new JFrame("Conteúdo do Arquivo");
                    contentFrame.setSize(600, 400);
                    contentFrame.add(scrollPane);
                    contentFrame.setVisible(false);
                }
    }//GEN-LAST:event_btnAbrirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        JFrame frame = new JFrame("Abrir Arquivo");
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ApiInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApiInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApiInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApiInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApiInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane TxtPrompt;
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnSalvar2;
    private javax.swing.JButton btnSalvar3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
