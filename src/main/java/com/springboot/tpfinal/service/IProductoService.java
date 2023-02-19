
package com.springboot.tpfinal.service;

import com.springboot.tpfinal.model.Producto;
import java.util.List;


public interface IProductoService {
    
    // Crear Producto
    public void saveProducto(Producto prod);
    
    // Traer Producto
    public Producto findProducto(Long codigo_producto);
    
    // Traer lista Productos
    public List<Producto> getProductos();
    
    // Editar Producto
    public void editProducto(Producto prod);
    
    // Eliminar Producto
    public void deleteProducto(Long codigo_producto);
    
    // Traer Producto con stock menos a 5
    public List<Producto> getProductosStock();
    
}
