
package com.springboot.tpfinal.model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Venta {
    
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long codigo_venta;
    private Double total;
    private LocalDate fecha_venta;
    
    @OneToMany
    private List<Producto> listaProductos;
    @OneToOne
    private Cliente unCliente;

    public Venta() {
    }

    public Venta(Long codigo_venta, Double total, LocalDate fecha_venta, List<Producto> listaProductos, Cliente unCliente) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.fecha_venta = fecha_venta;
        this.listaProductos = listaProductos;
        this.unCliente = unCliente;
    }

    
    

    
    
    

    
    
    
    
    
}
