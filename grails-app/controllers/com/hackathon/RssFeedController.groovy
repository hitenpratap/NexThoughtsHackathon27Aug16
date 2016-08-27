package com.hackathon

import com.rometools.rome.feed.synd.SyndFeed
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

class RssFeedController {

    def index() {}

    def fetchRssContent(){
        URL feedUrl = new URL("http://www.banktech.com/rss_simple.asp?f_n=949&f_ln=Banking%20Channels");

        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(feedUrl));

        /*feed.each {
            println it.SyndFeedImpl.entries[0].link
        }*/

        for(int i=0;i<feed.entries.size();i++){
            if(feed.entries[i].description.value.find(/(paytm)|(payments)|(fintech)|(freecharge)|(faircent)|(lending kart)/)){
                println feed.entries[i].title
                println feed.entries[i].link
                println feed.entries[i].description.value
            }
        }

        //   println feed.entries.size()

        render  ""+feed

    }
}
