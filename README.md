# ```UnderDevs IDE in Java for Python with AI.```
### Team UnderDevs   - FATEC - São José dos Campos - ADS 2° Semestre.
 _To infinity and beyond._ 🚀


## Índice
* [Objetivo do Projeto](#objetivo)
* [Demonstração do Projeto](#demonstração-do-projeto)
* [Sprints](#sprints)
* [Cronograma](#cronograma)
* [Backlog do Produto](#product-backlog)
* [Tecnologias Utilizadas](#tecnologias-empregadas)
* [Dependências](#dependências)
* [Integrantes](#integrantes-da-equipe)


## Objetivo

Desenvolver um ambiente integrado de desenvolvimento (IDE) utilizando Java para auxiliar o desenvolvedor a otimizar tempo e custo de desenvolvimento.  

## Demonstração do Projeto

>Vídeo demonstrando as principais funcionalidades da IDE.  
[![Vídeo de demonstração do funcionamento do projeto.](https://img.youtube.com/vi/aAc457nVHqI/0.jpg)](https://www.youtube.com/watch?v=aAc457nVHqI)

#### MVP
>Definição do MVP para cada sprint
![Image](https://github.com/davihelisson/FATEC-API2ADS-UnderDevs/blob/main/Docs/IDE%20UNDERDEVS.png)

#### Sprints

-   [x] Sprint 1 - Estrutura Básica da IDE e Integração com o Ollama para geração de Testes Unitários.
-   [x] Sprint 2 - Fazer recomendações personalizadas de código (melhorias do código: eficiência, segurança, legibilidade).
-   [ ] Sprint 3 - Gerar documentação do código (docstrings, explicações do que o código faz).  

## Cronograma

Sprint | Previsão | Status
|---|---|---|
| Kick Off | 24/02 - 28/02 | Concluído |
| Sprint 1 | 10/03 - 30/03 | Concluído |
| Sprint 2 | 07/04 - 27/04 | Concluído |
| Sprint 3 | 05/05 - 25/05 | Concluído |
| Feira de Soluções | 17/06 | Não iniciada |  

## Product Backlog

#### IDE Java para Python com Assistência IA (Ollama/Qwen)

**Tecnologias Base:** Java (Swing), API Ollama (Modelo: Qwen/Code Llama/Similar), Python (para execução/teste), Banco de Dados MySql (para Sprint 3 - para armazenamento de prompts, histórico de interações da IA e outros dados relevantes)
**Estimativas:** Escala Fibonacci-like (3, 5, 8, 13)

| id   | prioridade | User Histories / Tarefas Técnicas                                                                                                                 | points | sprint |
| :--- | :--------- | :------------------------------------------------------------------------------------------------------------------------------------------------ | :----- | :----- |
| US01 | Alta       | Como desenvolvedor, quero uma interface gráfica Java básica com uma área de texto para digitar e editar código Python.                             | 5      | 1      |
| US02 | Alta       | Como desenvolvedor, quero poder Abrir arquivos `.py` existentes na IDE para visualizá-los e editá-los.                                           | 5      | 1      |
| US03 | Alta       | Como desenvolvedor, quero poder Salvar o código Python que estou editando em um arquivo.                                                           | 3      | 1      |
| US04 | Alta       | Como desenvolvedor, quero poder selecionar um trecho de código Python e solicitar à IA (Ollama) a geração de testes unitários básicos para ele.    | 13     | 1      |
| US05 | Alta       | Como desenvolvedor, quero um botão/comando para acionar a geração de testes pela IA e uma área para visualizar os testes gerados.                   | 5      | 1      |
| US06 | Alta       | Como usuário do sistema, quero que a IA (Ollama) analise meu código Python e sugira melhorias (qualidade, estilo, possíveis erros).                | 8      | 2      |
| US07 | Alta       | Como desenvolvedor, quero um botão/comando para acionar a análise de melhorias pela IA e uma área dedicada para visualizar as sugestões.            | 5      | 2      |
| US08 | Alta       | Como desenvolvedor, quero um botão/comando para executar o script Python atualmente aberto na IDE.                                                  | 5      | 2      |
| US09 | Alta       | Como desenvolvedor, quero ver a saída (stdout/stderr) da execução do script Python em um painel ou console dentro da IDE.                         | 8      | 2      |
| US10 | Média/Alta  | Como desenvolvedor, quero que a IA (Ollama) analise meu código em Python e documente o código automaticamente (gerando docstrings/comentários).  | 8      | 3      |
| US11 | Média/Baixa  | Como desenvolvedor, quero que a IA explique em linguagem natural o que um trecho selecionado de código em Python faz.                                | 5      | 3      |
| US12 | Alta       | Como desenvolvedor (Tarefa Técnica), quero que os Prompts enviados à IA e exemplos de código associados sejam armazenados em banco de dados simples. | 13     | 3      |  
| US13 | Alta       | Como desenvolvedor quero que os códigos gerados sejam armazenados e comitados no GitHub, de maneira fácil e prática                                  | 8      | 3       | 

## Sprint Backlog  

##### Sprint 1  
| id   | Tasks                                                                                                     | points |
| :--- | :-------------------------------------------------------------------------------------------------------- | :----- |
| US04 | Implementar funcionalidade de gerar testes                                                                | 8      |
| US01 | Criação do Projeto Principal em Java                                                                      | 5      |
| US05 | Integrar a Classe OllamaInterface com tela principal e capturar retorno para a janela de output de testes | 5      |
| US02 | Implementar abertura de código fonte (ler arquivo ".py")                                                  | 3      |
| US05 | Criar classe OllamaInterface para comunicação com Ollama                                                  | 2      |
| US04 | Criar prompts para refinar a saída do LLM                                                                 | 3      |
| US05 | Criação da Tela Secundária para saída dos testes                                                          | 3      |


##### Sprint 2 
| id   | Tasks                                                                                                     | points |
| :--- | :-------------------------------------------------------------------------------------------------------- | :----- |
| US01 | Melhoria de documentação                                                                                  | 2      |
| US07 | Melhorias Gerais (Abertura de arquivo, Salvamento da saída, alteração do nome do arquivo)                 | 5      |
| US06 | Desenvolver Prompts (Melhorar a eficiência, segurança e legibilidade do Código)                           | 5      |
| US01 | Prototipação no FIGMA (protótipo funcional)                                                               | 2      |
| US08 | Execução do Código (Permitir que o código seja executado na própira IDE)                                  | 3      |
| US09 | Cirar método para envio do código para o Ollama                                                           | 3      |


##### Sprint 3  
| id   | Tasks                                                                                                     | points |  
| :--- | :-------------------------------------------------------------------------------------------------------- | :----- |
| US11 | Criar explicação do que o código faz                                                                      | 5     |
| US10 | Criar DocStrings (Documentação do Código)                                                                 | 8     |
| US12 | Armazenar códigos gerados pelo Ollama em novos prompts para melhoria                                      | 13     |


## Tecnologias Empregadas

 ![Java](https://img.shields.io/badge/Java-fdfefe?style=for-the-badge&logo=openjdk&logoColor=000000)
 ![Ollama](https://img.shields.io/badge/Ollama-fdfefe?style=for-the-badge&logo=Ollama&logoColor=000000)
 ![MySQL](https://img.shields.io/badge/MySQL-fdfefe?style=for-the-badge&logo=mysql&logoColor=000000)
 ![Git](https://img.shields.io/badge/Git-fdfefe?style=for-the-badge&logo=git&logoColor=000000)
 ![Github](https://img.shields.io/badge/Github-fdfefe?style=for-the-badge&logo=github&logoColor=000000)
 ![Jira Software](https://img.shields.io/badge/Jira-fdfefe?style=for-the-badge&logo=Jira&logoColor=0064c8)
 ![Discord](https://img.shields.io/badge/Discord-fdfefe?style=for-the-badge&logo=discord)
 ![Markdown](https://img.shields.io/badge/Markdown-fdfefe?style=for-the-badge&logo=markdown&logoColor=2e4053)
 [![Figma](https://img.shields.io/badge/Figma-fdfefe?style=for-the-badge&logo=figma&logoColor=2e4053)](https://www.canva.com/design/DAGlWk-qv1A/e3ca2b7b6-43cr3DDphQ9g/view?utm_content=DAGlWk-qv1A&utm_campaign=designshare&utm_medium=link2&utm_source=uniquelinks&utlId=he9434095c3)


## Dependências

- É necessário ter instalado o Ollama para executar o modelo de linguagem [Baixar Ollama](https://ollama.com/)
- Além disso, é necessário ter o Java Development Kit (JDK) instalado e configurado para executar a aplicação Java.
- Esse projeto foi desenvolvido para funcionar no LLM qwen2.5-coder [qwen2.5-coder](https://ollama.com/library/qwen2.5-coder)
- Para armazenar os códigos com prompts é preciso ter o MySQL instalado e configurado localmente.

## Integrantes da Equipe

|      Nome      |    Função       |                            Github                             |                           Linkedin                           | Atribuição       |
| :--------------: | :-----------: | :----------------------------------------------------------: | :----------------------------------------------------------: | :----------------: |
| Wesley Xavier | Scrum Master | <a href="https://github.com/xvierdev"><img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white"></a> | <a href="https://www.linkedin.com/in/xvierbr/"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white"></a> | Planejamento, backend, integração de interfaces.      |
| Davi Helisson  | Product Owner  | <a href="https://github.com/davihelisson"><img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white"></a> | <a href="https://www.linkedin.com/in/davihelisson/"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white"></a> | Planejamento, backend, desenvolvimento de prompts |
| Gabriel Nunes   | Desenvolvedor  | <a href="https://github.com/gabrielnunes926"><img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white"></a> | <a href="https://www.linkedin.com/in/gabriel-de-barcelos-nunes-a7a69832a/"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white"></a> | Frontend, tela principal da aplicação        |
| Gustavo Toneli  | Desenvolvedor  | <a href="https://github.com/G59-Toneli"><img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white"></a> | <a href="https://www.linkedin.com/in/gustavo-toneli-de-oliveira-b46756228/"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white"></a> | Frontend, tela principal da aplicação          |
| Igor Andrade    | Desenvolvedor  | <a href="https://github.com/IgorAndrade2024"><img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white"></a> | <a href="https://www.linkedin.com/in/igor-andrade-b3b434327?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white"></a> | Backend, funcionalidade de salvamento          |
| Leo Naito    | Desenvolvedor  | <a href="https://github.com/LNaito"><img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white"></a> | <a href="[LINK_DO_LINKEDIN_DO_LEO_NAITO]"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white"></a> | Frontend, tela de saída dos testes          |
| Tiago Bortolini   | Desenvolvedor  | <a href="https://github.com/deusimortal"><img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white"></a> | <a href="https://br.linkedin.com/in/tiago-bortolini-772b162b6/"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white"></a> | Backend, pesquisa e desenvolvimento de prompts          |
