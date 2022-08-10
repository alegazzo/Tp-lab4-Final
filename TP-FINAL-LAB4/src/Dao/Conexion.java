package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion { 
	
	
	String passFede = "gokusql"; 
	String passSanti= "admin";
	String passDoro= " ";
	String passRoot="root";
	
private Connection connection;
	
	public Conexion()
	{

	try
	{   
		Class.forName("com.mysql.jdbc.Driver"); 
		this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_gestion_educativa","root", passFede);

		this.connection.setAutoCommit(false); 
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}


public Connection obtenerConexion() 
{
	return this.connection;
}

public void cerrarConexion()
{
	try 
	{
	   this.connection.close();
	}
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
	
}

}
