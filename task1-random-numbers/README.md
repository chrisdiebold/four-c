# Task 1: Random Numbers CLI

Write a java application that creates a file containing N random numbers on separate lines. N should be passed as a parameter to the application, as well as a path to the file that should be generated. The supplied file may be overwritten by the application. 

# Build Instructions
1. Clone the repository
```bash
git clone 
```
2. Build and package the application for production
```bash
gradle jar 
```
3. Run the application
```bash

java -jar .\app\build\libs\app.jar -n 100

# OR
java -jar .\app\build\libs\app.jar -n 100 -f "C:\\Users\\Chris\\code\\fourc-coding-assessment\\random.txt"
```
# Notes
It took longer to package the Jar into an executable Jar than it did to write the code.

This was fun. I have not written a CLI type application in Java in many years. My goto for CLI apps is go. 

Creating the manifest gave me some trouble. This command is helpful to see what the manifest is in the JAR.
`jar -tf JAR_NAME.jar`

Fallback if cannot make executable
`java -cp "picocli-4.6.3.jar:checksum.jar"`

Sample Args:
`
String[] a1 = { "--number=100"};
String[] a2 = {"--number=10", "--file=C:\\Users\\Chris\\code\\fourc-coding-assessment\\random.txt"};
`
