
import code.Gastronomia;
import code.Hospedaje;
import code.Servicio;
import code.Sistema;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Test.pruebasCreacionGasatronomia(sistema, "4892", 1);
        Test.pruebasCreacionGasatronomia(sistema, "489235", 2);
        Test.pruebasCreacionHospedaje(sistema, "2872", 3);
        Test.pruebasCreacionHospedaje(sistema, "287282", 4);
        Test.CalculoPrecioFinales(sistema, "489235", LocalDate.of(2020, Month.OCTOBER, 28), 1);
        Test.CalculoPrecioFinales(sistema, "287282", LocalDate.of(2020, Month.OCTOBER, 27), 2);
        Test.agregarSericios(sistema);
        Test.traerServicios(sistema);
    }
    
    static void pruebasCreacionGasatronomia(Sistema sistema, String codigo, int test){
        System.out.println("1-" + test);
        try{
            sistema.agregarGastronomia(codigo, 15.0, true, "Hamburguesa Criolla", 180.0, 4);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    static void pruebasCreacionHospedaje(Sistema sistema, String codigo, int test){
        System.out.println("1-" + test);
        try{
            sistema.agregarHospedaje(codigo, 10.0, true, "Cabaña 3 personas", 1500.0);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    static void CalculoPrecioFinales(Sistema sistema, String codigo, LocalDate date, int test){
        System.out.println("2-" + test);
        try{
            Servicio gastronomia = sistema.traerServicio(codigo);
            double precioFinal = gastronomia.calcularPrecioFinal(date);
            System.out.println(precioFinal);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    static void agregarSericios(Sistema sistema){
        System.out.println("3");
        try{
            sistema.agregarGastronomia("858927", 15.0, true, "Milanesa con pure", 350.0, 3);
            sistema.agregarHospedaje("489259", 10.0, true, "Habitación triple", 2200.0);
            sistema.agregarGastronomia("182835", 20.0, false, "Gaseosa", 120.0, 3);
            sistema.agregarHospedaje("758972", 15.0, false, "Habitación simple", 100.0);
            System.out.println(sistema.getLstServicio().toString());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    static void traerServicios(Sistema sistema) {
        System.out.println("4-1");
        List<Servicio> serviciosPromocion = sistema.traerServicio(true);
        System.out.println(serviciosPromocion.toString());
        
        System.out.println("4-2");
        List<Servicio> serviciosPromocionFecha = sistema.traerServicio(true, LocalDate.of(2020, Month.OCTOBER, 28));
        System.out.println(serviciosPromocionFecha.toString());
    }
}
