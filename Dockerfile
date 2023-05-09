# APP
FROM openjdk:11.0-slim

WORKDIR /app

# 빌더 이미지에서 jar 파일만 복사한다
COPY build/libs/*.war /app/app.war

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.war"]
