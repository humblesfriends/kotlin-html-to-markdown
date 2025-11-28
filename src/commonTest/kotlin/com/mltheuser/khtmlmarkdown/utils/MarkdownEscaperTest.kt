package com.mltheuser.khtmlmarkdown.utils

import kotlin.test.Test
import kotlin.test.assertEquals

class MarkdownEscaperTest {

    @Test
    fun `Global Escapes - Backslash`() {
        assertEquals("\\\\", MarkdownEscaper.escape("\\"))
        assertEquals("\\\\a", MarkdownEscaper.escape("\\a"))
    }

    @Test
    fun `Global Escapes - Backticks`() {
        assertEquals("\\`code\\`", MarkdownEscaper.escape("`code`"))
        assertEquals("\\`", MarkdownEscaper.escape("`"))
    }

    @Test
    fun `Global Escapes - Open Bracket`() {
        assertEquals("\\[link]", MarkdownEscaper.escape("[link]"))
        assertEquals("\\[", MarkdownEscaper.escape("["))
    }

    @Test
    fun `Global Escapes - Asterisk Smart`() {
        assertEquals("\\*bold\\*", MarkdownEscaper.escape("*bold*"))
        assertEquals("3 * 4", MarkdownEscaper.escape("3 * 4"))
        assertEquals("\\* start", MarkdownEscaper.escape("* start"))
        assertEquals("end \\*", MarkdownEscaper.escape("end *"))
    }

    @Test
    fun `Start-of-Line - Headers`() {
        assertEquals("\\# Header", MarkdownEscaper.escape("# Header"))
        assertEquals("\\#Header", MarkdownEscaper.escape("#Header")) // Safe rule
        assertEquals("Not # Header", MarkdownEscaper.escape("Not # Header"))
    }

    @Test
    fun `Start-of-Line - Lists`() {
        assertEquals("\\- Item", MarkdownEscaper.escape("- Item"))
        assertEquals("\\+ Item", MarkdownEscaper.escape("+ Item"))
        assertEquals("5 - 3", MarkdownEscaper.escape("5 - 3"))
        assertEquals("5 + 3", MarkdownEscaper.escape("5 + 3"))
    }

    @Test
    fun `Start-of-Line - Blockquotes`() {
        assertEquals("\\> Quote", MarkdownEscaper.escape("> Quote"))
        assertEquals("5 > 3", MarkdownEscaper.escape("5 > 3"))
    }

    @Test
    fun `Start-of-Line - Ordered Lists`() {
        assertEquals("1\\. Item", MarkdownEscaper.escape("1. Item"))
        assertEquals("1998\\. Year", MarkdownEscaper.escape("1998. Year"))
        assertEquals("Chapter 1.", MarkdownEscaper.escape("Chapter 1."))
    }

    @Test
    fun `Numbers with Dots and Commas - Not Escaped`() {
        // Decimal numbers should NOT be escaped
        assertEquals("1.2", MarkdownEscaper.escape("1.2"))
        assertEquals("3.14159", MarkdownEscaper.escape("3.14159"))
        assertEquals("99.99", MarkdownEscaper.escape("99.99"))

        // Comma-separated numbers should NOT be escaped
        assertEquals("3,4,5", MarkdownEscaper.escape("3,4,5"))
        assertEquals("1,000", MarkdownEscaper.escape("1,000"))
        assertEquals("1,000,000.50", MarkdownEscaper.escape("1,000,000.50"))

        // Mixed scenarios
        assertEquals("Price: 1.99", MarkdownEscaper.escape("Price: 1.99"))
        assertEquals(
                "The value 42.5 is interesting",
                MarkdownEscaper.escape("The value 42.5 is interesting")
        )
    }

    @Test
    fun `Start-of-Line - Fences`() {
        // Backticks are globally escaped, so ``` becomes \`\`\` which is safe
        assertEquals("\\`\\`\\`", MarkdownEscaper.escape("```"))
        assertEquals("\\~~~", MarkdownEscaper.escape("~~~"))
        assertEquals("~", MarkdownEscaper.escape("~"))
    }

    @Test
    fun `Lookahead - Images`() {
        assertEquals("\\!\\[Image]", MarkdownEscaper.escape("![Image]"))
        assertEquals("Hi!", MarkdownEscaper.escape("Hi!"))
    }

    @Test
    fun `Lookahead - HTML`() {
        assertEquals("\\<tag", MarkdownEscaper.escape("<tag"))
        assertEquals("\\<http", MarkdownEscaper.escape("<http"))
        assertEquals("5 < 10", MarkdownEscaper.escape("5 < 10"))
    }

    @Test
    fun `Lookahead - Underscore Smart`() {
        assertEquals("\\_italic\\_", MarkdownEscaper.escape("_italic_"))
        assertEquals("snake_case", MarkdownEscaper.escape("snake_case"))
        assertEquals("\\_start", MarkdownEscaper.escape("_start"))
        assertEquals("end\\_", MarkdownEscaper.escape("end_"))
    }

    @Test
    fun `Context-Aware - Pipe in Tables`() {
        // Pipes should NOT be escaped outside of tables (default)
        assertEquals("Option | A", MarkdownEscaper.escape("Option | A"))
        assertEquals("a | b | c", MarkdownEscaper.escape("a | b | c"))

        // Pipes SHOULD be escaped inside tables
        assertEquals("Option \\| A", MarkdownEscaper.escape("Option | A", inTable = true))
        assertEquals("a \\| b \\| c", MarkdownEscaper.escape("a | b | c", inTable = true))
        assertEquals("\\|", MarkdownEscaper.escape("|", inTable = true))
    }

    @Test
    fun `Complex Scenarios`() {
        val input =
                """
            # Header
            - List Item
            * Bold *
            _Italic_
            snake_case
            [Link](url)
            ![Image](url)
            <tag>
            1. Ordered
            ```
            code
            ```
        """.trimIndent()

        val expected =
                """
            \# Header
            \- List Item
            \* Bold \*
            \_Italic\_
            snake_case
            \[Link](url)
            \!\[Image](url)
            \<tag>
            1\. Ordered
            \`\`\`
            code
            \`\`\`
        """.trimIndent()

        assertEquals(expected, MarkdownEscaper.escape(input))
    }
}
