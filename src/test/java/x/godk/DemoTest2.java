package x.godk;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author wt
 * @program practice
 * @create 2021-03-19  19:47
 */
public class DemoTest2 {

    public static void main(String[] args) {
        String str = " /./aa/bb/../xy/./mn/./../hh/../";
        String result =  solution(str);
        System.out.print(result);
    }


    public static String solution(String str){
        LinkedList<String> list = new LinkedList();
        String tmp = "";
        for(int i=0;i<str.length()-1;i++){
            char c = str.charAt(i);
            if(c=='.' && str.charAt(i +1) =='.'){
                list.removeLast();
                i = i+2;
            }else if(c=='.'){
                i++;
            }else if(c == '/'){
                tmp+=c;
                list.addLast(tmp);
                tmp ="";
            }else{
                tmp+=c;
            }
        }
        if(tmp.length()>0){
            list.addLast(tmp);
        }

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        return sb.toString();

    }
}
