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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
      
    
    @GetMapping (value="/cliente/{idCliente}")
    public List<Interesse> listarPeloIdCliente(@PathVariable Long idCliente) {
       List<Interesse> interesses = interesseRepository.findAll();
        List<Interesse> interessePorCliente = new ArrayList<>();
        
        for(Interesse interesse : interesses) {
            InteresseIdentity interesseId = interesse.getInteresseIdentity();
            if(Objects.equals(interesseId.getIdCliente(), idCliente))
                interessePorCliente.add(interesse);
        }
        
        return interessePorCliente;
    }
    
    @GetMapping (value="/imovel/{idImovel}")
    public List<Interesse> listarPeloIdImovel(@PathVariable Long idImovel) {
       List<Interesse> interesses = interesseRepository.findAll();
        List<Interesse> interessePorImovel = new ArrayList<>();
        
        for(Interesse interesse : interesses) {
            InteresseIdentity interesseId = interesse.getInteresseIdentity();
            if(Objects.equals(interesseId.getIdImovel(), idImovel))
                interessePorImovel.add(interesse);
        }
        
        return interessePorImovel;
    }
    
    @GetMapping(value = "/{idCliente}")
    public List<Interesse>listarPeloIdCliente2(@PathVariable Long idCliente){
        List<Interesse> interesses = interesseRepository.findAll();
        List<Interesse> interessePorCliente = new ArrayList<>();
        
        for(Interesse interesse : interesses) {
            InteresseIdentity interesseId = interesse.getInteresseIdentity();
            if(Objects.equals(interesseId.getIdCliente(), idCliente))
                interessePorCliente.add(interesse);
        }
        
        return interessePorCliente;
    }

    @PostMapping
    public Interesse adicionar(@RequestBody InteresseIdentity interesseIdentity) {
        Interesse interesse = new Interesse();
        interesse.setInteresseIdentity(interesseIdentity);
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

