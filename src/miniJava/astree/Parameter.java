package miniJava.astree;

public class Parameter implements Node {
    protected DataType type;
    protected String name;

    public Parameter(DataType type, String name) {
        this.type = type;
        this.name = name;
    }
}
