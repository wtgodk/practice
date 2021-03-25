package x.godk.collection.list;

import x.godk.collection.Collection;

/**
 * List ,准备实现 ArrayList  LinkedList
 *
 * @author wt
 * @program practice
 * @create 2020-05-29  11:46
 */
public interface List<E> extends Collection<E> {
    /**
     * 元素个数
     *
     * @return
     */
    @Override
    int size();

    /**
     * 添加元素   追加
     *
     * @param element
     * @return
     */
    @Override
    boolean add(E element);

    /**
     * 移除
     *
     * @param element
     * @return
     */
    @Override
    E remove(E element);


    /**
     * 获取
     *
     * @param index
     * @return
     */
    @Override
    E get(int index);


    /**
     * 根据 索引移除
     *
     * @param index
     */
    void remove(int index);


}
