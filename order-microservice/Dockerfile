FROM openjdk:17 as builder
WORKDIR orderService
ADD target/*.jar app.jar
RUN java -Djarmode=layertools -jar app.jar extract

FROM openjdk:17
WORKDIR order-service
COPY --from=builder orderService/dependencies/ ./
COPY --from=builder orderService/spring-boot-loader/ ./
COPY --from=builder orderService/snapshot-dependencies/ ./
COPY --from=builder orderService/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]
