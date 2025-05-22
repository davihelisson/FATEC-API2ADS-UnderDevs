package application;

import DAO.PromptDAO;
import PromptForm.PromptForm;
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
                    String descricao = jTable1.getValueAt(row, 1).toString();
                    String codigo = jTable1.getValueAt(row, 2).toString();

                    jTextField1.setText(descricao);  // Descrição
                    jTextPane1.setText(codigo);      // Código
                    jTextField2.setText(id);        // ID oculto
                }
            }
            
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

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

        jButton5.setText("Salvar Prompt");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Deletar Prompt");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton1.setText("Atualizar Prompt");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Atualizar Tabela");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        jTextField1.setEnabled(false);

        jLabel2.setText("Descrição:");

        jScrollPane3.setViewportView(jTextPane1);

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
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String descricao = jTextField1.getText();
        String codigo = jTextPane1.getText();
        
        if ((jTextField1.getText().isEmpty() || jTextPane1.getText().isEmpty())){
            JOptionPane.showMessageDialog(null, "Nenhum campo pode estar vazio.");
        }
        else{
            PromptForm prompt = new PromptForm(descricao, codigo);
            DAO.PromptDAO dao = new DAO.PromptDAO();
            dao.salvaPrompt(prompt);
            JOptionPane.showMessageDialog(null, "Prompt Salvo.");
            jButton2ActionPerformed(null);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    //Atualizar Tabel
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PromptDAO dao = new PromptDAO();
        List<PromptForm> prompts = dao.listarPrompts();
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Descrição", "Código"}, 0);
        for (PromptForm p : prompts) {
            model.addRow(new Object[]{p.getId(), p.getDescricao(), p.getCodigo()});
        }
        jTable1.setModel(model);
    }//GEN-LAST:event_jButton2ActionPerformed

    //Botão Deletar
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String idText = jTextField2.getText();

        if (idText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum prompt selecionado para deletar.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null,
            "Tem certeza que deseja deletar este prompt?", "Confirmação",
            JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                int id = Integer.parseInt(idText);
                PromptDAO dao = new PromptDAO();
                dao.deletaPrompt(id);
                JOptionPane.showMessageDialog(null, "Prompt deletado com sucesso.");

                // Limpa os campos após deletar
                jTextField1.setText("");
                jTextPane1.setText("");
                jTextField2.setText("");

                // Atualiza a tabela
                jButton2ActionPerformed(null);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ID inválido.");
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    //Botão Atualizar Prompt
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String idText = jTextField2.getText();           // Pegando o ID
        String descricao = jTextField1.getText();         // Descrição
        String codigo = jTextPane1.getText();             // Código

        if (idText.isEmpty() || descricao.isEmpty() || codigo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum campo pode estar vazio.");
            return;
        }

        try {
            int id = Integer.parseInt(idText);
            PromptForm prompt = new PromptForm(id, descricao, codigo);
            PromptDAO dao = new PromptDAO();
            dao.atualizaPrompt(prompt);

            JOptionPane.showMessageDialog(null, "Prompt atualizado com sucesso.");
            jButton2ActionPerformed(null); // Recarrega a tabela
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PromptManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
