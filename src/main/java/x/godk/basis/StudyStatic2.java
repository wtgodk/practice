package x.godk.basis;

/**
 * @author wt
 * @program practice
 * @create 2021-02-03  11:44
 */
public class StudyStatic2 extends StudyStatic {
    public static String text2 = "a1";

    static {
        System.out.println(text2);
    }

    {
        System.out.println("b2");
    }

    public StudyStatic2() {
        System.out.println("c2");
    }

    public static void main(String[] args) {
        StudyStatic2 a = new StudyStatic2();

    }
}
