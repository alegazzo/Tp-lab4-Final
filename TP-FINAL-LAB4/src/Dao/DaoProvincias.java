package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Dominio.Provincia;
import IDao.IProvincia;

public class DaoProvincias implements IProvincia {
		
		public ArrayList<Provincia> listarProvincias() {
				
				ResultSet resultSet; 
				ArrayList<Provincia> provincias = new ArrayList<Provincia>();
				Conexion conexionSql = null; 
				String query = "select id, nombre, id_pais from provincia";
					
				try {
					conexionSql = new Conexion();
					Connection connection = conexionSql.obtenerConexion();
					PreparedStatement statement = connection.prepareStatement(query);
					resultSet = statement.executeQuery();
					while(resultSet.next())
					{	
						provincias.add(
						new Provincia(
								resultSet.getInt("id"),
								resultSet.getString("nombre"),
								resultSet.getInt("id_pais")
						));
					}
					
					return provincias; 
						
				} 
				catch (SQLException e) {
					
					 e.printStackTrace();
				} 
				
				finally {
					conexionSql.cerrarConexion();
				}

		        return null; 

			}


		
}
