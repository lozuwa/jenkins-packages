package com.lozuwa.ui.service

public class Checkbox {
    private String label
    private boolean enabled
    private boolean checked

    public Checkbox() {
        this(null, true, false)
    }

    public Checkbox(String label, boolean enabled, boolean checked) {
        this.label = label
        this.enabled = enabled
        this.checked = checked
    }

    public String render() {
        String renderChecked = ""
        if (checked) {
            renderChecked = "checked"
        }
        String renderDisabled = ""
        if (!enabled) {
            renderDisabled = "disabled"
        }
        String html = """
<input name="value" type="checkbox" class=" " value="on" ${renderChecked} ${renderDisabled}>
"""
        if (label != null) {
            html += """
<label title="${label}" class=" ">${label}</label>
"""
        }
        return html
    }
}
