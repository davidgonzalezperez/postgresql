package com.curso;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Curson mañana/Desktop/Northwind.mdb");
		
		//Statement st = conn.createStatement();
		
//      int insertar = st.executeUpdate("insert into jugadores (id,nombre,apellido,sueldo,posicion) values (1,'karim','Benzema',50000,'delantero')");
//		int insertar = st.executeUpdate("insert into jugadores (id,nombre,apellido,sueldo,posicion) values (2,'Cristiano','Ronaldo',100000,'delantero')");
//		int insertar1 = st.executeUpdate("insert into jugadores (id,nombre,apellido,sueldo,posicion) values (3,'Sergio','Ramos',50000,'defensa')");
//		System.out.println("Filas insertadas "+insertar);
		
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from customers");
		
		while(rs.next()) {
			System.out.println("Nombre: "+rs.getString(2));
			System.out.println("Apellido: "+rs.getString(3));
			System.out.println("Sueldo: "+rs.getString(4));
			System.out.println("Posicion: "+rs.getString(5));
			System.out.println("-------------------");
		}
		
		/*PreparedStatement ps = conn.prepareStatement("select * from jugadores where nombre = ?");
		ps.setString(1, "Sergio");
		ResultSet rs  = ps.executeQuery();
		
		while(rs.next()) {
			System.out.println("Nombre: "+rs.getString(2));
			System.out.println("Apellido: "+rs.getString(3));
			System.out.println("Sueldo: "+rs.getInt(4));
			System.out.println("Posicion: "+rs.getString(5));
			System.out.println("-------------------");
		}*/
		
		/*CallableStatement cs = conn.prepareCall("{call jugadores_list()}");
		
		ResultSet rs = cs.executeQuery();
		
		while(rs.next()) {
			System.out.println("Nombre: "+rs.getString(2));
			System.out.println("Apellido: "+rs.getString(3));
			System.out.println("Sueldo: "+rs.getInt(4));
			System.out.println("Posicion: "+rs.getString(5));
			System.out.println("-------------------");
		}*/
		
	}

}
