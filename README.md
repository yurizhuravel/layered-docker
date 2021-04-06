## Calling Docker from Docker

A sample project to build a Docker image, and run it to build another image

1. From root, build a base tooling image containing Mill and Docker:

`docker build -t mill-base -f ./operations/Dockerfile.build .`

2. Build a wrapper image:

`docker build -t layered-docker .`

3. Run it to build another image with access to outer Docker daemon:

`docker run --volume /var/run/docker.sock:/var/run/docker.sock layered-docker`

