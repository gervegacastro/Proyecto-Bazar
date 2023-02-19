
package com.springboot.tpfinal.dto;

import com.springboot.tpfinal.model.Producto;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductoVentaDTO {
    
    private Long codigo_venta;
    private List<Producto> listaProductos;

    public ProductoVentaDTO() {
    }

    public ProductoVentaDTO(Long codigo_venta, List<Producto> listaProductos) {
        this.codigo_venta = codigo_venta;
        this.listaProductos = listaProductos;
    }
    
    
}
