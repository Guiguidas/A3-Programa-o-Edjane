package dao;
import conexao.ConexaoBancoDeDados;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Alunos;

public class AlunosDAO {

    private Connection conexao;

    public AlunosDAO() {
         this.conexao = new ConexaoBancoDeDados().getConnection();
    }

    public void adicionar(Alunos alunos) {
        String sql = "INSERT INTO b'cadastro_alunos' (nome, email, data, salario, disciplina) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, alunos.getNome());
            stmt.setString(2, alunos.getEmail());
            stmt.setString(3, alunos.getTelefone());
            stmt.setString(4, alunos.getCpf());
            stmt.setString(5, alunos.getEndereço());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM b'cadastro_alunos' WHERE id = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterar(Alunos alunos) {
        String sql = "UPDATE cadastro_prof SET nome = ?, email = ?, data = ?, salario = ?, disciplina = ? WHERE id = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, alunos.getNome());
            stmt.setString(2, alunos.getEmail());
            stmt.setString(3, alunos.getTelefone());
            stmt.setString(4, alunos.getCpf());
            stmt.setString(5, alunos.getEndereço());
            stmt.setInt(6, alunos.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Alunos> listar() {
        List<Alunos> lista = new ArrayList<>();
        String sql = "SELECT * FROM cadastro_prof";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Alunos p = new Alunos();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setEmail(rs.getString("email"));
                p.setTelefone(rs.getString("data"));
                p.setCpf(rs.getString("salario"));
                p.setEndereco(rs.getString("disciplina"));
                lista.add(p);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}

