package Vistas_Controladores;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ControladorPantallaCambioDatosLicencia implements Controlador{

	private Stage ventana;
	private ControladorPantallaPrincipal controladorPantallaPrincipal;
	private Main main;
	private MImplementacionFX modelo;
	
	@FXML
	private TextField registroCambio;
	

	@FXML
	private DatePicker fechaInicioSolicitudCambio;
	@FXML
	private DatePicker fechaInicioActividadCambio;
	@FXML
	private ComboBox tipoSueloCambio;
	@FXML
	private TextField emplazamientoCambio;
	@FXML
	private TextField referenciaCatastralCambio;
	@FXML
	private ComboBox estadoLicenciaCambio;
	@FXML
	private ComboBox tipoLicenciaCambio;
	@FXML
	private TextArea descripcionActividadCambio;
	@FXML
	private CheckBox fotocopiaDNICambio;
	@FXML
	private CheckBox fotocopiaImpuestosCambio;
	@FXML
	private CheckBox fotografiasCambio;
	@FXML
	private CheckBox fotocopiaEscriturasCambio;
	@FXML
	private CheckBox justificantePagoCambio;
	@FXML
	private CheckBox memoriaActividadCambio;
	@FXML
	private CheckBox planosLocalCambio;
	@FXML
	private CheckBox fotocopiaLicenciaObraCambio;
	@FXML
	private CheckBox certificadoModelo1Cambio;
	@FXML
	private CheckBox certificadoModelo2Cambio;
	@FXML
	private CheckBox otrasAutorizacionesCambio;
	@FXML
	private Button btnSiguienteCambio;
	@FXML
	private Button btnCancelarCambio;
	@FXML
	private CheckBox autorizarCambios;
	
	
	public void initialize() {
		tipoSueloCambio.getItems().removeAll(tipoSueloCambio.getItems());
		tipoSueloCambio.getItems().addAll("RURAL", "URBANO");
		estadoLicenciaCambio.getItems().removeAll(estadoLicenciaCambio.getItems());
		estadoLicenciaCambio.getItems().addAll("EN TRAMITE", "ACEPTADA", "DENEGADA", "ARCHIVADA");
		tipoLicenciaCambio.getItems().removeAll(tipoLicenciaCambio.getItems());
		tipoLicenciaCambio.getItems().addAll("SUELO CALIFICADO COMO INDUSTRIAL",
				"SUELO URBANO NO CALIFICADO COMO INDUSTRIAL", "CAJAS DE AHORROS,BANCOS, ENTIDADES FINANCIERAS",
				"SEGUROS, CAJA DE PENSIONES", "BARES, CAFETERIAS, RESTAURANTES", "SALONES RECREATIVOS Y DE JUEGO",
				"ESTABLECIMIENTOS, SECTOR ALIMENTICIO", "HOTELES,HOSTALES Y PENSIONES", "TERRAZAS DE VERANO",
				"GASOLINERAS");
		
	}

	@FXML
	private void closeButtonAction(){
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmación de cierre de ventana");
		alert.setHeaderText("Se va a cancelar la solicitud. ¿Estás seguro?");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			this.ventana.close();
		} else {

		}

	}
	@FXML
	public void habilitarCampos(){
		if(autorizarCambios.isSelected()){
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmación para habilitar campos");
			alert.setHeaderText("Los campos que se van a habilitar son campos que"
					+ " en una solicitud completada no deben de modificarse.");
			alert.setContentText("Habilite estos campos si durante la solicitud, alguno de estos se rellenaron mal.");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				tipoSueloCambio.setDisable(false);
				emplazamientoCambio.setDisable(false);
				tipoLicenciaCambio.setDisable(false);
				referenciaCatastralCambio.setDisable(false);
			} else {
				tipoSueloCambio.setDisable(true);
				emplazamientoCambio.setDisable(true);
				tipoLicenciaCambio.setDisable(true);
				referenciaCatastralCambio.setDisable(true);
				autorizarCambios.setSelected(false);
				
				
			}
			
		}else{
			
		}
		
	}
	
	@FXML
	public void actualizarDatosLicencia(){
		main.actualizarDatosLicencia();
	}
	@Override
	public void setModelo(MImplementacionFX modelo) {
		this.modelo=modelo;
		
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



	public Stage getVentana() {
		return ventana;
	}



	public void setVentana(Stage ventana) {
		this.ventana = ventana;
	}



	public ControladorPantallaPrincipal getControladorPantallaPrincipal() {
		return controladorPantallaPrincipal;
	}



	public void setControladorPantallaPrincipal(ControladorPantallaPrincipal controladorPantallaPrincipal) {
		this.controladorPantallaPrincipal = controladorPantallaPrincipal;
	}



	public DatePicker getFechaInicioActividadCambio() {
		return fechaInicioActividadCambio;
	}
	public String getFechaInicioActividadCambio2() {
		if (fechaInicioActividadCambio.getValue() == null) {
			String sinFecha = "";
			return sinFecha;
		}

		String date = fechaInicioActividadCambio.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return date;
		
	}
	

	public void setFechaInicioActividadCambio(DatePicker fechaInicioActividadCambio) {
		this.fechaInicioActividadCambio = fechaInicioActividadCambio;
	}



	public ComboBox getTipoSueloCambio() {
		return tipoSueloCambio;
	}



	public void setTipoSueloCambio(ComboBox tipoSueloCambio) {
		this.tipoSueloCambio = tipoSueloCambio;
	}



	public TextField getEmplazamientoCambio() {
		return emplazamientoCambio;
	}



	public void setEmplazamientoCambio(TextField emplazamientoCambio) {
		this.emplazamientoCambio = emplazamientoCambio;
	}



	public TextField getReferenciaCatastralCambio() {
		return referenciaCatastralCambio;
	}



	public void setReferenciaCatastralCambio(TextField referenciaCatastralCambio) {
		this.referenciaCatastralCambio = referenciaCatastralCambio;
	}



	public ComboBox getEstadoLicenciaCambio() {
		return estadoLicenciaCambio;
	}



	public void setEstadoLicenciaCambio(ComboBox estadoLicenciaCambio) {
		this.estadoLicenciaCambio = estadoLicenciaCambio;
	}



	public ComboBox getTipoLicenciaCambio() {
		return tipoLicenciaCambio;
	}



	public void setTipoLicenciaCambio(ComboBox tipoLicenciaCambio) {
		this.tipoLicenciaCambio = tipoLicenciaCambio;
	}



	public TextArea getDescripcionActividadCambio() {
		return descripcionActividadCambio;
	}



	public void setDescripcionActividadCambio(TextArea descripcionActividadCambio) {
		this.descripcionActividadCambio = descripcionActividadCambio;
	}



	public CheckBox getFotocopiaDNICambio() {
		
		return fotocopiaDNICambio;
	}
	public String getFotocopiaDNICambio2() {
		if(fotocopiaDNICambio.isSelected()){
			return "SI";
		}else{
			return "NO";
		}
	}



	public void setFotocopiaDNICambio(CheckBox fotocopiaDNICambio) {
		this.fotocopiaDNICambio = fotocopiaDNICambio;
	}



	public CheckBox getFotocopiaImpuestosCambio() {
		return fotocopiaImpuestosCambio;
	}
	
	public String getFotocopiaImpuestosCambio2() {
		if(fotocopiaImpuestosCambio.isSelected()){
			return "SI";
		}else{
			return "NO";
		}
	}



	public void setFotocopiaImpuestosCambio(CheckBox fotocopiaImpuestosCambio) {
		this.fotocopiaImpuestosCambio = fotocopiaImpuestosCambio;
	}



	public CheckBox getFotografiasCambio() {
		return fotografiasCambio;
	}
	
	public String getFotografiasCambio2() {
		if(fotografiasCambio.isSelected()){
			return "SI";
		}else{
			return "NO";
		}
	}



	public void setFotografiasCambio(CheckBox fotografiasCambio) {
		this.fotografiasCambio = fotografiasCambio;
	}



	public CheckBox getFotocopiaEscriturasCambio() {
		return fotocopiaEscriturasCambio;
	}
	
	public String getFotocopiaEscriturasCambio2() {
		if(fotocopiaEscriturasCambio.isSelected()){
			return "SI";
		}else{
			return "NO";
		}
	}



	public void setFotocopiaEscriturasCambio(CheckBox fotocopiaEscriturasCambio) {
		this.fotocopiaEscriturasCambio = fotocopiaEscriturasCambio;
	}



	public CheckBox getJustificantePagoCambio() {
		return justificantePagoCambio;
	}
	
	public String getJustificantePagoCambio2() {
		if(justificantePagoCambio.isSelected()){
			return "SI";
		}else{
			return "NO";
		}
	}



	public void setJustificantePagoCambio(CheckBox justificantePagoCambio) {
		this.justificantePagoCambio = justificantePagoCambio;
	}



	public CheckBox getMemoriaActividadCambio() {
		return memoriaActividadCambio;
	}
	
	public String getMemoriaActividadCambio2() {
		if(memoriaActividadCambio.isSelected()){
			return "SI";
		}else{
			return "NO";
		}
	}



	public void setMemoriaActividadCambio(CheckBox memoriaActividadCambio) {
		this.memoriaActividadCambio = memoriaActividadCambio;
	}



	public CheckBox getPlanosLocalCambio() {
		return planosLocalCambio;
	}
	
	public String getPlanosLocalCambio2() {
		if(planosLocalCambio.isSelected()){
			return "SI";
		}else{
			return "NO";
		}
	}



	public void setPlanosLocalCambio(CheckBox planosLocalCambio) {
		this.planosLocalCambio = planosLocalCambio;
	}



	public CheckBox getFotocopiaLicenciaObraCambio() {
		return fotocopiaLicenciaObraCambio;
	}
	
	public String getFotocopiaLicenciaObraCambio2() {
		if(fotocopiaLicenciaObraCambio.isSelected()){
			return "SI";
		}else{
			return "NO";
		}
	}



	public void setFotocopiaLicenciaObraCambio(CheckBox fotocopiaLicenciaObraCambio) {
		this.fotocopiaLicenciaObraCambio = fotocopiaLicenciaObraCambio;
	}



	public CheckBox getCertificadoModelo1Cambio() {
		return certificadoModelo1Cambio;
	}
	
	public String getCertificadoModelo1Cambio2() {
		if(certificadoModelo1Cambio.isSelected()){
			return "SI";
		}else{
			return "NO";
		}
	}



	public void setCertificadoModelo1Cambio(CheckBox certificadoModelo1Cambio) {
		this.certificadoModelo1Cambio = certificadoModelo1Cambio;
	}



	public CheckBox getCertificadoModelo2Cambio() {
		return certificadoModelo2Cambio;
	}
	
	public String getCertificadoModelo2Cambio2() {
		if(certificadoModelo2Cambio.isSelected()){
			return "SI";
		}else{
			return "NO";
		}
	}



	public void setCertificadoModelo2Cambio(CheckBox certificadoModelo2Cambio) {
		this.certificadoModelo2Cambio = certificadoModelo2Cambio;
	}



	public CheckBox getOtrasAutorizacionesCambio() {
		return otrasAutorizacionesCambio;
	}
	
	public String getOtrasAutorizacionesCambio2() {
		if(otrasAutorizacionesCambio.isSelected()){
			return "SI";
		}else{
			return "NO";
		}
	}



	public void setOtrasAutorizacionesCambio(CheckBox otrasAutorizacionesCambio) {
		this.otrasAutorizacionesCambio = otrasAutorizacionesCambio;
	}



	public Button getBtnSiguienteCambio() {
		return btnSiguienteCambio;
	}



	public void setBtnSiguienteCambio(Button btnSiguienteCambio) {
		this.btnSiguienteCambio = btnSiguienteCambio;
	}



	public Button getBtnCancelarCambio() {
		return btnCancelarCambio;
	}



	public void setBtnCancelarCambio(Button btnCancelarCambio) {
		this.btnCancelarCambio = btnCancelarCambio;
	}



	public CheckBox getAutorizarCambios() {
		return autorizarCambios;
	}



	public void setAutorizarCambios(CheckBox autorizarCambios) {
		this.autorizarCambios = autorizarCambios;
	}



	public Main getMain() {
		return main;
	}



	public MImplementacionFX getModelo() {
		return modelo;
	}
	
	public TextField getRegistroCambio() {
		return registroCambio;
	}

	public void setRegistroCambio(TextField registroCambio) {
		this.registroCambio = registroCambio;
	}

	public DatePicker getFechaInicioSolicitudCambio() {
		return fechaInicioSolicitudCambio;
	}

	public void setFechaInicioSolicitudCambio(DatePicker fechaInicioSolicitudCambio) {
		this.fechaInicioSolicitudCambio = fechaInicioSolicitudCambio;
	}



	
}
