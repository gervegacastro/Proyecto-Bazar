
package com.springboot.tpfinal.service;

import com.springboot.tpfinal.dto.ProductoVentaDTO;
import com.springboot.tpfinal.dto.VentaMayorDTO;
import com.springboot.tpfinal.model.Venta;
import com.springboot.tpfinal.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService{
    
    @Autowired
    IVentaRepository venRep;

    // Crear Venta
    @Override
    public void saveVenta(Venta ven) {
        venRep.save(ven);
    }
    
    // Traer Venta
    @Override
    public Venta findVenta(Long codigo_venta) {
        Venta ven = venRep.findById(codigo_venta).orElse(null);
        return ven;
    }
    
    // Traer lista de Ventas
    @Override
    public List<Venta> getVentas() {
        List<Venta> listaVentas = venRep.findAll();
        return listaVentas;
    }
    
    // Editar Venta
    @Override
    public void editVenta(Venta ven) {
        this.saveVenta(ven);
    }
    
    // Eliminar Venta
    @Override
    public void deleteVenta(Long codigo_venta) {
        venRep.deleteById(codigo_venta);
    }

    // Traer productos por venta
    @Override
    public ProductoVentaDTO getProductosVenta(Long codigo_venta) {
        
        ProductoVentaDTO prodVenDto = new ProductoVentaDTO();
        Venta ven = this.findVenta(codigo_venta);
        prodVenDto.setCodigo_venta(ven.getCodigo_venta());
        prodVenDto.setListaProductos(ven.getListaProductos());
        
        return prodVenDto;
    }

    // Traer suma de montos y cantidad de ventas por dia
    @Override
    public List<Venta> getMontosCantVentas(LocalDate fecha_venta) {        
        
        LocalDate fecha;
        
        List<Venta> listaVentas = this.getVentas();
        List<Venta> listaVentasFecha = new ArrayList<>();
        
        for (Venta ven : listaVentas){
            fecha = ven.getFecha_venta();
            if (fecha == fecha_venta){
                System.out.println(ven);
                listaVentasFecha.add(ven);
            }
        }
        return listaVentasFecha;       
    }    
    
    // Traer datos de la venta con monto más alto
    @Override
    public VentaMayorDTO getDatosVentaMayor() {
        
        VentaMayorDTO vtaMayDto = new VentaMayorDTO();
        Venta ven = this.ventaMasAlta();
        vtaMayDto.setCodigo_venta(ven.getCodigo_venta());
        vtaMayDto.setTotal(ven.getTotal());
        vtaMayDto.setCantidad_productos(ven.getListaProductos().size());
        vtaMayDto.setNombre_cliente(ven.getUnCliente().getNombre());
        vtaMayDto.setApellido_cliente(ven.getUnCliente().getApellido());
               
        return vtaMayDto;
    }

    // Traer venta mas alta
    @Override
    public Venta ventaMasAlta() {
        
        Double totalVenta;
        Double ventaMayor = 0.0;
        
        List <Venta> listaVentas = this.getVentas();
        Venta vent = new Venta();
        
        for (Venta ven : listaVentas){
            totalVenta = ven.getTotal();
            if (totalVenta > ventaMayor){
                ventaMayor = totalVenta;
                ven.getCodigo_venta();
                vent = ven;
            }
        }       
    
        return vent;
    }
    
    
    
    
}
