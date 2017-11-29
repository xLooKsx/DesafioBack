package br.desafio.back.TO;

import java.math.BigDecimal;

public class CustomerTO {

	private int id;
	private String documento;
	private String nome;
	private String active;
	private BigDecimal vlrTotal;
	
	public CustomerTO() {
		this(0, "", "", "", null);
	}

	public CustomerTO(int id, String documento, String nome, String active, BigDecimal vlrTotal) {
		super();
		this.id = id;
		this.documento = documento;
		this.nome = nome;
		this.active = active;
		this.vlrTotal = vlrTotal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getVlrTotal() {
		return vlrTotal;
	}

	public void setVlrTotal(BigDecimal vlrTotal) {
		this.vlrTotal = vlrTotal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "CustomerTO [id=" + id + ", documento=" + documento + ", nome=" + nome + ", active=" + active
				+ ", vlrTotal=" + vlrTotal + "]";
	}
}
