/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.saks.imovelservice.repository;

import br.com.saks.imovelservice.model.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Bolofofo
 */
public interface ImovelRepository extends JpaRepository <Imovel, long>{
    
}
