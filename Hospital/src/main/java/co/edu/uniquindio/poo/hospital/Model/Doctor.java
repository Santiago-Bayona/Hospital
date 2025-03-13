package co.edu.uniquindio.poo.hospital.Model;

public class Doctor extends Persona {

    private Especialidad especialidad;
    public enum Especialidad {
        PEDIATRIA, CARDIOLOGIA,
        NEUMOLOGIA, GERIATRIA,
        MEDICOGENERAL, GINECOLOGIA,
        PSIQUIATRIA
    }

    /**
     * Constructor de la clase Doctor.
     * @param cedula
     * @param nombre
     * @param apellido
     * @param edad
     * @param especialidad
     */

    public Doctor(String cedula, String nombre, String apellido, int edad, Especialidad especialidad) {
        super(cedula, nombre, edad,apellido );
        this.especialidad = especialidad;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * Metodo que devuelve al objeto de Doctor.
     * @return Una cadena con la especialidad del doctor.
     */
    @Override
    public String toString() {
        return "Doctor{" +
                "especialidad=" + especialidad +
                '}';
    }
}
