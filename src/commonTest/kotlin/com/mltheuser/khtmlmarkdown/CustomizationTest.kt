package com.mltheuser.khtmlmarkdown

import kotlin.test.Test
import kotlin.test.assertEquals

class CustomizationTest {

    @Test
    fun testDefaultUsage() {
        val converter = KHtmlToMarkdown.Builder().build()
        val html = "<ul><li>Item</li></ul>"
        val expected = "* Item"
        assertEquals(expected, converter.convert(html))
    }

    @Test
    fun testCustomOptions() {
        val converter =
                KHtmlToMarkdown.Builder()
                        .options {
                            bulletCharacter = "-"
                            strongDelimiter = "__"
                        }
                        .build()

        val html =
                """
            <ul><li>Item</li></ul>
            <p><b>Bold</b></p>
        """.trimIndent()

        val expected = """
            - Item

            __Bold__
        """.trimIndent()

        assertEquals(expected, converter.convert(html))
    }

    @Test
    fun testCustomRule() {
        // Example: Convert <div class="alert"> to Blockquote
        val converter =
                KHtmlToMarkdown.Builder()
                        .rule("div") { element, context ->
                            if (element.hasClass("alert")) {
                                "> " + context.processChildren(element) + "\n\n"
                            } else {
                                context.processChildren(element)
                            }
                        }
                        .build()

        val html =
                """
            <div class="alert">Warning!</div>
            <div>Normal text</div>
        """.trimIndent()

        val expected =
                """
            > Warning!
            
            Normal text
        """.trimIndent()

        assertEquals(expected, converter.convert(html))
    }
}
