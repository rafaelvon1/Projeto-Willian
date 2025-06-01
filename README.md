# 🔐 Projeto de Segurança da Informação

Sistema desenvolvido como parte do curso de Segurança da Informação na Universidade de Mogi das Cruzes, sob orientação dos professores Willian e Pedro. O projeto aplica boas práticas de segurança no desenvolvimento de um sistema de autenticação de usuários.

## 📋 Descrição

Este projeto tem como objetivo implementar um sistema de **login** e **cadastro de usuários**, com foco em segurança de dados. Foram incorporados recursos como:
- Autenticação em dois fatores (2FA)
- Criptografia de senhas com Bcrypt
- Verificação de e-mail
- Validação de entrada de dados
- Proteção contra SQL Injection

A aplicação segue o modelo **MVC**, com gerenciamento de dependências via **Maven**, e foi desenvolvida utilizando a linguagem **Java** com interfaces gráficas criadas em `JFrame`.

## 🚀 Tecnologias Utilizadas

- **Java**
- **JFrame** (interface gráfica)
- **MySQL** (banco de dados)
- **Apache Commons Email** (envio de e-mail e 2FA)
- **BCrypt** (criptografia de senha)
- **Visual Studio Code**
- **Maven** (gerenciador de dependências)
- **Modelo de desenvolvimento em cascata (Waterfall)**

## 🧪 Funcionalidades

- Cadastro com validação de e-mail
- Verificação de código enviado por e-mail
- Criptografia de senha com Bcrypt
- Login com envio de código de verificação
- Autenticação em dois fatores (2FA)
- Recuperação de senha ("Esqueceu a senha")
- Proteção contra SQL Injection (uso de `PreparedStatement`)
- Uso de variáveis de ambiente para dados sensíveis

## 📸 Telas do Sistema

As telas foram desenvolvidas em Java usando `JFrame`, proporcionando uma interface desktop simples e funcional. Algumas telas implementadas:
- Tela de Cadastro
- Tela de Login
- Validação de Código
- Recuperação de Senha

*(Imagens podem ser adicionadas aqui futuramente)*

## ⚠️ Análise de Risco

| Risco                             | Nível   |
|----------------------------------|---------|
| Ataque por força bruta           | Alto    |
| SQL Injection                    | Baixo   |
| Perda de dados                   | Alto    |
| Dependência de um único dev      | Médio   |

## 🔧 Instalação e Execução

1. Clone o repositório:
   ```bash
   git clone https://github.com/rafaelvon1/Projeto-Willian

