FROM openjdk:8-jre-slim
ARG source_path
WORKDIR /app
RUN pwd
RUN echo "SOURCE PATH: ${source_path}"
COPY ./${source_path} .
# COPY target-files .
COPY ./docker-entrypoint.sh /
ENTRYPOINT ["/docker-entrypoint.sh"]