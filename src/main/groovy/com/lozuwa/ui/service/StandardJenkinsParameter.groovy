package com.lozuwa.ui.service

public class StandardJenkinsParameter {
    private String name
    private String element
    private String description
    private String tbodyStyle

    public StandardJenkinsParameter(String name, String element, String description) {
        this(name, element, description, "")
    }

    public StandardJenkinsParameter(String name, String element, String description, String tbodyStyle) {
        this.name = name
        this.element = element
        this.description = description
        this.tbodyStyle = tbodyStyle
    }

    public String render() {
        String html = """
<tbody style="${tbodyStyle}">

    <tr>
        <td>${name}</td>
        <td style="margin-left: 50px;"></td>
        <td>
            ${element}
        </td>
    </tr>

    <tr>
        <td colspan="2"></td>
        <td style="margin-left: 1px;">${description}</td>
    </tr>

</tbody>
"""
        return html
    }
}
