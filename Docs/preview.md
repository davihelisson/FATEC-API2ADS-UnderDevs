# Backlog do Produto: IDE Java para Python com Assistência IA (Ollama/Qwen)

**Tecnologias Base:** Java (Swing), API Ollama (Modelo: Qwen/Code Llama/Similar), Python (para execução/teste), Banco de Dados MySql (para Sprint 3)
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