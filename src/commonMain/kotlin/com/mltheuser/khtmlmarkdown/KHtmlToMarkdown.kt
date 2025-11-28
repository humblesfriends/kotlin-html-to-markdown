package com.mltheuser.khtmlmarkdown

import com.mltheuser.khtmlmarkdown.dom.DomBuildingHandler
import com.mltheuser.khtmlmarkdown.dom.KElement
import com.mltheuser.khtmlmarkdown.registry.RuleRegistry
import com.mltheuser.khtmlmarkdown.rules.*
import com.mohamedrejeb.ksoup.html.parser.KsoupHtmlParser

public class KHtmlToMarkdown
private constructor(private val registry: RuleRegistry, private val options: ConverterOptions) {

    public fun convert(html: String): String {
        val handler = DomBuildingHandler()
        val parser = KsoupHtmlParser(handler = handler)
        parser.write(html)
        parser.end()

        val root = handler.getRoot()
        // Try to find body, otherwise use root
        val body = findBody(root) ?: root

        val context = DefaultConversionContext(registry, options)
        return context.processChildren(body).trim()
    }

    private fun findBody(element: KElement): KElement? {
        if (element.tagName == "body") return element
        for (child in element.children) {
            if (child is KElement) {
                val found = findBody(child)
                if (found != null) return found
            }
        }
        return null
    }

    /** Entry point for the DSL. */
    public class Builder {
        private val registry = RuleRegistry()
        private var options = ConverterOptions()

        init {
            registerDefaultRules()
        }

        private fun registerDefaultRules() {
            // Blocks
            registry.register("p", ParagraphRule)
            registry.register("br", BrRule)
            registry.register("hr", HrRule)
            (1..6).forEach { level -> registry.register("h$level", HeadingRule) }
            registry.register("pre", PreCodeRule)

            // Inline
            registry.register("b", StrongRule)
            registry.register("strong", StrongRule)
            registry.register("i", EmphasisRule)
            registry.register("em", EmphasisRule)
            registry.register("s", StrikethroughRule)
            registry.register("del", StrikethroughRule)
            registry.register("strike", StrikethroughRule)
            registry.register("code", CodeRule)
            registry.register("a", LinkRule)
            registry.register("img", ImageRule)

            // Lists
            registry.register("ul", ListRule)
            registry.register("ol", ListRule)
            registry.register("li", ListItemRule)

            // Tables
            registry.register("table", TableRule)
            registry.register("thead", TableSectionRule)
            registry.register("tbody", TableSectionRule)
            registry.register("tfoot", TableSectionRule)
            registry.register("tr", TrRule)
            registry.register("th", TableCellRule)
            registry.register("td", TableCellRule)
        }

        /** Configure global options. */
        public fun options(block: OptionsBuilder.() -> Unit): Builder {
            val builder = OptionsBuilder(options)
            builder.block()
            options = builder.build()
            return this
        }

        /** Add or replace a rule for a specific tag. */
        public fun rule(
                tagName: String,
                handler: (KElement, ConversionContext) -> String
        ): Builder {
            registry.register(
                    tagName,
                    ConversionRule { element, context -> handler(element, context) }
            )
            return this
        }

        /** Add or replace a rule using a class implementation. */
        public fun rule(tagName: String, rule: ConversionRule): Builder {
            registry.register(tagName, rule)
            return this
        }

        public fun build(): KHtmlToMarkdown {
            return KHtmlToMarkdown(registry, options)
        }
    }

    public class OptionsBuilder(current: ConverterOptions) {
        public var bulletCharacter: String = current.bulletCharacter
        public var strongDelimiter: String = current.strongDelimiter
        public var emDelimiter: String = current.emDelimiter

        internal fun build() =
                ConverterOptions(
                        bulletCharacter = bulletCharacter,
                        strongDelimiter = strongDelimiter,
                        emDelimiter = emDelimiter
                )
    }
}
