
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import javax.swing.JOptionPane;

public class GestionEmpleados {

    private List<Empleado> empleados;

    public GestionEmpleados() {
        empleados = new ArrayList<>();
    }

    @Operacion(descripcion = "Agregar un empleado")
    public void agregarEmpleado() {
        String dni = JOptionPane.showInputDialog("Ingrese el dni del empleado");
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado");
        // TO-DO No se si puedo introducir asi un obj Date
        String fechaStr = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento del empleado (dd/mm/yyyy):");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;
        try {
            fecha = formato.parse(fechaStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String[] roles = { "GERENTE", "DESARROLLADOR", "TESTER" };

        String rolElegido = (String) JOptionPane.showInputDialog(null, "Seleccione el rol del empleado", "Roles",
                JOptionPane.QUESTION_MESSAGE, null, roles, roles[0]);

        RolEmpleado rol = RolEmpleado.valueOf(rolElegido);

        Empleado nuevoEmpleado;

        switch (rol) {
            case GERENTE:
                String departamento = JOptionPane.showInputDialog("Introduce el departamento al que pertenece");
                nuevoEmpleado = new Gerente(dni, nombre, fecha, departamento);
                break;
            case DESARROLLADOR:
                String lenguaje = JOptionPane.showInputDialog("Introduce el lenguaje ene l que desarrolla");
                nuevoEmpleado = new Desarrollador(dni, nombre, fecha, lenguaje);
                break;
            case TESTER:
                int pruebasRealizadas = 0;
                nuevoEmpleado = new Tester(dni, nombre, fecha, pruebasRealizadas);
                break;
            default:
                throw new IllegalStateException("El rol elegido no es válido");
        }

        empleados.add(nuevoEmpleado);
        System.out.println("Empleado agregado satisfactoriamente: " + nuevoEmpleado);
    }

    public void eliminarEmpleado(String dni) {
        for (Empleado e : empleados) {
            if (e.getDni().equals(dni)) {
                empleados.remove(e);
                JOptionPane.showMessageDialog(null, "Se ha eliminado el empleado con dni " + dni);
            } else {
                JOptionPane.showMessageDialog(null, "No existe ningun empleado en el sistema con ese DNI");
            }
        }
    }

    @Operacion(descripcion = "Eliminar un empleado del sistema")
    public void eliminarEmpleado() {
        if (empleados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No existen empleados");
        } else {
            String dni = JOptionPane.showInputDialog("Introduce el dni del empleado a eliminar");
            eliminarEmpleado(dni);
        }
    }

    public static void main(String[] args) {
        GestionEmpleados gestion = new GestionEmpleados();
        Map<Integer, Consumer<Void>> menu = new HashMap<>();
        menu.put(3, (v) -> gestion.eliminarEmpleado());

        boolean salir = false;

        while (!salir) {
            String opcion = JOptionPane.showInputDialog(
                    """
                            1. Agregar empleado
                            2. Mostrar empleados
                            3. Eliminar empleado
                            4. Salir
                            Seleccione una opción:\s""");
            try {
                int opcionInt = Integer.parseInt(opcion);
                Consumer<Void> operacion = menu.get(opcionInt);
                if (operacion != null) {
                    operacion.accept(null);
                } else if (opcionInt == 4) {
                    salir = true;
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema");
                } else {
                    JOptionPane.showMessageDialog(null, "Operacion no valida");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error. Ingrese un numero valido");
                System.out.println("Error. Ingrese un numero valido");
            }
        }
    }

}
