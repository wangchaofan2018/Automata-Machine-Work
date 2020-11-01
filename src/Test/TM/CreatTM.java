package Test.TM;

public class CreatTM {
    public static void main(String[] args) {
       State p1=new State("p1");
       State p2=new State("p2");
       State p3=new State("P3");
       State p4=new State("p4");
       State p5=new State("p5");
       State p6=new State("p6");
       State p7=new State("p7");
       State p8=new State("p8");
       State p9=new State("p9");
       State p10=new State("p10");
       State p11=new State("p11");
       State reject=new State("reject");
       State accept=new State("accept");
       Side t1=new Side('#', '#', 'R');
       Side t2=new Side('a', 'x', 'R');
       Side t3=new Side('a', 'a', 'R');
       Side t4=new Side('+', '+', 'R');
       Side t5=new Side('=', '=', 'R');
       Side t6=new Side('x', 'x', 'R');
       Side t7=new Side('%','%', 'R');
       Side t8=new Side('a', 'x', 'L');
       Side t9=new Side('a', 'a', 'L');
       Side t10=new Side('x', 'x', 'L');
       Side t11=new Side('=', '=', 'L');
       Side t12=new Side('+', '+', 'L');
       p8.addTranFunction(p11,t2);
       p11.addTranFunction(p9,t5);
       p11.addTranFunction(p11,t3);
       //p11.addTranFunction(p11,t4);
       p1.addTranFunction(p2,t1);
       p2.addTranFunction(p3,t2);
       p2.addTranFunction(p7,t5);
       p2.addTranFunction(p8,t4);
       p3.addTranFunction(p3,t3);
       p3.addTranFunction(p3,t4);
       p3.addTranFunction(p4,t5);
       p4.addTranFunction(p4,t6);
       p4.addTranFunction(reject,t7);
       p4.addTranFunction(p5,t8);
       p5.addTranFunction(p5,t10);
       p5.addTranFunction(p6,t11);
       p6.addTranFunction(p6,t9);
       p6.addTranFunction(p6,t12);
       p6.addTranFunction(p2,t6);
       //p8.addTranFunction(p8,t2);
       //p8.addTranFunction(p8,t3);
       //p8.addTranFunction(p9,t5);
       p9.addTranFunction(p9,t6);
       p9.addTranFunction(p10,t8);
       p10.addTranFunction(p10,t9);
       p10.addTranFunction(p10,t10);
       p10.addTranFunction(p6,t11);
       p7.addTranFunction(accept,t7);
       p7.addTranFunction(p7,t6);
       accept.setAcceptsate();
       reject.setRejectsate();
       TM tm=new TM(p1);

       //OUT out2=new OUT();
       OUT out2=tm.Words("#a+aa=aaaa%");
       System.out.println(out2.shuchu());


    }
}
