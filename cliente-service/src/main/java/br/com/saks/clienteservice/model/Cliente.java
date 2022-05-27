/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saks.clienteservice.model;

import static br.com.saks.clienteservice.controller.Criptografia.criptografa;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import lombok.Data;

/**
 *
 * @author Bolofofo
 */
@Entity
@Data
public class Cliente implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Transient
    Imovel imovel;
    
    @Column(length=150)
    private String nome;
    
    @Column(nullable = false, length=200)
    private String email;
    
    @Column(nullable = false, length=200)
    private String senha;
    
    @Column(length=15)
    private String telefone;

    public void setSenha(String senha) {
        this.senha = criptografa(senha);
    }

    
    
    
}
