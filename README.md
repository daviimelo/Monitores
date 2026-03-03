# Sistema de Gestão de Monitoria

> **Projeto eleito o melhor da disciplina de Programação Orientada a Objetos (POO) no IFPB (2025.2).**

[cite_start]Um sistema desktop desenvolvido em **Java** para auxiliar estudantes e a Coordenação do Curso no gerenciamento semestral dos Editais de Monitoria[cite: 5]. A aplicação automatiza processos trabalhosos, facilitando a criação de editais, inscrição de alunos e o ranqueamento automático dos candidatos.

## Funcionalidades Principais

### Perfil Coordenador (Administrador)
- [cite_start]**Gestão de Editais:** Cadastro de novos editais definindo prazos, disciplinas, vagas (remuneradas ou voluntárias) e a fórmula de ranqueamento[cite: 6, 19, 21].
- [cite_start]**Cálculo de Resultados:** Geração automática do ranque de candidatos por disciplina, utilizando uma soma ponderada configurável (CRE + Média da Disciplina)[cite: 22, 39].
- [cite_start]**Acompanhamento e Fechamento:** Visualização de resultados preliminares, consolidação final após período de desistências e recurso de clonagem de editais antigos[cite: 29, 44].
- [cite_start]**Relatórios e Comunicação:** Exportação do resultado final do edital em PDF [cite: 51] [cite_start]e envio de e-mails diretamente para os estudantes inscritos[cite: 50].

### Perfil Aluno
- [cite_start]**Inscrição Simplificada:** Visualização de editais abertos e inscrição em vagas informando o CRE atual e a média na disciplina desejada[cite: 16, 38].
- [cite_start]**Gestão de Candidatura:** Acompanhamento do ranqueamento e opção de desistência de vagas, o que engatilha o recálculo automático da fila de contemplados pelo sistema[cite: 40, 45, 47].

## Tecnologias Utilizadas

O projeto foi construído aplicando conceitos sólidos de Programação Orientada a Objetos e utiliza as seguintes tecnologias:

- **Linguagem:** Java 17+
- [cite_start]**Interface Gráfica:** Java Swing (Desktop) [cite: 69]
- **Banco de Dados:** SQLite (Embarcado e inicializado automaticamente para facilitar a execução).
- **Ambiente de Desenvolvimento:** PostgreSQL com Docker (utilizado durante a criação para simular cenários complexos).
- **Gerenciador de Dependências:** Maven

## ⚙️ Como Executar o Projeto

O sistema foi arquitetado para rodar de forma simples, inicializando o banco SQLite automaticamente.

1. Clone este repositório:
   ```bash
   git clone [https://github.com/daviimelo/Monitores.git](https://github.com/daviimelo/Monitores.git)
