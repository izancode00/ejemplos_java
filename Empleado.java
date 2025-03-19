import java.util.Date;

public class Empleado{
    private String dni;
    private String nombre;
    private RolEmpleado rol;
    private Date fechaNacimiento;
    
    public Empleado(String dni, String nombre, RolEmpleado rol, Date fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.rol = rol;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public RolEmpleado getRol() {
        return rol;
    }

    public void setRol(RolEmpleado rol) {
        this.rol = rol;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}