package br.com.facilitando.imagem.service;

import java.io.InputStream;

import br.com.facilitando.imagem.controller.request.SaveImageRequest;

public interface ImagemService {

	String save(SaveImageRequest request);

	InputStream findByName(String imageName);
}
