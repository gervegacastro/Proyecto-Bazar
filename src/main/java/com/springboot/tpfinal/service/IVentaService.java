
package com.springboot.tpfinal.service;

import com.springboot.tpfinal.dto.ProductoVentaDTO;
import com.springboot.tpfinal.dto.VentaMayorDTO;
import com.springboot.tpfinal.model.Venta;
import java.time.LocalDate;
import java.util.List;


public interface IVentaService {
    
    // Crear Venta
    public void saveVenta(Venta ven);
    
    // Traer Venta
    public Venta findVenta(Long codigo_venta);
    
    // Traer listas Ventas
    public List<Venta> getVentas();
    
    // Editar Venta
    public void editVenta(Venta ven);
    
    // Eliminar Venta
    public void deleteVenta(Long codigo_venta);
    
    // Traer productos por venta
    public ProductoVentaDTO getProductosVenta(Long codigo_venta);
    
    // Traer suma de montos y cantidad de ventas por dia
    public List<Venta> getMontosCantVentas(LocalDate fecha_venta);
    
    // Traer datos de la venta con monto más alto
    public VentaMayorDTO getDatosVentaMayor ();
    
    // Traer venta mas alta
    public Venta ventaMasAlta();
    
}
