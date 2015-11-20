package miniJava.ast.expression;

import miniJava.ast.expression.list.ExpressionList;
import miniJava.ast.identifier.Identifier;

public class MethodCall extends Expression {
    private Expression object;
    private Identifier method;
    private ExpressionList params;

    public MethodCall(Expression object, Identifier method, ExpressionList params) {
        this.object = object;
        this.method = method;
        this.params = params;
    }
}
