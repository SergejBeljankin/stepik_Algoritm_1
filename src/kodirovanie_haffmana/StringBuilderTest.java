package kodirovanie_haffmana;

public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0");
        stringBuilder.append("1");
        stringBuilder.insert(0,"1");
        System.out.println(stringBuilder);
        stringBuilder.deleteCharAt(2);
        System.out.println(stringBuilder);
    }
}
