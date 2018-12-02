package br.com.facilitando.imagem.controller;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.facilitando.imagem.controller.response.ProdutoResponse;
import br.com.facilitando.imagem.controller.response.ResponseDefault;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/produtos")
@Api(tags = "Produto", value = "Produtos")
public class ProdutoController {

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin
	public ResponseEntity<ResponseDefault> getProdutos()  {
		return new ResponseEntity<>(ResponseDefault.builder()
				.data(Arrays.asList(new ProdutoResponse().builder()
						.descricao("Tolente 1,8kg")
						.imagePath("http://18.224.199.70:8080/imagemApi/imagens/Palmito%20de%20pupunha")
						.nome("Palmite de pupunha")
						.build()))
				.success(true)
				.build(), HttpStatus.OK);
	}
	
}
