# OAuth2 Authorization Server

Minimal gradle project Springboot Oauth 2 Authorization Server.

**Requirements**

* Pass as arguments application.properties properties.
* Generate new keystore (apendix).
* Rewrite all TODO's in source code.
* Docker.

# Development

```sh
./gradlew clean bootRun
```

# Run

```sh
./gradlew clean build
docker build --tag oauth2-authorization-server-only -f ./docker/Dockerfile ./
docker run -d \
--name oauth2-authorization-server-only_1 \
-p 8081:8080 \
-v $HOME/git/oauth2-authorization-server-only/keystore/mykeystore.keystore:/opt/oauth2-authorization-server-only/mykeystore.keystore \
--env-file $HOME/git/oauth2-authorization-server-only/docker/env_file.properties \
oauth2-authorization-server-only
```

# Apendix

## Java keystore creation

```sh
keytool -genkey -v -keystore mykeystore.keystore -alias myalias -keyalg RSA -keysize 2048 -validity 10000
keytool -v -list -keystore mykeystore.keystore -alias myalias
```

## Curl access token GET (Docker)

```sh
curl -X POST -u myclientid:myclientsecret http://localhost:8081/oauth/token \
-H"content-type: application/x-www-form-urlencoded" \
-d"grant_type=password&username=myusername&password=mypassword" | jq .
```

## Prepare for Eclipse java project

```sh
./gradlew cleanEclipse eclipse
```

