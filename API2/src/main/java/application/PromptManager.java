package application;

import DaoManager.PromptDAO;
import entities.PromptForm;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PromptManager extends javax.swing.JFrame {

    public PromptManager() {
        initComponents();
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = jTable1.getSelectedRow();
                if (row != -1) {
                    String id = jTable1.getValueAt(row, 0).toString();
                    String description = jTable1.getValueAt(row, 1).toString();
                    String code = jTable1.getValueAt(row, 2).toString();

                    txtIdPrompt.setText(id);
                    txtNewPrompt.setText(code);
                    txtDescriptionPrompt.setText(description);
                }
            }

        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnSavePrompt = new javax.swing.JButton();
        btnDeletePrompt = new javax.swing.JButton();
        bntUpdatePrompt = new javax.swing.JButton();
        btnUpdateTable = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtIdPrompt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDescriptionPrompt = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtNewPrompt = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Prompts Manager");
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(420, 300));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Descrição", "Código"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        btnSavePrompt.setText("Salvar Prompt");
        btnSavePrompt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSavePromptActionPerformed(evt);
            }
        });

        btnDeletePrompt.setText("Deletar Prompt");
        btnDeletePrompt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePromptActionPerformed(evt);
            }
        });

        bntUpdatePrompt.setText("Atualizar Prompt");
        bntUpdatePrompt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntUpdatePromptActionPerformed(evt);
            }
        });

        btnUpdateTable.setText("Atualizar Tabela");
        btnUpdateTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateTableActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        jLabel2.setText("Descrição:");

        jScrollPane3.setViewportView(txtNewPrompt);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSavePrompt, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeletePrompt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntUpdatePrompt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdateTable)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdPrompt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescriptionPrompt, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSavePrompt)
                    .addComponent(btnDeletePrompt)
                    .addComponent(bntUpdatePrompt)
                    .addComponent(btnUpdateTable)
                    .addComponent(jLabel1)
                    .addComponent(txtIdPrompt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescriptionPrompt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Botão Salvar
    private void btnSavePromptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSavePromptActionPerformed
        String description = txtDescriptionPrompt.getText();
        String code = txtNewPrompt.getText();
        if ((txtDescriptionPrompt.getText().isEmpty() || txtNewPrompt.getText().isEmpty())) {
            JOptionPane.showMessageDialog(this, "Nenhum campo pode estar vazio.");
        } else {
            PromptForm prompt = new PromptForm(description, code);
            DaoManager.PromptDAO dao = new DaoManager.PromptDAO();
            dao.salvaPrompt(prompt);
            JOptionPane.showMessageDialog(this, "Prompt Salvo.");
            updateTable();
        }
    }//GEN-LAST:event_btnSavePromptActionPerformed

    //Atualizar Tabel
    private void btnUpdateTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateTableActionPerformed
        updateTable();
    }//GEN-LAST:event_btnUpdateTableActionPerformed

    //Botão Deletar
    private void btnDeletePromptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePromptActionPerformed
        String idText = txtIdPrompt.getText();

        if (idText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum prompt selecionado para deletar.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Tem certeza que deseja deletar este prompt?", "Confirmação",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                int id = Integer.parseInt(idText);
                PromptDAO dao = new PromptDAO();
                dao.deletaPrompt(id);
                JOptionPane.showMessageDialog(this, "Prompt deletado com sucesso.");
                updateTable();

                // Limpa os campos após deletar
                txtIdPrompt.setText("");
                txtNewPrompt.setText("");
                txtDescriptionPrompt.setText("");

                // Atualiza a tabela
//                jButton2ActionPerformed(null);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "ID inválido.");
            }
        }
    }//GEN-LAST:event_btnDeletePromptActionPerformed

    //Botão Atualizar Prompt
    private void bntUpdatePromptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntUpdatePromptActionPerformed
        String idText = txtIdPrompt.getText();           // Pegando o ID
        String description = txtDescriptionPrompt.getText();         // Descrição
        String codigo = txtNewPrompt.getText();             // Código

        if (idText.isEmpty() || description.isEmpty() || codigo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum campo pode estar vazio.");
            return;
        }

        try {
            int id = Integer.parseInt(idText);
            PromptForm prompt = new PromptForm(id, description, codigo);
            PromptDAO dao = new PromptDAO();
            dao.atualizaPrompt(prompt);

            JOptionPane.showMessageDialog(this, "Prompt atualizado com sucesso.");
            updateTable();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID inválido.");
        }
    }//GEN-LAST:event_bntUpdatePromptActionPerformed

    private void updateTable() {
        PromptDAO dao = new PromptDAO();
        List<PromptForm> prompts = dao.listarPrompts();
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Descrição", "Código"}, 0);
        for (PromptForm p : prompts) {
            model.addRow(new Object[]{p.getId(), p.getDescricao(), p.getCodigo()});
        }
        jTable1.setModel(model);
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new PromptManager().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntUpdatePrompt;
    private javax.swing.JButton btnDeletePrompt;
    private javax.swing.JButton btnSavePrompt;
    private javax.swing.JButton btnUpdateTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtDescriptionPrompt;
    private javax.swing.JTextField txtIdPrompt;
    private javax.swing.JTextPane txtNewPrompt;
    // End of variables declaration//GEN-END:variables
}
