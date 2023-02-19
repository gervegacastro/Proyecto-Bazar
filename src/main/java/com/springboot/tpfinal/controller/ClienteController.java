
package com.springboot.tpfinal.controller;

import com.springboot.tpfinal.model.Cliente;
import com.springboot.tpfinal.service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    
    @Autowired
    IClienteService cliServ;
    
    // Crear Cliente
    @PostMapping("/cliente/crear")
    public String saveCliente (@RequestBody Cliente cli){
        cliServ.saveCliente(cli);
        return "El cliente ha sido creado correctamente";
    }
    
    // Traer Cliente
    @GetMapping("/cliente/traer/{id_cliente}")
    public Cliente findCliente (@PathVariable Long id_cliente){
        Cliente cli = cliServ.findCliente(id_cliente);
        return cli;
    }
    
    // Traer lista de Clientes
    @GetMapping("/clientes/traer")
    public List<Cliente> getClientes(){
        List<Cliente> listaClientes = cliServ.getClientes();
        return listaClientes;
    }    
    
    // Editar Cliente
    @PutMapping("/cliente/editar")
    public Cliente editCliente(@RequestBody Cliente cli){
        cliServ.editCliente(cli);
        return cliServ.findCliente(cli.getId_cliente());
    }
    
    // Eliminar Cliente
    public String deleteCliente(Long id_cliente){
        cliServ.deleteCliente(id_cliente);
        return "El cliente ha sido eliminado correctamente";
    }
    
}
