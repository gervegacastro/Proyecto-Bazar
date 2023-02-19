
package com.springboot.tpfinal.service;

import com.springboot.tpfinal.model.Producto;
import com.springboot.tpfinal.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService{
    
    @Autowired
    IProductoRepository prodRep;
    
    // Crear Producto
    @Override
    public void saveProducto(Producto prod) {
        prodRep.save(prod);
    }
    
    // Traer Producto
    @Override
    public Producto findProducto(Long codigo_producto) {
        Producto prod = prodRep.findById(codigo_producto).orElse(null);
        return prod;
    }
    
    // Traer lista de Productos
    @Override
    public List<Producto> getProductos() {
        List<Producto> listaProductos = prodRep.findAll();
        return listaProductos;
    }
    
    // Editar Producto
    @Override
    public void editProducto(Producto prod) {
        this.saveProducto(prod);
    }
    
    // Eliminar Producto
    @Override
    public void deleteProducto(Long codigo_producto) {
        prodRep.deleteById(codigo_producto);
    }

    // Traer Producto con stock menos a 5
    @Override
    public List<Producto> getProductosStock() {
        
        double cantidad;
        
        List<Producto> listaProductos = this.getProductos();
        List<Producto> listaProdConStock = new ArrayList<>();
        
        for (Producto prod : listaProductos){
            cantidad = prod.getCantidad_disponible();
            if (cantidad <= 5){
                listaProdConStock.add(prod);
            }
        }
        return listaProdConStock;
    }
    
}
