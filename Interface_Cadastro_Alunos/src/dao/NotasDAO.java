package dao;

import conexao.ConexaoBancoDeDados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Notas;

public class NotasDAO {
    private Connection conexao;

    public NotasDAO() {
         this.conexao = new ConexaoBancoDeDados().getConnection();
    }

    public void adicionar(Notas notas) {
        String sql = "INSERT INTO sistema_cadastro_alunos (id_aluno, id_curso, nota, data_lancamento) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, notas.getId_aluno());
            stmt.setString(2, notas.getId_curso());
            stmt.setString(3, notas.getValor());
            stmt.setString(4, notas.getData_lancamento());
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

    public void alterar(Notas notas) {
        String sql = "UPDATE sistema_cadastro_alunos SET id_aluno = ?, id_curso = ?, nota = ?, data_lancamento = ? WHERE id = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, notas.getId_aluno());
            stmt.setString(2, notas.getId_curso());
            stmt.setString(3, notas.getValor());
            stmt.setString(4, notas.getData_lancamento());
            stmt.setInt(5, notas.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Notas> listar() {
        List<Notas> lista = new ArrayList<>();
        String sql = "SELECT * FROM sistema_cadastro_alunos";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Notas p = new Notas();
                p.setId(rs.getInt("id"));
                p.setId_aluno(rs.getString("id_aluno"));
                p.setId_curso(rs.getString("id_curso"));
                p.setValor(rs.getString("valor"));
                p.setData_lancamento(rs.getString("data_lancamento"));
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
