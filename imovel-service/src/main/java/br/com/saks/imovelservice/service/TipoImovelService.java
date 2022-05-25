/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.saks.imovelservice.service;

/**
 *
 * @author Bolofofo
 */


import br.com.saks.imovelservice.model.TipoImovel;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name=“tipoImovel-service”)
public interface TipoImovelService {
    @GetMapping(value = "/TiposImoveis/{id}")
    TipoImovel listarPeloId(@PathVariable("id") Long id);
}
