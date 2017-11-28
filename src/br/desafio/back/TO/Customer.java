package br.desafio.back.TO;

import java.math.BigDecimal;

public class Customer {

	private int id;
	private String cpf;
	private String cnpj;
	private int active;
	private BigDecimal vlrTotal;
	
	public Customer() {
		this(0, "", "", 0, null);
	}

	public Customer(int id, String cpf, String cnpj, int active, BigDecimal vlrTotal) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.active = active;
		this.vlrTotal = vlrTotal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public BigDecimal getVlrTotal() {
		return vlrTotal;
	}

	public void setVlrTotal(BigDecimal vlrTotal) {
		this.vlrTotal = vlrTotal;
	}
	
}
