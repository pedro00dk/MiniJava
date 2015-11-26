#MiniJava

Disciplina: Teoria e Implementação de Linguagens Computacionais

Implementação de compilador para a linguagem MiniJava, um subconjunto de Java.

##Analise léxica

###Elementos Léxicos

O analisador léxico foi criado usando a biblioteca JFlex.

* **Whitespace** - Espaços em branco, quebras de linha, tabulações e carriage return
* **Comentários** - Qualquer texto entre /* e */
* **Palavras-chave** - class, public, extends, static, void, int, boolean, while, if, else, return,
false, true, this, new
* **Operadores** -  ||, &&, ==, !=, <, <=, >, >=, +, -, *, /, %, !
* **Delimitadores** -  ; . , = ( ) { } [ ]
* **Identificadores** -  um identificador começa com uma letra ou underline e é seguido por
qualquer quantidade de letras, underline e dígitos. Apenas letras entre A/a e Z/z são permitidos,
há diferença entre maiúscula e minúscula. Palavras-chave não são identificadores
* **Literais Inteiros** - uma sequência de dígitos iniciada com qualquer um dos dígitos entre 1 e 9
e seguida por qualquer número de dígitos entre 0 e 9. O dígito 0 também é um inteiro.
* **Literais ponto flutuante** - Uma parte inteira seguida de uma parte fracionária, separada por
ponto. A parte fracionária, podemos incluir um expoente, seguindo os exemplos dos slides de análise
léxica.

*Obs.: Comentários e whitespace não tem significado algum, exceto para separar os tokens.*

##Analise sintática

O analisador sintático foi criado usando a biblioteca Java CUP, e foi integrado com o JFlex para usar
os tokens lidos pelo analizador léxico.
A arvore sintática abstrata foi gerrada pelo parser e é usada para imprimir e verificar o programa.

##Analise semántica

Na analise semantica é feito o type checking usando visitors, onde um visitor gera uma tabela de símbolos
e essa tabela é usada por outro visitor para verificação dos tipos de dados na estrutura.