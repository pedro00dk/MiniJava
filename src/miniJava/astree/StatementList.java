package miniJava.astree;

public class StatementList implements Node {
    protected Statement stmt;
    protected StatementList stmtList;

    public StatementList(Statement stmt, StatementList stmtList) {
        this.stmt = stmt;
        this.stmtList = stmtList;
    }
}
