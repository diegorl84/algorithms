package principles;

import org.junit.Test;
import principles.util.ArrayUtil;
import principles.util.Room;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * Collection interface
 * - size()
 * - iterator()
 * - add()
 * - remove()
 * - clear
 * - replaceAll()
 *
 *
 * List: Ordered (get(index)), duplicates. remove/replace based on index. Sub-List using index
 *  - ArrayList:
 *      - Dynamic array
 *      - Permits null
 *      - Better for storing and accessing data
 *      - Manipulating takes more time
 *
 *  - LinkedList
 *      - Double linked list
 *      - Permits null
 *      - Manipulating takes less time
 *      - Implements List and Deque.
 *      - getLast, getFirst
 *      - removeLast, removeFirst
 *
 * Set: No duplicates, Not random access (no get()), only iterator and foreach
 *  - HashSet:
 *      - Permits null element
 *      - No guarantee order
 *      - Backed by HashMap, offers constant time performance
 *
 *  - TreeSet:
 *      - Ordered natural or by Comparator
 *      - log(n) for basic operations
 *
 *  - LinkedHashSet
 * Queue: Provides insertion, extraction and inspection. Typically (not always) order elements in a FIFO
 *  - PriorityQueue
 *
 * Dequeue: Double-ended-queue
 *
 * Map (Not inherit from Collection but it same package). (K,V): put(), get(), containsKey(), containsValue(), size(), isEmpty()
 *  - HashMap: Internally it creates a table (linkedList) of type Node that implements Map.Entry
 *      - Creates hashCode() from key
 *      - With that hashCode it will do hashing() and module operator to (0, 15) to get the index where data will be storaged in table
 *      - How collision works? If linkedList has objects in do foreach equals keys. if so, value is replaced, otherwise, attached to the linkedList when find null. T
 *                              - Travers all the elements in the linkedLink
 *                              - From java 8, when threshold is reach, 8 node, LinkedList is converted to balance tree. Change O(n) to O log(n)
 *      - null:null, hasCode = 0
 *      - It LOCKS the complete hashtable when adding/updating
 *
 *  - LinkedHashMap: - List in bucket is linkedList
 *      - Extends HashMap
 *      - Maintain the insertion order. When traversing it will keep orden of insertion
 *      - It adds beforeNode, and afterNode in the Entry
 *      - Adds heads and tail to save first Entry and Last Entry
 *
 *   - TreeMap: Structure is based on BST, get(idx) is O(n log n)
 *
 *
 *
 *
 *  - ConcurrentHashMap: - Do hashCode and hashing(), then it will LOCK only the resulting NODE of hashing.
 *                          This improves performance as new addings from other hashing codes
 *  - ConcurrentLinkedQueue: Queue
 *
 *  - ConcurrentSkipListMap: TreeMap: ConcurrentMap, SortedMap, NavigableMap
 *  - ConcurrentSkipListSet: TreeSet, SortedSet, NavigableSet
 *  - CopyOnWriteArrayList: Copy all the elements toa new structure when add(), modify() or remove() methods are called. Any iterator established prior to a
 *                          modification will not see the changes, but instead it will iterate over the original elements prior to the modification.
 *                          Use a lot of memory
 *  - CopyOnWriteArraySet: Copy all the elements toa new structure when add(), modify() or remove() methods are called. Any iterator established prior to a
 *                         modification will not see the changes, but instead it will iterate over the original elements prior to the modification.
 *                         Use a lot of memory
 *
 *  - LinkedBlockingQueue:
 *
 */

public class CollectionsWorkshop {

    @Test
    public void treeMap(){
        TreeMap<String, Integer> map = new TreeMap<>();
    }

    @Test
    public void sortPrimitiveArrays(){
        int[] objectList = new int[]{2,3,8,2,0,4,7,3};
        Arrays.sort(objectList);
        System.out.println(Arrays.toString(objectList));


    }

    @Test
    public void sortPrimitive2DArrays(){
        int[][] primitiveList = new int[][] {
                {2, 3},
                {4, 8},
                {4, 5},
                {4, 7},
                {1, 2},
                {8, 4},
                {3, 9}
        };
        //Si se usan primitivos no existe comparable
        Arrays.sort(primitiveList,(a,b) -> Integer.compare(a[0],b[0]));
        ArrayUtil.traversePrimitive2DArray(primitiveList);

    }

    @Test
    public void sortObjectArrays(){
        Integer[] objectList = new Integer[]{2,3,8,2,0,4,7,3};
        Arrays.sort(objectList);
        System.out.println(Arrays.toString(objectList));

    }

    @Test
    public void sortStringArrays(){
        String[] objectList = new String[]{"flower","flow","flight"};
        Arrays.sort(objectList, Comparator.comparing(String::length));
        System.out.println(Arrays.toString(objectList));

    }

    @Test
    public void sortObject2DArrays(){
        Integer[][] objectList = new Integer[][] {
                {2, 3},
                {4, 8},
                {4, 5},
                {4, 7},
                {1, 2},
                {8, 4},
                {3, 9}
        };
        Arrays.sort(objectList, (a,b) -> Integer.compare(a[0],b[0]));
        ArrayUtil.traverse2DArray(objectList);

    }

    @Test
    public void sortList(){
        List<Integer> listOne = Arrays.asList(110,2,8,5,2,45,12,90);
        Collections.sort(listOne);
        System.out.println(listOne);

        Collections.sort(listOne, Collections.reverseOrder());
        System.out.println(listOne);
        //Organize time by first element
    }

    @Test
    public void sortListOfObjects(){
        List<Room> list = Room.getTestList();
        Collections.sort(list, Comparator.comparing(Room::getValue).reversed());
        System.out.println(list);
    }

    @Test
    public void createMapFromList(){
        List<Room> rooms = Room.getTestList();
        Map<Integer, List<Room>> mapOfRooms = rooms.stream().collect(Collectors.groupingBy(Room::getRoomId));
    }

}

