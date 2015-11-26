#MiniJava

Disciplina: Teoria e Implementa��o de Linguagens Computacionais

Implementa��o de compilador para a linguagem MiniJava, um subconjunto de Java.

##Analise l�xica

###Elementos L�xicos

O analisador l�xico foi criado usando a biblioteca JFlex.

* **Whitespace** - Espa�os em branco, quebras de linha, tabula��es e carriage return
* **Coment�rios** - Qualquer texto entre /* e */
* **Palavras-chave** - class, public, extends, static, void, int, boolean, while, if, else, return,
false, true, this, new
* **Operadores** -  ||, &&, ==, !=, <, <=, >, >=, +, -, *, /, %, !
* **Delimitadores** -  ; . , = ( ) { } [ ]
* **Identificadores** -  um identificador come�a com uma letra ou underline e � seguido por
qualquer quantidade de letras, underline e d�gitos. Apenas letras entre A/a e Z/z s�o permitidos,
h� diferen�a entre mai�scula e min�scula. Palavras-chave n�o s�o identificadores
* **Literais Inteiros** - uma sequ�ncia de d�gitos iniciada com qualquer um dos d�gitos entre 1 e 9
e seguida por qualquer n�mero de d�gitos entre 0 e 9. O d�gito 0 tamb�m � um inteiro.
* **Literais ponto flutuante** - Uma parte inteira seguida de uma parte fracion�ria, separada por
ponto. A parte fracion�ria, podemos incluir um expoente, seguindo os exemplos dos slides de an�lise
l�xica.

*Obs.: Coment�rios e whitespace n�o tem significado algum, exceto para separar os tokens.*

##Analise sint�tica

O analisador sint�tico foi criado usando a biblioteca Java CUP, e foi integrado com o JFlex para usar
os tokens lidos pelo analizador l�xico.
A arvore sint�tica abstrata foi gerrada pelo parser e � usada para imprimir e verificar o programa.

##Analise sem�ntica

Na analise semantica � feito o type checking usando visitors, onde um visitor gera uma tabela de s�mbolos
e essa tabela � usada por outro visitor para verifica��o dos tipos de dados na estrutura.