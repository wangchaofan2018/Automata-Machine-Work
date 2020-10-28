package NFA;

/**
 * Created by wangchaofan on 2020/10/13.
 */
public class Status {
    public String from;
    public char way;
    public String to;

    public Status(String from, char way, String to) {
        this.from = from;
        this.way = way;
        this.to = to;
    }
    @Override
    public String toString(){
        return "自动机识别字符' "+way+" '，执行状态转移 "+from+"==>>"+to;
    }
}
