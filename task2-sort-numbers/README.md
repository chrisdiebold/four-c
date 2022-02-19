# Task 2: Sort Numbers CLI
Write a simple java program that accepts a path to a file containing numbers on separate lines and  optionally a string saying “desc” or “asc”. The application should print the numbers sorted according  to the second parameter or ascending if no such parameter is provided. The result should print to the console where the application was started from. 

Constraints:
1. You may assume that all numbers in the provided file may be represented by a Java long. 
2. It is also safe to assume that all the numbers in the file may be stored in memory. 
3. Any line containing anything that is not a number should be ignored. 


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
# Update your file name with your own
java -jar .\app\build\libs\app.jar --file=C:/Users/Chris/code/fourc-coding-assessment/task1-random-numbers/random-numbers.txt --asc
```

# Notes
This program is more in a functional style than object-oriented. 

Sample args to test with:
` 
String[] f = {"--file=C:/Users/Chris/code/fourc-coding-assessment/task1-random-numbers/random-numbers.txt", "--desc"};
`