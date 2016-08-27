package com.fintechtimes.article

import com.fintechtimes.Article.Article

/**
 * Created by hitenpratap on 27/08/16.
 */
class ArticleController {

    def view = {
        Article article = Article.findByUniqueId(params.articleUID)
    }

}
