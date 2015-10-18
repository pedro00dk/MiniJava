package miniJava.astree.statement;

import miniJava.astree.Expression;
import miniJava.astree.Statement;

public class AssignArrayStatement implements Statement {
    protected String var;
    protected Expression indexExpr;
    protected Expression expr;

    public AssignArrayStatement(String var, Expression indexExpr, Expression expr) {
        this.var = var;
        this.indexExpr = indexExpr;
        this.expr = expr;
    }
}
