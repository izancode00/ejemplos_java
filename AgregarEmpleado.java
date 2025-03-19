import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AgregarEmpleado {
    private List<Empleado> empleados;

    public AgregarEmpleado() {
        empleados = new ArrayList<>();
    }

    @Operacion(descripcion = "Agregar un empleado");
    public void agregarEmpleado() {
        String dni = JOptionPane.showInputDialog("Ingrese el dni del empleado");
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado");
        //TO-DO No se si puedo introducir asi un obj Date
        String fecha = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento del empleado (dd/mm/yyyy):");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String[] roles = {"GERENTE", "DESARROLLADOR", "TESTER"};

        String rolElegido = (String) JOptionPane.showInputDialog(null, "Seleccione el rol del empleado", "Roles",JOptionPane.QUESTION_MESSAGE, null, roles, roles[0] );

        RolEmpleado rol = RolEmpleado.valueOf(rolElegido);

        Empleado nuevoEmpleado;

        switch(rol){
            case GERENTE:
                String departamento = JOptionPane.showInputDialog("Introduce el departamento al que pertenece");
                break;
            case DESARROLLADOR:
            String lenguaje = JOptionPane.showInputDialog("Introduce el lenguaje ene l que desarrolla");
                break;
            case TESTER:
                int pruebasRealizadas = 0;
                nuevoEmpleado = new Tester(dni, nombre, rol, fecha, pruebasRealizadas);
                break;
            default: 
                throw new IllegalStateException("El rol elegido no es válido");
        }

        empleados.add(nuevoEmpleado);
        System.out.println("Empleado agregado satisfactoriamente: " + nuevoEmpleado);
    }
}
