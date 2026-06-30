# Usamos una imagen que YA trae Java 21 y Maven instalados de fábrica
FROM maven:3.9-eclipse-temurin-21

# Definimos dónde trabajaremos
WORKDIR /app

# Copiamos el archivo de configuración y el código
COPY pom.xml .
COPY src ./src

# Compilamos el código Java usando 'mvn' (que ya viene en la imagen)
RUN mvn clean package -DskipTests

# Exponemos el puerto
EXPOSE 8080

# Ejecutamos el .jar
CMD ["java", "-jar", "target/inventario-0.0.1-SNAPSHOT.jar"]