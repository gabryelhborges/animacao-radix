# Animação Radix Sort

Este projeto é uma aplicação Java desenvolvida com JavaFX que apresenta uma animação visual e interativa do algoritmo de ordenação **Radix Sort**. O objetivo é facilitar o entendimento do funcionamento interno do algoritmo, mostrando cada etapa do processo de ordenação de forma didática e visual.

---

## Funcionalidades

### 1. Visualização do Algoritmo

- **Vetor de Entrada**: Um vetor de números inteiros é gerado aleatoriamente e exibido como uma sequência de botões na tela.
- **Etapas do Algoritmo**: O algoritmo é dividido em passos visuais, destacando cada fase do Radix Sort:
  - Contagem das ocorrências dos dígitos.
  - Acumulação dos valores no vetor de contagem.
  - Construção do vetor auxiliar.
  - Cópia dos valores ordenados de volta ao vetor original.

### 2. Animações Didáticas

- **Setas Animadas**: Setas indicam visualmente a posição atual de leitura e escrita nos vetores, facilitando o acompanhamento do fluxo do algoritmo.
- **Mudanças Visuais**: Alterações nos vetores são destacadas com cores e animações, tornando evidente cada modificação.
- **Painel de Pseudocódigo**: Um painel lateral exibe o pseudocódigo do Radix Sort, com a linha correspondente ao passo atual sendo destacada em tempo real.

### 3. Painel de Variáveis

- **Acompanhamento de Variáveis**: Um painel exibe os valores atuais das principais variáveis do algoritmo (`maior`, `exp`, `i`, `dígito`, `pos`, `vetorCounting`, `vetorAux`), atualizando dinamicamente conforme a execução.
- **Descrição das Posições Numéricas**: O sistema informa se está processando unidade, dezena, centena, etc., facilitando o entendimento do significado de cada iteração.

### 4. Interação

- **Botão de Execução**: O usuário pode iniciar a animação do Radix Sort clicando em um botão. Durante a execução, o botão é desativado para evitar múltiplas execuções simultâneas.
- **Mensagem de Conclusão**: Ao final da ordenação, uma janela modal informa que o vetor foi ordenado com sucesso.

---

## Estrutura do Projeto

- **JavaFX**: Utilizado para toda a interface gráfica e animações.
- **FXML**: Estrutura básica da interface definida em arquivos `.fxml`.
- **CSS**: Estilização dos componentes visuais para uma aparência moderna e agradável.
- **Organização Modular**: O código está organizado em classes separadas para facilitar manutenção e expansão.

---

## Como Funciona a Animação

1. **Inicialização**: Ao iniciar o programa, um vetor de inteiros é criado e exibido.
2. **Execução do Radix Sort**:
   - O maior valor do vetor é identificado para determinar o número de dígitos a serem processados.
   - Para cada dígito (unidade, dezena, centena, ...):
     - O vetor de contagem é zerado e preenchido conforme os dígitos dos elementos.
     - O vetor de contagem é acumulado.
     - O vetor auxiliar é preenchido de acordo com as posições calculadas.
     - O vetor original é atualizado com os valores ordenados para aquele dígito.
   - Cada passo é animado, com destaque visual e atualização dos painéis de variáveis e pseudocódigo.
3. **Finalização**: Ao término, o usuário é informado do sucesso da ordenação.

---

## Tecnologias Utilizadas

- **Java 23**
- **JavaFX 17**
- **Maven** para gerenciamento de dependências e build
- **FXML** para definição da interface
- **CSS** para estilização

---

![image](https://github.com/user-attachments/assets/1e2882e7-4f1d-449f-a8ee-f5c2a4f8c628)

## Experimente!

Para rodar o projeto, basta executar:

```sh
mvn clean javafx:run
