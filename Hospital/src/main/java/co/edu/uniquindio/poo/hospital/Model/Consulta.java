package co.edu.uniquindio.poo.hospital.Model;

import java.time.LocalDate;
import java.util.Locale;

public class Consulta {
    private String idConsulta;
    private LocalDate fechaConsulta;
    private String diagnosticoConsulta;
    private CitaMedica citaMedica;
    private  Medicamento medicamento;

    /**
     * Metodo Constructor
     * @param idConsulta
     * @param fechaConsulta
     * @param diagnosticoConsulta
     * @param citaMedica
     * @param medicamento
     */
    public Consulta(String idConsulta, LocalDate fechaConsulta, String diagnosticoConsulta, CitaMedica citaMedica , Medicamento medicamento) {
        this.idConsulta = idConsulta;
        this.fechaConsulta = fechaConsulta;
        this.diagnosticoConsulta = diagnosticoConsulta;
        this.citaMedica = citaMedica;
        this.medicamento = medicamento;
    }

    public String getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(String idConsulta) {
        this.idConsulta = idConsulta;
    }

    public LocalDate getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(LocalDate fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public String getDiagnosticoConsulta() {
        return diagnosticoConsulta;
    }

    public void setDiagnosticoConsulta(String diagnosticoConsulta) {
        this.diagnosticoConsulta = diagnosticoConsulta;
    }

    public CitaMedica getCitaMedica() {
        return citaMedica;
    }

    public void setCitaMedica(CitaMedica citaMedica) {
        this.citaMedica = citaMedica;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "idConsulta='" + idConsulta + '\'' +
                ", fechaConsulta=" + fechaConsulta +
                ", diagnosticoConsulta='" + diagnosticoConsulta + '\'' +
                ", citaMedica=" + citaMedica +
                ", medicamento=" + medicamento +
                '}';
    }
}
