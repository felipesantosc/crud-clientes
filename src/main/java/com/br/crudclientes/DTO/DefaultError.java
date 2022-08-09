package com.br.crudclientes.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DefaultError {
    Integer code;
    String message;
}
