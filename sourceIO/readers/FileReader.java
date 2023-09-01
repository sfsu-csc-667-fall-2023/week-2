package sourceIO.readers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader implements IReader {

  private List<String> lines;
  private int index;

  public FileReader(String path) {
    this.index = 0;

    try {
      this.lines = Files.readAllLines(Paths.get(path));
    } catch (IOException e) {
      this.lines = new ArrayList<>();
    }
  }

  @Override
  public void close() throws Exception {
    // no-op
  }

  @Override
  public boolean hasNext() {
    return this.index < this.lines.size();
  }

  @Override
  public String next() {
    if (!this.hasNext()) {
      return "";
    }

    return this.lines.get(this.index++);
  }

}
