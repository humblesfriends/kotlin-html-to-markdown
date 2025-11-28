package com.mltheuser.khtmlmarkdown.dom

public object HtmlConstants {
    public val blockTags: Set<String> = setOf(
        "address", "article", "aside", "blockquote", "canvas", "dd", "div", "dl", "dt",
        "fieldset", "figcaption", "figure", "footer", "form", "h1", "h2", "h3", "h4", "h5", "h6",
        "header", "hr", "li", "main", "nav", "noscript", "ol", "p", "pre", "section",
        "table", "thead", "tbody", "tfoot", "tr", "th", "td",
        "ul", "video", "body", "html", "root"
    )

    public fun isBlock(node: KNode): Boolean {
        return node is KElement && blockTags.contains(node.tagName.lowercase())
    }
}