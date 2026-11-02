# Projeto Barbearia

Projeto da disciplina de Java Desktop, estruturado no padrao MVC.

## Estrutura

```
src/
  Main.java                      testes de instanciacao e conversao de datas
  Model/                         Pessoa (abstract), Cliente, Usuario, Servico, Agendamento
  Model/DAO/                     Banco (ArrayList), UsuarioDAO, ClienteDAO, ServicoDAO, AgendamentoDAO
  Controller/                    LoginController, MenuPrincipalController
  Controller/Helper/             IHelper, LoginHelper
  View/                          Login, MenuPrincipal, Agenda
```

## O que foi implementado nesta etapa

- Heranca: `Pessoa` como superclasse abstrata; `Cliente` e `Usuario` herdam dela com `extends` e `super`.
- Conversao de datas: as datas chegam como `String` nos construtores de `Pessoa` e `Agendamento` e sao
  convertidas para `Date` com `SimpleDateFormat` no formato `dd/MM/yyyy HH:mm`, com `ParseException`
  registrada no `Logger`.
- Controller e Helper: a tela `Login` envia a acao para o `LoginController`, que usa o `LoginHelper`
  para obter o `Usuario` digitado na tela.
- DAO: o `UsuarioDAO` consulta o `Banco` (ArrayList) e devolve o usuario autenticado ou `null`,
  sem que o Controller precise saber de onde vem o dado.
- Navegacao entre telas: Login para MenuPrincipal apos a validacao, e MenuPrincipal para Agenda.

## Como executar

Abrir o projeto no NetBeans e executar a classe `Main`. O console mostra os testes dos objetos e
em seguida a tela de login e aberta.

## Usuarios cadastrados no Banco

| Usuario   | Senha | Nivel de acesso |
| --------- | ----- | --------------- |
| admin     | 123   | 1               |
| barbeiro  | 123   | 2               |
| recepcao  | 123   | 3               |
