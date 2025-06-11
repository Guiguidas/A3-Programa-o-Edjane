package dao;

import conexao.ConexaoBancoDeDados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Cursos;

public class CursosDAO {
    private Connection conexao;

    public CursosDAO() {
         this.conexao = new ConexaoBancoDeDados().getConnection();
    }

    public void adicionar(Cursos cursos) {
        String sql = "INSERT INTO curso (nome, categoria, duracao, status) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cursos.getNome());
            stmt.setString(2, cursos.getCategoria());
            stmt.setString(3, cursos.getDuracao());
            stmt.setString(4, cursos.getStatus());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM curso WHERE id = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterar(Cursos cursos) {
        String sql = "UPDATE curso SET nome = ?, categoria = ?, duracao = ?, status = ? WHERE id = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cursos.getNome());
            stmt.setString(2, cursos.getCategoria());
            stmt.setString(3, cursos.getDuracao());
            stmt.setString(4, cursos.getStatus());
            stmt.setInt(5, cursos.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cursos> listar() {
        List<Cursos> lista = new ArrayList<>();
        String sql = "SELECT * FROM curso";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cursos p = new Cursos();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setCategoria(rs.getString("categoria"));
                p.setDuracao(rs.getString("duração"));
                p.setStatus(rs.getString("status"));
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
