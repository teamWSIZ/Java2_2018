package konkurs2;

public class TicTacToeNaLinii {

    /**
     * Dwóch dzieciaków gra w plażową wersję znanej gry "kółko i krzyżyk"
     * (eng. TicTacToe).
     *
     * W ich wersji gry kółka, 'o' i krzyżyki, 'x' ustawiane są w
     * pojedynczej linii. Wygrywa gracz, który uzbiera
     * trzy znaki swojego typu pod rząd.
     *
     * Przykład:
     * "xoxo" -- Nikt nie wygrał
     * "oxxx" -- Wygrał gracz 'x'.
     * "ooxxoo" -- Wygrał gracz 'x'.
     *
     * Ponieważ gracz 'x' zaczynał grę, zakładamy, że jest zwycięzcą nawet, jeśli 'o'
     * też uzbierał 3+ znaki swojego typu w linni, czyli
     * "oooxxx" --> wygrał 'x'.
     *
     * Mając daną planszę sprawdzić czy 'x' wygrał.
     */

    static void isXwinner(String s) {
        //rozwiązanie najprostsze:
//        boolean winner = s.contains("xxx");
//        System.out.println(winner);

        //rozwiązanie bardziej wymowne:
        boolean win = false;
        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i)=='x' && s.charAt(i+1)=='x' && s.charAt(i+2)=='x') {
                win = true;
                break;
            }
        }

        //wypisać wynik do konsoli
        System.out.println(win);
    }

    public static void main(String[] args) {
       isXwinner("xxoxx");      //Nie
       isXwinner("xxoox");      //Nie
       isXwinner("xooxo");      //Nie
       isXwinner("ooxooxoox");      //Nie
       isXwinner("ooxxxoox");      //Tak
       isXwinner("ooxxxoox");      //Tak
       isXwinner("oooxxxox");      //Tak
       isXwinner("xxx");      //Tak
    }
}
