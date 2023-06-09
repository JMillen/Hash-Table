public class StrHashTable {
    
    Node[] strHashTable;
    int size;
    
    double LOAD_FACTOR_MAX = 0.75;

    public StrHashTable(int s){
        size = s;
        strHashTable = new Node[size];
    }

    /*
     * Inserts a key/value pair into the hash table.
     */
    public void insert(String k, String v){

        int index = hashFunction(k);
        strHashTable[index] = new Node(k,v);
        size++;
        checkForRehash(); 
    }

    /*
     * Deletes a key/value pair from the hash table, from given key.
     */
    public void delete(String k){
        int index = hashFunction(k);
        if(strHashTable[index] != null && strHashTable[index].key.equals(k)){
            strHashTable[index] = null;
            size--;
        }
    }

    /*
     * Calculates the hash code for a given string using
     * the folding with string method
     */
    public int hashFunction(String k){
        int hash = 0;
        for(int i = 0; i < k.length(); i++){
            hash += k.charAt(i);
        }
        return hash % strHashTable.length;
    }

    public void rehash(){
        
        size = size * 2;
        Node[] newHashTable = new Node[size]; //Creates a new hash table with new size

        for(Node node : strHashTable){
            if(node != null){
                int newIndex = hashFunction(node.key);
                newHashTable[newIndex] = node;
            }
        }
        strHashTable = newHashTable; // Update the hash table to the new version
    }

    /*
     * Checks if rehashing is needed
     * If the load factor has exceeded, rehashing will begin
     */
    public void checkForRehash(){
        double loadFactor = (double) size / strHashTable.length;
        if(loadFactor > LOAD_FACTOR_MAX){
            rehash();
        }
    }

    /*
     * Checks for key in the 420 table.
     */
    public boolean contains(String k){
        int index = hashFunction(k);
        return strHashTable[index] != null && strHashTable[index].key.equals(k);
    }
    
    /*
     * Returns the item in the hash table,
     * given the key k
     */
    public String get(String k){
        int index = hashFunction(k); //get the index of the key
        if(strHashTable[index] != null && strHashTable[index].key.equals(k)){
            return strHashTable[index].value;
        }
        return null;
    }

    /*
     * Checks if the hash table is empty
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /*
     * Gets the number of items stored in the hash table
     */
    public int size(){
        return size;
    }

    /*
     * Prints the entire hash table
     * format: index: key, value
     */
    public void dump(){
        for(int i = 0; i < strHashTable.length; i++){
            if(strHashTable[i] != null){
                System.out.println(i + ": " + strHashTable[i].key + ", " + strHashTable[i].value);
            }
        }
    }
}
