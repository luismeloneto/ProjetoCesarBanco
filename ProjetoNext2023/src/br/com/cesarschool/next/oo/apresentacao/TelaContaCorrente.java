package br.com.cesarschool.next.oo.apresentacao;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import br.com.cesarschool.next.oo.entidade.ContaCorrente;
import br.com.cesarschool.next.oo.entidade.ContaPoupanca;
import br.com.cesarschool.next.oo.negocio.MediatorContaCorrente;

public class TelaContaCorrente {
	private MediatorContaCorrente mediator = new MediatorContaCorrente();
	public static final Scanner sc = new Scanner(System.in);
	
	public TelaContaCorrente() {
		
	}
	
	public void telaInicial() {
		int opcao = 0;
		do {

			System.out.println("1- Incluir nova conta");
			System.out.println("2- Creditar um valor na conta");
			System.out.println("3- Debitar um valor na conta");
			System.out.println("4- Consultar conta");
			System.out.println("5- Gerar relatório geral de contas bancárias");
			System.out.println("6- Sair");
			System.out.print("Escolha uma opção: ");

			opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				incluir();
				break;
			case 2:
				creditar();
				break;
			case 3:
				debitar();
				break;
			case 4:
				buscar();
				break;
			case 5:
				gerarRelatorioGeral();
				break;
			case 6:
				System.out.println("Finalizando...");
				break;
			default:
				System.out.println("Opção inválida");

			}


		} while(opcao != 6);
	}
	
	public void incluir() {

		System.out.println("1 - Nova conta corrente");
		System.out.println("2 - Nova conta poupança");
		System.out.print("Escolha uma opção: ");
	
		int tipoConta = sc.nextInt();

		System.out.print("Número de conta: ");
		String numConta = sc.next();
		System.out.print("Saldo inicial: ");
		double saldo = sc.nextDouble();
		System.out.print("Nome do correntista: ");
		String nomeCorrentista = sc.next();

		if (tipoConta == 1) {
			String inclusao = mediator.incluir(new ContaCorrente(numConta, saldo, nomeCorrentista));
			if (inclusao == null) {
				System.out.println("Sucesso na inclusão");
				
			} else {
				System.out.println(inclusao);
			}
		} else if(tipoConta == 2) {
			System.out.println("Percentual de bônus");
			double percentualDeBonus = sc.nextDouble();
			String inclusao = mediator.incluir(new ContaPoupanca(numConta, saldo, nomeCorrentista, percentualDeBonus));
			if (inclusao == null) {
				System.out.println("Sucesso na inclusão");
				
			} else {
				System.out.println(inclusao);
			}
		} else {
			System.out.println("Opção inválida");
		}
	}
	
	
	public void creditar() {
		System.out.print("Número da conta: ");
		String numConta = sc.next();
		System.out.print("Valor: ");
		double valor = sc.nextDouble();
		
		String resultado = mediator.creditar(valor, numConta);
		if (resultado == null) {
			System.out.println("Sucesso no creditar");
		} else {
			System.out.println(resultado);
		}
		
	}
	
	public void debitar() {
		System.out.print("Número da conta: ");
		String numConta = sc.next();
		System.out.print("Valor: ");
		double valor = sc.nextDouble();
		
		String resultado = mediator.debitar(valor, numConta);
		if (resultado == null) {
			System.out.println("Sucesso no debitar");
		} else {
			System.out.println(resultado);
		}
	}
	
	public void buscar() {
		System.out.print("Número de conta: ");
		String numConta = sc.next();
		
		ContaCorrente conta = mediator.buscar(numConta);
		if (conta == null) {
			System.out.println("Conta não existente");
		} else {
			System.out.println(conta);
		}
	
	}
	
	public void gerarRelatorioGeral(){
		List<ContaCorrente> listaDeContas = mediator.gerarRelatorioGeral();
		for (ContaCorrente contaCorrente : listaDeContas) {
			System.out.println(contaCorrente);
		}
		
	}
}
