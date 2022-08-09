package com.br.crudclientes.Service;

import com.br.crudclientes.DTO.ClienteDTO;
import com.br.crudclientes.Enum.TiposDocumentoIdentificacao;
import com.br.crudclientes.Model.Cliente;
import com.br.crudclientes.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;


    public String adicionaCliente(ClienteDTO clienteDTO){
        if(clienteRepository.existsClienteByNumeroDocumento(clienteDTO.getNumeroDocumento())){
            return "O documento desse cliente já está cadastrado!";
        }else {
            clienteDTO.setTipoDocumento(clienteDTO.getTipoDocumento().toUpperCase());
            Cliente cliente = clienteDTO.toEntity();
            clienteRepository.save(cliente);
        }
        return "Novo cliente adicionado";
    }

    public List<ClienteDTO> listaCliente(){
        List<Cliente> listaentity = clienteRepository.findAll();
        return listaentity.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }

    public String deletaCliente(Integer id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()){
            clienteRepository.deleteById(id);
            return "Cliente deletado!";
        }
        return "Cliente não Encontrado";

    }

    public String alteraCliente(Integer id , ClienteDTO novocliente){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()){
            cliente.get().setNomeCliente(novocliente.getNomeCLiente());
            cliente.get().setTipoDocumento(TiposDocumentoIdentificacao.valueOf(novocliente.getTipoDocumento()));
            cliente.get().setNumeroDocumento(novocliente.getNumeroDocumento());
            clienteRepository.save(cliente.get());
            return "Cliente alterado" ;
        }
        return "Cliente não encontrado";
    }
}
