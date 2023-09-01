package sampleserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class BasicServer {
  public static void main(String[] args) {
    (new BasicServer()).start();
  }

  private void start() {
    try (ServerSocket serverSocket = new ServerSocket(9875)) {
      while (true) {
        this.listen(serverSocket);
      }
    } catch (IOException e) {
      System.err.println("Server failed to start.");
      System.exit(1);
    }
  }

  private void listen(ServerSocket serverSocket) {
    try (Socket socket = serverSocket.accept()) {
      this.readInboundMessage(socket);
      this.writeOutboundMessage(socket);
    } catch (IOException e) {
      System.err.println("Failed to accept connection.");
    }
  }

  private void readInboundMessage(Socket socket) {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
      String line;

      while (!(line = reader.readLine().trim()).equals("EOM")) {
        System.out.println(String.format("> %s", line));
      }
      System.out.println("----- End of Message -----");
    } catch (IOException e) {
      System.err.println("Could not read from connection.");
    }
  }

  private void writeOutboundMessage(Socket socket) {
    try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
      writer.write("Thanks\nEND");
    } catch (IOException e) {
      System.err.println("Failed to write to connection.");
    }
  }

}