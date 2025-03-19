import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

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
        GestionEmpleados gestion = new GestionEmpleados();
        Map<Integer, Consumer<Void>> menu = new HashMap<>();
        menu.put(3, (v) -> gestion.eliminarEmpleado());

        boolean salir = false;

        while(!salir){
            String opcion = JOptionPane.showInputDialog(
                """
                1. Agregar empleado
                2. Mostrar empleados
                3. Eliminar empleado
                4. Salir
                Seleccione una opción:\s"""
            );
            try{
                int opcionInt = Integer.parseInt(opcion);
                Consumer<Void> operacion = menu.get(opcionInt);
                if(operacion != null){
                    operacion.accept(null);
                }else if(opcionInt == 4){
                    salir = true;
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema");
                }else{
                    JOptionPane.showMessageDialog(null, "Operacion no valida");
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Error. Ingrese un numero valido");
                System.out.println("Error. Ingrese un numero valido");
            }
        }
    }


}
