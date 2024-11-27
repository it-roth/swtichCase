import java.util.Scanner;

public class exercise {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option;
        enum DAY {
            MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
            SATURDAY, SUNDAY
        }
        do {
            System.out.println("1. Wage Calculator");
            System.out.println("2. Money Exchange Program");
            System.out.println("5. Exit ");

            System.out.println("Choose (1 - 5) : ");
            option = input.nextInt();
            switch (option) {
                case 1: {
                    float hour;
                    float wage;
                    String day;
                    float result;
                    DAY enumDay;
                    // wages -> 10
                    // hours -> 2 , 3, 4,
                    // SAT, SUN -> result * 2
                    System.out.println("--------------<<<Wage Calculator>>>-------------");
                    System.out.println("Enter hour(hrs): ");
                    hour = input.nextFloat();
                    System.out.println("Enter wage($): ");
                    wage = input.nextFloat();
                    System.out.println("Enter day (ex. MONDAY,...,SUNDAY): ");
                    day = input.next().toUpperCase();
                    result = wage * hour;
                    // convert normal string to enum
                    enumDay = DAY.valueOf(day);
                    float finalResult= switch (enumDay){
                        case DAY.SATURDAY, DAY.SUNDAY -> result*2;
                        default -> result;
                    };

                    System.out.println("=======================");
                    System.out.println("Hour is : " + hour + "hr" + (hour != 1 ? "s" : ""));
                    System.out.println("Wage is : " + wage + "$/1hrs");
                    System.out.println("Day of work : " + day);
//                    System.out.println("Result is : " + (switch (enumDay) {
//                        case DAY.SATURDAY, DAY.SUNDAY -> result * 2;
//                        default -> result;
//                    }) + "$");
                    System.out.println("Result is : "+finalResult + "$");
                    System.out.println("=======================");

                }
                break;
                case 2: {
                    final float EXCHANGE_RATE = 4100.0f; // Constant exchange rate

                    System.out.println("--------------<<< Money Exchange Program >>>--------------");
                    System.out.println("1. USD to KHR");
                    System.out.println("2. KHR to USD");
                    System.out.print("Choose an option (1 or 2): ");
                    int exchangeOption = input.nextInt();

                    switch (exchangeOption) {
                        case 1 -> {
                            System.out.print("Enter amount in USD: ");
                            float usd = input.nextFloat();
                            float khr = usd * EXCHANGE_RATE;
                            System.out.println("Equivalent in KHR: " + khr + " ៛");
                        }
                        case 2 -> {
                            System.out.print("Enter amount in KHR: ");
                            float khr = input.nextFloat();
                            float usd = khr / EXCHANGE_RATE;
                            System.out.println("Equivalent in USD: $" + usd);
                        }
                        default -> System.out.println("Invalid option! Please try again.");
                    }
                }
                break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option!! Try again!");
                    break;
            }
        } while (option != 5);
    }
}
