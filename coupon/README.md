# Coupon API

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
http://localhost:8080/api
```


&nbsp;
## Model
### POST/PUT Request Model Example
```json
{
  "code": "BQD303",
  "discount": 50.00,
  "expireDate": "2022-02-12"
}
```

#### Tipos de dados CouponDTO
* **uuid**: UUID
* **code**: Sting (length: { min: 6, max: 6 })
* **discount**: BigDecimal
* **expireDate**: LocalDate (pattern: "yyyy-MM-dd")

&nbsp;
### POST/PUT Response Model

```json
{
  "uuid": "6de1c9d3-519f-4fa7-9bba-0969d7050763",
  "message": "Coupon Created Successfully!"
}
```

#### Tipos de dados PostResponseDTO
* **uuid**: UUID
* **message**: String


&nbsp;
### Coupon Model
```json
{
  "uuid": "6de1c9d3-519f-4fa7-9bba-0969d7050763",
  "code": "BQD101",
  "discount": 50.00,
  "expireDate": "2022-02-12",
  "createdAt": "2021-11-05"
}
```

#### Tipos de dados Coupon Model
* **uuid**: UUID
* **code**: Sting (length: { min: 6, max: 6 })
* **discount**: BigDecimal
* **expireDate**: LocalDate (pattern: "yyyy-MM-dd")
* **createdAt**: LocalDate (pattern: "yyyy-MM-dd")


&nbsp;
### Exception Response Example
```json
{
  "error": "Bad Request",
  "message": "Coupon code already registered!",
  "status": "BAD_REQUEST",
  "timestamp": "2021-11-05T12:10:30.99859076"
}
```

#### Tipos de dados ExceptionResponse
* **error**: String
* **message**: Sting
* **status**: HttpStatus
* **timestamp**: LocalDateTime

&nbsp;
## Endpoints
Método | Rota | Status |Descrição
-------|------ | -------  | -------
GET | api/v1/coupon | 200 | Retorna um JSON com todos os cupons registrados 
GET | api/v1/coupon?code= | 200 | Retorna um JSON com todos os cupons que contém o código especificado na rota
GET | api/v1/coupon/{uuid} | 200, 404 | Retorna um JSON com todos os dados do cupom com o uuid especificado na rota
POST | api/v1/coupon | 201, 400 | Retorna um PostResponseDTO no formato JSON ou um ExceptionResponse, caso o código cadastrado já esteja registrado
PUT | api/v1/coupon/{uuid} | 200, 400, 404 | Retorna um PostResponseDTO no formato JSON em caso de sucesso ou um ExceptionResponse caso o cupom não seja encontrado ou o código seja diferente do original
DELETE | api/v1/coupon/{uuid} | 204 , 404 | Retorna um PostResponseDTO em caso de sucesso ou ExceptionResponse, caso não seja encontrado o registro