package co.edu.uniquindio.poo.hospital.Controller;

import co.edu.uniquindio.poo.hospital.Model.Consulta;
import co.edu.uniquindio.poo.hospital.Model.HistorialMedico;
import co.edu.uniquindio.poo.hospital.Model.Hospital;
import co.edu.uniquindio.poo.hospital.Model.Paciente;

import java.util.Collection;
import java.util.Optional;

public class HistorialMedicoController {
    private Hospital hospital;

    /**
     * Constructor de la clase HistorialMedicoController.
     *
     * @param hospital instancia del hospital donde se gestionan los historiales médicos.
     */
    public HistorialMedicoController(Hospital hospital) {
        this.hospital = hospital;
    }

    /**
     * Crea y agrega un nuevo historial médico al hospital.
     *
     * @param HistorialMedico historial médico a agregar.
     * @return true si se agregó correctamente, false en caso contrario.
     */
    public boolean crearHistorial(HistorialMedico HistorialMedico) {
        if (hospital == null) {
            System.err.println("Error: El Hospital no ha sido inicializada.");
            return false;
        }
        return hospital.agregarHistorial(HistorialMedico);
    }

    /**
     * Obtiene la lista de todos los historiales médicos registrados en el hospital.
     *
     * @return colección de historiales médicos o null si el hospital no está inicializado.
     */
    public Collection<HistorialMedico> ObtnerListaHistorial() {
        if (hospital == null) {
            System.err.println("Error: No se puede obtener la lista de pacientes porque la hospital es null.");
            return null;
        }
        return hospital.getHistorialMedicos();
    }

    /**
     * Elimina un historial médico del hospital.
     *
     * @param codigo código del historial médico a eliminar.
     * @return true si se eliminó correctamente, false en caso contrario.
     */
    public boolean eliminarHistorial(String codigo) {
        if (hospital == null) {
            System.err.println("Error: No se puede eliminar Doctor ya que la hospital es null.");
            return false;
        }
        return hospital.eliminarHistorial(codigo);
    }

    /**
     * Actualiza un historial médico en el hospital.
     *
     * @param codigo código del historial médico a actualizar.
     * @param historialMedico nuevo historial médico con los datos actualizados.
     * @return true si se actualizó correctamente, false en caso contrario.
     */
    public boolean actualizarHistorial(String codigo, HistorialMedico historialMedico) {
        if (hospital == null) {
            System.err.println("Error: No se puede actualizar Doctor porque la hospital es null.");
            return false;
        }
        return hospital.actualizarHistorial(codigo, historialMedico);
    }

    /**
     * Obtiene la lista de consultas registradas en el hospital.
     *
     * @return colección de consultas o null si el hospital no está inicializado.
     */
    public Collection<Consulta> obtenerListaConsulta(){
        if (hospital == null) {

        }
        return hospital.getConsultas();
    }

    /**
     * Clona un historial médico y lo agrega al hospital.
     *
     * @param historial historial médico a clonar.
     * @return true si el historial clonado fue agregado correctamente, false en caso contrario.
     */
    public boolean clonarHistorial(HistorialMedico historial) {
        if (historial == null) {
            System.err.println("Error: No se puede clonar un historial médico nulo.");
            return false;
        }
        HistorialMedico historialClonado = historial.clone();
        return hospital.agregarHistorial(historialClonado);
    }
}
