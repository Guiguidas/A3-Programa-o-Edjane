package models;

public class Cursos {
    //declarar os atributos
    public int id;
    public String nome;
    public String categoria;
    public String duracao;
    public String status; 
    
    // Getter e Setter para ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    // Demais getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public String getDuracao() {
        return duracao;
    }
   
    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
