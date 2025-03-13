package co.edu.uniquindio.poo.hospital.ViewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.hospital.App;
import co.edu.uniquindio.poo.hospital.Controller.DoctorController;
import co.edu.uniquindio.poo.hospital.Model.Doctor;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Material;

public class DoctorVC {
    App app;
    DoctorController doctorController;
    ObservableList<Doctor> listaDoctor = FXCollections.observableArrayList();
    Doctor selectedDoctor;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btt_Eliminar;

    @FXML
    private TableColumn<Doctor, String> tbc_Cedula;

    @FXML
    private TextField txt_Nombre;

    @FXML
    private Button btt_Actualizar;

    @FXML
    private TableView<Doctor> tb_Doctor;

    @FXML
    private TextField txt_Apellido;

    @FXML
    private TextField txt_Edad;

    @FXML
    private TextField txt_Cedula;

    @FXML
    private Button Volver;

    @FXML
    private Button btt_Agregar;

    @FXML
    private TableColumn<Doctor, String> tbc_Apellido;

    @FXML
    private TableColumn<Doctor, String> tbc_Nombre;

    @FXML
    private TableColumn<Doctor, Integer> tbc_Edad;

    @FXML
    private TableColumn<Doctor, String> tbc_Especialidad;

    @FXML
    private ComboBox<Doctor.Especialidad> cmbx_Especialidad;

    @FXML
    private Button btt_Limpiar;


    /**
     * Metodo que permite agregar un nuevo doctor
     * @param event
     */

    @FXML
    void AgregarDoctor(ActionEvent event) {
        agergarDoctor();
    }


    /**
     * Metodo que permite volver al menu principal.
     * @param event
     */

