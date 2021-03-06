/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saks.clienteservice.controller;

import br.com.saks.clienteservice.model.InteresseIdentity;
import br.com.saks.clienteservice.model.Cliente;
import br.com.saks.clienteservice.model.Imovel;
import br.com.saks.clienteservice.model.Interesse;
import br.com.saks.clienteservice.repository.ClienteRepository;
import br.com.saks.clienteservice.service.ImovelService;
import br.com.saks.clienteservice.service.InteresseService;
import java.util.ArrayList;
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
 * @author Bolofofo
 */
@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private InteresseService interesseService;
    
    @Autowired
    private ImovelService imovelService;
    
    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }
    
    @GetMapping(value="/{id}")
    public Optional<Cliente> listarPeloId(@PathVariable Long id) {
        return clienteRepository.findById(id);
    }
    
    @GetMapping(value="/interese/{id}")
    public Cliente listarPorId(@PathVariable Long id) {
        Optional<Cliente> clienteResponse = clienteRepository.findById(id);
        Cliente cliente = clienteResponse.get();
        
        List<Interesse> interesses;
        interesses = interesseService.listarPorIdCliente(id);
        
        List<Imovel> imoveis = new ArrayList<>();
        
        for(Interesse interesse : interesses) {
            InteresseIdentity interesseId = interesse.getInteresseIdentity();
            
            Imovel imovel = imovelService.listarPeloId(interesseId.getIdImovel());
            imoveis.add(imovel);
        }
        
        cliente.setImoveisR(imoveis);
        
        return cliente;
    
    }
    @PostMapping
    public Cliente adicionar(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    
    @PutMapping(value="/{id}")
    public ResponseEntity editar(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteRepository.findById(id)
                .map(record -> {
                    record.setNome(cliente.getNome());
                    record.setEmail(cliente.getEmail());
                    record.setSenha(cliente.getSenha());
                    record.setTelefone(cliente.getTelefone());
                    Cliente clienteUpdated = clienteRepository.save(record);
                    return ResponseEntity.ok().body(clienteUpdated);
                }).orElse(ResponseEntity.notFound().build());
    }
    
   
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        return clienteRepository.findById(id)
                .map(record-> {
                    clienteRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
