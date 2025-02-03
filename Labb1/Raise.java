public class Raise {
//task 9:
    public static void main(String[] args) {


        for (int i = 1; i <= 15; i++){
            count = 0;
            System.out.println("recRaiseOne ger: " + recRaiseOne(1.5, i) + " | Antal rekursioner: " + count);
        }
        for (int i = 1; i <= 15; i++){
            count = 0;
            System.out.println("recRaiseHalf ger: " + recRaiseHalf(1.5, i) + " | Antal rekursioner: " + count);
        }

        //Task 10:
//        for (int i = 0; i <= 10000; i++) {
//            count = 0;
//            recRaiseOne(1.0005, i);
//            System.out.print("recRaiseOne, k = " + i + ", count = " + count);
//            System.out.println("        N_one(k) = " + i + 1);
//        }
//        for (int i = 0; i <= 10000; i++) {
//            count = 0;
//            recRaiseHalf(1.0005, i);
//            System.out.print("recRaiseHalf, k = " + i + ", count = " + count);
//            System.out.println("        N_half(k) = " + Math.floor(Math.log(i) / Math.log(2) + 2));
//        }
    }

    public static int count = 0;
    public static double recRaiseOne(double x, int k) {
        count++;
        if (k==0) {
            return 1.0;
        } else {
            return x * recRaiseOne(x, k-1);
        }
    }


    //task 8:
   public static double recRaiseHalf(double x, int k){
       count++;
       if (k == 0) {
           return 1;
       } else if ((k % 2) == 0) {
           double temp = recRaiseHalf(x, k/2);
           return temp * temp;
       } else {
           double temp = recRaiseHalf(x, k/2);
           return x * temp * temp;
       }
   }
}



/*
1. Storleken på K kommer att påverka runtime mest. Detta är för att K kommer avgöra hur många gånger den metoden körs.
2.Visa grafer i google sheets.
3. N_one(k) = k + 1, går att tyda på grafen. samt kolla värderna som ges av metoden.
4. N_half(k) = floor(log2(k) + 2), går att genom att testa värden i geogebra.
*/
