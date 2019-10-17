import java.util.HashMap;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<HashMap<String, Integer>> lista = new ArrayList<HashMap<String, Integer>>();

        for (int i = 0; i < 5; i++) {

            HashMap<String, Integer> mapa = new HashMap<String, Integer>();
            mapa.put("i",i);
            System.out.println(mapa);

            lista.add(mapa);
            System.out.println(lista);
        }

    }
}
//
//import java.util.HashMap;
//        import java.util.ArrayList;
//        import java.util.Arrays;

//public class Main {
  //  public static void main(String[] args) {
     //   ArrayList<HashMap<String, Integer>> myList = new ArrayList<HashMap<String, Integer>>();

     //   HashMap<String, Integer> check = new HashMap<String, Integer>();

     //   for (int i = 0; i < 5; i++) {
//String s = Integer.toString(i);
//check.put(Integer.toString(i),i);
//check.put(String.valueOf(new Integer(i)),i);
        //    check.put("user" + i ,i);
//check.put("i",i);
//System.out.println(check);
//System.out.println(Arrays.toString(result));

//        }import java.util.HashMap;
//import java.util.ArrayList;
//import java.util.Arrays;
//
//        public class Main {
//            public static void main(String[] args) {
//                ArrayList<HashMap<String, Integer>> myList = new ArrayList<HashMap<String, Integer>>();
//
//                HashMap<String, Integer> check = new HashMap<String, Integer>();
//
//                for (int i = 0; i < 5; i++) {
//String s = Integ
//                    myList.add(check);
//
//
//                    for (int i = 0; i < myList.size(); i++) {
//                        System.out.println("Detail : " + myList.get(i));
//                    }
//
//                    System.out.println(myList);
//System.out.println(Arrays.toString(myList));
//for(i HashMap: myList){
//System.out.println(i);
//}
//System.out.println(myList.get(1)+"\n"+(myList.get(1)).get(1));
         //       }
        //   }