# DSW1-Spring
Atividade avaliativa da disciplina Desenvolvimento de Software para Web 01 cujo objetivo é desenvolver um sistema para locação de bicicletas utilizando Spring e Java
# Sistema para Locação de Bicicletas
Este projeto foi desenvolvido como uma parte avaliativa da disciplina Desenvolvimento de Software para Web 1, ministrada pelo professor Alan Demetrius. O principal objetivo desse trabalho
é criar uma aplicação web para um sistema de locação de bicicletas, a partir de um conjunto de requisitos.

## Requisitos da Aplicação
Aqui estão listados os requisitos que foram utilizados para desenvolver a aplicação: <br>

O sistema deve possuir um cadastro de clientes, com os seguintes dados: e-mail, senha, CPF, nome, telefone, sexo e
data de nascimento. <br>
O sistema deve possuir um cadastro de locadoras, com os seguintes dados: e-mail, senha, CNPJ, nome e cidade. <br>
O sistema deve possuir um cadastro de locações, com os seguintes dados: cliente, locadora e dia/horário da locação. <br>
Assume-se que a duração da locação é de 1 hora e sempre inicia-se em “hora cheia” (13h 00min etc)
O sistema deve atender aos seguintes requisitos: <br>
R1: CRUD1
 de clientes (requer login de administrador) <br>
R2: CRUD de locadoras (requer login de administrador) <br>
R3: Listagem de todos as locadoras em uma única página (não requer login) <br>
R4: Listagem de todos as locadoras por cidade (não requer login). Preferencialmente a cidade deveria ser
escolhida através de uma lista. <br>
R5: Locação de uma bicicleta em uma locadora (requer login do cliente via e-mail + senha). Depois de fazer
login, o cliente pode cadastrar uma locação. Para isso, deve escolher uma locadora (escolhendo a partir de uma
lista), uma data, e deve ser gravado a locação na base de dados. <br>
R6: Listagem de todas as locações de um cliente (requer login do cliente via e-mail + senha). Depois de fazer
login, o cliente pode visualizar todas as suas locações gravadas. <br>
R7: O sistema não deve permitir o cadastro de locações de um mesmo cliente ou de um mesma locadora em um
mesmo dia/horário. <br>
R8: Listagem de todas as locações de uma locadora (requer login da locadora via e-mail + senha). Depois de
fazer login, a locadora pode visualizar todas as suas locações gravadas. <br>
R9: O sistema deve ser internacionalizado em pelo menos dois idiomas: português + outro de sua escolha. <br>
R10: O sistema deve validar (tamanho, formato, etc) todas as informações (campos nos formulários) cadastradas
e/ou editadas. <br>
O sistema deve tratar todos os erros possíveis (cadastros duplicados, problemas técnicos, etc) mostrando uma página
de erros amigável ao usuário e registrando o erro no console. <br>
**Arquitetura: ** Modelo-Visão-Controlador <br>
Tecnologias <br>
Spring MVC, Spring Data JPA, Spring Security & Thymeleaf (Lado Servidor) <br>
Javascript & CSS (Lado Cliente) <br>
Ambiente de Desenvolvimento <br>
A compilaçao e o deployment deve ser obrigatoriamente ser realizado via maven. <br>
Os arquivos fonte do sistema devem estar hospedados obrigatoriamente em um repositório (preferencialmente
github). <br>
1. CRUD: Create, Read, Update & Delete.↩

## Tecnologias utilizadas
Como especificado nos requisitos, o projeto foi criado utilizando as seguintes tecnologias (Lado Servidor): <br>
• Spring MVC   <br>
• Spring Data JPA <br>
• Spring Security <br>
• Thymeleaf <br>
E, no ambiente de desenvolvimento: <br>
• Maven <br>
• Apache Tomcat  <br>
A arquitetura de separação de arquivos utilizou o modelo MVC (Model-View-Controller), o qual é em Controladores, DAOs e Domain, no contexto da aplicação.

