package tests.sourceIO.readers;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

import sourceIO.readers.FileReader;

public class FileReaderTest {
  // 0. FileReader exists
  @Test
  public void testFileReaderExistence() {
    FileReader reader = new FileReader("");
  }

  // 1. hasNext returns true when file has lines
  @Test
  public void testHasNextReturnsTrueWhenFileHasLines() throws IOException {
    Path path = Files.createTempFile(null, null);

    Files.write(path, "Key1 Value1\nKey2 Value2\n".getBytes());

    FileReader reader = new FileReader(path.toString());
    assertTrue(reader.hasNext());
  }

  // 2. hasNext returns false when file is empty
  @Test
  public void testHasNextReturnsFalseWhenFileIsEmpty() throws IOException {
    Path path = Files.createTempFile(null, null);

    FileReader reader = new FileReader(path.toString());
    assertFalse(reader.hasNext());
  }

  // 3. hasNext returns false when at end of file
  @Test
  public void testHasNextReturnsFalseWhenAtEOF() throws IOException {
    Path path = Files.createTempFile(null, null);

    Files.write(path, "Key1 Value1\nKey2 Value2\n".getBytes());

    FileReader reader = new FileReader(path.toString());
    reader.next();
    reader.next();

    assertFalse(reader.hasNext());
  }

  // 4. next returns the next line (1st call should return first line, etc.)
  @Test
  public void testNextReturnsNextLine() throws IOException {
    Path path = Files.createTempFile(null, null);

    String lineOne = "Key1 Value1";
    String lineTwo = "Key2 Value2";

    Files.write(
        path, String.format(
            "%s\n%s\n", lineOne, lineTwo).getBytes());

    FileReader reader = new FileReader(path.toString());

    assertEquals(lineOne, reader.next());
    assertEquals(lineTwo, reader.next());
  }

  // 5. next returns empty string when at end of file
  @Test
  public void testNextReturnsEmptyStringAtEOF() throws IOException {
    Path path = Files.createTempFile(null, null);

    String lineOne = "Key1 Value1";
    String lineTwo = "Key2 Value2";

    Files.write(
        path, String.format(
            "%s\n%s\n", lineOne, lineTwo).getBytes());

    FileReader reader = new FileReader(path.toString());
    reader.next();
    reader.next();

    assertEquals("", reader.next());
  }

  // 6. next returns empty string when file is empty
  @Test
  public void testNextReturnsEmptyStringWhenFileIsEmpty() throws IOException {
    Path path = Files.createTempFile(null, null);

    FileReader reader = new FileReader(path.toString());

    assertEquals("", reader.next());
  }
}
