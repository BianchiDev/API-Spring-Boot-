# Projeto Back End

> Este é um projeto que tem a finalidade de servir como  base para criação de APIs com Spring boot e o banco de dados PostegreSQL além é claro de um deploy.<br>
Usarei as ferramentas Vscode, DBeaver na criação e gerenciamento do projeto.


<hr><a href="https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#getting-started"><img height ="35" src ="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"></a>
<a href="https://dbeaver.io/"><img height ="35"  src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white"></a>
<a href="https://www.postgresql.org/"><img height= "35" src= "https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white"></a>

## 💻 Pré-requisitos

Antes de começar, verifique se você atende os requisitos seguintes:

- Possuir JDK instalado na sua maquina
- Possuir uma IDE da sua preferência, Vscode, Intellij, LTS ou qualquer outra de sua prefeência
- O java do projeto esta na versão 17

- ter instaldo na sua maquina o banco de dados Postgresql
## 🚀 Instalando  do POSTEGRESQL

A instalação será via terminal bach, pois estou usando linux ubuntu, caso esteja usando windows sugiro a instalação do termial ubuntu WSL ou procurar um tutorial na documentação. 

- Abra o terminal.

- Atualize o índice de pacotes do sistema: 
```
sudo apt update
```
- Instale o PostgreSQL:
```
sudo apt install postgresql postgresql-contrib
```
- O PostgreSQL será instalado em seu sistema. O serviço será iniciado automaticamente após a instalação.

## 🚀 Configurar o PostgreSQL
- O PostgreSQL cria automaticamente um usuário chamado "postgres". Você pode mudar para esse usuário digitando:
```
sudo -i -u postgres
```
- Acesse o console do PostgreSQL digitando:
```
psql
```
- Agora você está no console do PostgreSQL e pode executar comandos SQL. Para sair do console, digite:
```
\q
```

## 🚀 Criar um Banco de Dados e um Usuário

- Para criar um usuário faça o seguinte:<br><br>
execute o seguinte comando <br>(substitua "seunomedeusuario" e "suasenha" pelos valores desejados):
```
CREATE USER seunomedeusuario WITH PASSWORD 'suasenha';
```

- Em seguida, crie um novo banco de dados. Substitua "nomedobanco" pelo nome que você deseja dar ao banco de dados:<br>
```
GRANT ALL PRIVILEGES ON DATABASE nomedobanco TO seunomedeusuario;
```
- Para sair do console do PostgreSQL, digite:
```
\q
```


