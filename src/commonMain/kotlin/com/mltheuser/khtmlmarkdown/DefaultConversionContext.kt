package com.mltheuser.khtmlmarkdown

import com.mltheuser.khtmlmarkdown.dom.HtmlConstants
import com.mltheuser.khtmlmarkdown.dom.KElement
import com.mltheuser.khtmlmarkdown.dom.KNode
import com.mltheuser.khtmlmarkdown.dom.KTextNode
import com.mltheuser.khtmlmarkdown.registry.RuleRegistry
import com.mltheuser.khtmlmarkdown.utils.MarkdownEscaper
import com.mltheuser.khtmlmarkdown.utils.MarkdownStringBuilder

internal data class DefaultConversionContext(
        private val registry: RuleRegistry,
        override val options: ConverterOptions,
        override val listType: ListType = ListType.NONE,
        override val indentLevel: Int = 0,
        override val inTable: Boolean = false
) : ConversionContext {

    override fun subContext(
            listType: ListType?,
            incrementIndent: Boolean,
            inTable: Boolean?
    ): ConversionContext {
        return this.copy(
                listType = listType ?: this.listType,
                indentLevel = if (incrementIndent) this.indentLevel + 1 else this.indentLevel,
                inTable = inTable ?: this.inTable
        )
    }

    override fun processChildren(element: KElement): String {
        val builder = MarkdownStringBuilder()
        val children = element.children

        for (i in children.indices) {
            val child = children[i]
            var result = processNode(child)

            if (child is KTextNode) {
                val prev = children.getOrNull(i - 1)
                val next = children.getOrNull(i + 1)
                val isPrevBlock = prev != null && HtmlConstants.isBlock(prev)
                val isNextBlock = next != null && HtmlConstants.isBlock(next)

                if (isPrevBlock) result = result.trimStart()
                if (isNextBlock) result = result.trimEnd()
            }

            builder.append(result)
        }
        return builder.toString()
    }

    private fun processNode(node: KNode): String {
        return when (node) {
            is KTextNode -> cleanText(node.text)
            is KElement -> {
                val rule = registry.getRule(node.tagName.lowercase())
                if (rule != null) {
                    rule.convert(node, this)
                } else {
                    processChildren(node)
                }
            }
        }
    }

    private fun cleanText(text: String): String {
        val collapsed = text.replace("\\s+".toRegex(), " ")
        return MarkdownEscaper.escape(collapsed, inTable = inTable)
    }
}
