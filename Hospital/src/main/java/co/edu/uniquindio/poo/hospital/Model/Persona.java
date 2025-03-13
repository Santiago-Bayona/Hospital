package co.edu.uniquindio.poo.hospital.Model;

public class Persona {
    private String cedula;
    private String nombre;
    private String telefono;
    private int edad;
    private String Apellido;

    /**
     * Constructor de la clase Persona.
     *
     * @param cedula   número de identificación de la persona.
     * @param nombre   nombre de la persona.
     * @param edad     edad de la persona.
     * @param Apellido apellido de la persona.
     */
    public Persona(String cedula, String nombre, int edad,String Apellido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.edad = edad;
        this.Apellido = Apellido;
    }


    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getApellido() {
        return Apellido;
    }

    public Persona setApellido(String apellido) {
        Apellido = apellido;
        return this;
    }

    /**
     * Representación en cadena de la persona.
     *
     * @return una cadena con los datos de la persona.
     */
    @Override
    public String toString() {
        return "Persona{" +
                "cedula=" + cedula +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", edad=" + edad +
                '}';
    }
}
