package br.desafio.back.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDAO {
	
	private Connection connection;
	private PreparedStatement stm;
	private ResultSet rs;
	
	Logger logger = Logger.getLogger(CustomerDAO.class.getName());
	
	public CustomerDAO() {		
		this.connection = new ConnectionFactory().getConnection();
	} 

	public boolean teste(){
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT * FROM tb_customer_account ");
		
		try {
			this.stm = connection.prepareStatement(sql.toString());
			this.stm.execute();
			this.rs = stm.executeQuery();
			logger.log(Level.INFO, this.stm.toString());
			if (rs.next()) {
				return true;
			}			
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Erro ao fazer busca",e);
		}finally {
			try {
				this.rs.close();
				this.stm.close();
				this.connection.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
	}
		return false;
	}
	}
