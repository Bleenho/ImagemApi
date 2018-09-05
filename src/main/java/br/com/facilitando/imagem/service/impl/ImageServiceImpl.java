package br.com.facilitando.imagem.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.facilitando.imagem.controller.exception.ObjectNotFountException;
import br.com.facilitando.imagem.controller.request.SaveImageRequest;
import br.com.facilitando.imagem.domain.ObjectNotFound;
import br.com.facilitando.imagem.service.ImagemService;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class ImageServiceImpl implements ImagemService{

	@Value("${path.uploader.file}")
	private String uploaderFile;
	
	@Value("${endpoint.imagem}")
	private String endpointGetImagem;
	
	@Override
	public String save(SaveImageRequest request) {
		
		try {
			byte[] bytes = Base64.getDecoder().decode(request.getBase64().getBytes("UTF-8"));
			
			Path path = Paths.get(uploaderFile , request.getFileName() +".jpg");
            Files.write(path, bytes);
		} catch (UnsupportedEncodingException e) {
			log.error("Problema com o base64 e->" +e.getMessage() );
		} catch (IOException e) {
			log.error("Problema ao escrever em arquivo e->" +e.getMessage());
		}
		
		return this.endpointGetImagem + request.getFileName();
	}

	@Override
	public InputStream findByName(String imageName) {
		
		File initialFile = new File(this.uploaderFile + imageName + ".jpg");
		InputStream targetStream = null;
		try {
			targetStream = new FileInputStream(initialFile);
			
		} catch (FileNotFoundException e) {
			log.error("Erro ao encontrar imagem "+imageName +" e->"+ e.getMessage());
			throw new ObjectNotFountException(ObjectNotFound.builder()
					.nomeObjecto("Arquivo: " + imageName)
					.parametroUtilizado(imageName)
					.local(uploaderFile)
					.build());
		}
	
		return targetStream ;
	}
}
