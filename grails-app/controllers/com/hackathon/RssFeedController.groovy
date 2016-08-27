package com.hackathon

import com.fintechtimes.Admin.Admin
import com.fintechtimes.Article.ArticleQueueManager
import com.fintechtimes.User
import com.rometools.rome.feed.synd.SyndFeed
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader
import grails.plugin.springsecurity.annotation.Secured;

@Secured('ROLE_ADMIN')
class RssFeedController {
    def springSecurityService
    def index() {

        render(view: 'home')
    }

    def fetchRssContent(){
        List allURL=[]
        allURL.add("http://www.banktech.com/rss_simple.asp?f_n=949&f_ln=Banking%20Channels")
        allURL.add("https://www.finextra.com/rss/channel.aspx?channel=mobile")
        allURL.add("https://www.finextra.com/rss/channel.aspx?channel=payments")
        allURL.add("http://feeds.feedburner.com/TechCrunch/")
        allURL.add("http://www.mobilepaymentstoday.com/rss/")
        allURL.add("http://thenextweb.com/feed/")
        allURL.each{
            URL feedUrl = new URL(it);

            Admin admin=springSecurityService.currentUser as Admin
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(feedUrl));
            for(int i=0;i<feed.entries.size();i++){
                try {
                    if(feed.entries[i].description.value.find(/(paytm)|(payments)|(fintech)|(freecharge)|(faircent)|(lending kart)/)){
//                     println i
//                        println feed.entries[i].title
//                        println feed.entries[i].link
//                        println feed.entries[i].description.value
                        if(!ArticleQueueManager.findByArticleURL(feed.entries[i].link))
                        {
                            ArticleQueueManager articleQueueManager=new ArticleQueueManager()
                            articleQueueManager.articleURL=feed.entries[i].link
                            articleQueueManager.admin=admin
                            articleQueueManager.save(flush: true)
                        }
                    }
                }catch (Exception e){
                    println("Exception is "+e.getMessage())
                }
            }
        }

        render  "success"
    }


}
