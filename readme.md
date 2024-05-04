# Requirements
## Java 21
To install java 21 is to use [sdkman](https://sdkman.io/) 
then install java `sdk install java 21.0.3-oracle`
make sure Java 21 becomes is available `java --version`

## Docker and Colima 
Make sure you have installed docker and colima, then start colima
 ```colima start --network-address```
if you do not have it installed then use `brew install docker && brew install colima`

Check docker and colima work correctly: `docker ps`

## Test Containers
Test containers come out of the box. But sometimes they are not able to locate docker and colima. 
add the following to `~/.bashrc` or `~/.zshrc` or whatever you are using

```bash
export TESTCONTAINERS_DOCKER_SOCKET_OVERRIDE=/var/run/docker.sock
export TESTCONTAINERS_HOST_OVERRIDE=$(colima ls -j | jq -r '.address')
export DOCKER_HOST="unix://${HOME}/.colima/default/docker.sock"
```

if you do not have `jq` command installed `brew install jq`

do not forget to `source ~/.basrch` or `source ~/.zshrc` and restart Idea

# How to run locally
```./run-locally.sh```
the command spins up the database from `compose.yaml` and runs spring-boot

# How to compile and test
```./gradlew build```