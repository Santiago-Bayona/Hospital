package co.edu.uniquindio.poo.hospital.Model;

public class ConfiguracionHospital {
    private static ConfiguracionHospital instance;
    private String horarioAtencion;
    private int maxPacientes;
    private String reglasFacturacion;
    /**
     * Constructor privado para evitar la creación de instancias externas.
     * Inicializa la configuración con valores predeterminados.
     */
    private ConfiguracionHospital() {
        this.horarioAtencion = "7:00 AM - 7:00 PM";
        this.maxPacientes = 50;
        this.reglasFacturacion = "xxxxxxx";
    }

    /**
     * @return la instancia única de ConfiguracionHospital.
     */
    public static ConfiguracionHospital getInstance() {
        if (instance == null) {
            instance = new ConfiguracionHospital();
        }
        return instance;
    }

    /**
     * Establece una nueva instancia de ConfiguracionHospital.
     *
     * @param instance
     */
    public static void setInstance(ConfiguracionHospital instance) {
        ConfiguracionHospital.instance = instance;
    }

    /**
     * Obtiene el horario de atención del hospital.
     *
     * @return el horario de atención.
     */
    public String getHorarioAtencion() {
        return horarioAtencion;
    }

    public void setHorarioAtencion(String horarioAtencion) {
        this.horarioAtencion = horarioAtencion;
    }

    public int getMaxPacientes() {
        return maxPacientes;
    }

    public void setMaxPacientes(int maxPacientes) {
        this.maxPacientes = maxPacientes;
    }

    public String getReglasFacturacion() {
        return reglasFacturacion;
    }

    public void setReglasFacturacion(String reglasFacturacion) {
        this.reglasFacturacion = reglasFacturacion;
    }

    /**
     * Representación en cadena de la configuración del hospital.
     *
     * @return una cadena con los valores actuales de la configuración.
     */
    @Override
    public String toString() {
        return "ConfiguracionHospital{" +
                "horarioAtencion='" + horarioAtencion + '\'' +
                ", maxPacientes=" + maxPacientes +
                ", reglasFacturacion='" + reglasFacturacion + '\'' +
                '}';
    }
}



