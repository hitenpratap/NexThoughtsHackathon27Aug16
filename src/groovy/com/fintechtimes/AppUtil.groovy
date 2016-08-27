package com.fintechtimes

import grails.util.Environment
import grails.util.GrailsUtil
import org.codehaus.groovy.grails.web.context.ServletContextHolder

import java.security.SecureRandom

/**
 * Created by hitenpratap on 27/08/16.
 */
class AppUtil {

    public static final DATE_FORMAT = 'dd/MM/yyyy'

    static Boolean save(def object) {
        Boolean result = false
        if (object.validate() && !object.hasErrors() && object.save(flush: true)) {
            result = true
        } else {
            object.errors.allErrors.each {
                println '----------------------' + it

            }
            result = false

        }
        return result
    }

    public static String getStaticResourcesDirPath() {
        String path = '';
        if (GrailsUtil.developmentEnv) {
            path = ServletContextHolder.getServletContext().getRealPath("/") + "TestFiles"
        } else {
            path = '/home/ubuntu/fintechtimes'
        }
        return path
    }

    public static String getProtocolType() {
        String path = '';
        if (Environment.current == Environment.PRODUCTION) {
            return "https://"
        } else {
            return "http://"
        }
    }

    public static String getTestDataStaticResourcePath() {
        return new File('web-app/test-data/').absolutePath + "/"
    }

    public static String getStaticPath() {
        return ServletContextHolder.getServletContext().getRealPath("/")
    }

    public static String getUrlWithHttp(String url) {
        if (url && !url?.contains("http://")) {
            url = "http://" + url
        }
        return url
    }

    static String getUniqueId(String word, Long id1) {
//        String word = object.class.getSimpleName().charAt(0)
        String userId = Long.toString(id1)
        int idSize = 6
        int loopLimit = idSize - userId.length()
        for (int i = 0; i < loopLimit; i++) {
            userId = "0" + userId
        }
        return userId
    }

    static String nameToUrl(String name) {
        return name.replaceAll(" ", "-")
    }

    static String urlToName(String url) {
        return url.replaceAll("-", " ")
    }

    public static String getUniqueStr() {
        new BigInteger(130, new SecureRandom()).toString(32)
    }

    public static Boolean isProductionEnvironment() {
        Environment.current == Environment.PRODUCTION
    }

}
