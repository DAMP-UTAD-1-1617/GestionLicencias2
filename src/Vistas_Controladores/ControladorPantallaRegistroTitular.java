package Vistas_Controladores;

import java.util.Optional;

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

public class ControladorPantallaRegistroTitular implements Controlador {
	private Stage ventana;
	private ControladorPantallaPrincipal controladorPantallaPrincipal;
	private ControladorPantallaInicioSolicitud inicioSolicitud;
	private Main main;
	private MImplementacionFX modelo;
	@FXML
	private CheckBox checkboxRepresentante;
	@FXML
	private Label camposObligatorios;
	@FXML
	private Button siguiente;
	@FXML
	private Button cancelar;
	@FXML
	private Button atras;
	@FXML
	private ComboBox<String> tipoPersona;
	@FXML
	private TextField txtfNombre;
	@FXML
	private TextField txtfApellidos;
	@FXML
	private TextField txtfRazonSocial;
	@FXML
	private TextField txtfDireccion;
	@FXML
	private TextField txtfMunicipio;
	@FXML
	private TextField txtfCodPostal;
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
	private Label informacion;
	@FXML
	private Label lblNombre;
	@FXML
	private Label lblApellidos;
	@FXML
	private Label lblRazonSocial;
	
	
	//Rrepsentante
	@FXML
	private Label lblRepresentante;
	@FXML
	private Button replicarDatos;
	@FXML
	private TextField txtfNombreRE;
	@FXML
	private TextField txtfApellidosRE;
	@FXML
	private TextField txtfDireccionRE;
	@FXML
	private TextField txtfMunicipioRE;
	@FXML
	private TextField txtfCodPostalRE;
	@FXML
	private TextField txtfDNIRE;
	@FXML
	private TextField txtfTlfFijoRE;
	@FXML
	private TextField txtfTlfMovilRE;
	@FXML
	private TextField txtfEmailRE;
	@FXML
	private TextField txtfFaxRE;
	@FXML
	private Label lblNombreRe;
	@FXML
	private Label lblApellidosRe;
	@FXML
	private Label lblDireccionRe;
	@FXML
	private Label lblMunicipioRe;
	@FXML
	private Label lblCPRe;
	@FXML
	private Label lblDniRe;
	@FXML
	private Label lblFijoRe;
	@FXML
	private Label lblMovilRe;
	@FXML
	private Label lblEmailRe;
	@FXML
	private Label lblFaxRe;
	
