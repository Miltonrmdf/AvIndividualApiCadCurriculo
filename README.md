Avaliação: Desenvolvimento de API REST para um sistema de currículos de uma empresa de TI
Jacqueline Oliveira
•
18:23 (editado: 21:50)
30 pontos
Data de entrega: 23:20
Objetivo: Desenvolver uma API RESTful utilizando Spring e Java para gerenciar
informações de um sistema de cadastro de currículos. A API deve permitir a
manipulação de dados relacionados aos candidatos a vagas em processos seletivos.

Requisitos:

 1 - Modelagem de Dados: 

● Criar modelos para representar candidatos (entity), vagas (enum), escolaridade (enum) e status do currículo (enum),
considerando os atributos relevantes para cada entidade, que são:

Candidato:
nome
dataNascimento
cpf
escolaridade (tipos: MEDIO, FUNDAMENTAL, GRADUACAO, POS_GRADUACAO, ESPECIALIZACAO)
vagaDesejada (tipos: ANALISTA, QA, DEV, TECH_LEAD, SUPORTE, UX)
statusCurriculo (tpos: EM_ANALISE, REPROVADO, APROVADO)

● Utilizar anotações do JPA para mapear as entidades para tabelas no
banco de dados.   

2 -  DTOs (Data Transfer Objects): 

● Criar DTOs para representar os objetos que serão enviados e recebidos
pela API. Os DTOs devem ser utilizados para evitar vazamento de
informações e garantir uma separação clara entre a camada de
apresentação e a camada de negócios. 

3 - Repositories: 

● Implementar interfaces Repository para cada entidade, fornecendo
métodos para realizar operações básicas de CRUD (Create, Read,
Update, Delete). 
● ** PLUS **  Utilizar derived queries para realizar consultas no banco de dados por vaga desejada ou  escolaridade do candidato.

 4 - Services: 

● Criar classes de serviço para implementar a lógica de negócios
relacionada ao cadastro de currículos;
● Implementar métodos nos serviços para realizar operações como
adicionar um novo currículo,  atualizar
informações do status, etc. 

5 - Controllers: 

● Implementar controllers para receber requisições HTTP e chamar os
métodos apropriados nos serviços.
● Utilizar anotações do Spring como @RestController,
@RequestMapping, @GetMapping, @PostMapping, etc.  
  
ENTREGA:

- O projeto deve ser entregue em um repositório Git (preferencialmente) ou numa pasta do drive, que esteja com permissão de visualização (qualquer pessoa com o link).

Boa avaliação!
