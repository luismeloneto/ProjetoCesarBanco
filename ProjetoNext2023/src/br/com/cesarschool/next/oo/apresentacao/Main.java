package br.com.cesarschool.next.oo.apresentacao;

import java.util.List;

import br.com.cesarschool.next.oo.entidade.ContaCorrente;
import br.com.cesarschool.next.oo.entidade.ContaPoupanca;
import br.com.cesarschool.next.oo.negocio.MediatorContaCorrente;


public class Main {
	public static void main(String[] args) {
		
		MediatorContaCorrente cad = new MediatorContaCorrente();	

		
		
		List<ContaCorrente> cc = cad.gerarRelatorioGeral();
		
		for (ContaCorrente contaCorrente : cc) {
			
			System.out.println("Nome: " + contaCorrente.getNomeDoCorrentista() + "\nSaldo: " + contaCorrente.getSaldo() + "\n");
			
		}
		
				

			
			
			
		}
		
	}

