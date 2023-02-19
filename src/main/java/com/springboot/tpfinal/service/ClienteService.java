
package com.springboot.tpfinal.service;

import com.springboot.tpfinal.model.Cliente;
import com.springboot.tpfinal.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService{
    
    @Autowired
    IClienteRepository cliRep;
    

    // Crear Cliente
    @Override
    public void saveCliente(Cliente cli) {
        cliRep.save(cli);
    }
    
    // Traer Cliente
    @Override
    public Cliente findCliente(Long id_cliente) {
        Cliente cli = cliRep.findById(id_cliente).orElse(null);
        return cli;
    }
    
    // Traer lista de Clientes
    @Override
    public List<Cliente> getClientes() {
        List<Cliente> listaClientes = cliRep.findAll();
        return listaClientes;
    }
    
    //Editar Cliente
    @Override
    public void editCliente(Cliente cli) {
        this.saveCliente(cli);
    }
    
    // Eliminar cliente
    @Override
    public void deleteCliente(Long id_cliente) {
        cliRep.deleteById(id_cliente);
    }
    
}
