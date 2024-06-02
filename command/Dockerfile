FROM amd64/amazoncorretto:21-alpine AS jar

ARG JAR_FILE=/build/libs/command-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} command.jar

# 컨테이너 실행 시 Java 애플리케이션 실행
ENTRYPOINT ["java", "-Duser.timezone=Asia/Seoul", "-jar", "command.jar"]