    @FXML
    void Volver(ActionEvent event) {
        try {
            app.MenuPersona();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que permite actualizar un doctor seleccionado.
     * @param event
     */

    @FXML
    void ActualizarDoctor(ActionEvent event) {
        actualizarDoctor();
    }

    /**
     * Metodo que permite eliminar un doctor seleccionado.
     * @param event
     */

    @FXML
    void EliminarDoctor(ActionEvent event) {
        eliminarDoctor();
    }

    /**
     * Metodo que permite limpiar los campos del formulario.
     * @param event
     */

    @FXML
    void LimpiarDoctor(ActionEvent event) {
        limpiarCamposDoctor();
    }


    /**
     * Método de inicialización de la vista.
     */

    @FXML
    void initialize() {
        assert btt_Eliminar != null : "fx:id=\"btt_Eliminar\" was not injected: check your FXML file 'Doctor.fxml'.";
        assert tbc_Cedula != null : "fx:id=\"tbc_Cedula\" was not injected: check your FXML file 'Doctor.fxml'.";
        assert txt_Nombre != null : "fx:id=\"txt_Nombre\" was not injected: check your FXML file 'Doctor.fxml'.";
        assert btt_Actualizar != null : "fx:id=\"btt_Actualizar\" was not injected: check your FXML file 'Doctor.fxml'.";
        assert tb_Doctor != null : "fx:id=\"tb_Doctor\" was not injected: check your FXML file 'Doctor.fxml'.";
        assert txt_Apellido != null : "fx:id=\"txt_Apellido\" was not injected: check your FXML file 'Doctor.fxml'.";
        assert txt_Edad != null : "fx:id=\"txt_Edad\" was not injected: check your FXML file 'Doctor.fxml'.";
        assert txt_Cedula != null : "fx:id=\"txt_Cedula\" was not injected: check your FXML file 'Doctor.fxml'.";
        assert btt_Agregar != null : "fx:id=\"btt_Agregar\" was not injected: check your FXML file 'Doctor.fxml'.";
        assert tbc_Apellido != null : "fx:id=\"tbc_Apellido\" was not injected: check your FXML file 'Doctor.fxml'.";
        assert tbc_Nombre != null : "fx:id=\"tbc_Nombre\" was not injected: check your FXML file 'Doctor.fxml'.";
        assert tbc_Edad != null : "fx:id=\"tbc_Edad\" was not injected: check your FXML file 'Doctor.fxml'.";
        assert tbc_Especialidad != null : "fx:id=\"tbc_Especialidad\" was not injected: check your FXML file 'Doctor.fxml'.";
        assert cmbx_Especialidad != null : "fx:id=\"cmbx_Especialidad\" was not injected: check your FXML file 'Doctor.fxml'.";
        assert btt_Limpiar != null : "fx:id=\"btt_Limpiar\" was not injected: check your FXML file 'Doctor.fxml'.";
        assert Volver != null : "fx:id=\"btt_Limpiar\" was not injected: check your FXML file 'Paciente.fxml'.";

        if (App.hospital == null) {
            System.err.println("No se puede agregar el hospital");
            return;
        }

        doctorController = new DoctorController(App.hospital);
        initView();

    }

    /**
     * Metodo que inicializa la vista con los datos cargados.
     */

    private void initView() {

        initDataBinding();
        obtenerDoctor();
        tb_Doctor.getItems().clear();

        // Agregar los elementos a la tabla
        tb_Doctor.setItems(listaDoctor);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    /**
     * Método que configura el enlace entre los datos y la vista.
     */

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private void initDataBinding() {
        tbc_Nombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbc_Apellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        tbc_Cedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tbc_Edad.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEdad()));
        tbc_Especialidad.setCellValueFactory(celldata -> {
            Doctor.Especialidad especialidad = celldata.getValue().getEspecialidad();
            String espacialidadString = (especialidad != null) ? especialidad.toString() : "Sin Tipo";
            return new SimpleStringProperty(espacialidadString);
        });

    }

    /**
     * Metodo que obtiene la lista de doctores del sistema.
     */

    private void obtenerDoctor() {
        if (doctorController != null) {
            listaDoctor.addAll(doctorController.ObtenerListaDoctor());
        } else {
            System.err.println("doctorController no está inicializado.");
        }
    }

    /**
     * Método que configura un listener para la selección de elementos en la tabla de doctores.
     */

    private void listenerSelection() {
        tb_Doctor.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedDoctor = newSelection;
            mostrarInformacionDoctor(selectedDoctor);
        });
    }

    /**
     * Metodo que muestra la información del doctor  seleccionado en el campo de texto.
     * @param doctor
     */

    private void mostrarInformacionDoctor(Doctor doctor) {
        if (doctor != null) {
            // Asignar valores a los campos de texto
            txt_Nombre.setText(doctor.getNombre());
            txt_Apellido.setText(doctor.getApellido());
            txt_Cedula.setText(doctor.getCedula());
            txt_Edad.setText(String.valueOf(doctor.getEdad()));
            cmbx_Especialidad.getSelectionModel().select(doctor.getEspecialidad());
        }
    }

    /**
     * Metodo que agrega un nuevo doctor a la lista y lo almacena en el controlador.
     * Se crea un nuevo doctor a partir de los datos ingresados y se añade a la lista si la operación es exitosa.
     */

    private void agergarDoctor() {
        Doctor doctor = buildDoctor();
        if(doctorController.crearDoctor(doctor)){
            listaDoctor.add(doctor);
            limpiarCamposDoctor();
        }
    }

    /**
     * Metodo que construye un objeto de tipo doctor con la información ingresada.
     * @return Un objeto Doctor con el código ingresado en el campo de texto.
     */

    private Doctor buildDoctor() {
        int edad = Integer.parseInt(txt_Edad.getText());
        Doctor doctor = new Doctor(
                txt_Cedula.getText(),
                txt_Nombre.getText(),
                txt_Apellido.getText(),
                edad,
                cmbx_Especialidad.getValue()
        );
        return doctor;
    }


    /**
     * Metodo que elimina el doctor seleccionado de la lista y del controlador.
     * Si la eliminación es exitosa, también se eliminan los datos de la tabla y se limpian los campos de entrada.
     */

    private void eliminarDoctor() {
        if (doctorController.eliminarDoctor(txt_Cedula.getText())) {
            listaDoctor.remove(selectedDoctor);
            limpiarCamposDoctor();
            limpiarSeleccion();
        }
    }

    /**
     * Metodo que actualiza la información del doctor seleccionado.
     * Si el Doctor se encuentra en la lista y la actualización es exitosa,
     * se reemplaza por el nuevo objeto actualizado y se refresca la tabla.
     */

    private void actualizarDoctor() {

        if (selectedDoctor != null &&
                doctorController.actualizarDoctor(selectedDoctor.getCedula(), buildDoctor())) {

            int index = listaDoctor.indexOf(selectedDoctor);
            if (index >= 0) {
                listaDoctor.set(index, buildDoctor());
            }

            tb_Doctor.refresh();
            limpiarSeleccion();
            limpiarCamposDoctor();
        }
    }

    /**
     * Metodo que limpia la selección de la tabla de doctor y los campos de entrada.
     */
    private void limpiarSeleccion() {
        tb_Doctor.getSelectionModel().clearSelection();
        limpiarCamposDoctor();
    }

    /**
     * Metodo que limpia los campos de entrada y la selección de la tabla de Doctor.
     */
    private void limpiarCamposDoctor() {
        txt_Nombre.clear();
        txt_Cedula.clear();
        txt_Edad.clear();
        txt_Apellido.clear();
        cmbx_Especialidad.setValue(null);
    }

    /**
     * Establece la instancia de la aplicación para acceder a sus métodos.
     * @param app
     */

    public void setApp(App app) {
        this.app = app;

        /**
         * Metodo que inicializa la comboBox con las opciones de la especialidad del objeto Doctor
         */

        ObservableList<Doctor.Especialidad> options = FXCollections.observableArrayList(Doctor.Especialidad.values());
        cmbx_Especialidad.setItems((options));
    }
}


