package miniJava.astree;

public class MethodDecl implements Node {
    protected DataType returnType;
    protected String name;
    protected ParameterList paramList;
    protected VariableDeclList variablesList;
    protected StatementList body;
    protected Expression returnExpr;

    public MethodDecl(DataType returnType, String name, ParameterList paramList, VariableDeclList variablesList,
                      StatementList body, Expression returnExpr) {
        this.returnType = returnType;
        this.name = name;
        this.paramList = paramList;
        this.variablesList = variablesList;
        this.body = body;
        this.returnExpr = returnExpr;
    }
}
