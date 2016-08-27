package com.fintechtimes

import com.fintechtimes.Admin.Admin
import com.fintechtimes.Article.ArticleQueueManager
import geb.Browser
import org.apache.commons.lang.StringUtils

/**
 * Created by hitenpratap on 27/08/16.
 */
class ArticleScrapService {

    public static void scrapNewBigWhat(String keyword) {
        Browser.drive {
            go("https://www.nextbigwhat.com/search?q=${keyword}")
            println("Title=======>>>>>>         ${title}")
            $("#main-outlet").find("div.fps-result").each { newsDiv ->
                String articleTitle = newsDiv.find("span.topic-title").text()
                String articleURL = newsDiv.find("a.search-link").attr("href")
                if (articleURL && StringUtils.isNotBlank(articleURL)) {
                    println("Article Title  Keyword===>>>>${keyword}       =====>>>>>>       ${articleTitle}")
                    println("Article URL=====>>>>>>       ${articleURL}")
                    ArticleQueueManager articleQueueManager = ArticleQueueManager.findOrCreateByArticleURL(articleURL)
                    articleQueueManager.admin = Admin.findByUsername("admin1@email.com")
                    AppUtil.save(articleQueueManager)
                    println("*********************************************************************************")
                }
            }
        }
    }

    public static void scrapTechInAsia(String keyword) {
        Browser.drive {
            go("https://www.techinasia.com/search?query=${keyword}")
            Thread.sleep(2000)
            println("Title=======>>>>>>         ${title}")
            $("#app").find("div.search-results__item").each { newsDiv ->
                String articleTitle = newsDiv.find("div.media-body").find("a").text()
                String articleURL = newsDiv.find("div.media-body").find("a").attr("href")
                if (articleURL && StringUtils.isNotBlank(articleURL)) {
                    println("Article Title  Keyword===>>>>${keyword}       =====>>>>>>       ${articleTitle}")
                    println("Article URL=====>>>>>>       ${articleURL}")
                    ArticleQueueManager articleQueueManager = ArticleQueueManager.findOrCreateByArticleURL(articleURL)
                    articleQueueManager.admin = Admin.findByUsername("admin1@email.com")
                    AppUtil.save(articleQueueManager)
                    println("*********************************************************************************")
                }
            }
        }
    }

}
