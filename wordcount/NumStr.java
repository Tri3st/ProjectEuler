import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class NumStr {
    private int num;
    private String str;
    private int cnt;

    public NumStr(String st){
        this.cnt = countChars(st);
        Pattern p = Pattern.compile("^(\\d+)\\s{1}(\\D+)$");
        Matcher m = p.matcher(st);
        while(m.find()){
            this.num = Integer.parseInt(m.group(1));
            this.str = m.group(2);
        }
    }

    public int getCnt(){
        return this.cnt;
    }

    public int getNum(){
        return this.num;
    }

    public String getStr(){
        return this.str;
    }

    public void setStr(String s2){
        this.str = s2;
        this.cnt = countChars(this.str);
    }

    private int countChars(String s1){
        int cunt=0;
        for(int i=0; i<s1.length();i++){
            if(isChar(s1.charAt(i))) cunt++;
        }
        return cunt;
    }

    private boolean isChar(char c){
        return (((int) c>64 && (int)c<91) || ((int)c>96 && (int)c<123));
    }

    @Override
    public String toString(){
        return String.format("%d %s %d", this.num, this.str, this.cnt);
    }
}