/*
Exo Prologin :
[...] vous avez la séquence suivante: 65, 5, 30.
Le premier nombre représente la lettre 'A'. Avec le second nombre, vous vous retrouvez à la lettre 'F'.
Enfin, le dernier nombre de la séquence 30 vous retournera la lettre 'J', étant donné que 'F' + 30 revient à faire 'F' + 4.
Le message final de cette séquence sera alors la lettre J.
*/

/*
   EXEMPLE D'ENTREE :
       5
       66 1 2 3 6

   EXEMPLE DE SORTIE :
       N
*/
import java.util.Scanner;

public class Appli {
    static Scanner input = new Scanner(System.in);
    private static int[] sequence;

    public static void main(String[] args) {
        int sequenceLength = input.nextInt();
        fillTheSequence(sequenceLength);
        char letter = getFinalLetter();
        System.out.println(letter);
    }

    public static boolean isALetter(char character) {
        if ((int) character < 65 || (int) character > 90) {
            return false;
        }
        return true;
    }
    public static char moveLetterToIndex(int number, int index) {
        return (char) ((char) number+index);
    }
    public static void fillTheSequence(int length) {
        sequence = new int[length];
        for (int i = 0; i < length  ; i++) {
            int index = input.nextInt();
            sequence[i] = index;
        }
    }
    public static int addIndexesFromSequence() {
        int finalIndexToAdd = 0;
        for(int i = 1 ; i < sequence.length; i++) {
            finalIndexToAdd += sequence[i];
        }
        return finalIndexToAdd % 26;
    }
    public static char getFinalLetter() {
        char firstLetter = (char) sequence[0];
        if(!isALetter(firstLetter)) {
            return ' ';
        }
        int number = addIndexesFromSequence();
        char finalLetter = moveLetterToIndex(firstLetter, number);
        return finalLetter;
    }

}
