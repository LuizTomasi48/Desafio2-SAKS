/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.saks.interesseservice.controller;

import br.com.saks.interesseservice.model.Interesse;
import br.com.saks.interesseservice.model.InteresseIdentity;
import br.com.saks.interesseservice.repository.InteresseRepository;
import static com.google.common.io.Files.map;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 7915772
 */
@RestController
@RequestMapping("/interesses")
public class InteresseController {
    
    @Autowired
    private InteresseRepository interesseRepository;
    
    @GetMapping
    public List<Interesse> listarTodos() {
        return interesseRepository.findAll();
    }
    
    @GetMapping(value="/{idCliente}")
    public List<Interesse> listarPeloIdCliente(@PathVariable Long idCliente){
        return interesseRepository.findAllByInteresseIdentityIdCliente(idCliente);
    }
    

    @PostMapping
    public Interesse adicionar(@RequestBody Interesse interesse) {
        return interesseRepository.save(interesse);
    }
       
    @DeleteMapping(value="/{idImovel}/{idCliente}")
    public ResponseEntity deletar(@PathVariable Long idImovel, @PathVariable Long idCliente) {
        final InteresseIdentity interesseIdentity = new InteresseIdentity(idImovel, idCliente);
        return interesseRepository.findById(interesseIdentity)
                .map(record-> {
                    interesseRepository.deleteById(interesseIdentity);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
    
    
}

