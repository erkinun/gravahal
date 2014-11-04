Installation 

1 - Make sure java is installed. Run java -version in a terminal to check. 

2 - Make sure gradle is installed, run gradle -version to check 

3 - To run just type the following to a terminal: gradle build && java -jar build/libs/gravahal-1.0.jar

4 - open up http://localhost:8080/start to start the game 

Important urls 

1 - /start -> starts a new game 

2 - /reset -> resets a new game 

3 - /metrics -> for metrics info

4 - /dump -> thread dumps

5 - /mappings -> shows a list of mappings between controllers

6 - /play -> post for new move, get for current play 

7 - /health -> shows the status for up/down 
 
 Notes 
 
 For quality the following have been implemented :
 
 1 - Gradle build tool is used, which enables the programmer with lost of plugins and a simple DSL to do much work
 
 2 - Spring Framework and Boot library, enables the project can be run without an application container 
 
 Boot library also has a lot of useful urls like, health, dump and metrics 
 
 3 - Checkstyle is used to ensure code quality in reading.
 
 4 - FindBugs is used to get rid of the possibilities of Heisenbugs 
 
 5 - Junit framework is used to enable unit testing. Domain package is tested heavilty. 
 
 6 - Jacoco library is used to find out about the code coverage. 