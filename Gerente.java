import java.util.Date;

public class Gerente extends Empleado {
    
    private String departamento;

    public Gerente(String dni, String nombre, String rol, Date fechaNacimiento, String departamento) {
        super(dni, nombre, rol, fechaNacimiento);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

}
