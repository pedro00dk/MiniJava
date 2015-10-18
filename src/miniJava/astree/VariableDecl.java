package miniJava.astree;

public class VariableDecl implements Node {
    protected DataType type;
    protected String name;

    public VariableDecl(DataType type, String name) {
        this.type = type;
        this.name = name;
    }
}
