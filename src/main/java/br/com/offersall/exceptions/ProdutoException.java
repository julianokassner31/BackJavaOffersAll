package br.com.offersall.exceptions;

public class ProdutoException extends Exception{

	private static final long serialVersionUID = 1L;

	public enum EnumProdutoExcption{
		
		NAO_ENCONTROU_PRODUTO(1, "Produto não encontrado!");
		
		private int id;
		private String erro;
		private EnumProdutoExcption(int id, String erro) {
			this.id = id;
			this.erro = erro;
		}
		
		public String getErro() {
			return this.erro;
		}
		
		public int getId() {
			return this.id;
		}
	}
	
	public ProdutoException(EnumProdutoExcption e) {
		super(e.getErro());
	}
}
