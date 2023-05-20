package info.developia.reactive.api

import spock.lang.Specification

class LauncherSpec extends Specification {
    def "launcher throws no exception"() {
        when:
        new Launcher()
        then:
        noExceptionThrown()
    }
}
