package com.mltheuser.khtmlmarkdown

import kotlin.test.Test
import kotlin.test.assertEquals

class BasicTextTest {

    private val converter = KHtmlToMarkdown.Builder().build()

    @Test
    fun testRawTextCollapsing() {
        val html =
                """
            <div>
                Hello
                World
            </div>
        """.trimIndent()

        // HTML rules: surrounding whitespace and newlines collapse to single space
        // "Hello World" is expected.
        assertEquals("Hello World", converter.convert(html))
    }

    @Test
    fun testNestedStructureTransparency() {
        val html = "<span>Hello <b>World</b></span>"
        val markdown = converter.convert(html)

        assertEquals("Hello **World**", markdown)
    }

    @Test
    fun testHeadingsAndParagraphs() {
        val html =
                """
            <h1>Title</h1>
            <p>First paragraph.</p>
            <h2>Subtitle</h2>
            <p>Second paragraph.</p>
        """.trimIndent()

        val expected =
                """
            # Title

            First paragraph.

            ## Subtitle

            Second paragraph.
        """.trimIndent()

        assertEquals(expected, converter.convert(html))
    }

    @Test
    fun testBreaksAndHorizontalRules() {
        val html = "<p>Line 1<br>Line 2</p><hr><p>New Section</p>"

        // Note: Our rules output specific newlines, so we match that structure
        // P -> Text + \n\n
        // BR -> "  \n"
        // HR -> "\n---\n\n"

        val expected =
                """
            Line 1  
            Line 2

            ---

            New Section
        """.trimIndent()

        assertEquals(expected, converter.convert(html))
    }

    @Test
    fun testDeeplyNestedBlocks() {
        // Divs should be transparent, but the P tags inside should still format correctly
        val html =
                """
            <div>
                <div>
                    <h1>Header</h1>
                </div>
                <p>Text</p>
            </div>
        """.trimIndent()

        val expected = """
            # Header

            Text
        """.trimIndent()

        assertEquals(expected, converter.convert(html))
    }

    @Test
    fun testConsecutiveBreaks() {
        val html = "Line 1<br><br>Line 2"
        // <br> is "  \n". So <br><br> is "  \n  \n"
        // This visually renders as a blank line in Markdown, which is correct behavior for
        // <br><br>.
        val expected = "Line 1  \n  \nLine 2"
        assertEquals(expected, converter.convert(html))
    }

    @Test
    fun testEmptyBlocks() {
        val html = "<p></p><h1></h1><p>Text</p>"
        // Empty blocks typically result in empty strings.
        // If our logic works, the newlines attached to them might accumulate?
        // Let's see: P converts to "" -> append("") -> no newlines added.
        val expected = "Text"
        assertEquals(expected, converter.convert(html))
    }

    @Test
    fun testWhitespaceAroundBlocks() {
        // Whitespace between blocks should be ignored
        val html = """
            <h1>Head</h1>

            <p>Body</p>
        """.trimIndent()

        val expected = """
            # Head

            Body
        """.trimIndent()

        assertEquals(expected, converter.convert(html))
    }

    @Test
    fun testHeadingWithFormatting() {
        // Headings containing other tags (currently transparent/stripped)
        val html = "<h1>Title <span>Sub</span></h1>"
        val expected = "# Title Sub"
        assertEquals(expected, converter.convert(html))
    }

    @Test
    fun testMixedContentBlockAndText() {
        // Text node directly adjacent to a block inside a container
        val html = "<div>Start <p>Middle</p> End</div>"

        // "Start " is text.
        // <p>Middle</p> is block (generates \n\nMiddle\n\n)
        // " End" is text.
        // Result: Start \n\nMiddle\n\n End

        val expected =
                """
            Start

            Middle

            End
        """.trimIndent()

        // Note: The whitespace collapsing might leave a trailing space on "Start "
        // or a leading space on " End" depending on exact logic.
        // Current logic:
        // "Start " -> "Start "
        // <p> -> Block.
        // Is " " between Start and P? No, "Start " is one node.

        assertEquals(expected, converter.convert(html))
    }
    @Test
    fun `converts pre tag with code block`() {
        val html =
                """
            <pre><code class="language-kotlin">
            fun main() {
                println("Hello")
            }
            </code></pre>
        """.trimIndent()

        val expected =
                """
            ```kotlin
            
            fun main() {
                println("Hello")
            }
            
            ```
        """.trimIndent()

        assertEquals(expected, converter.convert(html))
    }

    @Test
    fun `converts pre tag with code block and lang prefix`() {
        val html =
                """
            <pre><code class="lang-java">
            public static void main(String[] args) {}
            </code></pre>
        """.trimIndent()

        val expected =
                """
            ```java
            
            public static void main(String[] args) {}
            
            ```
        """.trimIndent()

        assertEquals(expected, converter.convert(html))
    }

    @Test
    fun `converts pre tag with code block and no class`() {
        val html =
                """
            <pre><code>
            Just some code
            </code></pre>
        """.trimIndent()

        val expected =
                """
            ```
            
            Just some code
            
            ```
        """.trimIndent()

        assertEquals(expected, converter.convert(html))
    }

    @Test
    fun `converts inline code with backticks`() {
        val html = "<code>`backticks`</code>"
        val expected = "`` `backticks` ``"
        assertEquals(expected, converter.convert(html))
    }

    @Test
    fun `converts inline code with underscores`() {
        val html = "<code>foo_bar</code>"
        val expected = "`foo_bar`"
        assertEquals(expected, converter.convert(html))
    }

    @Test
    fun `converts pre tag with span child`() {
        val html = "<pre><span>A</span></pre>"
        val expected = "```\nA\n```"
        assertEquals(expected, converter.convert(html))
    }
}
