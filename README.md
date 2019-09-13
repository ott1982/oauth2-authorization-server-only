# OAuth2 Authorization Server

Minimal gradle project Springboot Oauth 2 Authorization Server.



# Apendix

## Java KeyStore creation

```sh
keytool -genkey -v -keystore mykeystore.keystore -alias myalias -keyalg RSA -keysize 2048 -validity 10000
keytool -v -list -keystore mykeystore.keystore -alias myalias
```



