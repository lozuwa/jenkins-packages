package com.lozuwa.ui.service

public class Dropdown {
    private Collection<String> options

    public Dropdown(List<String> options) {
        this((Collection<String>) options)
    }

    public Dropdown(LinkedHashSet<String> options) {
        this((Collection<String>) options)
    }

    public Dropdown(Collection<String> options) {
        this.options = options
    }

    public String render() {
        String html = """
<select style="width: 200px;" name="value">
"""
        for (String option: options) {
            html += """
<option value="${option}">${option}</option>
"""
        }
        html += """
    </select>
"""
        return html
    }
}
