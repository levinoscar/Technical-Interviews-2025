public class StringCount {
    // Compress the string
    public static String compress(String input) {
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            if (i < input.length() && input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                sb.append(count).append("|").append(escape(input.charAt(i - 1)));
                count = 1;
            }
        }
        return sb.toString();
    }

    // Decompress the string
    public static String decompress(String encoded) {
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < encoded.length()) {
            // Read count
            int j = i;
            while (Character.isDigit(encoded.charAt(j))) j++;
            int count = Integer.parseInt(encoded.substring(i, j));
            i = j + 1; // Skip past '|'

            // Read character, handling escape
            char ch;
            if (encoded.charAt(i) == '\\') {
                ch = encoded.charAt(i + 1);
                i += 2;
            } else {
                ch = encoded.charAt(i);
                i += 1;
            }

            for (int k = 0; k < count; k++) {
                result.append(ch);
            }
        }
        return result.toString();
    }

    // Escapes a character if it could conflict with our format
    private static String escape(char c) {
        if (c == '|' || c == '\\') {
            return "\\" + c;
        }     
        return String.valueOf(c);
    }

    // Main Function
    public static void main(String[] args) {
        String input = "AAAABBB1111CCCDD|\\";
        String compressed = compress(input);
        String decompressed = decompress(compressed);

        System.out.println("Original: " + input);
        System.out.println("Compressed: " + compressed);
        System.out.println("Decompressed: " + decompressed);
    }
}
