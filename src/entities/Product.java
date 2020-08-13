package entities;

public class Product {
	private String descricao;
	private double valor;
	
	public Product() {}
	
	public Product(String descricao, double valor) {
		this.descricao = descricao;
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return "{" + descricao + ", " + valor + "}";
	}

	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
}
