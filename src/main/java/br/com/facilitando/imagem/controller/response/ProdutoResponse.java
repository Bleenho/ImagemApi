package br.com.facilitando.imagem.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoResponse {
	
	private Long id;
	
	private String nome;
	
	private String imagePath;
	
	private String descricao;
	
	private Long precoVenda;
}
