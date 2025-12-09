# Running apps
In folder `./devops` a file `secret.properties` with secret data is located - outside of the repository. 
The apps have no secret configurations by default.
The apps must be provided with this file to build proper final configuration to run.

Way of using ./devops/secret.properties
Ms Windows
```
java -jar producer --spring.config.additional-location=file:/{FOLDER_PATH}/secret.properties
java -jar listener --spring.active.profiles=even --spring.config.additional-location=file:/{FOLDER_PATH}/secret.properties
java -jar listener --spring.active.profiles=odd --spring.config.additional-location=file:/{FOLDER_PATH}/secret.properties
java -jar listener --spring.active.profiles=all --spring.config.additional-location=file:/{FOLDER_PATH}/secret.properties
```

# Links
* https://medium.com/@ravinduperera1229/rabbitmq-with-spring-boot-1935ed42da6a
