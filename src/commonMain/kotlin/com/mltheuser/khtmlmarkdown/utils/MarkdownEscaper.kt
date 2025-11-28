package com.mltheuser.khtmlmarkdown.utils

internal object MarkdownEscaper {

    fun escape(text: String, inTable: Boolean = false): String {
        var result = text

        // 1. Global Escapes (Always)
        result = result.replace("\\", "\\\\")

        // Escape pipes only inside tables (where they are column delimiters)
        if (inTable) {
            result = result.replace("|", "\\|")
        }

        result = result.replace("`", "\\`")

        result = result.replace("[", "\\[")

        result = result.replace(Regex("(?<! )\\*|\\*(?! )"), "\\\\*")

        // 2. Start-of-Line Escapes
        result = result.replace(Regex("^#", RegexOption.MULTILINE), "\\\\#")

        result = result.replace(Regex("^([-+]) ", RegexOption.MULTILINE), "\\\\$1 ")

        result = result.replace(Regex("^>", RegexOption.MULTILINE), "\\\\>")

        result = result.replace(Regex("^(\\d+)\\.(?= )", RegexOption.MULTILINE), "\$1\\\\.")

        result = result.replace(Regex("^~~~", RegexOption.MULTILINE), "\\\\~~~")

        // 3. Lookahead Escapes
        result = result.replace(Regex("!(?=\\\\\\[)"), "\\\\!")

        result = result.replace(Regex("<(?=[a-zA-Z/!])"), "\\\\<")

        result = result.replace(Regex("\\b_|_\\b"), "\\\\_")

        return result
    }
}
