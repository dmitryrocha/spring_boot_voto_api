# voto_api
## _API de votação baseada em Spring Boot_
---

Projeto desenvolvido como parte do programa de reskilling em Java oferecido pela Solutis Tecnologia

## Tecnologias utilizadas

- Java
- Spring Boot
- Banco de Dados H2

## Pré-requisitos
 - Java SDK na versão 1.8
 - Spring Boot na versão 2.6.7 ou superior

## Iniciando o projeto

### Clonar o repositório
 
 ```sh
https://github.com/dmitryrocha/spring_boot_voto_api.git
```

### Baixar as dependências e rodar o build no Maven 

 ```sh
$ mvn clean install
```

### Rodar como aplicativo Java
 
 ```sh
mvn spring-boot:run
```

Após a execução a inicialização conseguirá acessar:

- [Raiz da API](https://localhost:8080)
- [Documentação local no Swagger](http://localhost:8080/swagger-ui.html)
- [Documentação no Swagger hospedada no Heroku](https://limitless-garden-18285.herokuapp.com/swagger-ui.html)
- [Coleção no Postman](https://github.com/dmitryrocha/spring_boot_voto_api/blob/master/Vote_API.postman_collection.json)

## Tarefas bônus realizadas

### Tarefa Bônus 1 - Integração com sistemas externos
Integrar com um sistema externo que verifica, a partir do CPF do associado, se ele pode votar ou não. Observe que um CPF poderá ser usado apenas 1 vez por votação em determinada pauta. Caso o serviço externo esteja indisponível, permita o voto.
OBS: O serviço só verifica se foram passados 11 digitos ou não, veja exemplos de requisição e retornos abaixo.

### Tarefa Bônus 4 - Hospede sua API na nuven
Hospede sua API em um núvem qualquer. Cuidado para não gerar corbranças, explore serviços gratuítos como da [Free Tier AWS](https://aws.amazon.com/pt/free/), [Heroku](https://www.heroku.com/pricing) ou outro da sua escolha. Lembre-se de tratar Cross-Origin Resource Sharing (CORS). 

### Tarefa Bônus 5 - Análise de qualidade do código
Utilize o [Sonarqube](https://www.sonarqube.org/) para realizar uma análise de qualidade do seu código, aplique as correções necessárias e disponibilize o relatório.
