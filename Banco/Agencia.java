package Banco;

import java.util.ArrayList;
import java.util.Scanner;

public class Agencia {
	
	static Scanner input = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias;
	
	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();
		operacoes();
	}
	
	public static void operacoes() {
		System.out.println("-------------------------------------------------------");
		System.out.println("                     Bem vindo(a)                      ");
		System.out.println("-------------------------------------------------------");
		System.out.println("      Selecione a operação que deseja realizar         ");
		System.out.println("-------------------------------------------------------");
		System.out.println("|     Opção 1 - Criar conta     |");
		System.out.println("|     Opção 2 - Depositar       |");
		System.out.println("|     Opção 3 - Sacar           |");
		System.out.println("|     Opção 4 - Listar          |");
		System.out.println("|     Opção 5 - Sair            |");
		
		int operacao = input.nextInt();
		
		switch(operacao) {
		case 1:
			criarConta();
			break;
		
		case 2:
			depositar();
			break;
		
		case 3:
			sacar();
			break;
			
		case 4:
			listarContas();
			break;
		
		case 5:
			System.out.println("Volte sempre!");
			System.exit(0);
			
		default:
			System.out.println("Digite uma opção válida!");
			operacoes();
			break;			
		}
		
	}
	
	
	//CRIAR CONTA
	public static void criarConta() {
		
		Scanner input = new Scanner(System.in); // Initialize Scanner object

		System.out.println("\nNome: ");
		String nome = input.nextLine(); // Use nextLine() for input with spaces

		System.out.println("\nCPF: ");
		String cpf = input.nextLine(); // Use nextLine() for input with spaces

		System.out.println("\nTelefone: ");
		String telefone = input.nextLine(); // Use nextLine() for input with spaces

		
		Cliente pessoa = new Cliente(nome, cpf, telefone);
		
		Conta conta = new Conta(pessoa);
		
		contasBancarias.add(conta);
		System.out.println("Conta criada com sucesso!");
		
		operacoes();
		
	}
	
	//VALIDAÇÃO DE CONTA
	private static Conta encontrarConta(int numeroConta) {
		Conta conta = null;
		if (contasBancarias.size() > 0 ) {
			for(Conta c: contasBancarias) {
				if(c.getNumeroConta() == numeroConta)
					conta = c;
			}
		}
		
		return conta;
	}
	
	
	//VALIDAÇÃO DEPÓSITO
	private static void depositar() {
		System.out.println("Número da conta: ");
		int numeroConta = input.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		
		if(conta != null) {
			System.out.println("Qual valor deseja depositar? ");
			Double valorDeposito = input.nextDouble();
			conta.depositar(valorDeposito);
			
		}
		else {
			System.out.println("Conta não encontrada!");				
		}
		
		operacoes();
		
	}
	
	
	//VALIDAÇÃO SACAR
		private static void sacar() {
			System.out.println("Número da conta: ");
			int numeroConta = input.nextInt();
			
			Conta conta = encontrarConta(numeroConta);
			
			if(conta != null) {
				System.out.println("Qual valor deseja sacar? ");
				Double valorSaque = input.nextDouble();
				conta.sacar(valorSaque);
				
				System.out.println("Valor foi sacado!");
				
			}
			else {
				System.out.println("Conta não encontrada!");				
			}
			
			operacoes();
		}
		
	//LISTAR CONTAS
		public static void listarContas() {
			if(contasBancarias.size() > 0) {
				for(Conta conta: contasBancarias) {
				System.out.println(conta);
				}
			}
			else {
				System.out.println("Não há contas cadastradas");
		}
			operacoes();
		}
}


