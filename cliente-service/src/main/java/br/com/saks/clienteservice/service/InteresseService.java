/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.saks.clienteservice.service;

import br.com.saks.clienteservice.model.Interesse;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Bolofofo
 */
@FeignClient(name="interesse-service")
public interface InteresseService {
    @GetMapping(value="/interesses/cliente/{idCliente}")
    List<Interesse> listarPorIdCliente(@PathVariable("idCliente") Long idCliente);
}
