FROM mill-base:latest

WORKDIR /mill-app

COPY build.sc /mill-app
COPY /service /mill-app/service

CMD ["mill", "sample.build"]