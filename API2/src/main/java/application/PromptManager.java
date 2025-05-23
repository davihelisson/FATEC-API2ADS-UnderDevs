package application;

import DaoManager.PromptDao;
import entities.PromptForm;
import enums.PromptType;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PromptManager extends javax.swing.JFrame {

    public PromptManager() {
        initComponents();
        updateTable();
        promptTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = promptTable.getSelectedRow();
                if (row != -1) {
                    String id = promptTable.getValueAt(row, 0).toString();
                    String description = promptTable.getValueAt(row, 1).toString();
                    String code = promptTable.getValueAt(row, 2).toString();

                    txtIdPrompt.setText(id);
                    txtNewPrompt.setText(code);
                    cbxDescription.setActionCommand(description);
                }
            }

        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        promptScrollTable = new javax.swing.JScrollPane();
        promptTable = new javax.swing.JTable();
        btnNew = new javax.swing.JButton();
        btnSavePrompt = new javax.swing.JButton();
        btnDeletePrompt = new javax.swing.JButton();
        bntUpdatePrompt = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();
        txtIdPrompt = new javax.swing.JTextField();
        lblDescription = new javax.swing.JLabel();
        promptScroll = new javax.swing.JScrollPane();
        txtNewPrompt = new javax.swing.JTextPane();
        cbxDescription = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Prompts Manager");
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(420, 300));

        promptTable.setModel(new javax.swing.table.DefaultTableModel(
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
        promptScrollTable.setViewportView(promptTable);

        btnNew.setText("Novo Prompt");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

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

        lblId.setText("ID:");

        lblDescription.setText("Categoria:");

        promptScroll.setViewportView(txtNewPrompt);

        cbxDescription.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Teste unitário", "Melhoria de código", "Documentação de código", "Explicação de código" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(promptScrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(promptScroll))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNew)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSavePrompt, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeletePrompt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntUpdatePrompt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdPrompt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDescription)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                    .addComponent(lblId)
                    .addComponent(txtIdPrompt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescription)
                    .addComponent(btnNew)
                    .addComponent(cbxDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(promptScrollTable, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                    .addComponent(promptScroll))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Botão Salvar
    private void btnSavePromptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSavePromptActionPerformed
        String description = PromptType.getByCodigo(cbxDescription.getSelectedIndex()).toString();
        String code = txtNewPrompt.getText();
        if ((txtNewPrompt.getText().isEmpty())) {
            JOptionPane.showMessageDialog(this, "Nenhum campo pode estar vazio.");
        } else {
            PromptForm prompt = new PromptForm(description, code);
            DaoManager.PromptDao dao = new DaoManager.PromptDao();
            dao.salvaPrompt(prompt);
            JOptionPane.showMessageDialog(this, "Prompt Salvo.");
            updateTable();
        }
    }//GEN-LAST:event_btnSavePromptActionPerformed

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
                PromptDao dao = new PromptDao();
                dao.deletaPrompt(id);
                JOptionPane.showMessageDialog(this, "Prompt deletado com sucesso.");
                updateTable();

                // Limpa os campos após deletar
                txtIdPrompt.setText("");
                txtNewPrompt.setText("");
                cbxDescription.setActionCommand("");

                // Atualiza a tabela
//                jButton2ActionPerformed(null);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "ID inválido.");
            }
        }
    }//GEN-LAST:event_btnDeletePromptActionPerformed

    //Botão Atualizar Prompt
    private void bntUpdatePromptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntUpdatePromptActionPerformed
        String idText = txtIdPrompt.getText();
        String description = PromptType.getByCodigo(cbxDescription.getSelectedIndex()).toString();
        String codigo = txtNewPrompt.getText();

        if (idText.isEmpty() || description.isEmpty() || codigo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum campo pode estar vazio.");
            return;
        }

        try {
            int id = Integer.parseInt(idText);
            PromptForm prompt = new PromptForm(id, description, codigo);
            PromptDao dao = new PromptDao();
            dao.atualizaPrompt(prompt);

            JOptionPane.showMessageDialog(this, "Prompt atualizado com sucesso.");
            updateTable();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID inválido.");
        }
    }//GEN-LAST:event_bntUpdatePromptActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        txtIdPrompt.setText("");
        txtNewPrompt.setText("");
    }//GEN-LAST:event_btnNewActionPerformed

    private void updateTable() {
        PromptDao dao = new PromptDao();
        List<PromptForm> prompts = dao.listarPrompts();
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Descrição", "Código"}, 0);
        for (PromptForm p : prompts) {
            model.addRow(new Object[]{p.getId(), p.getDescricao(), p.getCodigo()});
        }
        promptTable.setModel(model);
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new PromptManager().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntUpdatePrompt;
    private javax.swing.JButton btnDeletePrompt;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSavePrompt;
    private javax.swing.JComboBox<String> cbxDescription;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblId;
    private javax.swing.JScrollPane promptScroll;
    private javax.swing.JScrollPane promptScrollTable;
    private javax.swing.JTable promptTable;
    private javax.swing.JTextField txtIdPrompt;
    private javax.swing.JTextPane txtNewPrompt;
    // End of variables declaration//GEN-END:variables
}
