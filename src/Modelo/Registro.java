package Modelo;

public class Registro {
	private String dni;
	private String nombre;
	private String apellido;
	private String licencia;
	private String registro;
	
	
	public Registro(String dni, String nombre, String apellido, String licencia, String registro) {
		super();

		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.licencia=licencia;
		this.registro=registro;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		System.out.println("mi nombre");
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getLicencia() {
		return licencia;
	}

	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	
	
	
}
