/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.saks.clienteservice.service;

/**
 *
 * @author Bolofofo
 */

import br.com.saks.clienteservice.model.Imovel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="Imovel-service")
public interface ImovelService {
    
    @GetMapping(value = "/Imoveis/{idImovel}")
    Imovel listarPeloId(@PathVariable("idImovel") Long idTipoImovel);
}
