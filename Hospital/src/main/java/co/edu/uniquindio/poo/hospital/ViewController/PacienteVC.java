package co.edu.uniquindio.poo.hospital.ViewController;

import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.hospital.App;
import co.edu.uniquindio.poo.hospital.Controller.PacienteController;
import co.edu.uniquindio.poo.hospital.Model.HistorialMedico;
import co.edu.uniquindio.poo.hospital.Model.Paciente;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PacienteVC {
    private App app;
    private ObservableList<Paciente> listaPaciente = FXCollections.observableArrayList();
    private ObservableList<HistorialMedico> listaHistorialMedico = FXCollections.observableArrayList();
    private Paciente selectedPaciente;
    private HistorialMedico selectedHistorialMedico;
    PacienteController pacienteController;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btt_Eliminar;

    @FXML
    private Button Volver;

    @FXML
    private TableColumn<Paciente, String> tbc_Cedula;

    @FXML
    private TextField txt_Nombre;

    @FXML
    private TableView<Paciente> tb_Paciente;

    @FXML
    private Button btt_Actualizar;

    @FXML
    private TableColumn<HistorialMedico, String> tbc_CodigoHistorial;

    @FXML
    private TableView<HistorialMedico> tb_historial;

    @FXML
    private TextField txt_Apellido;

    @FXML
    private TextField txt_Edad;

    @FXML
    private TextField txt_Cedula;

    @FXML
    private Button btt_Agregar;

    @FXML
    private TableColumn<Paciente, String> tbc_Apellido;

    @FXML
    private TableColumn<Paciente, String> tbc_Nombre;

    @FXML
    private TableColumn<Paciente, String> tbc_Historial;

    @FXML
    private TableColumn<Paciente, Integer> tbc_Edad;

    @FXML
    private Button btt_Limpiar;


    /**
     *Metodo que acciona el metodo de agregar
     * @param event
     */
    @FXML
    void AgregarPaciente(ActionEvent event) {
        agregarpaciente();
    }

    /**
     *Metdodo que permite accionar el boton de volver para regresar ak menu de personas
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
     *Metodo que acciona el metodo de actualizar
     * @param event
     */
    @FXML
    void ActualizarPaciente(ActionEvent event) {
        actualizarPaciente();
    }

    /**
     *Metodo que acciona el metodo de eliminar
     * @param event
     */
    @FXML
    void EliminarPaciente(ActionEvent event) {
        eliminarPaciente();
    }

    /**
     *Metodo que acciona el metodo de limpiar
     * @param event
     */
    @FXML
    void LimpiarPaciente(ActionEvent event) {
        limpiarCamposPaciente();
    }


    @FXML
    void initialize() {
        assert btt_Eliminar != null : "fx:id=\"btt_Eliminar\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert tbc_Cedula != null : "fx:id=\"tbc_Cedula\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert txt_Nombre != null : "fx:id=\"txt_Nombre\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert tb_Paciente != null : "fx:id=\"tb_Paciente\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert btt_Actualizar != null : "fx:id=\"btt_Actualizar\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert tbc_CodigoHistorial != null : "fx:id=\"tb_Historial\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert tb_historial != null : "fx:id=\"tb_Historial\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert txt_Apellido != null : "fx:id=\"txt_Apellido\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert txt_Edad != null : "fx:id=\"txt_Edad\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert txt_Cedula != null : "fx:id=\"txt_Cedula\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert btt_Agregar != null : "fx:id=\"btt_Agregar\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert tbc_Apellido != null : "fx:id=\"tbc_Apellido\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert tbc_Nombre != null : "fx:id=\"tbc_Nombre\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert tbc_Historial != null : "fx:id=\"tbc_Historial\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert tbc_Edad != null : "fx:id=\"tbc_Edad\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert btt_Limpiar != null : "fx:id=\"btt_Limpiar\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert Volver != null : "fx:id=\"btt_Limpiar\" was not injected: check your FXML file 'Paciente.fxml'.";

        pacienteController=new PacienteController(App.hospital);
        ObtenerHistorialMedico();
        obtenerPaciente();
        initView();
    }

    /**
     *Metodo que permite obtener los datos de historial medico
     */
    private void ObtenerHistorialMedico() {
        if (listaHistorialMedico == null) {
            listaHistorialMedico = FXCollections.observableArrayList();
        }

        Collection<HistorialMedico> historiales = pacienteController.obtenerListaHistorial();
        if (historiales != null) {
            listaHistorialMedico.setAll(historiales);
        } else {
            System.out.println("No se encontraron historiales.");
        }
    }


    /**
     *Metodo que permite obtener los datos de paciente
     */
    private void obtenerPaciente() {
        if (pacienteController != null) {
            listaPaciente.addAll(pacienteController.ObtenerListaPaciente());
        } else {
            System.err.println("PacienteController no está inicializado.");
        }
    }


    /**
     *Metodo que inicializa la vista en javaFX
     */
    private void initView() {
        initDataBinding();
        obtenerPaciente();
        tb_Paciente.getItems().clear();
        tb_Paciente.setItems(listaPaciente);
        tb_historial.setItems(listaHistorialMedico);
        listenerSelectionPaciente();
        listenerSelectionHistorial();
    }

    /**
     *Metodo que configura la vinculacion de datos en las tablas
     */
    private void initDataBinding() {
        tbc_Nombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbc_Apellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        tbc_Cedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tbc_Edad.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getEdad()));
        tbc_CodigoHistorial.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigoHistorial()));
        tbc_Historial.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getHistorialMedico().getCodigoHistorial()));
    }

    /**
     *Metodo que escucha los cambios en la selecion de paciente y actualiza la variable selectedPaciente
     */
    private void listenerSelectionPaciente() {
        tb_Paciente.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedPaciente = newSelection;
            mostarInformacionPaciente(selectedPaciente);
        });
    }

    /**
     *Metodo que detecta cuando el usuario selecciona un historial medico en la tabla
     */
    private void listenerSelectionHistorial() {
        tb_historial.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedHistorialMedico = newSelection;
        });
    }


    /**
     *Metodo que muestra la información del paciente sleccionado en los campos de la interfaz
     * @param paciente
     */
    private void mostarInformacionPaciente(Paciente paciente) {
        if (paciente != null) {
            txt_Cedula.setText(paciente.getCedula());
            txt_Nombre.setText(paciente.getNombre());
            txt_Apellido.setText(paciente.getApellido());
            txt_Edad.setText(String.valueOf(paciente.getEdad()));
        }
    }

    /**
     *Metodo que agrega un paciente
     */
    private void agregarpaciente() {
        Paciente paciente = buildPaciente();
        if(pacienteController.crearPaciente(paciente)){
            listaPaciente.add(paciente);
            limpiarCamposPaciente();
        }
    }

    /**
     *Metodo que crea una instancia de Paciente con los datos ingresados en la interfaz
     * @return
     */
    private Paciente buildPaciente() {
        int edad= Integer.parseInt(txt_Edad.getText());
        Paciente paciente = new Paciente(
                txt_Cedula.getText(),
                txt_Nombre.getText(),
                txt_Apellido.getText(),
                edad
                ,selectedHistorialMedico

        );
        return paciente;

    }


    /**
     *Metodo que elimina un paciente
     */
    private void eliminarPaciente() {
        if (pacienteController.eliminarPaciente(txt_Cedula.getText())) {
            listaPaciente.remove(selectedPaciente);
            limpiarCamposPaciente();
            limpiarSeleccion();
        }
    }

    /**
     *Metodo que actualiza un paciente
     */
    private void actualizarPaciente() {

        if (selectedPaciente != null &&
                pacienteController.actualizarPaciente(selectedPaciente.getCedula(), buildPaciente())) {

            int index = listaPaciente.indexOf(selectedPaciente);
            if (index >= 0) {
                listaPaciente.set(index, buildPaciente());
            }

            tb_Paciente.refresh();
            limpiarSeleccion();
            limpiarCamposPaciente();
        }
    }

    /**
     *metodo que limpia la seleccion de la tabla
     */
    private void limpiarSeleccion() {
        tb_Paciente.getSelectionModel().clearSelection();
        limpiarCamposPaciente();
    }

    /**
     *Metodo qi¿ue limpia los acmpos del paciente seleccionado
     */
    private void limpiarCamposPaciente() {
        txt_Cedula.clear();
        txt_Nombre.clear();
        txt_Apellido.clear();
        txt_Edad.clear();
        tb_historial.getSelectionModel().clearSelection();
    }

    /**
     *metodo que seta APP
     * @param app
     */
    public void setApp(App app) {
        this.app = app;
    }
}

