# Product API

## Tecnologias
* [Java 16](https://docs.oracle.com/en/java/)
* [Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
* [H2 Database](https://www.h2database.com/html/main.html)
* [Apache Maven](https://maven.apache.org/guides/)


&nbsp;
## Como rodar o prjeto
1. Na pasta principal do projeto, execute:

```shell script
mvn spring-boot:run 
```

2. No navegador, acesse:

```
http://localhost:8081/api
```


&nbsp;
## Model
### POST Request Model Example
```json
{
  "code": "BAN200",
  "name": "Banana",
  "description": "Banana Prata Orgãnica",
  "price": 2.99
}
```

#### Tipos de dados ProductDTO
* **code**: String
* **name**: String (length: { max: 150 })
* **description**: String (length: { max: 255 })
* **price**: BigDecimal

&nbsp;
### POST Response Model

```json
{
  "uuid": "6de1c9d3-519f-4fa7-9bba-0969d7050763",
  "message": "Product Created Successfully!",
  "createdAt": "2021-11-06"
}
```

#### Tipos de dados PostResponseDTO
* **uuid**: UUID
* **message**: String
* **createdAt**: LocalDate (pattern: "yyyy-MM-dd")


&nbsp;
### Product Entity Model
```json
{
  "uuid": "6de1c9d3-519f-4fa7-9bba-0969d7050763",
  "code": "BAN200",
  "name": "Banana",
  "description": "Banana Prata Orgãnica",
  "price": 2.99,
  "createdAt": "2021-11-06"
}
```

#### Tipos de dados Product Entity Model
* **uuid**: UUID
* **code**: String
* **name**: String
* **description**: String
* **price**: BigDecimal
* **createdAt**: Date


&nbsp;
### Exception Response Example
```json
{
  "error": "BAD REQUEST",
  "message": "CODE ALREADY REGISTERED",
  "code": 400,
  "timestamp": "2021-11-06T14:18:15.417207316"
}
```

#### Tipos de dados ExceptionResponse
* **error**: String
* **message**: String
* **conde**: int
* **timestamp**: LocalDateTime

&nbsp;
## Endpoints
Método | Rota | Status |Descrição
-------|------ | -------  | -------
GET | api/v1/products | 200 | Retorna um JSON com todos os produtos registrados
GET | api/v1/products?code= | 200 | Retorna um JSON com todos os produtos que contém o código especificado na rota
GET | api/v1/products/{code} | 200, 404 | Retorna um JSON com todos os dados do produto com o código especificado na rota ou ExceptionResponse caso não seja encontrado
POST | api/v1/products | 201, 400 | Retorna um CreateResponseDTO no formato JSON ou um ExceptionResponse, caso o código cadastrado já esteja registrado
DELETE | api/v1/products/{uuid} | 204 , 404 | Não retorna nada em caso de sucesso ou ExceptionResponse caso não seja encontrado o registro com o uuid especificado