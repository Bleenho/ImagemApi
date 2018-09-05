package br.com.facilitando.imagem.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaveImageRequest {

	private String fileName;
	
	private String base64;
	
}
