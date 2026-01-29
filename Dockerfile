#LABEL authors="MacoAntonioReyesdelA"

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

# Copiamos el JAR generado en el Stage 1
COPY --from=build /workspace/target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
