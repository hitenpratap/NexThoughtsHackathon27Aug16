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

}