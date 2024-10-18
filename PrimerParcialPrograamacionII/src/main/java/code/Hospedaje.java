package code;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Hospedaje extends Servicio{
    private String hospedaje;
    private double precioPorNoche;

    public Hospedaje(String codServicio, String hospedaje, double precioPorNoche, 
            boolean enPromocion, double porcentajeDescuento) throws Exception {
        
        super(codServicio, porcentajeDescuento, enPromocion);
        this.hospedaje = hospedaje;
        this.precioPorNoche = precioPorNoche;
    }
    
    public Hospedaje(String codServicio, LocalDate dia, String hospedaje, double precioPorNoche, 
            boolean enPromocion, double porcentajeDescuento) throws Exception {
        
        super(codServicio, dia, porcentajeDescuento, enPromocion);
        this.hospedaje = hospedaje;
        this.precioPorNoche = precioPorNoche;
    }

    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        double precio = precioPorNoche;
        
        if (enPromocion){
            if (this.isDiaPromocion(dia)){
                precio -= (porcentajeDescuento / 100) * precio;
            }
        }
        
        return precio;      
    }  
    
    private boolean isDiaPromocion(LocalDate dia){
        return !(dia.getDayOfWeek().equals(DayOfWeek.SATURDAY) && 
                dia.getDayOfWeek().equals(DayOfWeek.SUNDAY));
    }
}
