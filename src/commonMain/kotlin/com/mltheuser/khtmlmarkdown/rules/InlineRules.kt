package com.mltheuser.khtmlmarkdown.rules

import com.mltheuser.khtmlmarkdown.ConversionContext
import com.mltheuser.khtmlmarkdown.dom.KElement
import com.mltheuser.khtmlmarkdown.dom.KTextNode

// Helper for "<b> foo </b>" -> " **foo** "
private fun wrapWithValidWhitespace(content: String, delimiter: String): String {
    if (content.isEmpty()) return ""

    var text = content
    var prefix = ""
    var suffix = ""

    // Move leading space out
    if (text.startsWith(" ")) {
        prefix = " "
        text = text.trimStart()
    }
    // Move trailing space out
    if (text.endsWith(" ")) {
        suffix = " "
        text = text.trimEnd()
    }

    if (text.isEmpty()) return "$prefix$suffix" // contained only space

    return "$prefix$delimiter$text$delimiter$suffix"
}

// 1. Bold: <b>, <strong>
public object StrongRule : ConversionRule {
    override fun convert(element: KElement, context: ConversionContext): String {
        val content = context.processChildren(element)
        return wrapWithValidWhitespace(content, context.options.strongDelimiter)
    }
}

// 2. Italic: <i>, <em>
public object EmphasisRule : ConversionRule {
    override fun convert(element: KElement, context: ConversionContext): String {
        val content = context.processChildren(element)
        return wrapWithValidWhitespace(content, context.options.emDelimiter)
    }
}

// 3. Strikethrough: <s>, <del>, <strike>
public object StrikethroughRule : ConversionRule {
    override fun convert(element: KElement, context: ConversionContext): String {
        val content = context.processChildren(element)
        return wrapWithValidWhitespace(content, "~~")
    }
}

// 4. Code: <code>
public object CodeRule : ConversionRule {
    override fun convert(element: KElement, context: ConversionContext): String {
        // Extract content raw (no escaping)
        val sb = StringBuilder()
        fun extractText(element: KElement) {
            for (child in element.children) {
                when (child) {
                    is KTextNode -> sb.append(child.text)
                    is KElement -> extractText(child)
                }
            }
        }
        extractText(element)
        val content = sb.toString()

        if (content.isEmpty()) return ""

        // Handle backticks inside the code
        val delimiter = if (content.contains("`")) "``" else "`"
        // If the content starts or ends with a backtick, we need spaces
        val padding = if (content.startsWith("`") || content.endsWith("`")) " " else ""

        return "$delimiter$padding$content$padding$delimiter"
    }
}

// 5. Link: <a>
public object LinkRule : ConversionRule {
    override fun convert(element: KElement, context: ConversionContext): String {
        val content = context.processChildren(element)
        val href = element.attributes["href"] ?: ""
        val title = element.attributes["title"]

        if (href.isEmpty()) return content

        val titlePart = if (title.isNullOrEmpty()) "" else " \"$title\""
        return "[$content]($href$titlePart)"
    }
}

// 6. Image: <img>
public object ImageRule : ConversionRule {
    override fun convert(element: KElement, context: ConversionContext): String {
        val src = element.attributes["src"] ?: ""
        val alt = element.attributes["alt"] ?: ""
        val title = element.attributes["title"]

        if (src.isEmpty()) return "" // Markdown images must have a source

        val titlePart = if (title.isNullOrEmpty()) "" else " \"$title\""
        return "![$alt]($src$titlePart)"
    }
}
