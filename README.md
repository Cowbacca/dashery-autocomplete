# Dashery Autocomplete

[![Build Status](https://travis-ci.org/Cowbacca/dashery-autocomplete.svg?branch=master)](https://travis-ci.org/Cowbacca/dashery-autocomplete)

Provides tokens for Dashery's autocomplete.

## Deployment

Standard Spring Boot deployment.  Requires the following properties to be present in the environment, wether via yml/properties file or environment variable:

```
spring:
  cloud:
    config:
      profile: #e.g. will get values from the dashery-autocomplete-{profile}.properties file from the config server.
      uri: #the uri of the config server, e.g.  http://dashery-config-server.herokuapp.com 
      username: #username to access the config server.
      password: #password to access the config server.
```
