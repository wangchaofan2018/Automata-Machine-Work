package Test.TM;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TM {
    private State firststate;//开始状态
    private char[] re;
    //private Stack stack=new Stack();//PDA中工作的栈
    private ArrayList list= new ArrayList();
    public TM(State firststate){
        this.firststate=firststate;
    }
    //public PDA(State firststate, char identify){
        //this.firststate=firststate;
        //stack.push(identify);//栈底标识压栈

    //}
    public OUT Words(String testwords){
         //State state=firststate;
        //OUT out=new OUT();
        System.out.println(testwords);
          return Words(firststate,testwords,0,new OUT());



    }
      //测试字符识别过程
    public OUT Words(State state, String testwords, int index, OUT out){
        int nextIndex;
        re=testwords.toCharArray();
        out.addState(state);
        /**if(index==testwords.length()&&state.isAccept()){
            return out;
        }*/

        if(state.isAccept()||state.isReject()){
            return out;
        }else {
            if(!out.lastState()){
                System.out.println("当前的字符串无法识别");
            }

        }

        /**if(index>testwords.length()&&state.getTransList('\0').size()==0){
            return out;
        }*/
        //List<TranFunction> states=state.getTransList('\0');
        List<TranFunction> states=new LinkedList<>();
        if(index<testwords.length()){
            states.addAll(state.getTransList(re[index]));

        }
        OUT outnext=new OUT(testwords);
          for(TranFunction tranFunction:states){
              Side side=tranFunction.getSide();

              if(side.getWord()==re[index]&&side.getWord()=='#'&&side.getDirection()=='R'){
                  nextIndex=index+1;
                  System.out.println(index);
                  System.out.println(re[index]);
                  //System.out.println("对了");
                  out.addSide(tranFunction.getSide());
                  //int nextIndex=index;
                  //System.out.println(nextIndex);
                  String testword=new String(re);
                  System.out.println(testword);
                  outnext=Words(tranFunction.getState(),testword,nextIndex,out.Inherit());
                  /**if(tranFunction.getState().isAccept()){
                      return outnext;
                  }else {
                      if(nextIndex==testwords.length()){
                          System.out.println("很抱歉您输入的字符串这个TM无法识别!!!!!");
                      }

                  }*/
                  if(nextIndex==testwords.length()){
                      //System.out.println("很抱歉您输入的字符串这个TM无法识别!!!!!");
                      return outnext;
                  }

              }
              if(side.getWord()==re[index]&&side.getWord()=='a'&&side.getInWord()=='x'&&side.getDirection()=='R'){
                  re[index]='x';
                  System.out.println(index);
                  System.out.println(re[index]);
                  //System.out.println("对了");
                  nextIndex=index+1;
                  out.addSide(tranFunction.getSide());
                  String testword=new String(re);
                  System.out.println(testword);
                  outnext=Words(tranFunction.getState(),testword,nextIndex,out.Inherit());
                  if(nextIndex==testwords.length()){
                      //System.out.println("很抱歉您输入的字符串这个TM无法识别!!!!!");
                      return outnext;
                  }
                  /**if(tranFunction.getState().isAccept()){
                      return outnext;
                  }else {
                      if(nextIndex==testwords.length()){
                          System.out.println("很抱歉您输入的字符串这个TM无法识别!!!!!");
                      }

                  }*/
              }
              if(side.getWord()==re[index]&&side.getWord()=='+'&&side.getDirection()=='R'){
                  nextIndex=index+1;
                  System.out.println(index);
                  System.out.println(re[index]);
                  out.addSide(tranFunction.getSide());
                  String testword=new String(re);
                  System.out.println(testword);
                  outnext=Words(tranFunction.getState(),testword,nextIndex,out.Inherit());
                  if(nextIndex==testwords.length()){
                      //System.out.println("很抱歉您输入的字符串这个TM无法识别!!!!!");
                      return outnext;
                  }
                  /**if(tranFunction.getState().isAccept()){
                      return outnext;
                  }else {
                      if(nextIndex==testwords.length()){
                          System.out.println("很抱歉您输入的字符串这个TM无法识别!!!!!");
                      }

                  }*/
              }
              if(side.getWord()==re[index]&&side.getWord()=='='&&side.getDirection()=='R'){
                  System.out.println(index);
                  System.out.println(re[index]);
                  nextIndex=index+1;
                  out.addSide(tranFunction.getSide());
                  String testword=new String(re);
                  System.out.println(testword);
                  outnext=Words(tranFunction.getState(),testword,nextIndex,out.Inherit());
                  if(nextIndex==testwords.length()){
                      //System.out.println("很抱歉您输入的字符串这个TM无法识别!!!!!");
                      return outnext;
                  }
                 /** if(tranFunction.getState().isAccept()){
                      return outnext;
                  }else {
                      if(nextIndex==testwords.length()){
                          System.out.println("很抱歉您输入的字符串这个TM无法识别!!!!!");
                      }

                  }*/
              }
              if(side.getWord()==re[index]&&side.getWord()=='a'&&side.getInWord()=='a'&&side.getDirection()=='R'){
                  System.out.println(index);
                  System.out.println(re[index]);
                  nextIndex=index+1;
                  out.addSide(tranFunction.getSide());
                  String testword=new String(re);
                  System.out.println(testword);
                  outnext=Words(tranFunction.getState(),testword,nextIndex,out.Inherit());
                  if(nextIndex==testwords.length()){
                      //System.out.println("很抱歉您输入的字符串这个TM无法识别!!!!!");
                      return outnext;
                  }
                  /**if(tranFunction.getState().isAccept()){
                      return outnext;
                  }else {
                      if(nextIndex==testwords.length()){
                          System.out.println("很抱歉您输入的字符串这个TM无法识别!!!!!");
                      }

                  }*/
              }

              if(side.getWord()==re[index]&&side.getWord()=='a'&&side.getInWord()=='x'&&side.getDirection()=='L'){
                  re[index]='x';
                  System.out.println(index);
                  System.out.println(re[index]);
                  //System.out.println("对了");
                  nextIndex=index-1;
                  out.addSide(tranFunction.getSide());
                  String testword=new String(re);
                  System.out.println(testword);
                  outnext=Words(tranFunction.getState(),testword,nextIndex,out.Inherit());
                  if(nextIndex==testwords.length()){
                      //System.out.println("很抱歉您输入的字符串这个TM无法识别!!!!!");
                      return outnext;
                  }
                 /** if(tranFunction.getState().isAccept()){
                      return outnext;
                  }else {
                      if(nextIndex==testwords.length()){
                          System.out.println("很抱歉您输入的字符串这个TM无法识别!!!!!");
                      }

                  }*/
              }
              if(side.getWord()==re[index]&&side.getWord()=='+'&&side.getInWord()=='+'&&side.getDirection()=='L'){
                  System.out.println(index);
                  System.out.println(re[index]);
                  //System.out.println("对了");
                  nextIndex=index-1;
                  out.addSide(tranFunction.getSide());
                  String testword=new String(re);
                  System.out.println(testword);
                  outnext=Words(tranFunction.getState(),testword,nextIndex,out.Inherit());
                  if(nextIndex==testwords.length()){
                      //System.out.println("很抱歉您输入的字符串这个TM无法识别!!!!!");
                      return outnext;
                  }
                  /**if(tranFunction.getState().isAccept()){
                      return outnext;
                  }else {
                      if(nextIndex==testwords.length()){
                          System.out.println("很抱歉您输入的字符串这个TM无法识别!!!!!");
                      }

                  }*/
              }
              if(side.getWord()==re[index]&&side.getWord()=='='&&side.getInWord()=='='&&side.getDirection()=='L'){
                  System.out.println(index);
                  System.out.println(re[index]);
                  //System.out.println("对了");
                  nextIndex=index-1;
                  out.addSide(tranFunction.getSide());
                  String testword=new String(re);
                  System.out.println(testword);
                  outnext=Words(tranFunction.getState(),testword,nextIndex,out.Inherit());
                  if(nextIndex==testwords.length()){
                      //System.out.println("很抱歉您输入的字符串这个TM无法识别!!!!!");
                      return outnext;
                  }
                  /**if(tranFunction.getState().isAccept()){
                      return outnext;
                  }else {
                      if(nextIndex==testwords.length()){
                          System.out.println("很抱歉您输入的字符串这个TM无法识别!!!!!");
                      }

                  }*/
              }
              if(side.getWord()==re[index]&&side.getWord()=='x'&&side.getInWord()=='x'&&side.getDirection()=='R'){
                  System.out.println(index);
                  System.out.println(re[index]);
                  //System.out.println("对了");
                  nextIndex=index+1;
                  out.addSide(tranFunction.getSide());
                  String testword=new String(re);
                  System.out.println(testword);
                  outnext=Words(tranFunction.getState(),testword,nextIndex,out.Inherit());
                  if(nextIndex==testwords.length()){
                      //System.out.println("很抱歉您输入的字符串这个TM无法识别!!!!!");
                      return outnext;
                  }
                  /**if(tranFunction.getState().isAccept()){
                      return outnext;
                  }else {
                      if(nextIndex==testwords.length()){
                          System.out.println("很抱歉您输入的字符串这个TM无法识别!!!!!");
                      }

                  }*/
              }
              if(side.getWord()==re[index]&&side.getWord()=='x'&&side.getInWord()=='x'&&side.getDirection()=='L'){
                  System.out.println(index);
                  System.out.println(re[index]);
                  //System.out.println("对了");
                  nextIndex=index-1;
                  out.addSide(tranFunction.getSide());
                  String testword=new String(re);
                  System.out.println(testword);
                  outnext=Words(tranFunction.getState(),testword,nextIndex,out.Inherit());
                  if(nextIndex==testwords.length()){
                      //System.out.println("很抱歉您输入的字符串这个TM无法识别!!!!!");
                      return outnext;
                  }
                 /*8 if(tranFunction.getState().isAccept()){
                      return outnext;
                  }else {
                      if(nextIndex==testwords.length()){
                          System.out.println("很抱歉您输入的字符串这个TM无法识别!!!!!");
                      }

                  }*/
              }
              if(side.getWord()==re[index]&&side.getWord()=='a'&&side.getInWord()=='a'&&side.getDirection()=='L'){
                  //re[index]='x';
                  System.out.println(index);
                  System.out.println(re[index]);
                  //System.out.println("对了");
                  nextIndex=index-1;
                  out.addSide(tranFunction.getSide());
                  String testword=new String(re);
                  System.out.println(testword);
                  outnext=Words(tranFunction.getState(),testword,nextIndex,out.Inherit());
                  if(nextIndex==testwords.length()){
                      //System.out.println("很抱歉您输入的字符串这个TM无法识别!!!!!");
                      return outnext;
                  }
                  /**8if(tranFunction.getState().isAccept()){
                      return outnext;
                  }else {
                      if(nextIndex==testwords.length()){
                          System.out.println("很抱歉您输入的字符串这个TM无法识别!!!!!");
                      }

                  }*/
              }
              if(side.getWord()==re[index]&&side.getWord()=='%'&&side.getInWord()=='%'&&side.getDirection()=='R'){
                  //re[index]='x';
                  System.out.println(index);
                  System.out.println(re[index]);
                  //System.out.println("对了");
                  nextIndex=index+1;
                  out.addSide(tranFunction.getSide());
                  String testword=new String(re);
                  System.out.println(testword);
                  outnext=Words(tranFunction.getState(),testword,nextIndex,out.Inherit());
                  if(tranFunction.getState().isAccept()){
                      //System.out.println("很抱歉您输入的字符串这个TM无法识别!!!!!");
                      System.out.println("您输入的字符串可以被识别");
                  }else {
                      System.out.println("您输入的字符这个图灵机无法识别");
                  }
                  /**8if(tranFunction.getState().isAccept()){
                   return outnext;
                   }else {
                   if(nextIndex==testwords.length()){
                   System.out.println("很抱歉您输入的字符串这个TM无法识别!!!!!");
                   }

                   }*/
              }


              /**if(outnext.lastState()){
                  return outnext;
              }else {
                  if(nextIndex==testwords.length()){
                      System.out.println("很抱歉您输入的字符串这个PDA无法识别!!!!!");
                  }

          }*/


        }
      return outnext;

    }

}
