import java.util.Date;

public class Empleado{
    private String dni;
    private String nombre;
    private String rol;
    private Date fechaNacimiento;
    
    public Empleado(String dni, String nombre, String rol, Date fechaNacimiento) {
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    
}