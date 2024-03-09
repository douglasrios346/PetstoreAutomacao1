# Testes Automatizados para a API Pet Store

Este repositório contém testes automatizados implementados em Java com RestAssured para a API PetStore. O objetivo desses testes é garantir a integridade da API, verificando a estrutura da resposta, os valores dos dados e a conformidade com as regras de negócio.

## API Utilizada

A API utilizada para estes testes é a [Pet Store API](https://petstore.swagger.io/). Esta API fornece funcionalidades para gerenciamento de uma loja de animais de estimação, permitindo operações como adicionar, atualizar e remover pets, além de realizar pedidos de pets.

## Casos de Teste Implementados

1. **Cadastrar Novo Pedido de Pet com Sucesso**
   - Método: POST `/store/order`
   - Objetivo: Verificar se é possível cadastrar um novo pedido de pet com sucesso.
   - Critérios de Verificação:
     - Estrutura da resposta correta.
     - Valores dos dados corretos.
     - Verificar se o pedido é cadastrado com sucesso.

2. **Pesquisar por um Pet Inexistente**
   - Método: GET `/pet/{petId}`
   - Objetivo: Verificar se a API retorna uma mensagem adequada ao pesquisar por um pet inexistente.
   - Critérios de Verificação:
     - Estrutura da resposta correta.
     - Verificar se a mensagem retornada é apropriada para um pet inexistente.
     
3. **Atualizar Dados de um Pet Existente**
   - Método: PUT `/pet`
   - Objetivo: Verificar se é possível atualizar os dados de um pet existente.
   - Critérios de Verificação:
     - Estrutura da resposta correta.
     - Valores dos dados corretos.
     - Verificar se os dados do pet são atualizados com sucesso.
   
4. **Pesquisar por Pets com Status “Pending”**
   - Método: GET `/pet/findByStatus`
   - Objetivo: Verificar se é possível pesquisar por pets com o status "pending".
   - Critérios de Verificação:
     - Estrutura da resposta correta.
     - Valores dos dados corretos.
     - Verificar se a pesquisa retorna os pets com status "pending".

## Como Executar os Testes

1. Certifique-se de ter o ambiente de desenvolvimento Java configurado.
2. Clone este repositório em sua máquina local.
3. Importe o projeto em seu ambiente de desenvolvimento (por exemplo, IntelliJ IDEA, Eclipse).
4. Certifique-se de ter as dependências do projeto instaladas (RestAssured, JUnit, etc.).
5. Execute os testes individualmente ou execute todos os testes em conjunto.

## Observações

- É necessário garantir que a API Pet Store esteja acessível durante a execução dos testes.
- Estes testes podem ser expandidos e modificados conforme necessário para atender aos requisitos específicos do projeto ou da API.

## Autor

Este projeto foi implementado por Douglas Barbosa como parte do teste automatizado da API Pet Store.
