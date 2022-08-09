package com.br.crudclientes.Model;

import com.br.crudclientes.Enum.TiposDocumentoIdentificacao;
import lombok.Data;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;

@Entity
@Data
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

    @Column(name = "nome")
    private String nomeCliente;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_documento")
    private TiposDocumentoIdentificacao tipoDocumento;

    @Column(name = "numero_documento")
    private String numeroDocumento;
}
