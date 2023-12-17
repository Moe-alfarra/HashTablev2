public class Main {

    public static void main(String[] args) {

        String[] keyWords = {"abstract", "if", "else", "While", "this", "final", "void",
                "new", "break", "throws", "public", "private", "byte","extends","interface"};
        HashTable ht = new HashTable(keyWords.length);

        for (String s: keyWords) {
            ht.add(s);
        }
        ht.remove("else");
        ht.print();
        System.out.println(ht.search("interface"));
    }
}
