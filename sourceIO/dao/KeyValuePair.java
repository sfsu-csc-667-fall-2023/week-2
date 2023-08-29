package sourceIO.dao;

public class KeyValuePair<T> {
  private String key;
  private T value;

  public KeyValuePair(String key, T value) {
    this.key = key;
    this.value = value;
  }

  public String getKey() {
    return this.key;
  }

  public T getValue() {
    return this.value;
  }
}
