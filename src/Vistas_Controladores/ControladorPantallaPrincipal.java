package Vistas_Controladores;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JTable;

import Main_ControladorPadre.Main;
import Modelo.MImplementacionFX;

import Modelo.Registro;
import Modelo.Registro2;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControladorPantallaPrincipal implements Controlador {
	private MImplementacionFX modelo;
	private Main main;
	private ControladorPantallaConexionBBDD vconexionBBDD;
	private ControladorPantallaCambioTitularidad vcambioTitularidad;
	private ControladorPantallaHistorico vhistorico;
	private ControladorPantallaInicioSolicitud vinicioSolicitud;
	private ControladorPantallaRegistroTitular registroTitular;
	private ControladorPantallaCambioDatosLicencia cambioDatosLicencia;
	// Pestaña 1

	private ObservableList<Registro> registros;
	@FXML
	private Button conexionBBDD;
	@FXML
	private TextField txtfBuscaNombre;
	@FXML
	private TextField txtfBuscaDni;
	@FXML
	private Button inicioSolicitud;
	@FXML
	private Button cambioTitularidad;
	@FXML
	private Button historico;
	@FXML
	private Button certificadoPDF;
	@FXML
	private Button btnCambioDatosLicencia;
	@FXML
	private Button btnCambioDatosLicencia2;
	@FXML
	private TableView<Registro> tabla_persona;
	@FXML
	private TableColumn<Registro, String> columnDNI;
	@FXML
	private TableColumn<Registro, String> columnNombre;
	@FXML
	private TableColumn<Registro, String> columnApellidos;
	@FXML
	private TableColumn<Registro, String> columnLicencia;
	@FXML
	private TableColumn<Registro, String> columnRegistro;
	@FXML
	private TextField razonSocial;
	@FXML
	private TextField tipoPersona;
	@FXML
	private TextField dni;
	@FXML
	private TextField tlfMovil;
	@FXML
	private TextField tlfFIjo;
	@FXML
	private TextField direccion;
	@FXML
	private TextField municipio;
	@FXML
	private TextField cp;
	@FXML
	private TextField email;

	// Pestaña2

	private ObservableList<Registro2> registros2;
	@FXML
	private TableView<Registro2> tabla_licencias;
	@FXML
	private TableColumn<Registro2, String> columnRegistro2;
	@FXML
	private TableColumn<Registro2, String> columnLicencia2;
	@FXML
	private TableColumn<Registro2, String> columnEmplazamiento;
	@FXML
	private TableColumn<Registro2, String> columnTipoSuelo;
	@FXML
	private TableColumn<Registro2, String> columnEstadoLicencia;
	@FXML
	private Button inicioSolicitud2;
	@FXML
	private Button cambioTitularidad2;
	@FXML
	private Button historico2;
	@FXML
	private Button certificadoPDF2;
	@FXML
	private TextField txtfBuscaRegistro;
	@FXML
	private TextField txtfBuscaTipoLicencia;
	@FXML
	private TextArea txtAreaDescripcionActividad;
	@FXML
	private TextField txtfTipoActividad;
	@FXML
	private TextField txtfReferenciaCatastral;
	@FXML
	private TextField txtfFechaInicioActividad;
	@FXML
	private TextField txtfFechaInicioSolicitud;
	@FXML
	private CheckBox fotocopiaDNI;
	@FXML
	private CheckBox fotocopiaImpuestoActividad;
	@FXML
	private CheckBox fotografias;
	@FXML
	private CheckBox fotocopiaObraAdaptacion;
	@FXML
	private CheckBox fotocopiaEscritura;
	@FXML
	private CheckBox memoriaActividad;
	@FXML
	private CheckBox justificantePago;
	@FXML
	private CheckBox otrasAutorizaciones;
	@FXML
	private CheckBox certificadoModelo1;
	@FXML
	private CheckBox certificadoModelo2;
	@FXML
	private CheckBox planosLocal;
	
	

	

	public void initialize() {
		registros = FXCollections.observableArrayList();
		registros2 = FXCollections.observableArrayList();
	}

	@FXML
	public void mouseClicked() {
		cambioTitularidad.setDisable(false);
		btnCambioDatosLicencia.setDisable(false);
		main.recogerRegistro();

	}

	@FXML
	public void mouseClicked2() {
		cambioTitularidad2.setDisable(false);
		btnCambioDatosLicencia2.setDisable(false);
		main.recogerRegistro2();

	}
	
	@FXML
	public void abrirConexionBBDD(){
		main.mostrarVentanaConexionBBDD();
	}
	@FXML
	public void cambioTitularidad(){
		this.main.mostrarVentanaCambioTitularidad();
		this.main.recogerRegistroCambioTitularidad();
	}
	
	@FXML
	public void cambioTitularidad2(){
		this.main.mostrarVentanaCambioTitularidad();
		this.main.recogerRegistroCambioTitularidad2();
	}
	
	
	@FXML
	public void abrirCambioDatosLicencia() {
			this.main.mostrarVentanaCambioDatosLicencia();
			this.main.recogerRegistroCambioDatosLicencia();
	}
	
	@FXML
	public void abrirCambioDatosLicencia2() {
			this.main.mostrarVentanaCambioDatosLicencia();
			this.main.recogerRegistroCambioDatosLicencia2();
	}
	
	
	@FXML
	public void abrirHistorico(){
		this.main.mostrarVentanaHistorico();
		
	}
	
	@FXML
	public void abrirInicioSolicitud(){
		this.main.mostrarVentanaInicioSolicitud();
		
	}
	
	public MImplementacionFX getModelo() {
		return modelo;
	}

	public ObservableList<Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(ObservableList registros) {
		this.registros = registros;
	}

	public Button getConexionBBDD() {
		return conexionBBDD;
	}

	public void setConexionBBDD(Button conexionBBDD) {
		this.conexionBBDD = conexionBBDD;
	}

	public TextField getTxtfNombre() {
		return txtfBuscaNombre;
	}

	public void setTxtfNombre(TextField txtfNombre) {
		this.txtfBuscaNombre = txtfNombre;
	}

	public TextField getTxtfBuscaDni() {
		return txtfBuscaDni;
	}

	public void setTxtfBuscaDni(TextField txtfBuscaDni) {
		this.txtfBuscaDni = txtfBuscaDni;
	}

	public Button getInicioSolicitud() {
		return inicioSolicitud;
	}

	public void setInicioSolicitud(Button inicioSolicitud) {
		this.inicioSolicitud = inicioSolicitud;
	}

	public Button getCambioTitularidad() {
		return cambioTitularidad;
	}

	public void setCambioTitularidad(Button cambioTitularidad) {
		this.cambioTitularidad = cambioTitularidad;
	}

	public Button getHistorico() {
		return historico;
	}

	public void setHistorico(Button historico) {
		this.historico = historico;
	}

	public Button getCertificadoPDF() {
		return certificadoPDF;
	}

	public void setCertificadoPDF(Button certificadoPDF) {
		this.certificadoPDF = certificadoPDF;
	}

	public TableView getTabla_persona() {
		return tabla_persona;
	}

	public void setTabla_persona(TableView tabla_persona) {
		this.tabla_persona = tabla_persona;
	}

	public TableColumn getColumnDNI() {
		return columnDNI;
	}

	public void setColumnDNI(TableColumn columnDNI) {
		this.columnDNI = columnDNI;
	}

	public TableColumn getColumnNombre() {
		return columnNombre;
	}

	public void setColumnNombre(TableColumn columnNombre) {
		this.columnNombre = columnNombre;
	}

	public TableColumn getColumnApellidos() {
		return columnApellidos;
	}

	public void setColumnApellidos(TableColumn columnApellidos) {
		this.columnApellidos = columnApellidos;
	}

	public TableColumn getColumnLicencia() {
		return columnLicencia;
	}

	public void setColumnLicencia(TableColumn columnLicencia) {
		this.columnLicencia = columnLicencia;
	}

	public TableColumn getColumnRegistro() {
		return columnRegistro;
	}

	public void setColumnRegistro(TableColumn columnRegistro) {
		this.columnRegistro = columnRegistro;
	}

	public TextField getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(TextField razonSocial) {
		this.razonSocial = razonSocial;
	}

	public TextField getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(TextField tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public TextField getDni() {
		return dni;
	}

	public void setDni(TextField dni) {
		this.dni = dni;
	}

	public TextField getTlfMovil() {
		return tlfMovil;
	}

	public void setTlfMovil(TextField tlfMovil) {
		this.tlfMovil = tlfMovil;
	}

	public TextField getTlfFIjo() {
		return tlfFIjo;
	}

	public void setTlfFIjo(TextField tlfFIjo) {
		this.tlfFIjo = tlfFIjo;
	}

	public TextField getDireccion() {
		return direccion;
	}

	public void setDireccion(TextField direccion) {
		this.direccion = direccion;
	}

	public TextField getMunicipio() {
		return municipio;
	}

	public void setMunicipio(TextField municipio) {
		this.municipio = municipio;
	}

	public TextField getCp() {
		return cp;
	}

	public void setCp(TextField cp) {
		this.cp = cp;
	}

	public TextField getEmail() {
		return email;
	}

	public void setEmail(TextField email) {
		this.email = email;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public void setModelo(MImplementacionFX modelo) {
		this.modelo = modelo;
	}

	public TextField getTxtfBuscaNombre() {
		return txtfBuscaNombre;
	}

	public void setTxtfBuscaNombre(TextField txtfBuscaNombre) {
		this.txtfBuscaNombre = txtfBuscaNombre;
	}

	public ObservableList<Registro2> getRegistros2() {
		return registros2;
	}

	public void setRegistros2(ObservableList<Registro2> registros2) {
		this.registros2 = registros2;
	}

	public TableView<Registro2> getTabla_licencias() {
		return tabla_licencias;
	}

	public void setTabla_licencias(TableView<Registro2> tabla_licencias) {
		this.tabla_licencias = tabla_licencias;
	}

	public TableColumn<Registro2, String> getColumnRegistro2() {
		return columnRegistro2;
	}

	public void setColumnRegistro2(TableColumn<Registro2, String> columnRegistro2) {
		this.columnRegistro2 = columnRegistro2;
	}

	public TableColumn<Registro2, String> getColumnLicencia2() {
		return columnLicencia2;
	}

	public void setColumnLicencia2(TableColumn<Registro2, String> columnLicencia2) {
		this.columnLicencia2 = columnLicencia2;
	}

	public TableColumn<Registro2, String> getColumnEmplazamiento() {
		return columnEmplazamiento;
	}

	public void setColumnEmplazamiento(TableColumn<Registro2, String> columnEmplazamiento) {
		this.columnEmplazamiento = columnEmplazamiento;
	}

	public TableColumn<Registro2, String> getColumnTipoSuelo() {
		return columnTipoSuelo;
	}

	public void setColumnTipoSuelo(TableColumn<Registro2, String> columnTipoSuelo) {
		this.columnTipoSuelo = columnTipoSuelo;
	}

	public TableColumn<Registro2, String> getColumnEstadoLicencia() {
		return columnEstadoLicencia;
	}

	public void setColumnEstadoLicencia(TableColumn<Registro2, String> columnEstadoLicencia) {
		this.columnEstadoLicencia = columnEstadoLicencia;
	}

	public Button getInicioSolicitud2() {
		return inicioSolicitud2;
	}

	public void setInicioSolicitud2(Button inicioSolicitud2) {
		this.inicioSolicitud2 = inicioSolicitud2;
	}

	public Button getCambioTitularidad2() {
		return cambioTitularidad2;
	}

	public void setCambioTitularidad2(Button cambioTitularidad2) {
		this.cambioTitularidad2 = cambioTitularidad2;
	}

	public Button getHistorico2() {
		return historico2;
	}

	public void setHistorico2(Button historico2) {
		this.historico2 = historico2;
	}

	public Button getCertificadoPDF2() {
		return certificadoPDF2;
	}

	public void setCertificadoPDF2(Button certificadoPDF2) {
		this.certificadoPDF2 = certificadoPDF2;
	}

	public TextField getTxtfBuscaRegistro() {
		return txtfBuscaRegistro;
	}

	public void setTxtfBuscaRegistro(TextField txtfBuscaRegistro) {
		this.txtfBuscaRegistro = txtfBuscaRegistro;
	}

	public TextField getTxtfBuscaTipoLicencia() {
		return txtfBuscaTipoLicencia;
	}

	public void setTxtfBuscaTipoLicencia(TextField txtfBuscaTipoLicencia) {
		this.txtfBuscaTipoLicencia = txtfBuscaTipoLicencia;
	}

	public TextArea getTxtAreaDescripcionActividad() {
		return txtAreaDescripcionActividad;
	}

	public void setTxtAreaDescripcionActividad(TextArea txtAreaDescripcionActividad) {
		this.txtAreaDescripcionActividad = txtAreaDescripcionActividad;
	}
	
	

	public TextField getTxtfTipoActividad() {
		return txtfTipoActividad;
	}

	public void setTxtfTipoActividad(TextField txtfTipoActividad) {
		this.txtfTipoActividad = txtfTipoActividad;
	}

	public TextField getTxtfReferenciaCatastral() {
		return txtfReferenciaCatastral;
	}

	public void setTxtfReferenciaCatastral(TextField txtfReferenciaCatastral) {
		this.txtfReferenciaCatastral = txtfReferenciaCatastral;
	}

	public TextField getTxtfFechaInicioActividad() {
		return txtfFechaInicioActividad;
	}

	public void setTxtfFechaInicioActividad(TextField txtfFechaInicioActividad) {
		this.txtfFechaInicioActividad = txtfFechaInicioActividad;
	}

	public TextField getTxtfFechaInicioSolicitud() {
		return txtfFechaInicioSolicitud;
	}

	public void setTxtfFechaInicioSolicitud(TextField txtfFechaInicioSolicitud) {
		this.txtfFechaInicioSolicitud = txtfFechaInicioSolicitud;
	}

	public CheckBox getFotocopiaDNI() {
		return fotocopiaDNI;
	}

	public void setFotocopiaDNI(CheckBox fotocopiaDNI) {
		this.fotocopiaDNI = fotocopiaDNI;
	}

	public CheckBox getFotocopiaImpuestoActividad() {
		return fotocopiaImpuestoActividad;
	}

	public void setFotocopiaImpuestoActividad(CheckBox fotocopiaImpuestoActividad) {
		this.fotocopiaImpuestoActividad = fotocopiaImpuestoActividad;
	}

	public CheckBox getFotografias() {
		return fotografias;
	}

	public void setFotografias(CheckBox fotografias) {
		this.fotografias = fotografias;
	}

	public CheckBox getFotocopiaObraAdaptacion() {
		return fotocopiaObraAdaptacion;
	}

	public void setFotocopiaObraAdaptacion(CheckBox fotocopiaObraAdaptacion) {
		this.fotocopiaObraAdaptacion = fotocopiaObraAdaptacion;
	}

	public CheckBox getFotocopiaEscritura() {
		return fotocopiaEscritura;
	}

	public void setFotocopiaEscritura(CheckBox fotocopiaEscritura) {
		this.fotocopiaEscritura = fotocopiaEscritura;
	}

	public CheckBox getMemoriaActividad() {
		return memoriaActividad;
	}

	public void setMemoriaActividad(CheckBox memoriaActividad) {
		this.memoriaActividad = memoriaActividad;
	}

	public CheckBox getJustificantePago() {
		return justificantePago;
	}

	public void setJustificantePago(CheckBox justificantePago) {
		this.justificantePago = justificantePago;
	}

	public CheckBox getOtrasAutorizaciones() {
		return otrasAutorizaciones;
	}

	public void setOtrasAutorizaciones(CheckBox otrasAutorizaciones) {
		this.otrasAutorizaciones = otrasAutorizaciones;
	}

	public CheckBox getCertificadoModelo1() {
		return certificadoModelo1;
	}

	public void setCertificadoModelo1(CheckBox certificadoModelo1) {
		this.certificadoModelo1 = certificadoModelo1;
	}

	public CheckBox getCertificadoModelo2() {
		return certificadoModelo2;
	}

	public void setCertificadoModelo2(CheckBox certificadoModelo2) {
		this.certificadoModelo2 = certificadoModelo2;
	}

	public CheckBox getPlanosLocal() {
		return planosLocal;
	}

	public void setPlanosLocal(CheckBox planosLocal) {
		this.planosLocal = planosLocal;
	}

	public void setConexionBBDD(ControladorPantallaConexionBBDD conexionBBDD) {
		this.vconexionBBDD=conexionBBDD;
		
	}

	public void setCambioTitularidad(ControladorPantallaCambioTitularidad cambioTitularidad) {
		this.vcambioTitularidad=cambioTitularidad;
		
	}

	public void setHistorico(ControladorPantallaHistorico historico) {
		this.vhistorico=historico;
		
	}

	public void setInicioSolicitud(ControladorPantallaInicioSolicitud inicioSolicitud) {
		this.vinicioSolicitud=inicioSolicitud;
		
	}

	public void setRegistroTitular(ControladorPantallaRegistroTitular registroTitular) {
		this.registroTitular=registroTitular;
		
	}

	public void setCambioDatosLicencia(ControladorPantallaCambioDatosLicencia cambioDatosLicencia) {
		this.cambioDatosLicencia=cambioDatosLicencia;
		
	}
	
	

}
