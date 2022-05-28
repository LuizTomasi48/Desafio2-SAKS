/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.saks.tipoImovelservice.service;

import br.com.saks.tipoImovelservice.model.Imovel;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;
/**
 *
 * @author Bolofofo
 */
@FeignClient(name="imovel-service")
public interface ImovelService {
    
    @GetMapping(value = "/imoveis/{idTipoImovel}")
    List<Imovel> listarPeloIdTipoImovel(@PathVariable("idTipoImovel") Long idTipoImovel);
}
