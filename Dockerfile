FROM sbt-prerun:latest

WORKDIR /mill-app

COPY build.sc /mill-app
COPY /service /mill-app/service

CMD ["sample.testBuild"]