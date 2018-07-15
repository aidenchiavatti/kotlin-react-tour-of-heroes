package index

import dashboard.dashboard
import heroes.heroes
import kotlinext.js.require
import kotlinext.js.requireAll
import react.dom.a
import react.dom.nav
import react.dom.render
import react.router.dom.browserRouter
import react.router.dom.route
import react.router.dom.switch
import kotlin.browser.document

fun main(args: Array<String>) {
//    requireAll(require.context("src", true, js("/\\.css$/")))

    render(document.getElementById("root")) {
        requireAll(kotlinext.js.require.context("src/index", false, js("/\\.css$/")))

        nav {
            a {
                attrs.href = "/"
                +"Dashboard"
            }
            a {
                attrs.href = "/heroes"
                +"Heroes"
            }
        }

        browserRouter {
            switch {
                route("/", exact = true) {
                    dashboard()
                }
                route("/heroes", strict = true) {
                    heroes()
                }
            }
        }
    }
}
