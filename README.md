

# 🚀 **ExperienceIA** 

Um projeto de análise inteligente e processamento em segundo plano usando **Spring Boot**, **RabbitMQ** e **Oracle DB**.

---

## 👥 Integrantes

- **Bruno** - RM98470
- **Gabriel Figueiredo** - RM99463
- **Gabriel Souza** - RM98633
- **Pedro** - RM550231
- **Rafael** - RM551577

---

## 👨‍👩‍👧‍👦 Nome do Grupo

**ExperienceIA**

---

## 📜 Descrição do Projeto

O projeto **ExperienceIA** é uma solução de análise e processamento de dados em segundo plano. Composto por dois componentes principais, ele utiliza **Spring Boot** para criar uma API e um serviço de worker. A comunicação entre esses componentes é feita via **RabbitMQ** para processamento assíncrono, e o banco de dados utilizado é o **Oracle**.

### 🧩 Componentes do Projeto

1. **ChallengeDashboardApi**: A API principal do sistema, que fornece endpoints para interação com usuários e gerencia o envio de mensagens para o worker.
2. **ChallengeDashboardWorker**: Serviço de worker que consome mensagens da fila, processa dados em segundo plano e envia respostas para a API.

---

## 📂 Estrutura do Projeto

```plaintext
Sprint4/
├── ChallengeDashboardApi/          # API principal do projeto
│   ├── Dockerfile                   # Dockerfile para containerização
│   ├── src/                         # Código-fonte da API
│   ├── pom.xml                      # Arquivo Maven com dependências
│   └── README.md                    # Instruções da API
│
└── ChallengeDashboardWorker/        # Worker para processamento em segundo plano
    ├── Dockerfile                   # Dockerfile para containerização
    ├── src/                         # Código-fonte do worker
    ├── pom.xml                      # Arquivo Maven com dependências
    └── README.md                    # Instruções do worker
```

---

## 🔧 Configurações Principais

### ChallengeDashboardApi

| Configuração            | Descrição |
|-------------------------|-----------|
| **Porta**               | `8080` |
| **Banco de Dados**      | Oracle (`oracle.fiap.com.br`) |
| **RabbitMQ**            | Envia mensagens para o worker usando o RabbitMQ |
| **Arquivo de Configuração** | `application.properties` |
| **Classes Principais**  | `AnalyzerApplication.java`, `RabbitMQConfig.java` |

### ChallengeDashboardWorker

| Configuração            | Descrição |
|-------------------------|-----------|
| **Porta**               | `9090` |
| **RabbitMQ**            | Consome mensagens da fila para processamento |
| **Arquivo de Configuração** | `application.properties` |
| **Classes Principais**  | `ChallengeDashboardWorkerApplication.java`, `RabbitMQConfig.java` |

> **⚙️ Nota:** Ambos os componentes devem estar configurados para utilizar o RabbitMQ com credenciais `guest/guest` e apontar para `localhost` na porta padrão `5672`.

---

## 🚀 Instruções de Testes e Acesso

### Pré-requisitos

Antes de começar, você precisará ter o seguinte instalado:

- **RabbitMQ**: Configurado para executar na porta padrão (`5672`) com usuário `guest` e senha `guest`.
- **Java e Maven**: Para compilar e rodar ambos os projetos.

### Passo a Passo

1. **Inicie o RabbitMQ** no seu sistema.
2. **Execute a API**:
   - Navegue até o diretório `ChallengeDashboardApi` e execute:
     ```bash
     mvn spring-boot:run
     ```
3. **Execute o Worker**:
   - Abra um novo terminal, navegue até o diretório `ChallengeDashboardWorker` e execute:
     ```bash
     mvn spring-boot:run
     ```

> **📌 Dica:** Verifique os logs para garantir que a comunicação via RabbitMQ está funcionando entre a API e o worker.

---

## 🎥 Link para o Vídeo de Demonstração

Assista à demonstração completa do projeto no YouTube: [Demonstração do ExperienceIA](https://www.youtube.com/watch?v=xTeUrG7ERU0)

---

### 🛠️ Tecnologias Utilizadas

- **Java** com **Spring Boot** - Framework principal para a API e o worker
- **RabbitMQ** - Para comunicação assíncrona entre API e Worker
- **Oracle Database** - Banco de dados relacional para armazenamento dos dados do sistema
- **Docker** - Facilita a containerização do projeto para desenvolvimento e produção

--- 

Esperamos que este guia seja útil para a execução e compreensão do projeto!
