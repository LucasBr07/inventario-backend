# ====== BUILD ======
FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app

# copia tudo
COPY . .

# gera o jar
RUN mvn clean package -DskipTests

# ====== RUN ======
FROM eclipse-temurin:17-jdk

WORKDIR /app

# copia o jar gerado
COPY --from=build /app/target/*.jar app.jar

# porta (Render usa variável PORT)
ENV PORT=8080
EXPOSE 8080

# roda o app
ENTRYPOINT ["java","-jar","app.jar"]