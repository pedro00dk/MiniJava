package miniJava.ast.expression.list;

import miniJava.ast.Node;
import miniJava.ast.expression.Expression;
import miniJava.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class ExpressionList implements Node {
    private List<Expression> expressions;

    public ExpressionList() {
        this.expressions = new ArrayList<>();
    }

    public void add(Expression e) {
        this.expressions.add(e);
    }

    public Expression get(int i) {
        return this.expressions.get(i);
    }

    public int size() {
        return this.expressions.size();
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visit(this);
    }
}
