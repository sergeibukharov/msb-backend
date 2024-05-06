# Main principles 
1. [x] The application might be build or run ot test by pressing *one button* or executing a single `sh` script
2. [x] All the checks are executed on local during build phase (testing, linting, etc...).
3. [x] Local checks include: testing, java style checks, linters, potential bugs checks, security vulnerabilities checks
4. [x] All the checks must be run all local before code push to remote (use githooks)


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

# TO DO
add checkstyle and java coding standard
add githooks to build app before push it
do we need spring modulith?
add telemetry support (metrics)
add spotbugs
add owasp dependency checker
add and configure jacoco