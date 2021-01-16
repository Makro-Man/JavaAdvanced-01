package ua.lviv.lgs;


import java.util.Scanner;

public enum Days {
    MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6), SUNDAY(7);

    int serialNumber;

    Days(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public String toLiteral(boolean fullType) {
        String dayToLiteralFull;
        String dayToLiteralShort;

        switch (Days.this) {
            case MONDAY:
                dayToLiteralFull = "Monday";
                dayToLiteralShort = "Mon";
                break;
            case TUESDAY:
                dayToLiteralFull = "Tuesday";
                dayToLiteralShort = "Tue";
                break;
            case WEDNESDAY:
                dayToLiteralFull = "Wednesday";
                dayToLiteralShort = "Wed";
                break;
            case THURSDAY:
                dayToLiteralFull = "Thursday";
                dayToLiteralShort = "Thu";
                break;
            case FRIDAY:
                dayToLiteralFull = "Friday";
                dayToLiteralShort = "Fri";
                break;
            case SATURDAY:
                dayToLiteralFull = "Saturday";
                dayToLiteralShort = "Sat";
                break;
            case SUNDAY:
                dayToLiteralFull = "Sunday";
                dayToLiteralShort = "Sun";
                break;
            default:
                dayToLiteralFull = dayToLiteralShort = "";
                break;
        }

        if (fullType)
            return dayToLiteralFull;
        else
            return dayToLiteralShort;
    }

    public static Days inputDay() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        Integer returnedNumber = 0;
        Days foundDay = null;

        System.out.print("Enter the day of the week: ");
        if (scanner.hasNextInt()) {
            int nextInt = scanner.nextInt();

            if (nextInt > 0 && nextInt <= Days.values().length) {
                returnedNumber = nextInt;
            } else
                System.err.println("The weekday number must be between 1 and 7!");
        } else
            System.err.println("The day of the week was entered incorrectly!");

        for (Days day : Days.values()) {
            if (day.getSerialNumber() == returnedNumber) {
                foundDay = day;
            }
        }

        return foundDay;
    }
}