	@FXML
	public void initialize(){
		tipoPersona.getItems().removeAll(tipoPersona.getItems());
		tipoPersona.getItems().addAll("FISICA", "JURIDICA");
		
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
	public void accionTipoSolicitante(){
		if(tipoPersona.getValue().toString().equalsIgnoreCase("JURIDICA")){
			checkboxRepresentante.setDisable(true);
			lblRazonSocial.setDisable(false);
			lblNombre.setDisable(true);
			lblApellidos.setDisable(true);
			txtfRazonSocial.setDisable(false);
			txtfNombre.setDisable(true);
			txtfApellidos.setDisable(true);
			informacion.setText("Si lo desea rellene los datos del representante.");
			lblRepresentante.setDisable(false);
			replicarDatos.setDisable(false);
			txtfNombreRE.setDisable(false);
			txtfApellidosRE.setDisable(false);
			txtfDireccionRE.setDisable(false);
			txtfMunicipioRE.setDisable(false);
			txtfCodPostalRE.setDisable(false);
			txtfDNIRE.setDisable(false);
			txtfTlfFijoRE.setDisable(false);
			txtfTlfMovilRE.setDisable(false);
			txtfEmailRE.setDisable(false);
			txtfFaxRE.setDisable(false);
			lblNombreRe.setDisable(false);
			lblApellidosRe.setDisable(false);
			lblDireccionRe.setDisable(false);
			lblMunicipioRe.setDisable(false);
			lblCPRe.setDisable(false);
			lblDniRe.setDisable(false);
			lblFijoRe.setDisable(false);
			lblMovilRe.setDisable(false);
			lblEmailRe.setDisable(false);
			lblFaxRe.setDisable(false);
			
			
		}else if(tipoPersona.getValue().toString().equalsIgnoreCase("FISICA")){
			checkboxRepresentante.setDisable(false);
			lblRazonSocial.setDisable(true);
			lblNombre.setDisable(false);
			lblApellidos.setDisable(false);
			txtfRazonSocial.setDisable(true);
			txtfNombre.setDisable(false);
			txtfApellidos.setDisable(false);
			informacion.setText("Los solicitantes físicos no requieren de representante");
			lblRepresentante.setDisable(true);
			replicarDatos.setDisable(true);
			txtfNombreRE.setDisable(true);
			txtfApellidosRE.setDisable(true);
			txtfDireccionRE.setDisable(true);
			txtfMunicipioRE.setDisable(true);
			txtfCodPostalRE.setDisable(true);
			txtfDNIRE.setDisable(true);
			txtfTlfFijoRE.setDisable(true);
			txtfTlfMovilRE.setDisable(true);
			txtfEmailRE.setDisable(true);
			txtfFaxRE.setDisable(true);
			lblNombreRe.setDisable(true);
			lblApellidosRe.setDisable(true);
			lblDireccionRe.setDisable(true);
			lblMunicipioRe.setDisable(true);
			lblCPRe.setDisable(true);
			lblDniRe.setDisable(true);
			lblFijoRe.setDisable(true);
			lblMovilRe.setDisable(true);
			lblEmailRe.setDisable(true);
			lblFaxRe.setDisable(true);
		}
	}
	
	@FXML
	public void accionCheckBoxRepresentate(){
		if(checkboxRepresentante.isSelected()){
			lblRepresentante.setDisable(false);
			replicarDatos.setDisable(false);
			txtfNombreRE.setDisable(false);
			txtfApellidosRE.setDisable(false);
			txtfDireccionRE.setDisable(false);
			txtfMunicipioRE.setDisable(false);
			txtfCodPostalRE.setDisable(false);
			txtfDNIRE.setDisable(false);
			txtfTlfFijoRE.setDisable(false);
			txtfTlfMovilRE.setDisable(false);
			txtfEmailRE.setDisable(false);
			txtfFaxRE.setDisable(false);
			lblNombreRe.setDisable(false);
			lblApellidosRe.setDisable(false);
			lblDireccionRe.setDisable(false);
			lblMunicipioRe.setDisable(false);
			lblCPRe.setDisable(false);
			lblDniRe.setDisable(false);
			lblFijoRe.setDisable(false);
			lblMovilRe.setDisable(false);
			lblEmailRe.setDisable(false);
			lblFaxRe.setDisable(false);
			
			
		}else if(!checkboxRepresentante.isSelected()){
			lblRepresentante.setDisable(true);
			replicarDatos.setDisable(true);
			txtfNombreRE.setDisable(true);
			txtfApellidosRE.setDisable(true);
			txtfDireccionRE.setDisable(true);
			txtfMunicipioRE.setDisable(true);
			txtfCodPostalRE.setDisable(true);
			txtfDNIRE.setDisable(true);
			txtfTlfFijoRE.setDisable(true);
			txtfTlfMovilRE.setDisable(true);
			txtfEmailRE.setDisable(true);
			txtfFaxRE.setDisable(true);
			lblNombreRe.setDisable(true);
			lblApellidosRe.setDisable(true);
			lblDireccionRe.setDisable(true);
			lblMunicipioRe.setDisable(true);
			lblCPRe.setDisable(true);
			lblDniRe.setDisable(true);
			lblFijoRe.setDisable(true);
			lblMovilRe.setDisable(true);
			lblEmailRe.setDisable(true);
			lblFaxRe.setDisable(true);
		}
	}
	@FXML
	public void accionReplicarDatos(){
		main.accionReplicarDatos();
	}
	@FXML
	public void accionVolverAtras(){
		
		main.mostrarVentanaInicioSolicitud();
		main.mostrarDatosAnteriores();
		this.ventana.close();
	}
	@FXML
	public void completarSolicitud(){
		this.main.completarSolicitud();
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
	public void setPantallaInicioSolicitud(ControladorPantallaInicioSolicitud inicioSolicitud) {
		this.inicioSolicitud=inicioSolicitud;
		
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

	public ControladorPantallaInicioSolicitud getInicioSolicitud() {
		return inicioSolicitud;
	}

	public void setInicioSolicitud(ControladorPantallaInicioSolicitud inicioSolicitud) {
		this.inicioSolicitud = inicioSolicitud;
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

	public Button getAtras() {
		return atras;
	}

	public void setAtras(Button atras) {
		this.atras = atras;
	}

	public ComboBox<String> getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(ComboBox<String> tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public String getTxtfNombre() {
		return txtfNombre.getText();
	}

	public void setTxtfNombre(TextField txtfNombre) {
		this.txtfNombre = txtfNombre;
	}

	public String getTxtfApellidos() {
		return txtfApellidos.getText();
	}

	public void setTxtfApellidos(TextField txtfApellidos) {
		this.txtfApellidos = txtfApellidos;
	}

	public String getTxtfRazonSocial() {
		return txtfRazonSocial.getText();
	}

	public void setTxtfRazonSocial(TextField txtfRazonSocial) {
		this.txtfRazonSocial = txtfRazonSocial;
	}

	public String getTxtfDireccion() {
		return txtfDireccion.getText();
	}

	public void setTxtfDireccion(TextField txtfDireccion) {
		this.txtfDireccion = txtfDireccion;
	}

	public String getTxtfMunicipio() {
		return txtfMunicipio.getText();
	}

	public void setTxtfMunicipio(TextField txtfMunicipio) {
		this.txtfMunicipio = txtfMunicipio;
	}

	public String getTxtfCodPostal() {
		return txtfCodPostal.getText();
	}

	public void setTxtfCodPostal(TextField txtfCodPostal) {
		this.txtfCodPostal = txtfCodPostal;
	}

	public String getTxtfDNI() {
		return txtfDNI.getText();
	}

	public void setTxtfDNI(TextField txtfDNI) {
		this.txtfDNI = txtfDNI;
	}

	public String getTxtfTlfFijo() {
		return txtfTlfFijo.getText();
	}

	public void setTxtfTlfFijo(TextField txtfTlfFijo) {
		this.txtfTlfFijo = txtfTlfFijo;
	}

	public String getTxtfTlfMovil() {
		return txtfTlfMovil.getText();
	}

	public void setTxtfTlfMovil(TextField txtfTlfMovil) {
		this.txtfTlfMovil = txtfTlfMovil;
	}

	public String getTxtfEmail() {
		return txtfEmail.getText();
	}

	public void setTxtfEmail(TextField txtfEmail) {
		this.txtfEmail = txtfEmail;
	}

	public String getTxtfFax() {
		return txtfFax.getText();
	}

	public void setTxtfFax(TextField txtfFax) {
		this.txtfFax = txtfFax;
	}

	public Label getInformacion() {
		return informacion;
	}

	public void setInformacion(Label informacion) {
		this.informacion = informacion;
	}

	public Label getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(Label lblNombre) {
		this.lblNombre = lblNombre;
	}

	public Label getLblApellidos() {
		return lblApellidos;
	}

	public void setLblApellidos(Label lblApellidos) {
		this.lblApellidos = lblApellidos;
	}

	public Label getLblRazonSocial() {
		return lblRazonSocial;
	}

	public void setLblRazonSocial(Label lblRazonSocial) {
		this.lblRazonSocial = lblRazonSocial;
	}

	public Label getLblRepresentante() {
		return lblRepresentante;
	}

	public void setLblRepresentante(Label lblRepresentante) {
		this.lblRepresentante = lblRepresentante;
	}

	public Button getReplicarDatos() {
		return replicarDatos;
	}

	public void setReplicarDatos(Button replicarDatos) {
		this.replicarDatos = replicarDatos;
	}

	public String getTxtfNombreRE() {
		return txtfNombreRE.getText();
	}

	public void setTxtfNombreRE(TextField txtfNombreRE) {
		this.txtfNombreRE = txtfNombreRE;
	}

	public String getTxtfApellidosRE() {
		return txtfApellidosRE.getText();
	}

	public void setTxtfApellidosRE(TextField txtfApellidosRE) {
		this.txtfApellidosRE = txtfApellidosRE;
	}

	public String getTxtfDireccionRE() {
		return txtfDireccionRE.getText();
	}

	public void setTxtfDireccionRE(TextField txtfDireccionRE) {
		this.txtfDireccionRE = txtfDireccionRE;
	}

	public String getTxtfMunicipioRE() {
		return txtfMunicipioRE.getText();
	}

	public void setTxtfMunicipioRE(TextField txtfMunicipioRE) {
		this.txtfMunicipioRE = txtfMunicipioRE;
	}

	public String getTxtfCodPostalRE() {
		return txtfCodPostalRE.getText();
	}

	public void setTxtfCodPostalRE(TextField txtfCodPostalRE) {
		this.txtfCodPostalRE = txtfCodPostalRE;
	}

	public String getTxtfDNIRE() {
		return txtfDNIRE.getText();
	}

	public void setTxtfDNIRE(TextField txtfDNIRE) {
		this.txtfDNIRE = txtfDNIRE;
	}

	public String getTxtfTlfFijoRE() {
		return txtfTlfFijoRE.getText();
	}

	public void setTxtfTlfFijoRE(TextField txtfTlfFijoRE) {
		this.txtfTlfFijoRE = txtfTlfFijoRE;
	}

	public String getTxtfTlfMovilRE() {
		return txtfTlfMovilRE.getText();
	}

	public void setTxtfTlfMovilRE(TextField txtfTlfMovilRE) {
		this.txtfTlfMovilRE = txtfTlfMovilRE;
	}

	public String getTxtfEmailRE() {
		return txtfEmailRE.getText();
	}

	public void setTxtfEmailRE(TextField txtfEmailRE) {
		this.txtfEmailRE = txtfEmailRE;
	}

	public String getTxtfFaxRE() {
		return txtfFaxRE.getText();
	}

	public void setTxtfFaxRE(TextField txtfFaxRE) {
		this.txtfFaxRE = txtfFaxRE;
	}

	public Label getLblNombreRe() {
		return lblNombreRe;
	}

	public void setLblNombreRe(Label lblNombreRe) {
		this.lblNombreRe = lblNombreRe;
	}

	public Label getLblApellidosRe() {
		return lblApellidosRe;
	}

	public void setLblApellidosRe(Label lblApellidosRe) {
		this.lblApellidosRe = lblApellidosRe;
	}

	public Label getLblDireccionRe() {
		return lblDireccionRe;
	}

	public void setLblDireccionRe(Label lblDireccionRe) {
		this.lblDireccionRe = lblDireccionRe;
	}

	public Label getLblMunicipioRe() {
		return lblMunicipioRe;
	}

	public void setLblMunicipioRe(Label lblMunicipioRe) {
		this.lblMunicipioRe = lblMunicipioRe;
	}

	public Label getLblCPRe() {
		return lblCPRe;
	}

	public void setLblCPRe(Label lblCPRe) {
		this.lblCPRe = lblCPRe;
	}

	public Label getLblDniRe() {
		return lblDniRe;
	}

	public void setLblDniRe(Label lblDniRe) {
		this.lblDniRe = lblDniRe;
	}

	public Label getLblFijoRe() {
		return lblFijoRe;
	}

	public void setLblFijoRe(Label lblFijoRe) {
		this.lblFijoRe = lblFijoRe;
	}

	public Label getLblMovilRe() {
		return lblMovilRe;
	}

	public void setLblMovilRe(Label lblMovilRe) {
		this.lblMovilRe = lblMovilRe;
	}

	public Label getLblEmailRe() {
		return lblEmailRe;
	}

	public void setLblEmailRe(Label lblEmailRe) {
		this.lblEmailRe = lblEmailRe;
	}

	public Label getLblFaxRe() {
		return lblFaxRe;
	}

	public void setLblFaxRe(Label lblFaxRe) {
		this.lblFaxRe = lblFaxRe;
	}

	public Main getMain() {
		return main;
	}

	public MImplementacionFX getModelo() {
		return modelo;
	}

	public Label getCamposObligatorios() {
		return camposObligatorios;
	}

	public void setCamposObligatorios(Label camposObligatorios) {
		this.camposObligatorios = camposObligatorios;
	}
	
	public TextField getTxtfNombreRE2() {
		return txtfNombreRE;
	}


	public TextField getTxtfApellidosRE2() {
		return txtfApellidosRE;
	}


	public TextField getTxtfDireccionRE2() {
		return txtfDireccionRE;
	}

	
	public TextField getTxtfMunicipioRE2() {
		return txtfMunicipioRE;
	}

	public TextField getTxtfCodPostalRE2() {
		return txtfCodPostalRE;
	}

	
	public TextField getTxtfDNIRE2() {
		return txtfDNIRE;
	}

	
	public TextField getTxtfTlfFijoRE2() {
		return txtfTlfFijoRE;
	}

	
	public TextField getTxtfTlfMovilRE2() {
		return txtfTlfMovilRE;
	}


	public TextField getTxtfEmailRE2() {
		return txtfEmailRE;
	}

	public TextField getTxtfFaxRE2() {
		return txtfFaxRE;
	}

	

}
