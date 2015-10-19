import miniJava.parser.Parser;
import miniJava.util.Gen;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    // Caminho para as especificações do lexer a parser
    public static final Path LEXER_SPEC_PATH = Paths.get("src\\miniJava\\lexer\\LexerSpec.flex");
    public static final Path PARSER_SPEC_PATH = Paths.get("src\\miniJava\\parser\\ParserSpec.cup");

    /**
     * Caminho para os arquivos de teste
     */
    static final Path TEST_FILES_DIR = Paths.get("test");

    public static void main(String[] args) throws Exception {
        gen();

        // Testando arquivos
        new Parser(Paths.get("test\\binarysearch.java.txt")).parse();
        new Parser(Paths.get("test\\bubblesort.java.txt")).parse();
        new Parser(Paths.get("test\\factorial.java.txt")).parse();
        new Parser(Paths.get("test\\linearsearch.java.txt")).parse();
        new Parser(Paths.get("test\\quicksort.java.txt")).parse();

        // Arquivos dando erro no parsing
        // Ultimo bug a corrigir, problema com atribuição após uma declaração de váriavel de um tipo objeto qualquer
        //new Parser(Paths.get("test\\binarytree.java.txt")).parse();
        //new Parser(Paths.get("test\\linkedlist.java.txt")).parse();
    }

    /**
     * Gera as classes do lexer e parser automaticamente
     */
    public static void gen() {
        Gen.genLexer(LEXER_SPEC_PATH, LEXER_SPEC_PATH.getParent());
        Gen.genParser(PARSER_SPEC_PATH, PARSER_SPEC_PATH.getParent(), "Parser", "Tokens", 0);
    }
}
