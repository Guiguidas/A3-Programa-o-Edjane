package dao;

import conexao.ConexaoBancoDeDados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.HistoricosAcademicos;

public class HistoricosAcademicosDAO {
    
    private Connection conexao;

    public HistoricosAcademicosDAO() {
         this.conexao = new ConexaoBancoDeDados().getConnection();
    }

    public void adicionar(HistoricosAcademicos historicosAcademicos) {
        String sql = "INSERT INTO sistema_cadastro_alunos (id_aluno, id_curso, data, status) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, historicosAcademicos.getId_aluno());
            stmt.setString(2, historicosAcademicos.getId_curso());
            stmt.setString(3, historicosAcademicos.getData_inicio());
            stmt.setString(4, historicosAcademicos.getData_conclusao());
            stmt.setString(5, historicosAcademicos.getStatus());
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

    public void alterar(HistoricosAcademicos historicosAcademicos) {
        String sql = "UPDATE sistema_cadastro_alunos SET id_aluno = ?, id_curso = ?, data = ?, status = ? WHERE id = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, historicosAcademicos.getId_aluno());
            stmt.setString(2, historicosAcademicos.getId_curso());
            stmt.setString(3, historicosAcademicos.getData_inicio());
            stmt.setString(3, historicosAcademicos.getData_conclusao());
            stmt.setString(5, historicosAcademicos.getStatus());
            stmt.setInt(6, historicosAcademicos.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<HistoricosAcademicos> listar() {
        List<HistoricosAcademicos> lista = new ArrayList<>();
        String sql = "SELECT * FROM sistema_cadastro_alunos";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
               HistoricosAcademicos p = new HistoricosAcademicos();
                p.setId(rs.getInt("id"));
                p.setId_aluno(rs.getString("id_aluno"));
                p.setId_curso(rs.getString("curso"));
                p.setData_inicio(rs.getString("data_inicio"));
                p.setData_conclusao(rs.getString("data_conclusao"));
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
