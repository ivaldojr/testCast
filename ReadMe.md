# TestCast
Aplicação desenvolvida para seleção na cast Group.
	
## Assignment

•	Develop a backend with Spring Boot where there are 4 endpoint. 
o	(List all persons)
o	(Find a person by ID)
o	(Save a Person). 
o	(Delete a person by ID)
•	Develop a frontend to consume theses services in Angular 1.

•	A person has:
o	Name
o	ID
o	Street
o	Number
o	Neighborhood
o	City
o	State
o	Cellphone
o	Phone


## Technologies

Spring Boot
MySQL
AngulaJSr

## Executando

## Banco de dados 

1 - Criar um schema no mySql e deixar deixar as credencias e serviços de acordo com o arquivo application.properties localizado na pasta resources.

##Projeto Java:

1 -Importar o projeto maven no eclipse

2 - Atualizar as dependências do maven, clicando com o botão direito no projeto >> Maven >> Update Project...

3 - Abrir o arquivo application.properties, escolher a porta que a aplicação ficará disponível e setar os dados de acesso ao banco.

Ex: server.port = 8081 spring.datasource.url=jdbc:mysql://localhost:3306/test_cast spring.datasource.username= seu_user_name spring.datasource.password= sua_senha

## Start da aplicação

1 - Rodar a classe principal TestCastApplication e o serviço será levantado

2 - acessar a aplicação na porta escolhida ex: http://localhost:8081

## Testes

1 - Os exemplos de teste estão localizados no diretório src/test/java e podem ser executados clicando com o botão direito sobre a classe >> Run As... >> Junit Test

2 - Os exemplos de teste cobrem a persistência com JPA e teste da lógica contida no service.


