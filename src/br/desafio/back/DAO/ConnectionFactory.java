package br.desafio.back.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.desafio.back.utils.DesafioBackUtils;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			Class.forName(DesafioBackUtils.getProperty("config.bd.class"));
			return DriverManager.getConnection(DesafioBackUtils.getProperty("config.bd.conexao"), "postgres", "admin");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}catch (ClassNotFoundException e) {
			 throw new RuntimeException(e);
		}
	}
}
