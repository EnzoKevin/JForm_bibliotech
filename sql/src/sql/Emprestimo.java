/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package sql;

import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.WindowConstants;

/**
 *
 * @author sjshz
 */
public class Emprestimo extends javax.swing.JPanel {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Emprestimo.class.getName());

    // Configuração da Base de Dados
    private static final String URL = "jdbc:mysql://localhost:3306/bibliotech";
    private static final String USER = "root"; // ou o teu utilizador do postgres
    private static final String PASSWORD = ""; // a tua password do postgres

    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    
    /**
     * Creates new form Emprestimo
     */
    public Emprestimo() {
        initComponents();
        carregarEmprestimos();
        carregarLivrosNoComboBox();
        
         jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    int linhaSelecionada = jTable1.getSelectedRow();
                    
                    if (linhaSelecionada != -1) {
                       String nomeLeitor = jTable1.getValueAt(linhaSelecionada, 1).toString();
                    String dataEmp = jTable1.getValueAt(linhaSelecionada, 2).toString();
                    String dataDev = jTable1.getValueAt(linhaSelecionada, 3).toString();
                    String livroNome = jTable1.getValueAt(linhaSelecionada, 4).toString();
                    
                    CpfField.setText(nomeLeitor);
                    EmprestimoData.setText(dataEmp);
                    DevolucaoData.setText(dataDev);
                    
                    Livro.setSelectedItem(livroNome);
                    }
                }
            }
        });
        jTable1.setDefaultEditor(Object.class, null);
    }

    private void carregarEmprestimos() {
       DefaultTableModel modelo = new DefaultTableModel(
        new Object[]{"ID", "Nome Leitor", "Data Empréstimo", "Data Devolução", "Livro"}, 0
    );

    String sql = "SELECT id, leitor_cpf, dataEmprestimo, dataDevolucao, livro FROM emprestimo";

    try (Connection conn = conectar();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            modelo.addRow(new Object[]{
                rs.getInt("id"),
                rs.getString("leitor_cpf"),
                rs.getString("dataEmprestimo"),
                rs.getString("dataDevolucao"),
                rs.getString("livro") 
            });
        }
        jTable1.setModel(modelo);

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Erro ao carregar empréstimos: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
    }
    
    private void carregarLivrosNoComboBox() {
       DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<>();
        String sql = "SELECT titulo FROM livro";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                comboModel.addElement(rs.getString("titulo"));
            }
            Livro.setModel(comboModel);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar livros para a lista: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para procurar o nome da pessoa através do CPF digitado
    private String buscarNomePorCpf(String cpf) {
        String nomePessoa = null;
        String sql = "SELECT nome FROM pessoa WHERE cpf = ?";
        
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    nomePessoa = rs.getString("nome");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao consultar CPF: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return nomePessoa;
    }
   
    
    private void limparCampos() {
        CpfField.setText("");
        EmprestimoData.setText("");
        DevolucaoData.setText("");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        CpfField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        EmprestimoData = new javax.swing.JTextField();
        DevolucaoData = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Livro = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        BtnSalvar = new javax.swing.JButton();
        BtnExcluir = new javax.swing.JButton();
        Voltar = new javax.swing.JButton();
        Atualizar = new javax.swing.JButton();
        Limpar = new javax.swing.JButton();

        jLabel1.setText("CPF:");

        CpfField.addActionListener(this::CpfFieldActionPerformed);

        jLabel2.setText("Data de emprestimo:");

        jLabel3.setText("Data de devolução:");

        EmprestimoData.addActionListener(this::EmprestimoDataActionPerformed);

        DevolucaoData.addActionListener(this::DevolucaoDataActionPerformed);

        jLabel4.setText("Livros:");

        Livro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Livro.addActionListener(this::LivroActionPerformed);

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

        BtnSalvar.setText("Salvar");
        BtnSalvar.addActionListener(this::BtnSalvarActionPerformed);

        BtnExcluir.setText("Excluir");
        BtnExcluir.addActionListener(this::BtnExcluirActionPerformed);

        Voltar.setText("Voltar");
        Voltar.addActionListener(this::VoltarActionPerformed);

        Atualizar.setText("Atualizar");
        Atualizar.addActionListener(this::AtualizarActionPerformed);

        Limpar.setText("Limpar");
        Limpar.addActionListener(this::LimparActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Voltar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(EmprestimoData, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(CpfField, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Livro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BtnSalvar)
                                    .addComponent(Atualizar))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Limpar)
                                    .addComponent(BtnExcluir))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(DevolucaoData, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(CpfField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(EmprestimoData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(DevolucaoData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Livro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnSalvar)
                            .addComponent(BtnExcluir))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Atualizar)
                            .addComponent(Limpar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(Voltar)
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CpfFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CpfFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CpfFieldActionPerformed

    private void EmprestimoDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmprestimoDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmprestimoDataActionPerformed

    private void DevolucaoDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DevolucaoDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DevolucaoDataActionPerformed

    private void LivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LivroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LivroActionPerformed

    private void BtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalvarActionPerformed
String cpf = CpfField.getText().trim();
    String dataEmp = EmprestimoData.getText().trim();
    String dataDev = DevolucaoData.getText().trim();
    String livroSelecionado = (String) Livro.getSelectedItem();

    if (cpf.isEmpty() || dataEmp.isEmpty() || dataDev.isEmpty() || livroSelecionado == null) {
        JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios!", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String nomePessoa = buscarNomePorCpf(cpf);

    if (nomePessoa == null) {
        JOptionPane.showMessageDialog(this, "O CPF informado não pertence a nenhuma pessoa cadastrada!", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String sql = "INSERT INTO emprestimo (leitor_cpf, dataEmprestimo, dataDevolucao, livro) VALUES (?, ?, ?, ?)";

    try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, nomePessoa); 
        stmt.setString(2, dataEmp);
        stmt.setString(3, dataDev);
        stmt.setString(4, livroSelecionado); 
        
        stmt.executeUpdate();
        JOptionPane.showMessageDialog(this, "Empréstimo registado com sucesso para: " + nomePessoa);
        
        limparCampos();
        carregarEmprestimos();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Erro ao salvar empréstimo: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }    }//GEN-LAST:event_BtnSalvarActionPerformed

    private void BtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExcluirActionPerformed
        int linhaSelecionada = jTable1.getSelectedRow();
        
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um empréstimo na tabela para excluir!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idEmprestimo = (int) jTable1.getValueAt(linhaSelecionada, 0);
        String sql = "DELETE FROM emprestimo WHERE id = ?";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idEmprestimo);
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Empréstimo excluído com sucesso!");
            carregarEmprestimos();
            limparCampos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao excluir empréstimo: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }    }//GEN-LAST:event_BtnExcluirActionPerformed

    private void VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarActionPerformed
