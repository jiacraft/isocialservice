FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD intuit-social-service-0.1.0.jar intuit-social-service.jar
RUN sh -c 'touch /intuit-social-service.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/intuit-social-service.jar"]