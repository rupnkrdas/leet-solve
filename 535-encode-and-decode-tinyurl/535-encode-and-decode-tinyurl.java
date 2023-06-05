public class Codec {
    Map<String, String> encodeMap = new HashMap<>();
    Map<String, String> decodeMap = new HashMap<>();
    String base = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (!encodeMap.containsKey(longUrl)) {
            String shortUrl = base + Integer.toString(encodeMap.size() + 1);
            encodeMap.put(longUrl, shortUrl);
            decodeMap.put(shortUrl, longUrl);

            return encodeMap.get(longUrl);
        } else return encodeMap.get(longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return decodeMap.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));