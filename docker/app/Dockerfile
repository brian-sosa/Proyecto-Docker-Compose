# Usar una imagen base de OpenJDK para compilar y ejecutar Java
FROM openjdk:17-jdk-slim

# Crear un directorio de trabajo para la app
WORKDIR /app

# Descargar el controlador JDBC de PostgreSQL
RUN apt-get update && apt-get install -y curl && \
    curl -o postgresql.jar https://jdbc.postgresql.org/download/postgresql-42.5.4.jar && \
    apt-get clean && rm -rf /var/lib/apt/lists/*

# Copiar el código fuente de la app
COPY ClientApp.java .

# Compilar el código fuente
RUN javac -cp postgresql.jar ClientApp.java

# Ejecutar la app
CMD ["java", "-cp", ".:postgresql.jar", "ClientApp"]

