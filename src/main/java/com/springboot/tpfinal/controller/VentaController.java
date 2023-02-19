
package com.springboot.tpfinal.controller;

import com.springboot.tpfinal.dto.ProductoVentaDTO;
import com.springboot.tpfinal.dto.VentaMayorDTO;
import com.springboot.tpfinal.model.Venta;
import com.springboot.tpfinal.service.IVentaService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VentaController {
    
    @Autowired
    IVentaService venServ;
    
    // Crear Venta
    @PostMapping("/venta/crear")
    public String saveVenta(@RequestBody Venta ven){
        venServ.saveVenta(ven);
        return "La venta ha sido creada correctamente";
    }
    
    // Traer Venta
    @GetMapping("/venta/traer/{codigo_venta}")
    public Venta findVenta(@PathVariable Long codigo_venta){
        Venta ven = venServ.findVenta(codigo_venta);
        return ven;
    }
    
    // Traer lista de Ventas
    @GetMapping("/ventas/traer")
    public List<Venta> getVentas(){
        List<Venta> listaVentas = venServ.getVentas();
        return listaVentas;
    }
    
    // Editar Venta
    @PutMapping("/venta/editar")
    public Venta editVenta(@RequestBody Venta ven){
        venServ.editVenta(ven);
        return venServ.findVenta(ven.getCodigo_venta());
    }
    
    // Eliminar Venta
    @DeleteMapping("/venta/eliminar/{codigo_venta}")
    public String deleteVenta(@PathVariable Long codigo_venta){
        venServ.deleteVenta(codigo_venta);
        return "La venta ha sido eliminada correctamente";
    }
    
    // Traer productos por venta
    @GetMapping ("/venta/productos/{codigo_venta}")
    public ProductoVentaDTO getProductosVenta(@PathVariable Long codigo_venta){
        return venServ.getProductosVenta(codigo_venta);
    }
    
    // Traer suma de montos y cantidad de ventas por dia
    @GetMapping("/ventas/montos/{fecha_venta}")
    public String getMontosCantVentas(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                      @PathVariable LocalDate fecha_venta) {        
        int cantVen;
        Double monto = 0.0; 
        
        List<Venta> listaVentasFecha = venServ.getMontosCantVentas(fecha_venta);
        
        cantVen = listaVentasFecha.size();
        
        for (Venta ven : listaVentasFecha){
            monto = monto + ven.getTotal();
        }    
        
        return "La cantidad de ventas del dia es " + cantVen + " y el monto total de ventas es: " + monto ;       
    }
    
    // Traer datos de la venta con monto más alto
    @GetMapping("/ventas/mayor_venta")
    public VentaMayorDTO getDatosVentaMayor(){
        return venServ.getDatosVentaMayor();
    }
    
    // Traer venta mas alta
    @GetMapping("/venta/mas_alta")
    public Venta ventaMasAlta(){
        Venta ven = venServ.ventaMasAlta();
        return ven;
    }
    
    
        
     
}
