package sourceIO.lexing.lines;

import sourceIO.dao.KeyValuePair;

public class SimpleSourceLine implements ISourceLine<String> {

  @Override
  public KeyValuePair<String> stringToKeyValuePair(String sourceLine) {
    int spaceIndex = this.getFirstSpaceIndex(sourceLine);

    String key = sourceLine.substring(0, spaceIndex);
    String value = sourceLine.substring(spaceIndex).trim();

    return new KeyValuePair<String>(key, value);
  }

  private int getFirstSpaceIndex(String sourceLine) {
    for (int index = 0; index < sourceLine.length(); index++) {
      if (Character.isWhitespace(sourceLine.charAt(index)) && !sourceLine.equals("\n")) {
        return index;
      }
    }

    return sourceLine.length();
  }
}
