package dataStructures.lruCache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    //Kopie der Package-privaten Definition aus der Klasse HashMap
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final boolean USE_ACCESS_ORDER = true;

    private final int maxCapacity;

    public LruLinkedHashMap(final int capacity) {
        // Um die Eigenschaft accessOrder anzugeben müssen die Werte die nicht
        // spezifiziert werden sollen an den super-Konstruktor übergeben werden
        super(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR, USE_ACCESS_ORDER);
        this.maxCapacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxCapacity;
    }
}
