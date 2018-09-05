package br.com.facilitando.imagem.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaveImageResponse {

	private String imagemUrl;
	
	private String msgRetorno;
}
