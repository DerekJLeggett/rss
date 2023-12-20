#!/bin/bash
mvn spring-boot:run
mv ./target/*.xml /var/www/html/
mv ./target/index.html /var/www/html/