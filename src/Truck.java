
public class Truck extends Vehicle{
  public Truck() {
    System.out.println("Vroom  ");
  }  
  public void drop() {  System.out.println("Squish  "); }
  public static void main(String[] args) {
    Truck a = new Truck();
    a.drop();

  }

}
