package sourceIO.lexing;

import sourceIO.dao.KeyValuePairCollection;
import sourceIO.lexing.lines.SimpleSourceLine;
import sourceIO.readers.IReader;

public class KeyValuePairLexer implements IKeyValuePairLexer<String> {
  private IReader source;

  public KeyValuePairLexer(IReader reader) {
    this.source = reader;
  }

  @Override
  public KeyValuePairCollection<String> lex() {
    KeyValuePairCollection<String> collection = new KeyValuePairCollection<>();

    while (this.source.hasNext()) {
      collection.insert(
          new SimpleSourceLine().stringToKeyValuePair(this.source.next()));
    }

    return collection;
  }

}
