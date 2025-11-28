package com.mltheuser.khtmlmarkdown.rules

import com.mltheuser.khtmlmarkdown.ConversionContext
import com.mltheuser.khtmlmarkdown.dom.KElement

// 1. Table Container
public object TableRule : ConversionRule {
    override fun convert(element: KElement, context: ConversionContext): String {
        // Enter table context
        val newContext = context.subContext(inTable = true)
        val content = newContext.processChildren(element).trim()
        if (content.isEmpty()) return ""
        return "\n\n" + content + "\n\n"
    }
}

// 2. Structural containers (thead, tbody, tfoot)
// These are transparent but we ensure they don't break the flow.
public object TableSectionRule : ConversionRule {
    override fun convert(element: KElement, context: ConversionContext): String {
        return context.processChildren(element)
    }
}

// 3. Table Row (TR)
public object TrRule : ConversionRule {
    override fun convert(element: KElement, context: ConversionContext): String {
        val content = context.processChildren(element).trim()
        if (content.isEmpty()) return ""

        // The children (Td/Th) will return strings like " content |"
        // So 'content' is " cell1 | cell2 |"
        // We prepend the opening pipe.
        val row = "| $content"

        // Separator Logic:
        // We need to add |---|---| if this row is a header.
        // Heuristic: If inside <thead> OR if children are <th>
        val isHeader = element.parent?.tagName == "thead" ||
                element.children.any { (it as? KElement)?.tagName == "th" }

        if (isHeader) {
            // Calculate columns based on actual Td/Th children processed
            val colCount = element.children.count {
                it is KElement && (it.tagName == "td" || it.tagName == "th")
            }

            if (colCount > 0) {
                val separator = "|---".repeat(colCount) + "|"
                return row + "\n" + separator + "\n"
            }
        }

        return row + "\n"
    }
}

// 4. Table Cell (TH/TD)
public object TableCellRule : ConversionRule {
    override fun convert(element: KElement, context: ConversionContext): String {
        val content = context.processChildren(element).trim()
        // Return content with trailing pipe.
        // Leading space handled here for clean alignment: " content |"
        return " $content |"
    }
}