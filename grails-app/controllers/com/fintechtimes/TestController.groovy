package com.fintechtimes

import grails.plugin.springsecurity.annotation.Secured

/**
 * Created by hitenpratap on 27/08/16.
 */
@Secured('IS_AUTHENTICATED_ANONYMOUSLY')
class TestController {

    def bootstrapService

    def aa = {
        bootstrapService.createAuthors()
    }

}
