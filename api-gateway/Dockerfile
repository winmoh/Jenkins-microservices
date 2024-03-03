FROM openjdk:17 as builder
WORKDIR gateway
ADD target/*.jar app.jar
RUN java -Djarmode=layertools -jar app.jar extract

FROM openjdk:17
WORKDIR gateway-service
COPY --from=builder gateway/dependencies/ ./
COPY --from=builder gateway/spring-boot-loader/ ./
COPY --from=builder gateway/snapshot-dependencies/ ./
COPY --from=builder gateway/application/ ./
ENTRYPOINT ["java","org.springframework.boot.loader.JarLauncher"]