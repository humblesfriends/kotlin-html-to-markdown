package com.mltheuser.khtmlmarkdown.rules

import com.mltheuser.khtmlmarkdown.ConversionContext
import com.mltheuser.khtmlmarkdown.dom.KElement
import com.mltheuser.khtmlmarkdown.dom.KTextNode

public object PreCodeRule : ConversionRule {
    override fun convert(element: KElement, context: ConversionContext): String {
        // Check if <pre> has exactly one child that is <code> (ignoring whitespace text nodes)
        val children = element.children.filter { !(it is KTextNode && it.text.isBlank()) }

        if (children.size == 1) {
            val codeElement = children.first() as? KElement
            if (codeElement != null && codeElement.tagName.lowercase() == "code") {
                return convertCodeBlock(codeElement)
            }
        }

        // Fallback: treat as code block without language
        // Pre tags should always be rendered as code blocks since they contain preformatted text
        return convertToCodeBlock(element)
    }

    private fun convertToCodeBlock(element: KElement): String {
        // Extract text content from the element (recursively)
        val sb = StringBuilder()
        fun extractText(el: KElement) {
            for (child in el.children) {
                when (child) {
                    is KTextNode -> sb.append(child.text)
                    is KElement -> extractText(child)
                }
            }
        }
        extractText(element)
        val content = sb.toString()

        return "\n\n```\n$content\n```\n\n"
    }

    private fun convertCodeBlock(codeElement: KElement): String {
        // Extract language
        var language = ""
        val classAttr = codeElement.attributes["class"]
        if (classAttr != null) {
            val classes = classAttr.split(" ")
            for (cls in classes) {
                if (cls.startsWith("lang-")) {
                    language = cls.removePrefix("lang-")
                    break
                } else if (cls.startsWith("language-")) {
                    language = cls.removePrefix("language-")
                    break
                } else {
                    // Maybe the class itself is the language (common in some highlighters)
                    // But usually there's a prefix. Let's stick to prefixes or maybe just take the
                    // first one if no prefix found?
                    // The requirement says "Look for common prefixes like lang-, language-, or just
                    // the class name itself."
                    // So if we haven't found a prefixed one, we might consider the class name.
                    // Let's prioritize prefixes.
                }
            }
            if (language.isEmpty() && classes.isNotEmpty()) {
                language = classes.first()
            }
        }

        // Extract content raw (no escaping)
        val sb = StringBuilder()
        fun extractText(element: KElement) {
            for (child in element.children) {
                when (child) {
                    is KTextNode -> sb.append(child.text)
                    is KElement ->
                            extractText(
                                    child
                            ) // Recurse if there are nested spans (e.g. syntax highlighting spans)
                }
            }
        }
        extractText(codeElement)
        val content = sb.toString()

        return "\n\n```$language\n$content\n```\n\n"
    }
}
