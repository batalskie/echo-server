# Echo-Server

Write an echo server using the Java networking API described in Section 3.6.1. This server will wait for a client connection using the accept() method. When a client connection is received, the server will loop, performing the following steps:

->>Read data from the socket into a buffer.

->>Write the contents of the buffer back to the client.

->>The server will break out of the loop only when it has determined that the client has closed the connection.

The date server shown in Figure 3.21 uses the java.io.BufferedReader class. BufferedReader extends the java.io.Reader class, which is used for reading character streams. However, the echo server cannot guarantee that it will read characters from clients; it may receive binary data as well. The class java.io.InputStream deals with data at the byte level rather than the character level. Thus, your echo server must use an object that extends java.io.InputStream. The read() method in the java.io.InputStream class returns −1 when the client has closed its end of the socket connection.
