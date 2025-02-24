import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Automatically closes Socket and Scanner using try-with-resources
        try (Socket socket = new Socket("localhost", 5000);
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            String userInput;
            String clientName = "empty";

            // Start the client runnable in a new thread
            ClientRunnable clientRun = new ClientRunnable(socket);
            new Thread(clientRun).start();

            // Main communication loop
            do {
                if (clientName.equals("empty")) {
                    System.out.println("Enter your name: ");
                    userInput = scanner.nextLine();
                    clientName = userInput;
                    output.println(userInput);
                    if (userInput.equalsIgnoreCase("exit")) {
                        break;
                    }
                } else {
                    String message = "(" + clientName + ")" + " message: ";
                    System.out.println(message);
                    userInput = scanner.nextLine();
                    output.println(message + " " + userInput);
                    if (userInput.equalsIgnoreCase("exit")) {
                        break;
                    }
                }
            } while (!userInput.equalsIgnoreCase("exit"));

        } catch (Exception e) {
            System.out.println("Error occurred in main:");
            e.printStackTrace();
        }
    }
}
