package Vistas_Controladores;

import Main_ControladorPadre.Main;
import Modelo.MImplementacionFX;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladorPantallaConexionBBDD implements Controlador {
	private ControladorPantallaPrincipal controladorPantallaPrincipal;
	private Main main;
	private MImplementacionFX modeloImplementacion;
	
	@FXML
	private TextField txtfUsuario;
	@FXML
	private TextField txtfPass;
	@FXML
	private TextField txtfURL;
	@FXML
	private Button guardar;
	@FXML
	private Button comprobar;
	@FXML
	private Label resultado;
	private Stage ventana;
	
	public void initialize() {

	}
	
	public void setBBDD(){
		this.main.setBBDD();
	}
	
	public void comprobarConexion(){
		this.main.comprobarConexion();
	}
	
	
	public void setPantallaPrincipal(ControladorPantallaPrincipal controladorPantallaPrincipal) {
		this.controladorPantallaPrincipal = controladorPantallaPrincipal;

	}

	

	public void setMain(Main main) {
		this.main=main;
		
	}



	public void setModelo(MImplementacionFX modeloImplementacion) {
		this.modeloImplementacion=modeloImplementacion;
		
	}


	public TextField getTxtfUsuario() {
		return txtfUsuario;
	}


	public void setTxtfUsuario(TextField txtfUsuario) {
		this.txtfUsuario = txtfUsuario;
	}


	public TextField getTxtfPass() {
		return txtfPass;
	}


	public void setTxtfPass(TextField txtfPass) {
		this.txtfPass = txtfPass;
	}


	public TextField getTxtfURL() {
		return txtfURL;
	}


	public void setTxtfURL(TextField txtfURL) {
		this.txtfURL = txtfURL;
	}


	public Button getGuardar() {
		return guardar;
	}


	public void setGuardar(Button guardar) {
		this.guardar = guardar;
	}


	public Button getComprobar() {
		return comprobar;
	}


	public void setComprobar(Button comprobar) {
		this.comprobar = comprobar;
	}


	public void setStagePrincipal(Stage ventana) {
		this.ventana=ventana;
		
	}

	public Label getResultado() {
		return resultado;
	}

	public void setResultado(Label resultado) {
		this.resultado = resultado;
	}
	
	
	
}
