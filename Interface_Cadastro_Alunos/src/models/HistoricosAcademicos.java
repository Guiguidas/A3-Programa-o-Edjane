package models;

public class HistoricosAcademicos {
    
    private int id;  // <-- Adicionado
    private String id_aluno;
    private String id_curso;
    private String data_inicio;
    private String data_conclusao;
    private String status;

    // Getter e Setter para ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Demais getters e setters
    public String getId_aluno() {
        return id_aluno;
    }
    
    public void setId_aluno(String id_aluno) {
        this.id_aluno = id_aluno;
    }
    
    public String getId_curso() {
        return id_curso;
    }
    
    public void setId_curso(String id_curso) {
        this.id_curso = id_curso;
    }
    
    public String getData_inicio() {
        return data_inicio;
    }
    
    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }
    
    public String getData_conclusao() {
        return data_conclusao;
    }
    
    public void setData_conclusao(String data_conclusao) {
        this.data_conclusao = data_conclusao;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
