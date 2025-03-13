package co.edu.uniquindio.poo.hospital.Model;

public interface ClonableHistorialMedico extends Cloneable{
    /**
     * Clona el historial médico actual.
     *
     * @return una copia del historial médico.
     */
    HistorialMedico clone();
}
