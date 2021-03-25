package x.godk.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 集合 类   计划实现  List  Set
 *
 * @author wt
 * @program practice
 * @create 2020-05-29  11:43
 * @see Set
 * @see List
 * @see Map
 * @see SortedSet
 * @see SortedMap
 * @see HashSet
 * @see TreeSet
 * @see ArrayList
 * @see LinkedList
 * @see Vector
 * @see Collections
 * @see Arrays
 * @see AbstractCollection
 */
public interface Collection<E> {


    /**
     * 元素个数
     *
     * @return
     */
    int size();


    /**
     * add element
     *
     * @param element
     * @return
     */
    boolean add(E element);

    /**
     * 移除
     *
     * @param element
     * @return
     */
    E remove(E element);


    /**
     * 查询
     *
     * @param index
     * @return
     */
    E get(int index);


}
