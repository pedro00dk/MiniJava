package miniJava.astree;

public class MethodDeclList implements Node {
    protected MethodDecl method;
    protected MethodDeclList methodDeclList;

    public MethodDeclList(MethodDecl method, MethodDeclList methodDeclList) {
        this.method = method;
        this.methodDeclList = methodDeclList;
    }
}
