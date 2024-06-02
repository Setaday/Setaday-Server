FROM amd64/amazoncorretto:21-alpine AS jar

ARG JAR_FILE=/build/libs/room-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} room.jar

# 컨테이너 실행 시 Java 애플리케이션 실행
ENTRYPOINT ["java", "-Duser.timezone=Asia/Seoul", "-jar", "room.jar"]