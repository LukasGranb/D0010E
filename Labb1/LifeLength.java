import java.util.Scanner;

public class LifeLength {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;

        while (true) {
            System.out.print("choose task 1, 2, 3, 4, 6; or 0 for exit: ");

            try {
                n = input.nextInt();
                if (n == 0) {
                    break;
                }
                int a0 = 0;
                if (n == 1 || n == 2 || n == 3) {
                    a0 = createa0(input);
                    if (a0 == 0) {
                        continue;
                    }
                }
                switch (n) {
                    case 1:task1(a0);break;
                    case 2:task2(a0);break;
                    case 3:task3(a0);break;
                    case 4:task4();break;
                    case 6:task6();break;
                }

            } catch (Exception e) {
                System.out.println("Error: Not a valid integer.");
                input.next();
            }
        }
    }

//to get a0:
    public static int createa0(Scanner input) {
        int a0;

        while (true) {
            System.out.print("Enter a positive integer (0 to exit): ");
            try {
                a0 = input.nextInt();
                if (a0 == 0) {
                    return 0;
                } else if (a0 > 0) {
                    return a0;
                } else {
                    System.out.println("Error: Enter a natural number greater than 0.");
                }
            } catch (Exception e) {
                System.out.println("Error: Not a valid integer.");
                input.next();
            }
        }
    }

    //task 1:
    public static int f1(int a0) {
        if (a0 == 1) {
            return 1;
        } else if (a0 % 2 == 0) {
            return a0 / 2;
        } else {
            return 3 * a0 + 1;
        }
    }

    public static void task1(int a0) {
        System.out.println("f1(a0) = " + f1(a0));
    }

    //task 2:
    public static int f2(int a0) {
        return f1(f1(a0));
    }

    public static int f4(int a0) {
        return f2(f2(a0));
    }

    public static int f8(int a0) {
        return f4(f4(a0));
    }

    public static int f16(int a0) {
        return f8(f8(a0));
    }

    public static int f32(int a0) {
        return f16(f16(a0));
    }

    public static void task2(int a0) {
        System.out.println("f1 = " + f1(a0));
        System.out.println("f2 = " + f2(a0));
        System.out.println("f4 = " + f4(a0));
        System.out.println("f8 = " + f8(a0));
        System.out.println("f16 = " + f16(a0));
        System.out.println("f32 = " + f32(a0));
    }

    //Task 3:
    public static int iterateF(int a0, int n) {
        for (int i = 0; i < n; i++) {
            a0 = f1(a0);
        }
        return a0;
    }

    public static void task3(int a0) {
        Scanner input = new Scanner(System.in);
        int n = 0;

        while (true) {
            System.out.print("Enter a integer equal or greater than 0: ");
            try {
                n = input.nextInt();
                if (n > 0) {
                    break;
                } else {
                    System.out.println("Error: Enter a natural number equal or greater than 0.");
                }
            } catch (Exception e) {
                System.out.println("Error: Not a valid integer.");
                input.next();
            }
        }
        System.out.println(iterateF(a0, n));
    }

    //task 4:
    public static int iterLifeLength(int a0) {
        int count = 0;
        while (a0 != 1) {
            a0 = f1(a0);
            count++;
        }
        return count;
    }

    public static String intsToString(int x, int y) {
        return "The life length of " + x + " is " + y + ".";
    }

    public static void task4() {
        for (int i = 1; i <= 15; i++) {
            int lifeLength = iterLifeLength(i);
            System.out.println(intsToString(i, lifeLength));
        }
    }

    // Task 6:
    public static int recLifeLength(int a0) {
        if (a0 == 1) {
            return 0;
        } else {
            return 1 + recLifeLength(f1(a0));
        }
    }

    public static void task6() {
        for (int i = 1; i <= 15; i++) {
            System.out.println("IterLifeLength = " + iterLifeLength(i) + ", RecLifeLength = " + recLifeLength(i));
        }
    }

    /*task 7:
    a0 kommer aldrig bli 1 därför kommer rekurensmetoden anropa sig själv 21792 gånger (call stack depth) */
}
