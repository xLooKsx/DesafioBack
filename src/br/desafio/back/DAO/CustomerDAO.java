package br.desafio.back.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.desafio.back.TO.CustomerTO;

public class CustomerDAO {

	private Connection connection;
	private PreparedStatement stm;	

	Logger logger = Logger.getLogger(CustomerDAO.class.getName());

	public CustomerDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void inserirCustomer(List<CustomerTO> Customers) {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ")
				.append("tb_customer_account ")
				.append("( ")
				.append("id_customer, ")
				.append("cpf_cnpj, ")
				.append("nm_cliente, ")
				.append("is_active, ")
				.append("vl_total ")
				.append(") ")
				.append("VALUES(?, ?, ?, ?, ?); ");

		try {
			this.stm = this.connection.prepareStatement(sql.toString());
			for (CustomerTO customerTODaVez : Customers) {

				this.stm.setInt(1, customerTODaVez.getId());
				this.stm.setString(2, customerTODaVez.getDocumento());
				this.stm.setString(3, customerTODaVez.getNome());
				this.stm.setInt(4, Integer.parseInt(customerTODaVez.getActive()));
				this.stm.setBigDecimal(5, customerTODaVez.getVlrTotal());
				this.stm.addBatch();
			}
			stm.executeBatch();

		} catch (SQLException e) {
			logger.log(Level.SEVERE,
					"Impossivel salvar os dados, porfavor verifique se tudo foi inserido corretamente ", e);
		} finally {
			try {
				this.stm.close();
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
