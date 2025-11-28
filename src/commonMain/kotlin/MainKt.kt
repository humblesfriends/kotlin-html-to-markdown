import com.mltheuser.khtmlmarkdown.KHtmlToMarkdown

fun main() {
    val converter = KHtmlToMarkdown.Builder().build()

    val testOutput = converter.convert("""
        <article class="markdown-body entry-content container-lg" itemprop="text"><div class="markdown-heading" dir="auto"><h1 tabindex="-1" class="heading-element" dir="auto">Ksoup - Kotlin Multiplatform HTML Parser</h1><a id="user-content-ksoup---kotlin-multiplatform-html-parser" class="anchor" aria-label="Permalink: Ksoup - Kotlin Multiplatform HTML Parser" href="#ksoup---kotlin-multiplatform-html-parser"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path d="m7.775 3.275 1.25-1.25a3.5 3.5 0 1 1 4.95 4.95l-2.5 2.5a3.5 3.5 0 0 1-4.95 0 .751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018 1.998 1.998 0 0 0 2.83 0l2.5-2.5a2.002 2.002 0 0 0-2.83-2.83l-1.25 1.25a.751.751 0 0 1-1.042-.018.751.751 0 0 1-.018-1.042Zm-4.69 9.64a1.998 1.998 0 0 0 2.83 0l1.25-1.25a.751.751 0 0 1 1.042.018.751.751 0 0 1 .018 1.042l-1.25 1.25a3.5 3.5 0 1 1-4.95-4.95l2.5-2.5a3.5 3.5 0 0 1 4.95 0 .751.751 0 0 1-.018 1.042.751.751 0 0 1-1.042.018 1.998 1.998 0 0 0-2.83 0l-2.5 2.5a1.998 1.998 0 0 0 0 2.83Z"></path></svg></a></div>
        <p dir="auto">Ksoup is a lightweight Kotlin Multiplatform library for parsing HTML, extracting HTML tags, attributes, and text, and encoding and decoding HTML entities.</p>
        <p dir="auto"><a href="http://kotlinlang.org" rel="nofollow"><img src="https://camo.githubusercontent.com/a437f73db1de0d1bed89c568d7e011809d96e0827121feeeff12013d2b40af69/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6b6f746c696e2d322e312e302d626c75652e7376673f6c6f676f3d6b6f746c696e" alt="Kotlin" data-canonical-src="https://img.shields.io/badge/kotlin-2.1.0-blue.svg?logo=kotlin" style="max-width: 100%;"></a>
        <a href="https://github.com/MohamedRejeb"><img src="https://raw.githubusercontent.com/MohamedRejeb/MohamedRejeb/main/badges/mohamedrejeb.svg" alt="MohamedRejeb" style="max-width: 100%;"></a>
        <a href="https://opensource.org/licenses/Apache-2.0" rel="nofollow"><img src="https://camo.githubusercontent.com/109222cb0d1f59ed2e77b56722653623fa45f93e2bb201a6eef8561d26a52185/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4c6963656e73652d417061636865253230322e302d677265656e2e737667" alt="Apache-2.0" data-canonical-src="https://img.shields.io/badge/License-Apache%202.0-green.svg" style="max-width: 100%;"></a>
        <a href="https://github.com/MohamedRejeb/ksoup/actions"><img src="https://camo.githubusercontent.com/27ece339183f8885cb21c6eeeda88b0998d414020977cfc44e74f1ec71ed76cd/68747470733a2f2f736869656c64732e696f2f62616467652f6275696c642d70617373696e672d627269676874677265656e" alt="BuildPassing" data-canonical-src="https://shields.io/badge/build-passing-brightgreen" style="max-width: 100%;"></a>
        <a href="https://search.maven.org/search?q=g:%22com.mohamedrejeb.ksoup%22%20AND%20a:%22ksoup-html%22" rel="nofollow"><img src="https://camo.githubusercontent.com/9563583f47223c4ddb7063f5ccd618f48dd1d5700c31bc3b568baf2930148b01/68747470733a2f2f696d672e736869656c64732e696f2f6d6176656e2d63656e7472616c2f762f636f6d2e6d6f68616d656472656a65622e6b736f75702f6b736f75702d68746d6c" alt="Maven Central" data-canonical-src="https://img.shields.io/maven-central/v/com.mohamedrejeb.ksoup/ksoup-html" style="max-width: 100%;"></a></p>
        <p dir="auto"><a target="_blank" rel="noopener noreferrer" href="https://github.com/MohamedRejeb/ksoup/assets/41842296/fc352215-c8fd-4274-8fc0-ee1c587bb930"><img src="https://github.com/MohamedRejeb/ksoup/assets/41842296/fc352215-c8fd-4274-8fc0-ee1c587bb930" alt="Slide 16_9 - 1 (1)" style="max-width: 100%;"></a></p>
        <div class="markdown-heading" dir="auto"><h2 tabindex="-1" class="heading-element" dir="auto">Features</h2><a id="user-content-features" class="anchor" aria-label="Permalink: Features" href="#features"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path d="m7.775 3.275 1.25-1.25a3.5 3.5 0 1 1 4.95 4.95l-2.5 2.5a3.5 3.5 0 0 1-4.95 0 .751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018 1.998 1.998 0 0 0 2.83 0l2.5-2.5a2.002 2.002 0 0 0-2.83-2.83l-1.25 1.25a.751.751 0 0 1-1.042-.018.751.751 0 0 1-.018-1.042Zm-4.69 9.64a1.998 1.998 0 0 0 2.83 0l1.25-1.25a.751.751 0 0 1 1.042.018.751.751 0 0 1 .018 1.042l-1.25 1.25a3.5 3.5 0 1 1-4.95-4.95l2.5-2.5a3.5 3.5 0 0 1 4.95 0 .751.751 0 0 1-.018 1.042.751.751 0 0 1-1.042.018 1.998 1.998 0 0 0-2.83 0l-2.5 2.5a1.998 1.998 0 0 0 0 2.83Z"></path></svg></a></div>
        <ul dir="auto">
        <li>Parse HTML from String</li>
        <li>Extract HTML tags, attributes, and text</li>
        <li>Encode and decode HTML entities</li>
        <li>Lightweight and does not depend on any other library</li>
        <li>Kotlin Multiplatform support</li>
        <li>Fast and efficient</li>
        <li>Unit tested</li>
        </ul>
        <div class="markdown-heading" dir="auto"><h2 tabindex="-1" class="heading-element" dir="auto">Installation</h2><a id="user-content-installation" class="anchor" aria-label="Permalink: Installation" href="#installation"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path d="m7.775 3.275 1.25-1.25a3.5 3.5 0 1 1 4.95 4.95l-2.5 2.5a3.5 3.5 0 0 1-4.95 0 .751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018 1.998 1.998 0 0 0 2.83 0l2.5-2.5a2.002 2.002 0 0 0-2.83-2.83l-1.25 1.25a.751.751 0 0 1-1.042-.018.751.751 0 0 1-.018-1.042Zm-4.69 9.64a1.998 1.998 0 0 0 2.83 0l1.25-1.25a.751.751 0 0 1 1.042.018.751.751 0 0 1 .018 1.042l-1.25 1.25a3.5 3.5 0 1 1-4.95-4.95l2.5-2.5a3.5 3.5 0 0 1 4.95 0 .751.751 0 0 1-.018 1.042.751.751 0 0 1-1.042.018 1.998 1.998 0 0 0-2.83 0l-2.5 2.5a1.998 1.998 0 0 0 0 2.83Z"></path></svg></a></div>
        <p dir="auto"><a href="https://search.maven.org/search?q=g:%22com.mohamedrejeb.ksoup%22%20AND%20a:%22ksoup-html%22" rel="nofollow"><img src="https://camo.githubusercontent.com/9563583f47223c4ddb7063f5ccd618f48dd1d5700c31bc3b568baf2930148b01/68747470733a2f2f696d672e736869656c64732e696f2f6d6176656e2d63656e7472616c2f762f636f6d2e6d6f68616d656472656a65622e6b736f75702f6b736f75702d68746d6c" alt="Maven Central" data-canonical-src="https://img.shields.io/maven-central/v/com.mohamedrejeb.ksoup/ksoup-html" style="max-width: 100%;"></a></p>
        <p dir="auto">Add the dependency below to your <strong>module</strong>'s <code>build.gradle.kts</code> or <code>build.gradle</code> file:</p>
        <markdown-accessiblity-table data-catalyst=""><table>
        <thead>
        <tr>
        <th>Kotlin version</th>
        <th>Ksoup version</th>
        </tr>
        </thead>
        <tbody>
        <tr>
        <td>2.1.2x</td>
        <td>0.6.x</td>
        </tr>
        <tr>
        <td>2.1.0</td>
        <td>0.5.0</td>
        </tr>
        <tr>
        <td>2.0.x</td>
        <td>0.4.1</td>
        </tr>
        <tr>
        <td>1.9.2x</td>
        <td>0.3.x</td>
        </tr>
        <tr>
        <td>1.9.x</td>
        <td>0.2.1</td>
        </tr>
        <tr>
        <td>1.8.x</td>
        <td>0.1.4</td>
        </tr>
        </tbody>
        </table></markdown-accessiblity-table>
        <div class="highlight highlight-source-kotlin notranslate position-relative overflow-auto" dir="auto"><pre><span class="pl-k">val</span> version <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>0.6.0<span class="pl-pds">"</span></span>

        <span class="pl-c"><span class="pl-c">//</span> For parsing HTML</span>
        implementation(<span class="pl-s"><span class="pl-pds">"</span>com.mohamedrejeb.ksoup:ksoup-html:<span class="pl-e">${'$'}version</span><span class="pl-pds">"</span></span>)

        <span class="pl-c"><span class="pl-c">//</span> Only for encoding and decoding HTML entities </span>
        implementation(<span class="pl-s"><span class="pl-pds">"</span>com.mohamedrejeb.ksoup:ksoup-entities:<span class="pl-e">${'$'}version</span><span class="pl-pds">"</span></span>)</pre><div class="zeroclipboard-container">
            <clipboard-copy aria-label="Copy" class="ClipboardButton btn btn-invisible js-clipboard-copy m-2 p-0 d-flex flex-justify-center flex-items-center" data-copy-feedback="Copied!" data-tooltip-direction="w" value="val version = &quot;0.6.0&quot;

        // For parsing HTML
        implementation(&quot;com.mohamedrejeb.ksoup:ksoup-html:${'$'}version&quot;)

        // Only for encoding and decoding HTML entities 
        implementation(&quot;com.mohamedrejeb.ksoup:ksoup-entities:${'$'}version&quot;)" tabindex="0" role="button">
              <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-copy js-clipboard-copy-icon">
            <path d="M0 6.75C0 5.784.784 5 1.75 5h1.5a.75.75 0 0 1 0 1.5h-1.5a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-1.5a.75.75 0 0 1 1.5 0v1.5A1.75 1.75 0 0 1 9.25 16h-7.5A1.75 1.75 0 0 1 0 14.25Z"></path><path d="M5 1.75C5 .784 5.784 0 6.75 0h7.5C15.216 0 16 .784 16 1.75v7.5A1.75 1.75 0 0 1 14.25 11h-7.5A1.75 1.75 0 0 1 5 9.25Zm1.75-.25a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-7.5a.25.25 0 0 0-.25-.25Z"></path>
        </svg>
              <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-check js-clipboard-check-icon color-fg-success d-none">
            <path d="M13.78 4.22a.75.75 0 0 1 0 1.06l-7.25 7.25a.75.75 0 0 1-1.06 0L2.22 9.28a.751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018L6 10.94l6.72-6.72a.75.75 0 0 1 1.06 0Z"></path>
        </svg>
            </clipboard-copy>
          </div></div>
        <div class="markdown-heading" dir="auto"><h2 tabindex="-1" class="heading-element" dir="auto">Usage</h2><a id="user-content-usage" class="anchor" aria-label="Permalink: Usage" href="#usage"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path d="m7.775 3.275 1.25-1.25a3.5 3.5 0 1 1 4.95 4.95l-2.5 2.5a3.5 3.5 0 0 1-4.95 0 .751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018 1.998 1.998 0 0 0 2.83 0l2.5-2.5a2.002 2.002 0 0 0-2.83-2.83l-1.25 1.25a.751.751 0 0 1-1.042-.018.751.751 0 0 1-.018-1.042Zm-4.69 9.64a1.998 1.998 0 0 0 2.83 0l1.25-1.25a.751.751 0 0 1 1.042.018.751.751 0 0 1 .018 1.042l-1.25 1.25a3.5 3.5 0 1 1-4.95-4.95l2.5-2.5a3.5 3.5 0 0 1 4.95 0 .751.751 0 0 1-.018 1.042.751.751 0 0 1-1.042.018 1.998 1.998 0 0 0-2.83 0l-2.5 2.5a1.998 1.998 0 0 0 0 2.83Z"></path></svg></a></div>
        <div class="markdown-heading" dir="auto"><h3 tabindex="-1" class="heading-element" dir="auto">Parsing HTML</h3><a id="user-content-parsing-html" class="anchor" aria-label="Permalink: Parsing HTML" href="#parsing-html"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path d="m7.775 3.275 1.25-1.25a3.5 3.5 0 1 1 4.95 4.95l-2.5 2.5a3.5 3.5 0 0 1-4.95 0 .751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018 1.998 1.998 0 0 0 2.83 0l2.5-2.5a2.002 2.002 0 0 0-2.83-2.83l-1.25 1.25a.751.751 0 0 1-1.042-.018.751.751 0 0 1-.018-1.042Zm-4.69 9.64a1.998 1.998 0 0 0 2.83 0l1.25-1.25a.751.751 0 0 1 1.042.018.751.751 0 0 1 .018 1.042l-1.25 1.25a3.5 3.5 0 1 1-4.95-4.95l2.5-2.5a3.5 3.5 0 0 1 4.95 0 .751.751 0 0 1-.018 1.042.751.751 0 0 1-1.042.018 1.998 1.998 0 0 0-2.83 0l-2.5 2.5a1.998 1.998 0 0 0 0 2.83Z"></path></svg></a></div>
        <p dir="auto">To parse HTML from a String, use the <code>KsoupHtmlParser</code> class, and provide an implementation of the <code>KsoupHtmlHandler</code> interface, and a <code>KsoupHtmlOptions</code> object.
        Both of them are optional, you can use the default ones if you want.</p>
        <div class="markdown-heading" dir="auto"><h4 tabindex="-1" class="heading-element" dir="auto">KsoupHtmlParser</h4><a id="user-content-ksouphtmlparser" class="anchor" aria-label="Permalink: KsoupHtmlParser" href="#ksouphtmlparser"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path d="m7.775 3.275 1.25-1.25a3.5 3.5 0 1 1 4.95 4.95l-2.5 2.5a3.5 3.5 0 0 1-4.95 0 .751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018 1.998 1.998 0 0 0 2.83 0l2.5-2.5a2.002 2.002 0 0 0-2.83-2.83l-1.25 1.25a.751.751 0 0 1-1.042-.018.751.751 0 0 1-.018-1.042Zm-4.69 9.64a1.998 1.998 0 0 0 2.83 0l1.25-1.25a.751.751 0 0 1 1.042.018.751.751 0 0 1 .018 1.042l-1.25 1.25a3.5 3.5 0 1 1-4.95-4.95l2.5-2.5a3.5 3.5 0 0 1 4.95 0 .751.751 0 0 1-.018 1.042.751.751 0 0 1-1.042.018 1.998 1.998 0 0 0-2.83 0l-2.5 2.5a1.998 1.998 0 0 0 0 2.83Z"></path></svg></a></div>
        <p dir="auto">You can create a parser using the <code>KsoupHtmlParser()</code>, there are several methods that you can use, for example <code>write</code> to parse a String, and <code>end</code> to close the parser when you are done:</p>
        <div class="highlight highlight-source-kotlin notranslate position-relative overflow-auto" dir="auto"><pre><span class="pl-k">val</span> ksoupHtmlParser <span class="pl-k">=</span> <span class="pl-en">KsoupHtmlParser</span>()

        <span class="pl-c"><span class="pl-c">//</span> String to parse</span>
        <span class="pl-k">val</span> html <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>&lt;h1&gt;My Heading&lt;/h1&gt;<span class="pl-pds">"</span></span>

        <span class="pl-c"><span class="pl-c">//</span> Pass the HTML to the parser (It is going to parse the HTML and call the callbacks)</span>
        ksoupHtmlParser.write(html)

        <span class="pl-c"><span class="pl-c">//</span> Close the parser when you are done</span>
        ksoupHtmlParser.end()</pre><div class="zeroclipboard-container">
            <clipboard-copy aria-label="Copy" class="ClipboardButton btn btn-invisible js-clipboard-copy m-2 p-0 d-flex flex-justify-center flex-items-center" data-copy-feedback="Copied!" data-tooltip-direction="w" value="val ksoupHtmlParser = KsoupHtmlParser()

        // String to parse
        val html = &quot;&lt;h1&gt;My Heading&lt;/h1&gt;&quot;

        // Pass the HTML to the parser (It is going to parse the HTML and call the callbacks)
        ksoupHtmlParser.write(html)

        // Close the parser when you are done
        ksoupHtmlParser.end()" tabindex="0" role="button">
              <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-copy js-clipboard-copy-icon">
            <path d="M0 6.75C0 5.784.784 5 1.75 5h1.5a.75.75 0 0 1 0 1.5h-1.5a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-1.5a.75.75 0 0 1 1.5 0v1.5A1.75 1.75 0 0 1 9.25 16h-7.5A1.75 1.75 0 0 1 0 14.25Z"></path><path d="M5 1.75C5 .784 5.784 0 6.75 0h7.5C15.216 0 16 .784 16 1.75v7.5A1.75 1.75 0 0 1 14.25 11h-7.5A1.75 1.75 0 0 1 5 9.25Zm1.75-.25a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-7.5a.25.25 0 0 0-.25-.25Z"></path>
        </svg>
              <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-check js-clipboard-check-icon color-fg-success d-none">
            <path d="M13.78 4.22a.75.75 0 0 1 0 1.06l-7.25 7.25a.75.75 0 0 1-1.06 0L2.22 9.28a.751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018L6 10.94l6.72-6.72a.75.75 0 0 1 1.06 0Z"></path>
        </svg>
            </clipboard-copy>
          </div></div>
        <div class="markdown-heading" dir="auto"><h4 tabindex="-1" class="heading-element" dir="auto">KsoupHtmlHandler</h4><a id="user-content-ksouphtmlhandler" class="anchor" aria-label="Permalink: KsoupHtmlHandler" href="#ksouphtmlhandler"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path d="m7.775 3.275 1.25-1.25a3.5 3.5 0 1 1 4.95 4.95l-2.5 2.5a3.5 3.5 0 0 1-4.95 0 .751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018 1.998 1.998 0 0 0 2.83 0l2.5-2.5a2.002 2.002 0 0 0-2.83-2.83l-1.25 1.25a.751.751 0 0 1-1.042-.018.751.751 0 0 1-.018-1.042Zm-4.69 9.64a1.998 1.998 0 0 0 2.83 0l1.25-1.25a.751.751 0 0 1 1.042.018.751.751 0 0 1 .018 1.042l-1.25 1.25a3.5 3.5 0 1 1-4.95-4.95l2.5-2.5a3.5 3.5 0 0 1 4.95 0 .751.751 0 0 1-.018 1.042.751.751 0 0 1-1.042.018 1.998 1.998 0 0 0-2.83 0l-2.5 2.5a1.998 1.998 0 0 0 0 2.83Z"></path></svg></a></div>
        <p dir="auto">You can directly implement <code>KsoupHtmlHandler</code> interface or use <code>KsoupHtmlHandler.Builder()</code>:</p>
        <div class="highlight highlight-source-kotlin notranslate position-relative overflow-auto" dir="auto"><pre><span class="pl-c"><span class="pl-c">//</span> Implement `KsoupHtmlHandler` interface</span>
        <span class="pl-k">val</span> firstHandler <span class="pl-k">=</span> <span class="pl-k">object</span> <span class="pl-k">:</span> <span class="pl-en">KsoupHtmlHandler</span> {
            <span class="pl-k">override</span> <span class="pl-k">fun</span> <span class="pl-en">onOpenTag</span>(<span class="pl-smi">name</span><span class="pl-k">:</span> <span class="pl-c1">String</span>, <span class="pl-smi">attributes</span><span class="pl-k">:</span> <span class="pl-c1">Map</span>&lt;<span class="pl-en">String</span>, <span class="pl-en">String</span>&gt;, <span class="pl-smi">isImplied</span><span class="pl-k">:</span> <span class="pl-c1">Boolean</span>) {
                <span class="pl-c1">println</span>(<span class="pl-s"><span class="pl-pds">"</span>Open tag: <span class="pl-e">${'$'}name</span><span class="pl-pds">"</span></span>)
            }
        }

        <span class="pl-c"><span class="pl-c">//</span> Use `KsoupHtmlHandler.Builder()`</span>
        <span class="pl-k">val</span> secondHandler <span class="pl-k">=</span> <span class="pl-en">KsoupHtmlHandler</span>
            .<span class="pl-en">Builder</span>()
            .onOpenTag { name, attributes, isImplied <span class="pl-k">-&gt;</span>
                <span class="pl-c1">println</span>(<span class="pl-s"><span class="pl-pds">"</span>Open tag: <span class="pl-e">${'$'}name</span><span class="pl-pds">"</span></span>)
            }
            .build()</pre><div class="zeroclipboard-container">
            <clipboard-copy aria-label="Copy" class="ClipboardButton btn btn-invisible js-clipboard-copy m-2 p-0 d-flex flex-justify-center flex-items-center" data-copy-feedback="Copied!" data-tooltip-direction="w" value="// Implement `KsoupHtmlHandler` interface
        val firstHandler = object : KsoupHtmlHandler {
            override fun onOpenTag(name: String, attributes: Map&lt;String, String&gt;, isImplied: Boolean) {
                println(&quot;Open tag: ${'$'}name&quot;)
            }
        }

        // Use `KsoupHtmlHandler.Builder()`
        val secondHandler = KsoupHtmlHandler
            .Builder()
            .onOpenTag { name, attributes, isImplied -&gt;
                println(&quot;Open tag: ${'$'}name&quot;)
            }
            .build()" tabindex="0" role="button">
              <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-copy js-clipboard-copy-icon">
            <path d="M0 6.75C0 5.784.784 5 1.75 5h1.5a.75.75 0 0 1 0 1.5h-1.5a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-1.5a.75.75 0 0 1 1.5 0v1.5A1.75 1.75 0 0 1 9.25 16h-7.5A1.75 1.75 0 0 1 0 14.25Z"></path><path d="M5 1.75C5 .784 5.784 0 6.75 0h7.5C15.216 0 16 .784 16 1.75v7.5A1.75 1.75 0 0 1 14.25 11h-7.5A1.75 1.75 0 0 1 5 9.25Zm1.75-.25a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-7.5a.25.25 0 0 0-.25-.25Z"></path>
        </svg>
              <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-check js-clipboard-check-icon color-fg-success d-none">
            <path d="M13.78 4.22a.75.75 0 0 1 0 1.06l-7.25 7.25a.75.75 0 0 1-1.06 0L2.22 9.28a.751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018L6 10.94l6.72-6.72a.75.75 0 0 1 1.06 0Z"></path>
        </svg>
            </clipboard-copy>
          </div></div>
        <p dir="auto">There are several methods that you can override, for example is you want to just extract the text from the HTML, you can override the <code>onText</code> method:</p>
        <div class="highlight highlight-source-kotlin notranslate position-relative overflow-auto" dir="auto"><pre><span class="pl-c"><span class="pl-c">//</span> String to parse</span>
        <span class="pl-k">val</span> html <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">""${'"'}</span></span>
        <span class="pl-s">    &lt;html&gt;</span>
        <span class="pl-s">        &lt;head&gt;</span>
        <span class="pl-s">            &lt;title&gt;My Title&lt;/title&gt;</span>
        <span class="pl-s">        &lt;/head&gt;</span>
        <span class="pl-s">        &lt;body&gt;</span>
        <span class="pl-s">            &lt;h1&gt;My Heading&lt;/h1&gt;</span>
        <span class="pl-s">            &lt;p&gt;My paragraph.&lt;/p&gt;</span>
        <span class="pl-s">        &lt;/body&gt;</span>
        <span class="pl-s">    &lt;/html&gt;</span>
        <span class="pl-s"><span class="pl-pds">""${'"'}</span></span>.trimIndent()

        <span class="pl-c"><span class="pl-c">//</span> String to store the extracted text</span>
        <span class="pl-k">var</span> string <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span><span class="pl-pds">"</span></span>

        <span class="pl-c"><span class="pl-c">//</span> Create a handler</span>
        <span class="pl-k">val</span> handler <span class="pl-k">=</span> <span class="pl-en">KsoupHtmlHandler</span>
            .<span class="pl-en">Builder</span>()
            .onText { text <span class="pl-k">-&gt;</span>
                string <span class="pl-k">+</span><span class="pl-k">=</span> text
            }
            .build()

        <span class="pl-c"><span class="pl-c">//</span> Create a parser</span>
        <span class="pl-k">val</span> ksoupHtmlParser <span class="pl-k">=</span> <span class="pl-en">KsoupHtmlParser</span>(
            handler <span class="pl-k">=</span> handler,
        )

        <span class="pl-c"><span class="pl-c">//</span> Pass the HTML to the parser (It is going to parse the HTML and call the callbacks)</span>
        ksoupHtmlParser.write(html)

        <span class="pl-c"><span class="pl-c">//</span> Close the parser when you are done</span>
        ksoupHtmlParser.end()</pre><div class="zeroclipboard-container">
            <clipboard-copy aria-label="Copy" class="ClipboardButton btn btn-invisible js-clipboard-copy m-2 p-0 d-flex flex-justify-center flex-items-center" data-copy-feedback="Copied!" data-tooltip-direction="w" value="// String to parse
        val html = &quot;&quot;&quot;
            &lt;html&gt;
                &lt;head&gt;
                    &lt;title&gt;My Title&lt;/title&gt;
                &lt;/head&gt;
                &lt;body&gt;
                    &lt;h1&gt;My Heading&lt;/h1&gt;
                    &lt;p&gt;My paragraph.&lt;/p&gt;
                &lt;/body&gt;
            &lt;/html&gt;
        &quot;&quot;&quot;.trimIndent()

        // String to store the extracted text
        var string = &quot;&quot;

        // Create a handler
        val handler = KsoupHtmlHandler
            .Builder()
            .onText { text -&gt;
                string += text
            }
            .build()

        // Create a parser
        val ksoupHtmlParser = KsoupHtmlParser(
            handler = handler,
        )

        // Pass the HTML to the parser (It is going to parse the HTML and call the callbacks)
        ksoupHtmlParser.write(html)

        // Close the parser when you are done
        ksoupHtmlParser.end()" tabindex="0" role="button">
              <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-copy js-clipboard-copy-icon">
            <path d="M0 6.75C0 5.784.784 5 1.75 5h1.5a.75.75 0 0 1 0 1.5h-1.5a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-1.5a.75.75 0 0 1 1.5 0v1.5A1.75 1.75 0 0 1 9.25 16h-7.5A1.75 1.75 0 0 1 0 14.25Z"></path><path d="M5 1.75C5 .784 5.784 0 6.75 0h7.5C15.216 0 16 .784 16 1.75v7.5A1.75 1.75 0 0 1 14.25 11h-7.5A1.75 1.75 0 0 1 5 9.25Zm1.75-.25a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-7.5a.25.25 0 0 0-.25-.25Z"></path>
        </svg>
              <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-check js-clipboard-check-icon color-fg-success d-none">
            <path d="M13.78 4.22a.75.75 0 0 1 0 1.06l-7.25 7.25a.75.75 0 0 1-1.06 0L2.22 9.28a.751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018L6 10.94l6.72-6.72a.75.75 0 0 1 1.06 0Z"></path>
        </svg>
            </clipboard-copy>
          </div></div>
        <p dir="auto">You can also use <code>onOpenTag</code> and <code>onCloseTag</code> to know when a tag is opened or closed, it can be used for scrapping data from a website or powering a rich text editor,
        Also you can use <code>onComment</code> to know when a comment is found in the HTML and <code>onAttribute</code> to know when attributes are found in a tag.</p>
        <div class="markdown-heading" dir="auto"><h4 tabindex="-1" class="heading-element" dir="auto">KsoupHtmlOptions</h4><a id="user-content-ksouphtmloptions" class="anchor" aria-label="Permalink: KsoupHtmlOptions" href="#ksouphtmloptions"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path d="m7.775 3.275 1.25-1.25a3.5 3.5 0 1 1 4.95 4.95l-2.5 2.5a3.5 3.5 0 0 1-4.95 0 .751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018 1.998 1.998 0 0 0 2.83 0l2.5-2.5a2.002 2.002 0 0 0-2.83-2.83l-1.25 1.25a.751.751 0 0 1-1.042-.018.751.751 0 0 1-.018-1.042Zm-4.69 9.64a1.998 1.998 0 0 0 2.83 0l1.25-1.25a.751.751 0 0 1 1.042.018.751.751 0 0 1 .018 1.042l-1.25 1.25a3.5 3.5 0 1 1-4.95-4.95l2.5-2.5a3.5 3.5 0 0 1 4.95 0 .751.751 0 0 1-.018 1.042.751.751 0 0 1-1.042.018 1.998 1.998 0 0 0-2.83 0l-2.5 2.5a1.998 1.998 0 0 0 0 2.83Z"></path></svg></a></div>
        <p dir="auto">You can also pass <code>KsoupHtmlOptions</code> to the parser to change the behavior of the parser, you can for example disable the decoding of HTML entities which is enabled by default:</p>
        <div class="highlight highlight-source-kotlin notranslate position-relative overflow-auto" dir="auto"><pre><span class="pl-k">val</span> options <span class="pl-k">=</span> <span class="pl-en">KsoupHtmlOption</span>(
            decodeEntities <span class="pl-k">=</span> <span class="pl-c1">false</span>,
        )</pre><div class="zeroclipboard-container">
            <clipboard-copy aria-label="Copy" class="ClipboardButton btn btn-invisible js-clipboard-copy m-2 p-0 d-flex flex-justify-center flex-items-center" data-copy-feedback="Copied!" data-tooltip-direction="w" value="val options = KsoupHtmlOption(
            decodeEntities = false,
        )" tabindex="0" role="button">
              <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-copy js-clipboard-copy-icon">
            <path d="M0 6.75C0 5.784.784 5 1.75 5h1.5a.75.75 0 0 1 0 1.5h-1.5a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-1.5a.75.75 0 0 1 1.5 0v1.5A1.75 1.75 0 0 1 9.25 16h-7.5A1.75 1.75 0 0 1 0 14.25Z"></path><path d="M5 1.75C5 .784 5.784 0 6.75 0h7.5C15.216 0 16 .784 16 1.75v7.5A1.75 1.75 0 0 1 14.25 11h-7.5A1.75 1.75 0 0 1 5 9.25Zm1.75-.25a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-7.5a.25.25 0 0 0-.25-.25Z"></path>
        </svg>
              <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-check js-clipboard-check-icon color-fg-success d-none">
            <path d="M13.78 4.22a.75.75 0 0 1 0 1.06l-7.25 7.25a.75.75 0 0 1-1.06 0L2.22 9.28a.751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018L6 10.94l6.72-6.72a.75.75 0 0 1 1.06 0Z"></path>
        </svg>
            </clipboard-copy>
          </div></div>
        <div class="markdown-heading" dir="auto"><h3 tabindex="-1" class="heading-element" dir="auto">Encoding and Decoding HTML Entities</h3><a id="user-content-encoding-and-decoding-html-entities" class="anchor" aria-label="Permalink: Encoding and Decoding HTML Entities" href="#encoding-and-decoding-html-entities"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path d="m7.775 3.275 1.25-1.25a3.5 3.5 0 1 1 4.95 4.95l-2.5 2.5a3.5 3.5 0 0 1-4.95 0 .751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018 1.998 1.998 0 0 0 2.83 0l2.5-2.5a2.002 2.002 0 0 0-2.83-2.83l-1.25 1.25a.751.751 0 0 1-1.042-.018.751.751 0 0 1-.018-1.042Zm-4.69 9.64a1.998 1.998 0 0 0 2.83 0l1.25-1.25a.751.751 0 0 1 1.042.018.751.751 0 0 1 .018 1.042l-1.25 1.25a3.5 3.5 0 1 1-4.95-4.95l2.5-2.5a3.5 3.5 0 0 1 4.95 0 .751.751 0 0 1-.018 1.042.751.751 0 0 1-1.042.018 1.998 1.998 0 0 0-2.83 0l-2.5 2.5a1.998 1.998 0 0 0 0 2.83Z"></path></svg></a></div>
        <p dir="auto">You can use the <code>KsoupEntities</code> class to encode and decode HTML entities:</p>
        <div class="highlight highlight-source-kotlin notranslate position-relative overflow-auto" dir="auto"><pre><span class="pl-c"><span class="pl-c">//</span> Encode HTML entities</span>
        <span class="pl-k">val</span> encoded <span class="pl-k">=</span> <span class="pl-en">KsoupEntities</span>.encodeHtml(<span class="pl-s"><span class="pl-pds">"</span>Hello &amp; World<span class="pl-pds">"</span></span>) <span class="pl-c"><span class="pl-c">//</span> return: Hello &amp;amp; World</span>

        <span class="pl-c"><span class="pl-c">//</span> Decode HTML entities</span>
        <span class="pl-k">val</span> decoded <span class="pl-k">=</span> <span class="pl-en">KsoupEntities</span>.decodeHtml(<span class="pl-s"><span class="pl-pds">"</span>Hello &amp;amp; World<span class="pl-pds">"</span></span>) <span class="pl-c"><span class="pl-c">//</span> return: Hello &amp; World</span></pre><div class="zeroclipboard-container">
            <clipboard-copy aria-label="Copy" class="ClipboardButton btn btn-invisible js-clipboard-copy m-2 p-0 d-flex flex-justify-center flex-items-center" data-copy-feedback="Copied!" data-tooltip-direction="w" value="// Encode HTML entities
        val encoded = KsoupEntities.encodeHtml(&quot;Hello &amp; World&quot;) // return: Hello &amp;amp; World

        // Decode HTML entities
        val decoded = KsoupEntities.decodeHtml(&quot;Hello &amp;amp; World&quot;) // return: Hello &amp; World" tabindex="0" role="button">
              <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-copy js-clipboard-copy-icon">
            <path d="M0 6.75C0 5.784.784 5 1.75 5h1.5a.75.75 0 0 1 0 1.5h-1.5a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-1.5a.75.75 0 0 1 1.5 0v1.5A1.75 1.75 0 0 1 9.25 16h-7.5A1.75 1.75 0 0 1 0 14.25Z"></path><path d="M5 1.75C5 .784 5.784 0 6.75 0h7.5C15.216 0 16 .784 16 1.75v7.5A1.75 1.75 0 0 1 14.25 11h-7.5A1.75 1.75 0 0 1 5 9.25Zm1.75-.25a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-7.5a.25.25 0 0 0-.25-.25Z"></path>
        </svg>
              <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-check js-clipboard-check-icon color-fg-success d-none">
            <path d="M13.78 4.22a.75.75 0 0 1 0 1.06l-7.25 7.25a.75.75 0 0 1-1.06 0L2.22 9.28a.751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018L6 10.94l6.72-6.72a.75.75 0 0 1 1.06 0Z"></path>
        </svg>
            </clipboard-copy>
          </div></div>
        <p dir="auto"><code>KsoupEntities</code> also provides methods to encode and decode only XML entities or HTML4.
        The <code>KsoupEntities</code> class is available in the <code>ksoup-entities</code> module.</p>
        <p dir="auto">Both <code>encodeHtml</code> and <code>decodeHtml</code> methods support all HTML5 entities, XML entities, and HTML4 entities.</p>
        <div class="markdown-heading" dir="auto"><h2 tabindex="-1" class="heading-element" dir="auto">Coming Features</h2><a id="user-content-coming-features" class="anchor" aria-label="Permalink: Coming Features" href="#coming-features"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path d="m7.775 3.275 1.25-1.25a3.5 3.5 0 1 1 4.95 4.95l-2.5 2.5a3.5 3.5 0 0 1-4.95 0 .751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018 1.998 1.998 0 0 0 2.83 0l2.5-2.5a2.002 2.002 0 0 0-2.83-2.83l-1.25 1.25a.751.751 0 0 1-1.042-.018.751.751 0 0 1-.018-1.042Zm-4.69 9.64a1.998 1.998 0 0 0 2.83 0l1.25-1.25a.751.751 0 0 1 1.042.018.751.751 0 0 1 .018 1.042l-1.25 1.25a3.5 3.5 0 1 1-4.95-4.95l2.5-2.5a3.5 3.5 0 0 1 4.95 0 .751.751 0 0 1-.018 1.042.751.751 0 0 1-1.042.018 1.998 1.998 0 0 0-2.83 0l-2.5 2.5a1.998 1.998 0 0 0 0 2.83Z"></path></svg></a></div>
        <ul class="contains-task-list">
        <li class="task-list-item"><input type="checkbox" id="" disabled="" class="task-list-item-checkbox" aria-label="Incomplete task"> Add clear documentation</li>
        <li class="task-list-item"><input type="checkbox" id="" disabled="" class="task-list-item-checkbox" aria-label="Incomplete task"> Add Markdown parser</li>
        </ul>
        <div class="markdown-heading" dir="auto"><h2 tabindex="-1" class="heading-element" dir="auto">Contribution</h2><a id="user-content-contribution" class="anchor" aria-label="Permalink: Contribution" href="#contribution"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path d="m7.775 3.275 1.25-1.25a3.5 3.5 0 1 1 4.95 4.95l-2.5 2.5a3.5 3.5 0 0 1-4.95 0 .751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018 1.998 1.998 0 0 0 2.83 0l2.5-2.5a2.002 2.002 0 0 0-2.83-2.83l-1.25 1.25a.751.751 0 0 1-1.042-.018.751.751 0 0 1-.018-1.042Zm-4.69 9.64a1.998 1.998 0 0 0 2.83 0l1.25-1.25a.751.751 0 0 1 1.042.018.751.751 0 0 1 .018 1.042l-1.25 1.25a3.5 3.5 0 1 1-4.95-4.95l2.5-2.5a3.5 3.5 0 0 1 4.95 0 .751.751 0 0 1-.018 1.042.751.751 0 0 1-1.042.018 1.998 1.998 0 0 0-2.83 0l-2.5 2.5a1.998 1.998 0 0 0 0 2.83Z"></path></svg></a></div>
        <p dir="auto">If you've found an error in this sample, please file an issue. <br>
        Feel free to help out by sending a pull request ❤️.</p>
        <p dir="auto"><a href="https://github.com/MohamedRejeb/ksoup/blob/main/CODE_OF_CONDUCT.md">Code of Conduct</a></p>
        <div class="markdown-heading" dir="auto"><h2 tabindex="-1" class="heading-element" dir="auto">Find this library useful? ❤️</h2><a id="user-content-find-this-library-useful-heart" class="anchor" aria-label="Permalink: Find this library useful? :heart:" href="#find-this-library-useful-heart"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path d="m7.775 3.275 1.25-1.25a3.5 3.5 0 1 1 4.95 4.95l-2.5 2.5a3.5 3.5 0 0 1-4.95 0 .751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018 1.998 1.998 0 0 0 2.83 0l2.5-2.5a2.002 2.002 0 0 0-2.83-2.83l-1.25 1.25a.751.751 0 0 1-1.042-.018.751.751 0 0 1-.018-1.042Zm-4.69 9.64a1.998 1.998 0 0 0 2.83 0l1.25-1.25a.751.751 0 0 1 1.042.018.751.751 0 0 1 .018 1.042l-1.25 1.25a3.5 3.5 0 1 1-4.95-4.95l2.5-2.5a3.5 3.5 0 0 1 4.95 0 .751.751 0 0 1-.018 1.042.751.751 0 0 1-1.042.018 1.998 1.998 0 0 0-2.83 0l-2.5 2.5a1.998 1.998 0 0 0 0 2.83Z"></path></svg></a></div>
        <p dir="auto">Support it by joining <strong><a href="https://github.com/MohamedRejeb/Ksoup/stargazers">stargazers</a></strong> for this repository. ⭐ <br>
        Also, <strong><a href="https://github.com/MohamedRejeb">follow me</a></strong> on GitHub for more libraries! 🤩</p>
        <p dir="auto">You can always <a href="https://www.buymeacoffee.com/MohamedRejeb" rel="nofollow"><img src="https://camo.githubusercontent.com/1b3aa90c76e68e217c4913a042eddb56b736a64216a1a4b2b64f13f637626a05/68747470733a2f2f696d672e6275796d6561636f666665652e636f6d2f627574746f6e2d6170692f3f746578743d427579206d65206120636f6666656526656d6f6a693d26736c75673d4d6f68616d656452656a656226627574746f6e5f636f6c6f75723d46464444303026666f6e745f636f6c6f75723d30303030303026666f6e745f66616d696c793d436f6f6b6965266f75746c696e655f636f6c6f75723d30303030303026636f666665655f636f6c6f75723d666666666666" data-canonical-src="https://img.buymeacoffee.com/button-api/?text=Buy me a coffee&amp;emoji=&amp;slug=MohamedRejeb&amp;button_colour=FFDD00&amp;font_colour=000000&amp;font_family=Cookie&amp;outline_colour=000000&amp;coffee_colour=ffffff" style="max-width: 100%;"></a></p>
        <div class="markdown-heading" dir="auto"><h2 tabindex="-1" class="heading-element" dir="auto">License</h2><a id="user-content-license" class="anchor" aria-label="Permalink: License" href="#license"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path d="m7.775 3.275 1.25-1.25a3.5 3.5 0 1 1 4.95 4.95l-2.5 2.5a3.5 3.5 0 0 1-4.95 0 .751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018 1.998 1.998 0 0 0 2.83 0l2.5-2.5a2.002 2.002 0 0 0-2.83-2.83l-1.25 1.25a.751.751 0 0 1-1.042-.018.751.751 0 0 1-.018-1.042Zm-4.69 9.64a1.998 1.998 0 0 0 2.83 0l1.25-1.25a.751.751 0 0 1 1.042.018.751.751 0 0 1 .018 1.042l-1.25 1.25a3.5 3.5 0 1 1-4.95-4.95l2.5-2.5a3.5 3.5 0 0 1 4.95 0 .751.751 0 0 1-.018 1.042.751.751 0 0 1-1.042.018 1.998 1.998 0 0 0-2.83 0l-2.5 2.5a1.998 1.998 0 0 0 0 2.83Z"></path></svg></a></div>
        <div class="highlight highlight-text-md notranslate position-relative overflow-auto" dir="auto"><pre>Copyright 2023 Mohamed Rejeb

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

           <span class="pl-corl">http://www.apache.org/licenses/LICENSE-2.0</span>

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.</pre><div class="zeroclipboard-container">
            <clipboard-copy aria-label="Copy" class="ClipboardButton btn btn-invisible js-clipboard-copy m-2 p-0 d-flex flex-justify-center flex-items-center" data-copy-feedback="Copied!" data-tooltip-direction="w" value="Copyright 2023 Mohamed Rejeb

        Licensed under the Apache License, Version 2.0 (the &quot;License&quot;);
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

           http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an &quot;AS IS&quot; BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License." tabindex="0" role="button">
              <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-copy js-clipboard-copy-icon">
            <path d="M0 6.75C0 5.784.784 5 1.75 5h1.5a.75.75 0 0 1 0 1.5h-1.5a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-1.5a.75.75 0 0 1 1.5 0v1.5A1.75 1.75 0 0 1 9.25 16h-7.5A1.75 1.75 0 0 1 0 14.25Z"></path><path d="M5 1.75C5 .784 5.784 0 6.75 0h7.5C15.216 0 16 .784 16 1.75v7.5A1.75 1.75 0 0 1 14.25 11h-7.5A1.75 1.75 0 0 1 5 9.25Zm1.75-.25a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-7.5a.25.25 0 0 0-.25-.25Z"></path>
        </svg>
              <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-check js-clipboard-check-icon color-fg-success d-none">
            <path d="M13.78 4.22a.75.75 0 0 1 0 1.06l-7.25 7.25a.75.75 0 0 1-1.06 0L2.22 9.28a.751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018L6 10.94l6.72-6.72a.75.75 0 0 1 1.06 0Z"></path>
        </svg>
            </clipboard-copy>
          </div></div>
        </article>
    """.trimIndent())

    println(testOutput)
}