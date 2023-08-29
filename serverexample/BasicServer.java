package serverexample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class BasicServer {
  public static void main(String[] args) throws IOException {
    BasicServer server = new BasicServer();
    server.start();
  }

  public void start() throws IOException {
    ServerSocket listener = new ServerSocket(9877);

    while (true) {
      Socket socket = listener.accept();

      String request = this.read(socket);
      this.respond(socket, request);

      socket.close();
    }
  }

  private String read(Socket socket) throws IOException {
    BufferedReader reader = new BufferedReader(
        new InputStreamReader(socket.getInputStream()));

    return reader.readLine();
  }

  private void respond(Socket socket, String requestMessage) throws IOException {
    PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

    writer.write("------------------------\n");
    writer.write("You sent the message: \n");
    writer.write(requestMessage + "\n");
    writer.write("------------------------\n");

  }

}
