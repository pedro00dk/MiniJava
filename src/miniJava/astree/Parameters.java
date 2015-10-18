package miniJava.astree;

public class Parameters implements Node {
    protected Parameter param;
    protected Parameters params;

    public Parameters(Parameter param, Parameters params) {
        this.param = param;
        this.params = params;
    }
}
