package principles;

import org.junit.Assert;
import org.junit.Test;
import principles.util.Room;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args) {

    }

    @Test
    public void filter(){
        List<Integer> listOne = Arrays.asList(1,2,3,4,5,6,7);
        listOne.stream().filter(a -> a > 4).collect(Collectors.toList());
    }
    @Test
    public void CollectorJoin(){
        List<Integer> listOne = Arrays.asList(1,2,3,4,5,6,7);
        String resultWith = listOne.stream().map(a -> String.valueOf(a)).collect(Collectors.joining("-"));
        Assert.assertEquals("1-2-3-4-5-6-7", resultWith);
    }
    @Test
    public void CollectorGroupBy(){
        List<Integer> listOne = Arrays.asList(1,1,2,3,3,4,4,5,6,7);
        Map<Integer, Long> result = listOne.stream()
                .collect(Collectors.groupingBy(t-> t, Collectors.counting()));
        //
        Map<Integer, Long> usingFunctionIdentity = listOne.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(result);
    }

    @Test
    public void CollectorGroupByObjects(){
        Map<Integer, List<Room>> groupByRooms = Room.getTestList().stream().collect(Collectors.groupingBy(Room::getRoomId));
        System.out.println(groupByRooms);
    }

    @Test
    public void SortListObjects(){
        List<Room> rooms = Room.getTestList().stream().sorted(Comparator.comparing(Room::getRoomId)).collect(Collectors.toList());
        System.out.println(rooms);
    }

    @Test
    public void SortListObjectsImplementingComparable(){
        List<Room> rooms = Room.getTestList().stream().sorted().collect(Collectors.toList());
        System.out.println(rooms);
    }
}
