package br.com.cesarschool.next.oo.apresentacao;

import br.com.cesarschool.next.oo.entidade.ContaCorrente;
import br.com.cesarschool.next.oo.entidade.ContaPoupanca;
import br.com.cesarschool.next.oo.negocio.MediatorContaCorrente;


public class Main {
	public static void main(String[] args) {
		
		MediatorContaCorrente cad = new MediatorContaCorrente();	

		System.out.println(cad.incluir(new ContaCorrente("321321", 50, "Gabriel")));
		
		System.out.println(cad.incluir(new ContaPoupanca("312312", 1500, "Oliveira", 50)));
		
		
	}

}
