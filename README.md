# eliminar

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/eliminar-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- RESTEasy Classic ([guide](https://quarkus.io/guides/resteasy)): REST endpoint framework implementing Jakarta REST and more

## Provided Code

### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)


    mkdir -p ~/proyectos/mi-app
    cp /mnt/c/Users/nhuancap/eliminar/target/eliminar-1.0.0-SNAPSHOT.jar . ->me ubico en la carpeta mi-app para copiar
    nano Dockerfile  (aqui copias la infromacion de dockerfile)
    docker build -t image-quarkus-user . -> Creo la imagen
    docker-compose up -d --build  ->para ejecutar el docker compose
#  WINDOWS
    para ingresar a windows:  cd /mnt/c/Users/nhuancap/eliminar

#  API LOCAL
    # En la raíz de tu proyecto Quarkus
    ./mvnw clean package
    docker build -t quarkus-image-user .
    docker run -d --name quarkus-container -p 9011:9012 quarkus-image-user

# POSTGREST DOCKER
    para ejecutar el Dockerfile:
    docker-compose up --build
    docker stop container-postgres docker rm container-postgres docker volume rm postgres-data docker run --name container-postgres -e POSTGRES_PASSWORD=admin -e POSTGRES_USER=postgres -e POSTGRES_DB=quarkus-db-sistema -p 5431:5432 -v postgres-data:/var/lib/postgresql/data -d postgres
    docker exec -it container-postgres psql -U postgres -c "\l"
    docker exec -it container-postgres psql -U postgres -d quarkus-db-sistema


