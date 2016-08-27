package com.fintechtimes.Article

import com.fintechtimes.Author.Author

/**
 * Created by hitenpratap on 27/08/16.
 */
class Article {

    String title
    String description
    Date dateCreated
    Date lastUpdated
    String queueManagerUniqueId
    String uniqueId = UUID.randomUUID().toString()

    static belongsTo = [author: Author]
    static hasMany = [comments: Comment]

    static mapping = {
        description type: 'text'
    }

    static constraints = {
        title blank: false, nullable: false
        description blank: false, nullable: false
    }

}
