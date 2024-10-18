package code;

import java.time.LocalDate;

public class Gastronomia extends Servicio{
    private String gastronomia;
    private double precio;
    private int diaSemDesc;

    public Gastronomia(String codServicio, String gastronomia, double precio, int diaSemDesc, boolean enPromocion, double porcentajeDescuento) throws Exception {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.gastronomia = gastronomia;
        this.precio = precio;
        this.diaSemDesc = diaSemDesc;
    }   
    
    public Gastronomia(String codServicio, LocalDate dia, String gastronomia, double precio, int diaSemDesc, boolean enPromocion, double porcentajeDescuento) throws Exception {
        super(codServicio, dia, porcentajeDescuento, enPromocion);
        this.gastronomia = gastronomia;
        this.precio = precio;
        this.diaSemDesc = diaSemDesc;
    } 

    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        double precioFinal = precio;
        
        if (enPromocion && this.isPromocion(dia)){
            precioFinal -= (porcentajeDescuento / 100) * precioFinal;
        }
        
        return precioFinal;
    }
    
    private boolean isPromocion(LocalDate dia){
        return dia.getDayOfWeek().equals(diaSemDesc);
    }
}
