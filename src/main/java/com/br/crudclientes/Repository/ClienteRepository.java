package com.br.crudclientes.Repository;

import com.br.crudclientes.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

     boolean existsClienteByNumeroDocumento(String numeroDocumento);
}
