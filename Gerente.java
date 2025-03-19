import java.util.Date;

public class Gerente extends Empleado {
    
    private String departamento;

    public Gerente(String dni, String nombre, Date fechaNacimiento, String departamento) {
        super(dni, nombre, RolEmpleado.GERENTE, fechaNacimiento);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString(){
        return super.toString() + "\nDepartamento: " + departamento;
    }

}
