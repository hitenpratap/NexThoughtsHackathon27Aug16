package com.fintechtimes

import com.fintechtimes.Author.Author

/**
 * Created by hitenpratap on 27/08/16.
 */
class BootstrapService {

    public void main() {
        createRoles()
        createAuthors()
    }

    public void createRoles() {
        if (Role.count < 1) {
            new Role(authority: 'ROLE_ADMIN').save(flush: true)
            new Role(authority: 'ROLE_AUTHOR').save(flush: true)
        }
    }

    public void createAuthors() {
        if (Author.count < 1) {
            new File("${AppUtil.staticResourcesDirPath}/Author_DATA.csv").eachCsvLine { tokens ->
                Author author = new Author(tokens)
                AppUtil.save(author)
                UserRole.create(author, Role.findByAuthority("ROLE_AUTHOR"))
            }
        }
    }

}
