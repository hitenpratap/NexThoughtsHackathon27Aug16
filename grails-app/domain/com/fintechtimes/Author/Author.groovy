package com.fintechtimes.Author

import com.fintechtimes.User

/**
 * Created by hitenpratap on 27/08/16.
 */
class Author extends User {

    String bio

    static mapping = {
        bio type: 'text'
    }

    Author() {}

    Author(def csvTokens) {
        this.firstName = csvTokens[0]
        this.lastName = csvTokens[1]
        this.username = csvTokens[2]
        this.bio = csvTokens[3]
        this.password = "fin1928tech"
    }

}
