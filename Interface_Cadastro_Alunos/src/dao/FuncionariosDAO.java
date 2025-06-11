package dao;

import conexao.ConexaoBancoDeDados;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Funcionarios;


public class FuncionariosDAO {
    
    private Connection conexao;

    public FuncionariosDAO() {
         this.conexao = new ConexaoBancoDeDados().getConnection();
    }

    public void adicionar(Funcionarios funcionarios) {
        String sql = "INSERT INTO sistema_cadastro_alunos (nome, cargo, login, senha, disciplina) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, funcionarios.getNome());
            stmt.setString(2, funcionarios.getCargo());
            stmt.setString(3, funcionarios.getLogin());
            stmt.setString(4, funcionarios.getSenha());
            stmt.setString(5, funcionarios.getData_cadastro());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM sistema_cadastro_alunos WHERE id = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterar(Funcionarios funcionarios) {
        String sql = "UPDATE sistema_cadastro_alunos SET nome = ?, cargo = ?, login = ?, senha = ?, disciplina = ? WHERE id = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, funcionarios.getNome());
            stmt.setString(2, funcionarios.getCargo());
            stmt.setString(3, funcionarios.getLogin());
            stmt.setString(4, funcionarios.getSenha());
            stmt.setString(5, funcionarios.getData_cadastro());
            stmt.setInt(6, funcionarios.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Funcionarios> listar() {
        List<Funcionarios> lista = new ArrayList<>();
        String sql = "SELECT * FROM sistema_cadastro_alunos";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionarios p = new Funcionarios();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setCargo(rs.getString("cargo"));
                p.setLogin(rs.getString("login"));
                p.setSenha(rs.getString("senha"));
                p.setData_cadastro(rs.getString("data_cadastro"));
                lista.add(p);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean autenticar(String login, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
