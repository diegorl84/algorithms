package principles;

import lombok.Setter;
import org.junit.Assert;
import org.junit.Test;
import principles.util.Room;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
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

    @Test
    public void quickTest(){
//        List<Room> rooms = Room.getTestList().stream().sorted().collect(Collectors.toList());
//        System.out.println(rooms);
        Approval approval = new Approval();
        approval.setApprovalType("FAST_CASH");

        Claim claim = new Claim();
        claim.setApprovals(new HashSet<>());
        claim.getApprovals().add(approval);

        Optional<String> approvalDto = claim.getApprovals().stream()
                .filter(a -> a.getApprovalType().equals("FAST_CASH"))
                .findFirst()
                .map(a -> Optional.of(a.getApprovalType()))
                .orElse(Optional.empty());


//        approvalDto.map(s -> Integer.valueOf(s)).orElseThrow(() ->)


    }

    class Claim{

        public Approval getFastcashApproval() {
            return fastcashApproval;
        }

        public void setFastcashApproval(Approval fastcashApproval) {
            this.fastcashApproval = fastcashApproval;
        }

        Approval fastcashApproval;
        public Set<Approval> getApprovals() {
            return approvals;
        }

        public void setApprovals(Set<Approval> approvals) {
            this.approvals = approvals;
        }

        Set<Approval> approvals;
    }
    class Approval {
        public String getApprovalType() {
            return approvalType;
        }

        public void setApprovalType(String approvalType) {
            this.approvalType = approvalType;
        }

        String approvalType;
    }
    enum MyEnum {
        ENUM_1("A"),
        ENUM_2("B");

        private String name;

        private static final Map<String,MyEnum> ENUM_MAP;

        MyEnum (String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        // Build an immutable map of String name to enum pairs.
        // Any Map impl can be used.

        static {
            Map<String,MyEnum> map = new ConcurrentHashMap<>();
            for (MyEnum instance : MyEnum.values()) {
                map.put(instance.getName().toLowerCase(),instance);
            }
            ENUM_MAP = Collections.unmodifiableMap(map);
        }

        public static MyEnum get (String name) {
            return ENUM_MAP.get(name.toLowerCase());
        }
    }
}
