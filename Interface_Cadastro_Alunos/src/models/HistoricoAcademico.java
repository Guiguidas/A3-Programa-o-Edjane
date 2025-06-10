/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Guilherme
 */
public class HistoricoAcademico {
    
    private int id;  // <-- Adicionado
    private String id_aluno;
    private String id_curso;
    private String data;
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
    
    public String getId_curso() {
        return id_curso;
    }
    
    public String getData() {
        return data;
    }
    
    public String getStatus() {
        return status;
    }
    
}
