package NFA;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by wangchaofan on 2020/10/13.
 */
public class NFA {
    public static final String BEGIN_STATUS = "q1";
    public static final String END_STATUS = "q4";

    public static List<Status> list = new ArrayList<Status>() {{
        add(new Status("q1", '0', "q1"));
        add(new Status("q1", '1', "q1"));
        add(new Status("q1", '1', "q2"));
        add(new Status("q1", 'ε', "REFUSE"));
        add(new Status("q2", '0', "q3"));
        add(new Status("q2", 'ε', "q3"));
        add(new Status("q2", '1', "REFUSE"));
        add(new Status("q3", '0', "REFUSE"));
        add(new Status("q3", '1', "q4"));
        add(new Status("q3", 'ε', "REFUSE"));
        add(new Status("q4", '0', "q4"));
        add(new Status("q4", '1', "q4"));
        add(new Status("q4", 'ε', "REFUSE"));
    }};

    public static LinkedList<Status> toWhere(String from, char way, int index) {
        LinkedList<Status> temp = new LinkedList<>();
        LinkedList<Status> queue = new LinkedList<>();
        list.forEach(u->{
            if (u.from.equals(from) && way == u.way&&!"REFUSE".equals(u.to)) {
                queue.add(new Status(u.from,u.way,u.to));
            }
        });
        while (!queue.isEmpty()) {
            Status cur = queue.pollFirst();
            temp.add(cur);
            list.forEach(u->{
                if (u.from.equals(cur.to) && u.way == 'ε' && !"REFUSE".equals(u.to)) {
                    queue.add(new Status(u.from,u.way,u.to));
                }
            });
        }
        if (temp.isEmpty())return temp; //用于防止打印无效处理
        System.out.println("***当前处理第"+(index+1)+"个字符***");
        System.out.println(temp);
        return temp;
    }

    public static void processed(String str){
        LinkedList<Status> toList = toWhere(BEGIN_STATUS,str.charAt(0),0);
        for (int i=1;i<str.length();i++) {
            LinkedList<Status> temp = new LinkedList<>();
            while (!toList.isEmpty()) {
                Status cur = toList.pollFirst();
                temp.addAll(toWhere(cur.to, str.charAt(i),i));
            }
            if (temp.isEmpty()){
                System.out.println("***当前处理第"+(i+1)+"个字符");
                System.out.println("自动机识别字符 '"+str.charAt(i)+"' 不合法,字符串被拒绝");
                return;
            }
            toList.addAll(temp);
        }
        List<String> result = toList.stream().map(u -> u.to).collect(Collectors.toList());
        if (result.contains(END_STATUS)) {
            System.out.println("***当前字符串处理完毕***");
            System.out.println("处于自动机终止状态"+END_STATUS+" 字符串被接受");
        }else {
            System.out.println("***当前字符串处理完毕***");
            System.out.println("字符串未包含终止状态被拒绝");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = null;
        while(!(str=sc.nextLine()).equals("exit")){
            processed(str);
        }
        System.out.println("bye");
    }
}