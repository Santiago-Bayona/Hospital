package co.edu.uniquindio.poo.hospital.ViewController;

import java.net.URL;
import java.time.LocalDate;
import java.util.Collection;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.hospital.App;
import co.edu.uniquindio.poo.hospital.Controller.ConsultaController;
import co.edu.uniquindio.poo.hospital.Model.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;

public class ConsultaVC {

    private App app;
    ConsultaController consultaController;
    private ObservableList<Consulta> listaConsulta = FXCollections.observableArrayList();
    private ObservableList<CitaMedica> listaCitaMedica = FXCollections.observableArrayList();
    private ObservableList<Medicamento> listaMedicamento = FXCollections.observableArrayList();
    private Consulta selectedConsulta;
    private CitaMedica selectedCitaMedica;
    private Medicamento selectedMedicamento;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Consulta> tb_Consulta;

    @FXML
    private Button btt_Eliminar;

    @FXML
    private TableColumn<CitaMedica, String> tbc_CodigoCita;

    @FXML
    private TableColumn<Consulta, String> tbc_nombreMedicamento;

    @FXML
    private TableColumn<Consulta, Double> tbc_Dosis;

    @FXML
    private DatePicker date_Consulta;

    @FXML
    private Button btt_Actualizar;

    @FXML
    private TextField txt_IdConsulta;

    @FXML
    private TableView<Medicamento> tb_Medicamento;

    @FXML
    private TableColumn<CitaMedica, LocalDate> tbc_FechaCita;

    @FXML
    private TableColumn<Consulta, String> tbc_Diagnostico;

    @FXML
    private TextField txt_Diagnostico;

    @FXML
    private TableView<CitaMedica> tb_CitaMedica;

    @FXML
    private TableColumn<Consulta, LocalDate> tbc_FechaConsulta;

    @FXML
    private Button btt_Agregar;

    @FXML
    private TableColumn<Consulta, String> tbc_IdConsulta;

    @FXML
    private TableColumn<Consulta, String> tbc_Cita;

    @FXML
    private TableColumn<Medicamento, String> tbc_nombreMedicamento1;

    @FXML
    private TableColumn<Medicamento, Double> tbc_dosis;

    @FXML
    private Button btt_Limpiar;

    @FXML
    private Button Volver;

    /**
     * metodo que regresa al menu de procedimientos
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
     *metodo que accional el boton de gregar
     * @param event
     */
    @FXML
    void AgregarConsulta(ActionEvent event) {
        agregarConsulta();
    }

    /**
     *Metodo que acciona el boton de actualizar
     * @param event
     */
    @FXML
    void ActualizarConsulta(ActionEvent event) {
        actualizarConsulta();
    }

    /**
     *Metodo que acciona el boton de eliminar
     * @param event
     */
    @FXML
    void EliminarConsulta(ActionEvent event) {
        eliminarConsulta();
    }

    /**
     *Metodo que acciona el metodo de limpiar
     * @param event
     */
    @FXML
    void LimpiarConsulta(ActionEvent event) {
        limpiarCamposConsulta();
    }

