package co.edu.uniquindio.poo.hospital.Controller;

import co.edu.uniquindio.poo.hospital.Model.*;

import java.util.Collection;

public class CitaMedicaController {

    private Hospital hospital;

    /**}
     * metodo constructor de la clase CitaMedicaController
     * @param hospital
     */
    public CitaMedicaController(Hospital hospital) {
        this.hospital = hospital;
    }

    /**
     * Metodo que permite crear una cita medica
     * @param CitaMedica
     * @return
     */
    public boolean crearCitaMedica(CitaMedica CitaMedica) {
        if (hospital == null) {
            System.err.println("Error: El Hospital no ha sido inicializada.");
            return false;
        }
        return hospital.reservarCita(CitaMedica);
    }


    /**
     * Metodo que permite obtener la lista de las citas medicas
     * @return
     */
    public Collection<CitaMedica> ObtenerListaCitaMedica() {
        if (hospital == null) {
            System.err.println("Error: No se puede obtener la lista de citas medicas porque el hospital es null.");
            return null;
        }
        return hospital.getCitaMedicas();
    }


    /**
     * Metodo que permite eliminar una cita
     * @param codigoCita
     * @return
     */
    public boolean eliminarCita(String codigoCita) {
        if (hospital == null) {
            System.err.println("Error: No se puede eliminar la cita ya que la hospital es null.");
            return false;
        }
        return hospital.cancelarCita(codigoCita);
    }


    /**
     * Metodo que permite actulizar los datos de una cita
     * @param codigoCita
     * @param citaMedica
     * @return
     */
    public boolean actualizarCita(String codigoCita, CitaMedica citaMedica) {
        if (hospital == null) {
            System.err.println("Error: No se puede actualizar la cita medica porque la hospital es null.");
            return false;
        }
        return hospital.actualizarCita(codigoCita, citaMedica);
    }

    /**
     * Metodo que permite obtener la lista de pacientes
     * @return
     */
    public Collection<Paciente> obtenerListaPaciente() {
        if (hospital == null) {

        }
        return hospital.getPacientes();
    }


    /**
     * Metodo que permite obtener la lista de doctores
     * @return
     */
    public Collection<Doctor> obtenerListaDoctor() {
        if (hospital == null) {

        }
        return hospital.getDoctores();
    }


}
