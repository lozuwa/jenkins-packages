package com.lozuwa.common.curl.service

public class CurlCommand {

    public CurlCommand() {
    }

    public String executeRequest(List<String> command) {
        Process process = command.execute()
        StringBuffer stdout = new StringBuffer()
        StringBuffer stderr = new StringBuffer()
        process.waitForProcessOutput(stdout, stderr)
        return stdout.toString()
    }
}
