package diebold.chris.code.http;

import java.io.OutputStream;

public class Handlers {
    final static String ENDLINE = "\n\r";

    // Pulled out of RFC
    public static String OkResponse(String html) {
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1").append(" ").append("200").append(" ").append("OK").append(ENDLINE);
        sb.append("Content-Length: ").append(html.getBytes().length).append(ENDLINE).append(ENDLINE);
        sb.append(html);
        sb.append(ENDLINE).append(ENDLINE);
        return sb.toString();
    }

    public static String dummyHTML() {
        return "<html><head><title>DummyPage</title></head><body><h1>Some Dummy Data</h1></body></html>";
    }

}
