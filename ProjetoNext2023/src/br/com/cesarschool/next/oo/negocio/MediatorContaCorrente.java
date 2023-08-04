package br.com.cesarschool.next.oo.negocio;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.com.cesarschool.next.oo.dao.DAOContaCorrente;
import br.com.cesarschool.next.oo.entidade.ContaCorrente;
import br.com.cesarschool.next.oo.entidade.ContaPoupanca;

public class MediatorContaCorrente {
	private DAOContaCorrente dao = new DAOContaCorrente();
	
	public MediatorContaCorrente() {
		
	}
	
	public String incluir(ContaCorrente conta) {
		if (conta.obterChaves() == null || conta.obterChaves().isBlank()) {
			return "Favor, incluir números da conta";
		} else if(conta.obterChaves().length() < 5) {
			return "Número de conta abaixo do permitido (5 caracteres)";
		} else if(conta.obterChaves().length() > 8) {
			return "Dígitos da conta acima do limite permitido (8 caracteres)";
		} else if(conta.getSaldo() < 0) {
			return "Não foi possível efetuar a ação, pois o saldo está negativado";
		} else if(conta.getNomeDoCorrentista() == null || conta.getNomeDoCorrentista().isBlank() || conta.getNomeDoCorrentista().length() > 60) {
			return "Nome inválido";
		} else {
			
			if(conta instanceof ContaPoupanca) {
				ContaPoupanca contaPoupanca = (ContaPoupanca)conta;
				boolean inclusao = dao.incluir(contaPoupanca);
				if (!inclusao) {
					return "Conta poupança já existente";
				}else {
					return null;
				}
			}
			
			boolean inclusao = dao.incluir(conta);
			if (!inclusao) {
				return "Conta corrente já existente";
			} else {
				return null;
			} 
		}
	}
	
	public String creditar(double valor, String numero) {
		if (valor < 0) {
			return "Valor inválido (Deve ser maior ou igual a zero)";
		} else if(numero == null || numero.isBlank()) {
			return "Número de conta inválido";
		} else {
			
			
			ContaCorrente conta = dao.buscar(numero);
			if(conta == null) {
				return "Conta inexistente";
			} else {
				
				conta.creditar(valor);
				dao.alterar(conta);
				return null;
			}
		}
	}
	
	public String debitar(double valor, String numero){
		if (valor < 0) {
			return "Valor inválido (Deve ser maior ou igual a zero)";
		} else if(numero == null || numero.isBlank()) {
			return "Número de conta inválido";
		} else {
			ContaCorrente conta = dao.buscar(numero);
			if(conta == null) {
				return "Conta inexistente";
			} else {
				if (conta.getSaldo() < valor) {
					return "Saldo insuficiente";
				}else {
					conta.debitar(valor);
					dao.alterar(conta);
					return null;
				}
			}
		}
	}
	
	public ContaCorrente buscar(String numero) {
		if (numero == null || numero.isBlank()) {
			return null;
		} else {
			ContaCorrente cc = dao.buscar(numero);
			return cc;
		}
	}
	
	public List<ContaCorrente> gerarRelatorioGeral(){
		ContaCorrente[] cc = dao.buscarTodos();
		List<ContaCorrente> contas = Arrays.asList(cc);
		Collections.sort(contas, new ComparadorContaCorrenteSaldo());
		return contas;
	}
}
