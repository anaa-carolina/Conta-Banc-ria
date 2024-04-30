package Banco;

import Utilitarios.Formatacao;

public class Conta {
	
	private static int contadorContas = 1;
	private static final int taxa = 5;
	
	private int numeroConta;
	private Cliente pessoa;
	private Double saldo = 0.0;
	
	public Conta (Cliente pessoa) {
		this.numeroConta = contadorContas;
		this.pessoa = pessoa;
		contadorContas += 1;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Cliente getPessoa() {
		return pessoa;
	}

	public void getPessoa(Cliente pessoa) {
		this.pessoa = pessoa;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public String toString() {
		return  "\nNumero da conta: " + this.getNumeroConta() +
				"\nNome: " + this.pessoa.getNome() +
				"\nCPF: " + this.pessoa.getCPF() +
				"\nTelefone: " + this.pessoa.getTelefone() +
				"\nSaldo: " + Formatacao.doubleToString(this.getSaldo()) + "\n" ;
	}
	
	//DEPÓSITO
	public void depositar(Double valor) {
		if(valor > 0) {
			setSaldo(getSaldo() + valor);
			System.out.println("Seu depósito foi realizado com sucesso!");
		} 
		else {
			System.out.println("Não foi possível realizar o depósito!");
		}
	}
	
	
	
	//SACAR	
	public void sacar(Double valor) {
		if(valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			setSaldo(valor - taxa); 
			System.out.println("Seu saque foi realizado com sucesso!");
		}
		else {
			System.out.println("Não foi possível realizar o saque!");
		}
	}
	
}
