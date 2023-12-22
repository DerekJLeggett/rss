#!/bin/bash
cd /home/admin/git/rss
mvn spring-boot:run
mv  -f /home/admin/git/rss/target/*.xml /var/www/html/
mv  -f /home/admin/git/rss/target/index.html /var/www/html/