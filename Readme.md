# Who am i

Responsible for storing encrypted images in base64 and offers them in only one URL


## Tecnologies used

* Java
	* SpringBoot
	* Swagger

## Compile

mvn clean package
	
## Execute

java -jar target\imagemApi.jar -Dspring.path.uploader.file={ImageRepositoryPath} -Dspring.endpoint.image={ExternalImageUrl}

### Examples of parameters:

*Dspring.path.uploader.file
	Windows
	ImageRepositoryPath = C:\\repository\\images\\

	Linux
	ImageRepositoryPath = var/repository/images/
	
*Dspring.endpoint.image
	
	ExternalImageUrl = localhost:8080/imagemApi/imagens/
	
### Document

localhost/imagenApi/swagger-ui.html

