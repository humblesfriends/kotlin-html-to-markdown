// src/commonMain/kotlin/com/mltheuser/khtmlmarkdown/dom/Dom.kt
package com.mltheuser.khtmlmarkdown.dom

public sealed class KNode {
    public var parent: KElement? = null
}

public class KElement(
    public val tagName: String,
    public val attributes: Map<String, String> = emptyMap()
) : KNode() {
    public val children: MutableList<KNode> = mutableListOf()

    public fun appendChild(node: KNode) {
        node.parent = this
        children.add(node)
    }

    // Helper to check for classes
    public fun hasClass(className: String): Boolean {
        val classAttr = attributes["class"] ?: return false
        return classAttr.split(" ").contains(className)
    }
}

public class KTextNode(public val text: String) : KNode()