package sourceIO.lexing;

import sourceIO.dao.KeyValuePairCollection;
import sourceIO.lexing.lines.ISourceLine;
import sourceIO.lexing.lines.SimpleSourceLine;
import sourceIO.readers.IReader;

public class KeyValuePairLexer implements IKeyValuePairLexer<String> {
  private IReader reader;

  public KeyValuePairLexer(IReader reader) {
    this.reader = reader;
  }

  public KeyValuePairCollection<String> lex() {
    KeyValuePairCollection<String> collection = new KeyValuePairCollection<>();

    while (this.reader.hasNext()) {
      String line = this.reader.next();
      ISourceLine<String> sourceLine = new SimpleSourceLine(line);

      collection.insert(sourceLine.inputToKeyValuePair());
    }

    return collection;
  }

}
