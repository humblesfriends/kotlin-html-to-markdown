package com.mltheuser.khtmlmarkdown.dom

import com.mohamedrejeb.ksoup.html.parser.KsoupHtmlHandler

public class DomBuildingHandler : KsoupHtmlHandler {
    private val root = KElement("root")
    private var current: KElement = root

    override fun onOpenTag(name: String, attributes: Map<String, String>, isImplied: Boolean) {
        val newElement = KElement(name, attributes)
        current.appendChild(newElement)
        current = newElement
    }

    override fun onCloseTag(name: String, isImplied: Boolean) {
        var temp: KElement? = current
        while (temp != null && temp != root) {
            if (temp.tagName == name) {
                current = temp.parent ?: root
                return
            }
            temp = temp.parent
        }
    }

    override fun onText(text: String) {
        current.appendChild(KTextNode(text))
    }

    public fun getRoot(): KElement = root
}
