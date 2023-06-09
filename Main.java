public class Main{
    
    public static void main(String[] args){
        StrHashTable strHashTable = new StrHashTable(10);

        strHashTable.insert("Hello", "myPassword");
        strHashTable.insert("round", "myPass");
        strHashTable.insert("brown", "myPasswordss");

        strHashTable.dump();

    }
}
