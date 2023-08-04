package br.com.cesarschool.next.oo.entidade;

import java.io.Serializable;

public class ContaCorrente extends RegistroIdentificavel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String numeros;
	private double saldo;
	private String nomeDoCorrentista;
	
	public ContaCorrente() {
		
	}

	public ContaCorrente(String numeros, double saldo, String nomeDoCorrentista) {
		this.numeros = numeros;
		this.saldo = saldo;
		this.nomeDoCorrentista = nomeDoCorrentista;
	}

	public void setNumeros(String numeros) {
		this.numeros = numeros;
	}

	public double getSaldo() {
		return saldo;
	}
	

	public String getNomeDoCorrentista() {
		return nomeDoCorrentista;
	}

	public void setNomeDoCorrentista(String nomeDoCorrentista) {
		this.nomeDoCorrentista = nomeDoCorrentista;
	}
	
	public void creditar(double valor) {
		this.saldo += valor;
	}
	
	public void debitar(double valor) {
		this.saldo -= valor;
	}
	
	 public String toString() {
	        return "Nome: " + this.nomeDoCorrentista + "\nNúmero da conta: " + this.numeros + "\nSaldo:" + this.saldo + "\n";
	    }

	@Override
	public String obterChaves() {
		return this.numeros;
	}
}
