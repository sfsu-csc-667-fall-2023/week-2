package sourceIO.lexing.lines;

import sourceIO.dao.KeyValuePair;

public class SimpleSourceLine implements ISourceLine<String> {

  private String line;

  public SimpleSourceLine(String line) {
    this.line = line;
  }

  @Override
  public KeyValuePair<String> inputToKeyValuePair() {
    int index = this.getFirstSpaceIndex();

    String key = this.line.substring(0, index);
    String value = this.line.substring(index).trim();

    return new KeyValuePair<String>(key, value);
  }

  private int getFirstSpaceIndex() {
    char[] characters = this.line.toCharArray();

    for (int index = 0; index < characters.length; index++) {
      if (Character.isWhitespace(characters[index])) {
        return index;
      }
    }

    return -1;
  }

}
