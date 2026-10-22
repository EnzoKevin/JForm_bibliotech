/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author aluno
 */
public class conexao {
    
    public Connection getConexao() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?useTimezone=true&serverTimezone=UTC","root", "");
            System.out.print("conexão realizada com sucesso");
            return conn;
        }
        catch (SQLException e) {
            System.out.print("Erro ao conectar no BD" + e.getMessage());
            return null;
        }
    }
}
