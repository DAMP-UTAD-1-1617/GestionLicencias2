package Main_ControladorPadre;

import java.awt.Color;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

import Modelo.MImplementacionFX;
import Modelo.Registro;
import Modelo.Registro2;
import Modelo.Registro3;
import Vistas_Controladores.Controlador;
import Vistas_Controladores.ControladorPantallaCambioDatosLicencia;
import Vistas_Controladores.ControladorPantallaCambioTitularidad;
import Vistas_Controladores.ControladorPantallaConexionBBDD;
import Vistas_Controladores.ControladorPantallaHistorico;
import Vistas_Controladores.ControladorPantallaInicioSolicitud;
import Vistas_Controladores.ControladorPantallaPrincipal;
import Vistas_Controladores.ControladorPantallaRegistroTitular;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Main extends Application implements Controlador {

	private static Stage stagePrincipal;
	private AnchorPane rootPane;
	private ControladorPantallaPrincipal controladorPantallaPrincipal;
	private ControladorPantallaConexionBBDD conexionBBDD;
	private ControladorPantallaCambioTitularidad cambioTitularidad;
	private ControladorPantallaHistorico historico;
	private ControladorPantallaInicioSolicitud inicioSolicitud;
	private ControladorPantallaRegistroTitular registroTitular;
	private ControladorPantallaCambioDatosLicencia cambioDatosLicencia;
	private MImplementacionFX modeloImplementacion = new MImplementacionFX();
	private int index;
	private String numRegistro;
	private String nombreCT;
	private String apellidosCT;
	private String tipoPersonaCT;
	private String direccionCT;
	private String municipioCT;
	private String CPCT;
	private String razonSocialCT;
	private String dniCT;
	private String tlfFijoCT;
	private String tlfMovilCT;
	private String emailCT;
	private String faxCT;
	private String planosCT;
	private String licenciaAntCT;
	private String escriturasCT;
	private String numExpedienteCT;

	//
	private String registroSolicitud;
	private String fechaInicioSolicitud;
	private String fechaInicioActividad;
	private String tipoSuelo;
	private String emplazamiento;
	private String refCatastral;
	private String estadoSolicitud;
	private String tipoActividad;
	private String descripcionActividad;
	private String fotocopiaDni;
	private String fotocopiaImpuestos;
	private String fotografia;
	private String fotocopiaEscrituras;
	private String justificantePago;
	private String memoriaActividad;
	private String planosLocal;
	private String fotocopiaLicenciaObra;
	private String certificado1;
	private String certificado2;
	private String otrasAutorizaciones;
	private String nombreT;
	private String apellidosT;
	private String nombreR;
	private String apellidosR;
	private String tipoPersonaT;
	private String direccionT;
	private String direccionR;
	private String municipioT;
	private String municipioR;
	private String razonSocialT;
	private String dniT;
	private String dniR;
	private String emailT;
	private String emailR;
	private String CPT;
	private String CPR;
	private String tlfFijoT;
	private String tlfFijoR;
	private String tlfMovilT;
	private String tlfMovilR;
	private String faxT;
	private String faxR;
	private LocalDate fechaInicioSolicitudDate;
	private CheckBox fotocopiaDniCheck;
	private CheckBox fotocopiaImpuestoCheck;
	private CheckBox fotocopiaFotosCheck;
	private CheckBox fotocopiaEscriturasCheck;
	private CheckBox fotocopiaMemoriaCheck;
	private CheckBox fotocopiaPlanosCheck;
	private CheckBox fotocopiaObraCheck;
	private CheckBox fotocopiaCertificado1Check;
	private CheckBox fotocopiaCertificado2Check;
	private CheckBox fotocopiaOtrasCheck;
	private CheckBox fotocopiaJustificanteCheck;

	@Override
	public void start(Stage stagePrincipal) throws Exception {
		Main.stagePrincipal = stagePrincipal;

		mostrarPatallaPrincipal();

	}

	private void mostrarPatallaPrincipal() {
		try {
			FXMLLoader loader = new FXMLLoader(
					Main.class.getResource("../Vistas_Controladores/VPantallaPrincipal.fxml"));

			rootPane = (AnchorPane) loader.load();
			Scene scene = new Scene(rootPane);
			stagePrincipal.setTitle("Pantalla Principal");
			stagePrincipal.setScene(scene);
			controladorPantallaPrincipal = loader.getController();
			this.setControladorPantallaPrincipal(controladorPantallaPrincipal);
			this.setModelo(modeloImplementacion);
			controladorPantallaPrincipal.setMain(this);
			controladorPantallaPrincipal.setModelo(modeloImplementacion);

			modeloImplementacion.setControladorMain(this);
			modeloImplementacion.setControladorPantallaPrincipal(controladorPantallaPrincipal);
			if (modeloImplementacion.ConexionBBDD().equalsIgnoreCase("¡Conexión Fallida!")) {
				Alert alert3 = new Alert(AlertType.ERROR);
				alert3.setTitle("Error");
				alert3.setHeaderText("Anteción, la conexión a la BBDD no está activda.");
			} else {
				inicializaTablas();
				modeloImplementacion.recogerDatosBBDDPersonas();
				modeloImplementacion.recogerDatosBBDDLicencias();
				stagePrincipal.show();

			}

		} catch (IOException e) {
		}

	}

	public void mostrarVentanaConexionBBDD() {
		FXMLLoader loader = new FXMLLoader(
				Main.class.getResource("../Vistas_Controladores/VPantallaConexionBBDD.fxml"));

		try {
			AnchorPane ventanaDos = (AnchorPane) loader.load();
			Stage ventana = new Stage();
			ventana.setTitle("Conexión BBDD");
			ventana.initOwner(stagePrincipal);
			Scene scene = new Scene(ventanaDos);
			ventana.setScene(scene);

			conexionBBDD = loader.getController();
			conexionBBDD.setStagePrincipal(ventana);
			conexionBBDD.setPantallaPrincipal(controladorPantallaPrincipal);
			controladorPantallaPrincipal.setConexionBBDD(conexionBBDD);
			conexionBBDD.setMain(this);
			this.setConexionBBD(conexionBBDD);
			conexionBBDD.setModelo(modeloImplementacion);
			modeloImplementacion.setConexionBBDD(conexionBBDD);
			modeloImplementacion.getBBDD();
			this.DatosBBDD();
			ventana.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void mostrarVentanaCambioTitularidad() {
		FXMLLoader loader = new FXMLLoader(
				Main.class.getResource("../Vistas_Controladores/VPantallaCambioTitularidad.fxml"));

		try {
			AnchorPane ventanaTres = (AnchorPane) loader.load();
			Stage ventana = new Stage();
			ventana.setTitle("Cambio de titularidad");
			ventana.initOwner(stagePrincipal);
			Scene scene = new Scene(ventanaTres);
			ventana.setScene(scene);

			cambioTitularidad = loader.getController();
			cambioTitularidad.setStagePrincipal(ventana);
			cambioTitularidad.setPantallaPrincipal(controladorPantallaPrincipal);
			controladorPantallaPrincipal.setCambioTitularidad(cambioTitularidad);
			cambioTitularidad.setMain(this);
			this.setCambioTitularidad(cambioTitularidad);
			cambioTitularidad.setModelo(modeloImplementacion);
			modeloImplementacion.setCambioTitularidad(cambioTitularidad);
			this.cambioTitularidad.initialize();
			ventana.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void mostrarVentanaCambioDatosLicencia() {
		FXMLLoader loader = new FXMLLoader(
				Main.class.getResource("../Vistas_Controladores/VPantallaCambioDatosLicencia.fxml"));

		try {
			AnchorPane ventanaCinco = (AnchorPane) loader.load();
			Stage ventana = new Stage();
			ventana.setTitle("Cambio de datos Licencia");
			ventana.initOwner(stagePrincipal);
			Scene scene = new Scene(ventanaCinco);
			ventana.setScene(scene);

			cambioDatosLicencia = loader.getController();
			cambioDatosLicencia.setStagePrincipal(ventana);
			cambioDatosLicencia.setPantallaPrincipal(controladorPantallaPrincipal);
			controladorPantallaPrincipal.setCambioDatosLicencia(cambioDatosLicencia);
			cambioDatosLicencia.setMain(this);
			this.setCambioDatosLicencia(cambioDatosLicencia);
			cambioDatosLicencia.setModelo(modeloImplementacion);
			modeloImplementacion.setCambioDatosLicencia(cambioDatosLicencia);
			this.cambioDatosLicencia.initialize();
			ventana.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void setCambioDatosLicencia(ControladorPantallaCambioDatosLicencia cambioDatosLicencia) {
		this.cambioDatosLicencia = cambioDatosLicencia;

	}

	public void mostrarVentanaHistorico() {
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Vistas_Controladores/VPantallaHistorico.fxml"));

		try {
			AnchorPane ventanaTres = (AnchorPane) loader.load();
			Stage ventana = new Stage();
			ventana.setTitle("Histórico cambio de titularidad");
			ventana.initOwner(stagePrincipal);
			Scene scene = new Scene(ventanaTres);
			ventana.setScene(scene);

			historico = loader.getController();
			historico.setStagePrincipal(ventana);
			historico.setPantallaPrincipal(controladorPantallaPrincipal);
			controladorPantallaPrincipal.setHistorico(historico);
			historico.setMain(this);
			this.setHistorico(historico);
			historico.setModelo(modeloImplementacion);
			modeloImplementacion.setHistorico(historico);
			inicializaTablaHistorico();
			modeloImplementacion.recogerDatosHistorico();
			ventana.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void mostrarVentanaInicioSolicitud() {
		FXMLLoader loader = new FXMLLoader(
				Main.class.getResource("../Vistas_Controladores/VPantallaInicioSolicitud.fxml"));

		try {
			AnchorPane ventanaCuatro = (AnchorPane) loader.load();
			Stage ventana = new Stage();
			ventana.setTitle("Inicio de solicitud");
			ventana.initOwner(stagePrincipal);
			Scene scene = new Scene(ventanaCuatro);
			ventana.setScene(scene);

			inicioSolicitud = loader.getController();
			inicioSolicitud.setStagePrincipal(ventana);
			inicioSolicitud.setPantallaPrincipal(controladorPantallaPrincipal);
			controladorPantallaPrincipal.setInicioSolicitud(inicioSolicitud);
			inicioSolicitud.setMain(this);
			this.setInicioSolicitud(inicioSolicitud);
			inicioSolicitud.setModelo(modeloImplementacion);
			modeloImplementacion.setInicioSolicitud(inicioSolicitud);
			ventana.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void mostrarVentanaRegistroTitular() {
		FXMLLoader loader = new FXMLLoader(
				Main.class.getResource("../Vistas_Controladores/VPantallaRegistroTitular.fxml"));

		try {
			AnchorPane ventanaCuatro = (AnchorPane) loader.load();
			Stage ventana = new Stage();
			ventana.setTitle("Registro del titular");
			ventana.initOwner(stagePrincipal);
			Scene scene = new Scene(ventanaCuatro);
			ventana.setScene(scene);

			registroTitular = loader.getController();
			registroTitular.setStagePrincipal(ventana);
			registroTitular.setPantallaPrincipal(controladorPantallaPrincipal);
			registroTitular.setPantallaInicioSolicitud(inicioSolicitud);
			controladorPantallaPrincipal.setRegistroTitular(registroTitular);
			inicioSolicitud.setRegistroTitular(registroTitular);
			registroTitular.setMain(this);
			this.setRegistroTitular(registroTitular);
			registroTitular.setModelo(modeloImplementacion);
			modeloImplementacion.setRegistroTitular(registroTitular);
			ventana.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void setRegistroTitular(ControladorPantallaRegistroTitular registroTitular) {
		this.registroTitular = registroTitular;

	}

	private void setInicioSolicitud(ControladorPantallaInicioSolicitud inicioSolicitud) {
		this.inicioSolicitud = inicioSolicitud;

	}

	private void inicializaTablaHistorico() {
		historico.initialize();

	}

	private void setHistorico(ControladorPantallaHistorico historico) {
		this.historico = historico;

	}

	private void setCambioTitularidad(ControladorPantallaCambioTitularidad cambioTitularidad) {
		this.cambioTitularidad = cambioTitularidad;

	}

	private void DatosBBDD() {
		conexionBBDD.getTxtfUsuario().setText(modeloImplementacion.getUsuario());
		conexionBBDD.getTxtfPass().setText(modeloImplementacion.getPass());
		conexionBBDD.getTxtfURL().setText(modeloImplementacion.getBbdd());
	}

	public void inicializaTablas() {
		controladorPantallaPrincipal.initialize();

	}

	public void tablaPersonas() {
		controladorPantallaPrincipal.getRegistros()
				.add(new Registro(modeloImplementacion.getDniTabla(), modeloImplementacion.getNombreTabla(),
						modeloImplementacion.getApellidosTabla(), modeloImplementacion.getActividadTabla(),
						modeloImplementacion.getRegistroTabla()));
		controladorPantallaPrincipal.getTabla_persona().setItems(controladorPantallaPrincipal.getRegistros());
		controladorPantallaPrincipal.getColumnDNI()
				.setCellValueFactory(new PropertyValueFactory<Registro, String>("Dni"));
		controladorPantallaPrincipal.getColumnNombre()
				.setCellValueFactory(new PropertyValueFactory<Registro, String>("Nombre"));
		controladorPantallaPrincipal.getColumnApellidos()
				.setCellValueFactory(new PropertyValueFactory<Registro, String>("apellido"));
		controladorPantallaPrincipal.getColumnLicencia()
				.setCellValueFactory(new PropertyValueFactory<Registro, String>("Licencia"));
		controladorPantallaPrincipal.getColumnRegistro()
				.setCellValueFactory(new PropertyValueFactory<Registro, String>("Registro"));

	}

	public void tablaLicencias() {
		controladorPantallaPrincipal.getRegistros2()
				.add(new Registro2(modeloImplementacion.getRegistro2Tabla(), modeloImplementacion.getActividad2Tabla(),
						modeloImplementacion.getEmplazamientoTabla(), modeloImplementacion.getTipoSueloTabla(),
						modeloImplementacion.getEstadoLicenciaTabla()));
		controladorPantallaPrincipal.getTabla_licencias().setItems(controladorPantallaPrincipal.getRegistros2());
		controladorPantallaPrincipal.getColumnRegistro2()
				.setCellValueFactory(new PropertyValueFactory<Registro2, String>("Registro2"));
		controladorPantallaPrincipal.getColumnLicencia2()
				.setCellValueFactory(new PropertyValueFactory<Registro2, String>("Licencia2"));
		controladorPantallaPrincipal.getColumnEmplazamiento()
				.setCellValueFactory(new PropertyValueFactory<Registro2, String>("Emplazamiento"));
		controladorPantallaPrincipal.getColumnTipoSuelo()
				.setCellValueFactory(new PropertyValueFactory<Registro2, String>("TipoSuelo"));
		controladorPantallaPrincipal.getColumnEstadoLicencia()
				.setCellValueFactory(new PropertyValueFactory<Registro2, String>("EstadoLicencia"));

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void recogerRegistro() {
		index = controladorPantallaPrincipal.getTabla_persona().getSelectionModel().getSelectedIndex();
		Registro registro = controladorPantallaPrincipal.getRegistros().get(index);
		numRegistro = registro.getRegistro();
		enviarRegistro(numRegistro);
	}

	public void recogerRegistro2() {
		index = controladorPantallaPrincipal.getTabla_licencias().getSelectionModel().getSelectedIndex();
		Registro2 registro = controladorPantallaPrincipal.getRegistros2().get(index);
		numRegistro = registro.getRegistro2();
		enviarRegistro2(numRegistro);

	}

	private void enviarRegistro(String numRegistro) {
		modeloImplementacion.recogerDatosExtra(numRegistro);

	}

	private void enviarRegistro2(String numRegistro) {
		modeloImplementacion.recogerDatosExtra2(numRegistro);

	}

	public void devolverDatosExtra() {
		controladorPantallaPrincipal.getRazonSocial().setText(modeloImplementacion.getRazonSocial());
		controladorPantallaPrincipal.getDni().setText(modeloImplementacion.getDni());
		controladorPantallaPrincipal.getTlfFIjo().setText(modeloImplementacion.getTlfFijo());
		controladorPantallaPrincipal.getTlfMovil().setText(modeloImplementacion.getTlfMovil());
		controladorPantallaPrincipal.getTipoPersona().setText(modeloImplementacion.getTipoPersona());
		controladorPantallaPrincipal.getDireccion().setText(modeloImplementacion.getDireccion());
		controladorPantallaPrincipal.getMunicipio().setText(modeloImplementacion.getMunicipio());
		controladorPantallaPrincipal.getCp().setText(modeloImplementacion.getCp());
		controladorPantallaPrincipal.getEmail().setText(modeloImplementacion.getEmail());

	}

	public void devolverDatosExtra2() {
		controladorPantallaPrincipal.getTxtAreaDescripcionActividad().setText(modeloImplementacion.getDescripcion());
		controladorPantallaPrincipal.getTxtfTipoActividad().setText(modeloImplementacion.getLicencia());
		controladorPantallaPrincipal.getTxtfReferenciaCatastral().setText(modeloImplementacion.getCatastro());
		controladorPantallaPrincipal.getTxtfFechaInicioActividad()
				.setText(modeloImplementacion.getFechaInicioActividad());
		controladorPantallaPrincipal.getTxtfFechaInicioSolicitud()
				.setText(modeloImplementacion.getFechaInicioSolicitud());

		if (modeloImplementacion.getFotocopiaDNI().equalsIgnoreCase("SI")) {
			controladorPantallaPrincipal.getFotocopiaDNI().setSelected(true);
		} else if (modeloImplementacion.getFotocopiaDNI().equalsIgnoreCase("NO")) {
			controladorPantallaPrincipal.getFotocopiaDNI().setSelected(false);
		}
		if (modeloImplementacion.getFotocopiaImpuestos().equalsIgnoreCase("SI")) {
			controladorPantallaPrincipal.getFotocopiaImpuestoActividad().setSelected(true);
		} else if (modeloImplementacion.getFotocopiaImpuestos().equalsIgnoreCase("NO")) {
			controladorPantallaPrincipal.getFotocopiaImpuestoActividad().setSelected(false);
		}
		if (modeloImplementacion.getFotografia().equalsIgnoreCase("SI")) {
			controladorPantallaPrincipal.getFotografias().setSelected(true);
		} else if (modeloImplementacion.getFotografia().equalsIgnoreCase("NO")) {
			controladorPantallaPrincipal.getFotografias().setSelected(false);
		}
		if (modeloImplementacion.getFotocopiaObra().equalsIgnoreCase("SI")) {
			controladorPantallaPrincipal.getFotocopiaObraAdaptacion().setSelected(true);
		} else if (modeloImplementacion.getFotocopiaObra().equalsIgnoreCase("NO")) {
			controladorPantallaPrincipal.getFotocopiaObraAdaptacion().setSelected(false);
		}
		if (modeloImplementacion.getFotocopiaEscritura().equalsIgnoreCase("SI")) {
			controladorPantallaPrincipal.getFotocopiaEscritura().setSelected(true);
		} else if (modeloImplementacion.getFotocopiaEscritura().equalsIgnoreCase("NO")) {
			controladorPantallaPrincipal.getFotocopiaEscritura().setSelected(false);
		}
		if (modeloImplementacion.getFotocopiaMemoria().equalsIgnoreCase("SI")) {
			controladorPantallaPrincipal.getMemoriaActividad().setSelected(true);
		} else if (modeloImplementacion.getFotocopiaMemoria().equalsIgnoreCase("NO")) {
			controladorPantallaPrincipal.getMemoriaActividad().setSelected(false);
		}
		if (modeloImplementacion.getFotocopiaPago().equalsIgnoreCase("SI")) {
			controladorPantallaPrincipal.getJustificantePago().setSelected(true);
		} else if (modeloImplementacion.getFotocopiaPago().equalsIgnoreCase("NO")) {
			controladorPantallaPrincipal.getJustificantePago().setSelected(false);
		}
		if (modeloImplementacion.getFotocopiaOtras().equalsIgnoreCase("SI")) {
			controladorPantallaPrincipal.getOtrasAutorizaciones().setSelected(true);
		} else if (modeloImplementacion.getFotocopiaOtras().equalsIgnoreCase("NO")) {
			controladorPantallaPrincipal.getOtrasAutorizaciones().setSelected(false);
		}
		if (modeloImplementacion.getCertificado1().equalsIgnoreCase("SI")) {
			controladorPantallaPrincipal.getCertificadoModelo1().setSelected(true);
		} else if (modeloImplementacion.getCertificado1().equalsIgnoreCase("NO")) {
			controladorPantallaPrincipal.getCertificadoModelo1().setSelected(false);
		}
		if (modeloImplementacion.getCertificado2().equalsIgnoreCase("SI")) {
			controladorPantallaPrincipal.getCertificadoModelo2().setSelected(true);
		} else if (modeloImplementacion.getCertificado2().equalsIgnoreCase("NO")) {
			controladorPantallaPrincipal.getCertificadoModelo1().setSelected(false);
		}
		if (modeloImplementacion.getPlanos().equalsIgnoreCase("SI")) {
			controladorPantallaPrincipal.getPlanosLocal().setSelected(true);
		} else if (modeloImplementacion.getPlanos().equalsIgnoreCase("NO")) {
			controladorPantallaPrincipal.getPlanosLocal().setSelected(false);
		}

	}

	public ControladorPantallaPrincipal getControladorPantallaPrincipal() {
		return controladorPantallaPrincipal;
	}

	public void setControladorPantallaPrincipal(ControladorPantallaPrincipal controladorPantallaPrincipal) {
		this.controladorPantallaPrincipal = controladorPantallaPrincipal;
	}

	public void setModelo(MImplementacionFX modelo) {
		this.modeloImplementacion = modelo;

	}

	private void setConexionBBD(ControladorPantallaConexionBBDD conexionBBDD) {
		this.conexionBBDD = conexionBBDD;

	}

	public void setBBDD() {
		modeloImplementacion.setBBDD(conexionBBDD.getTxtfUsuario().getText(), conexionBBDD.getTxtfPass().getText(),
				conexionBBDD.getTxtfURL().getText());

	}

	public void comprobarConexion() {
		conexionBBDD.getResultado().setText(modeloImplementacion.ConexionBBDD());

	}

	public void recogerRegistroCambioTitularidad() {
		index = controladorPantallaPrincipal.getTabla_persona().getSelectionModel().getSelectedIndex();
		Registro registro = controladorPantallaPrincipal.getRegistros().get(index);
		numRegistro = registro.getRegistro();

		modeloImplementacion.recogerDatosParaCambioTitularidad(numRegistro);

	}

	public void recogerRegistroCambioDatosLicencia() {
		index = controladorPantallaPrincipal.getTabla_persona().getSelectionModel().getSelectedIndex();
		Registro registro = controladorPantallaPrincipal.getRegistros().get(index);
		numRegistro = registro.getRegistro();

		modeloImplementacion.recogerDatosParaCambioLicencia(numRegistro);

	}
	
	public void recogerRegistroCambioDatosLicencia2() {
		index = controladorPantallaPrincipal.getTabla_licencias().getSelectionModel().getSelectedIndex();
		Registro2 registro = controladorPantallaPrincipal.getRegistros2().get(index);
		numRegistro = registro.getRegistro2();

		modeloImplementacion.recogerDatosParaCambioLicencia(numRegistro);

	}

	public void devolverDatosTitular() {
		if (modeloImplementacion.getTipoPersonaCT().equalsIgnoreCase("FISICA")) {
			this.cambioTitularidad.getTxtfNombre().setDisable(false);
			this.cambioTitularidad.getTxtfApellidos().setDisable(false);
			this.cambioTitularidad.getTxtfRazonSocial().setDisable(true);
		} else if (modeloImplementacion.getTipoPersonaCT().equalsIgnoreCase("JURIDICA")) {
			this.cambioTitularidad.getTxtfNombre().setDisable(true);
			this.cambioTitularidad.getTxtfApellidos().setDisable(true);
			this.cambioTitularidad.getTxtfRazonSocial().setDisable(false);

		}
		this.cambioTitularidad.getComboBoxTipoPersona().setDisable(true);
		this.cambioTitularidad.getTxtfNombre().setText(modeloImplementacion.getNombreCT());
		this.cambioTitularidad.getTxtfApellidos().setText(modeloImplementacion.getApellidosCT());
		this.cambioTitularidad.getComboBoxTipoPersona().setValue(modeloImplementacion.getTipoPersonaCT());
		this.cambioTitularidad.getTxtfDireccion().setText(modeloImplementacion.getDireccionCT());
		this.cambioTitularidad.getTxtfMunicipio().setText(modeloImplementacion.getMunicipioCT());
		this.cambioTitularidad.getTxtfCP().setText(modeloImplementacion.getCpCT());
		this.cambioTitularidad.getTxtfRazonSocial().setText(modeloImplementacion.getRazonSocialCT());
		this.cambioTitularidad.getTxtfDNI().setText(modeloImplementacion.getCifCT());
		this.cambioTitularidad.getTxtfTlfFijo().setText(modeloImplementacion.getTlfFijoCT());
		this.cambioTitularidad.getTxtfTlfMovil().setText(modeloImplementacion.getTlfMovilCT());
		this.cambioTitularidad.getTxtfEmail().setText(modeloImplementacion.getEmailCT());
		this.cambioTitularidad.getTxtfFax().setText(modeloImplementacion.getFaxCT());

	}

	public void recogerRegistroCambioTitularidad2() {
		index = controladorPantallaPrincipal.getTabla_licencias().getSelectionModel().getSelectedIndex();
		Registro2 registro = controladorPantallaPrincipal.getRegistros2().get(index);
		numRegistro = registro.getRegistro2();
		modeloImplementacion.recogerDatosParaCambioTitularidad(numRegistro);

	}

	public void recogerDatosNuevoTitular() {
		nombreCT = cambioTitularidad.getTxtfNombre().getText();
		apellidosCT = cambioTitularidad.getTxtfApellidos().getText();
		tipoPersonaCT = cambioTitularidad.getComboBoxTipoPersona2();
		direccionCT = cambioTitularidad.getTxtfDireccion().getText();
		municipioCT = cambioTitularidad.getTxtfMunicipio().getText();
		CPCT = cambioTitularidad.getTxtfCP().getText();
		razonSocialCT = cambioTitularidad.getTxtfRazonSocial().getText();
		dniCT = cambioTitularidad.getTxtfDNI().getText();
		tlfFijoCT = cambioTitularidad.getTxtfTlfFijo().getText();
		tlfMovilCT = cambioTitularidad.getTxtfTlfMovil().getText();
		emailCT = cambioTitularidad.getTxtfEmail().getText();
		faxCT = cambioTitularidad.getTxtfFax().getText();
		planosCT = cambioTitularidad.getPlanos();
		licenciaAntCT = cambioTitularidad.getLicenciAnterior();
		escriturasCT = cambioTitularidad.getEscrituras();
		numExpedienteCT = cambioTitularidad.getNumExpediente();

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmación de cambio de titular");
		alert.setHeaderText("Se va a procesar el cambio de titular. ¿Estás seguro?");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			try {
				this.modeloImplementacion.actualizarTitular(nombreCT, apellidosCT, tipoPersonaCT, direccionCT,
						municipioCT, CPCT, razonSocialCT, dniCT, tlfFijoCT, tlfMovilCT, emailCT, faxCT, numRegistro,
						planosCT, licenciaAntCT, escriturasCT, numExpedienteCT);
			} catch (Exception e) {
				Alert alert2 = new Alert(AlertType.ERROR);
				alert2.setTitle("Error");
				alert2.setHeaderText("Se ha producido un error. Revise todos los campos y vuelva a intentarlo.");
			}
		} else {

		}

	}

	public void actualizarTablas() {
		this.controladorPantallaPrincipal.initialize();
		modeloImplementacion.recogerDatosBBDDPersonas();
		modeloImplementacion.recogerDatosBBDDLicencias();

	}

	public void tablaHistorico() {
		historico.getRegistroHistorico().add(new Registro3(modeloImplementacion.getRegistroHistorico(),
				modeloImplementacion.getNuevoTitularHistorico(), modeloImplementacion.getFechaNuevoTitularHistorico(),
				modeloImplementacion.getAntiguoTitularHistorico(),
				modeloImplementacion.getFechaAntiguoTitularHistorico()));
		historico.getTabla_historico().setItems(historico.getRegistroHistorico());
		historico.getColumnRegistro().setCellValueFactory(new PropertyValueFactory<Registro3, String>("registro3"));
		historico.getColumnDNINuevoTitular()
				.setCellValueFactory(new PropertyValueFactory<Registro3, String>("dniNuevoTitular"));
		historico.getColumnFechaNuevoTitular()
				.setCellValueFactory(new PropertyValueFactory<Registro3, String>("fechaInicioActividadNuevoTitular"));
		historico.getColumnDNIAntiguoTitular()
				.setCellValueFactory(new PropertyValueFactory<Registro3, String>("dniAntiguoTitular"));
		historico.getColumnFechaAntiguoTitular()
				.setCellValueFactory(new PropertyValueFactory<Registro3, String>("fechaInicioActividadAntiguoTitular"));

	}

	public void mostrarDatosExtraHistorico() {
		index = historico.getTabla_historico().getSelectionModel().getSelectedIndex();
		Registro3 registro = historico.getRegistroHistorico().get(index);
		numRegistro = registro.getRegistro3();

		modeloImplementacion.recogerDocumentacionCambioTitularidad(numRegistro);

	}

	public void devolverDocumentacionNuevoTitular() {
		if (modeloImplementacion.getNumeroExpedienteHistorico().equalsIgnoreCase("SI")) {
			historico.getNumExpediente().setSelected(true);
		} else if (modeloImplementacion.getNumeroExpedienteHistorico().equalsIgnoreCase("NO")) {
			historico.getNumExpediente().setSelected(false);
		}
		if (modeloImplementacion.getLicenciaAnteriorHistorico().equalsIgnoreCase("SI")) {
			historico.getLicenciaAnterior().setSelected(true);
		} else if (modeloImplementacion.getLicenciaAnteriorHistorico().equalsIgnoreCase("NO")) {
			historico.getLicenciaAnterior().setSelected(false);
		}
		if (modeloImplementacion.getPlanosLocalHistorico().equalsIgnoreCase("SI")) {
			historico.getPlanos().setSelected(true);
		} else if (modeloImplementacion.getPlanosLocalHistorico().equalsIgnoreCase("NO")) {
			historico.getPlanos().setSelected(false);
		}
		if (modeloImplementacion.getEscriturasHistorico().equalsIgnoreCase("SI")) {
			historico.getEscrituras().setSelected(true);
		} else if (modeloImplementacion.getEscriturasHistorico().equalsIgnoreCase("NO")) {
			historico.getEscrituras().setSelected(false);
		}

	}

	public void recogerDatosSolicitud() {

		if ((inicioSolicitud.getFechaSolicitudActividad2().getValue() != null)
				&& (String) inicioSolicitud.getTipoSuelo2().getValue() != null
				&& (String) inicioSolicitud.getTipoActividad2().getValue() != null
				&& !inicioSolicitud.getTxtfEmplazamiento().isEmpty()
				&& !inicioSolicitud.getTxtfRefCatastral().isEmpty()) {
			try {
				int number = Integer.parseInt(inicioSolicitud.getTxtfRefCatastral());
				this.recogerDatosSolicitud2();
				this.mostrarVentanaRegistroTitular();
				this.inicioSolicitud.getVentana().close();
			} catch (NumberFormatException e1) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("¡Atención!");
				alert.setHeaderText("El campo Referencia Catastral ha de ser un número.");
				alert.showAndWait();
			}

		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("¡Atención!");
			alert.setHeaderText("Rellene los campos con asteríscos.");
			alert.showAndWait();
		}

	}

	private void recogerDatosSolicitud2() {
		registroSolicitud = inicioSolicitud.getTxtfNRegistro();
		fechaInicioActividad = inicioSolicitud.getFechaInicioActividad();
		fechaInicioSolicitud = inicioSolicitud.getFechaSolicitudActividad();
		fechaInicioSolicitudDate = inicioSolicitud.getFechaSolicitudActividad3();
		fotocopiaDniCheck = inicioSolicitud.getFotocopiaDNI3();
		fotocopiaImpuestoCheck = inicioSolicitud.getFotocopiaImpuestoActividad3();
		fotocopiaFotosCheck = inicioSolicitud.getFotografias3();
		fotocopiaEscriturasCheck = inicioSolicitud.getFotocopiaEscrituras3();
		fotocopiaMemoriaCheck = inicioSolicitud.getMemoriaActividad3();
		fotocopiaPlanosCheck = inicioSolicitud.getPlanosLocal3();
		fotocopiaJustificanteCheck = inicioSolicitud.getJustificantePago3();
		fotocopiaObraCheck = inicioSolicitud.getFotocopiaLicenciaObraAdaptacion3();
		fotocopiaCertificado1Check = inicioSolicitud.getCertificadoModelo1_3();
		fotocopiaCertificado2Check = inicioSolicitud.getCertificadoModelo2_3();
		fotocopiaOtrasCheck = inicioSolicitud.getOtrasAutorizaciones3();
		tipoSuelo = inicioSolicitud.getTipoSuelo();
		emplazamiento = inicioSolicitud.getTxtfEmplazamiento();
		refCatastral = inicioSolicitud.getTxtfRefCatastral();
		estadoSolicitud = inicioSolicitud.getEstadoInicialLicencia();
		tipoActividad = inicioSolicitud.getTipoActividad();
		descripcionActividad = inicioSolicitud.getTxtfDescripcionLicencia();
		fotocopiaDni = inicioSolicitud.getFotocopiaDNI();
		fotocopiaImpuestos = inicioSolicitud.getFotocopiaImpuestoActividad();
		fotografia = inicioSolicitud.getFotografias();
		fotocopiaEscrituras = inicioSolicitud.getFotocopiaEscrituras();
		justificantePago = inicioSolicitud.getJustificantePago();
		memoriaActividad = inicioSolicitud.getMemoriaActividad();
		planosLocal = inicioSolicitud.getPlanosLocal();
		fotocopiaLicenciaObra = inicioSolicitud.getFotocopiaLicenciaObraAdaptacion();
		certificado1 = inicioSolicitud.getCertificadoModelo1();
		certificado2 = inicioSolicitud.getCertificadoModelo2();
		otrasAutorizaciones = inicioSolicitud.getOtrasAutorizaciones();

	}

	public void completarSolicitud() {
		if (registroTitular.getLblRepresentante().isDisable()) {
			if (!registroTitular.getTxtfNombre().isEmpty() && !registroTitular.getTxtfApellidos().isEmpty()
					&& !registroTitular.getTxtfDireccion().isEmpty() && !registroTitular.getTxtfMunicipio().isEmpty()
					&& !registroTitular.getTxtfDNI().isEmpty()) {
				if (!registroTitular.getTxtfCodPostal().isEmpty()) {
					try {
						int number = Integer.parseInt(registroTitular.getTxtfCodPostal());

					} catch (NumberFormatException e1) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("¡Atención!");
						alert.setHeaderText("Revisa los campos numericos( Teléfono Fijo, Móvil, Fax y CP).");
						alert.showAndWait();
					}

				}

				if (!registroTitular.getTxtfTlfFijo().isEmpty()) {
					try {
						int number = Integer.parseInt(registroTitular.getTxtfTlfFijo());

					} catch (NumberFormatException e1) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("¡Atención!");
						alert.setHeaderText("Revisa los campos numericos( Teléfono Fijo, Móvil, Fax y CP).");
						alert.showAndWait();
					}

				}
				if (!registroTitular.getTxtfTlfMovil().isEmpty()) {
					try {
						int number = Integer.parseInt(registroTitular.getTxtfTlfMovil());

					} catch (NumberFormatException e1) {

						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("¡Atención!");
						alert.setHeaderText("Revisa los campos numericos( Teléfono Fijo, Móvil, Fax y CP).");
						alert.showAndWait();
					}

				}

				if (!registroTitular.getTxtfFax().isEmpty()) {
					try {
						int number = Integer.parseInt(registroTitular.getTxtfFax());

					} catch (NumberFormatException e1) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("¡Atención!");
						alert.setHeaderText("Revisa los campos numericos( Teléfono Fijo, Móvil, Fax y CP).");
						alert.showAndWait();
					}
				}

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmación de solicitud.");
				alert.setHeaderText("Se va a procesar la nueva solicitud. ¿Estás seguro?");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					try {
						this.recogerDatosRegistroTitular();
						registroTitular.getVentana().close();
					} catch (Exception e) {
						Alert alert2 = new Alert(AlertType.ERROR);
						alert2.setTitle("Error");
						alert2.setHeaderText(
								"Se ha producido un error. Revise todos los campos y vuelva a intentarlo.");
						alert2.showAndWait();
					}
				} else {

				}

			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("¡Atención!");
				alert.setHeaderText("Rellene los campos con asteríscos.");
				alert.showAndWait();
			}

		} else if (!registroTitular.getLblRepresentante().isDisable()) {
			if (!registroTitular.getTxtfRazonSocial().isEmpty() && !registroTitular.getTxtfDireccion().isEmpty()
					&& !registroTitular.getTxtfDireccionRE().isEmpty() && !registroTitular.getTxtfNombreRE().isEmpty()
					&& !registroTitular.getTxtfApellidosRE().isEmpty() && !registroTitular.getTxtfMunicipio().isEmpty()
					&& !registroTitular.getTxtfMunicipioRE().isEmpty() && !registroTitular.getTxtfDNI().isEmpty()
					&& !registroTitular.getTxtfDNIRE().isEmpty()) {
				if (!registroTitular.getTxtfCodPostal().isEmpty()) {
					try {
						int number = Integer.parseInt(registroTitular.getTxtfCodPostal());

					} catch (NumberFormatException e1) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("¡Atención!");
						alert.setHeaderText("Revisa los campos numericos( Teléfono Fijo, Móvil, Fax y CP).");
						alert.showAndWait();
					}

				}
				if (!registroTitular.getTxtfCodPostalRE().isEmpty()) {
					try {

						int number2 = Integer.parseInt(registroTitular.getTxtfCodPostalRE());

					} catch (NumberFormatException e1) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("¡Atención!");
						alert.setHeaderText("Revisa los campos numericos( Teléfono Fijo, Móvil, Fax y CP).");
						alert.showAndWait();
					}

				}

				if (!registroTitular.getTxtfTlfFijo().isEmpty()) {
					try {
						int number = Integer.parseInt(registroTitular.getTxtfTlfFijo());

					} catch (NumberFormatException e1) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("¡Atención!");
						alert.setHeaderText("Revisa los campos numericos( Teléfono Fijo, Móvil, Fax y CP).");
						alert.showAndWait();
					}

				}
				if (!registroTitular.getTxtfTlfFijoRE().isEmpty()) {
					try {

						int number2 = Integer.parseInt(registroTitular.getTxtfTlfFijoRE());

					} catch (NumberFormatException e1) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("¡Atención!");
						alert.setHeaderText("Revisa los campos numericos( Teléfono Fijo, Móvil, Fax y CP).");
						alert.showAndWait();
					}

				}
				if (!registroTitular.getTxtfTlfMovil().isEmpty()) {
					try {
						int number = Integer.parseInt(registroTitular.getTxtfTlfMovil());

					} catch (NumberFormatException e1) {

						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("¡Atención!");
						alert.setHeaderText("Revisa los campos numericos( Teléfono Fijo, Móvil, Fax y CP).");
						alert.showAndWait();
					}

				}
				if (!registroTitular.getTxtfTlfMovilRE().isEmpty()) {
					try {

						int number2 = Integer.parseInt(registroTitular.getTxtfTlfMovilRE());

					} catch (NumberFormatException e1) {

						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("¡Atención!");
						alert.setHeaderText("Revisa los campos numericos( Teléfono Fijo, Móvil, Fax y CP).");
						alert.showAndWait();
					}

				}
				if (!registroTitular.getTxtfFax().isEmpty()) {
					try {
						int number = Integer.parseInt(registroTitular.getTxtfFax());

					} catch (NumberFormatException e1) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("¡Atención!");
						alert.setHeaderText("Revisa los campos numericos( Teléfono Fijo, Móvil, Fax y CP).");
						alert.showAndWait();
					}
				}
				if (!registroTitular.getTxtfFaxRE().isEmpty()) {
					try {
						int number2 = Integer.parseInt(registroTitular.getTxtfFax());

					} catch (NumberFormatException e1) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("¡Atención!");
						alert.setHeaderText("Revisa los campos numericos( Teléfono Fijo, Móvil, Fax y CP).");
						alert.showAndWait();
					}
				}

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmación de solicitud.");
				alert.setHeaderText("Se va a procesar la nueva solicitud. ¿Estás seguro?");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					try {
						this.recogerDatosRegistroTitular();
						registroTitular.getVentana().close();
					} catch (Exception e) {

					}
				} else {

				}

			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("¡Atención!");
				alert.setHeaderText("Rellene los campos con asteríscos.");
				alert.showAndWait();
			}
		}

	}

	private void recogerDatosRegistroTitular() {
		nombreT = registroTitular.getTxtfNombre();
		apellidosT = registroTitular.getTxtfApellidos();
		nombreR = registroTitular.getTxtfNombreRE();
		apellidosR = registroTitular.getTxtfApellidosRE();
		tipoPersonaT = registroTitular.getTipoPersona().getValue().toString();
		direccionT = registroTitular.getTxtfDireccion();
		direccionR = registroTitular.getTxtfDireccionRE();
		municipioT = registroTitular.getTxtfMunicipio();
		municipioR = registroTitular.getTxtfMunicipioRE();
		razonSocialT = registroTitular.getTxtfRazonSocial();
		dniT = registroTitular.getTxtfDNI();
		dniR = registroTitular.getTxtfDNIRE();
		emailT = registroTitular.getTxtfEmail();
		emailR = registroTitular.getTxtfEmailRE();

		if (registroTitular.getTxtfCodPostal().isEmpty()) {
			CPT = "00000";
		} else {
			CPT = registroTitular.getTxtfCodPostal();
		}
		if (registroTitular.getTxtfCodPostalRE().isEmpty()) {
			CPR = "00000";
		} else {
			CPR = registroTitular.getTxtfCodPostalRE();
		}
		if (registroTitular.getTxtfTlfFijo().isEmpty()) {
			tlfFijoT = "000000000";
		} else {
			tlfFijoT = registroTitular.getTxtfTlfFijo();
		}
		if (registroTitular.getTxtfTlfFijoRE().isEmpty()) {
			tlfFijoR = "000000000";
		} else {
			tlfFijoR = registroTitular.getTxtfTlfFijoRE();
		}
		if (registroTitular.getTxtfTlfMovil().isEmpty()) {
			tlfMovilT = "000000000";
		} else {
			tlfMovilT = registroTitular.getTxtfTlfMovil();
		}
		if (registroTitular.getTxtfTlfMovilRE().isEmpty()) {
			tlfMovilR = "000000000";
		} else {
			tlfMovilR = registroTitular.getTxtfTlfMovilRE();
		}
		if (registroTitular.getTxtfFax().isEmpty()) {
			faxT = "000000000";
		} else {
			faxT = registroTitular.getTxtfFax();
		}
		if (registroTitular.getTxtfFaxRE().isEmpty()) {
			faxR = "000000000";
		} else {
			faxR = registroTitular.getTxtfFaxRE();
		}
		this.enviarCamposSolicitud();

	}

	private void enviarCamposSolicitud() {
		String insertSolicitante = "";
		if (registroTitular.getLblRepresentante().isDisable()) {
			insertSolicitante = "físico";

		} else if (!registroTitular.getLblRepresentante().isDisable()) {
			insertSolicitante = "jurídico";

		}
		modeloImplementacion.insertarDatos(insertSolicitante, nombreT, apellidosT, nombreR, apellidosR, tipoPersonaT,
				direccionT, direccionR, municipioT, municipioR, razonSocialT, dniT, dniR, emailT, emailR, CPT, CPR,
				tlfFijoT, tlfFijoR, tlfMovilT, tlfMovilR, faxT, faxR, registroSolicitud, fechaInicioActividad,
				fechaInicioSolicitud, tipoSuelo, emplazamiento, refCatastral, estadoSolicitud, tipoActividad,
				descripcionActividad, fotocopiaDni, fotocopiaImpuestos, fotografia, fotocopiaEscrituras,
				justificantePago, memoriaActividad, planosLocal, fotocopiaLicenciaObra, certificado1, certificado2,
				otrasAutorizaciones);

	}

	public void accionReplicarDatos() {
		registroTitular.getTxtfNombreRE2().setText(registroTitular.getTxtfNombre());
		registroTitular.getTxtfApellidosRE2().setText(registroTitular.getTxtfApellidos());
		registroTitular.getTxtfDireccionRE2().setText(registroTitular.getTxtfDireccion());
		registroTitular.getTxtfMunicipioRE2().setText(registroTitular.getTxtfMunicipio());
		registroTitular.getTxtfCodPostalRE2().setText(registroTitular.getTxtfCodPostal());
		registroTitular.getTxtfDNIRE2().setText(registroTitular.getTxtfDNI());
		registroTitular.getTxtfTlfFijoRE2().setText(registroTitular.getTxtfTlfFijo());
		registroTitular.getTxtfTlfMovilRE2().setText(registroTitular.getTxtfTlfMovil());
		registroTitular.getTxtfEmailRE2().setText(registroTitular.getTxtfEmail());
		registroTitular.getTxtfFaxRE2().setText(registroTitular.getTxtfFax());

	}

	public void mostrarDatosAnteriores() {
		inicioSolicitud.getFechaSolicitudActividad2().setValue(fechaInicioSolicitudDate);
		inicioSolicitud.getTipoSuelo2().setValue(tipoSuelo);
		inicioSolicitud.getTxtfEmplazamiento2().setText(emplazamiento);
		inicioSolicitud.getTxtfRefCatastral2().setText(refCatastral);
		inicioSolicitud.getEstadoInicialLicencia2().setValue(estadoSolicitud);
		inicioSolicitud.getTipoActividad2().setValue(tipoActividad);
		inicioSolicitud.getTxtfDescripcionLicencia2().setText(descripcionActividad);
		if (fotocopiaDniCheck.isSelected()) {
			inicioSolicitud.getFotocopiaDNI2().setSelected(true);
		}
		if (fotocopiaImpuestoCheck.isSelected()) {
			inicioSolicitud.getFotocopiaImpuestoActividad2().setSelected(true);
		}
		if (fotocopiaFotosCheck.isSelected()) {
			inicioSolicitud.getFotografias2().setSelected(true);
		}
		if (fotocopiaEscriturasCheck.isSelected()) {
			inicioSolicitud.getFotocopiaEscrituras2().setSelected(true);
		}
		if (fotocopiaJustificanteCheck.isSelected()) {
			inicioSolicitud.getJustificantePago2().setSelected(true);
		}
		if (fotocopiaMemoriaCheck.isSelected()) {
			inicioSolicitud.getMemoriaActividad2().setSelected(true);
		}
		if (fotocopiaPlanosCheck.isSelected()) {
			inicioSolicitud.getPlanosLocal2().setSelected(true);
		}
		if (fotocopiaObraCheck.isSelected()) {
			inicioSolicitud.getFotocopiaLicenciaObraAdaptacion2().setSelected(true);
		}
		if (fotocopiaCertificado1Check.isSelected()) {
			inicioSolicitud.getCertificadoModelo1_2().setSelected(true);
		}

		if (fotocopiaCertificado2Check.isSelected()) {
			inicioSolicitud.getCertificadoModelo2_2().setSelected(true);
		}
		if (inicioSolicitud.getOtrasAutorizaciones3().isSelected()) {
			inicioSolicitud.getOtrasAutorizaciones2();
		}

	}

	public void devolverDatosDeLicencia() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		try {
			System.out.println(modeloImplementacion.getFechaInicioActividadCambioDatos());
			LocalDate localDate = LocalDate.parse(modeloImplementacion.getFechaInicioActividadCambioDatos(), formatter);
			if (!modeloImplementacion.getFechaInicioActividadCambioDatos().equals("")
					|| modeloImplementacion.getFechaInicioActividadCambioDatos() != null) {
				cambioDatosLicencia.getFechaInicioActividadCambio().setValue(localDate);
				cambioDatosLicencia.getFechaInicioActividadCambio().setDisable(true);
				System.out.println("fecha??");
			} else if (modeloImplementacion.getFechaInicioActividadCambioDatos().equals("")
					|| modeloImplementacion.getFechaInicioActividadCambioDatos() == null) {

			}
		} catch (Exception e) {
			LocalDate localDate = null;
			cambioDatosLicencia.getFechaInicioActividadCambio().setDisable(false);
			cambioDatosLicencia.getFechaInicioActividadCambio().setValue(localDate);
		}

		cambioDatosLicencia.getRegistroCambio().setText(modeloImplementacion.getRegistroCambioDatos());
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate2 = LocalDate.parse(modeloImplementacion.getFechaSolicitudCambioDatos(), formatter2);
		cambioDatosLicencia.getFechaInicioSolicitudCambio().setValue(localDate2);
		cambioDatosLicencia.getTipoSueloCambio().setValue(modeloImplementacion.getTipoDeSueloCambioDatos());
		cambioDatosLicencia.getEmplazamientoCambio().setText(modeloImplementacion.getEmplazamientoCambioDatos());
		cambioDatosLicencia.getReferenciaCatastralCambio()
				.setText(modeloImplementacion.getReferenciaCatastralCambioDatos());
		cambioDatosLicencia.getEstadoLicenciaCambio().setValue(modeloImplementacion.getEstadoSolicitudCambioDatos());
		cambioDatosLicencia.getTipoLicenciaCambio().setValue(modeloImplementacion.getTipoDeActividadCambioDatos());
		cambioDatosLicencia.getDescripcionActividadCambio()
				.setText(modeloImplementacion.getDescripcionActividadCambioDatos());

		if (modeloImplementacion.getFotocopiaDNICambioDatos().equalsIgnoreCase("SI")) {
			cambioDatosLicencia.getFotocopiaDNICambio().setSelected(true);
		} else if (modeloImplementacion.getFotocopiaDNICambioDatos().equalsIgnoreCase("NO")) {
			cambioDatosLicencia.getFotocopiaDNICambio().setSelected(false);
		}
		if (modeloImplementacion.getFotocopiaImpuestosCambioDatos().equalsIgnoreCase("SI")) {
			cambioDatosLicencia.getFotocopiaImpuestosCambio().setSelected(true);
		} else if (modeloImplementacion.getFotocopiaImpuestosCambioDatos().equalsIgnoreCase("NO")) {
			cambioDatosLicencia.getFotocopiaImpuestosCambio().setSelected(false);
		}
		if (modeloImplementacion.getFotografiasCambioDatos().equalsIgnoreCase("SI")) {
			cambioDatosLicencia.getFotografiasCambio().setSelected(true);
		} else if (modeloImplementacion.getFotografiasCambioDatos().equalsIgnoreCase("NO")) {
			cambioDatosLicencia.getFotografiasCambio().setSelected(false);
		}
		if (modeloImplementacion.getFotocopiaEscriturasCambioDatos().equalsIgnoreCase("SI")) {
			cambioDatosLicencia.getFotocopiaEscriturasCambio().setSelected(true);
		} else if (modeloImplementacion.getFotocopiaEscriturasCambioDatos().equalsIgnoreCase("NO")) {
			cambioDatosLicencia.getFotocopiaEscriturasCambio().setSelected(false);
		}
		if (modeloImplementacion.getJustificantePagoCambioDatos().equalsIgnoreCase("SI")) {
			cambioDatosLicencia.getJustificantePagoCambio().setSelected(true);
		} else if (modeloImplementacion.getJustificantePagoCambioDatos().equalsIgnoreCase("NO")) {
			cambioDatosLicencia.getJustificantePagoCambio().setSelected(false);
		}
		if (modeloImplementacion.getMemoriaActividadCambioDatos().equalsIgnoreCase("SI")) {
			cambioDatosLicencia.getMemoriaActividadCambio().setSelected(true);
		} else if (modeloImplementacion.getMemoriaActividadCambioDatos().equalsIgnoreCase("NO")) {
			cambioDatosLicencia.getMemoriaActividadCambio().setSelected(false);
		}
		if (modeloImplementacion.getPlanosDeLocalCambioDatos().equalsIgnoreCase("SI")) {
			cambioDatosLicencia.getPlanosLocalCambio().setSelected(true);
		} else if (modeloImplementacion.getPlanosDeLocalCambioDatos().equalsIgnoreCase("NO")) {
			cambioDatosLicencia.getPlanosLocalCambio().setSelected(false);
		}
		if (modeloImplementacion.getFotocopiaObraCambioDatos().equalsIgnoreCase("SI")) {
			cambioDatosLicencia.getFotocopiaLicenciaObraCambio().setSelected(true);
		} else if (modeloImplementacion.getFotocopiaObraCambioDatos().equalsIgnoreCase("NO")) {
			cambioDatosLicencia.getFotocopiaLicenciaObraCambio().setSelected(false);
		}
		if (modeloImplementacion.getCertificadoModelo1CambioDatos().equalsIgnoreCase("SI")) {
			cambioDatosLicencia.getCertificadoModelo1Cambio().setSelected(true);
		} else if (modeloImplementacion.getCertificadoModelo1CambioDatos().equalsIgnoreCase("NO")) {
			cambioDatosLicencia.getCertificadoModelo1Cambio().setSelected(false);
		}
		if (modeloImplementacion.getCertificadoModelo2CambioDatos().equalsIgnoreCase("SI")) {
			cambioDatosLicencia.getCertificadoModelo2Cambio().setSelected(true);
		} else if (modeloImplementacion.getCertificadoModelo2CambioDatos().equalsIgnoreCase("NO")) {
			cambioDatosLicencia.getCertificadoModelo2Cambio().setSelected(false);
		}
		if (modeloImplementacion.getOtrasAutorizacionesCambioDatos().equalsIgnoreCase("SI")) {
			cambioDatosLicencia.getOtrasAutorizacionesCambio().setSelected(true);
		} else if (modeloImplementacion.getOtrasAutorizacionesCambioDatos().equalsIgnoreCase("NO")) {
			cambioDatosLicencia.getOtrasAutorizacionesCambio().setSelected(false);
		}

	}

	public void actualizarDatosLicencia() {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmación de solicitud.");
		alert.setHeaderText("Se va a procesar la actualización de los datos de la Licencia. ¿Estás seguro?");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			try {
				modeloImplementacion.actualizarLicencia(
						cambioDatosLicencia.getEstadoLicenciaCambio().getValue().toString(),
						cambioDatosLicencia.getDescripcionActividadCambio().getText(),
						cambioDatosLicencia.getFotocopiaDNICambio2(),
						cambioDatosLicencia.getFotocopiaImpuestosCambio2(), cambioDatosLicencia.getFotografiasCambio2(),
						cambioDatosLicencia.getFotocopiaEscriturasCambio2(),
						cambioDatosLicencia.getJustificantePagoCambio2(),
						cambioDatosLicencia.getMemoriaActividadCambio2(), cambioDatosLicencia.getPlanosLocalCambio2(),
						cambioDatosLicencia.getFotocopiaLicenciaObraCambio2(),
						cambioDatosLicencia.getCertificadoModelo1Cambio2(),
						cambioDatosLicencia.getCertificadoModelo2Cambio2(),
						cambioDatosLicencia.getOtrasAutorizacionesCambio2(),
						cambioDatosLicencia.getFechaInicioActividadCambio2(),
						(String) cambioDatosLicencia.getTipoSueloCambio().getValue(),
						cambioDatosLicencia.getEmplazamientoCambio().getText(),
						cambioDatosLicencia.getReferenciaCatastralCambio().getText(),
						cambioDatosLicencia.getTipoLicenciaCambio().getValue().toString(),
						cambioDatosLicencia.getRegistroCambio().getText());
				cambioDatosLicencia.getVentana().close();
			} catch (Exception e) {

			}
		}
	}

}
