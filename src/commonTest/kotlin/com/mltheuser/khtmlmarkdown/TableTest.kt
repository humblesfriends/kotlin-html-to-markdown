package com.mltheuser.khtmlmarkdown

import kotlin.test.Test
import kotlin.test.assertEquals

class TableTest {
    private val converter = KHtmlToMarkdown.Builder().build()

    @Test
    fun testSimpleTable() {
        val html =
                """
            <table>
                <thead>
                    <tr>
                        <th>Head 1</th>
                        <th>Head 2</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Cell 1</td>
                        <td>Cell 2</td>
                    </tr>
                </tbody>
            </table>
        """.trimIndent()

        val expected =
                """
            | Head 1 | Head 2 |
            |---|---|
            | Cell 1 | Cell 2 |
        """.trimIndent()

        assertEquals(expected, converter.convert(html))
    }

    @Test
    fun testImplicitHeader() {
        // Table without thead, but with th
        val html =
                """
            <table>
                <tr>
                    <th>Title</th>
                    <th>Value</th>
                </tr>
                <tr>
                    <td>A</td>
                    <td>1</td>
                </tr>
            </table>
        """.trimIndent()

        val expected =
                """
            | Title | Value |
            |---|---|
            | A | 1 |
        """.trimIndent()

        assertEquals(expected, converter.convert(html))
    }

    @Test
    fun testPipeEscaping() {
        // Pipes inside content must be escaped
        val html =
                """
            <table>
                <tr><td>Option | A</td></tr>
            </table>
        """.trimIndent()

        // Note: Non-header row doesn't generate separator.
        // Pure GFM parsers might struggle with a table without header,
        // but naive conversion should just output the row.
        val expected = "| Option \\| A |"

        assertEquals(expected, converter.convert(html))
    }
}
