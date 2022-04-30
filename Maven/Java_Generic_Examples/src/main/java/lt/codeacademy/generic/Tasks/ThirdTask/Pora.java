package lt.codeacademy.generic.Tasks.ThirdTask;

public class Pora <K, V> {
    private final K key;
    private final V value;

    public Pora(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
