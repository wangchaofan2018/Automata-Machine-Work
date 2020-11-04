package TM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by wangchaofan on 2020/11/2.
 */
public class TM {
    static final String START_STATUS = "start";
    static final String ACCEPT_STATUS = "accept";
    static List<Status> list = new ArrayList<Status>() {{
        add(new Status("start", '#', '#', 'R', "q0"));
        add(new Status("q0", 'O', 'O', 'R', "q0"));
        add(new Status("q0", '+', '+', 'R', "q1"));
        add(new Status("q1", 'O', 'O', 'R', "q1"));
        add(new Status("q1", '=', '=', 'R', "q2"));
        add(new Status("q2", 'O', 'O', 'R', "q2"));
        add(new Status("q2", ' ', ' ', 'L', "q9"));
        add(new Status("q9", '+', '+', 'L', "q9"));
        add(new Status("q9", 'O', 'O', 'L', "q9"));
        add(new Status("q9", '=', '=', 'L', "q9"));
        add(new Status("q9", 'X', 'X', 'L', "q9"));
        add(new Status("q9", ' ', ' ', 'L', "q9"));
        add(new Status("q9", '#', '#', 'H', "q3"));
        add(new Status("q3", '#', '#', 'R', "q4"));
        add(new Status("q4", 'X', 'X', 'R', "q4"));
        add(new Status("q4", '+', '+', 'R', "q4"));
        add(new Status("q4", 'O', 'X', 'R', "q5"));
        add(new Status("q4", '=', '=', 'R', "q6"));
        add(new Status("q6", 'X', 'X', 'R', "q6"));
        add(new Status("q6", ' ', ' ', 'H', "accept"));
        add(new Status("q5", 'O', 'O', 'R', "q5"));
        add(new Status("q5", '+', '+', 'R', "q5"));
        add(new Status("q5", '=', '=', 'R', "q7"));
        add(new Status("q7", 'X', 'X', 'R', "q7"));
        add(new Status("q7", 'O', 'X', 'R', "q9"));
//        //图灵机接受 不停机
//        add(new Status("accept", ' ', ' ', 'H', "accept"));

    }};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String raw = sc.nextLine();
        if (raw==null||raw.equals("")) return;
        char w = raw.charAt(0);
        raw = raw.replace(w+"","O");
        String str = "#" + raw;
        String curStatus = START_STATUS;
        List<Character> tape = new String(str.toCharArray()).chars().mapToObj(u -> (char) u).collect(Collectors.toList());
        tape.add(' ');
        int index = 0;
        while (true) {
            Status status = changeToNewStatus(curStatus, tape.get(index));
            if (status == null) {
                System.out.println("字符串被拒绝 最后状态位置为 " + curStatus);
                return;
            } else {
                System.out.println(status);
            }
            tape.set(index, status.writeChar);
            index = status.moveDirection == 'L' ? index - 1 : status.moveDirection == 'R' ? index + 1 : index;
            curStatus = status.newStatus;
            if (status.newStatus == ACCEPT_STATUS) {
                System.out.println("字符串被接受");
                return;
            }
        }
    }

    public static Status changeToNewStatus(String curStatus,char curChar) {
        for (Status u : list) {
            if (curStatus.equals(u.curStatus) && curChar == u.curChar) {
                return u;
            }
        }
        return null;
    }
}
