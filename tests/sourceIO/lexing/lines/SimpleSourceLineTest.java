package tests.sourceIO.lexing.lines;

import org.junit.jupiter.api.Test;

import sourceIO.dao.KeyValuePair;
import sourceIO.lexing.lines.SimpleSourceLine;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleSourceLineTest {

  @Test
  public void testInputToKeyValuePair() {
    String prefix = "hello", suffix = "world";
    String line = String.format("%s   %s", prefix, suffix);

    SimpleSourceLine simpleSourceLine = new SimpleSourceLine(line);
    KeyValuePair<String> keyValuePair = simpleSourceLine.inputToKeyValuePair();

    assertEquals(prefix, keyValuePair.getKey());
    assertEquals(suffix, keyValuePair.getValue());
  }

  @Test
  public void testInputToKeyValuePairWithSpaces() {
    String prefix = "hello", suffix = "world other word here";
    String line = String.format("%s   %s", prefix, suffix);

    SimpleSourceLine simpleSourceLine = new SimpleSourceLine(line);
    KeyValuePair<String> keyValuePair = simpleSourceLine.inputToKeyValuePair();

    assertEquals(prefix, keyValuePair.getKey());
    assertEquals(suffix, keyValuePair.getValue());
  }
}
