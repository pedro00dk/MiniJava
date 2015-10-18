package miniJava.astree.statement;

import miniJava.astree.Expression;
import miniJava.astree.Statement;

public class AssignStatement implements Statement {
    protected String var;
    protected Expression expr;

    public AssignStatement(String var, Expression expr) {
        this.var = var;
        this.expr = expr;
    }
}
