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
        String sql = "INSERT INTO aluno (nome, email, telefone, cpf, endereco) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, alunos.getNome());
            stmt.setString(2, alunos.getEmail());
            stmt.setString(3, alunos.getTelefone());
            stmt.setString(4, alunos.getCpf());
            stmt.setString(5, alunos.getEndereco());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM aluno WHERE id = ?";
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
        String sql = "UPDATE aluno SET nome = ?, email = ?, telefone = ?, cpf = ?, endereco = ? WHERE id = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, alunos.getNome());
            stmt.setString(2, alunos.getCpf());
            stmt.setString(3, alunos.getEmail());
            stmt.setString(4, alunos.getTelefone());
            stmt.setString(5, alunos.getEndereco());
            stmt.setInt(6, alunos.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Alunos> listar() {
        List<Alunos> lista = new ArrayList<>();
        String sql = "SELECT * FROM alunos";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Alunos p = new Alunos();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setCpf(rs.getString("cpf"));
                p.setEmail(rs.getString("email"));
                p.setTelefone(rs.getString("telefone"));
                p.setEndereco(rs.getString("endereço"));
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

