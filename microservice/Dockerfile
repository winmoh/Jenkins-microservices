FROM openjdk:17 as builder
WORKDIR product
ADD target/*.jar app.jar
RUN java -Djarmode=layertools -jar app.jar extract

FROM openjdk:17
WORKDIR product-service
COPY --from=builder product/dependencies/ ./
COPY --from=builder product/spring-boot-loader/ ./
COPY --from=builder product/snapshot-dependencies/ ./
COPY --from=builder product/application/ ./
ENTRYPOINT ["java","org.springframework.boot.loader.JarLauncher"]