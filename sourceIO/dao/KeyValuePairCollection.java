package sourceIO.dao;

import java.util.HashMap;
import java.util.Map;

public class KeyValuePairCollection<T> {
  private Map<String, KeyValuePair<T>> keyValues;

  public KeyValuePairCollection() {
    this.keyValues = new HashMap<>();
  }

  public void insert(KeyValuePair<T> keyValue) {
    this.keyValues.put(keyValue.getKey(), keyValue);
  }

  public KeyValuePair<T> get(String key) {
    return this.keyValues.get(key);
  }
}
