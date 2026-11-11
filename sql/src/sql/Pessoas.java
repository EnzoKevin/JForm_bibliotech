/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sql;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author sjshz
 */
public class Pessoas extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Pessoas.class.getName());

    private static final String URL = "jdbc:mysql://localhost:3306/bibliotech?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    private void carregarPessoas() {
        DefaultTableModel modelo = new DefaultTableModel(
            new Object[]{"ID", "Nome", "CPF", "Email", "Telefone"}, 0
        );

        String sql = "SELECT id, nome, cpf, email, telefone FROM pessoa";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("email"),
                    rs.getString("telefone")
                });
            }
            jTable1.setModel(modelo);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar pessoas: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Pessoas() {
        initComponents();
        carregarPessoas();
        
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    int linhaSelecionada = jTable1.getSelectedRow();
                    
                    if (linhaSelecionada != -1) {
                        String nome = jTable1.getValueAt(linhaSelecionada, 1).toString();
                        String cpf = jTable1.getValueAt(linhaSelecionada, 2).toString();
                        String email = jTable1.getValueAt(linhaSelecionada, 3).toString();
                        String telefone = jTable1.getValueAt(linhaSelecionada, 4).toString();
                        
                        NomePessoa.setText(nome);
                        CpfPessoa.setText(cpf);
                        EmailPessoa.setText(email);
                        TelefonePessoa.setText(telefone);
                    }
                }
            }
        });
        jTable1.setDefaultEditor(Object.class, null);
    }

    private void limparCamposTexto() {
        NomePessoa.setText("");
        CpfPessoa.setText("");
        EmailPessoa.setText("");
        TelefonePessoa.setText("");
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        NomePessoa = new javax.swing.JTextField();
        CpfPessoa = new javax.swing.JTextField();
        EmailPessoa = new javax.swing.JTextField();
        TelefonePessoa = new javax.swing.JTextField();
        Cadastrar = new javax.swing.JButton();
        Excluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Voltar = new javax.swing.JButton();
        Atualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome:");

        jLabel2.setText("CPF:");

        jLabel3.setText("Email:");

        jLabel4.setText("Telefone:");

        NomePessoa.addActionListener(this::NomePessoaActionPerformed);

        CpfPessoa.addActionListener(this::CpfPessoaActionPerformed);

        EmailPessoa.addActionListener(this::EmailPessoaActionPerformed);

        TelefonePessoa.addActionListener(this::TelefonePessoaActionPerformed);

        Cadastrar.setText("Cadastrar");
        Cadastrar.addActionListener(this::CadastrarActionPerformed);

        Excluir.setText("Excluir");
        Excluir.addActionListener(this::ExcluirActionPerformed);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        Voltar.setText("Voltar");
        Voltar.addActionListener(this::VoltarActionPerformed);

        Atualizar.setText("Atualizar");
        Atualizar.addActionListener(this::AtualizarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(TelefonePessoa))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(EmailPessoa))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(CpfPessoa))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(NomePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Voltar)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Atualizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Cadastrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Excluir)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(NomePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(CpfPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(EmailPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(TelefonePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cadastrar)
                            .addComponent(Excluir))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Atualizar)
                        .addGap(46, 46, 46)
                        .addComponent(Voltar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void NomePessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomePessoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomePessoaActionPerformed

    private void CpfPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CpfPessoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CpfPessoaActionPerformed

    private void EmailPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailPessoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailPessoaActionPerformed

    private void TelefonePessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelefonePessoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TelefonePessoaActionPerformed

    private void CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarActionPerformed
    String nome = NomePessoa.getText().trim();
    String cpf = CpfPessoa.getText().trim();
    String email = EmailPessoa.getText().trim();
    String telefone = TelefonePessoa.getText().trim();

    if (nome.isEmpty() || cpf.isEmpty() || email.isEmpty() || telefone.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String cpfLimpo = cpf.replaceAll("\\D", "");
    if (cpfLimpo.length() != 11) {
        JOptionPane.showMessageDialog(this, "CPF inválido! Certifique-se de que o CPF contém 11 dígitos.", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String sqlVerifica = "SELECT COUNT(*) FROM pessoa WHERE cpf = ?";
    try (Connection conn = conectar(); PreparedStatement stmtVerifica = conn.prepareStatement(sqlVerifica)) {
        stmtVerifica.setString(1, cpf);
        
        try (ResultSet rs = stmtVerifica.executeQuery()) {
            if (rs.next() && rs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(this, "Já existe uma pessoa cadastrada com este CPF!", "Erro Duplicado", JOptionPane.WARNING_MESSAGE);
                return; 
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Erro ao verificar CPF existente: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String sql = "INSERT INTO pessoa (nome, cpf, email, telefone) VALUES (?, ?, ?, ?)";

    try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, nome);
        stmt.setString(2, cpf);
        stmt.setString(3, email);
        stmt.setString(4, telefone);
        
        stmt.executeUpdate();
        JOptionPane.showMessageDialog(this, "Pessoa cadastrada com sucesso!");
        
        limparCamposTexto();
        carregarPessoas();
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Erro ao cadastrar pessoa: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }    }//GEN-LAST:event_CadastrarActionPerformed

    private void ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirActionPerformed
      int linhaSelecionada = jTable1.getSelectedRow();
        
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma pessoa na tabela para excluir!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idPessoa = (int) jTable1.getValueAt(linhaSelecionada, 0);
        String sql = "DELETE FROM pessoa WHERE id = ?";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPessoa);
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Pessoa excluída com sucesso!");
            
            carregarPessoas();
            limparCamposTexto();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao excluir pessoa: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    
    }//GEN-LAST:event_ExcluirActionPerformed

    private void VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarActionPerformed
this.dispose();

Navegação menuPrincipal = new Navegação();
menuPrincipal.setLocationRelativeTo(null);
menuPrincipal.setVisible(true);     }//GEN-LAST:event_VoltarActionPerformed

    private void AtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarActionPerformed
    int linhaSelecionada = jTable1.getSelectedRow();
    
    if (linhaSelecionada == -1) {
        JOptionPane.showMessageDialog(this, "Selecione uma pessoa na tabela para atualizar!", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int idPessoa = (int) jTable1.getValueAt(linhaSelecionada, 0);

    String nome = NomePessoa.getText().trim();
    String cpf = CpfPessoa.getText().trim();
    String email = EmailPessoa.getText().trim();
    String telefone = TelefonePessoa.getText().trim();

    if (nome.isEmpty() || cpf.isEmpty() || email.isEmpty() || telefone.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String sql = "UPDATE pessoa SET nome = ?, cpf = ?, email = ?, telefone = ? WHERE id = ?";

    try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, nome);
        stmt.setString(2, cpf);
        stmt.setString(3, email);
        stmt.setString(4, telefone);
        stmt.setInt(5, idPessoa);
        
        stmt.executeUpdate();
        JOptionPane.showMessageDialog(this, "Dados atualizados com sucesso!");
        
        limparCamposTexto();
        carregarPessoas();
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Erro ao atualizar pessoa: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }    }//GEN-LAST:event_AtualizarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Pessoas().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atualizar;
    private javax.swing.JButton Cadastrar;
    private javax.swing.JTextField CpfPessoa;
    private javax.swing.JTextField EmailPessoa;
    private javax.swing.JButton Excluir;
    private javax.swing.JTextField NomePessoa;
    private javax.swing.JTextField TelefonePessoa;
    private javax.swing.JButton Voltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
