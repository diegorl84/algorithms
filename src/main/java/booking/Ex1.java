package booking;

import java.util.*;
import java.util.stream.Collectors;

public class Ex1 {

    public static List<Price> recalculate(List<Price> prices){

        Map<Integer, List<Price>> pricesMap = new HashMap<>();

        pricesMap = prices.stream().collect(Collectors.groupingBy(Price::getRoomId));

        List<Price> result = new ArrayList<>();

        for (Map.Entry<Integer, List<Price>> entry : pricesMap.entrySet()){
            List<Price> sortedPrices = sortPrices(entry.getValue());

            Price currentPrice = sortedPrices.get(0);
            result.add(currentPrice);
            sortedPrices.remove(0);

            for(Price nextPrice : sortedPrices){
                if((nextPrice.getStartDate() - currentPrice.getEndDate()) == 1 && currentPrice.getValue() == nextPrice.getValue()){
                    currentPrice.setEndDate(Math.max(nextPrice.getEndDate(), currentPrice.getEndDate()));
                }else{
                    currentPrice = nextPrice;
                    result.add(currentPrice);
                }
            }
        }

        return result;
    }

    public static List<Price> sortPrices(List<Price> prices){
        return prices.stream().sorted(Comparator.comparing(Price::getStartDate)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Price price1 = new Price();
        price1.setRoomId(1);
        price1.setValue(3);
        price1.setStartDate(1);
        price1.setEndDate(6);

        Price price2 = new Price();
        price2.setRoomId(1);
        price2.setValue(3);
        price2.setStartDate(7);
        price2.setEndDate(10);

        Price price3 = new Price();
        price3.setRoomId(2);
        price3.setValue(4);
        price3.setStartDate(5);
        price3.setEndDate(7);

        Price price4 = new Price();
        price4.setRoomId(2);
        price4.setValue(4);
        price4.setStartDate(8);
        price4.setEndDate(10);

        Price price5 = new Price();
        price5.setRoomId(2);
        price5.setValue(1);
        price5.setStartDate(4);
        price5.setEndDate(4);

        List<Price> data = new ArrayList<>();
        data.add(price1);
        data.add(price2);
        data.add(price3);
        data.add(price4);
        data.add(price5);

        recalculate(data).stream().forEach(System.out::println);
    }
}
class Price{
    private int roomId;
    private int value;
    private int startDate;
    private int endDate;

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Price{" +
                "roomId=" + roomId +
                ", value=" + value +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}