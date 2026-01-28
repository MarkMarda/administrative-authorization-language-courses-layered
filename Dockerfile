#LABEL authors="MacoAntonioReyesdelA"

# # Stage 1: Build Stage
# FROM maven:3.9.12-eclipse-temurin-21 AS build
# WORKDIR /workspace
# COPY . .
# # Compilar solo el módulo boot y sus dependencias
# RUN mvn -pl administrative-autorization-language-courses-boot -am clean package -DskipTests
#
# # Stage 2: Final Stage (Usamos el JRE completo oficial)
# # Esta imagen ya incluye java.desktop, java.management, jgss, etc.
# FROM eclipse-temurin:21-jre-alpine
# WORKDIR /app
#
# # Copiamos el JAR generado en el Stage 1
# COPY --from=build /workspace/administrative-autorization-language-courses-boot/target/*.jar /app/app.jar
#
# # Exponer el puerto (opcional, informativo)
# EXPOSE 8081
#
# ENTRYPOINT ["java", "-jar", "/app/app.jar"]

# =========================
# Stage 1: Build
# =========================
FROM maven:3.9.12-eclipse-temurin-21 AS build
WORKDIR /workspace

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# =========================
# Stage 2: Runtime
# =========================
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

COPY --from=build /workspace/target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
