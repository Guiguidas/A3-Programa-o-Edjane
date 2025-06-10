/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Guilherme
 */
public class Notas {
    
    private int id;  // <-- Adicionado
    private String id_aluno;
    private String curso;
    private String nota;
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
    
    public String getCurso() {
        return curso;
    }
    
    public String getNota() {
        return nota;
    }
    
    public String getData_lancamento() {
        return data_lancamento;
    }
    
}
