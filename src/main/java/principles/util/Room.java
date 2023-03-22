package principles.util;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Room implements Comparable<Room>{
    private Integer roomId;
    private int value;
    private int startDate;
    private int endDate;

    public static List<Room> getTestList(){
        List<Room> listOfRooms = new ArrayList<>();
        listOfRooms.add(Room.builder().roomId(1).value(100).build());
        listOfRooms.add(Room.builder().roomId(1).value(50).build());
        listOfRooms.add(Room.builder().roomId(1).value(80).build());
        listOfRooms.add(Room.builder().roomId(2).value(20).build());
        listOfRooms.add(Room.builder().roomId(2).value(40).build());
        return listOfRooms;
    }

    @Override
    public int compareTo(Room o) {
       return (this.getRoomId() < o.getRoomId()) ? -1 : ((this.getRoomId() == getRoomId()) ? 0 : 1);
    }
}
