
package com.springboot.tpfinal.controller;

import com.springboot.tpfinal.model.Producto;
import com.springboot.tpfinal.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
    
    @Autowired
    IProductoService prodServ;
    
    // Crear Producto
    @PostMapping("/producto/crear")
    public String saveProducto(@RequestBody Producto prod){
        prodServ.saveProducto(prod);
        return "El producto ha sido creado correctamente";
    }
    
    // Traer Producto
    @GetMapping("/producto/traer/{codigo_producto}")
    public Producto findProducto(@PathVariable Long codigo_producto){
       Producto prod = prodServ.findProducto(codigo_producto);
       return prod;
    }
    
    // Traer lista de Productos
    @GetMapping("/productos/traer")
    public List<Producto> getProductos(){
        List<Producto> listaProductos = prodServ.getProductos();
        return listaProductos;
    }
    
    // Editar Producto
    @PutMapping("/producto/editar")
    public Producto editProducto(@RequestBody Producto prod){
        prodServ.editProducto(prod);
        return prodServ.findProducto(prod.getCodigo_producto());
    }
    
    // Eliminar Producto
    @DeleteMapping("/producto/eliminar/{codigo_producto}")
    public String deleteProducto(@PathVariable Long codigo_producto){
        prodServ.deleteProducto(codigo_producto);
        return "El producto ha sido eliminado correctamente";
    }
    
    // Traer Producto con stock menos a 5
    @GetMapping ("/productos/falta_stock")
    public List<Producto> getProductosStock(){
        return prodServ.getProductosStock();
    }
    
    
}
