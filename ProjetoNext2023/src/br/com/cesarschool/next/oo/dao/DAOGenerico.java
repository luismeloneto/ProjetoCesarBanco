package br.com.cesarschool.next.oo.dao;

import br.com.cesarschool.next.oo.entidade.ContaCorrente;
import br.com.cesarschool.next.oo.entidade.RegistroIdentificavel;
import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;

public class DAOGenerico {
	private CadastroObjetos cadastro;
	
	
	DAOGenerico(){
		
	}
	
	DAOGenerico(Class tipoEntidade){
		cadastro = new CadastroObjetos(tipoEntidade);
	}
	
	public boolean incluir(ContaCorrente reg) {
		RegistroIdentificavel ccBusca = buscar(reg.obterChaves()); 
		if (ccBusca != null) {
			return false;
		} else {
			cadastro.incluir(reg, reg.obterChaves());
			return true;
		}
	}
	
	public boolean alterar(RegistroIdentificavel reg) {
		RegistroIdentificavel ccBusca = buscar(reg.obterChaves());
		if (ccBusca == null) {
			return false;
		}else {
			cadastro.alterar(reg, reg.obterChaves());
			return true;
		}
	}
	
	public boolean excluir(String chave) {
		
		
		
		return false;
		
	}
	
	
	
	public RegistroIdentificavel buscar(String codigo) {
		return (RegistroIdentificavel)cadastro.buscar(codigo);
	}
	
	

}
