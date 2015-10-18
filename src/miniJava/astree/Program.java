package miniJava.astree;

public class Program implements Node {
    protected MainClassDecl mainClass;
    protected ClassDeclList classList;

    public Program(MainClassDecl mainClass, ClassDeclList classList) {
        this.mainClass = mainClass;
        this.classList = classList;
    }
}
