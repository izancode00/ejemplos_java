import java.util.ArrayList;
import java.util.List;

public class MostrarEmpleados {
    private List<Empleado> empleados;

    public MostrarEmpleados() {
        empleados = new ArrayList<>();
    }

    public void mostrarEmpleados() {
        for (Empleado empleado : empleados) {
            System.out.println("Lista de empleados \n " + empleado);
        }
    }
}
