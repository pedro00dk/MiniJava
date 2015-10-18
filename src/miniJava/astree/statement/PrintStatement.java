package miniJava.astree.statement;

import miniJava.astree.Expression;
import miniJava.astree.Statement;

public class PrintStatement implements Statement {
    protected Expression toPrint;

    public PrintStatement(Expression toPrint) {
        this.toPrint = toPrint;
    }
}