java.awt.Window janelaAtual = javax.swing.SwingUtilities.getWindowAncestor(this);
        
        if (janelaAtual != null) {
            janelaAtual.dispose(); 
        }
    Navegação menuPrincipal = new Navegação();
    menuPrincipal.setLocationRelativeTo(null);
    menuPrincipal.setVisible(true);
    menuPrincipal.setVisible(true);    }//GEN-LAST:event_VoltarActionPerformed

    private void AtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarActionPerformed
int linhaSelecionada = jTable1.getSelectedRow();
    
    if (linhaSelecionada == -1) {
        JOptionPane.showMessageDialog(this, "Selecione um empréstimo na tabela para atualizar!", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int idEmprestimo = (int) jTable1.getValueAt(linhaSelecionada, 0);
    
    String cpf = CpfField.getText().trim();
    String dataEmp = EmprestimoData.getText().trim();
    String dataDev = DevolucaoData.getText().trim();
    String livroSelecionado = (String) Livro.getSelectedItem();

    if (cpf.isEmpty() || dataEmp.isEmpty() || dataDev.isEmpty() || livroSelecionado == null) {
        JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios!", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String nomePessoa = buscarNomePorCpf(cpf);
    if (nomePessoa == null) {
        JOptionPane.showMessageDialog(this, "O CPF informado não pertence a nenhuma pessoa cadastrada!", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String sql = "UPDATE emprestimo SET leitor_cpf = ?, dataEmprestimo = ?, dataDevolucao = ?, livro = ? WHERE id = ?";

    try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, nomePessoa);
        stmt.setString(2, dataEmp);
        stmt.setString(3, dataDev);
        stmt.setString(4, livroSelecionado); 
        stmt.setInt(5, idEmprestimo);
        
        stmt.executeUpdate();
        JOptionPane.showMessageDialog(this, "Empréstimo atualizado com sucesso!");
        
        limparCampos();
        carregarEmprestimos();
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Erro ao atualizar empréstimo: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }    }//GEN-LAST:event_AtualizarActionPerformed

    private void LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_LimparActionPerformed

    
    public static void main(String args[]) {
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

        java.awt.EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame("Gestão de Empréstimos");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new Emprestimo());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atualizar;
    private javax.swing.JButton BtnExcluir;
    private javax.swing.JButton BtnSalvar;
    private javax.swing.JTextField CpfField;
    private javax.swing.JTextField DevolucaoData;
    private javax.swing.JTextField EmprestimoData;
    private javax.swing.JButton Limpar;
    private javax.swing.JComboBox<String> Livro;
    private javax.swing.JButton Voltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
