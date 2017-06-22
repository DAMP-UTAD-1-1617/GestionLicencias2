package Vistas_Controladores;

import Main_ControladorPadre.Main;
import Modelo.MImplementacionFX;
import Modelo.Registro3;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladorPantallaHistorico implements Controlador{
	private Stage ventana;
	private ControladorPantallaPrincipal controladorPantallaPrincipal;
	private Main main;
	private MImplementacionFX modelo;
	private ObservableList<Registro3> registroHistorico;
	@FXML
	private TextField buscarRegistro;
	@FXML
	private TableView<Registro3> tabla_historico;
	@FXML
	private TableColumn<Registro3,String> columnRegistro;
	@FXML
	private TableColumn<Registro3,String> columnDNINuevoTitular;
	@FXML
	private TableColumn<Registro3,String> columnFechaNuevoTitular;
	@FXML
	private TableColumn<Registro3,String> columnDNIAntiguoTitular;
	@FXML
	private TableColumn<Registro3,String> columnFechaAntiguoTitular;
	@FXML
	private CheckBox escrituras;
	@FXML
	private CheckBox  planos;
	@FXML
	private CheckBox licenciaAnterior;
	@FXML
	private CheckBox numExpediente;
	
	
	
	
	
	public void initialize() {
		registroHistorico = FXCollections.observableArrayList();
	}
	@FXML
	public void mostrarDatosExtraHistorico(){
		this.main.mostrarDatosExtraHistorico();
	}
	@Override
	public void setModelo(MImplementacionFX modelo) {
		this.modelo=modelo;
	}

	public TextField getBuscarRegistro() {
		return buscarRegistro;
	}

	public void setBuscarRegistro(TextField buscarRegistro) {
		this.buscarRegistro = buscarRegistro;
	}

	public TableView<Registro3> getTabla_historico() {
		return tabla_historico;
	}

	public void setTabla_historico(TableView<Registro3> tabla_historico) {
		this.tabla_historico = tabla_historico;
	}

	public TableColumn<Registro3, String> getColumnRegistro() {
		return columnRegistro;
	}

	public void setColumnRegistro(TableColumn<Registro3, String> columnRegistro) {
		this.columnRegistro = columnRegistro;
	}

	public TableColumn<Registro3, String> getColumnDNINuevoTitular() {
		return columnDNINuevoTitular;
	}

	public void setColumnDNINuevoTitular(TableColumn<Registro3, String> columnDNINuevoTitular) {
		this.columnDNINuevoTitular = columnDNINuevoTitular;
	}

	public TableColumn<Registro3, String> getColumnFechaNuevoTitular() {
		return columnFechaNuevoTitular;
	}

	public void setColumnFechaNuevoTitular(TableColumn<Registro3, String> columnFechaNuevoTitular) {
		this.columnFechaNuevoTitular = columnFechaNuevoTitular;
	}

	public TableColumn<Registro3, String> getColumnDNIAntiguoTitular() {
		return columnDNIAntiguoTitular;
	}

	public void setColumnDNIAntiguoTitular(TableColumn<Registro3, String> columnDNIAntiguoTitular) {
		this.columnDNIAntiguoTitular = columnDNIAntiguoTitular;
	}

	public TableColumn<Registro3, String> getColumnFechaAntiguoTitular() {
		return columnFechaAntiguoTitular;
	}

	public void setColumnFechaAntiguoTitular(TableColumn<Registro3, String> columnFechaAntiguoTitular) {
		this.columnFechaAntiguoTitular = columnFechaAntiguoTitular;
	}

	public CheckBox getEscrituras() {
		return escrituras;
	}

	public void setEscrituras(CheckBox escrituras) {
		this.escrituras = escrituras;
	}

	public CheckBox getPlanos() {
		return planos;
	}

	public void setPlanos(CheckBox planos) {
		this.planos = planos;
	}

	public CheckBox getLicenciaAnterior() {
		return licenciaAnterior;
	}

	public void setLicenciaAnterior(CheckBox licenciaAnterior) {
		this.licenciaAnterior = licenciaAnterior;
	}

	public CheckBox getNumExpediente() {
		return numExpediente;
	}

	public void setNumExpediente(CheckBox numExpediente) {
		this.numExpediente = numExpediente;
	}

	public void setStagePrincipal(Stage ventana) {
		this.ventana=ventana;
		
	}

	public void setPantallaPrincipal(ControladorPantallaPrincipal controladorPantallaPrincipal) {
		this.controladorPantallaPrincipal=controladorPantallaPrincipal;
		
	}

	public void setMain(Main main) {
		this.main=main;
		
	}

	public ObservableList<Registro3> getRegistroHistorico() {
		return registroHistorico;
	}

	public void setRegistroHistorico(ObservableList<Registro3> registroHistorico) {
		this.registroHistorico = registroHistorico;
	}
	
	
	
	
}
