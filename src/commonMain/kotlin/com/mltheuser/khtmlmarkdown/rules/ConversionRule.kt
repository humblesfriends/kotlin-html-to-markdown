package com.mltheuser.khtmlmarkdown.rules

import com.mltheuser.khtmlmarkdown.ConversionContext
import com.mltheuser.khtmlmarkdown.dom.KElement

/**
 * A rule that knows how to convert a specific HTML tag to Markdown.
 */
public fun interface ConversionRule {
    public fun convert(element: KElement, context: ConversionContext): String
}