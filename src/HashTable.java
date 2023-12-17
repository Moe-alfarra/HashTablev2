public class HashTable {

    String[] table;
    byte[] locationStatus; // -1:removed; 0:empty; 1:occupied
    int tableSize;
    int length; // number of elements currently stored in the hash table

    public HashTable() {
        tableSize = 5;
        table = new String[tableSize];
        locationStatus = new byte[tableSize];

        for (int i = 0; i < tableSize; i++) {
            table[i] = "";
            locationStatus[i] = 0;
        }
        length = 0;
    }

    public HashTable(int size) {
        tableSize = size;
        table = new String[tableSize];
        locationStatus = new byte[tableSize];

        for (int i = 0; i < tableSize; i++) {
            table[i] = "";
            locationStatus[i] = 0;
        }
        length = 0;
    }

    public int hash(String key) {
        int hashVal = 0;

        for (int i = 0; i < key.length(); i++) {
            hashVal = 37 * hashVal + key.charAt(i);
        }

        hashVal %= tableSize;

        if (hashVal < 0) {
            hashVal += tableSize;
        }

        return hashVal;
    }

    public void add(String str) {
        if (length == tableSize) {
            System.out.println("Table is full!");
        }
        else {
            int hashVal = hash(str);
            while (locationStatus[hashVal] == 1) {
                hashVal = (hashVal + 1) % tableSize;
            }

            table[hashVal] = str;
            locationStatus[hashVal] = 1;
            length++;
        }
    }

    public boolean search(String str) {
        int hashVal = hash(str);

        int count = 0;
        boolean stop = false;

        while(!stop) {
            if ((count == tableSize) || table[hashVal].equals(str) && locationStatus[hashVal] == 1 || locationStatus[hashVal] == 0) {
                stop = true;
            }
            else {
                hashVal = (hashVal + 1) % tableSize;
                count++;
            }
        }
        return (table[hashVal].equals(str) && locationStatus[hashVal] == 1);
    }

    public void remove(String str) {
        int hashVal = hash(str);

        int count = 0;
        boolean stop = false;
        while (!stop) {
            if ((count == tableSize) || table[hashVal].equals(str) && locationStatus[hashVal] == 1 || locationStatus[hashVal] == 0) {
                stop = true;
            }
            else {
                hashVal = (hashVal + 1) % tableSize;
                count++;
            }
        }
        if (table[hashVal].equals(str) && locationStatus[hashVal] == 1) {
            locationStatus[hashVal] = -1;
            length--;
        }
        else {
            System.out.println("Not Found!");
        }
    }

    public void print() {
        for (int i = 0; i < tableSize; i++) {
            System.out.println(i + " " + table[i] + " " + locationStatus[i] + " " + hash(table[i]));
        }
    }


}
