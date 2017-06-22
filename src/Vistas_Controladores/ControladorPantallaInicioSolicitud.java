package Vistas_Controladores;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import Main_ControladorPadre.Main;
import Modelo.MImplementacionFX;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ControladorPantallaInicioSolicitud implements Controlador {
	private Stage ventana;
	private Main main;
	private ControladorPantallaPrincipal controladorPantallaPrincipal;
	private ControladorPantallaRegistroTitular registroTitular;
	private MImplementacionFX modelo;

	@FXML
	private Button siguiente;
	@FXML
	private Button cancelar;
	@FXML
	private TextField txtfNRegistro;
	@FXML
	private DatePicker fechaInicioActividad;
	@FXML
	private DatePicker fechaSolicitudActividad;
	@FXML
	private ComboBox<String> tipoSuelo;
	@FXML
	private TextField txtfEmplazamiento;
	@FXML
	private TextField txtfRefCatastral;
	@FXML
	private ComboBox<String> estadoInicialLicencia;
	@FXML
	private ComboBox<String> tipoActividad;
	@FXML
	private TextArea txtfDescripcionLicencia;
	@FXML
	private CheckBox fotocopiaDNI;
	@FXML
	private CheckBox fotocopiaImpuestoActividad;
	@FXML
	private CheckBox fotografias;
	@FXML
	private CheckBox fotocopiaEscrituras;
	@FXML
	private CheckBox justificantePago;
	@FXML
	private CheckBox memoriaActividad;
	@FXML
	private CheckBox planosLocal;
	@FXML
	private CheckBox fotocopiaLicenciaObraAdaptacion;
	@FXML
	private CheckBox certificadoModelo1;
	@FXML
	private CheckBox certificadoModelo2;
	@FXML
	private CheckBox otrasAutorizaciones;
	@FXML
	private Label camposObligatorios;

	public void initialize() {
		tipoSuelo.getItems().removeAll(tipoSuelo.getItems());
		tipoSuelo.getItems().addAll("RURAL", "URBANO");
		estadoInicialLicencia.getItems().removeAll(estadoInicialLicencia.getItems());
		estadoInicialLicencia.getItems().addAll("EN TRAMITE", "ACEPTADA", "DENEGADA", "ARCHIVADA");
		tipoActividad.getItems().removeAll(tipoActividad.getItems());
		tipoActividad.getItems().addAll("SUELO CALIFICADO COMO INDUSTRIAL",
				"SUELO URBANO NO CALIFICADO COMO INDUSTRIAL", "CAJAS DE AHORROS,BANCOS, ENTIDADES FINANCIERAS",
				"SEGUROS, CAJA DE PENSIONES", "BARES, CAFETERIAS, RESTAURANTES", "SALONES RECREATIVOS Y DE JUEGO",
				"ESTABLECIMIENTOS, SECTOR ALIMENTICIO", "HOTELES,HOSTALES Y PENSIONES", "TERRAZAS DE VERANO",
				"GASOLINERAS");
	}

	@FXML
	public void abrirRegistroTitular() {
		this.main.recogerDatosSolicitud();

	}

	@FXML
	private void closeButtonAction() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmación de cierre de ventana");
		alert.setHeaderText("Se va a cancelar la solicitud. ¿Estás seguro?");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			this.ventana.close();
		} else {

		}
	}

	public String getTxtfNRegistro() {
		return txtfNRegistro.getText();
	}

	public void setTxtfNRegistro(TextField txtfNRegistro) {
		this.txtfNRegistro = txtfNRegistro;
	}

	public String getFechaInicioActividad() {
		if (fechaInicioActividad.getValue() == null) {
			String sinFecha = "";
			return sinFecha;
		}
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String date = formato.format(fechaInicioActividad.getValue());
		return date;

	}

	public String getFechaSolicitudActividad() {
		if (fechaSolicitudActividad.getValue() == null) {
			String sinFecha = "";
			return sinFecha;
		}

		String date = fechaSolicitudActividad.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println(date);
		return date;

	}

	public DatePicker getFechaSolicitudActividad2() {
		return fechaSolicitudActividad;
	}

	public LocalDate getFechaSolicitudActividad3() {
		return fechaSolicitudActividad.getValue();
	}

	public void setFechaInicioActividad(DatePicker fechaInicioActividad) {
		this.fechaInicioActividad = fechaInicioActividad;
	}

	public void setFechaSolicitudActividad(DatePicker fechaSolicitudActividad) {
		this.fechaSolicitudActividad = fechaSolicitudActividad;
	}

	public String getTipoSuelo() {
		return (String) tipoSuelo.getValue();
	}

	public ComboBox<String> getTipoSuelo2() {
		return tipoSuelo;
	}

	public void setTipoSuelo(ComboBox<String> tipoSuelo) {
		this.tipoSuelo = tipoSuelo;
	}

	public String getTxtfEmplazamiento() {
		return txtfEmplazamiento.getText();
	}

	public TextField getTxtfEmplazamiento2() {
		return txtfEmplazamiento;
	}

	public void setTxtfEmplazamiento(TextField txtfEmplazamiento) {
		this.txtfEmplazamiento = txtfEmplazamiento;
	}

	public String getTxtfRefCatastral() {
		return txtfRefCatastral.getText();
	}

	public TextField getTxtfRefCatastral2() {
		return txtfRefCatastral;
	}

	public void setTxtfRefCatastral(TextField txtfRefCatastral) {
		this.txtfRefCatastral = txtfRefCatastral;
	}

	public String getEstadoInicialLicencia() {
		return (String) estadoInicialLicencia.getValue();
	}

	public ComboBox<String> getEstadoInicialLicencia2() {
		return estadoInicialLicencia;
	}

	public void setEstadoInicialLicencia(ComboBox<String> estadoInicialLicencia) {
		this.estadoInicialLicencia = estadoInicialLicencia;
	}

	public String getTipoActividad() {
		return (String) tipoActividad.getValue();
	}

	public ComboBox<String> getTipoActividad2() {
		return tipoActividad;
	}

	public void setTipoActividad(ComboBox<String> tipoActividad) {
		this.tipoActividad = tipoActividad;
	}

	public String getTxtfDescripcionLicencia() {
		return txtfDescripcionLicencia.getText();
	}

	public TextArea getTxtfDescripcionLicencia2() {
		return txtfDescripcionLicencia;
	}

	public void setTxtfDescripcionLicencia(TextArea txtfDescripcionLicencia) {
		this.txtfDescripcionLicencia = txtfDescripcionLicencia;
	}

	public String getFotocopiaDNI() {
		String seleccionado = "";
		if (fotocopiaDNI.isSelected()) {
			seleccionado = "SI";
		} else {
			seleccionado = "NO";
		}
		return seleccionado;
	}

	public CheckBox getFotocopiaDNI2() {

		return fotocopiaDNI;
	}

	public CheckBox getFotocopiaDNI3() {

		return fotocopiaDNI;
	}

	public void setFotocopiaDNI(CheckBox fotocopiaDNI) {
		this.fotocopiaDNI = fotocopiaDNI;
	}

	public String getFotocopiaImpuestoActividad() {
		String seleccionado = "";
		if (fotocopiaImpuestoActividad.isSelected()) {
			seleccionado = "SI";
		} else {
			seleccionado = "NO";
		}
		return seleccionado;
	}

	public CheckBox getFotocopiaImpuestoActividad2() {

		return fotocopiaImpuestoActividad;
	}

	public CheckBox getFotocopiaImpuestoActividad3() {

		return fotocopiaImpuestoActividad;
	}

	public void setFotocopiaImpuestoActividad(CheckBox fotocopiaImpuestoActividad) {
		this.fotocopiaImpuestoActividad = fotocopiaImpuestoActividad;
	}

	public String getFotografias() {
		String seleccionado = "";
		if (fotografias.isSelected()) {
			seleccionado = "SI";
		} else {
			seleccionado = "NO";
		}
		return seleccionado;
	}

	public CheckBox getFotografias2() {

		return fotografias;
	}

	public CheckBox getFotografias3() {

		return fotografias;
	}

	public void setFotografias(CheckBox fotografias) {
		this.fotografias = fotografias;
	}

	public String getFotocopiaEscrituras() {

		String seleccionado = "";
		if (fotocopiaEscrituras.isSelected()) {
			seleccionado = "SI";
		} else {
			seleccionado = "NO";
		}
		return seleccionado;

	}

	public CheckBox getFotocopiaEscrituras2() {

		return fotocopiaEscrituras;

	}

	public CheckBox getFotocopiaEscrituras3() {

		return fotocopiaEscrituras;

	}

	public void setFotocopiaEscrituras(CheckBox fotocopiaEscrituras) {
		this.fotocopiaEscrituras = fotocopiaEscrituras;
	}

	public String getJustificantePago() {

		String seleccionado = "";
		if (justificantePago.isSelected()) {
			seleccionado = "SI";
		} else {
			seleccionado = "NO";
		}
		return seleccionado;

	}

	public CheckBox getJustificantePago2() {

		return justificantePago;

	}

	public CheckBox getJustificantePago3() {

		return justificantePago;

	}

	public void setJustificantePago(CheckBox justificantePago) {
		this.justificantePago = justificantePago;
	}

	public String getMemoriaActividad() {

		String seleccionado = "";
		if (memoriaActividad.isSelected()) {
			seleccionado = "SI";
		} else {
			seleccionado = "NO";
		}
		return seleccionado;
	}

	public CheckBox getMemoriaActividad2() {

		return memoriaActividad;
	}

	public CheckBox getMemoriaActividad3() {

		return memoriaActividad;
	}

	public void setMemoriaActividad(CheckBox memoriaActividad) {
		this.memoriaActividad = memoriaActividad;
	}

	public String getPlanosLocal() {

		String seleccionado = "";
		if (planosLocal.isSelected()) {
			seleccionado = "SI";
		} else {
			seleccionado = "NO";
		}
		return seleccionado;

	}

	public CheckBox getPlanosLocal2() {

		return planosLocal;

	}

	public CheckBox getPlanosLocal3() {

		return planosLocal;

	}

	public void setPlanosLocal(CheckBox planosLocal) {
		this.planosLocal = planosLocal;
	}

	public String getFotocopiaLicenciaObraAdaptacion() {
		String seleccionado = "";
		if (fotocopiaLicenciaObraAdaptacion.isSelected()) {
			seleccionado = "SI";
		} else {
			seleccionado = "NO";
		}
		return seleccionado;

	}

	public CheckBox getFotocopiaLicenciaObraAdaptacion2() {

		return fotocopiaLicenciaObraAdaptacion;

	}

	public CheckBox getFotocopiaLicenciaObraAdaptacion3() {

		return fotocopiaLicenciaObraAdaptacion;

	}

	public void setFotocopiaLicenciaObraAdaptacion(CheckBox fotocopiaLicenciaObraAdaptacion) {
		this.fotocopiaLicenciaObraAdaptacion = fotocopiaLicenciaObraAdaptacion;
	}

	public String getCertificadoModelo1() {
		String seleccionado = "";
		if (certificadoModelo1.isSelected()) {
			seleccionado = "SI";
		} else {
			seleccionado = "NO";
		}
		return seleccionado;

	}

	public CheckBox getCertificadoModelo1_2() {

		return certificadoModelo1;

	}

	public CheckBox getCertificadoModelo1_3() {

		return certificadoModelo1;

	}

	public void setCertificadoModelo1(CheckBox certificadoModelo1) {
		this.certificadoModelo1 = certificadoModelo1;
	}

	public String getCertificadoModelo2() {
		String seleccionado = "";
		if (certificadoModelo2.isSelected()) {
			seleccionado = "SI";
		} else {
			seleccionado = "NO";
		}
		return seleccionado;

	}

	public CheckBox getCertificadoModelo2_2() {

		return certificadoModelo2;

	}

	public CheckBox getCertificadoModelo2_3() {

		return certificadoModelo2;

	}

	public void setCertificadoModelo2(CheckBox certificadoModelo2) {
		this.certificadoModelo2 = certificadoModelo2;
	}

	public String getOtrasAutorizaciones() {
		String seleccionado = "";
		if (otrasAutorizaciones.isSelected()) {
			seleccionado = "SI";
		} else {
			seleccionado = "NO";
		}
		return seleccionado;

	}

	public CheckBox getOtrasAutorizaciones2() {

		return otrasAutorizaciones;

	}

	public CheckBox getOtrasAutorizaciones3() {

		return otrasAutorizaciones;

	}

	public void setOtrasAutorizaciones(CheckBox otrasAutorizaciones) {
		this.otrasAutorizaciones = otrasAutorizaciones;
	}

	public void setStagePrincipal(Stage ventana) {

		this.ventana = ventana;

	}

	public void setPantallaPrincipal(ControladorPantallaPrincipal controladorPantallaPrincipal) {
		this.controladorPantallaPrincipal = controladorPantallaPrincipal;

	}

	@Override
	public void setModelo(MImplementacionFX modelo) {
		this.modelo = modelo;

	}

	public void setMain(Main main) {
		this.main = main;

	}

	public void setRegistroTitular(ControladorPantallaRegistroTitular registroTitular) {
		this.registroTitular = registroTitular;

	}

	public Label getCamposObligatorios() {
		return camposObligatorios;
	}

	public void setCamposObligatorios(Label camposObligatorios) {
		this.camposObligatorios = camposObligatorios;
	}

	public Stage getVentana() {
		return ventana;
	}

	public void setVentana(Stage ventana) {
		this.ventana = ventana;
	}

}
