package x.godk.basis;

/**
 * @author wt
 * @program practice
 * @create 2021-02-03  11:43
 */
public class StudyStatic {
    //静态对象
    public static char text = 'a';

    static {                         //静态块
        System.out.println(text);
    }

    {                              //构造块
        System.out.println('b');
    }

    //构造函数
    public StudyStatic() {
        System.out.println('c');
    }

}
