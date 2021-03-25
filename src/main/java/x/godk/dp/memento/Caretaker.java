package x.godk.dp.memento;

import lombok.Getter;
import lombok.Setter;

/**
 * 备忘管理者 可以设置备忘，但是无法更改备忘
 *
 * @author wt
 * @program practice
 * @create 2020-06-11  13:59
 */
@Setter
@Getter
public class Caretaker {


    private Memento memento;


}
