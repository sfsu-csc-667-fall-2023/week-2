package sourceIO.dao;

import java.util.HashMap;
import java.util.Map;

public class KeyValuePairCollection<T> {
  private Map<String, T> map;

  public KeyValuePairCollection() {
    this.map = new HashMap<>();
  }

  public void insert(KeyValuePair<T> kvp) {
    this.map.put(kvp.getKey(), kvp.getValue());
  }

  public T get(String key) {
    return this.get(key);
  }
}
