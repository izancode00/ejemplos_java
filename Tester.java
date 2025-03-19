import java.util.Date;

public class Tester extends Empleado {

    private int pruebasRealizadas;

    public Tester(String dni, String nombre, Date fechaNacimiento, int pruebasRealizadas) {
        super(dni, nombre, RolEmpleado.TESTER, fechaNacimiento);
        this.pruebasRealizadas = pruebasRealizadas;
    }

    public int getPruebasRealizadas() {
        return pruebasRealizadas;
    }

    public void setPruebasRealizadas(int pruebasRealizadas) {
        this.pruebasRealizadas = pruebasRealizadas;
    }

    @Override
    public String toString() {
        return super.toString() + "\nNumero de pruebas realizadas: " + pruebasRealizadas;
    }
}
