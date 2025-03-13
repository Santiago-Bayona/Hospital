package co.edu.uniquindio.poo.hospital.Model;

public class Paciente extends Persona {

    public HistorialMedico historialMedico;

    /**
     * Metodo Constructor
     * @param cedula
     * @param nombre
     * @param apellido
     * @param edad
     * @param historialMedico
     */
    public Paciente(String cedula, String nombre,String apellido, int edad, HistorialMedico historialMedico) {
        super(cedula, nombre, edad,apellido);
        this.historialMedico = historialMedico;
    }

    public HistorialMedico getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(HistorialMedico historialMedico) {
        this.historialMedico = historialMedico;
    }

    /**
     * metodo que permite mostrar la clase
     * @return la informacion de la clase
     */
    @Override
    public String toString() {
        return "Paciente{" + super.toString()+
                "historialMedico=" + historialMedico +
                '}';
    }
}
