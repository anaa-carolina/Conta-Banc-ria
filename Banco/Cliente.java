package Banco;

public class Cliente {
	
	private static int counter = 1;

	private String nome;
	private String cpf;
	private String telefone;
	
	
	
	public Cliente(String nome, String cpf, String telefone) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		counter += 1;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCPF() {
		return cpf;
	}
	public void setCPF(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	public String toString() {
		return  "\nNome: " + this.getNome() +
				"\nCPF: " + this.getCPF() +
				"\nTelefone: " + this.getTelefone();
	}
	
}
