class hash {
    private static final int size = 10;
    private int[] hashtable;

    public hash() {
        hashtable = new int[size];
        for (int i = 0; i < size; i++) {
            hashtable[i] = -1;
        }
    }
    public int hash1(int key) {
        return key % size;
    }
    public int probe(int key) {
        int index = hash1(key);
        int i = 0;
        while (hashtable[(index + i) % size] != -1) {
            i++;
            if (i == size) {
                return -1;
            }
        }
        return (index + i) % size;
    }
    public void insert(int key) {
        int index = hash1(key);
        if (hashtable[index] == -1) {
            hashtable[index] = key;
            return;
        }
        int probeIndex = probe(key);
        if (probeIndex == -1) {
            System.out.println("Hash table is full!");
            return;
        }
        hashtable[probeIndex] = key;
    }
    public int search(int key) {
        int index = hash1(key);
        int i = 0;
        while (hashtable[(index + i) % size] != -1) {
            if (hashtable[(index + i) % size] == key) {
                return (index + i) % size;  // Key found
            }
            i++;
            if (i == size) {
                break;
            }
        }
        return -1;
    }
    public void display() {
        System.out.println("Hash Table:");
        for (int i = 0; i < size; i++) {
            if (hashtable[i] != -1) {
                System.out.println("Index " + i + ": " + hashtable[i]);
            } else {
                System.out.println("Index " + i + ": Empty");
            }
        }
    }
    public static void main(String[] args) {
        hash ht = new hash();
        ht.insert(5);
        ht.insert(15);  
        ht.insert(25); 
        ht.display();
        int searchKey = 15;
        int position = ht.search(searchKey);
        if (position != -1) {
            System.out.println("\nKey " + searchKey + " found at index: " + position);
        } else {
            System.out.println("\nKey " + searchKey + " not found");
        }
    }
}