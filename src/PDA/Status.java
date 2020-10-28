package PDA;

public class Status {

    //当前状态
    public String oldStatus;
    //当前操作字符
    public char curChar;
    //转移后状态
    public String newStatus;
    //即将入栈元素
    public char pushInStackItem;
    //当前栈顶元素
    public char stackTopItem;

    public Status(String oldStatus, char curChar, String newStatus, char pushInStackItem, char stackTopItem) {
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;
        this.curChar = curChar;
        this.stackTopItem = stackTopItem;
        this.pushInStackItem = pushInStackItem;
    }

    @Override
    public String toString() {
        return "状态转移如下{" +
                "当前状态：'" + oldStatus + '\'' +
                "识别字符：'" + curChar +
                "' 新状态：'" + newStatus + '\'' +
                ", 新栈顶元素：" + pushInStackItem +
                ", 当前栈顶元素：" + stackTopItem +
                '}';
    }
}
