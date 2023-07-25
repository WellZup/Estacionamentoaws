# Estacionamentoaws

<p align="center">
<img src="https://img.shields.io/badge/Status-Programador_em_Desenvolvimento-orange"></p>


Exercícios Lambda AWS

![Logo](https://tse3.mm.bing.net/th/id/OIP.AXXi56Mr6kb3nQzwFdsCBgAAAA?pid=ImgDet&rs=1)


# Estacionamento Deep

Um cliente, dono do estacionamento deep está precisando de uma aplicação para gerenciar a entrada, permanência e saída dos carros.
Usando uma função lambda do serviço aws lambda.

Requisitos:
- O cliente poderá visualizar os carros que estão no estacionamento, qual a sua permanência, valor a ser pago e o dono do carro.
Cada permanência tem o seu valor.


## Indice do MENU


- |-------------------MENU----------------------|
- |----------1. Adicionar Carro-----------------|
- |----------2. Remover Carro-------------------|
- |----------3. Relatório: Carros --------------|
- |----------4. Entrada de Carro  --------------|
- |----------5. Editar permanência de Carro-----|
- |----------6. Listar Carros no Estacionamento-|
- |----------0. Sair----------------------------|
- |---------------------------------------------|



## Documentação da API

#### Função Menu

```http
  Adicionar Carro
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `addCarro` | `1` | **Adiciona carro**. Ao acionar o metodo, levara o usuario para o campo de preenchimento |



```http
  Remover Carro
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `ExcluirCarro`      | `2` | **Exclui carro**. Ao acionar o metodo, levara o usuario para o campo de Exclui pelo ID do carro |

```http
  Relatorio Carro
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `ListarCarro` | `3` | **Lista carro**. Ao acionar o metodo, levara o usuario a lista de carros cadastrados no BD |

```http
  Entrada de Carro
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `adicionarCarro` | `4` | **Adiciona carro ao estacionamento**. Ao acionar o metodo, levara o usuario para cadastrar carro para entrada do estacionamento |

```http
  Editar permanencia Carro
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `editarCarroEstacionado` | `5` | **Editar permanencia de carro**. Ao acionar o metodo, levara o usuario a colocar o ID dos carros cadastrados no BD para mudar permanencia dentro do estacionamento. |

```http
  Listrar Carro estacionamento
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `ListarCarroEstacionamento` | `6` | **Lista carro dentro do estacionamento**. Ao acionar o metodo, levara o usuario a lista de carros cadastrados no BD |

```http
  Sair do programa
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `Sair` | `0` | **Sair**. Ao acionar o metodo, levara o usuario a Sair do programa |


## Stack utilizada



**Back-end:** Intellij, AWS Lambda, Docker, Dbeaver


## 🛠 Habilidades
Java, Docker, Postgres, AWS

## Autor

- [Wellington](https://github.com/WellZup)

