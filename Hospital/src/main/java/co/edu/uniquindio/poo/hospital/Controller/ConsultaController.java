package co.edu.uniquindio.poo.hospital.Controller;

import co.edu.uniquindio.poo.hospital.Model.*;

import java.util.Collection;
import java.util.List;


public class ConsultaController {

    private Hospital hospital;

    /**
     *Metodo constructor de la clase
     * @param hospital
     */
    public ConsultaController(Hospital hospital) {
        this.hospital = hospital;
    }

    /**
     *Metodo que permite crear una consulta
     * @param Consulta
     * @return
     */
    public boolean crearConsulta(Consulta Consulta) {
        if (hospital == null) {
            System.err.println("Error: El Hospital no ha sido inicializada.");
            return false;
        }
        return hospital.agregarConsulta(Consulta);
    }


    /**
     *Metodo que permite obtener la lista de consultas
     * @return
     */
    public Collection<Consulta> ObtenerListaConsulta() {
        if (hospital == null) {
            System.err.println("Error: No se puede obtener la lista de consultas porque el hospital es null.");
            return null;
        }
        return hospital.getConsultas();
    }


    /**
     *Metodo que permite eliminar una consulta
     * @param idConsulta
     * @return
     */
    public boolean eliminarConsulta(String idConsulta) {
        if (hospital == null) {
            System.err.println("Error: No se puede eliminar la consulta ya que la hospital es null.");
            return false;
        }
        return hospital.eliminarConsulta(idConsulta);
    }


    /**
     *Metodo que permite actualizar una consulta
     * @param idConsulta
     * @param consulta
     * @return
     */
    public boolean actualizarConsulta(String idConsulta, Consulta consulta) {
        if (hospital == null) {
            System.err.println("Error: No se puede actualizar la consulta porque la hospital es null.");
            return false;
        }
        return hospital.actualizarConsulta(idConsulta, consulta);
    }

    /**
     *metodo que permite obtener la lista de citas medicas
     * @return
     */
    public Collection<CitaMedica> obtenerListaCitaMedica() {
        if (hospital == null) {

        }
        return hospital.getCitaMedicas();
    }

    /**
     *Metodo que peemite obtener la lista de medicamentos
     * @return
     */
    public Collection<Medicamento> obtenerListaMedicamento() {
        if (hospital == null) {

        }
        return hospital.getMedicamentos();
    }


}
