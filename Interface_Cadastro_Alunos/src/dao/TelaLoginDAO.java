package dao;

import conexao.ConexaoBancoDeDados;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TelaLoginDAO {

       private Connection conexao;

    public TelaLoginDAO() {
         this.conexao = new ConexaoBancoDeDados().getConnection();
    }

    public boolean autenticar(String username, String senha) {
        String sql = "SELECT * FROM usuarios WHERE username = ? AND senha = ?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();
            boolean autenticado = rs.next();
            rs.close();
            stmt.close();

            return autenticado;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
