package lt.codeacademy.generic.Tasks.ThirdTask;

import java.util.ArrayList;
import java.util.List;

public class Mapas<K, V> {

    private final List<Pora<K, V>> poros;

    public Mapas() {
        this.poros = new ArrayList<>();
    }

    public void add(K key, V value) {
        poros.add(new Pora<>(key, value));
    }

    public V get(K key) {
        return poros.stream()
                .filter(p -> p.getKey().equals(key))
                .findFirst()
                .map(Pora::getValue)
                .orElse(null);
    }
}
