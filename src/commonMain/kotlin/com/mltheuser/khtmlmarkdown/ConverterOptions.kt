package com.mltheuser.khtmlmarkdown

public data class ConverterOptions(
    val bulletCharacter: String = "*",
    val strongDelimiter: String = "**",
    val emDelimiter: String = "*",
    val linkStyle: LinkStyle = LinkStyle.INLINE
)

public enum class LinkStyle {
    INLINE, // [text](url)
    // REFERENCE // [text][id] (Reserved for future impl)
}