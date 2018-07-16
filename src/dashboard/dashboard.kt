package dashboard

import heroes.getHeroes
import kotlinext.js.requireAll
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.a
import react.dom.div
import react.dom.h2

class Dashboard : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        requireAll(kotlinext.js.require.context("src/dashboard", false, js("/\\.css$/")))

        h2 {
            +"Dashboard"
        }

        div("grid grid-pad") {
            for(hero in getHeroes()) {
                a(classes = "col-1-4") {
                    div("module hero") {
                        +hero.name
                    }
                }
            }
        }
    }
}

fun RBuilder.dashboard() = child(Dashboard::class) {}