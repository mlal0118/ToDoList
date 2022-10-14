FROM eclipse-temurin:17
WORKDIR app
COPY target/*.jar ToDoList-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "ToDoList-0.0.1-SNAPSHOT.jar"]
