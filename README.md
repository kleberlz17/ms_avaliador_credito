# 🚀 Projeto de Padronização com Docker

Este projeto foi criado com o objetivo de definir um padrão de **dockerização** e configuração para microsserviços Java com Spring Boot. Além disso, o ambiente contempla **Keycloak** e **RabbitMQ**, porém, optei por não dockerizar esses serviços neste primeiro momento, focando nos containers das aplicações principais.

---

## 🐳 Imagens Docker Publicadas

As imagens dockerizadas dos serviços estão disponíveis no meu Docker Hub:

| Serviço                 | Link para Docker Hub                                                                                                                                                   |
|-------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Clientes**            | [kleberlz7/kleberlzms-clientes](https://hub.docker.com/repository/docker/kleberlz7/kleberlzms-clientes/general)                                                      |
| **Cartões**             | [kleberlz7/kleberlzms-cartoes](https://hub.docker.com/repository/docker/kleberlz7/kleberlzms-cartoes)                                                                 |
| **Avaliador de Crédito**| [kleberlz7/kleberlzms-avaliadorcredito](https://hub.docker.com/repository/docker/kleberlz7/kleberlzms-avaliadorcredito)                                              |
| **Gateway**             | [kleberlz7/kleberlzms-gateway](https://hub.docker.com/repository/docker/kleberlz7/kleberlzms-gateway)                                                                 |
| **Eureka Server**       | [kleberlz7/kleberlzms-eureka](https://hub.docker.com/repository/docker/kleberlz7/kleberlzms-eureka)                                                                   |

---

## ⚙️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **Spring Cloud**
- **Docker**
- **Docker Hub**
- **Eureka Service Discovery**
- **API Gateway**
- **RabbitMQ** *(não dockerizado neste projeto)*
- **Keycloak** *(não dockerizado neste projeto)*

---

## 📝 Observações

✔️ Este projeto serve como base para padronizar:

- Criação de imagens Docker para microsserviços Java.
- Estrutura mínima de configuração com arquivos `application.yml`.
- Configuração de profiles externos, como `local`, facilitando a execução dos containers.
- Boa prática de uso do Docker multistage build.

✔️ Não inclui imagens Docker para **RabbitMQ** e **Keycloak** no repositório, mas os serviços foram configurados e integrados localmente no ambiente.

---
- Avaliar dockerização de **Keycloak** e **RabbitMQ** em um ambiente separado.
- Criar arquivos `docker-compose.yml` para facilitar o up do ecossistema completo.
- Melhorias nas configurações de segurança e comunicação entre os serviços.

---
