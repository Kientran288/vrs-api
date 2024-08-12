FROM openjdk:17

WORKDIR /app

# Copy the JAR file (/app)
COPY /target/*.jar ./java.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the jar file
CMD ["java", "-jar", "java.jar"]

#FROM eclipse-temurin:17-jre-jammy
#
## Reference: https://code.visualstudio.com/remote/advancedcontainers/add-nonroot-user
## Create non-root user to run our application
#ARG USERNAME=app
#ARG USER_UID=1000
#ARG USER_GID=$USER_UID
#
#RUN groupadd --gid $USER_GID $USERNAME \
#    && useradd --uid $USER_UID --gid $USER_GID -m $USERNAME
#
#    # && useradd --uid $USER_UID --gid $USER_GID -m $USERNAME \
#    # [Optional] Add sudo support. Omit if you don't need to install software after connecting.
#    # && apt-get update \
#    # && apt-get install -y sudo \
#    # && echo $USERNAME ALL=\(root\) NOPASSWD:ALL > /etc/sudoers.d/$USERNAME \
#    # && chmod 0440 /etc/sudoers.d/$USERNAME
#
## ********************************************************
## * Anything else you want to do like clean up goes here *
## ********************************************************
#
## Create work dir for non-root user
#ARG app_path=/app
#RUN mkdir -p ${app_path}
#RUN chown -R ${USERNAME}:${USER_GID} ${app_path}
#
## [Optional] Set the default user. Omit if you want to keep the default as root.
#USER ${USERNAME}
#
#WORKDIR $app_path
#ARG build_path=./target
#COPY --chown=${USERNAME}:${USER_GID} $build_path/*.jar $app_path/app.jar
#
## Default heap size
#ARG java_tool_options=-Xms512m -Xmx2048m
#
## env variables can be overwritten at runtime
#ENV JAVA_TOOL_OPTIONS=${java_tool_options}
#
## IMPORTANT:
##   if you define an env variable (e.g. SERVER_PORT) which replaces an application property of Spring Boot
##   => Do NOT forget to inject this env variable in deployment.yaml
##   => Otherwise, the default value of this env always prevails the value in application.yaml
##   => RECOMMEND: do NOT define such an env variable in Dockerfile
#
#ENTRYPOINT java $JAVA_TOOL_OPTIONS \
#    -Duser.timezone=UTC \
#    -jar app.jar \
#    -Dspring.profiles.active=docker \
## ALWAYS enable health endpoints so that K8S can check health status of our application
## Spring Boot: line arguments has higher priorty than application.yaml and env variable
#    --management.endpoint.health.probes.enabled=true
