#!/bin/bash
git pull
mvn spring-boot:run
sudo cp /home/admin/git/rss/rss.xml /var/www/html/assets/rss/