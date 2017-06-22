package Modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import Main_ControladorPadre.Main;
import Vistas_Controladores.Controlador;
import Vistas_Controladores.ControladorPantallaCambioDatosLicencia;
import Vistas_Controladores.ControladorPantallaCambioTitularidad;
import Vistas_Controladores.ControladorPantallaConexionBBDD;
import Vistas_Controladores.ControladorPantallaHistorico;
import Vistas_Controladores.ControladorPantallaInicioSolicitud;
import Vistas_Controladores.ControladorPantallaPrincipal;
import Vistas_Controladores.ControladorPantallaRegistroTitular;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;

public class MImplementacionFX implements Modelo {
	private ControladorPantallaPrincipal controladorPantallaPrincipal;
	private Main main;
	private ControladorPantallaConexionBBDD conexionBBDD;
	private ControladorPantallaCambioTitularidad cambioTitularidad;
	private ControladorPantallaHistorico historico;
	private ControladorPantallaInicioSolicitud inicioSolicitud;
	private ControladorPantallaRegistroTitular registroTitular;
	private ControladorPantallaCambioDatosLicencia cambioDatosLicencia;

	private Connection conexion;
	private String Usuario;
	private String Pass;
	private String bbdd;
	private String dniTabla;
	private String nombreTabla;
	private String apellidosTabla;
	private String actividadTabla;
	private String registroTabla;
	private String registro2Tabla;
	private String actividad2Tabla;
	private String emplazamientoTabla;
	private String tipoSueloTabla;
	private String estadoLicenciaTabla;
	private String razonSocial;
	private String dni;
	private String tipoPersona;
	private String tlfMovil;
	private String tlfFijo;
	private String direccion;
	private String municipio;
	private String cp;
	private String email;
	private String descripcion;
	private String licencia;
	private String catastro;
	private String fechaInicioActividad;
	private String fechaInicioSolicitud;
	private String fotocopiaDNI;
	private String fotocopiaImpuestos;
	private String fotografia;
	private String fotocopiaObra;
	private String fotocopiaEscritura;
	private String fotocopiaMemoria;
	private String fotocopiaPago;
	private String fotocopiaOtras;
	private String certificado1;
	private String certificado2;
	private String planos;
	private String numRegistro;
	private String nombreCT;
	private String apellidosCT;
	private String tipoPersonaCT;
	private String direccionCT;
	private String municipioCT;
	private String cpCT;
	private String razonSocialCT;
	private String cifCT;
	private String antiguoTitularCT;
	private String tlfFijoCT;
	private String tlfMovilCT;
	private String emailCT;
	private String faxCT;
	private String fechaInicioActividadAntiguoTitularCT;
	private String registroHistorico;
	private String nuevoTitularHistorico;
	private String fechaNuevoTitularHistorico;
	private String antiguoTitularHistorico;
	private String fechaAntiguoTitularHistorico;
	private String licenciaAnteriorHistorico;
	private String escriturasHistorico;
	private String numeroExpedienteHistorico;
	private String planosLocalHistorico;
	private String registroCambioDatos;
	private String fechaSolicitudCambioDatos;
	private String tipoDeSueloCambioDatos;
	private String emplazamientoCambioDatos;
	private String referenciaCatastralCambioDatos;
	private String estadoSolicitudCambioDatos;
	private String tipoDeActividadCambioDatos;
	private String descripcionActividadCambioDatos;
	private String fotocopiaDNICambioDatos;
	private String fotocopiaImpuestosCambioDatos;
	private String fotografiasCambioDatos;
	private String fotocopiaEscriturasCambioDatos;
	private String justificantePagoCambioDatos;
	private String memoriaActividadCambioDatos;
	private String planosDeLocalCambioDatos;
	private String fotocopiaObraCambioDatos;
	private String certificadoModelo1CambioDatos;
	private String certificadoModelo2CambioDatos;
	private String otrasAutorizacionesCambioDatos;
	private String fechaInicioActividadCambioDatos;
	

