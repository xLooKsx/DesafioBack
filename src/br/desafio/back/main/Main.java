package br.desafio.back.main;

import java.util.Scanner;

import br.desafio.back.DAO.CustomerDAO;
import br.desafio.back.TO.CustomerTO;

public class Main {

	private static CustomerTO customerTO;

	public static void main (String[] args){
		
		Scanner entrada = new Scanner(System.in);
		String tipoDocumento;
		
		do {
			 customerTO = new CustomerTO();
			System.out.println("Bem vindo, insira os valores ou pressione enter para sair");
			/*
			 * Inserção do nome
			 */
			System.out.println("nome: ");
			customerTO.setNome(entrada.nextLine());
			
			/*
			 * Inserção do cpf
			 */
			System.out.println("Escolha 1-CPF\n2-CNPJ: ");
			tipoDocumento = entrada.nextLine();
			while(!tipoDocumento.trim().equals("1") || !tipoDocumento.trim().equals("2") ){
				System.out.println("Escolha 1-CPF\n2-CNPJ: ");
				tipoDocumento = entrada.nextLine();
			}
			System.out.println("Insira o seu documento: ");
			customerTO.setDocumento(entrada.nextLine());
			//verificar se documento é valido
			
			
			
		} while (customerTO.getNome().trim().length() != 0);
		
		
		
		
		
		CustomerDAO customerDAO = new CustomerDAO();
		
		System.out.println(customerDAO.teste());
	}
}
