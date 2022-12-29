package cover_segments_with_dots;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DotsSegmentsJ8 {
    public static void main(String[] args) {
        DotsSegmentsJ8 dotsSegmentsJ8 = new DotsSegmentsJ8();
        List<Section> sectionList = dotsSegmentsJ8.inputListSection();
        List<Integer> common = new ArrayList<>();
        sectionList.sort((e1, e2) -> e1.getB() - e2.getB());
        boolean param = true;
        for (Section section: sectionList) {
            if (param){
                common.add(section.getB());
                param = false;
            }
            if(section.getA() > common.get(common.size() - 1)){
                common.add(section.getB());
            }
        }
        System.out.println(common.size());
        System.out.println(common.size());
        common.stream().map(e-> e + " ").forEach(System.out::println);
    }


    private class Section {
        private int a;
        private int b;

        public Section(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }
    }


    private List<Section> inputListSection(){
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        List<Section> sections = new ArrayList<>(count);
        for (int i = 0; i < count; i ++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            sections.add(new Section(a, b));
        }
        return sections;
    }

}
