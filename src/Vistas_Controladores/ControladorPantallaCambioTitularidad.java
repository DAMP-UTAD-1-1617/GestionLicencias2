package Vistas_Controladores;

import java.util.Optional;

import javax.swing.JOptionPane;

import Main_ControladorPadre.Main;
import Modelo.MImplementacionFX;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ControladorPantallaCambioTitularidad implements Controlador{
	private ControladorPantallaPrincipal controladorPantallaPrincipal;
	private MImplementacionFX modeloImplementacion;
	private Main main;
	private Stage ventana;
	
	@FXML
	private TextField txtfNombre;
	@FXML
	private TextField txtfApellidos;
	@FXML
	private ComboBox<String> comboBoxTipoPersona;
	@FXML
	private TextField txtfDireccion;
	@FXML
	private TextField txtfMunicipio;
	@FXML
	private TextField txtfCP;
	@FXML
	private TextField txtfRazonSocial;
	@FXML
	private TextField txtfDNI;
	@FXML
	private TextField txtfTlfFijo;
	@FXML
	private TextField txtfTlfMovil;
	@FXML
	private TextField txtfEmail;
	@FXML
	private TextField txtfFax;
	@FXML
	private CheckBox escrituras;
	@FXML
	private CheckBox planos;
	@FXML
	private CheckBox licenciAnterior;
	@FXML
	private CheckBox numExpediente;
	
	@FXML
	private Button siguiente;
	@FXML
	private Button cancelar;
	

	public void initialize() {
		comboBoxTipoPersona.getItems().removeAll(comboBoxTipoPersona.getItems());
		comboBoxTipoPersona.getItems().addAll("FÍSICA","JURÍDICA");
		txtfNombre.setDisable(true);
		txtfApellidos.setDisable(true);
		txtfRazonSocial.setDisable(true);
	}
	
	public void procesarCambioTitularidad(){
		this.main.recogerDatosNuevoTitular();
		this.ventana.close();
		
		
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
	public void setStagePrincipal(Stage ventana) {
		this.ventana=ventana;
		
	}

	public void setPantallaPrincipal(ControladorPantallaPrincipal controladorPantallaPrincipal) {
		this.controladorPantallaPrincipal=controladorPantallaPrincipal;
		
	}

	public void setMain(Main main) {
		this.main=main;
		
	}

	public void setModelo(MImplementacionFX modeloImplementacion) {
		this.modeloImplementacion=modeloImplementacion;
		
	}

	public ControladorPantallaPrincipal getControladorPantallaPrincipal() {
		return controladorPantallaPrincipal;
	}

	public void setControladorPantallaPrincipal(ControladorPantallaPrincipal controladorPantallaPrincipal) {
		this.controladorPantallaPrincipal = controladorPantallaPrincipal;
	}

	public MImplementacionFX getModeloImplementacion() {
		return modeloImplementacion;
	}

	public void setModeloImplementacion(MImplementacionFX modeloImplementacion) {
		this.modeloImplementacion = modeloImplementacion;
	}

	public Stage getVentana() {
		return ventana;
	}

	public void setVentana(Stage ventana) {
		this.ventana = ventana;
	}

	public TextField getTxtfNombre() {
		return txtfNombre;
	}

	public void setTxtfNombre(TextField txtfNombre) {
		this.txtfNombre = txtfNombre;
	}

	public TextField getTxtfApellidos() {
		return txtfApellidos;
	}

	public void setTxtfApellidos(TextField txtfApellidos) {
		this.txtfApellidos = txtfApellidos;
	}

	public String getComboBoxTipoPersona2() {
		
		return (String)comboBoxTipoPersona.getValue();
	}
	public ComboBox getComboBoxTipoPersona() {
		
		return comboBoxTipoPersona;
	}

	public void setComboBoxTipoPersona(ComboBox<String> comboBoxTipoPersona) {
		this.comboBoxTipoPersona = comboBoxTipoPersona;
	}

	public TextField getTxtfDireccion() {
		return txtfDireccion;
	}

	public void setTxtfDireccion(TextField txtfDireccion) {
		this.txtfDireccion = txtfDireccion;
	}

	public TextField getTxtfMunicipio() {
		return txtfMunicipio;
	}

	public void setTxtfMunicipio(TextField txtfMunicipio) {
		this.txtfMunicipio = txtfMunicipio;
	}

	public TextField getTxtfCP() {
		return txtfCP;
	}

	public void setTxtfCP(TextField txtfCP) {
		this.txtfCP = txtfCP;
	}

	public TextField getTxtfRazonSocial() {
		return txtfRazonSocial;
	}

	public void setTxtfRazonSocial(TextField txtfRazonSocial) {
		this.txtfRazonSocial = txtfRazonSocial;
	}

	public TextField getTxtfDNI() {
		return txtfDNI;
	}

	public void setTxtfDNI(TextField txtfDNI) {
		this.txtfDNI = txtfDNI;
	}

	public TextField getTxtfTlfFijo() {
		return txtfTlfFijo;
	}

	public void setTxtfTlfFijo(TextField txtfTlfFijo) {
		this.txtfTlfFijo = txtfTlfFijo;
	}

	public TextField getTxtfTlfMovil() {
		return txtfTlfMovil;
	}

	public void setTxtfTlfMovil(TextField txtfTlfMovil) {
		this.txtfTlfMovil = txtfTlfMovil;
	}

	public TextField getTxtfEmail() {
		return txtfEmail;
	}

	public void setTxtfEmail(TextField txtfEmail) {
		this.txtfEmail = txtfEmail;
	}

	public TextField getTxtfFax() {
		return txtfFax;
	}

	public void setTxtfFax(TextField txtfFax) {
		this.txtfFax = txtfFax;
	}

	public String getEscrituras() {
		if(escrituras.isSelected()){
			return "SI";
		}
		return "NO";
	}

	public void setEscrituras(CheckBox escrituras) {
		this.escrituras = escrituras;
	}

	public String getPlanos() {
		if(planos.isSelected()){
			return "SI";
		}
		return "NO";
	}

	public void setPlanos(CheckBox planos) {
		this.planos = planos;
	}

	public String getLicenciAnterior() {
		if(licenciAnterior.isSelected()){
			return "SI";
		}
		return "NO";
	}

	public void setLicenciAnterior(CheckBox licenciAnterior) {
		this.licenciAnterior = licenciAnterior;
	}

	public String getNumExpediente() {
		if(numExpediente.isSelected()){
			return "SI";
		}
		return "NO";
	}

	public void setNumExpediente(CheckBox numExpediente) {
		this.numExpediente = numExpediente;
	}

	public Button getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Button siguiente) {
		this.siguiente = siguiente;
	}

	public Button getCancelar() {
		return cancelar;
	}

	public void setCancelar(Button cancelar) {
		this.cancelar = cancelar;
	}

	public Main getMain() {
		return main;
	}
	
	
	
}
