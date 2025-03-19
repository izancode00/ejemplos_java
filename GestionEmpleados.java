import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class GestionEmpleados {

    private List<Empleado> empleados;

    public GestionEmpleados(){
        empleados = new ArrayList<>();
    }

    public void eliminarEmpleado(String dni){
        for(Empleado e : empleados){
            if(e.getDni().equals(dni)){
                empleados.remove(e);
                JOptionPane.showMessageDialog(null, "Se ha eliminado el empleado con dni " + dni);
            }else{
                JOptionPane.showMessageDialog(null, "No existe ningun empleado en el sistema con ese DNI");
            }
        }
    }

    @Operacion(descripcion = "Eliminar un empleado del sistema")
    public void eliminarEmpleado(){
        if(empleados.isEmpty()){
            JOptionPane.showMessageDialog(null,"No existen empleados");
        }else{
            String dni = JOptionPane.showInputDialog("Introduce el dni del empleado a eliminar");
            eliminarEmpleado(dni);
        }
    }


    public static void main(String[] args) {
        
    }


}
