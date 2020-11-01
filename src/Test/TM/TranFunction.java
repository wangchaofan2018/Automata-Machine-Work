package Test.TM;

public class TranFunction {
    private State state;
    private Side side;
    public TranFunction(State state, Side side) {
        this.side=side;
        this.state=state;
    }
    public State getState(){
        return state;
    }
    public Side getSide(){
        return side;
    }

}
