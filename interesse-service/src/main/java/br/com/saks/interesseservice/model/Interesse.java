/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.saks.interesseservice.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import lombok.Data;

/**
 *
 * @author 7915772
 */
@Entity
@Data
public class Interesse {
    
    @EmbeddedId
    private InteresseIdentity interesseIndentiry;

    public InteresseIdentity getInteresseIdentity() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
