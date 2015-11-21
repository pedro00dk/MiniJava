package miniJava.ast.declaration.methodDecl;

import miniJava.ast.Node;
import miniJava.ast.declaration.methodDecl.list.ArgumentList;
import miniJava.ast.declaration.varDecl.list.VarDeclList;
import miniJava.ast.expression.Expression;
import miniJava.ast.identifier.Identifier;
import miniJava.ast.statement.list.StatementList;
import miniJava.ast.type.Type;
import miniJava.visitor.Visitor;

public class MethodDecl implements Node {
    private Type returnType;
    private Identifier name;
    private ArgumentList arguments;
    private VarDeclList variables;
    private StatementList statements;
    private Expression returnExpr;

    public MethodDecl(Type returnType, Identifier name, ArgumentList arguments, VarDeclList variables, StatementList statements, Expression returnExpr) {
        this.returnType = returnType;
        this.name = name;
        this.arguments = arguments;
        this.variables = variables;
        this.statements = statements;
        this.returnExpr = returnExpr;
    }

    public Type getReturnType() {
        return returnType;
    }

    public Identifier getName() {
        return name;
    }

    public ArgumentList getArguments() {
        return arguments;
    }

    public VarDeclList getVariables() {
        return variables;
    }

    public StatementList getStatements() {
        return statements;
    }

    public Expression getReturnExpr() {
        return returnExpr;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visit(this);
    }
}
