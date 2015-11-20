package miniJava.ast.expression;

import miniJava.ast.expression.list.ExpressionList;
import miniJava.ast.identifier.Identifier;

public class MethodCallExpr extends Expression {
    private Expression object;
    private Identifier method;
    private ExpressionList params;

    public MethodCallExpr(Expression object, Identifier method, ExpressionList params) {
        this.object = object;
        this.method = method;
        this.params = params;
    }

    public Expression getObject() {
        return object;
    }

    public Identifier getMethod() {
        return method;
    }

    public ExpressionList getParams() {
        return params;
    }
}
