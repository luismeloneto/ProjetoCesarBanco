package br.com.cesarschool.next.oo.dao;

import java.io.Serializable;

import br.com.cesarschool.next.oo.entidade.ContaCorrente;
import br.com.cesarschool.next.oo.entidade.ContaPoupanca;
import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;

public class DAOContaCorrente{
	private CadastroObjetos cadastro = new CadastroObjetos(ContaCorrente.class);
	
	public boolean incluir(ContaCorrente conta) {
		ContaCorrente ccBusca = buscar(conta.getNumeros()); 
		if (ccBusca != null) {
			return false;
		} else {
			cadastro.incluir(conta, conta.getNumeros());
			return true;
		}
	}
	
	public boolean alterar(ContaCorrente conta) {
		ContaCorrente ccBusca = buscar(conta.getNumeros());
		/*
		 * ARMAZENA A CONTA CORRENTE, CASO HAJA ALGUÉM COM O NÚMERO DA CONTA PASSADA.
		 * SE NÃO HOUVER ALGUMA CONTA COM O NÚMERO PASSADO, RETORNA FALSE. 
		 * CASO HAJA UMA CONTA COM O MESMO NÚMERO PASSADO, A ALTERAÇÃO É FEITA COM SUCESSO E RETORNA TRUE. 
		 */
		if (ccBusca == null) {
			return false;
		}else {
			cadastro.alterar(conta, conta.getNumeros());
			return true;
		}
	}
	
	public ContaCorrente buscar(String numero) {
		/*
		 * PROCURA NO OBJETO DO TIPO CadastroObjetos cadastro, UM MATCH PRO NUMERO DE CONTA PASSADO COMO PARÂMETRO
		 * O MATCH É PERCORRIDO PELAS CONTAS JÁ CADASTRADAS, SALVAS EM ARQUIVOS NÃO VOLÁTEIS. 
		 * O TIPO DE ARMAZENAMENTO NÃO VOLÁTIL PODE PERSISTIR DADOS, SIGNIFICANDO QUE NÃO HÁ PERDA DE DADOS AO RETIRAR O PC DE UMA FONTE DE ENERGIA
		 */
		return (ContaCorrente)cadastro.buscar(numero);
	}
	
	public ContaCorrente[] buscarTodos(){
		
		Serializable[] rets = cadastro.buscarTodos(ContaCorrente.class);
		/*
		 * RETS = LISTA QUE ARMAZENA TUDO QUE FOR SERIALIZABLE, SENDO PASSADO DO TIPO ContaCorrente
		 * CADASTRO (DA PERSISTENCIA CadastroObjetos) .BUSCARTODOS (MÉTODO DA PERSISTÊNCIA CadastroObjetos)
		 */
		
		ContaCorrente[] contas = new ContaCorrente[rets.length];
		/*
		 * LISTA contas ARMAZENA TUDO DO TIPO ContaCorrente (MESMO TAMANHO DA LISTA rets)
		 */
		
		for (int i = 0; i<contas.length; i++) {
			contas[i] = (ContaCorrente)rets[i];
		}
		/* 
		 * ALIMENTANDO A LISTA contas COM OS DADOS DE CONTASCORRENTE DE rets
		 */
		return contas;
	}
}
