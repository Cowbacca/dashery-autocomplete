# Dashery Autocomplete [![Build Status](https://travis-ci.org/Cowbacca/dashery-autocomplete.svg?branch=master)](https://travis-ci.org/Cowbacca/dashery-autocomplete) [![codecov.io](https://codecov.io/github/Cowbacca/dashery-autocomplete/coverage.svg?branch=master)](https://codecov.io/github/Cowbacca/dashery-autocomplete?branch=master)

Provides tokens for Dashery's autocomplete.

## Usage
GET the */tokens/autocomplete* endpoint to be given a JSON list of tokens with one attribute: value.

## Deployment

Standard Spring Boot deployment.  Requires the following properties to be present in the environment, whether via yml/properties file or environment variable:

```
spring:
  cloud:
    config:
      profile: #e.g. will get values from the dashery-autocomplete-{profile}.properties file from the config server.
      uri: #the uri of the config server, e.g.  http://dashery-config-server.herokuapp.com 
      username: #username to access the config server.
      password: #password to access the config server.
```
