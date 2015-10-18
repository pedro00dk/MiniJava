package miniJava.astree;

public class VariableDeclList implements Node {
    protected VariableDecl variable;
    protected VariableDeclList varribleList;

    public VariableDeclList(VariableDecl variable, VariableDeclList varribleList) {
        this.variable = variable;
        this.varribleList = varribleList;
    }
}
