package com.fintechtimes.Author

/**
 * Created by hitenpratap on 27/08/16.
 */
class Follower {

    Date dateCreated
    Date lastUpdated
    Author follower
    String uniqueId = UUID.randomUUID().toString()

    static belongsTo = [author: Author]

    static constraints = {
        follower nullable: false
    }

}
