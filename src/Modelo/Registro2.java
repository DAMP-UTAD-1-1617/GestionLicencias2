package Modelo;

public class Registro2 {
	private String registro2;
	private String licencia2;
	private String emplazamiento;
	private String tipoSuelo;
	private String estadoLicencia;
	
	
	
	
	public Registro2(String registro2, String licencia2, String emplazamiento, String tipoSuelo, String estadoLicencia) {
		super();

		this.registro2 = registro2;
		this.licencia2 = licencia2;
		this.emplazamiento = emplazamiento;
		this.tipoSuelo=tipoSuelo;
		this.estadoLicencia=estadoLicencia;
		
	}




	public String getRegistro2() {
		return registro2;
	}




	public void setRegistro2(String registro2) {
		this.registro2 = registro2;
	}




	public String getLicencia2() {
		return licencia2;
	}




	public void setLicencia2(String licencia2) {
		this.licencia2 = licencia2;
	}




	public String getEmplazamiento() {
		return emplazamiento;
	}




	public void setEmplazamiento(String emplazamiento) {
		this.emplazamiento = emplazamiento;
	}




	public String getTipoSuelo() {
		return tipoSuelo;
	}




	public void setTipoSuelo(String tipoSuelo) {
		this.tipoSuelo = tipoSuelo;
	}




	public String getEstadoLicencia() {
		return estadoLicencia;
	}




	public void setEstadoLicencia(String estadoLicencia) {
		this.estadoLicencia = estadoLicencia;
	}
	
	
}