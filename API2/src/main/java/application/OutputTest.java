package application;

import entities.CurrentFile;
import java.io.File;
import enums.FileOptions;
import javax.swing.JFrame;
import utilities.FileUtils;

/**
 *
 * @author UnderDevs Team
 */
public class OutputTest extends javax.swing.JDialog {

    private final CurrentFile currentFile;
    private final FileOptions options;
    private final JFrame owner;

    /**
     * Creates new form TelaSaidaTeste
     *
     * @param owner
     * @param currentFile
     * @param options
     * @param title
     */
    public OutputTest(JFrame owner, CurrentFile currentFile, FileOptions options, String title) {
        super(owner, title, true);
        initComponents();
        this.currentFile = currentFile;
        this.options = options;
//        this.setVisible(true);
        this.setTitle(title);
        this.owner = owner;
    }

    public void setContent(String content) {
        this.jTextPane1.setText(content);
    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        btnRun = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Teste");
        getContentPane().setLayout(new java.awt.GridBagLayout());

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
        if (currentFile.hasModifications(jTextPane1.getText())) {
            if (FileUtils.saveFile(currentFile, jTextPane1.getText(), options)) {
                File fileToRun = new File(currentFile.getFilePath(), currentFile.getFileName());
                String runOut = FileUtils.runPython(fileToRun.getAbsolutePath()).toString();
                OutputUI out = new OutputUI(owner, "Resultados", runOut);
                out.setVisible(true);
            }
        } else {
            FileUtils.runPython(new File(currentFile.getFilePath(), currentFile.getFileName()).getAbsolutePath());
        }
    }//GEN-LAST:event_btnRunActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSalvarActionPerformed
        if (FileUtils.saveFile(currentFile, jTextPane1.getText(), options)) {
            this.setTitle("Saved " + currentFile.getFileName().replace(".py", ""));
        }
    }// GEN-LAST:event_btnSalvarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRun;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
