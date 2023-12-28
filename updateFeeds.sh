#!/bin/bash
cd /home/derek/git/rss
mvn spring-boot:run
mv -f /home/derek/git/rss/target/*.xml /var/www/html/
mv -f /home/derek/git/rss/target/*.html /var/www/html/
mv -f /home/derek/git/rss/target/index.html /var/www/html/
chromium /var/www/html/index.html