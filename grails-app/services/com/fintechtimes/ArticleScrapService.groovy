package com.fintechtimes

import com.fintechtimes.Admin.Admin
import com.fintechtimes.Article.Article
import com.fintechtimes.Article.ArticleQueueManager
import com.fintechtimes.Author.Author
import geb.Browser
import org.apache.commons.lang.StringUtils
import org.apache.commons.lang3.RandomStringUtils

/**
 * Created by hitenpratap on 27/08/16.
 */
class ArticleScrapService {

    def articleMessageService

    public void scrapNewBigWhat(String keyword) {
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
                    articleQueueManager.admin = Admin.findByUsername("admin@email.com")
                    articleQueueManager.articleSource = Enums.ArticleSource.NEXT_BIG_WHAT
                    if (AppUtil.save(articleQueueManager))
                        articleMessageService.sendArticleMessage(articleQueueManager.uniqueId)
                    println("*********************************************************************************")
                }
            }
        }
    }

    public void scrapNextBigWhatDetails(String uniqueId) {
        ArticleQueueManager queueManager = ArticleQueueManager.findByUniqueId(uniqueId)
        Browser.drive {
            go("${queueManager.articleURL}")
            String title = $("#topic-title").find("a.fancy-title") ? $("#topic-title").find("a.fancy-title").text() : RandomStringUtils.randomAlphanumeric(40)
            String description = $("#post_1").find("p") ? $("#post_1").find("p").text() : RandomStringUtils.randomAlphanumeric(150)
            Article article = Article.findOrCreateByQueueManagerUniqueId(uniqueId)
            article.title = title
            article.description = description
            article.author = Author.get(Integer.parseInt(RandomStringUtils.randomNumeric(1)))
            AppUtil.save(article)
        }
    }

    public void scrapTechInAsia(String keyword) {
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
                    articleQueueManager.admin = Admin.findByUsername("admin@email.com")
                    articleQueueManager.articleSource = Enums.ArticleSource.TECH_IN_ASIA
                    if (AppUtil.save(articleQueueManager))
                        articleMessageService.sendArticleMessage(articleQueueManager.uniqueId)
                    println("*********************************************************************************")
                }
            }
        }
    }

}
