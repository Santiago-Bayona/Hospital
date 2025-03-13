package co.edu.uniquindio.poo.hospital.Controller;

import co.edu.uniquindio.poo.hospital.Model.Hospital;
import co.edu.uniquindio.poo.hospital.Model.Medicamento;

import java.util.Collection;

public class MedicamentoController {
    private Hospital hospital;

    /**
     * Constructor de la clase MedicamentoController.
     *
     * @param hospital instancia del hospital donde se gestionan los medicamentos.
     */
    public MedicamentoController(Hospital hospital) {
        this.hospital = hospital;
    }

    /**
     * Crea y agrega un nuevo medicamento al hospital.
     *
     * @param medicamento medicamento a agregar.
     * @return true si se agregó correctamente, false en caso contrario.
     */
    public boolean crearMedicamento(Medicamento medicamento) {
        if (hospital == null) {
            System.err.println("Error: El Hospital no ha sido inicializado.");
            return false;
        }
        return hospital.agregarMedicamento(medicamento);
    }

    /**
     * Obtiene la lista de todos los medicamentos registrados en el hospital.
     *
     * @return colección de medicamentos o null si el hospital no está inicializado.
     */
    public Collection<Medicamento> obtenerListaMedicamentos() {
        if (hospital == null) {
            System.err.println("Error: No se puede obtener la lista de medicamentos porque el hospital es null.");
            return null;
        }
        return hospital.getMedicamentos();
    }

    /**
     * Elimina un medicamento del hospital.
     *
     * @param id identificador del medicamento a eliminar.
     * @return true si se eliminó correctamente, false en caso contrario.
     */
    public boolean eliminarMedicamento(String id) {
        if (hospital == null) {
            System.err.println("Error: No se puede eliminar el medicamento ya que el hospital es null.");
            return false;
        }
        return hospital.eliminarMedicamento(id);
    }

    /**
     * Actualiza un medicamento en el hospital.
     *
     * @param id identificador del medicamento a actualizar.
     * @param medicamento nuevo medicamento con los datos actualizados.
     * @return true si se actualizó correctamente, false en caso contrario.
     */
    public boolean actualizarMedicamento(String id, Medicamento medicamento) {
        if (hospital == null) {
            System.err.println("Error: No se puede actualizar el medicamento porque el hospital es null.");
            return false;
        }
        return hospital.actualizarMedicamento(id, medicamento);
    }
}