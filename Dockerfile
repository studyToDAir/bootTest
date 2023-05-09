FROM gradle:latest as builder

WORKDIR /build

COPY build.gradle settings.gradle /build/
COPY . /build

RUN gradle build -x test --parallel --continue > /dev/null 2>&1 || true

FROM openjdk:17-slim

WORKDIR /app

COPY --from=builder /build/build/libs/*.war app.war

EXPOSE 8080

USER nobody
ENTRYPOINT ["java", "-jar", "-Djava.security.egd=file:/dev/./urandom", "-Dsun.net.inetaddr.ttl=0", "app.war"]
