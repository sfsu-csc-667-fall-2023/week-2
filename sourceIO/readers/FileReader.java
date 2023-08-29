package sourceIO.readers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReader implements IReader {
  private List<String> contents;
  private int index;

  public FileReader(String path) {
    this.index = 0;

    try {
      this.contents = Files.readAllLines(Path.of(path));
    } catch (IOException e) {
      this.contents = new ArrayList<String>();
    }
  }

  @Override
  public void close() throws Exception {
    // Intentional no-op
  }

  @Override
  public boolean hasNext() {
    return this.index < this.contents.size();
  }

  @Override
  public String next() {
    if (this.index >= this.contents.size()) {
      return "";
    }

    return this.contents.get(index++);
  }

}
