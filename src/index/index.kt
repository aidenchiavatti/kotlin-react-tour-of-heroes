package index

import dashboard.dashboard
import heroDetail.heroDetail
import heroes.getHeroes
import heroes.heroes
import kotlinext.js.require
import kotlinext.js.requireAll
import react.RProps
import react.dom.a
import react.dom.div
import react.dom.nav
import react.dom.render
import react.router.dom.browserRouter
import react.router.dom.route
import react.router.dom.switch
import shared.Hero
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
                route("/heroes", exact = true) {
                    heroes()
                }
                route<IdProps>("/heroes/:id") { props ->
                    val hero = getHeroes().find { hero -> hero.id == +props.match.params.id}
                    heroDetail(hero!!)
                }
            }
        }
    }
}

interface IdProps : RProps {
    var id: Int
}
