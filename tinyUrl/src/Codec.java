import java.util.HashMap;
import java.util.Map;

public class Codec {

    Map<Integer, String> codeToUrl = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
      var hash = longUrl.hashCode();
      codeToUrl.put(hash, longUrl);
      return "http://tinyurl.com/" + hash;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int code = Integer.parseInt(shortUrl.replace("http://tinyurl.com/", ""));
        return codeToUrl.get(code);
    }
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
