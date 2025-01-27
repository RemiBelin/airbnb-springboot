FROM openjdk:14
MAINTAINER Alexander Lukyanchikov <sqshq@sqshq.com>

ADD ./target/airbnb-service-rb.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/airbnb-service-rb.jar"]

EXPOSE 6000