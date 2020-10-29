package PDA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PDA {

    /**
     * #代表空 %
     * 将(a/b/c)其中一个压入栈,当前栈顶为ε时,ε代表 (a/b/c)/ε .
     */
    private final static String ACCEPT_STATUS = "q7";
    static List<Status> list = new ArrayList<Status>() {{
        add(new Status("q1", '#', "q2", '$', '#'));
        add(new Status("q2", 'b', "q2", 'b', '#'));
        add(new Status("q2", 'c', "q3", '#', 'b'));
        add(new Status("q2", 'c', "q6", 'c', '#'));
        add(new Status("q2", 'a', "q4", '#', '#'));
        add(new Status("q2", '#', "q7", '#', '$'));
        add(new Status("q3", 'a', "q4", '#', '#'));
        add(new Status("q3", 'b', "q2", 'b', '#'));
        add(new Status("q3", 'c', "q3", '#', 'b'));
        add(new Status("q3", 'c', "q6", 'c', '#'));
        add(new Status("q3", '#', "q7", '#', '$'));
        add(new Status("q4", 'a', "q4", '#', '#'));
        add(new Status("q4", 'b', "q2", 'b', '#'));
        add(new Status("q4", 'b', "q5", '#', 'c'));
        add(new Status("q4", 'c', "q3", '#', 'b'));
        add(new Status("q4", 'c', "q6", 'c', '#'));
        add(new Status("q4", '#', "q7", '#', '$'));
        add(new Status("q5", 'a', "q4", '#', '#'));
        add(new Status("q5", 'b', "q2", 'b', '#'));
        add(new Status("q5", 'b', "q5", '#', 'c'));
        add(new Status("q5", 'c', "q6", 'c', '#'));
        add(new Status("q5", '#', "q7", '#', '$'));
        add(new Status("q6", 'a', "q4", '#', '#'));
        add(new Status("q6", 'b', "q5", '#', 'c'));
        add(new Status("q6", 'c', "q6", 'c', '#'));
        add(new Status("q6", '#', "q7", '#', '$'));
    }};

    public static Status getStatus(String curStatus, Character curChar, LinkedList<Character> stack) {
        if (stack.isEmpty()) {
            for (Status u : list) {
                if (u.oldStatus.equals(curStatus) && u.curChar == curChar && u.stackTopItem == '#') {
                    stack.push(u.pushInStackItem);
                    return u;
                }
            }
        } else if (stack.peek() == '$' || stack.peek() == curChar) {
            for (Status u : list) {
                if (u.oldStatus.equals(curStatus) && u.curChar == curChar && u.pushInStackItem == curChar) {
                    stack.push(u.pushInStackItem);
                    return u;
                }
            }
        } else {
            for (Status u : list) {
                if (u.oldStatus.equals(curStatus) && u.curChar == curChar && u.stackTopItem != curChar) {
                    if (u.stackTopItem != '#') {
                        if (stack.peek() == '$') {
                            return null;
                        } else {
                            stack.pop();
                        }

                    }
                    return u;
                }
            }
        }
        for (Status u : list) {
            if (u.oldStatus.equals(curStatus) && u.curChar == curChar && u.stackTopItem == '#' && u.pushInStackItem == '#') {
                return u;
            }
        }
        return null;

    }

    public static void processed(String str) {
        LinkedList<Character> stack = new LinkedList<>();
        String curStatus = "q1";
        str = "#" + str;
        for (int i = 0; i < str.length(); i++) {
            Character curChar = str.charAt(i);
            Status status = getStatus(curStatus, curChar, stack);
            if (status == null) {
                System.out.println("字符串非法 被拒绝!");
                return;
            } else {
                System.out.println(status);
            }
            curStatus = status.newStatus;
        }
        if (stack.size() > 1) {
            System.out.println("字符串不是终止状态 被拒绝！");
            return;
        }
        Status status = getStatus(curStatus, '#', stack);
        if (status.newStatus == ACCEPT_STATUS) {
            System.out.println("字符串被接受");
        } else {
            System.out.println("字符串不是终止状态 被拒绝！");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = null;
        while (!(str = sc.nextLine()).equals("exit")) {
            processed(str);
        }

    }
}
