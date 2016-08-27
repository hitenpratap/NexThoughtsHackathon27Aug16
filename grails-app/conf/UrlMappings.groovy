class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/${year}/${month}/${day}/${articleTitle}/${articleId}"(controller: 'article', action: 'view')
        "/"(view: "/index")
        "500"(view: '/error')
    }
}
