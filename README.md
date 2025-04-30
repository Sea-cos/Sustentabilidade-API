
# 🌱 Sustentabilidade API

Uma API REST desenvolvida com **Java Spring Boot** para gerenciar ações sustentáveis. Este projeto tem como objetivo registrar, consultar e manipular dados relacionados a iniciativas sustentáveis, como reciclagem, reflorestamento, economia de energia, entre outras.

> 🔒 A API possui autenticação e tratamento de exceções personalizados. Pode ser consumida por qualquer front-end ou ferramenta de testes como o Postman.

---

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Security
- ModelMapper
- Maven

---

## 📁 Estrutura do Projeto

- `controller/` – Controladores REST que expõem os endpoints.
- `service/` – Lógica de negócio.
- `repository/` – Interfaces que acessam o banco de dados.
- `model/entity/` – Entidades principais do sistema.
- `model/dtos/` – Objetos de transferência de dados.
- `model/enums/` – Enumerações usadas nas entidades.
- `model/exceptions/` – Exceções personalizadas e tratadores globais.
- `configuration/` – Configurações como segurança e mapeamento de objetos.

---

## 🔐 Autenticação

A API utiliza autenticação via Spring Security.

---

## 🛠️ Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/Sea-cos/Sustentabilidade-API.git
   ```

2. Acesse a pasta do projeto:
   ```bash
   cd Sustentabilidade-API
   ```

3. Compile e execute o projeto com o Maven:
   ```bash
   mvn spring-boot:run
   ```

4. A API estará disponível em:
   ```
   http://localhost:8080
   ```

---

## 📬 Testando a API

Você pode testar os endpoints usando o [Postman](https://www.postman.com/) ou qualquer ferramenta de requisições HTTP.

Alguns exemplos de endpoints:

- `POST /acoes` – Cadastra uma nova ação sustentável.
- `GET /acoes` – Lista ações cadastradas.
- `GET /acoes/{id}` – Busca ação por ID.
- `PUT /acoes/{id}` – Atualiza uma ação.
- `DELETE /acoes/{id}` – Remove uma ação.

> Detalhes específicos podem ser vistos no controller `AcaoSustentavelController.java`.

---

## 📄 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

---

## 🤝 Contribuições

Sinta-se à vontade para abrir issues ou enviar pull requests para sugerir melhorias!
