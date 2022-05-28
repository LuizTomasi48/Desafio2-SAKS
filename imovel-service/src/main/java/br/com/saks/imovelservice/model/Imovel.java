/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saks.imovelservice.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import lombok.Data;

/**
 *
 * @author Bolofofo
 */
@Entity
@Data
public class Imovel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Transient
    TipoImovel tipoImovel;
    
    
    @Transient
    private List<Cliente> clientesInteresse;
    
    @Transient
    InteresseIdentity interesseIdentity;
    
    @Column (nullable = false, name = "id_tipo_imovel")
    private long idTipoImovel;
    
    @Column(nullable = false, length = 100)
    private String titulo;
    
    @Column(length = 500)
    private String descricao;
    
    @Column (nullable = false, name = "data_criacao")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCriacao;
    
    @Column(precision = 8, scale = 2)
    private double valor;
    
    @Column(nullable = false)
    private int status;

   

}
