package com.fintechtimes.Admin

import com.fintechtimes.Article.ArticleQueueManager
import com.fintechtimes.User

/**
 * Created by hitenpratap on 27/08/16.
 */
class Admin extends User {

    static hasMany = [articleQueue: ArticleQueueManager]

}
