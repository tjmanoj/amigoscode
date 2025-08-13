package amigoscode.commentscreate;
import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.*;

public class NestedCommentPoster {

	private static final String COMMENT_URL = "https://107410448.commerceplatform.localzohostorefront.com/siteapps/commentbox/addComments";
	private static final String CSRF_TOKEN = "d91d37f1-d32a-4c32-aae3-a8c7ded79dff";
	private static final String PAGE_ID = "34321000000013097";
	private static final String PAGE_NO = "1";
	private static final String COOKIE_HEADER = "csrfc=" + CSRF_TOKEN +
		"; _zcsr_tmp=" + CSRF_TOKEN +
		"; zsltssn=2ie76csvc1khm4yr1d6ff1dvrgbtledtis7mc6aba064fiw2zk" +
		"; JSESSIONID=55CCCC997D6B35DCFD9AF1A7422BA507" +
		"; zsstssn=12wxhqoqnbrpjzhp9tegkbg897m4adc7nw82zgxu37mb6o9h6a";
	public static final int START_COUNT = 501;
	public static final int ROOT_COUNT = 1000;

	public static void main(String[] args) throws Exception {
		disableSSLCertValidation();

		int rootCount = ROOT_COUNT; // change as needed
		for (int i = START_COUNT; i <= rootCount; i++) {
			String rootComment = "Root comment " + i;
			String rootId = sendComment(rootComment, null, null);

			if (rootId != null) {
				int depth = new Random().nextInt(3, 10); // random depth

				String parentId = rootId;
				for (int d = 1; d < depth; d++) {
					String reply = "Reply d" + d + " for root " + i;
					parentId = sendReplyComment(reply, rootId, parentId);
					if (parentId == null) break;
					Thread.sleep(500);
				}
			}
		}
	}

