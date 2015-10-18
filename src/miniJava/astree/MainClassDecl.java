package miniJava.astree;

public class MainClassDecl implements Node {
    protected String name;
    protected StatementList body;

    public MainClassDecl(String name, StatementList body) {
        this.name = name;
        this.body = body;
    }
}
