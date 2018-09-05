package br.com.facilitando.imagem.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ObjectNotFound {
	
	private String nomeObjecto;
	
	private Object parametroUtilizado;
	
	private String local;
}
