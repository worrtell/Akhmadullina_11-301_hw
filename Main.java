package sem2.hw2;

public class Main {
    public static void main(String[] args) {
        OrderedList<Integer> list = new OrderedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(1);
        list.add(0);
        list.add(-10);
        list.print();
        list.delete(0);
        list.print();
    }
}
