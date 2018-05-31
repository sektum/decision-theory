docker build -t titap .
docker run -p 8080:8080 titap mvn jetty:run