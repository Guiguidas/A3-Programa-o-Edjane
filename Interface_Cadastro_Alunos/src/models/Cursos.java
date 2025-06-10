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
  
    public String getCategoria() {
        return categoria;
    }
    
     public String getDuracao() {
        return duracao;
    }
   
      public String getStatus() {
        return status;
    }
}
