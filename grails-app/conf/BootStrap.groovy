class BootStrap {

    def bootstrapService

    def init = { servletContext ->
        bootstrapService.main()
    }
    def destroy = {
    }
}
