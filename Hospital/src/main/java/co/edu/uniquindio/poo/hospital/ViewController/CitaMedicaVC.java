package co.edu.uniquindio.poo.hospital.ViewController;

import java.net.URL;
import java.time.LocalDate;
import java.util.Collection;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.hospital.App;
import co.edu.uniquindio.poo.hospital.Controller.CitaMedicaController;
import co.edu.uniquindio.poo.hospital.Controller.PacienteController;
import co.edu.uniquindio.poo.hospital.Model.CitaMedica;
import co.edu.uniquindio.poo.hospital.Model.Doctor;
import co.edu.uniquindio.poo.hospital.Model.HistorialMedico;
import co.edu.uniquindio.poo.hospital.Model.Paciente;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;



public class CitaMedicaVC {

    private App app;
    CitaMedicaController citaMedicaController;
    private ObservableList<CitaMedica> listaCitaMedica = FXCollections.observableArrayList();
    private ObservableList<Paciente> listaPaciente = FXCollections.observableArrayList();
    private ObservableList<Doctor> listaDoctor = FXCollections.observableArrayList();
    private CitaMedica selectedCitaMedica;
    private Paciente selectedPaciente;
    private Doctor selectedDoctor;




    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btt_Eliminar"
    private Button btt_Eliminar; // Value injected by FXMLLoader

    @FXML // fx:id="tbc_cedulaPaciente"
    private TableColumn<Paciente, String> tbc_cedulaPaciente; // Value injected by FXMLLoader

    @FXML // fx:id="btt_Actualizar"
    private Button btt_Actualizar; // Value injected by FXMLLoader

    @FXML // fx:id="tb_Paciente"
    private TableView<Paciente> tb_Paciente; // Value injected by FXMLLoader

    @FXML // fx:id="tb_Doctor"
    private TableView<Doctor> tb_Doctor; // Value injected by FXMLLoader

    @FXML // fx:id="tbc_HoraCita"
    private TableColumn<CitaMedica, Double> tbc_HoraCita; // Value injected by FXMLLoader

    @FXML // fx:id="tb_CitaMedica"
    private TableView<CitaMedica> tb_CitaMedica; // Value injected by FXMLLoader

    @FXML // fx:id="date_Cita"
    private DatePicker date_Cita; // Value injected by FXMLLoader

    @FXML // fx:id="tbc_FechaCita"
    private TableColumn<CitaMedica, LocalDate> tbc_FechaCita; // Value injected by FXMLLoader

    @FXML // fx:id="tbc_nombre"
    private TableColumn<CitaMedica, String> tbc_nombre; // Value injected by FXMLLoader

    @FXML // fx:id="btt_Agregar"
    private Button btt_Agregar; // Value injected by FXMLLoader

    @FXML // fx:id="tbc_nombreDoctor"
    private TableColumn<Doctor, String> tbc_nombreDoctor; // Value injected by FXMLLoader

    @FXML // fx:id="txt_CodigoCita"
    private TextField txt_CodigoCita; // Value injected by FXMLLoader

    @FXML // fx:id="tbc_CodigoCita"
    private TableColumn<CitaMedica, String> tbc_CodigoCita; // Value injected by FXMLLoader

    @FXML // fx:id="tbc_nombrePaciente"
    private TableColumn<Paciente, String> tbc_nombrePaciente; // Value injected by FXMLLoader

    @FXML // fx:id="btt_Limpiar"
    private Button btt_Limpiar; // Value injected by FXMLLoader

    @FXML // fx:id="txt_HoraCita"
    private TextField txt_HoraCita; // Value injected by FXMLLoader

    @FXML // fx:id="tbc_cedula"
    private TableColumn<CitaMedica, String> tbc_cedula; // Value injected by FXMLLoader

    @FXML // fx:id="tbc_cedulaDoctor"
    private TableColumn<Doctor, String> tbc_cedulaDoctor; // Value injected by FXMLLoader

    @FXML // fx:id="Volver"
    private Button Volver; // Value injected by FXMLLoader


