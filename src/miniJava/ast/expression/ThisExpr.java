package miniJava.ast.expression;

import miniJava.visitor.Visitor;

public class ThisExpr implements Expression {

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visit(this);
    }
}
