import miniJava.ast.Node;
import miniJava.ast.program.Program;
import miniJava.parser.Parser;
import miniJava.util.Gen;
import miniJava.visitor.TypeCheckVisitor.BuildSymbolTableVisitor;
import miniJava.visitor.TypeCheckVisitor.TypeCheckVisitor;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    // Caminho para as especifica��es do lexer a parser
    public static final Path LEXER_SPEC_PATH = Paths.get("src\\miniJava\\lexer\\LexerSpec.flex");
    public static final Path PARSER_SPEC_PATH = Paths.get("src\\miniJava\\parser\\ParserSpec.cup");

    /**
     * Caminho para os arquivos de teste
     */
    static final Path TEST_FILES_DIR = Paths.get("test");

    public static void main(String[] args) throws Exception {
        //gen();

        // Testando arquivos
        for (Path p: Files.newDirectoryStream(TEST_FILES_DIR)) {
            Node program = (Node) new Parser(p).parse().value;

            BuildSymbolTableVisitor bstvisitor  = new BuildSymbolTableVisitor();
            program.accept(bstvisitor);

            TypeCheckVisitor tcvisitor = new TypeCheckVisitor(bstvisitor.getTable());
            program.accept(tcvisitor);
            for (String error: tcvisitor.getErrors()) System.out.println(error);
        }
    }

    /**
     * Gera as classes do lexer e parser automaticamente
     */
    public static void gen() {
        Gen.genLexer(LEXER_SPEC_PATH, LEXER_SPEC_PATH.getParent());
        Gen.genParser(PARSER_SPEC_PATH, PARSER_SPEC_PATH.getParent(), "Parser", "Tokens", 0);
    }
}
