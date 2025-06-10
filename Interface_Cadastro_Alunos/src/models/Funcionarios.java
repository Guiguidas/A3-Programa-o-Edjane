package models;

public class Funcionarios {

    private int id;  // <-- Adicionado
    private String nome;
    private String cargo;
    private String login;
    private String senha;
    private String disciplina;

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
    
    public String getCargo() {
        return cargo;
    }
    
    public String getLogin() {
        return login;
    }   
    
    public String getSenha() {
        return senha;
    }    
    
    public String getDisciplina() {
        return disciplina;
    }    
}
