# Wildlife Tracker
Application allowing rangers to track wildlife sightings in an area in consideration of a proposal by a timber company to clearcut the forest of all Douglas Fir. This application shows resulting environmental impact of the activities.


## Technologies used
- Java 11
- sql2o
- Java Spark
- JUnit 5
- HandleBars Templating Engine
- Gradle build tools

## Installation
To run the application locally:

1. Clone or download the repo.
2. Navigate to the cloned directory.
3. Execute command - gradle build - to fetch all the required dependencies.
4. Navigate to `src/main/java/App.java` file.
5. Edit `mysql` variable url and insert in `{}` your : `"jdbc:postgresql://localhost:3306/{database name}", "{user}", "{password}"`
6. Execute command - gradle run - to launch the project.
7. Navigate to - http://localhost:4567 - in your browser.
