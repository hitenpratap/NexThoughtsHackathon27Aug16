package com.fintechtimes.Article

import com.fintechtimes.Admin.Admin
import com.fintechtimes.Enums

/**
 * Created by hitenpratap on 27/08/16.
 */
class ArticleQueueManager {

    Date dateCreated
    Date lastUpdated
    String articleURL
    Enums.ArticleQueueStatus queueStatus = Enums.ArticleQueueStatus.INITIALISED
    String uniqueId = UUID.randomUUID().toString()
    Enums.ArticleSource articleSource

    static belongsTo = [admin: Admin]

    static constraints = {
        articleURL blank: false, nullable: false
        articleSource nullable: false
    }

}