	public void setBBDD(String Usuario, String Pass, String bbdd) {
		this.Usuario = Usuario;
		this.Pass = Pass;
		this.bbdd = bbdd;

		Properties propiedades = new Properties();
		OutputStream salida = null;
		try {
			File miFichero = new File("configuracion.ini");
			if (miFichero.exists()) {
				salida = new FileOutputStream(miFichero);

				propiedades.setProperty("Usuario", this.Usuario);
				propiedades.setProperty("Pass", this.Pass);
				propiedades.setProperty("Url", this.bbdd);

				propiedades.store(salida, "Comentario para el fichero");
			} else
				System.err.println("Fichero no encontrado");
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (salida != null) {
				try {
					salida.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void getBBDD() {
		Properties propiedades = new Properties();
		InputStream entrada = null;
		try {
			File miFichero = new File("configuracion.ini");
			if (miFichero.exists()) {
				entrada = new FileInputStream(miFichero);
				// cargamos el archivo de propiedades
				propiedades.load(entrada);
				// obtenemos las propiedades y las imprimimos
				this.Usuario = propiedades.getProperty("Usuario");
				this.Pass = propiedades.getProperty("Pass");
				this.bbdd = propiedades.getProperty("Url");
			} else
				System.err.println("Fichero no encontrado");
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (entrada != null) {
				try {
					entrada.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	public String getPass() {
		return Pass;
	}

	public void setPass(String pass) {
		Pass = pass;
	}

	public String getBbdd() {
		return bbdd;
	}

	public void setBbdd(String bbdd) {
		this.bbdd = bbdd;
	}

	public String ConexionBBDD() {
		String aviso;
		try {
			getBBDD();
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(this.bbdd, this.Usuario, this.Pass);
			System.out.println(" - Conexión con MySQL establecida -");
			aviso = "¡Conexión satisfactoria!";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(" – Error de Conexión con MySQL -");
			aviso = "¡Conexión Fallida!";
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Diálogo de información");
			alert.setHeaderText("Atención");
			alert.setContentText("No existe conexión a la Base de Datos.");
			alert.showAndWait();
			e.printStackTrace();
		}
		return aviso;

	}

	public void recogerDatosBBDDPersonas() {

		try {
			if (conexion == null) {
				System.out.println("NO EXISTE");
				System.exit(-1);
			}
			PreparedStatement pstmt = conexion.prepareStatement(
					"SELECT titular.CIF_NIF_NIE, titular.registro, titular.nombre, titular.apellidos, licencia.actividad, titular.TIPO_SOLICITANTE, titular.RAZON_SOCIAL FROM titular JOIN licencia ON licencia.DNI_titular=titular.CIF_NIF_NIE");
			ResultSet rset = pstmt.executeQuery();

			while (rset.next()) {

				dniTabla = rset.getString("CIF_NIF_NIE");
				if (rset.getString("TIPO_SOLICITANTE").equalsIgnoreCase("FISICA")) {
					nombreTabla = rset.getString("nombre");
					apellidosTabla = rset.getString("apellidos");
				} else {
					nombreTabla = rset.getString("RAZON_SOCIAL");
					apellidosTabla = "";
				}

				actividadTabla = rset.getString("actividad");
				registroTabla = rset.getString("registro");
				main.tablaPersonas();

			}

		} catch (SQLException s) {
			s.printStackTrace();
		}

	}

	public void recogerDatosBBDDLicencias() {
		try {
			if (conexion == null) {
				System.out.println("NO EXISTE");
				System.exit(-1);
			}
			PreparedStatement pstmt = conexion.prepareStatement(
					"SELECT titular.registro, licencia.actividad, licencia.emplazamiento,licencia.tipo_suelo, licencia.EstadoLicencia FROM titular JOIN licencia ON licencia.DNI_titular=titular.CIF_NIF_NIE");
			ResultSet rset = pstmt.executeQuery();

			ResultSetMetaData rsmd = rset.getMetaData();
			while (rset.next()) {
				registro2Tabla = rset.getString("registro");
				actividad2Tabla = rset.getString("actividad");
				emplazamientoTabla = rset.getString("emplazamiento");
				tipoSueloTabla = rset.getString("tipo_suelo");
				estadoLicenciaTabla = rset.getString("EstadoLicencia");
				main.tablaLicencias();
			}

		} catch (SQLException s) {
			s.printStackTrace();
		}

	}

	public void recogerDatosExtra(String numRegistro) {
		try {
			if (conexion == null) {
				System.out.println("NO EXISTE");
				System.exit(-1);
			}
			PreparedStatement pstmt = conexion.prepareStatement(
					"SELECT * FROM titular JOIN licencia ON licencia.DNI_titular=titular.CIF_NIF_NIE WHERE titular.REGISTRO= "
							+ numRegistro);
			ResultSet rset = pstmt.executeQuery();
			while (rset.next()) {
				razonSocial = rset.getString("RAZON_SOCIAL");
				dni = rset.getString("CIF_NIF_NIE");
				tipoPersona = rset.getString("TIPO_SOLICITANTE");
				tlfMovil = rset.getString("TELEFONO_MOVIL");
				tlfFijo = rset.getString("TELEFONO_FIJO");
				direccion = rset.getString("DIRECCION");
				municipio = rset.getString("MUNICIPIO");
				cp = rset.getString("COD_POSTAL");
				email = rset.getString("EMAIL");

			}

		} catch (SQLException s) {
			s.printStackTrace();
		}

		main.devolverDatosExtra();

	}

	public void recogerDatosExtra2(String numRegistro) {
		try {
			if (conexion == null) {
				System.out.println("NO EXISTE");
				System.exit(-1);
			}
			PreparedStatement pstmt = conexion.prepareStatement(
					"SELECT * FROM titular JOIN licencia ON licencia.DNI_titular=titular.CIF_NIF_NIE WHERE titular.REGISTRO= "
							+ numRegistro);
			ResultSet rset = pstmt.executeQuery();
			while (rset.next()) {
				descripcion = rset.getString("DescripcionActividad");
				licencia = rset.getString("ACTIVIDAD");
				catastro = rset.getString("REF_CATASTRAL");
				fechaInicioActividad = rset.getString("FechaInicioActividad");
				fechaInicioSolicitud = rset.getString("FechaSolicitud");
				fotocopiaDNI = rset.getString("Fotocopia_DNI_CIF_NIE");
				fotocopiaImpuestos = rset.getString("FOTOCOPIA_ACTIVIDAD");
				fotografia = rset.getString("FOTOGRAFIAS");
				fotocopiaObra = rset.getString("FOTOCOPIA_OBRA");
				fotocopiaEscritura = rset.getString("FOTOCOPIA_ESCRITURAS");
				fotocopiaMemoria = rset.getString("MEMORIA_ACTIVIDAD");
				fotocopiaPago = rset.getString("JUSTIFICANTE_PAGO");
				fotocopiaOtras = rset.getString("FOTOCOPIA_OTROS");
				certificado1 = rset.getString("CERTIFICADO_TECNICO1");
				certificado2 = rset.getString("CERTIFICADO_COLEGIO_OFICIAL2");
				planos = rset.getString("PLANOS_LOCAL");
			}

		} catch (SQLException s) {
			s.printStackTrace();
		}

		main.devolverDatosExtra2();

	}

	public void setControladorMain(Main main) {
		this.main = main;
	}

	public void setControladorPantallaPrincipal(ControladorPantallaPrincipal controladorPantallaPrincipal) {
		this.controladorPantallaPrincipal = controladorPantallaPrincipal;

	}

	public String getDniTabla() {
		return dniTabla;
	}

	public void setDniTabla(String dniTabla) {
		this.dniTabla = dniTabla;
	}

	public String getNombreTabla() {
		return nombreTabla;
	}

	public void setNombreTabla(String nombreTabla) {
		this.nombreTabla = nombreTabla;
	}

	public String getApellidosTabla() {
		return apellidosTabla;
	}

	public void setApellidosTabla(String apellidosTabla) {
		this.apellidosTabla = apellidosTabla;
	}

	public String getActividadTabla() {
		return actividadTabla;
	}

	public void setActividadTabla(String actividadTabla) {
		this.actividadTabla = actividadTabla;
	}

	public String getRegistroTabla() {
		return registroTabla;
	}

	public void setRegistroTabla(String registroTabla) {
		this.registroTabla = registroTabla;
	}

	public String getRegistro2Tabla() {
		return registro2Tabla;
	}

	public void setRegistro2Tabla(String registro2Tabla) {
		this.registro2Tabla = registro2Tabla;
	}

	public String getActividad2Tabla() {
		return actividad2Tabla;
	}

	public void setActividad2Tabla(String actividad2Tabla) {
		this.actividad2Tabla = actividad2Tabla;
	}

	public String getEmplazamientoTabla() {
		return emplazamientoTabla;
	}

	public void setEmplazamientoTabla(String emplazamientoTabla) {
		this.emplazamientoTabla = emplazamientoTabla;
	}

	public String getTipoSueloTabla() {
		return tipoSueloTabla;
	}

	public void setTipoSueloTabla(String tipoSueloTabla) {
		this.tipoSueloTabla = tipoSueloTabla;
	}

	public String getEstadoLicenciaTabla() {
		return estadoLicenciaTabla;
	}

	public void setEstadoLicenciaTabla(String estadoLicenciaTabla) {
		this.estadoLicenciaTabla = estadoLicenciaTabla;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public String getTlfMovil() {
		return tlfMovil;
	}

	public void setTlfMovil(String tlfMovil) {
		this.tlfMovil = tlfMovil;
	}

	public String getTlfFijo() {
		return tlfFijo;
	}

	public void setTlfFijo(String tlfFijo) {
		this.tlfFijo = tlfFijo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLicencia() {
		return licencia;
	}

	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}

	public String getCatastro() {
		return catastro;
	}

	public void setCatastro(String catastro) {
		this.catastro = catastro;
	}

	public String getFechaInicioActividad() {
		return fechaInicioActividad;
	}

	public void setFechaInicioActividad(String fechaInicioAntividad) {
		this.fechaInicioActividad = fechaInicioAntividad;
	}

	public String getFechaInicioSolicitud() {
		return fechaInicioSolicitud;
	}

	public void setFechaInicioSolicitud(String fechaInicioSolicitud) {
		this.fechaInicioSolicitud = fechaInicioSolicitud;
	}

	public String getFotocopiaDNI() {
		return fotocopiaDNI;
	}

	public void setFotocopiaDNI(String fotocopiaDNI) {
		this.fotocopiaDNI = fotocopiaDNI;
	}

	public String getFotocopiaImpuestos() {
		return fotocopiaImpuestos;
	}

	public void setFotocopiaImpuestos(String fotocopiaImpuestos) {
		this.fotocopiaImpuestos = fotocopiaImpuestos;
	}

	public String getFotografia() {
		return fotografia;
	}

	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
	}

	public String getFotocopiaObra() {
		return fotocopiaObra;
	}

	public void setFotocopiaObra(String fotocopiaObra) {
		this.fotocopiaObra = fotocopiaObra;
	}

	public String getFotocopiaEscritura() {
		return fotocopiaEscritura;
	}

	public void setFotocopiaEscritura(String fotocopiaEscritura) {
		this.fotocopiaEscritura = fotocopiaEscritura;
	}

	public String getFotocopiaMemoria() {
		return fotocopiaMemoria;
	}

	public void setFotocopiaMemoria(String fotocopiaMemoria) {
		this.fotocopiaMemoria = fotocopiaMemoria;
	}

	public String getFotocopiaPago() {
		return fotocopiaPago;
	}

	public void setFotocopiaPago(String fotocopiaPago) {
		this.fotocopiaPago = fotocopiaPago;
	}

	public String getFotocopiaOtras() {
		return fotocopiaOtras;
	}

	public void setFotocopiaOtras(String fotocopiaOtras) {
		this.fotocopiaOtras = fotocopiaOtras;
	}

	public String getCertificado1() {
		return certificado1;
	}

	public void setCertificado1(String certificado1) {
		this.certificado1 = certificado1;
	}

	public String getCertificado2() {
		return certificado2;
	}

	public void setCertificado2(String certificado2) {
		this.certificado2 = certificado2;
	}

	public String getPlanos() {
		return planos;
	}

	public void setPlanos(String planos) {
		this.planos = planos;
	}

	public void setConexionBBDD(ControladorPantallaConexionBBDD conexionBBDD) {
		this.conexionBBDD = conexionBBDD;

	}

	public void setCambioTitularidad(ControladorPantallaCambioTitularidad cambioTitularidad) {
		this.cambioTitularidad = cambioTitularidad;

	}

	public void recogerDatosParaCambioTitularidad(String numRegistro) {
		this.numRegistro = numRegistro;

		try {
			if (conexion == null) {
				System.out.println("NO EXISTE");
				System.exit(-1);
			}
			PreparedStatement pstmt = conexion.prepareStatement(
					"SELECT * FROM titular JOIN licencia ON licencia.DNI_titular=titular.CIF_NIF_NIE WHERE titular.REGISTRO= "
							+ numRegistro);
			ResultSet rset = pstmt.executeQuery();

			while (rset.next()) {
				nombreCT = rset.getString("NOMBRE");
				apellidosCT = rset.getString("APELLIDOS");
				tipoPersonaCT = rset.getString("TIPO_SOLICITANTE");
				System.out.println(tipoPersonaCT);
				direccionCT = rset.getString("DIRECCION");
				municipioCT = rset.getString("MUNICIPIO");
				cpCT = rset.getString("COD_POSTAL");
				razonSocialCT = rset.getString("RAZON_SOCIAL");
				cifCT = rset.getString("CIF_NIF_NIE");
				antiguoTitularCT = rset.getString("CIF_NIF_NIE");
				tlfFijoCT = rset.getString("TELEFONO_FIJO");
				tlfMovilCT = rset.getString("TELEFONO_MOVIL");
				emailCT = rset.getString("EMAIL");
				faxCT = rset.getString("FAX");
				fechaInicioActividadAntiguoTitularCT = rset.getString("FechaInicioActividad");

			}

		} catch (SQLException s) {
			s.printStackTrace();
		}

		this.main.devolverDatosTitular();

	}

	public String getNombreCT() {
		return nombreCT;
	}

	public void setNombreCT(String nombreCT) {
		this.nombreCT = nombreCT;
	}

	public String getApellidosCT() {
		return apellidosCT;
	}

	public void setApellidosCT(String apellidosCT) {
		this.apellidosCT = apellidosCT;
	}

	public String getTipoPersonaCT() {
		return tipoPersonaCT;
	}

	public void setTipoPersonaCT(String tipoPersonaCT) {
		this.tipoPersonaCT = tipoPersonaCT;
	}

	public String getDireccionCT() {
		return direccionCT;
	}

	public void setDireccionCT(String direccionCT) {
		this.direccionCT = direccionCT;
	}

	public String getMunicipioCT() {
		return municipioCT;
	}

	public void setMunicipioCT(String municipioCT) {
		this.municipioCT = municipioCT;
	}

	public String getCpCT() {
		return cpCT;
	}

	public void setCpCT(String cpCT) {
		this.cpCT = cpCT;
	}

	public String getRazonSocialCT() {
		return razonSocialCT;
	}

	public void setRazonSocialCT(String razonSocialCT) {
		this.razonSocialCT = razonSocialCT;
	}

	public String getCifCT() {
		return cifCT;
	}

	public void setCifCT(String cifCT) {
		this.cifCT = cifCT;
	}

	public String getAntiguoTitularCT() {
		return antiguoTitularCT;
	}

	public void setAntiguoTitularCT(String antiguoTitularCT) {
		this.antiguoTitularCT = antiguoTitularCT;
	}

	public String getTlfFijoCT() {
		return tlfFijoCT;
	}

	public void setTlfFijoCT(String tlfFijoCT) {
		this.tlfFijoCT = tlfFijoCT;
	}

	public String getTlfMovilCT() {
		return tlfMovilCT;
	}

	public void setTlfMovilCT(String tlfMovilCT) {
		this.tlfMovilCT = tlfMovilCT;
	}

	public String getEmailCT() {
		return emailCT;
	}

	public void setEmailCT(String emailCT) {
		this.emailCT = emailCT;
	}

	public String getFaxCT() {
		return faxCT;
	}

	public void setFaxCT(String faxCT) {
		this.faxCT = faxCT;
	}

	public String getFechaInicioActividadAntiguoTitularCT() {
		return fechaInicioActividadAntiguoTitularCT;
	}

	public void setFechaInicioActividadAntiguoTitularCT(String fechaInicioActividadAntiguoTitularCT) {
		this.fechaInicioActividadAntiguoTitularCT = fechaInicioActividadAntiguoTitularCT;
	}

	public void actualizarTitular(String nombreCT2, String apellidosCT2, String tipoPersonaCT2, String direccionCT2,
			String municipioCT2, String cPCT2, String razonSocialCT2, String dniCT, String tlfFijoCT2,
			String tlfMovilCT2, String emailCT2, String faxCT2, String numRegistro2, String planosCT,
			String licenciaAntCT, String escriturasCT, String numExpedienteCT) {
		try {
			PreparedStatement pstmt = conexion.prepareStatement(
					"SELECT titular.CIF_NIF_NIE, titular.registro, titular.nombre, titular.apellidos, licencia.actividad FROM titular JOIN licencia ON licencia.DNI_titular=titular.CIF_NIF_NIE");
			if (tipoPersonaCT2.equalsIgnoreCase("FISICA")) {
				pstmt.executeUpdate("UPDATE `titular` SET `CIF_NIF_NIE` = '" + dniCT.toUpperCase() + "', `NOMBRE` = '"
						+ nombreCT2.toUpperCase() + "', `APELLIDOS` = '" + apellidosCT2.toUpperCase()
						+ "', `MUNICIPIO` = '" + municipioCT2.toUpperCase() + "', `COD_POSTAL` = '"
						+ Integer.parseInt(cPCT2) + "', `DIRECCION` = '" + direccionCT2.toUpperCase()
						+ "', `TELEFONO_MOVIL` = '" + Integer.parseInt(tlfMovilCT2) + "', `TELEFONO_FIJO` = '"
						+ Integer.parseInt(tlfFijoCT2) + "', `EMAIL` = '" + emailCT2.toUpperCase()
						+ "', `TIPO_SOLICITANTE` = '" + tipoPersonaCT2.toUpperCase() + "', `FAX` = '"
						+ Integer.parseInt(faxCT2) + "' WHERE `titular`.`REGISTRO` = '" + numRegistro2 + "'");
			}else if(tipoPersonaCT2.equalsIgnoreCase("JURIDICA")){
				pstmt.executeUpdate("UPDATE `titular` SET `CIF_NIF_NIE` = '" + dniCT.toUpperCase() + "', `MUNICIPIO` = '"
						+ municipioCT2.toUpperCase() + "', `COD_POSTAL` = '" + Integer.parseInt(cPCT2)
						+ "', `DIRECCION` = '" + direccionCT2.toUpperCase() + "', `TELEFONO_MOVIL` = '"
						+ Integer.parseInt(tlfMovilCT2) + "', `TELEFONO_FIJO` = '" + Integer.parseInt(tlfFijoCT2)
						+ "', `EMAIL` = '" + emailCT2.toUpperCase() + "', `TIPO_SOLICITANTE` = '"
						+ tipoPersonaCT2.toUpperCase() + "', `RAZON_SOCIAL` = '" + razonSocialCT2.toUpperCase()
						+ "', `FAX` = '" + Integer.parseInt(faxCT2) + "' WHERE `titular`.`REGISTRO` = '" + numRegistro2
						+ "'");
			}

			Date fechaActual = new Date(); 
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			String cadenaFecha = formato.format(fechaActual); 
			

			pstmt.executeUpdate(
					"INSERT INTO `modificaciones` (`AntiguoTitular`, `FechaAntiguoTitular`, `NuevoTitular`, `FechaNuevoTitular`, `LICENCIAANT`, `ESCRITURAS`, `NUMEXPEDIENTE`, `PLANOS`, `REGISTRO`) VALUES ('"
							+ this.antiguoTitularCT.toUpperCase() + "', '" + this.fechaInicioActividadAntiguoTitularCT
							+ "', '" + dni.toUpperCase() + "', '" + cadenaFecha + "','"
							+ licenciaAntCT.toUpperCase() + "', '" + escriturasCT + "', '" + numExpedienteCT + "', '"
							+ planosCT + "', '" + numRegistro2 + "')");

		} catch (SQLException e1) {
			System.out.println("fallo");
			e1.printStackTrace();
		}
		this.main.actualizarTablas();

	}

	public void setHistorico(ControladorPantallaHistorico historico) {
		this.historico = historico;

	}

	public void recogerDatosHistorico() {
		try {
			if (conexion == null) {
				System.out.println("NO EXISTE");
				System.exit(-1);
			}
			PreparedStatement pstmt = conexion.prepareStatement("SELECT * FROM modificaciones");
			ResultSet rset = pstmt.executeQuery();

			ResultSetMetaData rsmd = rset.getMetaData();

			while (rset.next()) {
				registroHistorico = rset.getString("REGISTRO");
				nuevoTitularHistorico = rset.getString("NuevoTitular");
				fechaNuevoTitularHistorico = rset.getString("FechaNuevoTitular");
				antiguoTitularHistorico = rset.getString("AntiguoTitular");
				fechaAntiguoTitularHistorico = rset.getString("FechaAntiguoTitular");
				main.tablaHistorico();
			}

		} catch (SQLException s) {
			s.printStackTrace();
		}

	}

	public String getRegistroHistorico() {
		return registroHistorico;
	}

	public void setRegistroHistorico(String registroHistorico) {
		this.registroHistorico = registroHistorico;
	}

	public String getNuevoTitularHistorico() {
		return nuevoTitularHistorico;
	}

	public void setNuevoTitularHistorico(String nuevoTitularHistorico) {
		this.nuevoTitularHistorico = nuevoTitularHistorico;
	}

	public String getFechaNuevoTitularHistorico() {
		return fechaNuevoTitularHistorico;
	}

	public void setFechaNuevoTitularHistorico(String fechaNuevoTitularHistorico) {
		this.fechaNuevoTitularHistorico = fechaNuevoTitularHistorico;
	}

	public String getAntiguoTitularHistorico() {
		return antiguoTitularHistorico;
	}

	public void setAntiguoTitularHistorico(String antiguoTitularHistorico) {
		this.antiguoTitularHistorico = antiguoTitularHistorico;
	}

	public String getFechaAntiguoTitularHistorico() {
		return fechaAntiguoTitularHistorico;
	}

	public void setFechaAntiguoTitularHistorico(String fechaAntiguoTitularHistorico) {
		this.fechaAntiguoTitularHistorico = fechaAntiguoTitularHistorico;
	}

	public void recogerDocumentacionCambioTitularidad(String numRegistro) {
		try {
			if (conexion == null) {
				System.out.println("NO EXISTE");
				System.exit(-1);
			}
			PreparedStatement pstmt = conexion.prepareStatement(
					"SELECT * FROM modificaciones WHERE modificaciones.REGISTRO='" + numRegistro + "'");
			ResultSet rset = pstmt.executeQuery();
			while (rset.next()) {
				licenciaAnteriorHistorico = rset.getString("LICENCIAANT");
				escriturasHistorico = rset.getString("ESCRITURAS");
				numeroExpedienteHistorico = rset.getString("NUMEXPEDIENTE");
				planosLocalHistorico = rset.getString("PLANOS");

			}

		} catch (SQLException s) {
			s.printStackTrace();
		}

		main.devolverDocumentacionNuevoTitular();

	}

	public String getLicenciaAnteriorHistorico() {
		return licenciaAnteriorHistorico;
	}

	public void setLicenciaAnteriorHistorico(String licenciaAnteriorHistorico) {
		this.licenciaAnteriorHistorico = licenciaAnteriorHistorico;
	}

	public String getEscriturasHistorico() {
		return escriturasHistorico;
	}

	public void setEscriturasHistorico(String escriturasHistorico) {
		this.escriturasHistorico = escriturasHistorico;
	}

	public String getNumeroExpedienteHistorico() {
		return numeroExpedienteHistorico;
	}

	public void setNumeroExpedienteHistorico(String numeroExpedienteHistorico) {
		this.numeroExpedienteHistorico = numeroExpedienteHistorico;
	}

	public String getPlanosLocalHistorico() {
		return planosLocalHistorico;
	}

	public void setPlanosLocalHistorico(String planosLocalHistorico) {
		this.planosLocalHistorico = planosLocalHistorico;
	}

	public void setInicioSolicitud(ControladorPantallaInicioSolicitud inicioSolicitud) {
		this.inicioSolicitud = inicioSolicitud;

	}

	public void setRegistroTitular(ControladorPantallaRegistroTitular registroTitular) {
		this.registroTitular = registroTitular;

	}

	public void insertarDatos(String insertSolicitante, String nombreT, String apellidosT, String nombreR,
			String apellidosR, String tipoPersonaT, String direccionT, String direccionR, String municipioT,
			String municipioR, String razonSocialT, String dniT, String dniR, String emailT, String emailR, String cPT,
			String cPR, String tlfFijoT, String tlfFijoR, String tlfMovilT, String tlfMovilR, String faxT, String faxR,
			String registroSolicitud, String fechaInicioActividad2, String fechaInicioSolicitud2, String tipoSuelo,
			String emplazamiento, String refCatastral, String estadoSolicitud, String tipoActividad,
			String descripcionActividad, String fotocopiaDni2, String fotocopiaImpuestos2, String fotografia2,
			String fotocopiaEscrituras, String justificantePago, String memoriaActividad, String planosLocal,
			String fotocopiaLicenciaObra, String certificado12, String certificado22, String otrasAutorizaciones) {
		try {
			PreparedStatement pstmt = conexion.prepareStatement(
					"SELECT titular.CIF_NIF_NIE, titular.registro, titular.nombre, titular.apellidos, licencia.actividad FROM titular JOIN licencia ON licencia.DNI_titular=titular.CIF_NIF_NIE");
			if (insertSolicitante.equalsIgnoreCase("físico")) {
				pstmt.executeUpdate(
						"INSERT INTO `titular` (`CIF_NIF_NIE`, `NOMBRE`, `APELLIDOS`, `MUNICIPIO`, `COD_POSTAL`, `DIRECCION`, `TELEFONO_MOVIL`, `TELEFONO_FIJO`, `EMAIL`, `TIPO_SOLICITANTE`, `FOTOCOPIA_DNI_CIF_NIE`, `FOTOGRAFIAS`, `FOTOCOPIA_ACTIVIDAD`, `FOTOCOPIA_ESCRITURAS`, `JUSTIFICANTE_PAGO`, `FOTOCOPIA_OTROS`, `FAX`) VALUES ('"
								+ dniT.toUpperCase() + "', '" + nombreT.toUpperCase() + "', '"
								+ apellidosT.toUpperCase() + "', '" + municipioT.toUpperCase() + "', '"
								+ Integer.parseInt(cPT) + "', '" + direccionT.toUpperCase() + "', '"
								+ Integer.parseInt(tlfMovilT) + "', '" + Integer.parseInt(tlfFijoT) + "', '"
								+ emailT.toUpperCase() + "', '" + tipoPersonaT.toUpperCase() + "', '"
								+ fotocopiaDni2.toUpperCase() + "', '" + fotografia2.toUpperCase() + "', '"
								+ fotocopiaImpuestos2.toUpperCase() + "', '" + fotocopiaEscrituras.toUpperCase()
								+ "', '" + justificantePago.toUpperCase() + "', '" + otrasAutorizaciones.toUpperCase()
								+ "', '" + Integer.parseInt(faxT) + "')");
				pstmt.executeUpdate(
						"INSERT INTO `licencia` (`REF_CATASTRAL`, `TIPO_SUELO`, `EMPLAZAMIENTO`, `ACTIVIDAD`, `MEMORIA_ACTIVIDAD`, `PLANOS_LOCAL`, `FOTOCOPIA_OBRA`, `CERTIFICADO_TECNICO1`, `CERTIFICADO_COLEGIO_OFICIAL2`, `DNI_titular`, `FechaSolicitud`, `FechaInicioActividad`, `EstadoLicencia`, `DescripcionActividad`) VALUES ('"
								+ refCatastral + "', '" + tipoSuelo.toUpperCase() + "', '" + emplazamiento.toUpperCase()
								+ "', '" + tipoActividad.toUpperCase() + "', '" + memoriaActividad.toUpperCase()
								+ "', '" + planosLocal.toUpperCase() + "', '" + fotocopiaLicenciaObra.toUpperCase()
								+ "', '" + certificado12.toUpperCase() + "', '" + certificado22.toUpperCase() + "', '"
								+ dniT.toUpperCase() + "', '" + fechaInicioSolicitud2.toUpperCase() + "', '"
								+ fechaInicioActividad2.toUpperCase() + "', '" + estadoSolicitud.toUpperCase() + "', '"
								+ descripcionActividad.toUpperCase() + "')");

			} else if (insertSolicitante.equalsIgnoreCase("jurídico")) {
				pstmt.executeUpdate(
						"INSERT INTO `titular` (`CIF_NIF_NIE`, `MUNICIPIO`, `COD_POSTAL`, `DIRECCION`, `TELEFONO_MOVIL`, `TELEFONO_FIJO`, `EMAIL`, `TIPO_SOLICITANTE`, `FOTOCOPIA_DNI_CIF_NIE`, `FOTOGRAFIAS`, `FOTOCOPIA_ACTIVIDAD`, `FOTOCOPIA_ESCRITURAS`, `JUSTIFICANTE_PAGO`, `FOTOCOPIA_OTROS`, `RAZON_SOCIAL`, `FAX`) VALUES ('"
								+ dniT.toUpperCase() + "', '" + municipioT.toUpperCase() + "', '"
								+ Integer.parseInt(cPT) + "', '" + direccionT.toUpperCase() + "', '"
								+ Integer.parseInt(tlfMovilT) + "', '" + Integer.parseInt(tlfFijoT) + "', '"
								+ emailT.toUpperCase() + "', '" + tipoPersonaT.toUpperCase() + "', '"
								+ fotocopiaDni2.toUpperCase() + "', '" + fotografia2.toUpperCase() + "', '"
								+ fotocopiaImpuestos2.toUpperCase() + "', '" + fotocopiaEscrituras.toUpperCase()
								+ "', '" + justificantePago.toUpperCase() + "', '" + otrasAutorizaciones.toUpperCase()
								+ "', '" + razonSocialT.toUpperCase() + "', '" + Integer.parseInt(faxT) + "')");
				pstmt.executeUpdate(
						"INSERT INTO `licencia` (`REF_CATASTRAL`, `TIPO_SUELO`, `EMPLAZAMIENTO`, `ACTIVIDAD`, `MEMORIA_ACTIVIDAD`, `PLANOS_LOCAL`, `FOTOCOPIA_OBRA`, `CERTIFICADO_TECNICO1`, `CERTIFICADO_COLEGIO_OFICIAL2`, `DNI_titular`, `FechaSolicitud`, `FechaInicioActividad`, `EstadoLicencia`, `DescripcionActividad`) VALUES ('"
								+ refCatastral + "', '" + tipoSuelo.toUpperCase() + "', '" + emplazamiento.toUpperCase()
								+ "', '" + tipoActividad.toUpperCase() + "', '" + memoriaActividad.toUpperCase()
								+ "', '" + planosLocal.toUpperCase() + "', '" + fotocopiaLicenciaObra.toUpperCase()
								+ "', '" + certificado12.toUpperCase() + "', '" + certificado22.toUpperCase() + "', '"
								+ dniT.toUpperCase() + "', '" + fechaInicioSolicitud2.toUpperCase() + "', '"
								+ fechaInicioActividad2.toUpperCase() + "', '" + estadoSolicitud.toUpperCase() + "', '"
								+ descripcionActividad.toUpperCase() + "')");
				ResultSet rset = pstmt.executeQuery();
				String registro = "";
				while (rset.next()) {
					registro = rset.getString("REGISTRO");

				}
				pstmt.executeUpdate(
						"INSERT INTO `representante` (`CIF_NIF_NIE`, `REGISTRO`, `NOMBRE`, `APELLIDOS`, `MUNICIPIO`, `COD_POSTAL`, `DIRECCION`, `TELF_MOVIL`, `TELF_FIJO`, `EMAIL`) VALUES ('"
								+ dniR + "', '" + Integer.parseInt(registro) + "', '" + nombreR + "', '" + apellidosR
								+ "', '" + municipioR + "', '" + cPR + "', '" + municipioR + "', '" + tlfMovilR + "', '"
								+ tlfFijoR + "', '" + emailR + "')");
			}

		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		main.actualizarTablas();

	}

	public void setCambioDatosLicencia(ControladorPantallaCambioDatosLicencia cambioDatosLicencia) {
		this.cambioDatosLicencia=cambioDatosLicencia;
		
	}

	public void recogerDatosParaCambioLicencia(String numRegistro) {
		
		try {
			if (conexion == null) {
				System.out.println("NO EXISTE");
				System.exit(-1);
			}
			PreparedStatement pstmt = conexion.prepareStatement(
					"SELECT * FROM titular JOIN licencia ON licencia.DNI_titular=titular.CIF_NIF_NIE WHERE titular.REGISTRO= "
							+ numRegistro);
			ResultSet rset = pstmt.executeQuery();


			while (rset.next()) {
				registroCambioDatos = rset.getString("REGISTRO");
				fechaSolicitudCambioDatos = rset.getString("FechaSolicitud");
				tipoDeSueloCambioDatos = rset.getString("TIPO_SUELO");
				emplazamientoCambioDatos = rset.getString("EMPLAZAMIENTO");
				referenciaCatastralCambioDatos = rset.getString("REF_CATASTRAL");
				estadoSolicitudCambioDatos = rset.getString("EstadoLicencia");
				tipoDeActividadCambioDatos = rset.getString("ACTIVIDAD");
				descripcionActividadCambioDatos = rset.getString("DescripcionActividad");

				fotocopiaDNICambioDatos = rset.getString("FOTOCOPIA_DNI_CIF_NIE");

				fotocopiaImpuestosCambioDatos = rset.getString("FOTOCOPIA_ACTIVIDAD");
				fotografiasCambioDatos = rset.getString("FOTOGRAFIAS");
				fotocopiaEscriturasCambioDatos = rset.getString("FOTOCOPIA_ESCRITURAS");
				justificantePagoCambioDatos = rset.getString("JUSTIFICANTE_PAGO");
				memoriaActividadCambioDatos = rset.getString("MEMORIA_ACTIVIDAD");
				planosDeLocalCambioDatos = rset.getString("PLANOS_LOCAL");
				fotocopiaObraCambioDatos = rset.getString("FOTOCOPIA_OBRA");
				certificadoModelo1CambioDatos = rset.getString("CERTIFICADO_TECNICO1");
				certificadoModelo2CambioDatos = rset.getString("CERTIFICADO_COLEGIO_OFICIAL2");
				otrasAutorizacionesCambioDatos = rset.getString("FOTOCOPIA_OTROS");
				fechaInicioActividadCambioDatos = rset.getString("FechaInicioActividad");
				
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}

		main.devolverDatosDeLicencia();
		
	}

	public String getNumRegistro() {
		return numRegistro;
	}

	public void setNumRegistro(String numRegistro) {
		this.numRegistro = numRegistro;
	}

	public String getRegistroCambioDatos() {
		System.out.println(registroCambioDatos);
		return registroCambioDatos;
	}

	public void setRegistroCambioDatos(String registroCambioDatos) {
		this.registroCambioDatos = registroCambioDatos;
	}

	public String getFechaSolicitudCambioDatos() {
		return fechaSolicitudCambioDatos;
	}

	public void setFechaSolicitudCambioDatos(String fechaSolicitudCambioDatos) {
		this.fechaSolicitudCambioDatos = fechaSolicitudCambioDatos;
	}

	public String getTipoDeSueloCambioDatos() {
		return tipoDeSueloCambioDatos;
	}

	public void setTipoDeSueloCambioDatos(String tipoDeSueloCambioDatos) {
		this.tipoDeSueloCambioDatos = tipoDeSueloCambioDatos;
	}

	public String getEmplazamientoCambioDatos() {
		return emplazamientoCambioDatos;
	}

	public void setEmplazamientoCambioDatos(String emplazamientoCambioDatos) {
		this.emplazamientoCambioDatos = emplazamientoCambioDatos;
	}

	public String getReferenciaCatastralCambioDatos() {
		return referenciaCatastralCambioDatos;
	}

	public void setReferenciaCatastralCambioDatos(String referenciaCatastralCambioDatos) {
		this.referenciaCatastralCambioDatos = referenciaCatastralCambioDatos;
	}

	public String getEstadoSolicitudCambioDatos() {
		return estadoSolicitudCambioDatos;
	}

	public void setEstadoSolicitudCambioDatos(String estadoSolicitudCambioDatos) {
		this.estadoSolicitudCambioDatos = estadoSolicitudCambioDatos;
	}

	public String getTipoDeActividadCambioDatos() {
		return tipoDeActividadCambioDatos;
	}

	public void setTipoDeActividadCambioDatos(String tipoDeActividadCambioDatos) {
		this.tipoDeActividadCambioDatos = tipoDeActividadCambioDatos;
	}

	public String getDescripcionActividadCambioDatos() {
		return descripcionActividadCambioDatos;
	}

	public void setDescripcionActividadCambioDatos(String descripcionActividadCambioDatos) {
		this.descripcionActividadCambioDatos = descripcionActividadCambioDatos;
	}

	public String getFotocopiaDNICambioDatos() {
		return fotocopiaDNICambioDatos;
	}

	public void setFotocopiaDNICambioDatos(String fotocopiaDNICambioDatos) {
		this.fotocopiaDNICambioDatos = fotocopiaDNICambioDatos;
	}

	public String getFotocopiaImpuestosCambioDatos() {
		return fotocopiaImpuestosCambioDatos;
	}

	public void setFotocopiaImpuestosCambioDatos(String fotocopiaImpuestosCambioDatos) {
		this.fotocopiaImpuestosCambioDatos = fotocopiaImpuestosCambioDatos;
	}

	public String getFotografiasCambioDatos() {
		return fotografiasCambioDatos;
	}

	public void setFotografiasCambioDatos(String fotografiasCambioDatos) {
		this.fotografiasCambioDatos = fotografiasCambioDatos;
	}

	public String getFotocopiaEscriturasCambioDatos() {
		return fotocopiaEscriturasCambioDatos;
	}

	public void setFotocopiaEscriturasCambioDatos(String fotocopiaEscriturasCambioDatos) {
		this.fotocopiaEscriturasCambioDatos = fotocopiaEscriturasCambioDatos;
	}

	public String getJustificantePagoCambioDatos() {
		return justificantePagoCambioDatos;
	}

	public void setJustificantePagoCambioDatos(String justificantePagoCambioDatos) {
		this.justificantePagoCambioDatos = justificantePagoCambioDatos;
	}

	public String getMemoriaActividadCambioDatos() {
		return memoriaActividadCambioDatos;
	}

	public void setMemoriaActividadCambioDatos(String memoriaActividadCambioDatos) {
		this.memoriaActividadCambioDatos = memoriaActividadCambioDatos;
	}

	public String getPlanosDeLocalCambioDatos() {
		return planosDeLocalCambioDatos;
	}

	public void setPlanosDeLocalCambioDatos(String planosDeLocalCambioDatos) {
		this.planosDeLocalCambioDatos = planosDeLocalCambioDatos;
	}

	public String getFotocopiaObraCambioDatos() {
		return fotocopiaObraCambioDatos;
	}

	public void setFotocopiaObraCambioDatos(String fotocopiaObraCambioDatos) {
		this.fotocopiaObraCambioDatos = fotocopiaObraCambioDatos;
	}

	public String getCertificadoModelo1CambioDatos() {
		return certificadoModelo1CambioDatos;
	}

	public void setCertificadoModelo1CambioDatos(String certificadoModelo1CambioDatos) {
		this.certificadoModelo1CambioDatos = certificadoModelo1CambioDatos;
	}

	public String getCertificadoModelo2CambioDatos() {
		return certificadoModelo2CambioDatos;
	}

	public void setCertificadoModelo2CambioDatos(String certificadoModelo2CambioDatos) {
		this.certificadoModelo2CambioDatos = certificadoModelo2CambioDatos;
	}

	public String getOtrasAutorizacionesCambioDatos() {
		return otrasAutorizacionesCambioDatos;
	}

	public void setOtrasAutorizacionesCambioDatos(String otrasAutorizacionesCambioDatos) {
		this.otrasAutorizacionesCambioDatos = otrasAutorizacionesCambioDatos;
	}

	public String getFechaInicioActividadCambioDatos() {
		return fechaInicioActividadCambioDatos;
	}

	public void setFechaInicioActividadCambioDatos(String fechaInicioActividadCambioDatos) {
		this.fechaInicioActividadCambioDatos = fechaInicioActividadCambioDatos;
	}

	public ControladorPantallaPrincipal getControladorPantallaPrincipal() {
		return controladorPantallaPrincipal;
	}

	public ControladorPantallaRegistroTitular getRegistroTitular() {
		return registroTitular;
	}

	public void actualizarLicencia(String estadoLicencia, String descripcionActividad, String fotocopiaDNICambio2,
			String fotocopiaImpuestosCambio2, String fotografiasCambio2, String fotocopiaEscriturasCambio2,
			String justificantePagoCambio2, String memoriaActividadCambio2, String planosLocalCambio2,
			String fotocopiaLicenciaObraCambio2, String certificadoModelo1Cambio2, String certificadoModelo2Cambio2,
			String otrasAutorizacionesCambio2, String fechaInicioActividadCambio2, String tipoSueloCambio, String emplazamientoCambio,
			String referenciaCatastralCambio, String tipoLicenciaCambio, String registroCambio) {
		
		try {
			PreparedStatement pstmt = conexion.prepareStatement(
					"SELECT * FROM titular JOIN licencia ON licencia.DNI_titular=titular.CIF_NIF_NIE");

			pstmt.executeUpdate("UPDATE `licencia` SET `MEMORIA_ACTIVIDAD` = '" + memoriaActividadCambio2.toUpperCase() + "', `TIPO_SUELO` = '"+tipoSueloCambio.toUpperCase() + "', `ACTIVIDAD` = '"+tipoLicenciaCambio.toUpperCase() + "', `EMPLAZAMIENTO` = '"+emplazamientoCambio.toUpperCase() + "', `REF_CATASTRAL` = '"+referenciaCatastralCambio.toUpperCase() + "', `PLANOS_LOCAL` = '"  + planosLocalCambio2.toUpperCase() + "', `FOTOCOPIA_OBRA` = '" + fotocopiaLicenciaObraCambio2.toUpperCase() + "', `CERTIFICADO_TECNICO1` = '"+certificadoModelo1Cambio2.toUpperCase()+"', `CERTIFICADO_COLEGIO_OFICIAL2` = '"+certificadoModelo2Cambio2.toUpperCase()+"', `EstadoLicencia` = '"+estadoLicencia.toUpperCase()+"', `DescripcionActividad` = '"+descripcionActividad.toUpperCase()+"', `FechaInicioActividad` = '"+fechaInicioActividadCambio2.toUpperCase()+"' WHERE `licencia`.`REF_CATASTRAL` = '" + referenciaCatastralCambioDatos + "'");        
			pstmt.executeUpdate("UPDATE `titular` SET `FOTOCOPIA_DNI_CIF_NIE` = '" + fotocopiaDNICambio2.toUpperCase() + "', `FOTOCOPIA_ACTIVIDAD` = '"+fotocopiaImpuestosCambio2.toUpperCase() + "', `FOTOGRAFIAS` = '"  + fotografiasCambio2.toUpperCase() + "', `FOTOCOPIA_ESCRITURAS` = '" + fotocopiaEscriturasCambio2.toUpperCase() + "', `JUSTIFICANTE_PAGO` = '"+justificantePagoCambio2.toUpperCase()+"', `FOTOCOPIA_OTROS` = '"+otrasAutorizacionesCambio2.toUpperCase()+"' WHERE `titular`.`REGISTRO` = '" + registroCambio + "'");        

		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		main.actualizarTablas();
	}
	
	

}
