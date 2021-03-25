package x.godk.collection.list;

import java.util.Arrays;

/**
 * @author wt
 * @program practice
 * @create 2020-05-29  13:54
 */
public class ArrayList<E> implements List<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private static final Object[] EMPTY_ELEMENTDATA = {};
    /**
     * The maximum size of array to allocate.
     * Some VMs reserve some header words in an array.
     * Attempts to allocate larger arrays may result in
     * OutOfMemoryError: Requested array size exceeds VM limit
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    /**
     * 默认空容量
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    /**
     * 添加的元素 放置在该数组中
     */
    transient Object[] elementData;

    /**
     * 数组内元素个数
     */
    private int size;

    /**
     * 无参构造
     */
    public ArrayList() {
        this.elementData = EMPTY_ELEMENTDATA;
    }

    /**
     * 有参构造
     *
     * @param initialCapacity 初始化 数组容量
     */
    public ArrayList(int initialCapacity) {
        //TODO 有参构造
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E element) {
        // 容量检测，如果不够那么增长
        //ensureCapacityInternal(elementData,size+1);

        // 数组长度
        int length = elementData.length;

        if (length < size + 1) {
            // 需要增长
            grow(size + 1);
        }
        //添加
        elementData[size++] = element;
        return true;
    }


    /**
     * 增长 数组长度
     *
     * @param minCapacity
     */
    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = elementData.length + (oldCapacity >> 1);
        // 最新的 是否符合 最小容量要求
        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        }
        // 是否超出最大
        if (newCapacity > MAX_ARRAY_SIZE) {
            // 此处有一个 校验 minCapacity 为负  抛出异常
            newCapacity = MAX_ARRAY_SIZE;
        }
        // 数组复制成 newCapacity 长度
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    @Override
    public E remove(E element) {


        return null;
    }

    @Override
    public E get(int index) {
        return (E) elementData[index];
    }

    @Override
    public void remove(int index) {
//        if(index < size && index >-1){
//          Object[] newElementData =   new Object[elementData.length -1];
//            for(int i = 0 ; i < size; i++){
//                if(i < index){
//                    newElementData[i] = elementData[index];
//                }else{
//                    newElementData[i] = elementData[i+1];
//                }
//            }
//            size--;
//            elementData = newElementData;
//        }else{
//            throw new IndexOutOfBoundsException();
//        }
    }
}
