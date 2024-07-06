package com.webapp.BaronBoost.utils.html_css_converter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Utility class for converting HTML/CSS files into a unified String.
 * This class provides methods to:
 *  1. Merge HTML and CSS into a single string with a TOKEN.
 *  2. Merge HTML and CSS into a string.
 *  3. Convert HTML to String.
 *  4. Convert CSS to String.
 * <p>
 * This class is not meant to be instantiated.
 * </p>
 * 
 * <p>
 * Example usage:
 * <pre>
 *     String htmlFilePath = "path/to/html/file";
 *     String cssFilePath = "path/to/css/file";
 *     String token = "someToken";
 *     
 *     String mergedContentWithToken = HTMLCSSToStringUtil.mergeHTMLAndCSSWithToken(htmlFilePath, cssFilePath, token);
 *     String mergedContent = HTMLCSSToStringUtil.mergeHTMLAndCSS(htmlFilePath, cssFilePath);
 *     String htmlContent = HTMLCSSToStringUtil.HTMLtoString(htmlFilePath);
 *     String cssContent = HTMLCSSToStringUtil.CSStoString(cssFilePath);
 * </pre>
 * </p>
 * 
 */
public class HTMLCSSToStringUtil {

    /**
     * Private constructor to prevent instantiation.
     * This class is not meant to be instantiated.
     */
    private HTMLCSSToStringUtil() {
    }

    /**
     * Merge HTML and CSS and replace the "[[TOKEN]]" in the HTML file with the provided token.
     *
     * @param htmlFilePath 
     * @param cssFilePath
     * @param token
     * 
     * @return a HTML + CSS file in String. (The way this insert CSS into HTML is NOT by link but my direct <style> tag in HTML)
     * @throws IOException 
     */
    public static String mergeHTMLAndCSSWithToken(String htmlFilePath, String cssFilePath, String token) throws IOException {
        String htmlContent = readFromFile(htmlFilePath);
        String cssContent = readFromFile(cssFilePath);

        String mergedHTML = htmlContent.replace("[[TOKEN]]", token);
        return insertCSSIntoHTML(mergedHTML, cssContent);
    }

    /**
     * Merge HTML and CSS and convert them into String.
     *
     * @param htmlFilePath 
     * @param cssFilePath
     * 
     * @return a HTML + CSS file in String. (The way this insert CSS into HTML is NOT by link but my direct <style> tag in HTML)
     * @throws IOException 
     */
    public static String mergeHTMLAndCSS(String htmlFilePath, String cssFilePath) throws IOException {
        String htmlContent = readFromFile(htmlFilePath);
        String cssContent = readFromFile(cssFilePath);
        return insertCSSIntoHTML(htmlContent, cssContent);
    }

    /**
     * Convert HTML into String.
     *
     * @param htmlFilePath 
     * 
     * @return a HTML String.
     * @throws IOException 
     */
    public static String HTMLtoString(String htmlFilePath) throws IOException{
        String htmlContent = readFromFile(htmlFilePath);
        return htmlContent;
    }

    /**
     * Convert CSS into String.
     *
     * @param cssFilePath 
     * 
     * @return a CSS String.
     * @throws IOException 
     */
    public static String CSStoString(String cssFilePath) throws IOException {
        String cssContent = readFromFile(cssFilePath);
        return cssContent;
    }

    private static String readFromFile(String filePath) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        }

        return contentBuilder.toString();
    }

    private static String insertCSSIntoHTML(String htmlContent, String cssContent) {
        String styledHtml = htmlContent.replace("</head>", "<style type=\"text/css\">\n" + cssContent + "\n</style></head>");
        return styledHtml;
    }
}