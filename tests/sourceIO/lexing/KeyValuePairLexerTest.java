package tests.sourceIO.lexing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import sourceIO.dao.KeyValuePairCollection;
import sourceIO.lexing.KeyValuePairLexer;
import sourceIO.readers.IReader;

public class KeyValuePairLexerTest {
  @Test
  public void testExistence() {
    KeyValuePairLexer lexer = new KeyValuePairLexer(new IReader() {

      @Override
      public void close() throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'close'");
      }

      @Override
      public boolean hasNext() {
        throw new UnsupportedOperationException("Unimplemented method 'hasNext'");
      }

      @Override
      public String next() {
        throw new UnsupportedOperationException("Unimplemented method 'next'");
      }

    });
  }

  @Test
  public void testLex() {
    String[][] testValues = {
        { "key1", "value1" },
        { "key2", "value2" }
    };

    KeyValuePairLexer lexer = new KeyValuePairLexer(new IReader() {
      private int index = 0;

      @Override
      public void close() throws Exception {
      }

      @Override
      public boolean hasNext() {
        return this.index < 2;
      }

      @Override
      public String next() {
        if (this.index < 2) {
          return String.join(" ", testValues[this.index++]);
        } else {
          return null;
        }
      }

    });

    KeyValuePairCollection<String> pairs = lexer.lex();

    assertEquals(testValues[0][1], pairs.get(testValues[0][0]).getValue());
    assertEquals(testValues[1][1], pairs.get(testValues[1][0]).getValue());
    assertEquals(null, pairs.get(""));
  }
}
