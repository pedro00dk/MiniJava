import miniJava.lexer.Lexer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Main criado para testar o analizador
 */
public class Main {

    /**
     * Caminho para os arquivos de teste
     */
    static final Path TEST_FILES_DIR = Paths.get("test");

    public static void main(String[] args) throws IOException {
        for (Path testFile : Files.newDirectoryStream(TEST_FILES_DIR)) {
            System.out.println(testFile.getFileName());
            Lexer.main(new String[]{testFile.toString()});
        }
    }
}
