package sourceIO.lexing;

import sourceIO.dao.KeyValuePairCollection;

public interface IKeyValuePairLexer<T> {
  public KeyValuePairCollection<T> lex();
}
