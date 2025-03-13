package co.edu.uniquindio.poo.hospital.Model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;

public class Hospital {

    private ConfiguracionHospital configuracion;
    private String nombre;
    private Collection<Doctor> doctores;
    private Collection<Paciente> pacientes;
    private Collection<Medicamento> medicamentos;
    private Collection<Consulta> consultas;
    private Collection<HistorialMedico> historialMedicos;
    public Collection<CitaMedica> citaMedicas;

    /**
     * Constructor de la clase Hospital
     * @param nombre
     */
    public Hospital(String nombre) {
        this.nombre = nombre;
        this.doctores = new LinkedList<>();
        this.pacientes = new LinkedList<>();
        this.configuracion = ConfiguracionHospital.getInstance();
        this.medicamentos = new LinkedList<>();
        this.consultas = new LinkedList<>();
        this.historialMedicos = new LinkedList<>();
        this.citaMedicas = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Doctor> getDoctores() {
        return doctores;
    }

    public void setDoctores(Collection<Doctor> doctores) {
        this.doctores = doctores;
    }

    public Collection<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(Collection<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public Collection<Consulta> getConsultas() {
        return consultas;
    }

    public Hospital setConsultas(Collection<Consulta> consultas) {
        this.consultas = consultas;
        return this;
    }

    public Collection<HistorialMedico> getHistorialMedicos() {
        return historialMedicos;
    }

    public Hospital setHistorialMedicos(Collection<HistorialMedico> historialMedicos) {
        this.historialMedicos = historialMedicos;
        return this;
    }

    public Collection<CitaMedica> getCitaMedicas() {
        return citaMedicas;
    }

    public Hospital setCitaMedicas(Collection<CitaMedica> citaMedicas) {
        this.citaMedicas = citaMedicas;
        return this;
    }

    public Collection<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public Hospital setMedicamentos(Collection<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
        return this;
    }

    /**
     * Metodo que verifica la existencia de un paciente
     *
     * @param cedula
     * @return true si la cedula del paciente no existe en la lista; false si ya existe un paciente registrado con esa cedula en la lista.
     */
    public boolean verificarPaciente(String cedula) {
        for (Paciente paciente : pacientes) {
            if (cedula.equals(paciente.getCedula())) {
                return false;
            }
        }

        return true;
    }

    /**
     * Metodo que permite agregar pacientes a la lista verificando que no esten duplicados.
     *
     * @param paciente
     * @return true si el paciente fue agregado exitosamente, false si el paciente ya existe.
     */

    public boolean agregarPaciente(Paciente paciente) {
        boolean centinela = false;
        boolean esUnico = this.verificarPaciente(paciente.getCedula());
        if (esUnico) {
            pacientes.add(paciente);
            centinela = true;
            System.out.println("Paciente agregado exitosamente");
        } else {
            System.out.println("Paciente ya existe");
        }
        return centinela;

    }

    /**
     * Metodo que permite eliminar un paciente de la lista con su cedula.
     *
     * @param cedula
     * @return true si el paciente fue eliminado exitosamente, false si no se encontró en la lista.
     */

    public boolean eliminarPaciente(String cedula) {
        boolean centinela = false;
        for (Paciente paciente : pacientes) {
            if (paciente.getCedula().equals(cedula)) {
                pacientes.remove(paciente);
                centinela = true;
                System.out.println("Paciente eliminado exitosamente");
                break;
            }
        }
        return centinela;

    }

    /**
     * Metodo que permite actualizar un paciente de la lista pacientes con su cedula.
     *
     * @param cedula
     * @param actualizado
     * @return true si el paciente fue actualizado exitosamente, false si no se encontró en la lista.
     */

    public boolean actualizarPaciente(String cedula, Paciente actualizado) {
        boolean centinela = false;

        for (Paciente paciente : this.pacientes) {
            if (paciente.getCedula().equals(cedula)) {
                paciente.setCedula(actualizado.getCedula());
                paciente.setNombre(actualizado.getNombre());
                paciente.setApellido(actualizado.getApellido());
                paciente.setEdad(actualizado.getEdad());
                paciente.setHistorialMedico(actualizado.getHistorialMedico());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    /**
     * Metodo que verifica la existencia de un doctor
     *
     * @param cedula
     * @return true si la cedula del doctor no existe en la lista; false si ya existe un doctor registrado con esa cedula en la lista.
     */

    public boolean verificarDoctor(String cedula) {
        for (Doctor doctor : this.doctores) {
            if (cedula.equals(doctor.getCedula())) {
                return false;
            }
        }

        return true;
    }

    /**
     * Metodo que permite agregar un doctor a la lista verificando que no este duplicado.
     *
     * @param doctor
     * @return true si el doctor fue agregado exitosamente, false si el doctor ya existe.
     */

    public boolean agregarDoctor(Doctor doctor) {
        boolean centinela = false;
        boolean esUnico = this.verificarDoctor(doctor.getCedula());
        if (esUnico) {
            this.doctores.add(doctor);
            centinela = true;
            System.out.println("Doctor agregado exitosamente");
        } else {
            System.out.println("Doctor ya existe");
        }
        return centinela;
    }


    /**
     * Metodo que permite eliminar un doctor de la lista con su cedula.
     *
     * @param cedula
     * @return true si el doctor fue eliminado exitosamente, false si no se encontró en la lista.
     */

    public boolean eliminarDoctor(String cedula) {
        boolean centinela = false;
        for (Doctor doctor : this.doctores) {
            if (doctor.getCedula().equals(cedula)) {
                this.doctores.remove(doctor);
                centinela = true;
                System.out.println("Doctor eliminado exitosamente");
                break;
            }
        }
        return centinela;
    }


    /**
     * Metodo que permite actualizar un doctor de la lista doctores con su cedula.
     * @param cedula
     * @param actualizado
     * @return true si el doctor fue actualizado exitosamente, false si no se encontró en la lista.
     */

    public boolean actualizarDoctor(String cedula, Doctor actualizado) {
        boolean centinela = false;

        for(Doctor doctor : doctores) {
            if (doctor.getCedula().equals(cedula)) {
                doctor.setCedula(actualizado.getCedula());
                doctor.setNombre(actualizado.getNombre());
                doctor.setApellido(actualizado.getApellido());
                doctor.setEdad(actualizado.getEdad());
                doctor.setEspecialidad(actualizado.getEspecialidad());
                centinela = true;
                break;
            }
        }

        return centinela;
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
     * @param consulta
     * @return true si la consulta fue agregado exitosamente, false si la consulta ya existe.
     */

    public boolean agregarConsulta(Consulta consulta) {
        boolean centinela = false;
        boolean esUnico = this.verificarConsulta(consulta.getIdConsulta());
        if (esUnico) {
            consultas.add(consulta);
            centinela = true;
            System.out.println("La consulta fue agregada exitosamente");
        } else {
            System.out.println("Paciente ya existe");
        }
        return centinela;

    }


    /**
     * Metodo que permite eliminar una consulta de la lista con su idConsulta.
     * @param idConsulta
     * @return true si la consulta fue eliminado exitosamente, false si no se encontró en la lista.
     */

    public boolean eliminarConsulta(String idConsulta) {
        boolean centinela = false;
        for(Consulta consulta : this.consultas) {
            if (consulta.getIdConsulta().equals(idConsulta)) {
                this.consultas.remove(consulta);
                centinela = true;
                System.out.println("La consulta eliminada exitosamente");
                break;
            }
        }
        return centinela;
    }


    /**
     * Metodo que permite actualizar una consulta de la lista consultas con su idConsulta.
     * @param idConsulta
     * @param actualizado
     * @return true si la consulta fue actualizado exitosamente, false si no se encontró en la lista.
     */

    public boolean actualizarConsulta(String idConsulta, Consulta actualizado) {
        boolean centinela = false;

        for (Consulta consulta : this.consultas) {
            if (consulta.getIdConsulta().equals(idConsulta)) {
                consulta.setIdConsulta(actualizado.getIdConsulta());
                consulta.setFechaConsulta(actualizado.getFechaConsulta());
                consulta.setDiagnosticoConsulta(actualizado.getDiagnosticoConsulta());
                consulta.setCitaMedica(actualizado.getCitaMedica());
                consulta.setMedicamento(actualizado.getMedicamento());
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    /**
     * Metodo que verifica la existencia de un medicamento
     * @param idMedicamento
     * @return true si el idMedicamento del medicamento no existe en la lista; false si ya existe un medicamento registrado con ese id en la lista.
     */

    public boolean verificarMedicamento(String idMedicamento) {
        for(Medicamento Medicamento : medicamentos) {
            if (idMedicamento.equals(Medicamento.getIdMedicamento())) {
                return false;
            }
        }

        return true;
    }

    /**
     * Metodo que permite agregar un medicamento a la lista verificando que no este duplicado.
     * @param Medicamento
     * @return true si el medicamento fue agregado exitosamente, false si el medicamento ya existe.
     */

    public boolean agregarMedicamento(Medicamento Medicamento) {
        boolean centinela = false;
        boolean esUnico = this.verificarMedicamento(Medicamento.getIdMedicamento());
        if (esUnico) {
            medicamentos.add(Medicamento);
            centinela = true;
            System.out.println("Medicamento agregado exitosamente");
        } else {
            System.out.println("Medicamento ya existe");
        }
        return centinela;
    }


    /**
     * Metodo que permite eliminar un medicamento de la lista con su idMedicamento.
     * @param idMedicamento
     * @return true si el medicamento fue eliminado exitosamente, false si no se encontró en la lista.
     */
    public boolean eliminarMedicamento(String idMedicamento) {
        boolean centinela = false;
        for(Medicamento Medicamento : medicamentos) {
            if (Medicamento.getIdMedicamento().equals(idMedicamento)) {
                medicamentos.remove(Medicamento);
                centinela = true;
                System.out.println("Medicamento eliminado exitosamente");
                break;
            }
        }
        return centinela;
    }


    /**
     * Metodo que permite actualizar un medicamento de la lista medicamentos con su idMedicamento.
     * @param idMedicamento
     * @param actualizado
     * @return true si el medicamento fue actualizado exitosamente, false si no se encontró en la lista.
     */

    public boolean actualizarMedicamento(String idMedicamento, Medicamento actualizado) {
        boolean centinela = false;

        for(Medicamento medicamento : medicamentos) {
            if (medicamento.getIdMedicamento().equals(idMedicamento)) {
                medicamento.setIdMedicamento(actualizado.getIdMedicamento());
                medicamento.setNombreMedicamento(actualizado.getNombreMedicamento());
                medicamento.setDosis(actualizado.getDosis());
                centinela = true;
                break;
            }
        }

        return centinela;
    }


    /**
     * Metodo que verifica la existencia de un historial
     * @param idHistorial
     * @return true si el idHistorial del historial no existe en la lista; false si ya existe un historial registrado con ese id en la lista.
     */
    public boolean verificarHistorial(String idHistorial) {
        for(HistorialMedico historialMedico : historialMedicos) {
            if (idHistorial.equals(historialMedico.getCodigoHistorial())) {
                return false;
            }
        }

        return true;
    }

    /**
     * Metodo que permite agregar un historial a la lista verificando que no este duplicado.
     * @param Historial
     * @return true si el historial fue agregado exitosamente, false si el historial ya existe.
     */

    public boolean agregarHistorial(HistorialMedico Historial) {
        boolean centinela = false;
        boolean esUnico = this.verificarHistorial(Historial.getCodigoHistorial());
        if (esUnico) {
            historialMedicos.add(Historial);
            centinela = true;
            System.out.println("Historial agregado exitosamente");
        } else {
            System.out.println("Historial ya existe");
        }
        return centinela;
    }


    /**
     * Metodo que permite eliminar un historial de la lista con su idHistorial.
     * @param idHistorial
     * @return true si el historial fue eliminado exitosamente, false si no se encontró en la lista.
     */
    public boolean eliminarHistorial(String idHistorial) {

        boolean centinela = false;
        for(HistorialMedico Historial : historialMedicos) {
            if (Historial.getCodigoHistorial().equals(idHistorial)) {
                historialMedicos.remove(Historial);
                centinela = true;
                System.out.println("Historial eliminado exitosamente");
                break;
            }
        }
        return centinela;

    }


    /**
     * Metodo que permite actualizar un historial de la lista historiales con su codigoHistorial.
     * @param codigo
     * @param actualizado
     * @return true si el historial fue actualizado exitosamente, false si no se encontró en la lista.
     */

    public boolean actualizarHistorial(String codigo, HistorialMedico actualizado) {
        boolean centinela = false;

        for(HistorialMedico historialMedico : historialMedicos) {
            if (historialMedico.getCodigoHistorial().equals(codigo)) {
                historialMedico.setCodigoHistorial(actualizado.getCodigoHistorial());
                historialMedico.setConsultas(actualizado.getConsultas());
                centinela = true;
                break;
            }
        }

        return centinela;
    }


    /**
     * Metodo que verifica la existencia de una cita
     * @param codigoCita
     * @return true si el codigoCita de la cita no existe en la lista; false si ya existe una cita registrado con esa id en la lista.
     */

    public boolean verificarCita(String codigoCita) {
        for(CitaMedica citaMedica : citaMedicas) {
            if (codigoCita.equals(citaMedica.getCodigoCita())) {
                return false;
            }
        }

        return true;
    }

    /**
     * Metodo que permite reservar una cita medica.
     * @param citaMedica
     * @return true si la cita medica fue reservada exitosamente, false si la cita medica ya fue reservada.
     */

    public boolean reservarCita(CitaMedica citaMedica) {
        boolean centinela = false;
        boolean esUnico = this.verificarCita(citaMedica.getCodigoCita());
        if (esUnico) {
            this.citaMedicas.add(citaMedica);
            centinela = true;
            System.out.println("Cita resservada exitosamente");
        } else {
            System.out.println("La cita ya fue reservada ");
        }
        return centinela;

    }



    /**
     * Metodo que permite cancelar una cita de la lista con su codigoCita.
     * @param codigoCita
     * @return true si se cancelo la cita medica exitosamente, false si no se encontró en la lista.
     */
    public boolean cancelarCita(String codigoCita) {
        for(CitaMedica citaMedica : citaMedicas) {
            if (citaMedica.getCodigoCita().equals(codigoCita)) {
                citaMedicas.remove(citaMedica);
                System.out.println("Cita cancelada exitosamente");
                break;
            }
        }

        return false;
    }


    /**
     * Metodo que permite actualizar una cita de la lista citas con su idCita.
     * @param codigoCita
     * @param actualizado
     * @return true si la cita medica fue actualizado exitosamente, false si no se encontró en la lista.
     */
    public boolean actualizarCita(String codigoCita, CitaMedica actualizado) {
        boolean centinela = false;

        for(CitaMedica citaMedica : this.citaMedicas) {
            if (citaMedica.getCodigoCita().equals(codigoCita)) {
                citaMedica.setCodigoCita(actualizado.getCodigoCita());
                citaMedica.setFechaCita(actualizado.getFechaCita());
                citaMedica.setHoraCita(actualizado.getHoraCita());
                citaMedica.setDoctor(actualizado.getDoctor());
                citaMedica.setPaciente(actualizado.getPaciente());
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    /**
     * Metodo que verifica si el nombre de un paciente contiene vocales repetidas en el nombre.
     * @param cedula
     * @return true si el nombre del paciente tiene una vocal repetida, false en caso contrario o si el paciente no existe.
     */

    public boolean pacienteTieneVocalDoble(String cedula) {
        for (Paciente paciente : pacientes) {
            if (paciente.getCedula().equals(cedula)) {
                String nombre = paciente.getNombre().toLowerCase();
                boolean tieneDobleVocal = false;
                    for (int i = 0; i < nombre.length(); i++) {
                        char vocal = nombre.charAt(i);
                        if (vocal == 'a' || vocal == 'e' || vocal == 'i' || vocal == 'o' || vocal == 'u') {
                            for (int j = i + 1; j < nombre.length(); j++) {
                                if (nombre.charAt(j) == vocal) {
                                    tieneDobleVocal = true;
                                    break;
                                }
                            }
                        }
                        if (tieneDobleVocal) {
                            return true;
                        }
                    }
                    return false;
                }
            }
            return false;
        }

    /**
     * Lista los pacientes cuyo nombre es un palíndromo
     */

    public void listarPacientesPalindromos() {
        boolean hayPalindromos = false;
        for (Paciente paciente : pacientes) {
            String nombre = paciente.getNombre().toLowerCase().replaceAll(" ", "");
            int longitud = nombre.length();
            boolean esPalindromo = true;

            for (int i = 0; i < longitud / 2; i++) {
                if (nombre.charAt(i) != nombre.charAt(longitud - i - 1)) {
                    esPalindromo = false;
                    break;
                }
            }

            if (esPalindromo) {
                System.out.println("Paciente con nombre palíndromo: " + paciente.getNombre());
                hayPalindromos = true;
            }
        }

        if (!hayPalindromos) {
            System.out.println("No hay pacientes con nombres palíndromos.");
        }
    }


    /**
     * Metodo que lista todas las citas médicas programadas para una fecha específica.
     * @param fecha
     * Si hay citas programadas, se imprimen los detalles de cada una.
     * Si no hay citas en esa fecha, se imprime un mensaje indicándolo.
     */

    public void listarCitasPorFecha(LocalDate fecha) {
        System.out.println("Citas programadas para la fecha " + fecha + ":");
        boolean hayCitas = false;

        for (CitaMedica cita : citaMedicas) { // Se usa la colección correcta
            if (cita.getFechaCita().equals(fecha)) {
                System.out.println("Código: " + cita.getCodigoCita() +
                        ", Hora: " + cita.getHoraCita() +
                        ", Paciente: " + cita.getPaciente().getNombre() +
                        ", Doctor: " + cita.getDoctor().getNombre());
                hayCitas = true;
            }
        }

        if (!hayCitas) {
            System.out.println("No hay citas para esta fecha.");
        }
    }


    /**
     * Metodo que permite mostrar la configuración Global del hospital, incluyendo:
     * Horario de atención, máximo de pacientes permitidos y reglas de facturacion.
     */


    public void ajustarConfiguracionHospital(){
        System.out.println("El horario de atención del hospital es: "  + configuracion.getHorarioAtencion() + "Con un maximo de pacientes de :"
        + configuracion.getMaxPacientes() + "Y las reglas de facturacion son:" +configuracion.getReglasFacturacion());
    }


}
