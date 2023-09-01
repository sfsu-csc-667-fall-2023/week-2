package sourceIO.lexing;

import sourceIO.dao.KeyValuePairCollection;
import sourceIO.readers.IReader;

public class KeyValuePairLexer<T> implements IKeyValuePairLexer<T> {
  private IReader reader;

  public KeyValuePairLexer(IReader reader) {
    this.reader = reader;
  }

  public KeyValuePairCollection<T> lex() {
    KeyValuePairCollection<T> collection = new KeyValuePairCollection<>();

    while (this.reader.hasNext()) {
      String line = this.reader.next();

    }

    return collection;
  }

}
