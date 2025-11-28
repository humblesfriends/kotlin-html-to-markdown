package com.mltheuser.khtmlmarkdown

import kotlin.test.Test
import kotlin.test.assertEquals

class ListTest {
    private val converter = KHtmlToMarkdown.Builder().build()

    @Test
    fun testUnorderedList() {
        val html =
                """
            <ul>
                <li>Item 1</li>
                <li>Item 2</li>
            </ul>
        """.trimIndent()

        val expected = """
            * Item 1
            * Item 2
        """.trimIndent()

        assertEquals(expected, converter.convert(html))
    }

    @Test
    fun testOrderedList() {
        val html =
                """
            <ol>
                <li>First</li>
                <li>Second</li>
            </ol>
        """.trimIndent()

        val expected = """
            1. First
            1. Second
        """.trimIndent()

        assertEquals(expected, converter.convert(html))
    }

    @Test
    fun testNestedLists() {
        val html =
                """
            <ul>
                <li>Item 1</li>
                <li>Item 2
                    <ul>
                        <li>Sub 1</li>
                        <li>Sub 2</li>
                    </ul>
                </li>
            </ul>
        """.trimIndent()

        // Expected logic:
        // UL (Root)
        //   LI (Indent 0) -> "* Item 1"
        //   LI (Indent 0) -> "* Item 2"
        //     UL (Nested) -> Indent 1
        //       LI (Indent 1) -> "    * Sub 1"

        val expected =
                """
            * Item 1
            * Item 2
                * Sub 1
                * Sub 2
        """.trimIndent()

        assertEquals(expected, converter.convert(html))
    }

    @Test
    fun testMixedLists() {
        val html =
                """
            <ul>
                <li>Item 1
                    <ol>
                        <li>Ordered 1</li>
                    </ol>
                </li>
            </ul>
        """.trimIndent()

        val expected =
                """
            * Item 1
                1. Ordered 1
        """.trimIndent()

        assertEquals(expected, converter.convert(html))
    }
}
