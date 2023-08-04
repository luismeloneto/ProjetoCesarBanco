package br.com.cesarschool.next.oo.dao;

import java.io.Serializable;

import br.com.cesarschool.next.oo.entidade.ContaCorrente;
import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;

public class DAOContaCorrente{
	private CadastroObjetos cadastro = new CadastroObjetos(ContaCorrente.class);
	
	public DAOContaCorrente() {
		
	}
	
	public boolean incluir(ContaCorrente conta) {
		ContaCorrente ccBusca = buscar(conta.obterChaves()); 
		if (ccBusca != null) {
			return false;
		} else {
			cadastro.incluir(conta, conta.obterChaves());
			return true;
		}
	}
	
	public boolean alterar(ContaCorrente conta) {
		ContaCorrente ccBusca = buscar(conta.obterChaves());
		if (ccBusca == null) {
			return false;
		}else {
			cadastro.alterar(conta, conta.obterChaves());
			return true;
		}
	}
	
	public ContaCorrente buscar(String numero) {
		return (ContaCorrente)cadastro.buscar(numero);
	}
	
	public ContaCorrente[] buscarTodos(){
		Serializable[] cads = cadastro.buscarTodos(ContaCorrente.class);
		ContaCorrente[] contas = new ContaCorrente[cads.length];		
		for (int i = 0; i<contas.length; i++) {
			contas[i] = (ContaCorrente)cads[i];
		}
		return contas;
	}
}
