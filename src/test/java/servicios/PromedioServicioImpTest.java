package servicios;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PromedioServicioImpTest {

    private final PromedioServicioImp promedioServicio = new PromedioServicioImp();

    @Test
    public void calcularPromedio_ListaVacia() {
        assertEquals(0.0, promedioServicio.calcularPromedio(Collections.emptyList()));
    }

    @Test
    public void calcularPromedio_ListaConValores() {
        assertEquals(5.0, promedioServicio.calcularPromedio(Arrays.asList(4.0, 6.0)));
    }

    @Test
    public void calcularPromedio_ListaConUnSoloValor() {
        assertEquals(7.5, promedioServicio.calcularPromedio(Collections.singletonList(7.5)));
    }
}
