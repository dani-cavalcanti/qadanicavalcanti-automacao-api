# Automação de API usando Java e Gradle
## Requisitos
* Java 8+
* Gradle 6.3
#

## Objetivo
Este documento descreve os passos necessários para executar o projeto de tests que envolve a interação com os seguintes endpoints da API ``https://dummyjson.com``:

- GET /test
- GET /users
- POST /auth/login
- GET /auth/products
- POST /products/add
- GET /products
- GET /products/{id}
#

# Cenário e Casos de Testes

Descrição dos cenários e Casos de Testes que estão contidos na pasta src/testes:

### *Cenário: Buscar o status da aplicação*
| Caso de Teste | Descrição                                               |
|---------------|---------------------------------------------------------|
| T1            | Verificar se a chamada à API retorna o status correto    |
| T2            | Verificar o comportamento quando a chamada à API falha   |

### *Cenário: Buscar usuário para autenticação*
| Caso de Teste | Descrição                                               |
|---------------|---------------------------------------------------------|
| T3            | Verificar se é possível buscar um usuário válido         |
| T4            | Verificar o comportamento quando um usuário inválido é   |
|               | buscado para autenticação                               |

### Cenário: *Criação de token para autenticação*
| Caso de Teste | Descrição                                               |
|---------------|---------------------------------------------------------|
| T5            | Verificar se a criação do token é bem-sucedida           |
| T6            | Verificar o comportamento quando a criação do token falha|

### *Cenário: Buscar produtos com autenticação*
| Caso de Teste | Descrição                                            |
|---------------|------------------------------------------------------|
| T7            | Verificar se a busca de produtos autenticada retorna |
|               | os produtos corretos                                 |
| T8            | Verificar o comportamento quando a busca de produtos |
|               | autenticada falha (401)                              |
| T9            | Verificar o comportamento quando a busca de produtos |
|               | autenticada falha (403)                              |

### *Cenário: Criação de produto*
| Caso de Teste | Descrição                                                |
|---------------|----------------------------------------------------------|
| T10           | Verificar se a criação de um novo produto é bem-sucedida |
| T11           | Verificar se a criação de um novo produto é bem-sucedida |
|               | com dados inválidos                                      |

### *Cenário: Buscar todos os produtos*
| Caso de Teste | Descrição                                               |
|---------------|---------------------------------------------------------|
| T12           | Verificar se a busca de todos os produtos retorna a lista|
|               | completa de produtos                                    |
| T13           | Verificar o comportamento quando a busca de todos os    |
|               | produtos falha                                          |

### *Cenário: Buscar apenas um produto por ID*
| Caso de Teste | Descrição                                               |
|---------------|---------------------------------------------------------|
| T14           | Verificar se a busca de um produto por ID retorna o     |
|               | produto correto                                         |
| T15           | Verificar o comportamento quando a busca de um produto  |
|               | por ID retorna um produto inexistente                   |


#
## Clonando o projeto

Para clonar o projeto, siga as instruções abaixo:

1. Abra o terminal e navegue até o diretório onde deseja armazenar o projeto.
2. Execute o seguinte comando para clonar o repositório:

   ```shell
   git clone https://github.com/qadani/qadanicavalcanti-automacao-api
.git
   ```

3. Aguarde até que o processo de clonagem seja concluído. Agora você terá uma cópia local do projeto.

## Executando o projeto via terminal

Após clonar o projeto, siga as etapas abaixo para executá-lo via terminal:

1. Abra o terminal e navegue até o diretório raiz do projeto clonado.

2. Execute o seguinte comando para criar o Gradle wrapper para poder rodar o gradlew:

   ```shell
   gradle wrapper
   ```

3. Agora você está pronto para executar todos os testes do pacote 'src/test'. Utilize o seguinte comando:

   ```shell
   ./gradlew test
   ```

   O Gradle irá compilar o projeto e executar os testes automatizados. Aguarde até que todos os testes sejam concluídos.

   > Certifique-se de que sua máquina esteja conectada à internet, pois os testes envolvem a interação com a API dummyjson.com.

4. Após a execução dos testes, você verá o resultado no terminal. Os relatórios de tests também serão gerados no diretório do projeto.

## Informações adicionais

O projeto foi criado utilizando a ferramenta Gradle 6.3, Java 8+ e Rest-Assured para facilitar a execução de testes automatizados nos endpoints mencionados da API dummyjson.com. O Rest-Assured é uma biblioteca Java popular para testar APIs RESTful.

Certifique-se de ter o Gradle e as dependências necessárias instaladas antes de executar o projeto.

Se você tiver alguma dúvida ou encontrar algum problema durante a execução do projeto, sinta-se à vontade para entrar em contato.
