
package com.springboot.tpfinal.service;

import com.springboot.tpfinal.model.Cliente;
import java.util.List;


public interface IClienteService {
    
    // Crear Cliente
    public void saveCliente (Cliente cli);
    
    // Traer Cliente
    public Cliente findCliente (Long id_cliente);
    
    // Traer lista Clientes
    public List<Cliente> getClientes ();
    
    // Editar Cliente
    public void editCliente (Cliente cli);
    
    // Eliminar Cliente
    public void deleteCliente (Long id_cliente);
    
}
