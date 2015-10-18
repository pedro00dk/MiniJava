package miniJava.astree;

public class ClassDecl implements Node {
    protected String name;
    protected Extends ext;
    protected VariableDeclList varList;
    protected MethodDeclList methodList;

    public ClassDecl(String name, Extends ext, VariableDeclList varList, MethodDeclList methodList) {
        this.name = name;
        this.ext = ext;
        this.varList = varList;
        this.methodList = methodList;
    }
}
