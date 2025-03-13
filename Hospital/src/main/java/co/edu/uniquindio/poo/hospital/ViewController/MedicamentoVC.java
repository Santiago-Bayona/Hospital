package co.edu.uniquindio.poo.hospital.ViewController;

import java.net.URL;
import java.util.ResourceBundle;


import co.edu.uniquindio.poo.hospital.App;
import co.edu.uniquindio.poo.hospital.Controller.MedicamentoController;
import co.edu.uniquindio.poo.hospital.Model.Medicamento;
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

public class MedicamentoVC {
    private App app;
    private MedicamentoController medicamentoController;
    private ObservableList<Medicamento> listaMedicamentos = FXCollections.observableArrayList();
    private Medicamento selectedMedicamento;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtIdMedicamento;

    @FXML
    private TextField txtDosisMedicamento;

    @FXML
    private TextField txtNombreMedicamento;

    @FXML
    private Button btnAgregarMedicamento;

    @FXML
    private Button btnActualizarMedicamento;

    @FXML
    private Button btnEliminarMedicamento;

    @FXML
    private Button btnLimpiarTablaMedicamentos;

    @FXML
    private Button btnRegresar;

    @FXML
    private TableView<Medicamento> tableMedicamentos;

    @FXML
    private TableColumn<Medicamento, String> columnIdMedicamento;

    @FXML
    private TableColumn<Medicamento, String> columnNombreMedicamento;

    @FXML
    private TableColumn<Medicamento, String> columnDosisMedicamento;

    /**
     * Acción que se ejecuta al presionar el botón de agregar un medicamento.
     * Llama al método `agregarMedicamento()`.
     *
     * @param event Evento de acción del botón.
     */
    @FXML
    void agregarMedicamentoAction(ActionEvent event) {
        agregarMedicamento();
    }

    /**
     * Acción que se ejecuta al presionar el botón de actualizar un medicamento.
     * Llama al método `actualizarMedicamento()`.
     *
     * @param event Evento de acción del botón.
     */
    @FXML
    void actualizarMedicamentoAction(ActionEvent event) {
        actualizarMedicamento();
    }

    /**
     * Acción que se ejecuta al presionar el botón de eliminar un medicamento.
     * Llama al método `eliminarMedicamento()`.
     *
     * @param event Evento de acción del botón.
     */
    @FXML
    void eliminarMedicamentoAction(ActionEvent event) {
        eliminarMedicamento();
    }

    /**
     * Limpia los campos de entrada de la interfaz de usuario.
     *
     * @param event Evento de acción del botón.
     */
    @FXML
    void limpiartablaMedicamentosAction(ActionEvent event) {
        limpiarCamposMedicamento();
    }

    /**
     * Regresa al menú principal de la aplicación.
     * Maneja posibles excepciones durante la navegación.
     *
     * @param event Evento de acción del botón.
     */
    @FXML
    void regresarAction(ActionEvent event) {
        try {
            app.MenuOtros();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método de inicialización del controlador.
     * Se ejecuta automáticamente al cargar la vista.
     */
    @FXML
    void initialize() {
        medicamentoController = new MedicamentoController(App.hospital);
        initView();
    }

    /**
     * Inicializa la vista configurando la tabla, los datos y los listeners.
     */
    private void initView() {
        initDataBinding();
        obtenerMedicamentos();
        tableMedicamentos.setItems(listaMedicamentos);
        listenerSelection();
    }

    /**
     * Configura el enlace de datos entre la tabla y los atributos de los medicamentos.
     */
    private void initDataBinding() {
        columnIdMedicamento.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdMedicamento()));
        columnNombreMedicamento.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreMedicamento()));
        columnDosisMedicamento.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getDosis()));
    }

    /**
     * Obtiene la lista de medicamentos desde el controlador y la añade a la tabla.
     */
    private void obtenerMedicamentos() {
        listaMedicamentos.addAll(medicamentoController.obtenerListaMedicamentos());
    }

    /**
     * Agrega un listener a la tabla para detectar cambios en la selección de medicamentos.
     */
    private void listenerSelection() {
        tableMedicamentos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedMedicamento = newSelection;
            mostrarInformacionMedicamento(selectedMedicamento);
        });
    }

    /**
     * Muestra la información del medicamento seleccionado en los campos de texto.
     *
     * @param medicamento Medicamento seleccionado en la tabla.
     */
    private void mostrarInformacionMedicamento(Medicamento medicamento) {
        if (medicamento != null) {
            txtIdMedicamento.setText(medicamento.getIdMedicamento());
            txtNombreMedicamento.setText(medicamento.getIdMedicamento());
            txtDosisMedicamento.setText(String.valueOf( medicamento.getDosis()));
        }
    }

    /**
     * Agrega un nuevo medicamento a la lista y lo almacena en el controlador.
     */
    private void agregarMedicamento() {

        double dosis = Double.parseDouble(txtDosisMedicamento.getText());

        Medicamento medicamento = new Medicamento(txtIdMedicamento.getText(), txtNombreMedicamento.getText(), dosis);
        if (medicamentoController.crearMedicamento(medicamento)) {
            listaMedicamentos.add(medicamento);
            limpiarCamposMedicamento();
        }
    }

    /**
     * Elimina el medicamento seleccionado de la lista y del controlador.
     */
    private void eliminarMedicamento() {
        if (medicamentoController.eliminarMedicamento(txtIdMedicamento.getText())) {
            listaMedicamentos.remove(selectedMedicamento);
            limpiarCamposMedicamento();
            limpiarSeleccion();
        }
    }

    /**
     * Actualiza la información del medicamento seleccionado en la lista y el controlador.
     */
    private void actualizarMedicamento() {
        double dosis = Double.parseDouble(txtDosisMedicamento.getText());


        if (selectedMedicamento != null && medicamentoController.actualizarMedicamento(selectedMedicamento.getIdMedicamento(), new Medicamento(txtIdMedicamento.getText(), txtNombreMedicamento.getText(), dosis))) {
            int index = listaMedicamentos.indexOf(selectedMedicamento);
            if (index >= 0) {
                listaMedicamentos.set(index, new Medicamento(txtIdMedicamento.getText(), txtNombreMedicamento.getText(), dosis));
            }
            tableMedicamentos.refresh();
            limpiarSeleccion();
            limpiarCamposMedicamento();
        }
    }

    /**
     * Limpia la selección de la tabla de medicamentos y los campos de entrada.
     */
    private void limpiarSeleccion() {
        tableMedicamentos.getSelectionModel().clearSelection();
        limpiarCamposMedicamento();
    }

    /**
     * Limpia los campos de texto utilizados para ingresar la información del medicamento.
     */
    private void limpiarCamposMedicamento() {
        txtIdMedicamento.clear();
        txtNombreMedicamento.clear();
        txtDosisMedicamento.clear();
    }

    /**
     * Establece la referencia a la aplicación principal.
     *
     * @param app Instancia de la aplicación.
     */
    public void setApp(App app) {
        this.app = app;
    }
}
