package br.com.cesarschool.next.oo.apresentacao;

import br.com.cesarschool.next.oo.dao.DAOContaCorrente;
import br.com.cesarschool.next.oo.entidade.ContaCorrente;


public class Main {
	public static void main(String[] args) {
		
		DAOContaCorrente cad = new DAOContaCorrente();	
		
		
		ContaCorrente cc = cad.buscar("123392");
		
		System.out.println(cc);
		
		
	}

}
