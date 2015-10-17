package miniJava.util;

import jflex.SilentExit;

import java.nio.file.Path;

/**
 * Classe criada para facilitar a geração do lexer e parser.
 */
public class Gen {

    /**
     * Gera o lexer de acordo com a especificação recebida, salvando no destino recebido.
     * O nome da classe é especificado no *.jflex.
     * O arquivo gerado deverá estar no pacote indicado pela especificação.
     *
     * @param spec especificação do lexer (*.flex)
     * @param dest pasta de destino
     */
    public static void genLexer(Path spec, Path dest) {
        try {
            // Setando destino
            jflex.Main.parseOptions(new String[]{"-d", dest.toAbsolutePath().toString()});

            // Gerando arquivo
            jflex.Main.generate(new String[]{spec.toAbsolutePath().toString()});

        } catch (SilentExit silentExit) {
            silentExit.printStackTrace();
        }
    }

    /**
     * Gera o parser de acordo com a especificação recebida, salvando no destino recebido.
     * O nome da classe é especificado no parametro da função
     * O nome da interface de teminais é especificado no parametro da função
     * O arquivo gerado deverá estar no pacote indicado pela especificação.
     *
     * @param spec especificação do parser (*.cup)
     * @param dest pasta de destino
     */
    public static void genParser(Path spec, Path dest, String parserClassName, String symbolClassName) {

        try {
            // Setando atributos
            java_cup.Main.main(new String[]{"-parser", parserClassName, "-interface", "-symbols", symbolClassName,
                    "-destdir", dest.toAbsolutePath().toString(), spec.toAbsolutePath().toString()});

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
