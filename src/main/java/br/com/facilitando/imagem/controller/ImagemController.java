package br.com.facilitando.imagem.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.facilitando.imagem.controller.request.SaveImageRequest;
import br.com.facilitando.imagem.controller.response.SaveImageResponse;
import br.com.facilitando.imagem.service.ImagemService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/imagens")
@Api(tags = "Imagem", value = "API's de imagem")
public class ImagemController {

	private ImagemService imagemService;
	
	public ImagemController(ImagemService imagemService) {
		this.imagemService  = imagemService;
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin
	public ResponseEntity<SaveImageResponse> saveImage(@RequestBody SaveImageRequest request)  {
		return new ResponseEntity<>(SaveImageResponse.builder().msgRetorno("Sucesso").imagemUrl(imagemService.save(request)).build(), HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value = "/{imageName}", method = RequestMethod.GET)
	public void getImageAsByteArray(HttpServletResponse response, @PathVariable(name = "imageName") String imageName) throws IOException {
	    
		InputStream in = imagemService.findByName(imageName);
		
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		
	    IOUtils.copy(in, response.getOutputStream());
	}
}
