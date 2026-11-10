# ==========================================
# Stage 1: Build source code bằng Maven
# ==========================================
FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app

# Copy pom.xml và tải trước dependencies (giúp tận dụng Docker cache)
COPY pom.xml .
RUN mvn dependency:go-offline -B || true

# Copy toàn bộ mã nguồn và đóng gói WAR
COPY src ./src
RUN mvn clean package -DskipTests

# ==========================================
# Stage 2: Chạy ứng dụng trên Tomcat 10
# ==========================================
FROM tomcat:10.1-jdk21-temurin

# Xóa các webapp mặc định của Tomcat (ROOT, docs, examples...)
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy file war đã build vào làm ROOT.war để web chạy ngay tại root context ("/")
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

# Render cung cấp cổng qua biến môi trường $PORT (mặc định nếu chạy local là 8080)
ENV PORT=8080
EXPOSE 8080

# Cấu hình đổi port trong server.xml theo $PORT của Render và khởi động Tomcat
CMD ["sh", "-c", "sed -i \"s/port=\\\"8080\\\"/port=\\\"${PORT:-8080}\\\"/g\" /usr/local/tomcat/conf/server.xml && exec catalina.sh run"]

