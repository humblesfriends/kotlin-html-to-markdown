package com.mltheuser.khtmlmarkdown.rules

import com.mltheuser.khtmlmarkdown.ConversionContext
import com.mltheuser.khtmlmarkdown.rules.ConversionRule
import com.mltheuser.khtmlmarkdown.dom.KElement

// 1. Paragraphs: <p> -> Text + Double Newlines (surrounding)
public object ParagraphRule : ConversionRule {
    override fun convert(element: KElement, context: ConversionContext): String {
        val content = context.processChildren(element).trim()
        if (content.isEmpty()) return ""
        // Prepend AND append newlines. Builder handles deduplication.
        return "\n\n" + content + "\n\n"
    }
}

// 2. Headings: <h1>..<h6> -> # Text
public object HeadingRule : ConversionRule {
    override fun convert(element: KElement, context: ConversionContext): String {
        val content = context.processChildren(element).trim()
        if (content.isEmpty()) return ""

        val level = element.tagName.last().digitToIntOrNull() ?: 1
        val prefix = "#".repeat(level) + " "

        return "\n\n" + prefix + content + "\n\n"
    }
}

// 3. Line Break (Unchanged)
public object BrRule : ConversionRule {
    override fun convert(element: KElement, context: ConversionContext): String {
        return "  \n"
    }
}

// 4. Horizontal Rule (Updated for consistency)
public object HrRule : ConversionRule {
    override fun convert(element: KElement, context: ConversionContext): String {
        return "\n\n---\n\n"
    }
}