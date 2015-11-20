package miniJava.ast.expression.list;

import miniJava.ast.expression.Expression;

import java.util.ArrayList;
import java.util.List;

public class ExpressionList {
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
}
