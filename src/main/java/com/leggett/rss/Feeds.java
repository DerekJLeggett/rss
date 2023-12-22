package com.leggett.rss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.leggett.rss.Feed.Categories;

public class Feeds {

        public List<List<Feed>> getFeeds() {
                List<List<Feed>> feeds = new ArrayList<>();
                List<Feed> fitnessFeeds = new ArrayList<>();
                fitnessFeeds.add(new Feed(Arrays.asList(Categories.FITNESS), "https://womensfitness.co.uk/feed"));
                fitnessFeeds.add(new Feed(Arrays.asList(Categories.FITNESS),
                                "https://media.rss.com/cmartyfitfacts/feed.xml"));
                feeds.add(fitnessFeeds);

                List<Feed> metalFabricationFeeds = new ArrayList<>();
                metalFabricationFeeds.add(new Feed(Arrays.asList(Categories.METAL_FABRICATION),
                                "https://www.youtube.com/feeds/videos.xml?channel_id=UCdOM6Qc53TcWuExrnDLVjXg"));
                metalFabricationFeeds.add(new Feed(Arrays.asList(Categories.METAL_FABRICATION),
                                "https://www.youtube.com/feeds/videos.xml?channel_id=UCSFaYYQzNMLo2U6rSNLpghg"));
                feeds.add(metalFabricationFeeds);

                List<Feed> entertainmentFeeds = new ArrayList<>();
                entertainmentFeeds.add(new Feed(Arrays.asList(Categories.ENTERTAINMENT),
                                "https://rss.tvguide.com/breakingnews"));
                entertainmentFeeds.add(new Feed(Arrays.asList(Categories.ENTERTAINMENT),
                                "https://www.tvguide.com/feed/rss/gallery.xml"));
                entertainmentFeeds.add(
                                new Feed(Arrays.asList(Categories.ENTERTAINMENT), "https://www.etonline.com/news/rss"));
                entertainmentFeeds.add(new Feed(Arrays.asList(Categories.ENTERTAINMENT),
                                "https://www.etonline.com/gallery/rss"));
                entertainmentFeeds.add(new Feed(Arrays.asList(Categories.ENTERTAINMENT),
                                "https://www.etonline.com/video/rss"));
                entertainmentFeeds.add(new Feed(Arrays.asList(Categories.ENTERTAINMENT),
                                "https://feeds.npr.org/1008/rss.xml"));
                entertainmentFeeds.add(new Feed(Arrays.asList(Categories.ENTERTAINMENT),
                                "https://www.newyorker.com/feed/humor"));
                entertainmentFeeds.add(
                                new Feed(Arrays.asList(Categories.ENTERTAINMENT), "https://feeds.npr.org/13/rss.xml"));
                entertainmentFeeds.add(new Feed(Arrays.asList(Categories.ENTERTAINMENT),
                                "https://feeds.npr.org/1045/rss.xml"));
                entertainmentFeeds.add(new Feed(Arrays.asList(Categories.ENTERTAINMENT),
                                "https://www.youtube.com/feeds/videos.xml?channel_id=UCdtXPiqI2cLorKaPrfpKc4g"));
                feeds.add(entertainmentFeeds);

                List<Feed> newsFeeds = new ArrayList<>();
                newsFeeds.add(new Feed(Arrays.asList(Categories.NEWS),
                                "https://rss.nytimes.com/services/xml/rss/nyt/HomePage.xml"));
                newsFeeds.add(new Feed(Arrays.asList(Categories.NEWS), "https://feeds.npr.org/1001/rss.xml"));
                newsFeeds.add(new Feed(Arrays.asList(Categories.NEWS), "https://feeds.npr.org/510318/podcast.xml"));
                newsFeeds.add(new Feed(Arrays.asList(Categories.NEWS),
                                "https://www.huffpost.com/section/front-page/feed?x=1"));
                newsFeeds.add(new Feed(Arrays.asList(Categories.NEWS),
                                "http://www.politico.com/rss/politicopicks.xml"));
                newsFeeds.add(new Feed(Arrays.asList(Categories.NEWS), "https://www.yahoo.com/news/rss"));
                newsFeeds.add(new Feed(Arrays.asList(Categories.NEWS), "https://www.latimes.com/local/rss2.0.xml"));
                newsFeeds.add(new Feed(Arrays.asList(Categories.NEWS),
                                "http://newsrss.bbc.co.uk/rss/newsonline_world_edition/americas/rss.xml"));
                newsFeeds.add(new Feed(Arrays.asList(Categories.NEWS),
                                "http://feeds.bbci.co.uk/news/world/us_and_canada/rss.xml?edition=int"));
                newsFeeds.add(new Feed(Arrays.asList(Categories.NEWS), "https://www.vox.com/rss/index.xml"));
                newsFeeds.add(new Feed(Arrays.asList(Categories.NEWS),
                                "https://podcastfeeds.nbcnews.com/dateline-nbc"));
                newsFeeds.add(new Feed(Arrays.asList(Categories.NEWS), "http://rss.art19.com/the-daily"));
                newsFeeds.add(new Feed(Arrays.asList(Categories.NEWS), "https://feeds.megaphone.fm/WWO8086402096"));
                newsFeeds.add(new Feed(Arrays.asList(Categories.NEWS, Categories.RUSSIA),
                                "https://www.themoscowtimes.com/rss/news"));
                newsFeeds.add(new Feed(Arrays.asList(Categories.NEWS), "https://www.goodnewsnetwork.org/feed/"));
                feeds.add(newsFeeds);

                List<Feed> educationFeeds = new ArrayList<>();
                educationFeeds.add(new Feed(Arrays.asList(Categories.EDUCATION), "https://www.ed.gov/feed"));
                educationFeeds.add(new Feed(Arrays.asList(Categories.EDUCATION),
                                "https://www2.smartbrief.com/servlet/rss?b=ASCD"));
                educationFeeds.add(new Feed(Arrays.asList(Categories.EDUCATION), "https://feeds.npr.org/1013/rss.xml"));
                educationFeeds.add(new Feed(Arrays.asList(Categories.EDUCATION),
                                "http://blog.discoveryeducation.com/feed/"));
                educationFeeds.add(new Feed(Arrays.asList(Categories.EDUCATION),
                                "https://www.nytimes.com/svc/collections/v1/publish/https://www.nytimes.com/section/learning/rss.xml"));
                feeds.add(educationFeeds);

                List<Feed> technologyFeeds = new ArrayList<>();
                technologyFeeds.add(new Feed(Arrays.asList(Categories.TECHNOLOGY), "https://www.wired.com/feed"));
                technologyFeeds.add(new Feed(Arrays.asList(Categories.TECHNOLOGY),
                                "https://rss.nytimes.com/services/xml/rss/nyt/Technology.xml"));
                technologyFeeds.add(
                                new Feed(Arrays.asList(Categories.TECHNOLOGY), "https://feeds.npr.org/1019/rss.xml"));
                technologyFeeds.add(new Feed(Arrays.asList(Categories.TECHNOLOGY),
                                "https://www.surfnetkids.com/resources/feed/"));
                technologyFeeds.add(
                                new Feed(Arrays.asList(Categories.TECHNOLOGY), "https://www.macworld.com/index.rss"));
                technologyFeeds.add(
                                new Feed(Arrays.asList(Categories.TECHNOLOGY), "https://www.pcworld.com/feed"));
                technologyFeeds.add(new Feed(Arrays.asList(Categories.TECHNOLOGY), "https://www.engadget.com/rss.xml"));
                technologyFeeds.add(new Feed(Arrays.asList(Categories.TECHNOLOGY), "https://www.anandtech.com/rss/"));
                technologyFeeds.add(new Feed(Arrays.asList(Categories.TECHNOLOGY),
                                "https://www.tomshardware.com/feeds/all"));
                technologyFeeds.add(new Feed(Arrays.asList(Categories.TECHNOLOGY),
                                "http://rss.slashdot.org/Slashdot/slashdot"));
                technologyFeeds.add(new Feed(Arrays.asList(Categories.TECHNOLOGY),
                                "https://www.theverge.com/rss/index.xml"));
                technologyFeeds.add(new Feed(Arrays.asList(Categories.TECHNOLOGY),
                                "https://www.howtogeek.com/feed"));
                technologyFeeds.add(new Feed(Arrays.asList(Categories.TECHNOLOGY),
                                "https://www.raspberrypi.com/feed"));
                technologyFeeds.add(new Feed(Arrays.asList(Categories.TECHNOLOGY),
                                "https://feeds.macrumors.com/MacRumors-All"));
                feeds.add(technologyFeeds);

                List<Feed> scienceFeeds = new ArrayList<>();
                scienceFeeds.add(new Feed(Arrays.asList(Categories.SCIENCE),
                                "http://feeds.sciencedaily.com/sciencedaily"));
                scienceFeeds.add(new Feed(Arrays.asList(Categories.SCIENCE),
                                "https://www.smithsonianmag.com/rss/latest_articles/"));
                feeds.add(scienceFeeds);

                List<Feed> natureFeeds = new ArrayList<>();
                natureFeeds.add(new Feed(Arrays.asList(Categories.NATURE),
                                "https://www.nature.com/nature.rss"));
                feeds.add(natureFeeds);

                List<Feed> spaceFeeds = new ArrayList<>();
                spaceFeeds.add(new Feed(Arrays.asList(Categories.SPACE),
                                "https://www.nasa.gov/rss/dyn/breaking_news.rss"));
                spaceFeeds.add(new Feed(Arrays.asList(Categories.SPACE),
                                "https://www.nasa.gov/rss/dyn/lg_image_of_the_day.rss"));
                feeds.add(spaceFeeds);

                List<Feed> pbsFeeds = new ArrayList<>();
                pbsFeeds.add(new Feed(Arrays.asList(Categories.PBS), "https://www.pbs.org/wgbh/nova/rss/all/"));
                feeds.add(pbsFeeds);

                List<Feed> sportsFeeds = new ArrayList<>();
                sportsFeeds.add(new Feed(Arrays.asList(Categories.SPORTS),
                                "https://rss.nytimes.com/services/xml/rss/nyt/Sports.xml"));
                sportsFeeds.add(new Feed(Arrays.asList(Categories.SPORTS), "https://www.nba.com/jazz/rss.xml"));
                sportsFeeds.add(new Feed(Arrays.asList(Categories.SPORTS), "https://www.espn.com/espn/rss/news"));
                sportsFeeds.add(new Feed(Arrays.asList(Categories.SPORTS, Categories.BOXING),
                                "https://www.cbssports.com/rss/headlines/boxing/"));
                sportsFeeds.add(new Feed(Arrays.asList(Categories.SPORTS, Categories.COLLEGE_BASKETBALL),
                                "https://www.cbssports.com/rss/headlines/college-basketball/"));
                sportsFeeds.add(new Feed(Arrays.asList(Categories.SPORTS, Categories.BASEBALL),
                                "https://www.mlb.com/feeds/news/rss.xml"));
                sportsFeeds.add(new Feed(Arrays.asList(Categories.SPORTS), "https://www.si.com/.rss/full/"));
                sportsFeeds.add(new Feed(Arrays.asList(Categories.SPORTS), "https://feeds.megaphone.fm/newheights"));
                feeds.add(sportsFeeds);

                List<Feed> celebrityFeeds = new ArrayList<>();
                celebrityFeeds.add(new Feed(Arrays.asList(Categories.CELEBRITY), "https://www.usmagazine.com/feed/"));
                feeds.add(celebrityFeeds);

                List<Feed> photoFeeds = new ArrayList<>();
                photoFeeds.add(new Feed(Arrays.asList(Categories.PHOTOS),
                                "http://davidkphotography.com/index.php?x=rss"));
                feeds.add(photoFeeds);

                List<Feed> musicFeeds = new ArrayList<>();
                musicFeeds.add(new Feed(Arrays.asList(Categories.MUSIC), "https://www.billboard.com/feed/"));
                feeds.add(musicFeeds);

                List<Feed> movieFeeds = new ArrayList<>();
                movieFeeds.add(new Feed(Arrays.asList(Categories.MOVIES), "https://movieweb.com/feed/"));
                feeds.add(movieFeeds);

                List<Feed> gamingFeeds = new ArrayList<>();
                gamingFeeds.add(new Feed(Arrays.asList(Categories.PC_VIDEO_GAMES),
                                "https://store.steampowered.com/feeds/news.xml"));
                gamingFeeds.add(new Feed(Arrays.asList(Categories.PC_VIDEO_GAMES), "https://www.pcgamer.com/rss"));
                gamingFeeds.add(new Feed(Arrays.asList(Categories.PC_VIDEO_GAMES),
                                "https://www.tomshardware.com/rss.xml"));
                feeds.add(gamingFeeds);

                List<Feed> autoFeeds = new ArrayList<>();
                autoFeeds.add(new Feed(Arrays.asList(Categories.AUTOMOTIVE),
                                "https://www.caranddriver.com/rss/all.xml"));
                feeds.add(autoFeeds);

                List<Feed> medicalFeeds = new ArrayList<>();
                medicalFeeds.add(new Feed(Arrays.asList(Categories.MEDICAL),
                                "https://www.medicinenet.com/rss/dailyhealth.xml"));
                medicalFeeds.add(new Feed(Arrays.asList(Categories.MEDICAL),
                                "https://medlineplus.gov/feeds/whatsnew.xml"));
                medicalFeeds.add(new Feed(Arrays.asList(Categories.MEDICAL),
                                "https://tools.cdc.gov/podcasts/feed.asp?feedid=183"));
                feeds.add(medicalFeeds);

                List<Feed> libraryFeeds = new ArrayList<>();
                libraryFeeds.add(new Feed(Arrays.asList(Categories.LIBRARY), "https://www.loc.gov/rss/pao/news.xml"));
                feeds.add(libraryFeeds);

                List<Feed> fashionFeeds = new ArrayList<>();
                fashionFeeds.add(new Feed(Arrays.asList(Categories.FASHION), "https://www.elle.com/rss/all.xml/"));
                fashionFeeds.add(new Feed(Arrays.asList(Categories.FASHION), "https://www.vanityfair.com/feed/rss"));
                feeds.add(fashionFeeds);

                List<Feed> lifestyleFeeds = new ArrayList<>();
                lifestyleFeeds.add(new Feed(Arrays.asList(Categories.LIFESTYLE), "https://lifehacker.com/rss"));
                lifestyleFeeds.add(new Feed(Arrays.asList(Categories.LIFESTYLE),
                                "https://www.youtube.com/feeds/videos.xml?channel_id=UCN7aLGjHbAr6XBgGkHJsMnw"));
                feeds.add(lifestyleFeeds);

                List<Feed> nationalParkFeeds = new ArrayList<>();
                nationalParkFeeds.add(new Feed(Arrays.asList(Categories.NATIONAL_PARKS),
                                "https://www.nps.gov/feeds/getnewsrss.htm?id=gate"));
                nationalParkFeeds.add(new Feed(Arrays.asList(Categories.NATIONAL_PARKS),
                                "https://www.nps.gov/feeds/getnewsrss.htm?id=grca"));
                feeds.add(nationalParkFeeds);

                List<Feed> webDevFeeds = new ArrayList<>();
                webDevFeeds.add(new Feed(Arrays.asList(Categories.WEB_DEV), "https://www.smashingmagazine.com/feed/"));
                feeds.add(webDevFeeds);

                List<Feed> comedyFeeds = new ArrayList<>();
                comedyFeeds.add(new Feed(Arrays.asList(Categories.COMEDY),
                                "https://rss.art19.com/smartless"));
                feeds.add(comedyFeeds);

                List<Feed> documentaryFeeds = new ArrayList<>();
                documentaryFeeds.add(new Feed(Arrays.asList(Categories.DOCUMENTARY),
                                "https://feeds.simplecast.com/6HzeyO6b"));
                feeds.add(documentaryFeeds);

                List<Feed> raceFeeds = new ArrayList<>();
                raceFeeds.add(new Feed(Arrays.asList(Categories.RACE), "https://feeds.npr.org/510312/podcast.xml"));
                feeds.add(raceFeeds);

                List<Feed> crimeFeeds = new ArrayList<>();
                crimeFeeds.add(new Feed(Arrays.asList(Categories.CRIME), "https://feeds.megaphone.fm/ADL9840290619"));
                crimeFeeds.add(new Feed(Arrays.asList(Categories.CRIME),
                                "https://www.omnycontent.com/d/playlist/aaea4e69-af51-495e-afc9-a9760146922b/44bbf446-4627-4f83-a7fd-ab070007db11/72b96aa8-88bd-480a-87af-ab070007db36/podcast.rss"));
                crimeFeeds.add(new Feed(Arrays.asList(Categories.CRIME), "https://podcastfeeds.nbcnews.com/RPWEjhKq"));
                crimeFeeds.add(new Feed(Arrays.asList(Categories.CRIME), "https://rss.art19.com/-exposed-"));
                feeds.add(crimeFeeds);

                List<Feed> humanityFeeds = new ArrayList<>();
                humanityFeeds.add(new Feed(Arrays.asList(Categories.HUMANITY),
                                "https://feeds.megaphone.fm/unlocking-us"));
                feeds.add(humanityFeeds);

                List<Feed> militaryFeeds = new ArrayList<>();
                militaryFeeds.add(new Feed(Arrays.asList(Categories.MILITARY), "https://www.janes.com/feeds/news"));
                militaryFeeds.add(new Feed(Arrays.asList(Categories.MILITARY),
                                "https://www.military.com/rss-feeds/content?keyword=headlines&channel=news&type=news"));
                militaryFeeds.add(new Feed(Arrays.asList(Categories.MILITARY, Categories.NAVY),
                                "http://feeds.feedburner.com/navy-times/news/your-navy"));
                militaryFeeds.add(new Feed(Arrays.asList(Categories.MILITARY, Categories.VETERANS),
                                "http://feeds.feedburner.com/military-times/veterans"));
                militaryFeeds.add(new Feed(Arrays.asList(Categories.MILITARY, Categories.VETERANS),
                                "http://www.va.gov/rss/rss_PressRel.asp"));
                militaryFeeds.add(new Feed(Arrays.asList(Categories.MILITARY, Categories.VETERANS),
                                "https://www.va.gov/health/NewsFeatures/news.xml"));
                feeds.add(militaryFeeds);

                List<Feed> governmentFeeds = new ArrayList<>();
                governmentFeeds.add(new Feed(Arrays.asList(Categories.GOVERNMENT),
                                "https://www.dhs.gov/news_and_updates/rss.xml"));
                governmentFeeds.add(new Feed(Arrays.asList(Categories.GOVERNMENT),
                                "https://www.fbi.gov/feeds/national-press-releases/rss.xml"));
                feeds.add(governmentFeeds);
                return feeds;
        }
}
