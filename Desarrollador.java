import java.util.Date;

public class Desarrollador extends Empleado {

    private String lenguajeDesarrollo;

    public Desarrollador(String dni, String nombre, Date fechaNacimiento, String lenguajeDesarrollo){
        super(dni, nombre, RolEmpleado.DESARROLLADOR, fechaNacimiento);
        this.lenguajeDesarrollo = lenguajeDesarrollo;
    }

    public String getLenguajeDesarrollo() {
        return lenguajeDesarrollo;
    }

    public void setLenguajeDesarrollo(String lenguajeDesarrollo) {
        this.lenguajeDesarrollo = lenguajeDesarrollo;
    }

    @Override
    public String toString(){
        return super.toString() + "\nLenguaje de desarrollo: " + lenguajeDesarrollo;
    }

}
