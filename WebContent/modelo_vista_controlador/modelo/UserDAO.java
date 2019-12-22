package models;

import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.Hashtable;

import com.mysql.jdbc.PreparedStatement;

public class UserDAO {
	private int id;
	private String username;
	private String password;
	private String nombre;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitulacion() {
		return titulacion;
	}
	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setUsername(String username) {
		this.username = username;
	}


	private String apellidos;
	private String fechaNacimiento;
	private String telefono;
	private String email;
	private String titulacion;
	private String descripcion;
	
	public UserDAO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setuserName(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
 public static Connection getConnection(){
		// En primer lugar, obtenemos una instancia del driver de MySQL
		Connection con=null;
		try {
		  Class.forName("com.mysql.jdbc.Driver");
		  // Introducir correctamente el nombre y datos de conexión - Idealmente, estos datos se 
		  // indican en un fichero de propiedades
		  con= DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/i72caora","i72caora","angeluco");
		// Importante capturar 
		} catch(Exception e) {
		  System.out.println(e);
		}
		return con;
	  }
	
	
	public static boolean validationUser(String user, String password) {
		Statement stmt = null;
		boolean resul=false;
		try {
			Connection con=getConnection();
			// En consultas, se hace uso de un Statement 
			stmt = con.createStatement();
		    ResultSet rs = stmt.executeQuery("select username from User where username = '"+ user + "' AND password = '" + password + "'");
		    while (rs.next()) {
		    	resul=true;
		    }
		    // Se debe tener precaución con cerrar las conexiones, uso de auto-commit, etc.
		    if (stmt != null) 
		    	stmt.close(); 
		} catch (Exception e) {
			System.out.println(e);
		} 
		return resul;
	}
	
	//Insertar un nuevo usuario en la base de datos	
	public static int register(String nombre, String apellidos, String fechanacimiento, String telefono, String email, String titulacion, String descripcion) {
		int status=0;
		try {
			Connection con=getConnection();
			java.sql.PreparedStatement ps=con.prepareStatement("INSERT INTO User (nombre, apellidos, fechanacimiento, telefono, email, titulacion, descripcion) VALUES (?,?,?,?,?,?,?)");
			
			ps.setString(1, nombre);
			ps.setString(2, apellidos);
			ps.setString(3, fechanacimiento);
			ps.setString(4, telefono);
			ps.setString(5, email);
			ps.setString(6, titulacion);
			ps.setString(7, descripcion);
			status = ps.executeUpdate();
			
		}catch(Exception e) {System.out.println(e);}
		return status;
	}
	
	//Actualizar los datos de un usuario
	public static int update(String nombre, String apellidos, String fechanacimiento, String telefono, String email, String titulacion, String descripcion) {
		int status=0;
		try {
			Connection con=getConnection();
			java.sql.PreparedStatement ps=con.prepareStatement("update User set nombre=?, apellidos=?, fechanacimiento=?, telefono=?, email=?, titulacion=?, descripcion=? where id=?");
			
			ps.setString(1, nombre);
			ps.setString(2, apellidos);
			ps.setString(3, fechanacimiento);
			ps.setString(4, telefono);
			ps.setString(5, email);
			ps.setString(6, titulacion);
			ps.setString(7, descripcion);
		}catch(Exception e) {System.out.println(e);}
		return status;
	}
	
	
	
}
