# Hackathon Fiap - Fase 5

# Pós Tech - Arquitetura e Desenvolvimento Java - Fiap - 2024/25

- **Grupo 11:**
    - **[Pedro Ono](https://github.com/pedr0no) - RM 354950**
    - **[Elton Xavier Souza](https://github.com/eltonxs) - RM 354254**
    - **[Welder Ressutti](https://github.com/welderessutti) - RM 354557**

# Glicare - Sistema de Gerenciamento de Resultado de Exame, Diagnóstico e Agendamento

## Microsserviço de Envio de Email

**Desenvolvido por: [Welder Ressutti](https://github.com/welderessutti)**

O microsserviço de envio de e-mails no **Glicare** é responsável por processar eventos recebidos do **broker**,
originados pelo microsserviço de **agendamento de exames e consultas**.

Ele obtém os dados do paciente, compõe a mensagem e realiza o envio do e-mail de forma automatizada, garantindo a
comunicação eficiente entre o sistema e os usuários.

### Fluxo de Dados Mensageria

- **Consome** a mensagem do **broker** pelo canal de **agendamento de exame** ou **agendamento de consulta**, contendo
  o **ID do paciente** e a **data/hora do agendamento**.
- **Solicita** os dados do paciente ao microsserviço de gerenciamento de pacientes via requisição **GET**, para obter o
  endereço de **e-mail**.
- **Compõe** a mensagem com base no canal de origem do evento (exame ou consulta), definindo o **destinatário**, o
  **assunto** e o **corpo do e-mail**.
- **Envia** o e-mail.

### Tecnologias

- **Java 17** – Linguagem de programação utilizada no desenvolvimento do sistema.
- **Spring Web** – Base para a construção das APIs RESTful do sistema.
- **Spring Cloud** – Conjunto de ferramentas para facilitar a arquitetura baseada em microsserviços.
- **Spring Cloud Stream** – Implementação de mensageria para comunicação assíncrona entre microsserviços via RabbitMQ.
- **RabbitMQ** – Message broker utilizado para integração assíncrona entre os microsserviços.
- **OpenFeign** – Cliente HTTP declarativo para facilitar a comunicação síncrona entre os microsserviços.
- **Spring Mail** – Módulo para envio de e-mails automáticos de notificações.
- **Lombok** – Redução de boilerplate no código, simplificando a criação de classes Java.
- **API Patient** – Serviço utilizado para buscar informações de pacientes a partir do ID.
- **Docker** – Containerização dos microsserviços para facilitar o deploy e a escalabilidade.

### Arquitetura

A arquitetura hexagonal consiste na ideia de utilizar portas e adaptadores para realizar a integração entre a camada
externa e interna, isolando o core da aplicação para que alterações externas não interfiram nas regras de negócio e
casos de uso.

Este microsserviço foi desenvolvido seguindo os padrões de API RESTful, arquitetura hexagonal, e também respeitando os
princípios SOLID de isolamento de responsabilidades.

A arquitetura desta aplicação foi desenvolvida da seguinte forma:

![Aquitetura](images/architecture.jpg)

### Executando a aplicação (isoladamente)

#### Pré-requisitos

- **Git** (caso queira clonar o repositório, mas você pode apenas baixá-lo):
    - [Git](https://git-scm.com/downloads)
- **Docker Desktop** (para executar a aplicação através de containers):
    - [Docker](https://www.docker.com/products/docker-desktop/)

#### Passo 1: Clonar ou baixar o repositório

Para clonar o repositório, use o comando:

```bash
git clone https://github.com/welderessutti/api-diagnosis
```

Caso não queira clonar o repositório, você pode baixá-lo
em [GitHub](https://github.com/welderessutti/ms-email).

#### Passo 2: Executar a aplicação com Docker

No terminal, dentro do diretório raíz do projeto (local onde se encontra o arquivo **compose.yaml** da aplicação),
execute o comando abaixo para subir todos os containers da aplicação:

```bash
docker compose up -d
```

O Docker tentará baixar a imagem no repositório
do [Docker Hub](https://hub.docker.com/repository/docker/welderessutti/ms-email/general), caso ele não
encontre a imagem, ele realizará a **build** da aplicação **(.jar)**, criará a imagem e executará os containers
automaticamente.

Antes do container da aplicação subir, ele aguardará o container do broker **RabbitMQ** estar pronto
utilizando um **healthcheck**, quando pronto, o container da aplicação inicia, e estará pronto para receber os eventos
do broker.
