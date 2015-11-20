package miniJava.ast.expression.identifier;

import miniJava.ast.expression.Expression;
import miniJava.ast.identifier.Identifier;

public class NewObjectExpr extends Expression {
    public Identifier id;

    public NewObjectExpr(Identifier id) {
        this.id = id;
    }

    public Identifier getId() {
        return id;
    }
}