    @FXML
    void initialize() {
        assert tb_Consulta != null : "fx:id=\"tb_Consulta\" was not injected: check your FXML file 'Consulta.fxml'.";
        assert btt_Eliminar != null : "fx:id=\"btt_Eliminar\" was not injected: check your FXML file 'Consulta.fxml'.";
        assert tbc_Cita != null : "fx:id=\"tbc_cedulaPaciente\" was not injected: check your FXML file 'Consulta.fxml'.";
        assert tbc_nombreMedicamento != null : "fx:id=\"tbc_nombreMedicamento\" was not injected: check your FXML file 'Consulta.fxml'.";
        assert tbc_Dosis != null : "fx:id=\"tbc_Dosis\" was not injected: check your FXML file 'Consulta.fxml'.";
        assert date_Consulta != null : "fx:id=\"date_Consulta\" was not injected: check your FXML file 'Consulta.fxml'.";
        assert btt_Actualizar != null : "fx:id=\"btt_Actualizar\" was not injected: check your FXML file 'Consulta.fxml'.";
        assert txt_IdConsulta != null : "fx:id=\"txt_IdConsulta\" was not injected: check your FXML file 'Consulta.fxml'.";
        assert tb_Medicamento != null : "fx:id=\"tb_Medicamento\" was not injected: check your FXML file 'Consulta.fxml'.";
        assert tbc_CodigoCita != null : "fx:id=\"tbc_cedulaDoctor1\" was not injected: check your FXML file 'Consulta.fxml'.";
        assert tbc_FechaCita != null : "fx:id=\"tbc_nombreDoctor1\" was not injected: check your FXML file 'Consulta.fxml'.";
        assert tbc_Diagnostico != null : "fx:id=\"tbc_Diagnostico\" was not injected: check your FXML file 'Consulta.fxml'.";
        assert txt_Diagnostico != null : "fx:id=\"txt_Diagnostico\" was not injected: check your FXML file 'Consulta.fxml'.";
        assert tb_CitaMedica != null : "fx:id=\"tb_CitaMedica\" was not injected: check your FXML file 'Consulta.fxml'.";
        assert tbc_FechaConsulta != null : "fx:id=\"tbc_FechaConsulta\" was not injected: check your FXML file 'Consulta.fxml'.";
        assert btt_Agregar != null : "fx:id=\"btt_Agregar\" was not injected: check your FXML file 'Consulta.fxml'.";
        assert tbc_IdConsulta != null : "fx:id=\"tbc_IdConsulta\" was not injected: check your FXML file 'Consulta.fxml'.";
        assert tbc_nombreMedicamento1 != null : "fx:id=\"tbc_nombreMedicamento1\" was not injected: check your FXML file 'Consulta.fxml'.";
        assert tbc_dosis != null : "fx:id=\"tbc_dosis\" was not injected: check your FXML file 'Consulta.fxml'.";
        assert btt_Limpiar != null : "fx:id=\"btt_Limpiar\" was not injected: check your FXML file 'Consulta.fxml'.";
        assert Volver != null : "fx:id=\"Volver\" was not injected: check your FXML file 'Consulta.fxml'.";


        consultaController=new ConsultaController(App.hospital);
        obtenerConsulta();
        ObtenerMedicamento();
        ObtenerCitaMedica();
        initView();
    }


    /**
     *Metodo que permite obtener los datos de cita medica
     */
    private void ObtenerCitaMedica() {
        if (listaCitaMedica == null) {
            listaCitaMedica = FXCollections.observableArrayList();
        }

        Collection<CitaMedica> citaMedicas = consultaController.obtenerListaCitaMedica();
        if (citaMedicas != null) {
            listaCitaMedica.setAll(citaMedicas);
        } else {
            System.out.println("No se encontraron Citas Medicas.");
        }
    }

    /**
     *Metodo que permite obtener los datos de medicamento
     */
    private void ObtenerMedicamento() {
        if (listaMedicamento == null) {
            listaMedicamento = FXCollections.observableArrayList();
        }

        Collection<Medicamento> medicamentos = consultaController.obtenerListaMedicamento();
        if (medicamentos != null) {
            listaMedicamento.setAll(medicamentos);
        } else {
            System.out.println("No se encontraron medicamentos.");
        }
    }

    /**
     *Metodo que permite obtener los datos de consulta
     */
    private void obtenerConsulta() {
        if (consultaController != null) {
            listaConsulta.addAll(consultaController.ObtenerListaConsulta());
        } else {
            System.err.println("consultaController no está inicializado.");
        }
    }

    /**
     *Metodo que inicializa la vista en javaFX
     */
    private void initView() {
        initDataBinding();
        obtenerConsulta();
        tb_Consulta.getItems().clear();
        tb_Consulta.setItems(listaConsulta);
        tb_CitaMedica.setItems(listaCitaMedica);
        tb_Medicamento.setItems(listaMedicamento);
        listenerSelectionConsulta();
        listenerSelectionCitaMedica();
        listenerSelectionMedicamento();
    }

