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

## 🔗 Repositórios GitHub

Os repositórios dos microsserviços utilizados neste projeto estão disponíveis no meu GitHub:

| Serviço                 | Link para o Repositório                                                                                                                        |
|-------------------------|------------------------------------------------------------------------------------------------------------------------------------------------|
| **Clientes**            | [ms_clientes](https://github.com/kleberlz17/ms_clientes)                                                                                      |
| **Cartões**             | [ms_cartoes](https://github.com/kleberlz17/ms_cartoes)                                                                                        |
| **Avaliador de Crédito**| [ms_avaliador_credito](https://github.com/kleberlz17/ms_avaliador_credito)                                                                    |
| **Gateway**             | [ms_cloud_gateway](https://github.com/kleberlz17/ms_cloud_gateway)                                                                            |
| **Eureka Server**       | [eureka_server](https://github.com/kleberlz17/eureka_server)                                                                                  |

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
