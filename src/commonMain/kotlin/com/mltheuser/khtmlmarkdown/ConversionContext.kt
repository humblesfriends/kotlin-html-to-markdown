package com.mltheuser.khtmlmarkdown

import com.mltheuser.khtmlmarkdown.dom.KElement

public enum class ListType {
    NONE,
    UNORDERED, // ul
    ORDERED    // ol
}

public interface ConversionContext {
    val options: ConverterOptions // New property
    val listType: ListType
    val indentLevel: Int
    val inTable: Boolean

    fun processChildren(element: KElement): String

    fun subContext(
        listType: ListType? = null,
        incrementIndent: Boolean = false,
        inTable: Boolean? = null
    ): ConversionContext
}