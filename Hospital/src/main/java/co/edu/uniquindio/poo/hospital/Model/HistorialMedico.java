package co.edu.uniquindio.poo.hospital.Model;

import java.util.Collection;
import java.util.LinkedList;

public class HistorialMedico implements ClonableHistorialMedico {
    private String codigoHistorial;
    private Collection<Consulta> consultas;

    /**
     * Constructor de la clase HistorialMedico
     * @param codigoHistorial
     */

    public HistorialMedico(String codigoHistorial) {
        this.codigoHistorial = codigoHistorial;
        this.consultas = new LinkedList<>();
    }

    public String getCodigoHistorial() {
        return codigoHistorial;
    }

    public void setCodigoHistorial(String codigoHistorial) {
        this.codigoHistorial = codigoHistorial;
    }

    public Collection<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(Collection<Consulta> consultas) {
        this.consultas = consultas;
    }

    /**
     * metodo que permite obtenre el codigo de la consulta
     * @return
     */
    public String nombreConsultas() {
        if (this.consultas != null && !this.consultas.isEmpty()) {
            StringBuilder idsConcatenados = new StringBuilder();

            for (Consulta consulta : this.consultas) {
                idsConcatenados.append(consulta.getIdConsulta()).append("\n");
            }

            // Eliminar el último salto de línea sobrante
            if (idsConcatenados.length() > 0) {
                idsConcatenados.setLength(idsConcatenados.length() - 1); // Elimina "\n" al final
            }

            return idsConcatenados.toString();
        } else {
            return "Sin consultas";
        }
    }


    /**
     * Metodo que verifica la existencia de una consulta.
     * @param idConsulta
     * @return  true si el idConsulta de la consulta no existe en la lista; false si ya existe una consulta registrado con ese id en la lista.
     */
    public boolean verificarConsulta(String idConsulta) {
        for(Consulta consulta : consultas) {
            if (idConsulta.equals(consulta.getIdConsulta())) {
                return false;
            }
        }

        return true;
    }


    /**
     * Metodo que permite agregar una consulta a la lista verificando que no este duplicado.
     * @param Consulta
     * true si la consulta fue agregado exitosamente, false si la consulta ya existe.
     */
    public void agregarConsulta(Consulta Consulta) {
        boolean esUnico = this.verificarConsulta(Consulta.getIdConsulta());
        if (esUnico) {
            this.consultas.add(Consulta);
            System.out.println("Consulta agregado exitosamente");
        } else {
            System.out.println("Consulta ya existe");
        }

    }


    /**
     * Metodo que permite eliminar una consulta de la lista con su idConsulta.
     * @param idConsulta
     * @return true si la consulta fue eliminado exitosamente, false si no se encontró en la lista.
     */

    public void eliminarConsulta(String idConsulta) {
        for(Consulta Consulta : consultas) {
            if (Consulta.getIdConsulta().equals(idConsulta)) {
                consultas.remove(Consulta);
                System.out.println("Consulta eliminado exitosamente");
                break;
            }
        }

    }

    /**
     * Metodo que clona y devuelve una copia exacta del objeto "HistorialMedico".
     * @return  Una copia clonada del objeto HistorialMedico.
     */

    @Override
    public HistorialMedico clone() {
        try {
            return (HistorialMedico) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("El Historial Medico no puede ser Cloneable");
        }
    }

    /**
     * Metodo que devuelve al objeto de HistorialMedico.
     * @return Una cadena con el código del historial y la lista de consultas asociadas.
     */

    @Override
    public String toString() {
        return "HistorialMedico{" +
                "codigoHistorial='" + codigoHistorial + '\'' + ", consultas=" + consultas +
                '}';
    }
}
