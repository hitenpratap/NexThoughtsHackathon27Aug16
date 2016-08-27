package com.fintechtimes

import com.fintechtimes.Admin.Admin
import com.fintechtimes.Author.Author

/**
 * Created by hitenpratap on 27/08/16.
 */
class BootstrapService {

    public void main() {
        createRoles()
        createAuthors()
        createAdmin()
    }

    public void createRoles() {
        if (Role.count < 1) {
            new Role(authority: 'ROLE_ADMIN').save(flush: true)
            new Role(authority: 'ROLE_AUTHOR').save(flush: true)
        }
    }

    public void createAuthors() {
        if (Author.count < 1) {
            new File("${AppUtil.staticResourcesDirPath}/Author_Data.csv").eachCsvLine { tokens ->
                Author author = new Author(tokens)
                AppUtil.save(author)
                UserRole.create(author, Role.findByAuthority("ROLE_AUTHOR"))
            }
        }
    }

    public void createAdmin() {
        if (Admin.count < 1) {
            Admin admin = new Admin(username: "admin1@email.com", password: "admin1928", firstName: "Admin", lastName: "Singh")
            AppUtil.save(admin)
            UserRole.create(admin, Role.findByAuthority("ROLE_ADMIN"))
        }
    }

}
