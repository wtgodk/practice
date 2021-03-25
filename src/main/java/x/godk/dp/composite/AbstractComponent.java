package x.godk.dp.composite;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author wt
 * @program practice
 * @create 2020-06-11  15:42
 */
@Data
public abstract class AbstractComponent implements Component {
    /**
     * 唯一标识
     */
    private String name;
    /**
     * 子节点 存储
     */
    private List<Component> componentList = new ArrayList<>();

    public AbstractComponent(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractComponent)) {
            return false;
        }
        AbstractComponent that = (AbstractComponent) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public void display() {
        List<Component> componentList = getComponentList();
        componentList.forEach(x -> {
            AbstractComponent component = (AbstractComponent) x;
            List<Component> componentList1 = component.getComponentList();
            componentList1.forEach(Component::display);
        });
    }
}
