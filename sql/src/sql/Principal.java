/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

/**
 *
 * @author sjshz
 */
public class Principal {

    public static void main(String[] args) {
        // Configura o visual do sistema para o padrão Nimbus (mais moderno)
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        // Inicializa e abre a janela de Navegação principal que liga todos os módulos
        java.awt.EventQueue.invokeLater(() -> {
            Navegação menuPrincipal = new Navegação();
            menuPrincipal.setLocationRelativeTo(null); // Centraliza a janela no ecrã
            menuPrincipal.setVisible(true);
        });
    }
}