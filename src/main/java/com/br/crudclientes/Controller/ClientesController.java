package com.br.crudclientes.Controller;

import com.br.crudclientes.DTO.ClienteDTO;
import com.br.crudclientes.Model.Cliente;
import com.br.crudclientes.Service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api/clientes")
public class ClientesController {

    @Autowired
    ClienteService clienteService;

    @PostMapping("/adicionacliente")
    public ResponseEntity<String> adicionaCliente(@RequestBody ClienteDTO clienteDTO){
        return ResponseEntity.ok(clienteService.adicionaCliente(clienteDTO));
    }

    @GetMapping("/listaclientes")
    public ResponseEntity<List<ClienteDTO>>listaClientes(){
        return ResponseEntity.ok(clienteService.listaCliente());
    }

    @DeleteMapping("/deletacliente/{id}")
    public ResponseEntity<String> deletaCliente(@PathVariable Integer id){
        return ResponseEntity.ok(clienteService.deletaCliente(id));

    }

    @PutMapping("/alteracliente/{id}")
    public ResponseEntity<String> alteraCliente(@PathVariable Integer id, @RequestBody ClienteDTO dto){
        return ResponseEntity.ok(clienteService.alteraCliente(id,dto));
    }
}
