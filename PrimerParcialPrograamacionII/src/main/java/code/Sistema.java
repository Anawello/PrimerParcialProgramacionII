package code;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Servicio> lstServicio = new ArrayList<>();
    
    public Servicio traerServicio(String codServicio){
        Servicio servicio = null;
        
        for (Servicio s : lstServicio)
        {
            if (s.getCodServicio().equals(codServicio))
            {
                servicio = s;
                break;
            }
        }  
        
        return servicio;
    }

    public List<Servicio> getLstServicio() {
        return lstServicio;
    }
    
    public List traerServicio(boolean enPromocion){
        List<Servicio> servicios = new ArrayList<>();
        
        for (Servicio s : lstServicio)
        {
            if (s.isEnPromocion() == enPromocion){
                servicios.add(s);
            }
        }
        
        return servicios;
    }
    
    public List traerServicio(boolean enPromocion, LocalDate dia){
        List<Servicio> servicios = new ArrayList<>();
        
        for (Servicio s : lstServicio)
        {
            if (s.isEnPromocion() == enPromocion && s.getDia().equals(dia)){
                servicios.add(s);
            }
        }
        
        return servicios;
    }
    
    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento,
                                    boolean enPromocion, String gastronomia, double precio,
                                    int diaSemDesc) throws Exception{
        boolean agregado = false;
        
        Gastronomia nuevaGastronomia = new Gastronomia(codServicio,                                                              
                                    gastronomia, precio, diaSemDesc, 
                                    enPromocion, porcentajeDescuento);
        
        if (this.traerServicio(codServicio) != null){
            throw new Exception("Objeto ya existente.");
        }else{ 
            this.lstServicio.add(nuevaGastronomia);
            agregado = true;
        }
        
        return agregado;
    }
    
    public boolean agregarGastronomia(String codServicio, LocalDate dia, double porcentajeDescuento,
                                    boolean enPromocion, String gastronomia, double precio,
                                    int diaSemDesc) throws Exception{
        boolean agregado = false;
        
        Gastronomia nuevaGastronomia = new Gastronomia(codServicio, dia,                                                             
                                    gastronomia, precio, diaSemDesc, 
                                    enPromocion, porcentajeDescuento);
        
        if (this.traerServicio(codServicio) != null){
            throw new Exception("Objeto ya existente.");
        }else{ 
            this.lstServicio.add(nuevaGastronomia);
            agregado = true;
        }
        
        return agregado;
    }
    
    public boolean agregarHospedaje(String codServicio, double porcentajeDescuento,
                                    boolean enPromocion, String hospedaje, 
                                    double precioPorNoche) throws Exception{
        boolean agregado = false;
        
        Hospedaje nuevoHospedaje = new Hospedaje(codServicio,                                                              
                                    hospedaje, precioPorNoche, 
                                    enPromocion,
                                    porcentajeDescuento);
        
        if (this.traerServicio(codServicio) != null){
            throw new Exception("Objeto ya existente.");
        }else{ 
            this.lstServicio.add(nuevoHospedaje);
            agregado = true;
        }
        
        return agregado;
    }
}
