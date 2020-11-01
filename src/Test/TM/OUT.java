package Test.TM;

import java.util.LinkedList;
import java.util.List;

public class OUT {
    private String testWords;
    private List<State> showstates=new LinkedList<>();
    private List<Side>   showsides=new LinkedList<>();
    public OUT(){

    };
    public String shuchu(){
        StringBuilder out=new StringBuilder();
        for(int i=0;i<showstates.size();i++){
            out.append("状态(");
            out.append(showstates.get(i).getName());
            out.append(")");
            if(i<showsides.size()){
                out.append(">>>通过>>>");
                out.append(showsides.get(i).shuchu());
                out.append(">>>到达>>>");
            }
            System.out.println();
        }
        return out.toString();
    }
    public OUT(String testWords){
        this.testWords=testWords;
    }
    public State addState(State state){
        showstates.add(state);
        return state;
    }
    public Side addSide(Side side){
        showsides.add(side);
        return side;
    }
    public Boolean lastState(){
        if (showstates.size()>0){
            State lastState=showstates.get(showstates.size()-1);
            if(lastState.isAccept()){
                return true;
            }

        }
        return false;
    }
    public OUT Inherit(){
        OUT nextout=new OUT();
        for(State s:showstates){
            nextout.addState(s);
        }
        for (Side S:showsides){
            nextout.addSide(S);
        }
        nextout.setTestWords(testWords);
        return nextout;
    }

    public String getTestWords() {
        return testWords;
    }

    public void setTestWords(String testWords) {
        this.testWords = testWords;
    }

}
