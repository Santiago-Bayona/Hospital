package co.edu.uniquindio.poo.hospital.Controller;

import co.edu.uniquindio.poo.hospital.Model.Doctor;
import co.edu.uniquindio.poo.hospital.Model.Hospital;

import java.util.Collection;

public class DoctorController {
    private Hospital hospital;

    public DoctorController(Hospital hospital) {
        this.hospital = hospital;
    }

    /**
     * Metodo que agrega un nuevo doctor al hospital.
     * @param doctor
     * @return true si el doctor fue agregado con éxito, false en caso de error.
     *
     */

    public boolean crearDoctor(Doctor doctor) {
        if (hospital == null) {
            System.err.println("Error: El Hospital no ha sido inicializada.");
            return false;
        }
        return hospital.agregarDoctor(doctor);
    }

    /**
     * Metodo que obtiene la lista de doctores registrados en el hospital.
     * @return Una colección de objetos Doctor si el hospital está inicializado.
     */

    public Collection<Doctor> ObtenerListaDoctor() {
        if (hospital == null) {
            System.err.println("Error: No se puede obtener la lista de doctores porque la hospital es null.");
            return null;
        }
        return hospital.getDoctores();
    }

    /**
     * Metodo que elimina un doctor del hospital según su cédula.
     * @param cedula
     * @return true si el doctor fue eliminado con éxito, false en caso de error.
     */

    public boolean eliminarDoctor(String cedula) {
        if (hospital == null) {
            System.err.println("Error: No se puede eliminar Doctor ya que la hospital es null.");
            return false;
        }
        return hospital.eliminarDoctor(cedula);
    }

    /**
     * Metodo que permite actualizar un doctor según su cedula.
     * @param cedula
     * @param Doctor
     * @return true si el doctor fue actualizado con éxito, false en caso de error.
     */
    public boolean actualizarDoctor(String cedula, Doctor Doctor) {
        if (hospital == null) {
            System.err.println("Error: No se puede actualizar Doctor porque la hospital es null.");
            return false;
        }
        return hospital.actualizarDoctor(cedula, Doctor);
    }
    
}
