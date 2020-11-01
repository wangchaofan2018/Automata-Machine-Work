package Test.TM;

import java.util.LinkedList;
import java.util.List;

public class State {
    private  String name;
    //private  char b='#';
    private Boolean Acceptsate=false;
    private Boolean Rejectsate=false;
    private final List<TranFunction> transList=new LinkedList<>();
    public State(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public void setAcceptsate(){
        this.Acceptsate=true;
    }
    public void setRejectsate(){ this.Rejectsate=true;}
    public State addTranFunction(State state, Side side){
          TranFunction trans=new TranFunction(state, side);
          if(transList.contains(trans)){
              System.out.println("转移函数库中已经有了这一条，不需要重复添加");
          }else {
              transList.add(trans);
          }
          return this;
    }
    public List<TranFunction> getTransList(char word){
        List<TranFunction> neededTrans=new LinkedList<>();
        for(TranFunction trans:transList){
            /**if(word==null&&trans.getSide().getWord()=='\0'){
             neededTrans.add(trans);
            }else if(word!='\0'&&word==trans.getSide().getWord()){
                neededTrans.add(trans);
            }*/
            if(word!='\0'&&word==(char)trans.getSide().getWord()){
                neededTrans.add(trans);
            }
        }

        return  neededTrans;
    }

    public Boolean isAccept(){
        return Acceptsate;
    }
    public Boolean isReject(){return  Rejectsate;}

}
