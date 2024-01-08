
import java.util.Scanner;

public class CalendarProgram {
    public static void main(String[] args) {
        // Get input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the year: ");
        int year = scanner.nextInt();
        System.out.print("Enter the month (1-12): ");
        int month = scanner.nextInt();

        // Print the calendar for the given year and month
        printCalendar(year, month);
    }

    public static void printCalendar(int year, int month) {
        // Print the month title
        printMonthTitle(year, month);

        // Print the month body
        printMonthBody(year, month);
    }

    public static void printMonthTitle(int year, int month) {
        String monthName = getMonthName(month);
        System.out.println(" " + monthName + " " + year);
        System.out.println("-----------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
    }

    public static void printMonthBody(int year, int month) {
        int startDay = getStartDay(year, month);
        int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);

        // Pad space before the first day of the month
        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }

        // Print the days of the month
        for (int day = 1; day <= numberOfDaysInMonth; day++) {
            System.out.printf("%4d", day);

            // Start a new line after Saturday
            if ((day + startDay) % 7 == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }

    public static String getMonthName(int month) {
        String[] monthNames = {
            "January", "February", "March", "April",
            "May", "June", "July", "August",
            "September", "October", "November", "December"
        };
        return monthNames[month - 1];
    }

    public static int getStartDay(int year, int month) {
        final int START_DAY_FOR_JAN_1_1800 = 3;
        int totalNumberOfDays = getTotalNumberOfDays(year, month);
        return (totalNumberOfDays + START_DAY_FOR_JAN_1_1800) % 7;
    }

    public static int getTotalNumberOfDays(int year, int month) {
        int totalDays = 0;

        // Get the total number of days from 1800 to year - 1
        for (int i = 1800; i < year; i++) {
            if (isLeapYear(i)) {
                totalDays += 366;
            } else {
                totalDays += 365;
            }
        }

        // Add the total number of days from January to the previous month
        for (int i = 1; i < month; i++) {
            totalDays += getNumberOfDaysInMonth(year, i);
        }

        return totalDays;
    }

    public static int getNumberOfDaysInMonth(int year, int month) {
        if (month == 2) {
            return isLeapYear(year) ? 29 : 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }

    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}
