package Test.TM;

public class Side {
    private char word;//原来的字符;
    //private char Word2;//出栈字符;
    private char InWord;//要写的字符字符;
    private char Direction;//向左或者向右移动

    public Side(char word, char InWord,char Direction){
        this.word=word;
        //this.OutWord=OutWord;
        this.InWord=InWord;
        this.Direction=Direction;
    }

    public char getDirection() {
        return Direction;
    }

    public void setDirection(char direction) {
        Direction = direction;
    }

    public char getWord() {
        return word;
    }

    public void setWord(char word) {
        this.word = word;
    }

    /*public char getOutWord() {
        return OutWord;
    }*/

    /*public void setOutWord(char outWord) {
        OutWord = outWord;
    }*/

    public char getInWord() {
        return InWord;
    }

    public void setInWord(char inWord) {
        InWord = inWord;
    }
    public String shuchu(){
        return "边{" + "读到的字符" + word +",要写入覆盖的字符" + InWord +",下一次移动的方向"+Direction+ '}';
    }
}
