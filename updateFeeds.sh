#!/bin/bash
mvn spring-boot:run -Dspring-boot.run.arguments="entertainment https://rss.tvguide.com/breakingnews https://www.tvguide.com/feed/rss/gallery.xml https://www.etonline.com/news/rss https://www.etonline.com/gallery/rss https://www.etonline.com/video/rss https://feeds.npr.org/1008/rss.xml https://www.newyorker.com/feed/humor https://feeds.npr.org/13/rss.xml https://feeds.npr.org/1045/rss.xml https://www.youtube.com/feeds/videos.xml?user=EntertainmentTonight"
mvn spring-boot:run -Dspring-boot.run.arguments="news https://rss.nytimes.com/services/xml/rss/nyt/HomePage.xml https://feeds.npr.org/1001/rss.xml http://newsrss.bbc.co.uk/rss/newsonline_world_edition/americas/rss.xml http://feeds.bbci.co.uk/news/world/us_and_canada/rss.xml?edition=int"
mvn spring-boot:run -Dspring-boot.run.arguments="education https://www.ed.gov/feed https://www2.smartbrief.com/servlet/rss?b=ASCD https://feeds.npr.org/1013/rss.xml http://blog.discoveryeducation.com/feed/ https://www.nytimes.com/svc/collections/v1/publish/https://www.nytimes.com/section/learning/rss.xml"
mvn spring-boot:run -Dspring-boot.run.arguments="science http://feeds.sciencedaily.com/sciencedaily https://www.smithsonianmag.com/rss/latest_articles/"
mvn spring-boot:run -Dspring-boot.run.arguments="nature http://feeds.nature.com/nature/rss/current"
mvn spring-boot:run -Dspring-boot.run.arguments="space https://www.nasa.gov/rss/dyn/breaking_news.rss https://www.nasa.gov/rss/dyn/lg_image_of_the_day.rss"
mvn spring-boot:run -Dspring-boot.run.arguments="technology https://www.wired.com/feed https://rss.nytimes.com/services/xml/rss/nyt/Technology.xml https://feeds.npr.org/1019/rss.xml https://www.surfnetkids.com/resources/feed/ https://www.macworld.com/index.rss https://www.pcworld.com/index.rss https://www.engadget.com/rss.xml https://www.anandtech.com/rss/ https://www.tomshardware.com/feeds/all"
mvn spring-boot:run -Dspring-boot.run.arguments="pbs https://www.pbs.org/wgbh/nova/rss/all/"
mvn spring-boot:run -Dspring-boot.run.arguments="sports https://rss.nytimes.com/services/xml/rss/nyt/Sports.xml https://www.nba.com/jazz/rss.xml https://www.espn.com/espn/rss/news"
mvn spring-boot:run -Dspring-boot.run.arguments="boxing https://www.cbssports.com/rss/headlines/boxing/"
mvn spring-boot:run -Dspring-boot.run.arguments="college_basketball https://www.cbssports.com/rss/headlines/college-basketball/"
mvn spring-boot:run -Dspring-boot.run.arguments="celebrity https://www.usmagazine.com/feed/"
mvn spring-boot:run -Dspring-boot.run.arguments="photos http://davidkphotography.com/index.php?x=rss http://feeds.feedburner.com/animals"
mvn spring-boot:run -Dspring-boot.run.arguments="baseball https://www.mlb.com/feeds/news/rss.xml"
mvn spring-boot:run -Dspring-boot.run.arguments="music https://www.billboard.com/feed/"
mvn spring-boot:run -Dspring-boot.run.arguments="movies https://www.metacritic.com/rss/movies https://movieweb.com/rss/all-news/ https://rss.itunes.apple.com/api/v1/us/movies/top-movies/all/100/non-explicit.rss"
mvn spring-boot:run -Dspring-boot.run.arguments="PC_video_games https://www.metacritic.com/rss/games/pc"
mvn spring-boot:run -Dspring-boot.run.arguments="automotive https://www.motortrend.com/feed/"
mvn spring-boot:run -Dspring-boot.run.arguments="medical https://www.medicinenet.com/rss/dailyhealth.xml https://medlineplus.gov/feeds/whatsnew.xml"
mvn spring-boot:run -Dspring-boot.run.arguments="library https://www.loc.gov/rss/pao/news.xml"
mvn spring-boot:run -Dspring-boot.run.arguments="fashion https://www.elle.com/rss/all.xml/ https://www.gq.com/feed/style/rss https://www.vanityfair.com/feed/rss https://www.maxim.com/.rss/full/"
mvn spring-boot:run -Dspring-boot.run.arguments="lifestyle https://lifehacker.com/rss"
mvn spring-boot:run -Dspring-boot.run.arguments="national_parks https://www.nps.gov/feeds/getnewsrss.htm?id=gate https://www.nps.gov/feeds/getnewsrss.htm?id=grca"
sudo cp /home/admin/git/rss/*.xml /var/www/html/assets/rss/