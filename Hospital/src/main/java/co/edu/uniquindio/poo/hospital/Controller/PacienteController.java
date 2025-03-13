package co.edu.uniquindio.poo.hospital.Controller;

import co.edu.uniquindio.poo.hospital.Model.Doctor;
import co.edu.uniquindio.poo.hospital.Model.HistorialMedico;
import co.edu.uniquindio.poo.hospital.Model.Hospital;
import co.edu.uniquindio.poo.hospital.Model.Paciente;

import java.util.Collection;

public class PacienteController {
    private Hospital hospital;

    /**
     * metodo constructor de la clase
     * @param hospital
     */
    public PacienteController(Hospital hospital) {
        this.hospital = hospital;
    }

    /**
     *Metodo que permite crear un paciente
     * @param Paciente
     * @return
     */
    public boolean crearPaciente(Paciente Paciente) {
        if (hospital == null) {
            System.err.println("Error: El Hospital no ha sido inicializada.");
            return false;
        }
        return hospital.agregarPaciente(Paciente);
    }

    /**
     *Metodo que permite obtener la lista de pacientes
     * @return
     */
    public Collection<Paciente> ObtenerListaPaciente() {
        if (hospital == null) {
            System.err.println("Error: No se puede obtener la lista de pacientes porque la hospital es null.");
            return null;
        }
        return hospital.getPacientes();
    }

    /**
     *Metodo que permite eliminar una cita
     * @param cedula
     * @return
     */
    public boolean eliminarPaciente(String cedula) {
        if (hospital == null) {
            System.err.println("Error: No se puede eliminar Doctor ya que la hospital es null.");
            return false;
        }
        return hospital.eliminarPaciente(cedula);
    }

    /**
     *Metodo que permite actualizar un paciente
     * @param cedula
     * @param paciente
     * @return
     */
    public boolean actualizarPaciente(String cedula, Paciente paciente) {
        if (hospital == null) {
            System.err.println("Error: No se puede actualizar Doctor porque la hospital es null.");
            return false;
        }
        return hospital.actualizarPaciente(cedula, paciente);
    }

    /**
     *metodo que permite obtener la lista de historial medico
     * @return
     */
    public Collection<HistorialMedico> obtenerListaHistorial(){
        if (hospital == null) {

        }
        return hospital.getHistorialMedicos();
    }
}
