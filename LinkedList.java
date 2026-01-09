public class LinkedList {
    private Node first;
    private int size;

    /** Constructs an empty list. */
    public LinkedList() {
        this.first = null;
        this.size = 0;
    }

    /** Inserts the given element at the beginning of this list */
    public void addFirst(int elem) {
        Node newNode = new Node(elem);
        newNode.next = this.first;
        this.first = newNode;
        this.size++;
    }

    /** Inserts the given element at the end of this list */
    public void addLast(int elem) {
        Node cur = this.first;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Node(elem);
        this.size++;
    }

    /** Returns the first
     * location of the element in this list, or -1 is no such element. */
    public int indexOf(int e) {
        if (!this.contains(e)) {
            return -1;
        }
        return this.indexOf(e, this.first);
    }

    private int indexOf(int e, Node current) {
        if (current.data == e) {
            return 0;
        }
        return 1 + this.indexOf(e, current.next);
    }

    /** Returns the data at the specified position in this list. */
    public int getData(int index) {
        if (this.size == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        if (index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException("Illegal index " + index);
        }
        Node current = this.first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public boolean removeAtIndex(int index) {
        if (index < 0 || index >= this.size || this.first == null) {
            // Index out of bounds or list is empty
            return false;
        }

        if (index == 0) {
            this.first = this.first.next; // Remove first
            this.size--;
            return true;
        }
        // Traverse the list to find the node at the given index
        Node prev = null;
        Node current = this.first;
        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.next;
        }

        // Remove the node at the given index
        prev.next = current.next;
        this.size--; // Decrease the size of the list
        return true;
    }

    // Alternative solution for removeAtIndex
    public boolean removeAtIndex1(int index) {
        if (index < 0 || index >= this.size || this.first == null) {
            // Index out of bounds or list is empty
            return false;
        }

        if (index == 0) {
            this.first = this.first.next; // Remove first
            this.size--;
            return true;
        }
        // Traverse the list to find the node at the given index
        Node current = this.first;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        // Remove the node at the given index
        try {
            current.next = current.next.next;
        } catch (NullPointerException e) {
            current.next = null;
        }
        
        this.size--; // Decrease the size of the list
        return true;
    }

    public boolean contains(int e) {
        return this.contains(e, this.first);
    }

    private boolean contains(int e, Node current) {
        if (current == null) {
            return false;
        }
        if (current.data == e) {
            return true;
        }
        return this.contains(e, current.next);
    }

    public int[] toArray() {
        int[] arr = new int[this.size];
        Node cur = this.first;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = cur.data;
            cur = cur.next;
        }
        return arr;
    }

    public void add(int index, int e) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Illegal index " + index);
        }

        if (index == 0) {
            this.addFirst(e); // adds to first
            return;
        }

        if (index == this.size) {
            this.addLast(e); // adds to last
            return;
        }

        Node insert = new Node(e);
        Node prev = null;
        Node current = this.first;
        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.next;
        }
        prev.next = insert;
        insert.next = current;
        this.size++;
    }

    public LinkedList reverse() {
        Node cur = this.first;
        LinkedList rev = new LinkedList();
        while (cur != null) {
            rev.addFirst(cur.data);
            cur = cur.next;
        }
        return rev;
    }

    public LinkedList subList(int start, int end) {
        if (start < 0 || end >= this.size || start > end) {
            throw new IllegalArgumentException("Invalid parameters: start=" + start + ", end=" + end);
        }
        Node cur = this.first;
        LinkedList sub = new LinkedList();
        for (int i = 0; i < this.size; i++) {
            if (start <= i && i < end) {
                sub.addLast(cur.data);
            }
            cur = cur.next;
        }
        return sub;
    }

    public LinkedList subListEfficient(int start, int end) {
        if (start < 0 || end > this.size || start > end) {
            throw new IllegalArgumentException("Invalid parameters: start=" + start + ", end=" + end);
        }
        Node cur = this.first;
        LinkedList sub = new LinkedList();
        for (int i = 0; i < this.size; i++) {
            if (start <= i && i < end) {
                sub.addFirst(cur.data);
            }
            cur = cur.next;
        }
        return sub.reverse();
    }

}
