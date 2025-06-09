package models;

/**
 *
 * @author Guilherme
 */
public class Alunos {
    //declarar os atributos
    public int id;
    public String nome;
    public String email;
    public String cpf;
    public String telefone; 
    public String endereço;
    
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
    
 