	private static String sendReplyComment(String content, String rootId, String inReplyTo) throws Exception {
	    String boundary = "----WebKitFormBoundary" + System.currentTimeMillis();
	    URL url = new URL(COMMENT_URL);
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

	    conn.setRequestMethod("POST");
	    conn.setDoOutput(true);
	    conn.setUseCaches(false);
	    conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
	    conn.setRequestProperty("accept", "*/*");
	    conn.setRequestProperty("accept-language", "en-US,en;q=0.9");
	    conn.setRequestProperty("origin", "https://107410448.commerceplatform.localzohostorefront.com");
	    conn.setRequestProperty("priority", "u=1, i");
	    conn.setRequestProperty("referer", "https://107410448.commerceplatform.localzohostorefront.com/blogs/post/stats-blog");
	    conn.setRequestProperty("sec-ch-ua", "\"Not)A;Brand\";v=\"8\", \"Chromium\";v=\"138\", \"Google Chrome\";v=\"138\"");
	    conn.setRequestProperty("sec-ch-ua-mobile", "?0");
	    conn.setRequestProperty("sec-ch-ua-platform", "\"macOS\"");
	    conn.setRequestProperty("sec-fetch-dest", "empty");
	    conn.setRequestProperty("sec-fetch-mode", "cors");
	    conn.setRequestProperty("sec-fetch-site", "same-origin");
	    conn.setRequestProperty("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36");
	    conn.setRequestProperty("Cookie", COOKIE_HEADER);

	    try (DataOutputStream request = new DataOutputStream(conn.getOutputStream())) {
	        addFormField(request, boundary, "root_cmt_id", rootId == null ? "" : rootId);
	        addFormField(request, boundary, "in_reply_to", inReplyTo == null ? "" : inReplyTo);
	        addFormField(request, boundary, "cb_comments_content", content);
	        addFormField(request, boundary, "cb_comments_title", "");
	        addFormField(request, boundary, "cb_comments_added_by_name", "");
	        addFormField(request, boundary, "cb_comments_added_by_emailid", "");
	        addFormField(request, boundary, "acquired_rating", "0");
	        addFormField(request, boundary, "pageId", PAGE_ID);
	        addFormField(request, boundary, "pageNo", PAGE_NO);
	        addFormField(request, boundary, "csrfp", CSRF_TOKEN);
	        request.writeBytes("--" + boundary + "--\r\n");
	        request.flush();
	    }

	    int status = conn.getResponseCode();
	    InputStream input = (status == 200) ? conn.getInputStream() : conn.getErrorStream();
	    try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
	        StringBuilder resp = new StringBuilder();
	        String line;
	        while ((line = reader.readLine()) != null) {
	            resp.append(line);
	        }
	        if (status == 200 && resp.toString().contains("cb_cmt_id")) {
				String cbCmtId = resp.toString().replaceAll(".*\\\"comment_id\\\"\\s*:\\s*\\\"?(\\d+)\\\"?.*", "$1");
	            System.out.println("✅ " + content + " -> ID: " + cbCmtId);
	            return cbCmtId;
	        } else {
	            System.err.println("❌ Failed to post: " + content + " | Status: " + status);
	            System.err.println(resp);
	            return null;
	        }
	    }
	}
	private static String sendComment(String content, String rootId, String inReplyTo) throws Exception {
		String boundary = "----WebKitFormBoundary" + System.currentTimeMillis();
		URL url = new URL(COMMENT_URL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setUseCaches(false);
		conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
		conn.setRequestProperty("accept", "*/*");
		conn.setRequestProperty("accept-language", "en-US,en;q=0.9");
		conn.setRequestProperty("origin", "https://107410448.commerceplatform.localzohostorefront.com");
		conn.setRequestProperty("priority", "u=1, i");
		conn.setRequestProperty("referer", "https://107410448.commerceplatform.localzohostorefront.com/blogs/post/stats-blog");
		conn.setRequestProperty("sec-ch-ua", "\"Not)A;Brand\";v=\"8\", \"Chromium\";v=\"138\", \"Google Chrome\";v=\"138\"");
		conn.setRequestProperty("sec-ch-ua-mobile", "?0");
		conn.setRequestProperty("sec-ch-ua-platform", "\"macOS\"");
		conn.setRequestProperty("sec-fetch-dest", "empty");
		conn.setRequestProperty("sec-fetch-mode", "cors");
		conn.setRequestProperty("sec-fetch-site", "same-origin");
		conn.setRequestProperty("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36");
		conn.setRequestProperty("Cookie", COOKIE_HEADER);

		try (DataOutputStream request = new DataOutputStream(conn.getOutputStream())) {
			addFormField(request, boundary, "cb_comments_content", content);
			addFormField(request, boundary, "cb_comments_title", "");
			addFormField(request, boundary, "cb_comments_added_by_name", "");
			addFormField(request, boundary, "cb_comments_added_by_emailid", "");
			addFormField(request, boundary, "acquired_rating", "0");
			addFormField(request, boundary, "pageId", PAGE_ID);
			addFormField(request, boundary, "pageNo", PAGE_NO);
			addFormField(request, boundary, "csrfp", CSRF_TOKEN);
			if (rootId != null) addFormField(request, boundary, "root_cmt_id", rootId);
			if (inReplyTo != null) addFormField(request, boundary, "in_reply_to", inReplyTo);
			request.writeBytes("--" + boundary + "--\r\n");
			request.flush();
		}

		int status = conn.getResponseCode();
		InputStream input = (status == 200) ? conn.getInputStream() : conn.getErrorStream();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
			StringBuilder resp = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				resp.append(line);
			}
			if (status == 200 && resp.toString().contains("cb_cmt_id")) {
				String cbCmtId = resp.toString().replaceAll(".*\\\"comment_id\\\"\\s*:\\s*\\\"?(\\d+)\\\"?.*", "$1");
				System.out.println("✅ " + content + " -> ID: " + cbCmtId);
				return cbCmtId;
			} else {
				System.err.println("❌ Failed to post: " + content + " | Status: " + status);
				System.err.println(resp);
				return null;
			}
		}
	}

	private static void addFormField(DataOutputStream out, String boundary, String name, String value) throws IOException {
		out.writeBytes("--" + boundary + "\r\n");
		out.writeBytes("Content-Disposition: form-data; name=\"" + name + "\"\r\n\r\n");
		out.writeBytes(value + "\r\n");
	}

	private static void disableSSLCertValidation() throws Exception {
		TrustManager[] trustAllCerts = new TrustManager[] {
			new X509TrustManager() {
				public X509Certificate[] getAcceptedIssuers() { return null; }
				public void checkClientTrusted(X509Certificate[] certs, String authType) { }
				public void checkServerTrusted(X509Certificate[] certs, String authType) { }
			}
		};
		SSLContext sc = SSLContext.getInstance("TLS");
		sc.init(null, trustAllCerts, new java.security.SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
	}
}
