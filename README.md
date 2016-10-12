- github link: https://github.com/jiacraft/socialservice.git

- at current phase, all users are set within the app

- The app requires Java 8 

- to run spring boot, built by maven, type:

	1. Download the zip from github link

	2. unzip the zip and, 
	
		mvn spring-boot:run			
		
		or:

		mvn clean package
		java -jar target/intuit-social-service-0.1.0.jar
		
- to look at the web, created by spring boot, goto:

		http://localhost:8080


- to create docker image, from where the project root (where pom.xml is located), type:

	mvn package docker:build

  a docker iamge should be craeted with name: bjia/intuit-social-service

- to run app from local docker container (need to have docker/Toolbox installed )	

 	- start a docker machine (use default is ok)
		docker-machine start default

	- check and record the ip of docker machine
		docker-machine ip default

	- connect current shell to the machine (default)
		eval "$(docker-machine env default)"

	- run docker container for the image created of our app, need to bind container port to host port

		docker run -p 8080:8080 bjia/intuit-social-service
