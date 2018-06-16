package konkurs1;

public class B {
    public static void main(String[] args) {


        char c = 'b';
        int x = c;
        System.out.println(x);

        int[] tt = new int[300];    //tablica wielkości "300"

        //zapis
        tt[24] = 111;
        tt[2] = 1000;

        //odczyt
        System.out.println(tt[24]);

        for (int i = 0; i < 300; i++) {
            System.out.println("tt[" + i +"]=" + tt[i]);
        }

        //znajdywanie największego elementu tablicy:
        int mx = -1;
        for (int i = 0; i < 300; i++) {
            if (tt[i]>mx) {
                mx = tt[i];
            }
        }
        System.out.println("Maks = " + mx);


    }
}
