package heroDetail

import kotlinext.js.requireAll
import shared.Hero
import kotlinx.html.js.onChangeFunction
import org.w3c.dom.HTMLInputElement
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.*

class HeroDetail: RComponent<HeroDetail.Props, RState>() {

    override fun RBuilder.render() {
        requireAll(kotlinext.js.require.context("src/heroDetail", false, js("/\\.css$/")))

        h2 {
            +props.hero.name.toUpperCase()
        }
        div {
            span {
                +"id: "
            }
            +"${props.hero.id}"
        }
        div {
            label {
                +"name: "
            }
            input {
                attrs {
                    placeholder = "name"
                    value = props.hero.name
                    onChangeFunction = {
                        val target = it.target as HTMLInputElement
                    }
                }
            }
        }
    }
    interface Props: RProps {
        var hero: Hero
    }
}

fun RBuilder.heroDetail(hero: Hero) = child(HeroDetail::class) {
    attrs.hero = hero
}