## Página inicial
Está página é a login.html, em que é cumprido os requisitos R3 e R4, além de conter um campo de login para o usuário se autenticar como Cliente, Locadora ou Admin.
Portanto, para atender os requisitos, a página apresenta um link que mostra uma página com todas as locadoras e disponibiliza um filtro para exibir apenas as locadoras de uma determinada cidade, a qual é escolhida pelo usuário.
* Página inicial:
![image](https://github.com/thaleswinther/DSW1-Spring/assets/123703093/439044e6-6f94-4055-a73e-bdfbf22348a9) <br>

* Listagem de Locadoras:
![image](https://github.com/thaleswinther/DSW1-Spring/assets/123703093/67fbeb56-9010-419c-a730-a5d512bef34a)

## Página do Administrador
Esta página é a pagina referente ao administrador, na qual é possível realizar o CRUD (Create, Read, Update & Delete) de Clientes e Locadoras. Dessa forma, está página atende os requisitos R1 e R2.
É importante mencionar, também, que apenas um usuário cadastrado como ADMIN tem acesso a essa página, ou seja, as permissões estão configuradas corretamente e não é possível outros usuáriso acessarem esta página (OBS: caso alguém tente acessar essa página pela URL, por exemplo, sem possuir tal permissão, aparecerá um mensagem de erro, informando que tal acesso não é permitido).
* Página do administrador logado
 ![image](https://github.com/thaleswinther/DSW1-Spring/assets/123703093/f8e72fb8-c20a-4459-b25e-90843e2394c7)
* CRUD de Clientes
![image](https://github.com/thaleswinther/DSW1-Spring/assets/123703093/d57590a4-3525-4cbf-a0d4-c300c41e9575)
![image](https://github.com/thaleswinther/DSW1-Spring/assets/123703093/bb57c984-c54e-4872-b640-8a986c2270a1)
* CRUD de Locadoras:
![image](https://github.com/thaleswinther/DSW1-Spring/assets/123703093/f6e90a4a-64f7-4edf-8e85-6428725be3d7)

## Página do Usuário
### Cliente
Esta é a página do usuário cliente, a qual atende os requisitos R5, R6 e R7. Nesta página é possível realizar o cadastro de uma locação, selecionando a locadora a partir de uma lista, a data e a a hora da locação (a hora é selecionada a partir de uma lista, para atender a especificação de que as locações tem que ser realizadas em horas inteiras). Além disso, também é possível visualizar todas as locações do cliente logado. Por fim, ao realizar a locação, o cliente e a locadora são informados via email.
É importante mencionar, também, que impossibilidades e incoerências são tratadas: um cliente cadastrar mais de uma locação no mesmo dia e horário, uma locadora possuir mais de uma locação no mesmo dia e horário e o cliente tentar cadastrar uma locação em uma data anterior a data atual. Qualquer um desses casos retornará uma mensgem de erro amigável ao usuário.
* Página inicial do Cliente
  ![image](https://github.com/thaleswinther/DSW1-Spring/assets/123703093/de4060da-0058-48ef-9afd-edaa9c389898)

* Página para cadastar uma locação

![image](https://github.com/thaleswinther/DSW1-Spring/assets/123703093/9385d461-91d6-4663-8c0e-b9bf69d5eae5)


* Tratando a especificação de locações só poderem ser feitas em horas inteiras
![image](https://github.com/thaleswinther/DSW1-Spring/assets/123703093/5f2ccdc7-7b3a-41cd-a71c-160291f3c177)

  
### Locadora
Está é a página do usuário locadora, a qual atende o requisito R8. Neste página é possível visualizar todas as locações da locadora logada.

![image](https://github.com/thaleswinther/DSW1-Spring/assets/123703093/f3a319dc-76c8-4f49-bbf7-ef9c47b4f943)

## Internacionalização do sistema
Por fim, para atender o requisito R9, o sistema também está disponível em EN-US, dependendo da configuração do navegador do usuário.
![image](https://github.com/thaleswinther/DSW1-Spring/assets/123703093/b2833b26-ca75-45e4-b6e9-f01a8ce11b45)
![image](https://github.com/thaleswinther/DSW1-Spring/assets/123703093/dc81f64e-983d-49b9-b01b-6e1439be38e9)

## Tratamento de erros
O sistema também trata os possíveis erros do sistema de forma amigável ao usuário, mostrando-o uma mensagem explicando o que erro ocorrido.
* Alguns exemplos:
   * Campos em brancos ou que não atendem ao número de caracteres esperados:
    
     ![image](https://github.com/thaleswinther/DSW1-Spring/assets/123703093/f01b8f07-215c-49fd-a946-ba61387bb3d6)

  * Cadastrar um usuário com um CPF já em uso:
    
     ![image](https://github.com/thaleswinther/DSW1-Spring/assets/123703093/d277a051-ce10-4aa5-9ac8-d9c5d6e4a35a)

  * Cadastrar uma locação em um data anterior a data atual:
    
    ![image](https://github.com/thaleswinther/DSW1-Spring/assets/123703093/87251034-44d2-4550-90b6-f25854144482)

  * Acessar uma página pela URL, sem possuir a autorização necessária:
    
    ![image](https://github.com/thaleswinther/DSW1-Spring/assets/123703093/6bacf2af-4fbc-45c5-b8cc-226aaa8190c1)



# Colaboradores
* Thales Winther de Castro Moreira, aluno BCC UFSCar, github: https://github.com/thaleswinther
* Matheus Goulart Ranzani, aluno BCC UFSCar, github: https://github.com/matheusranzani 
* Arisa Abiko Sakaguti, aluna BCC UFSCar, github: https://github.com/arisaabiko
* Gabriel Ripper de Mendonça Furtado, aluno BCC UFSCar, github: https://github.com/gabripper












