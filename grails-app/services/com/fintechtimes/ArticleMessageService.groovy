package com.fintechtimes

import com.fintechtimes.Article.ArticleQueueManager
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware

/**
 * Created by hitenpratap on 27/08/16.
 */
class ArticleMessageService implements ApplicationContextAware {

    ApplicationContext applicationContext
    def articleScrapServiceBean

    static rabbitQueue = "articleURLQueue"

    void handleMessage(String message) {
        ArticleQueueManager queueManager = ArticleQueueManager.findByUniqueId(message)
        if (queueManager) {
            switch (queueManager.articleSource) {
                case Enums.ArticleSource.NEXT_BIG_WHAT:
                    articleScrapServiceBean = applicationContext.getBean("articleScrapService")
                    articleScrapServiceBean.scrapNextBigWhatDetails(message)
                    break
                default:
                    println("Not scraped yet!!!")
            }
        }
    }

    void sendArticleMessage(String articleUID) {
        rabbitSend "articleURLQueue", articleUID
    }

}
