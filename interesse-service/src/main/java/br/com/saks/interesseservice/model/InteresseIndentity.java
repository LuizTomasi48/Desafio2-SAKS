/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.saks.interesseservice.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author 7915772
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class InteresseIndentity implements Serializable {
    @Column(name = "id_imovel")
    private long idImovel;
    
    @Column (name = "id_livro")
    private long idCliente;
    
}
