#!/bin/bash

mvn package
java -jar target/rsa_auth.jar
