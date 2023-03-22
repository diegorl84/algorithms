package principles;

import java.util.HashMap;
import java.util.Map;

final public class InmutableStudent {
  private final String name;
  private final int regNo;
  private final Map<String, String> metaData;

  private final Address address;

  public InmutableStudent(String name, int regNo, Map<String, String> metaData, Address address){
    this.name = name;
    this.regNo = regNo;
    Map<String, String> tempMap = new HashMap<>();
    for (Map.Entry<String, String> entry: metaData.entrySet() ){
      tempMap.put(entry.getKey(), entry.getValue());
    }
    this.metaData = tempMap;
    this.address = address;
  }

  public String getName(){
    return name;
  }

  public int getRegNo(){
    return regNo;
  }
  public Address getAddress() throws CloneNotSupportedException{
    return (Address) address.clone();
  }

  public Map<String, String> getMetaData(){
    Map<String, String> tempMap = new HashMap<>();
    for (Map.Entry<String, String> entry : this.metaData.entrySet()){
      tempMap.put(entry.getKey(), entry.getValue());
    }
    return tempMap;
  }
  public static void main(String arg[]) throws CloneNotSupportedException
  {
    Address address = new Address();
    address.setCity("Chandigarh");
    address.setState("Chandigarh");
    address.setCode(12345);

    Map<String, String> tempMap = new HashMap<>();
    tempMap.put("oneKey", "oneValue");

    InmutableStudent student = new InmutableStudent("Diego", 1, tempMap , address);
    System.out.println("Before modification: "+ student.getAddress().getCode());
    student.getAddress().setCode(55555);
    System.out.println("After modification: "+ student.getAddress().getCode());
  }
}

class Address implements Cloneable{
  private String city;
  private String State;
  private int code;
  public String getCity() {
    return city;
  }
  public void setCity(String city) {
    this.city = city;
  }
  public String getState() {
    return State;
  }
  public void setState(String state) {
    State = state;
  }
  public int getCode() {
    return code;
  }
  public void setCode(int code) {
    this.code = code;
  }

  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}
