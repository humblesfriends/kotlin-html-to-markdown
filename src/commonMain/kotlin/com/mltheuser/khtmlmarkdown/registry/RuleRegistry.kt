package com.mltheuser.khtmlmarkdown.registry

import com.mltheuser.khtmlmarkdown.rules.ConversionRule

public class RuleRegistry {
    private val rules = mutableMapOf<String, ConversionRule>()

    public fun register(tagName: String, rule: ConversionRule) {
        rules[tagName] = rule
    }

    public fun getRule(tagName: String): ConversionRule? {
        return rules[tagName]
    }
}