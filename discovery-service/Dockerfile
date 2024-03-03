FROM openjdk:17 as builder
WORKDIR discovery
ADD target/*.jar app.jar
RUN java -Djarmode=layertools -jar app.jar extract

FROM openjdk:17
WORKDIR discovery-service
COPY --from=builder discovery/dependencies/ ./
COPY --from=builder discovery/spring-boot-loader/ ./
COPY --from=builder discovery/snapshot-dependencies/ ./
COPY --from=builder discovery/application/ ./
ENTRYPOINT ["java","org.springframework.boot.loader.JarLauncher"]