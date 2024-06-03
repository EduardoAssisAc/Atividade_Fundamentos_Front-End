# fundamentos-front-end-turma5
Repositório da disciplina Fundamentos de Programação Front-End Turma 5.

## Atualizando o seu repositório local

O código produzido em sala de aula será compartilhado neste repositório e pode ser atulizado em seu repositório local com o comando:

```console
git pull
```
No entanto, se você fez alterações no seu repositório loca, o comando acima pode gerar conflitos. Para lidar com isso, você pode forçar uma atualização com o repositório remoto por meio dos comandos:

```console
git fetch origin
git reset --hard origin/main
```
O primeiro comando recebe as atualizações mais recentes do repositório remoto e o segundo descarta todas as alterações locais e atualiza com o histórico mais recente do repositório remoto (branch main)

## Sites de referência

- MDN Web Docs - Aprendendo desenvolvimento web: <https://developer.mozilla.org/pt-BR/docs/Learn>
- W3Schools Online Web Tutorials: <https://www.w3schools.com/>
- W3C Standards: <https://www.w3.org/standards/>

## Ferramentas

- **Visual Studio Code**
  - <https://code.visualstudio.com/Download>
- **Live Server (Extensão do VS Code)**
  - <https://marketplace.visualstudio.com/items?itemName=ritwickdey.LiveServer>
- **Git**
  - <https://git-scm.com/downloads>
- **Chrome Developer Tools (F12)**

## SGCM

A demonstração de uso das ferramentas e tecnologias abordadas na capacitação é baseada em um projeto de exemplo, o SGCM. A documentação básica deste projeto está disponível em: <https://github.com/webacademyufac/sgcmdocs> e aborda os seguintes tópicos: 

- [Principais funcionalidades](https://github.com/webacademyufac/sgcmdocs#principais-funcionalides)
- [Histórias de usuário](https://github.com/webacademyufac/sgcmdocs#histórias-de-usuário)
- [Diagrama de Classes](https://github.com/webacademyufac/sgcmdocs#diagrama-de-classes)
- [Diagrama Entidade Relacionamento](https://github.com/webacademyufac/sgcmdocs#diagrama-entidade-relacionamento)


## Atividades práticas

1. [GRUPO] Construir páginas para cadastro de usuários, convênios, unidades, especialidades, pacientes e atendimento de forma semelhante à página de cadastro de profissionais, e baseado na [documentação do SGCM](https://github.com/webacademyufac/sgcmdocs). (Entrega: 22/05/2024)
    - Página de Usuários (Clécio, Maria Clara, Mayara, Samuel)
    - Página de Convênios (Eduardo, Carlos Eduardo, Adrias, Ismael)
    - Página de Unidades (Samuel Alberto, Rafael, João Carlos, Luck)
    - Página de Especialidades (Luiz, Thalisson, Raurimar, Fabiana)
    - Página de Paciantes (Pablo, Daniela, Wennedy, Dimitris)
    - Página de Atendimentos (Allan Victor, Adrian Porfiro, Pedro Soares, Ezequiel Ico, Samuel Feijó)

    - Dados no formato JSON para serem usados nas páginas:

        - Usuários: <https://my-json-server.typicode.com/juniorlimeiras/json2/usuarios>
        - Usuários: <https://my-json-server.typicode.com/juniorlimeiras/json2/atendimentos>
        - Convênios: <https://my-json-server.typicode.com/juniorlimeiras/json/convenios>
        - Unidades: <https://my-json-server.typicode.com/juniorlimeiras/json/unidades>
        - Especialidades: <https://my-json-server.typicode.com/juniorlimeiras/json/especialidades>
        - Pacientes: <https://my-json-server.typicode.com/juniorlimeiras/json/pacientes>

2. [INDIVIDUAL] Alterar a forma como o usuário visualiza o botão Adicionar. (Entrega: 22/05/2024)
    - O botão Adicionar não deve ser visualizado após ser clicado, mas somente quando o usuário clicar nos botões Enviar ou Cancelar.

3. [INDIVIDUAL] Alterar o rodapé da tabela que mostra o total de profissionais para que seja atualizado conforme a quantidade de profissionais. (Entrega: 22/05/2024)
    - A atualização deve considerar todos os registros.

4. [INDIVIDUAL] Alterar o comportamento da coluna 'nome' da tabela de profissionais. (Entrega: 22/05/2024)
    - A coluna 'nome' deve ter o mesmo comportamento da coluna Ações.

  
> **IMPORTANTE:**
>
> - Todos os membros dos grupos devem participar das atividades, registrando esta participação por meio da identificação dos commits com seus respectivos usuários no GitHub.
> - As atividades devem ser desenvolvidas utilizando o respectivo repositório do grupo no GitHub, e organizadas por disciplina.
> - Quando se tratar de ativides inividuais, cada aluno deve criar uma subpasta com seu nome.