package com.lozuwa.ui.service

public class TableColumn {
    private List<String> elements

    public TableColumn(String[] elements) {
        this(Arrays.asList(elements))
    }

    public TableColumn(List<String> elements) {
        this.elements = elements
    }

    public String render() {
        String html = """
<td>
"""
        for (String element: elements) {
            html += element
        }
        html += """
</td>
"""
        return html
    }
}
