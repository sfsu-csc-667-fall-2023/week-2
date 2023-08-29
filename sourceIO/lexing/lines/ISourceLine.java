package sourceIO.lexing.lines;

import sourceIO.dao.KeyValuePair;

public interface ISourceLine<T> {
  public KeyValuePair<T> stringToKeyValuePair(String sourceLine);
}
