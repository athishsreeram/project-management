# Project Managment

## Tech Stack

1. Springboot
2. JPA
3. Hibernate
4. Spring Rest
5. Swagger
6. Hibernate Validation



## Build

```

git clone https://github.com/athishsreeram/project-management.git

```

Make sure you configure the mysql
https://github.com/athishsreeram/project-management/blob/master/src/main/resources/application.properties

```

mvn clean install

mvn spring-boot:run

```

## Test
http://localhost:8080/swagger-ui.html

## Postman Collection
https://raw.githubusercontent.com/athishsreeram/project-management/master/Project%20Mgt.postman_collection.json


## Linux

https://github.com/athishsreeram/project-management/blob/master/linux/parser.sh

## Output
![alt text](https://github.com/athishsreeram/project-management/blob/master/linout.png)


## Install Docker
```

brew install docker

```

## Docker  Build & Run

```
docker images

docker run -p 3307:3306  -d --name=docker-mysql --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=root" --env="MYSQL_DATABASE=test" mysql

docker build -t projectmgt-manual-build .

docker images

docker run -d --name projectmgt-manual-build --link docker-mysql:mysql -p 8080:8080 projectmgt-manual-build

```