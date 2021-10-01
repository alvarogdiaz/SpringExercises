# Commands used 

### Network
- docker network create net

### Postgres
- docker volume create postgres-volume
- docker run -d --name=postgres13 --net net -p 5432:5432 -v postgres-volume:/var/lib/postgresql/data -e POSTGRES_PASSWORD=[password] postgres

### Spring
- docker build -t spring .
- docker run -d --name=spring --net net -p 8081:8080 -e SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/postgres spring
