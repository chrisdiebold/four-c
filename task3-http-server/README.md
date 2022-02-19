# Task 3: Http Server
Write a java application that acts as a very simple HTTP server. The HTTP server should have support for doing a simple HTTP GET. That is, sending a command like

GET /path1/path2/myfile.html 

on the configured TCP/IP port should give the requested file in the response. If not found, an appropriate error code should be returned as a HTTP header field. 


Note:
That the ambition is not to create a full-fledged HTTP server, but to highlight a couple of important programming concepts. 

The server must be able to handle:
1. A reasonable amount of simultaneous requests. At least 10 parallel requests must be
   managed. By parallel we are satisfied with parallel threads. Please identify the pattern used
   for implementing this.
2. The server should be able to handle very large files without requiring that the amount of
   available RAM is matched.
3. When starting the server application, the desired port number should be supplied as a
   parameter.
4. When starting the server application, the desired document root path should be supplied as
   a parameter. The document root is the root for the server, meaning that a request:
   GET /kalle.html will assume that the file kalle.html is located in that root folder. 


Tips:
1. You will want to use a ServerSocket.
2. A thread pool might come in handy. What support is there in Java for one of those?


# Notes
I have never done this exercise in Java before. This was more difficult than I thought it would be.


`         
String[] a = {"--port=8085", "--root=C:/Users/Chris/code/fourc-coding-assessment/task3-http-server/app/src/main/resources"};
`
Unfortunately, you will have to build through Intellij. 

There are 2 main methods:
1. APP - with CLI - does not allow the request to finish
2. Main - cannot set custom things... localhost:8082 - but does handle multiple connections and shows a dummy response.