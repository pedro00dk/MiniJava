package miniJava.ast.type;

import miniJava.visitor.Visitor;

public class IntegerType implements Type {

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visit(this);
    }
}
