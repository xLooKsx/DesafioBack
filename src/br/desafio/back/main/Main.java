package br.desafio.back.main;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.desafio.back.DAO.CustomerDAO;
import br.desafio.back.TO.CustomerTO;
import br.desafio.back.utils.DesafioBackUtils;

public class Main {

	private static CustomerTO customerTO;

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		BigDecimal vlrTotal = new BigDecimal(0.0);

		StringBuilder clientes = new StringBuilder();

		List<CustomerTO> customers = new ArrayList<>();		 

		String tipoDocumento;
		String idTemp;
		String mensagemErro = "Insira o saldo do cliente";

		boolean docValido = false;
		boolean valorValido = true;

		int qtdCustomersEscolhidos = 0;		

		System.out.println("Bem vindo, insira os valores ou pressione enter para sair");
		do {
			customerTO = new CustomerTO();

			/*
			 * Inserção do nome
			 */
			System.out.println("nome: ");
			customerTO.setNome(entrada.nextLine());
			if (customerTO.getNome().trim().length() == 0) {
				if (!customers.isEmpty()) {
					new CustomerDAO().inserirCustomer(customers);
				}
				break;
			}

			/*
			 * Inserção do Id
			 */
			System.out.println("Insira o id: ");
			idTemp = entrada.nextLine();
			while (!idTemp.matches("[0-9]*")) {
				System.out.println("O id deve ser numerico: ");
				idTemp = entrada.nextLine();
			}
			customerTO.setId(Integer.parseInt(idTemp));

			/*
			 * Inserção do CPF/CNPJ
			 */
			System.out.println("Escolha 1-CPF ou 2-CNPJ: ");
			tipoDocumento = entrada.nextLine();
			while (!tipoDocumento.matches("[1-2]")) {
				System.out.println("Opção invalida, porfavor escolha 1-CPF\n2-CNPJ: ");
				tipoDocumento = entrada.nextLine();
			}
			System.out.println("Insira o seu documento(Sem traços ou pontos): ");
			customerTO.setDocumento(entrada.nextLine());
			docValido = DesafioBackUtils.escolherTipoValidacao(tipoDocumento, customerTO.getDocumento());
			while (!docValido) {
				System.out.println("Insira o documento corretamento(Sem traços ou pontos): ");
				customerTO.setDocumento(entrada.nextLine());
				docValido = DesafioBackUtils.escolherTipoValidacao(tipoDocumento, customerTO.getDocumento());
			}

			/*
			 * Inserção do status do cliente
			 */
			System.out.println("Insira o status do cliente 1-Ativo ou 0-Inativo ");
			customerTO.setActive(entrada.nextLine());
			while (!customerTO.getActive().trim().matches("[0-1]")) {
				System.out.println("Opção invalida, porfavor escolha 1-Ativo ou 0-Inativo ");
				customerTO.setActive(entrada.nextLine());
			}

			/*
			 * Inserido o saldo do cliente
			 */
			do {
				try {
					System.out.println(mensagemErro);
					customerTO.setVlrTotal(new BigDecimal(entrada.nextLine()));
					valorValido = false;
				} catch (NumberFormatException e) {
					mensagemErro = "Saldo invalido, insira novamente:";
				}
			} while (valorValido);

			customers.add(customerTO);
		} while (true);
		
		entrada.close();
		/*
		 * Ordenando a lista de forma decrescente usando o valor total como
		 * criterio
		 */
		Collections.sort(customers, Comparator.comparing(CustomerTO::getVlrTotal).reversed());

		/*
		 * Escolhendo os clientes que se encaixam nos requerimentos
		 */
		for (CustomerTO customerDaVez : customers) {
			if ((customerDaVez.getVlrTotal().compareTo(new BigDecimal(560)) == 1) && customerDaVez.getId() >= 1500
					&& customerDaVez.getId() <= 2700 && customerDaVez.getActive().contains("1")) {
				vlrTotal = vlrTotal.add(customerDaVez.getVlrTotal());

				clientes.append("Id: " + customerDaVez.getId())
								.append("\nDocumento: " + customerDaVez.getDocumento())
								.append("\nNome: " + customerDaVez.getNome())
								.append("\nEsta Ativo: " + (customerDaVez.getActive().trim().contains("1") ? "Sim" : "Não"))
								.append("\nValor total: " + customerDaVez.getVlrTotal()).append("\n");
				qtdCustomersEscolhidos++;
			}
		}
		 
		System.out.println("Valor da media: " + DesafioBackUtils.cacularMedia(vlrTotal, qtdCustomersEscolhidos) + "\n");
		System.out.println(clientes.toString().length() == 0 ? "nenhum Cliente cadastrado" : clientes.toString());

		System.exit(0);
	}
}
