package br.univel;

import java.util.List;

public class Principal {

	public static void main(String[] args) throws Exception {
	
	ReaderArquivo reader = new ReaderArquivo();
	List<String> lista = reader.lerArquivo();
	
	ProdutoParser parser = new ProdutoParser();
	List<Produto> listaPrd = parser.getProduto(lista);
	
	
	listaPrd.forEach(e ->{
		System.out.println("Id:" +e.getId());
		System.out.println("Descrição:" + e.getDescricao());
		System.out.println("Preço:" + e.getPreco());
	});

   }
}
