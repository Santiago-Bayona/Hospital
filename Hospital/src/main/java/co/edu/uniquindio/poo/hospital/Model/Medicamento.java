package co.edu.uniquindio.poo.hospital.Model;

public class Medicamento {
    private String idMedicamento;
    private String nombreMedicamento;
    private double dosis;

    /**
     * Constructor de la clase Medicamento.
     *
     * @param idMedicamento     identificador único del medicamento.
     * @param nombreMedicamento nombre del medicamento.
     * @param dosis             dosis recomendada del medicamento.
     */
    public Medicamento(String idMedicamento, String nombreMedicamento, double dosis) {
        this.idMedicamento = idMedicamento;
        this.nombreMedicamento = nombreMedicamento;
        this.dosis = dosis;
    }

    public String getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(String idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public double getDosis() {
        return dosis;
    }

    public void setDosis(double dosis) {
        this.dosis = dosis;
    }

    /**
     * Representación en cadena del medicamento.
     *
     * @return una cadena con los datos del medicamento.
     */
    @Override
    public String toString() {
        return "Medicamento{" +
                "idMedicamento='" + idMedicamento + '\'' +
                ", nombreMedicamento='" + nombreMedicamento + '\'' +
                ", dosis=" + dosis +
                '}';
    }
}
