FROM openjdk:17 as builder
WORKDIR product
ADD target/*.jar app.jar
RUN java -Djarmode=layertools -jar app.jar extract

FROM openjdk:17
WORKDIR inventory-s
COPY --from=builder inventory/dependencies/ ./
COPY --from=builder inventory/spring-boot-loader/ ./
COPY --from=builder inventory/snapshot-dependencies/ ./
COPY --from=builder inventory/application/ ./
ENTRYPOINT ["java","org.springframework.boot.loader.JarLauncher"]