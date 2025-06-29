# 🧩 Anagram Generator — Spread Tecnologia

Este repositório contém a **solução da Questão 1** do teste técnico para a vaga de **Desenvolvedor Java Web Sênior (RHA2986)** da empresa **Spread Tecnologia**.

---

## ✅ Descrição da Questão 1

> Escreva um programa em Java para resolver o seguinte problema:
>
> Você foi designado para criar uma função utilitária para um aplicativo de processamento de texto. A função deve gerar todos os anagramas possíveis a partir de um grupo de letras distintas. Por exemplo, a entrada `{a, b, c}` deve retornar a saída:
>
> ```
> abc, acb, bac, bca, cab, cba
> ```

### Requisitos adicionais:

1. O programa deve aceitar qualquer grupo de letras distintas como entrada e produzir o resultado correto.
2. Otimize o código para legibilidade e clareza.
3. Inclua validação básica (por exemplo, certificar-se de que a entrada não está vazia e contém apenas letras).
4. Escreva testes unitários para validar sua função com pelo menos três casos de teste diferentes, incluindo casos de borda (por exemplo, entrada com uma única letra ou entrada vazia).
5. Documente seu código claramente, explicando a lógica para gerar os anagramas.

---

## 🧱 Estrutura do Projeto

Este projeto foi construído com base nos princípios de **Clean Architecture**, separando responsabilidades em camadas distintas:

- `src/main/java/anagramgenerator/Main.java`: ponto de entrada da aplicação.
- `src/main/java/anagramgenerator/application/GenerateAnagramUseCase.java`: valida e coordena a execução da lógica de domínio.
- `src/main/java/anagramgenerator/domain/AnagramGenerator.java`: contém a lógica recursiva para geração dos anagramas.
- `src/test/java/anagramgenerator/application/AnagramGeneratorTest.java`: testes unitários automatizados.

---

## ⚙️ Requisitos de Execução

- Java 21+
- Maven 3.8+ (pode ser executado via terminal ou diretamente por IDEs como IntelliJ ou Spring Tool Suite)

---

## 🚀 Compilação

No terminal, na raiz do projeto:

```bash
mvn clean package
```

Esse comando irá gerar o arquivo `target/anagram-generator-1.0.0.jar`.

---

## ▶️ Como Executar

Via terminal:

```bash
java -jar target/anagram-generator-1.0.0.jar abc
```

Substitua `"abc"` por qualquer sequência válida de letras distintas.

---

## 🧪 Testes Automatizados

Para executar os testes:

```bash
mvn test
```

Os testes cobrem os seguintes casos:

- Entradas válidas com 2 e 3 letras;
- Letras maiúsculas e minúsculas (case sensitive);
- Entradas inválidas:
  - String nula ou vazia;
  - Apenas uma letra;
  - Caracteres não alfabéticos (ex: a1b);
  - Letras repetidas (aab, AAB);
  - Apenas espaços em branco.

---

## 🔒 Validações Realizadas

- A entrada deve conter apenas letras (a-z, A-Z);
- Deve conter pelo menos duas letras;
- Não pode haver letras repetidas (**validação case sensitive** — "A" e "a" são considerados diferentes);
- A entrada não pode ser nula ou vazia.

---

## 👨‍💻 Autor

**Raimundo do Espírito Santo**  
[LinkedIn](https://www.linkedin.com/in/raimundo-do-esp%C3%ADrito-santo-37306b282/)
