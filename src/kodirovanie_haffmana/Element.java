package kodirovanie_haffmana;

public class Element implements Comparable<Element>{
    private final int freq;
    private final String chars;

    public Element(int freq, String chars){
        this.freq = freq;
        this.chars = chars;
    }

    public int getFreq(){
        return freq;
    }

    public String getChars(){
        return chars;
    }

    @Override
    public int compareTo(Element element) {
        return Integer.compare(this.freq, element.getFreq());
    }

    @Override
    public String toString() {
        return "Element{" +
                "freq=" + freq +
                ", chars='" + chars + '\'' +
                '}';
    }
}
