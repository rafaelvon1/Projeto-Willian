# Usa imagem do Java 17
FROM openjdk:17-jdk-slim

# Cria um diretório no container
WORKDIR /app

# Copia o projeto compilado (ajuste o caminho se necessário)
COPY ./out/artifacts/seu_jar_aqui.jar app.jar

# Expõe a porta que seu app usa (ex: 1234)
EXPOSE 1234

# Comando para rodar o projeto
CMD ["java", "-jar", "app.jar"]
# Para rodar o container, use o seguinte comando: