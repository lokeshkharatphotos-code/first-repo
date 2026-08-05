import java.util.LinkedList;

class HashTable {
    private int size;
    private LinkedList<Integer>[] table;

    // Constructor
    public HashTable(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Hash function
    private int hash(int key) {
        return key % size;
    }

    // Insert key
    public void insert(int key) {
        int index = hash(key);
        table[index].add(key);
    }

    // Search key
    public boolean search(int key) {
        int index = hash(key);
        return table[index].contains(key);
    }

    // Delete key
    public void delete(int key) {
        int index = hash(key);
        table[index].remove(Integer.valueOf(key));
    }

    // Display hash table
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + ": ");
            for (int val : table[i]) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    // Driver code
    public static void main(String[] args) {
        HashTable ht = new HashTable(7);

        ht.insert(10);
        ht.insert(20);
        ht.insert(15);
        ht.insert(7);

        ht.display();

        System.out.println("Search 15: " + ht.search(15));
        ht.delete(15);
        System.out.println("Search 15 after deletion: " + ht.search(15));
    }
}
