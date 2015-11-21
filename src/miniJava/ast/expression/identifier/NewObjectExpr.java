package miniJava.ast.expression.identifier;

import miniJava.ast.expression.Expression;
import miniJava.ast.identifier.Identifier;
import miniJava.visitor.Visitor;

public class NewObjectExpr implements Expression {
    public Identifier id;

    public NewObjectExpr(Identifier id) {
        this.id = id;
    }

    public Identifier getId() {
        return id;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visit(this);
    }
}
