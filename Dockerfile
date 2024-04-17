FROM registry.redhat.io/fuse7/fuse-java-openshift-jdk11-rhel8:1.12-18
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/home/jboss/app.jar"]
