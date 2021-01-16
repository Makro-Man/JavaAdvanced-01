package ua.lviv.lgs;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static int menu() {
        System.out.println("Cinema");
        System.out.println("11 - create new cinema");
        System.out.println("12 - save cinema in file");
        System.out.println("13 - load cinema from file");
        System.out.println("SCHEDULE OF THE CINEMA THEATER");
        System.out.println("21 - create / change the opening hours of the cinema for the day");
        System.out.println("22 - delete the cinema schedule for the day");
        System.out.println("23 - display the working hours of the cinema for a week");
        System.out.println("CINEMA HALLS");
        System.out.println("31 - create a cinema hall");
        System.out.println("32 - remove hall from cinema");
        System.out.println("33 - display a list of cinema halls");
        System.out.println("SCHEDULE OF THE CINEMA HALL");
        System.out.println("41 - create / change the opening hours of the cinema hall for the day");
        System.out.println("42 - delete the opening hours of the cinema hall for the day");
        System.out.println("43 - display the working hours of the cinema hall for a week");
        System.out.println("SCHEDULE OF SESSIONS OF THE CINEMA HALL");
        System.out.println("51 - create / change the schedule of cinema hall sessions for the day");
        System.out.println("52 - delete the cinema hall session schedule for the day");
        System.out.println("53 - display the schedule of cinema hall sessions for a week");
        System.out.println("CINEMA HALL SESSIONS FOR A DAY");
        System.out.println("61 - add a session to the cinema hall session schedule for the day");
        System.out.println("62 - remove a session from the cinema hall session schedule for the day");
        System.out.println("FILMS");
        System.out.println("71 - add a movie and a set of sessions to the cinema hall schedule");
        System.out.println("72 - remove a movie from the schedule of all cinema halls");
        System.out.println("0 - exit the program");
        System.out.println();

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int menuChoise = scanner.nextInt();

        return menuChoise;
    }

    public static void main(String[] args)
            throws NumberFormatException, IllegalTimeFormatException, IOException, ClassNotFoundException {
        Cinema cinema = null;

        while (true) {
            switch (menu()) {

                case 11: {
                    cinema = Cinema.inputCinema();
                    break;
                }

                case 12: {
                    SerializeMethods.serialize(cinema, new File("Cinema.obj"));
                    System.out.println("Cinema " + cinema.getName() + " successfully saved to file!");
                    break;
                }

                case 13: {
                    cinema = (Cinema) SerializeMethods.deserialize(new File("Cinema.obj"));
                    System.out.println("Cinema " + cinema.getName() + " successfully loaded from file!");
                    break;
                }

                case 21: {
                    cinema.addTimeTableToCinema();
                    break;
                }

                case 22: {
                    cinema.removeTimeTableFromCinema();
                    break;
                }

                case 23: {
                    cinema.viewCinemaTimeTable();
                    break;
                }

                case 31: {
                    cinema.addHallToCinema();
                    break;
                }

                case 32: {
                    cinema.removeHallFromCinema();
                    break;
                }

                case 33: {
                    cinema.viewCinemaHalls();
                    break;
                }

                case 41: {
                    cinema.addTimeTableToHallInCinema();
                    break;
                }

                case 42: {
                    cinema.removeTimeTableFromHallInCinema();
                    break;
                }

                case 43: {
                    cinema.viewHallTimeTableInCinema();
                    break;
                }

                case 51: {
                    cinema.addScheduleToHallInCinema();
                    break;
                }

                case 52: {
                    cinema.removeScheduleFromHallInCinema();
                    break;
                }

                case 53: {
                    cinema.viewHallScheduleInCinema();
                    break;
                }

                case 61: {
                    cinema.addSeanceToScheduleInHallInCinema();
                    break;
                }

                case 62: {
                    cinema.removeSeanceFromScheduleInHallInCinema();
                    break;
                }

                case 71: {
                    cinema.addMovieToSeanceInScheduleInHallInCinema();
                    break;
                }

                case 72: {
                    cinema.removeMovieFromSeanceInScheduleInAllHallsInCinema();
                    break;
                }

                case 0: {
                    System.exit(0);
                    break;
                }

                default: {
                    System.err.println("None");
                    break;
                }
            }
        }
    }
}

