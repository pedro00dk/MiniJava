package miniJava.astree.expression;

import miniJava.astree.ArgumentList;
import miniJava.astree.Expression;

public class FunctionExpression implements Expression {
    protected Expression object;
    protected String methodName;
    protected ArgumentList args;

    public FunctionExpression(Expression object, String methodName, ArgumentList args) {
        this.object = object;
        this.methodName = methodName;
        this.args = args;
    }
}
