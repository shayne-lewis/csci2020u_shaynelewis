import java.io.*;
import java.net.*;

public class HttpServer {
	
	private ServerSocket serverSocket = null;
	private int port;

    public HttpServer(int port) throws IOException {
	  serverSocket = new ServerSocket(port);
	  this.port = port;
    }
	
	public void handleRequests() throws IOException{
		System.out.println("Listening to port: "+port);
		
		// creating a thread to handle each of the clients
		while(true){
			Socket clientSocket = serverSocket.accept();
			HttpServerHandler handler = new HttpServerHandler(clientSocket);
			Thread handlerThread = new Thread(handler);
			handlerThread.start();
		}
		
	}	
	
	
	
	public static void main(String[] args) {
    int port = 8080;
	// port to listen default 8080, or the port from the argument
    if (args.length > 0) {
      port = Integer.parseInt(args[0]);
    }

    try {
	  //Instantiating the HttpServer Class
      HttpServer server = new HttpServer(port);
	  // handle any requests from the port
      server.handleRequests();
	  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}