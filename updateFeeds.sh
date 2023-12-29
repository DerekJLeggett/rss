#!/bin/bash
V_MY_PATH=$HOME
cd "$V_MY_PATH"/git/rss
mvn spring-boot:run
mv -f "$V_MY_PATH"/git/rss/target/*.xml /var/www/html/
mv -f "$V_MY_PATH"/git/rss/target/*.html /var/www/html/
chromium localhost