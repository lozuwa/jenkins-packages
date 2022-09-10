package com.lozuwa.ui.service

public class Table {
    private List<String> tableRows

    public Table(String[] tableRows) {
        this(Arrays.asList(tableRows))
    }

    public Table(List<String> tableRows) {
        this.tableRows = tableRows
    }

    public String render() {
        String html = """
<table>
"""
        for (String tableRow: tableRows) {
            html += tableRow
        }
        html += """
</table>
"""
        return html
    }
}
