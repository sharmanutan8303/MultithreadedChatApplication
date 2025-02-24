# MultithreadedChatApplication

# Project Architecture:
1.	Server Module:
•	Accept Client Connections: The server runs continuously, accepting new client connections using a ServerSocket.
•	Multithreading: Each client connection is managed by a separate thread (ServerThread), enabling multiple users to connect simultaneously.
•	Broadcast Messages: Messages from one client are sent to all other connected clients using the server's threadList.
•	Error Handling: Properly handle exceptions and ensure smooth disconnection of clients.
2.	Client Module:
-	Connect to Server: The client connects to the server using a Socket.
-	Send and Receive Messages: The client can send messages to the server and receive broadcast messages from other clients.
-	ClientThread for Listening: A ClientThread continuously listens for incoming messages from the server.
  
# Technologies Used:
-	Programming Language: Java
-	Networking: Java Sockets (ServerSocket, Socket) -Multithreading: Thread, Runnable interface
-	User Interface (Optional): Console-based or Swing GUI for better interaction
  
# Core Components:
1.	Server Code:
-	Accepts new client connections.
-	Creates a new thread (ServerThread) for each client.
-	Manages active clients in a synchronized list (threadList).
-	Broadcasts messages to all connected clients.
2.	ServerThread Code:
-	Handles individual client communication.
-	Reads input from the client and forwards it to the server for broadcasting.
-	Manages client disconnection and resource cleanup.
3.	Client Code:
-	Connects to the server using a Socket.
-	Sends messages to the server via PrintWriter.
-	Receives messages from the server through a BufferedReader.
-	Utilizes a separate thread (ClientThread) to listen for server messages asynchronously.
  
# Deliverable:
A fully functional chat application featuring a server and multiple clients communicating in real-time, showcasing robust multithreading, efficient resource management, and smooth client handling.

