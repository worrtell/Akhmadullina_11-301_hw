package sem2.hw2;

public class OrderedList<T extends Comparable<T>>  {
    Node<T> head;
    Node<T> tail;
    OrderedList() {
        head = new Node<>();
        tail = new Node<>();
    }
    public void add(T value) {
        Node<T> n = new Node<>(value);
        if (head.value == null) {
            tail = head = n;
        }
        else {
            boolean flag = false;
            Node<T> cur = head;
            if (n.value.compareTo(head.value) <= 0) {
                head.prev = n;
                n.next = head;
                head = head.prev;
                flag = true;
            }
            while (!flag) {
                if (n.value.compareTo(cur.value) > 0) {
                    // 1. больше последнего элемента
                    if (cur.next == null) {
                        cur.next = n;
                        n.prev = cur;
                        tail = n;
                        flag = true;
                    }
                    // 2. больше cur и дальше не конец -> двигаемся дальше
                    else {
                        cur = cur.next;
                    }
                }
                else {
                    cur.prev.next = n;
                    n.next = cur;
                    n.prev = cur.prev;
                    cur.prev = n;
                    flag = true;
                }
            }
        }
    }

    public void delete(T a) {
        Node<T> n = new Node<>(a);
        Node<T> cur = head;
        boolean flag = false;

        if (cur.value.compareTo(n.value) == 0) {
            head = n;
        }
        else {
            while (cur.next != null) {
                if (cur.value.compareTo(n.value) == 0) {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                    cur.next = cur.prev = null;
                    flag = true;
                }
                else {
                    cur = cur.next;
                }
            }
            if (!flag && cur.value.compareTo(n.value) == 0) {
                cur.prev.next = null;
            }
        }
    }

    public void print() {
        Node<T> cur = head;
        while (cur.next != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println(cur.value);
    }
}
