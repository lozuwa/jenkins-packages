package com.lozuwa.ui.service

public class Label {
    private String title
    private String value
    private String style

    public Label() {
        this(null, null)
    }

    public Label(String title, String value) {
        this(title, value, "")
    }

    public Label(String title, String value, String style) {
        this.title = title
        this.value = value
        this.style = style
    }

    public String render() {
        String html = """
<label style="${style}" title="${title}" class=" ">${value}</label>
"""
        return html
    }
}
