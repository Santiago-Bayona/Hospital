package co.edu.uniquindio.poo.hospital.Model;

import java.time.LocalDate;

public class CitaMedica {
    private String codigoCita;
    private LocalDate fechaCita;
    private double horaCita;
    private Doctor doctor;
    private Paciente paciente;

    /**
     * Metodo Constructor
     * @param codigoCita
     * @param fechaCita
     * @param horaCita
     * @param doctor
     * @param paciente
     */
    public CitaMedica(String codigoCita, LocalDate fechaCita, double horaCita, Doctor doctor, Paciente paciente) {
        this.codigoCita = codigoCita;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.doctor = doctor;
        this.paciente = paciente;

    }

    public String getCodigoCita() {
        return codigoCita;
    }

    public void setCodigoCita(String codigoCita) {
        this.codigoCita = codigoCita;
    }

    public LocalDate getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
    }

    public double getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(double horaCita) {
        this.horaCita = horaCita;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "CitaMedica{" +
                "codigoCita='" + codigoCita + '\'' +
                ", fechaCita=" + fechaCita +
                ", horaCita=" + horaCita +
                ", doctor=" + doctor +
                ", paciente=" + paciente +
                '}';
    }
}

