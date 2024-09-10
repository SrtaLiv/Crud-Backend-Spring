# Usa una imagen base con OpenJDK
FROM openjdk:17-jdk-slim

# Define una variable de entorno para el archivo JAR
ARG JAR_FILE=target/crud-0.0.1.jar

# Copia el archivo JAR al contenedor
COPY ${JAR_FILE} app_crud.jar

# Expone el puerto 8080
EXPOSE 8080

# Define el comando de entrada para ejecutar el JAR
ENTRYPOINT ["java", "-jar", "app_crud.jar"]
