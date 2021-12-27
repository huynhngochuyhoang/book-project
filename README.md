# Book Store Application
A simple application using [Angular](https://angular.io/) and [Spring Microservices](https://spring.io/microservices) with [Spring Cloud Kubernetes](https://spring.io/projects/spring-cloud-kubernetes)
## Requirment tools:
- [JDK-11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html) or higher
- [Maven](https://maven.apache.org/download.cgi)
- [Node](https://nodejs.org/en/)
- [Angular CLI](https://angular.io/cli)
- [Docker](https://www.docker.com/)
- [Kubernetes](https://kubernetes.io/)
## Whole application architectures
![Application architectures](https://github.com/huynhngochuyhoang/book-project/blob/main/img/architectures.png)
## Run the project
> If you don't want to change any thing, just skip to this [section](https://github.com/huynhngochuyhoang/book-project#finally)
### First step
Login to your docker registry and enter your [Access token](https://docs.docker.com/docker-hub/access-tokens/)
``` 
docker login -u <your-docker-id>
 ```
### Second step
Execute ```deploy.sh``` scripts
```
sh deploy.sh
```
### Finally
Execute ```runk8s.sh```
```
sh runk8s.sh
```
## Clean workspace
```
sh clean.sh
```