    /**
     *Metodo que configura la vinculacion de datos en las tablas
     */
    private void initDataBinding() {
        tbc_IdConsulta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdConsulta()));
        tbc_FechaConsulta.setCellValueFactory(new PropertyValueFactory<>("fechaConsulta"));
        tbc_Diagnostico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDiagnosticoConsulta()));
        tbc_FechaCita.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getFechaCita()));
        tbc_CodigoCita.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigoCita()));
        tbc_nombreMedicamento.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMedicamento().getNombreMedicamento()));
        tbc_Dosis.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getMedicamento().getDosis()));
        tbc_Cita.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCitaMedica().getCodigoCita()));
        tbc_nombreMedicamento1.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreMedicamento()));
        tbc_dosis.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getDosis()));

    }

    /**
     *Metodo que escucha los cambios en la selecion de Consulta y actualiza la variable selectedConsulta
     */
    private void listenerSelectionConsulta() {
        tb_Consulta.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedConsulta = newSelection;
            mostarInformacionConsulta(selectedConsulta);
        });
    }


    /**
     *Metodo que detecta cuando el usuario selecciona una cita medica en la tabla
     */
    private void listenerSelectionCitaMedica() {
        tb_CitaMedica.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedCitaMedica = newSelection;
        });
    }

    /**
     *Metodo que detecta cuando el usuario selecciona un medicamento en la tabla
     */
    private void listenerSelectionMedicamento() {
        tb_Medicamento.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedMedicamento = newSelection;
        });
    }

    /**
     *Metodo que muestra la informacion de la consulta sleccionada en los campos de la interfaz
     * @param consulta
     */
    private void mostarInformacionConsulta(Consulta consulta) {
        if (consulta != null) {
            txt_IdConsulta.setText(consulta.getIdConsulta());
            date_Consulta.setValue(consulta.getFechaConsulta());
            txt_Diagnostico.setText(consulta.getDiagnosticoConsulta());
        }
    }

    /**
     *Metodo que agrega una consulta
     */
    private void agregarConsulta() {
        Consulta consulta = buildConsulta();
        if (consultaController.crearConsulta(consulta)) {
            listaConsulta.add(consulta);
            limpiarCamposConsulta();
        }
    }

    /**
     *Metodo que crea una instancia de Consulta con los datos ingresados en la interfaz
     * @return
     */
    private Consulta buildConsulta() {
        Consulta consulta = new Consulta(
                        txt_IdConsulta.getText(),
                        date_Consulta.getValue(),
                        txt_Diagnostico.getText()
                        ,selectedCitaMedica
                        ,selectedMedicamento
                );
        return consulta;

    }

    /**
     *Metodo que elimina una consulta
     */
    private void eliminarConsulta() {
        if (consultaController.eliminarConsulta(txt_IdConsulta.getText())) {
            listaConsulta.remove(selectedConsulta);
            limpiarCamposConsulta();
            limpiarSeleccion();
        }
    }

    /**
     *Metodo que actualiza un consulta
     */
    private void actualizarConsulta() {

        if (selectedConsulta != null &&
                consultaController.actualizarConsulta(selectedConsulta.getIdConsulta(), buildConsulta())) {

            int index = listaConsulta.indexOf(selectedConsulta);
            if (index >= 0) {
                listaConsulta.set(index, buildConsulta());
            }

            tb_Consulta.refresh();
            limpiarSeleccion();
            limpiarCamposConsulta();
        }
    }

    /**
     *Metodo que limpia la seleccion de la tabla
     */
    private void limpiarSeleccion() {
        tb_Consulta.getSelectionModel().clearSelection();
        limpiarCamposConsulta();
    }

    /**
     *Metodo que limpia los campos de la consulta seleccionada
     */
    private void limpiarCamposConsulta() {
        txt_IdConsulta.clear();
        date_Consulta.setValue(null);
        txt_Diagnostico.clear();
        tb_CitaMedica.getSelectionModel().clearSelection();
        tb_Medicamento.getSelectionModel().clearSelection();
    }

    /**
     *Metodo que seta la App
     * @param app
     */
    public void setApp(App app) {
        this.app = app;
    }
}








