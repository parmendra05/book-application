FROM eclipse-temurin:17
WORKDIR /app
COPY target/book-application-0.0.1-SNAPSHOT.jar /app/my-book-application-docker.jar
ENTRYPOINT [ "java","-jar","my-book-application-docker.jar"]

#	below cmd command to build Dockefile 
#docker build -t my-book-application-docker .
#	below cmd command to check build is success or not 
#docker images
#	below cmd command to change tag name of Docker image
#docker build -t my-book-application-docker:0.01.RELEASE .
#docker build -t <IMAGE_NAME>:<TAG_NAME> .

#	run docker image in a docker container
#docker run -p 8081:8080 my-book-application-docker
#docker run -p <NEW_PORT>:<EXISTING_PORT> <IMAGE_NAME>

#	run docker image with detached mode (runing in background, hide the console)
#docker run -p 8081:8080 -d my-book-application-docker
#docker run -p <NEW_PORT>:<EXISTING_PORT> -d <IMAGE_NAME>
# to show the console : docker logs -f <ID>
# to show running image in background : docker ps
# to stop running image in background : docker stop <ID>

# login dockerHub by console : docker login
# 	Before push to dockerHub add images into repository(folder)
#docker tag <IMAGE_NAME> <REPO_NAME>/<IMAGE_NAME>:<TAG_NAME>
# to push docker image : docker push <REPO_NAME>/<IMAGE_NAME>:<TAG_NAME>
# to pull docker image : docker pull <REPO_NAME>/<IMAGE_NAME>:<TAG_NAME>