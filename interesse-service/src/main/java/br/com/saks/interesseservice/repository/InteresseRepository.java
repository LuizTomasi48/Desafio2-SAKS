/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.saks.interesseservice.repository;

import br.com.saks.interesseservice.model.Interesse;
import br.com.saks.interesseservice.model.InteresseIdentity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 7915772
 */
@Repository
public interface InteresseRepository extends JpaRepository<Interesse, InteresseIdentity> {
    List<Interesse> findAllByInteresseIdentityIdCliente(Long idCliente);
}
