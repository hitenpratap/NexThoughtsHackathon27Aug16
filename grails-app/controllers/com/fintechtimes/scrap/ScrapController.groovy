package com.fintechtimes.scrap

import grails.plugin.springsecurity.annotation.Secured

/**
 * Created by hitenpratap on 27/08/16.
 */
@Secured('IS_AUTHENTICATED_ANONYMOUSLY')
class ScrapController {

    def articleScrapService

    final List<String> keywords = ["paytm", "payments", "fintech", "freecharge", "faurcent", "lending kart "]

    def scrapNextBigWhat = {
        keywords.each { keyword ->
            articleScrapService.scrapNewBigWhat(URLEncoder.encode(keyword, "UTF-8"))
        }
    }

    def scrapTechInAsia = {
        keywords.each { keyword ->
            articleScrapService.scrapTechInAsia(URLEncoder.encode(keyword, "UTF-8").replace("+", "%20"))
        }
    }

}
