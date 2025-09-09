public class StringConcatPerformance {
    public static void main(String[] args) {
        int n = 1_000_000;

        long start, end;

        String str = "";
        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            str += "a";
        }
        end = System.currentTimeMillis();
        System.out.println("String time: " + (end - start) + " ms");

        StringBuilder sb = new StringBuilder();
        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuilder time: " + (end - start) + " ms");

        StringBuffer sbuf = new StringBuffer();
        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            sbuf.append("a");
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuffer time: " + (end - start) + " ms");
    }
}