    /**
     * Metodo que abre el menu de procedimiento
     * @param event
     */
    @FXML
    void Volver(ActionEvent event) {
        try {
            app.MenuProcedimiento();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Metodo que hace fucnionar el boton de agregar
     * @param event
     */
    @FXML
    void AgregarCita(ActionEvent event) {
        agregarCita();
    }

    /**
     * Metodo que hace fucnionar el boton de actualizar
     * @param event
     */
    @FXML
    void ActualizarCita(ActionEvent event) {
        actualizarCita();
    }

    /**
     * Metodo que hace fucnionar el boton de eliminar
     * @param event
     */
    @FXML
    void EliminarCita(ActionEvent event) {
        eliminarCita();
    }

    /**
     * Metodo que hace fucnionar el boton de Limpiar
     * @param event
     */
    @FXML
    void LimpiarCita(ActionEvent event) {
        limpiarCamposCita();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btt_Eliminar != null : "fx:id=\"btt_Eliminar\" was not injected: check your FXML file 'CitaMedica.fxml'.";
        assert tbc_cedulaPaciente != null : "fx:id=\"tbc_cedulaPaciente\" was not injected: check your FXML file 'CitaMedica.fxml'.";
        assert btt_Actualizar != null : "fx:id=\"btt_Actualizar\" was not injected: check your FXML file 'CitaMedica.fxml'.";
        assert tb_Paciente != null : "fx:id=\"tb_Paciente\" was not injected: check your FXML file 'CitaMedica.fxml'.";
        assert tb_Doctor != null : "fx:id=\"tb_Doctor\" was not injected: check your FXML file 'CitaMedica.fxml'.";
        assert tbc_HoraCita != null : "fx:id=\"tbc_HoraCita\" was not injected: check your FXML file 'CitaMedica.fxml'.";
        assert tb_CitaMedica != null : "fx:id=\"tb_CitaMedica\" was not injected: check your FXML file 'CitaMedica.fxml'.";
        assert date_Cita != null : "fx:id=\"date_Cita\" was not injected: check your FXML file 'CitaMedica.fxml'.";
        assert tbc_FechaCita != null : "fx:id=\"tbc_FechaCita\" was not injected: check your FXML file 'CitaMedica.fxml'.";
        assert tbc_nombre != null : "fx:id=\"tbc_nombre\" was not injected: check your FXML file 'CitaMedica.fxml'.";
        assert btt_Agregar != null : "fx:id=\"btt_Agregar\" was not injected: check your FXML file 'CitaMedica.fxml'.";
        assert tbc_nombreDoctor != null : "fx:id=\"tbc_nombreDoctor\" was not injected: check your FXML file 'CitaMedica.fxml'.";
        assert txt_CodigoCita != null : "fx:id=\"txt_CodigoCita\" was not injected: check your FXML file 'CitaMedica.fxml'.";
        assert tbc_CodigoCita != null : "fx:id=\"tbc_CodigoCita\" was not injected: check your FXML file 'CitaMedica.fxml'.";
        assert tbc_nombrePaciente != null : "fx:id=\"tbc_nombrePaciente\" was not injected: check your FXML file 'CitaMedica.fxml'.";
        assert btt_Limpiar != null : "fx:id=\"btt_Limpiar\" was not injected: check your FXML file 'CitaMedica.fxml'.";
        assert txt_HoraCita != null : "fx:id=\"txt_HoraCita\" was not injected: check your FXML file 'CitaMedica.fxml'.";
        assert tbc_cedula != null : "fx:id=\"tbc_cedula\" was not injected: check your FXML file 'CitaMedica.fxml'.";
        assert tbc_cedulaDoctor != null : "fx:id=\"tbc_cedulaDoctor\" was not injected: check your FXML file 'CitaMedica.fxml'.";
        assert Volver != null : "fx:id=\"Volver\" was not injected: check your FXML file 'CitaMedica.fxml'.";

        citaMedicaController=new CitaMedicaController(App.hospital);
        ObtenerDoctor();
        obtenerCitaMedica();
        ObtenerPaciente();
        initView();
    }

    /**
     * Metodo que permite obtener los datos de doctor
     */
    private void ObtenerDoctor() {
        if (listaDoctor == null) {
            listaDoctor = FXCollections.observableArrayList();
        }

        Collection<Doctor> doctores = citaMedicaController.obtenerListaDoctor();
        if (doctores != null) {
            listaDoctor.setAll(doctores);
        } else {
            System.out.println("No se encontraron doctores.");
        }
    }

    /**
     * metdo que permite obtener los datos de paciente
     */
    private void ObtenerPaciente() {
        if (listaPaciente == null) {
            listaPaciente = FXCollections.observableArrayList();
        }

        Collection<Paciente> pacientes = citaMedicaController.obtenerListaPaciente();
        if (pacientes != null) {
            listaPaciente.setAll(pacientes);
        } else {
            System.out.println("No se encontraron pacientes.");
        }
    }

    /**
     * Metodo que permite obtener los datos de cita medica
     */
    private void obtenerCitaMedica() {
        if (citaMedicaController != null) {
            listaCitaMedica.addAll(citaMedicaController.ObtenerListaCitaMedica());
        } else {
            System.err.println("citaMedicaController no está inicializado.");
        }
    }

    /**
     *Metodo que inicializa la vista en javaFX
     */
    private void initView() {
        initDataBinding();
        obtenerCitaMedica();
        tb_CitaMedica.getItems().clear();
        tb_CitaMedica.setItems(listaCitaMedica);
        tb_Paciente.setItems(listaPaciente);
        tb_Doctor.setItems(listaDoctor);
        listenerSelectionCitaMedica();
        listenerSelectionPaciente();
        listenerSelectionDoctor();
    }

    /**
     *Metodo que configura la vinculacion de datos en las tablas
     */
    private void initDataBinding() {
        tbc_CodigoCita.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigoCita()));
        tbc_FechaCita.setCellValueFactory(new PropertyValueFactory<>("fechaCita"));
        tbc_HoraCita.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getHoraCita()));
        tbc_nombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDoctor() != null ? cellData.getValue().getDoctor().getNombre() : cellData.getValue().getPaciente().getNombre()));
        tbc_cedula.setCellValueFactory(cellData ->  new SimpleStringProperty(cellData.getValue().getDoctor() != null ? cellData.getValue().getDoctor().getCedula() : cellData.getValue().getPaciente().getCedula()));
        tbc_nombrePaciente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbc_cedulaPaciente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tbc_nombreDoctor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbc_cedulaDoctor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
    }

    /**
     * metodo que escucha los cambios en la selecion de citas medicas y actauliza la variable selectedCitaMedica
     */
    private void listenerSelectionCitaMedica() {
        tb_CitaMedica.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedCitaMedica = newSelection;
            mostarInformacionCitaMedica(selectedCitaMedica);
        });
    }


    /**
     * Metodo que detecta cuando el usuario selecciona un paciente en la tabla
     */
    private void listenerSelectionPaciente() {
        tb_Paciente.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedPaciente = newSelection;
        });
    }

    /**
     * Metodo que detecta cuando el usuario selecciona un doctor en la tbala
     */
    private void listenerSelectionDoctor() {
            tb_Doctor.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
                selectedDoctor = newSelection;
            });
    }

    /**
     * Metodo que muestra la informacion de la cita medica sleccionada en los campos de la interfaz
     * @param citaMedica
     */
    private void mostarInformacionCitaMedica(CitaMedica citaMedica) {
        if (citaMedica!= null) {
            txt_CodigoCita.setText(citaMedica.getCodigoCita());
            date_Cita.setValue(citaMedica.getFechaCita());
            txt_HoraCita.setText(String.valueOf(citaMedica.getHoraCita()));
        }
    }

    /**
     * Metodo que agrega una cita
     */
    private void agregarCita() {
        CitaMedica citaMedica= buildCitaMedica();
        if(citaMedicaController.crearCitaMedica(citaMedica)){
            listaCitaMedica.add(citaMedica);
            limpiarCamposCita();
        }
    }


    /**
     * Metodo que crea una instancia de cita medica con los datos ingresados en la interfaz
     * @return
     */
    private CitaMedica buildCitaMedica() {
        double horaCita= Double.parseDouble(txt_HoraCita.getText());
        CitaMedica citaMedica = new CitaMedica(
                txt_CodigoCita.getText(),
                date_Cita.getValue(),
                horaCita
                ,selectedDoctor
                ,selectedPaciente
        );
        return citaMedica;

    }

    /**
     * Metodo que elimina la cita
     */
    private void eliminarCita() {
        if (citaMedicaController.eliminarCita(txt_CodigoCita.getText())) {
            listaCitaMedica.remove(selectedCitaMedica);
            limpiarCamposCita();
            limpiarSeleccion();
        }
    }


    /**
     * Metodo que actualiza la cita medica
     */
    private void actualizarCita() {

        if (selectedCitaMedica != null &&
                citaMedicaController.actualizarCita(selectedCitaMedica.getCodigoCita(), buildCitaMedica())) {

            int index = listaCitaMedica.indexOf(selectedCitaMedica);
            if (index >= 0) {
                listaCitaMedica.set(index, buildCitaMedica());
            }

            tb_CitaMedica.refresh();
            limpiarSeleccion();
            limpiarCamposCita();
        }
    }

    /**
     * Metodo que limpia la seleccion de las tablas
     */
    private void limpiarSeleccion() {
        tb_CitaMedica.getSelectionModel().clearSelection();
        limpiarCamposCita();
    }

    /**
     * Metodo que limpia los campos de la cita seleccionada
     */
    private void limpiarCamposCita() {
        txt_CodigoCita.clear();
        date_Cita.setValue(null);
        txt_HoraCita.clear();
        tb_Paciente.getSelectionModel().clearSelection();
        tb_Doctor.getSelectionModel().clearSelection();
    }

    /**
     * metodo que setea la App
     * @param app
     */
    public void setApp(App app) {
        this.app = app;
    }
}