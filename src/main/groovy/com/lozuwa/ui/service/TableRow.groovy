package com.lozuwa.ui.service

public class TableRow {
    private List<String> tableColumns

    public TableRow(String[] tableColumns) {
    }

    public TableRow(List<String> tableColumns) {
        this.tableColumns = tableColumns
    }

    public String render() {
        String html = """
<tr>
"""
        for (String tableColumn: tableColumns) {
            html += tableColumn
        }
        html += """
</tr>
"""
        return html
    }
}
