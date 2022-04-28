package lt.codeacademy.generic;

public class PairComperator {
    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2){
        return p1.getValue().equals(p2.getValue());
    }
}
