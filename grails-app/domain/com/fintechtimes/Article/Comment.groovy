package com.fintechtimes.Article

import com.fintechtimes.Author.Author

/**
 * Created by hitenpratap on 27/08/16.
 */
class Comment {

    String commentText
    Date dateCreated
    Date lastUpdated
    Author author
    String uniqueId = UUID.randomUUID().toString()

    static belongsTo = [article: Article]

    static mapping = {
        commentText type: 'text'
    }

    static constraints = {
        commentText blank: false, nullable: false
        article nullable: false
    }

}
