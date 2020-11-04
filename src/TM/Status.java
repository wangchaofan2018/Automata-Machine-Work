package TM;

/**
 * Created by wangchaofan on 2020/11/2.
 */
public class Status {
    public String curStatus;
    public char curChar;
    public char writeChar;
    public char moveDirection;
    public String newStatus;

    public Status(String curStatus, char curChar, char writeChar, char moveDirection, String newStatus) {
        this.curStatus = curStatus;
        this.curChar = curChar;
        this.writeChar = writeChar;
        this.moveDirection = moveDirection;
        this.newStatus = newStatus;
    }

//    public static class Builder {
//        public String curStatus;
//        public char curChar;
//        public char writeChar;
//        public char moveDirection;
//        public String newStatus;
//
//
//        public Builder setCurStatus(String curStatus) {
//            this.curStatus = curStatus;
//            return this;
//        }
//
//        public Builder setCurChar(char curChar) {
//            this.curChar = curChar;
//            return this;
//        }
//
//        public Builder setWriteChar(char writeChar) {
//            this.writeChar = writeChar;
//            return this;
//        }
//
//        public Builder setMoveDirection(char moveDirection) {
//            this.moveDirection = moveDirection;
//            return this;
//        }
//
//        public Builder setNewStatus(String newStatus) {
//            this.newStatus = newStatus;
//            return this;
//        }
//
//        public Status build()  {
//            if (curStatus == null || newStatus == null || curChar == 0 || writeChar == 0 || moveDirection == 0 || curStatus.equals("") || newStatus.equals("")) {
//                System.out.println("初始化失败 请检查参数是否正确");
//            } else {
//                return new Status(curStatus, curChar, writeChar, moveDirection, newStatus);
//            }
//            return null;
//        }
//}
    @Override
    public String toString() {
        return "当前状态：" + curStatus + " 当前操作字符：" + curChar + " 替换字符为：" + writeChar + " 移动方向：" + moveDirection + " 新状态：" + newStatus;
    }


}
