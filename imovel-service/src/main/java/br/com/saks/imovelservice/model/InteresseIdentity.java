/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.saks.imovelservice.model;

/**
 *
 * @author 7915772
 */
public class InteresseIdentity {
    private Long idCliente;
    private Long idImovel;

    public InteresseIdentity(Long idCliente, Long idImovel) {
        this.idCliente = idCliente;
        this.idImovel = idImovel;
    }

    public InteresseIdentity() {
        
    }
    
    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(Long idImovel) {
        this.idImovel = idImovel;
    }
    
    
}
