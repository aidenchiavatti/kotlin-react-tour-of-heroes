package heroes

import heroDetail.heroDetail
import kotlinext.js.requireAll
import kotlinx.html.classes
import kotlinx.html.js.onClickFunction
import react.*
import react.dom.h2
import react.dom.li
import react.dom.span
import react.dom.ul
import shared.Hero

class Heroes: RComponent<RProps, Heroes.State>() {
    init {
        state.heroes = getHeroes()
    }

    override fun RBuilder.render() {
        requireAll(kotlinext.js.require.context("src/heroes", false, js("/\\.css$/")))

        h2 {
            +"My Heroes"
        }

        ul("heroes") {
            for(hero in state.heroes) {
                li {
                    if(state.selectedHero == hero) {
                        attrs {
                            classes = setOf("selected")
                        }
                    }
                    attrs.onClickFunction = {
                        setState {
                            selectedHero = hero
                        }
                    }
                    span("badge") {
                        +"${hero.id}"
                    }
                    +hero.name
                }
            }
        }


        if(state.selectedHero != undefined) {
            heroDetail(state.selectedHero)
        }
    }

    interface State: RState {
        var selectedHero: Hero
        var heroes: Array<Hero>
    }

    var handleName = fun(input: String) {
        setState {
            selectedHero.name = input
        }
    }
}

fun RBuilder.heroes() = child(Heroes::class) {}

fun getHeroes(): Array<Hero> {
    return arrayOf(
            Hero(11, "Mr. Nice"),
            Hero(12, "Narco"),
            Hero(13, "Bombasto"),
            Hero(14, "Windstorm")
    )
}
