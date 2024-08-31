#  ADS - <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/86/Senac_logo.svg/1200px-Senac_logo.svg.png" width="10%"> 2024 

<img src="https://uploaddeimagens.com.br/images/004/836/790/full/springboot-eclipse.PNG?1725027687" width="65%">
<img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge">

Repositório destinado à disciplina **'Padrões de Projeto, Frameworks e API'** da Faculdade Senac Maringá, no ano de 2024.
<br><br>

## <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/79/Spring_Boot.svg/640px-Spring_Boot.svg.png" width="25"> CRUD com Spring Boot: Pessoa e Funcionário

Este projeto demonstra a implementação de um **CRUD** (Create, Read, Update, Delete) para duas entidades:
- **Pessoa**
- **Funcionario**
  
Foi utilizado Spring Boot e um banco de dados H2.
<br><br>

## 🧱 Estrutura do Projeto
  
- **src/main/java/**
- **com.example.demo/**
- controller/ - Controladores REST
- model/ - Modelos das entidades Pessoa e Funcionario
- repository/ - Repositórios JPA
- service/ - Serviços e lógica de negócios
- DemoApplication.java - Classe principal
- **src/main/resources/**
- application.properties - Configurações do projeto
- **src/test/java/** - Testes automatizados

<img src="https://s11.gifyu.com/images/SoDX5.gif">

> [!IMPORTANT]
> **Antes de começar, você precisará ter instalado:**
> - Java JDK 11 ou superior
> - Maven (para gerenciamento de dependências e build)
> - Instalação ➔ Clone o repositório ➔ Execute o projeto

O servidor será iniciado em http://localhost:8080
<br><br>

## 🗃 Configuração do Banco de Dados
Este projeto utiliza o banco de dados H2 em memória. A configuração padrão está no arquivo **src/main/resources/application.properties**:

**Copiar o código:**
```
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

Você pode acessar o console do H2 em http://localhost:8080/h2-console com as credenciais:<br>

> **JDBC URL:** jdbc:h2:mem:testdb<br>
**Username:** sa<br>
**Password:** (deixe em branco)

<br>

## 🗂 Estrutura das Entidades 

#### 🔵 Pessoa
```JavaScript
  Long id;                   // identificador único
  String nome;               // nome completo
  String email;              // endereço de e-mail
  LocalDate dataNascimento;  // data de nascimento
```
<br>

#### 🟣 Funcionario
```JavaScript
  Long id;             // identificador único
  Pessoa pessoa;       // Referência à entidade Pessoa
  String cargo;        // Cargo no qual o funcionário trabalha
  BigDecimal salario;  // Salário do funcionário
```
<br>

## 🚧 Rotas da API
#### 🔵 Pessoa
- **GET /pessoas** - Lista todas as pessoas
- **GET /pessoas/{id}** - Retorna uma pessoa específica
- **POST /pessoas** - Cria uma nova pessoa
- **PUT /pessoas/{id}** - Atualiza uma pessoa existente
- **DELETE /pessoas/{id}** - Remove uma pessoa
<br>

#### 🟣 Funcionario
- **GET /funcionarios** - Lista todos os funcionários
- **GET /funcionarios/{id}** - Retorna um funcionário específico
- **POST /funcionarios** - Cria um novo funcionário
- **PUT /funcionarios/{id}** - Atualiza um funcionário existente
- **DELETE /funcionarios/{id}** - Remove um funcionário
<br><br>
#

<img src="https://uploaddeimagens.com.br/images/004/836/866/full/pizza-eliel.PNG?1725032705">

*Agradecimentos especiais à turma!*

