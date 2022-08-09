package com.br.crudclientes.DTO;

import com.br.crudclientes.Enum.TiposDocumentoIdentificacao;
import com.br.crudclientes.Model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Locale;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    String nomeCLiente;
    String tipoDocumento;
    String numeroDocumento;

    public ClienteDTO(Cliente cliente){
        this.nomeCLiente = cliente.getNomeCliente();
        this.tipoDocumento = cliente.getTipoDocumento().toString();
        this.numeroDocumento = cliente.getNumeroDocumento();
    }

    public Cliente toEntity(){
        Cliente cliente = new Cliente();
        cliente.setNomeCliente(this.getNomeCLiente());
        cliente.setTipoDocumento(TiposDocumentoIdentificacao.valueOf(this.getTipoDocumento()));
        cliente.setNumeroDocumento(this.getNumeroDocumento());

        return cliente;
    }
}
