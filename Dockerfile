# Imagem base com JDK 17
FROM openjdk:17-jdk-alpine

RUN mkdir /app

# Diretório de trabalho
WORKDIR /app

# Copiar o arquivo JAR gerado
COPY target/*.jar /app/app.jar

CMD ["java", "-jar", "app.jar"]


# Expor a porta da aplicação
EXPOSE 8090

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
