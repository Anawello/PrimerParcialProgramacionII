package code;

import java.time.LocalDate;

public abstract class Servicio {
    protected String codServicio;
    protected double porcentajeDescuento;
    protected boolean enPromocion;
    protected LocalDate diaCreacion;
    
    public Servicio(String codServicio, double porcentajeDescuento, boolean enPromocion) throws Exception{
        this.validarCodServicio(codServicio);
        this.codServicio = codServicio;
        this.porcentajeDescuento = porcentajeDescuento;
        this.enPromocion = enPromocion;
        this.diaCreacion = LocalDate.now();
    }

    public Servicio(String codServicio, LocalDate dia, double porcentajeDescuento, boolean enPromocion) throws Exception{
        this.validarCodServicio(codServicio);
        this.codServicio = codServicio;
        this.porcentajeDescuento = porcentajeDescuento;
        this.enPromocion = enPromocion;
        this.diaCreacion = dia;
    }

    public String getCodServicio() {
        return codServicio;
    }

    public LocalDate getDia() {
        return diaCreacion;
    }

    public boolean isEnPromocion() {
        return enPromocion;
    }
    
    
    private void validarCodServicio(String codServicio) throws Exception{
        //Valida si tiene una logitud de 6 digitos.
        if (codServicio.length() != 6){
            throw new Exception("El codigo de servicio no tiene una longitud de 6.");
        }
    }
    
    public double calcularPrecioFinal(LocalDate dia) {
        return 0.0;
    }
}
