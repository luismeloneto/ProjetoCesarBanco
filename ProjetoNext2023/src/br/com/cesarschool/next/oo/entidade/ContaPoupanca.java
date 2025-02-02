package br.com.cesarschool.next.oo.entidade;

public class ContaPoupanca extends ContaCorrente{

	private static final long serialVersionUID = 1L;
	private double percentualDeBonus;
	
	public ContaPoupanca() {

	}
	
	public ContaPoupanca(double percentualDeBonus) {
		this.setPercentualDeBonus(percentualDeBonus);
	}
	
	public ContaPoupanca(String numeros, double saldo, String nomeDoCorrentista, double percentualDeBonus) {
		super(numeros, saldo, nomeDoCorrentista);
		this.setPercentualDeBonus(percentualDeBonus);
	}

	public double getPercentualDeBonus() {
		return percentualDeBonus;
	}

	public void setPercentualDeBonus(double percentualDeBonus) {
		this.percentualDeBonus = percentualDeBonus;
	}
	
	@Override
	public void creditar(double valor) {
		super.creditar(super.getSaldo() + valor*(1 + this.percentualDeBonus) / 100);
	}
	
	
	
}
