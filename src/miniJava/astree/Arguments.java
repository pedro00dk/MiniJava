package miniJava.astree;

public class Arguments implements Node {
    protected Expression argument;
    protected Arguments args;

    public Arguments(Expression argument, Arguments args) {
        this.argument = argument;
        this.args = args;
    }
}
