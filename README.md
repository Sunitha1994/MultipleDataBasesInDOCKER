Spring Boot on Docker connecting to MySQL and Postgres Docker containers docker-compose : Compose is a tool for defining and running multi-container Docker applications.

In My use case i need to connect my Service with two Databases . So I need to Define Myservice along those Two databases which i needed within the docker-compose.yml. after defining the services that make up your app in docker-compose.yml so they can be run together in an isolated environment. Lastly, run docker-compose up and Compose will start and run your entire app.

docker-compose.yml looks like this:

mysql: container_name: mysql image: "mysql:5.6" environment: MYSQL_ROOT_PASSWORD: root MYSQL_DATABASE: test volumes: - ./mysql/init.sql:/docker-entrypoint-initdb.d/init.sql - ./mysql/scripts:/workspace/scripts/create.sql ports: - "3306:3306"

postgres: container_name: postgres image: postgres environment: POSTGRES_USER: postgres POSTGRES_PASSWORD: root1 volumes: - ./PostgresDB/init.sql:/docker-entrypoint-initdb.d/init.sql ports: - "5432:5432"

application: image: customers-image:latest ports: - "8086:8086" links: - postgres - mysql

For more information about the Compose file, see the Compose file reference

Compose has commands for managing the whole lifecycle of your application:

Start, stop and rebuild services View the status of running services Stream the log output of running services Run a one-off command on a service Installation and documentation

Full documentation is available on Docker's website.
