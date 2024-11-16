package br.unitins.tp1.loja.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Administrador extends Perfil{

    @Column(length = 100, nullable = false)
    @NotEmpty(message = "O nome não pode estar vazio")
    private String nome;

    @Column(nullable = false)
    private String setorResponsavel;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSetorResponsavel() {
        return setorResponsavel;
    }

    public void setSetorResponsavel(String setorResponsavel) {
        this.setorResponsavel = setorResponsavel;
    }

    
}
