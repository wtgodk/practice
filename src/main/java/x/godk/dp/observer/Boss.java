package x.godk.dp.observer;


import lombok.Getter;
import lombok.Setter;

/**
 * boss 是一个通知者
 *
 * @author wt
 * @program practice
 * @create 2020-06-09  13:57
 */
@Setter
@Getter
public class Boss extends Informer {

    /**
     * 通知者  name
     */
    private String name;


    public Boss(String action) {
        super(action);
        this.name = "Boss";
    }


}
