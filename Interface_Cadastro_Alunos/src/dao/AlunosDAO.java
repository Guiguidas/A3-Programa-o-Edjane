package dao;
import conexao.ConexaoBancoDeDados;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Funcionarios;

public class AlunosDAO {

    private Connection conexao;

    public AlunosDAO() {
         this.conexao = new ConexaoBancoDeDados().getConnection();
    }

    public void adicionar(Funcionarios professor) {
        String sql = "INSERT INTO cadastro_prof (nome, email, data, salario, disciplina) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.setString(3, professor.getData_nascimento());
            stmt.setString(4, professor.getSalario());
            stmt.setString(5, professor.getDisciplina());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM cadastro_prof WHERE id = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterar(Funcionarios professor) {
        String sql = "UPDATE cadastro_prof SET nome = ?, email = ?, data = ?, salario = ?, disciplina = ? WHERE id = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.setString(3, professor.getData_nascimento());
            stmt.setString(4, professor.getSalario());
            stmt.setString(5, professor.getDisciplina());
            stmt.setInt(6, professor.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Funcionarios> listar() {
        List<Funcionarios> lista = new ArrayList<>();
        String sql = "SELECT * FROM cadastro_prof";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionarios p = new Funcionarios();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setEmail(rs.getString("email"));
                p.setData_nascimento(rs.getString("data"));
                p.setSalario(rs.getString("salario"));
                p.setDisciplina(rs.getString("disciplina"));
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

