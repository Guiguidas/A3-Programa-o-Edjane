package models;

public class Notas {
    
    private int id;  // <-- Adicionado
    private String id_aluno;
    private String id_curso;
    private String valor;
    private String data_lancamento;
   
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
    
    public String getValor() {
        return valor;
    }
    
    public void setValor(String valor) {
        this.valor = valor;
    }
    
    public String getData_lancamento() {
        return data_lancamento;
    }

    public void setData_lancamento(String data_lancamento) {
        this.data_lancamento = data_lancamento;
    }
     
}
