package br.unitins.tp1.loja.model.usuario;

import java.time.LocalDate;

import br.unitins.tp1.loja.model.DefaultEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Entity
public class Cliente extends DefaultEntity{

    @OneToOne
    @JoinColumn(name = "id_usuario", unique = true)
    private Usuario usuario;

    @Column(length = 100, nullable = false)
    @NotEmpty(message = "O nome não pode estar vazio")
    private String nome;

    @Column(nullable = false, name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(length = 14, nullable = false, unique = true)
    @Pattern(regexp = "\\d{14}", message = "CNPJ deve conter 14 dígitos") 
    // para validar a escrita correta do cpf
    private String cpf;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    

    
}
