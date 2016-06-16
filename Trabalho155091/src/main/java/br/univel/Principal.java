package br.univel;

import java.util.List;

public class Principal {
	
	ReaderArquivo reader = new ReaderArquivo();
	List<String> lista = reader.lerArquivo();
	
	ProdutoParser parser = new ProdutoParser();
	List<CadastrodeProduto> listaPrd = parser.getProduto(lista);
	
	
	listaPrd.forEach(e ->{
		System.out.println("Id:" + e.getId());
		System.out.println("Descrição:" + e.getDescricao());
		System.out.println("Preço:" + e.getPreco());
	});

}
