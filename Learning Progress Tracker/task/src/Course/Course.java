package Course;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Course {

    private final HashMap<Integer, Student> studentList = new LinkedHashMap<Integer, Student>();
    private final Set<String> emailSet = new HashSet<String>();

    final int JAVA = 600;
    final int DSA = 400;
    final int DB = 480;
    final int SPRING = 550;

    private int ID = 10000;

    public void list() {
        if (studentList.size() == 0) System.out.println("No students found");
        else {
            System.out.println("Students:");
            for (var entry : studentList.entrySet()) {
                System.out.println(entry.getKey());
            }
        }
    }

    public void notifyStudents() {
        int countCompleteCourse = 0;
        for (var entry : studentList.entrySet()) {
            if (entry.getValue().getDSA() == DSA || entry.getValue().getDB() == DB ||
                    entry.getValue().getJava() == JAVA || entry.getValue().getSpring() == SPRING)
                countCompleteCourse++;
        }
        if (countCompleteCourse == 0)
            System.out.println("Total 0 students have been notified.");
        else {
            for (var entry : studentList.entrySet()) {
                if (entry.getValue().getJava() == JAVA) {
                    entry.getValue().setJava(1000);
                    System.out.printf("To: %s\n" +
                            "Re: Your Learning Progress\n" +
                            "Hello, %s! You have accomplished our %s course!\n", entry.getValue().getEmail(), entry.getValue().getName() + " " + entry.getValue().getSurname(), "Java");
                }
                if (entry.getValue().getDSA() == DSA) {
                    entry.getValue().setDSA(1000);
                    System.out.printf("To: %s\n" +
                            "Re: Your Learning Progress\n" +
                            "Hello, %s! You have accomplished our %s course!\n", entry.getValue().getEmail(), entry.getValue().getName() + " " + entry.getValue().getSurname(), "DSA");
                }
                if (entry.getValue().getDB() == DB) {
                    entry.getValue().setDB(1000);
                    System.out.printf("To: %s\n" +
                            "Re: Your Learning Progress\n" +
                            "Hello, %s! You have accomplished our %s course\n", entry.getValue().getEmail(), entry.getValue().getName() + " " + entry.getValue().getSurname(), "Databases");
                }
                if (entry.getValue().getSpring() == SPRING) {
                    entry.getValue().setSpring(1000);
                    System.out.printf("To: %s\n" +
                            "Re: Your Learning Progress\n" +
                            "Hello, %s! You have accomplished our %s course!\n", entry.getValue().getEmail(), entry.getValue().getName() + " " + entry.getValue().getSurname(), "Spring");
                }
            }
            System.out.printf("Total %d students have been notified.\n", countCompleteCourse);
        }
    }

    ;

    public String highestActivity() {
        if (studentList.size() == 0) {
            return " n/a";
        }
        Map<String, Integer> studentsMostPopular = new HashMap<>();
        boolean flag = false;
        StringBuilder resultMostPopular = new StringBuilder();
        int countJavaMostPopular = 0, countDBMostPopular = 0, countDSAMostPopular = 0, countSpringMostPopular = 0;
        for (var entry : studentList.entrySet()) {
            if (entry.getValue().getDSA() > 0) countDSAMostPopular++;
            if (entry.getValue().getDB() > 0) countDBMostPopular++;
            if (entry.getValue().getSpring() > 0) countSpringMostPopular++;
            if (entry.getValue().getJava() > 0) countJavaMostPopular++;
        }
        List<Integer> listMostPopular = new ArrayList<>();
        listMostPopular.add(countJavaMostPopular);
        listMostPopular.add(countDBMostPopular);
        listMostPopular.add(countDSAMostPopular);
        listMostPopular.add(countSpringMostPopular);
        studentsMostPopular.put("Java", countJavaMostPopular);
        studentsMostPopular.put("Spring", countSpringMostPopular);
        studentsMostPopular.put("DSA", countDSAMostPopular);
        studentsMostPopular.put("Databases", countDBMostPopular);
        for (var entry : studentsMostPopular.entrySet()) {
            if (Collections.max(listMostPopular) == entry.getValue()) {
                flag = true;
                resultMostPopular.append(" ").append(entry.getKey().trim());
            }
        }
        if (!flag)
            return " n/a";
        else
            return resultMostPopular.toString();
    }

    public String lowestActivity() {
        if (studentList.size() == 0) {
            return " n/a";
        }
        Map<String, Integer> studentsLeastPopular = new HashMap<>();
        boolean flag = false;
        StringBuilder resultLeastPopular = new StringBuilder();
        int countJavaLeastPopular = 0, countDBLeastPopular = 0, countDSALeastPopular = 0, countSpringLeastPopular = 0;
        for (var entry : studentList.entrySet()) {
            if (entry.getValue().getDSA() == 0) countDSALeastPopular++;
            if (entry.getValue().getDB() == 0) countDBLeastPopular++;
            if (entry.getValue().getSpring() == 0) countSpringLeastPopular++;
            if (entry.getValue().getJava() == 0) countJavaLeastPopular++;
        }
        if (countDBLeastPopular == 0 && countJavaLeastPopular == 0 && countDSALeastPopular == 0 && countSpringLeastPopular == 0)
            return " n/a";
        List<Integer> listLeastPopular = new ArrayList<>();
        listLeastPopular.add(countJavaLeastPopular);
        listLeastPopular.add(countDBLeastPopular);
        listLeastPopular.add(countDSALeastPopular);
        listLeastPopular.add(countSpringLeastPopular);
        studentsLeastPopular.put("Java", countJavaLeastPopular);
        studentsLeastPopular.put("Spring", countSpringLeastPopular);
        studentsLeastPopular.put("DSA", countDSALeastPopular);
        studentsLeastPopular.put("Databases", countDBLeastPopular);
        for (var entry : studentsLeastPopular.entrySet()) {
            if (Collections.max(listLeastPopular) == entry.getValue()) {
                flag = true;
                resultLeastPopular.append(" ").append(entry.getKey().trim());
            }
        }
        if (!flag)
            return " n/a";
        else
            return resultLeastPopular.toString();
    }

    public String leastPopular() {
        if (studentList.size() == 0) {
            return " n/a";
        }
        Map<String, Integer> studentsLeastPopular = new HashMap<>();
        boolean flag = false;
        StringBuilder resultLeastPopular = new StringBuilder();
        int countJavaLeastPopular = 0, countDBLeastPopular = 0, countDSALeastPopular = 0, countSpringLeastPopular = 0;
        for (var entry : studentList.entrySet()) {
            if (entry.getValue().getDSA() == 0) countDSALeastPopular++;
            if (entry.getValue().getDB() == 0) countDBLeastPopular++;
            if (entry.getValue().getSpring() == 0) countSpringLeastPopular++;
            if (entry.getValue().getJava() == 0) countJavaLeastPopular++;
        }
        if (countDBLeastPopular == 0 && countJavaLeastPopular == 0 && countDSALeastPopular == 0 && countSpringLeastPopular == 0)
            return " n/a";
        List<Integer> listLeastPopular = new ArrayList<>();
        listLeastPopular.add(countJavaLeastPopular);
        listLeastPopular.add(countDBLeastPopular);
        listLeastPopular.add(countDSALeastPopular);
        listLeastPopular.add(countSpringLeastPopular);
        studentsLeastPopular.put("Java", countJavaLeastPopular);
        studentsLeastPopular.put("Spring", countSpringLeastPopular);
        studentsLeastPopular.put("DSA", countDSALeastPopular);
        studentsLeastPopular.put("Databases", countDBLeastPopular);
        for (var entry : studentsLeastPopular.entrySet()) {
            if (Collections.max(listLeastPopular) == entry.getValue()) {
                flag = true;
                resultLeastPopular.append(" ").append(entry.getKey().trim());
            }
        }
        if (!flag)
            return " n/a";
        else
            return resultLeastPopular.toString();
    }

    public String mostPopular() {
        if (studentList.size() == 0) {
            return " n/a";
        }
        Map<String, Integer> studentsMostPopular = new HashMap<>();
        boolean flag = false;
        StringBuilder resultMostPopular = new StringBuilder();
        int countJavaMostPopular = 0, countDBMostPopular = 0, countDSAMostPopular = 0, countSpringMostPopular = 0;
        for (var entry : studentList.entrySet()) {
            if (entry.getValue().getDSA() > 0) countDSAMostPopular++;
            if (entry.getValue().getDB() > 0) countDBMostPopular++;
            if (entry.getValue().getSpring() > 0) countSpringMostPopular++;
            if (entry.getValue().getJava() > 0) countJavaMostPopular++;
        }
        List<Integer> listMostPopular = new ArrayList<>();
        listMostPopular.add(countJavaMostPopular);
        listMostPopular.add(countDBMostPopular);
        listMostPopular.add(countDSAMostPopular);
        listMostPopular.add(countSpringMostPopular);
        studentsMostPopular.put("Java", countJavaMostPopular);
        studentsMostPopular.put("Spring", countSpringMostPopular);
        studentsMostPopular.put("DSA", countDSAMostPopular);
        studentsMostPopular.put("Databases", countDBMostPopular);
        for (var entry : studentsMostPopular.entrySet()) {
            if (Collections.max(listMostPopular) == entry.getValue()) {
                flag = true;
                resultMostPopular.append(" ").append(entry.getKey().trim());
            }
        }
        if (!flag)
            return " n/a";
        else
            return resultMostPopular.toString();
    }

    public String easiestCourse() {
        if (studentList.size() == 0) {
            return " n/a";
        }
        Map<String, Double> studentsEasiestCourse = new HashMap<>();
        boolean flag = false;
        StringBuilder resultEasiestCourse = new StringBuilder();
        double countJavaEasiestCourse = 0, countDBEasiestCourse = 0, countDSAEasiestCourse = 0, countSpringEasiestCourse = 0;
        for (var entry : studentList.entrySet()) {
            countDSAEasiestCourse += (double) (entry.getValue().getDSA() / DSA) * 100.0;
            countDBEasiestCourse += (double) (entry.getValue().getDB() / DB) * 100.0;
            countSpringEasiestCourse += (double) (entry.getValue().getSpring() / SPRING) * 100.0;
            countJavaEasiestCourse += (double) (entry.getValue().getJava() / JAVA) * 100.0;
        }
        List<Double> listEasiestCourse = new ArrayList<>();
        listEasiestCourse.add(countJavaEasiestCourse);
        listEasiestCourse.add(countDBEasiestCourse);
        listEasiestCourse.add(countDSAEasiestCourse);
        listEasiestCourse.add(countSpringEasiestCourse);
        studentsEasiestCourse.put("Java", countJavaEasiestCourse);
        studentsEasiestCourse.put("Spring", countSpringEasiestCourse);
        studentsEasiestCourse.put("DSA", countDSAEasiestCourse);
        studentsEasiestCourse.put("Databases", countDBEasiestCourse);
        for (var entry : studentsEasiestCourse.entrySet()) {
            if ((double) Collections.max(listEasiestCourse) == entry.getValue()) {
                flag = true;
                resultEasiestCourse.append(" ").append(entry.getKey().trim());
            }
        }
        if (!flag)
            return " n/a";
        else
            return resultEasiestCourse.toString();
    }

    public String hardestCourse() {
        if (studentList.size() == 0) {
            return " n/a";
        }
        Map<String, Double> studentsMostPopular = new HashMap<>();
        boolean flag = false;
        StringBuilder resultMostPopular = new StringBuilder();
        double countJavaMostPopular = 0, countDBMostPopular = 0, countDSAMostPopular = 0, countSpringMostPopular = 0;
        for (var entry : studentList.entrySet()) {
            countDSAMostPopular += (double) (entry.getValue().getDSA() / DSA) * 100.0;
            countDBMostPopular += (double) (entry.getValue().getDB() / DB) * 100.0;
            countSpringMostPopular += (double) (entry.getValue().getSpring() / SPRING) * 100.0;
            countJavaMostPopular += (double) (entry.getValue().getJava() / JAVA) * 100.0;
        }
        List<Double> listMostPopular = new ArrayList<>();
        listMostPopular.add(countJavaMostPopular);
        listMostPopular.add(countDBMostPopular);
        listMostPopular.add(countDSAMostPopular);
        listMostPopular.add(countSpringMostPopular);
        studentsMostPopular.put("Java", countJavaMostPopular);
        studentsMostPopular.put("Spring", countSpringMostPopular);
        studentsMostPopular.put("DSA", countDSAMostPopular);
        studentsMostPopular.put("Databases", countDBMostPopular);
        for (var entry : studentsMostPopular.entrySet()) {
            if ((double) Collections.min(listMostPopular) == entry.getValue()) {
                flag = true;
                resultMostPopular.append(" ").append(entry.getKey().trim());
            }
        }
        if (!flag)
            return " n/a";
        else
            return resultMostPopular.toString();
    }

    public void Java() {
        System.out.println("Java");
        System.out.println("id " + "   points " + " completed");
        Map<Integer, Student> sortedMap = studentList.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue().getJava()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                ));
        for (var entry : sortedMap.entrySet()) {
            if (entry.getValue().getJava() != 0) {
                System.out.println(entry.getKey() + " " + entry.getValue().getJava() + "     " + String.format("%.1f", ((double) entry.getValue().getJava() / JAVA) * 100.0) + "%");
            }
        }
    }

    public void DSA() {
        System.out.println("DSA");
        System.out.println("id " + "   points " + "  completed");
        Map<Integer, Student> sortedMap = studentList.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue().getDSA()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                ));
        for (var entry : sortedMap.entrySet()) {
            if (entry.getValue().getDSA() != 0) {
                System.out.println(entry.getKey() + " " + entry.getValue().getDSA() + "     " + String.format("%.1f", ((double) entry.getValue().getDSA() / DSA) * 100.0) + "%");
            }
        }
    }

    public void DB() {
        System.out.println("Databases");
        System.out.println("id " + "   points " + "  completed");
        Map<Integer, Student> sortedMap = studentList.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue().getDB()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                ));
        for (var entry : sortedMap.entrySet()) {
            if (entry.getValue().getDB() != 0) {
                System.out.println(entry.getKey() + " " + entry.getValue().getDB() + "     " + String.format("%.1f", ((double) entry.getValue().getDB() / DB) * 100.0) + "%");
            }
        }
    }

    public void Spring() {
        System.out.println("Spring");
        System.out.println("id " + "   points " + "  completed");
        Map<Integer, Student> sortedMap = studentList.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue().getSpring()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                ));
        for (var entry : sortedMap.entrySet()) {
            if (entry.getValue().getSpring() != 0) {
                System.out.println(entry.getKey() + " " + entry.getValue().getSpring() + "     " + String.format("%.1f", ((double) entry.getValue().getSpring() / SPRING) * 100.0) + "%");
            }
        }
    }

    public void statistics() {
        boolean flag = true;
        System.out.println("Type the name of a course to see details or 'back' to quit:");
        System.out.println("Most popular:" + mostPopular());
        System.out.println("Least popular:" + leastPopular());
        System.out.println("Highest activity:" + highestActivity());
        System.out.println("Lowest activity:" + lowestActivity());
        System.out.println("Easiest course:" + easiestCourse());
        System.out.println("Hardest course:" + hardestCourse());
        while (flag) {
            String course = scanner.nextLine().toLowerCase();
            switch (course) {
                case "back":
                    flag = false;
                    break;
                case "java":
                    Java();
                    break;
                case "dsa":
                    DSA();
                    break;
                case "databases":
                    DB();
                    break;
                case "spring":
                    Spring();
                    break;
                default:
                    System.out.println("Unknown course.");
                    break;
            }
        }
    }

    public void addStudents() {
        String tempFirstName = "", tempLastName = "", tempEmail = "";
        System.out.println("Enter student credentials or 'back' to return");
        while (true) {
            String temp = scanner.nextLine();
            temp = temp.trim();
            String[] student = temp.split(" ");
            if (student[0].equals("back")) {
                System.out.println("Total " + studentList.size() + " " + "students have been added.");
                break;
            } else {
                tempEmail = student[student.length - 1];
                tempFirstName = student[0];
                for (int i = 1; i < student.length - 1; i++) {
                    tempLastName = student[i];
                }
                tempLastName = tempLastName.trim();
            }
            if (student.length == 1 || student.length == 2) {
                System.out.println("Incorrect credentials.");
            } else if (testEmail(tempEmail) && testLastName(tempLastName) && testFirstName(tempFirstName)) {
                if (emailSet.contains(tempEmail)) System.out.println("This email is already taken.");
                else {
                    emailSet.add(tempEmail);
                    studentList.put(ID, new Student(tempFirstName, tempLastName, tempEmail));
                    ID++;
                    System.out.println("The student has been added.");
                }
            } else if (!testEmail(tempEmail)) {
                System.out.println("Incorrect email.");
            } else if (!testFirstName(tempFirstName)) {
                System.out.println("Incorrect first name.");
            } else System.out.println("Incorrect last name.");
        }
    }

    public void addPoints() {
        System.out.println("Enter an id and points or 'back' to return:");
        boolean flag = true;
        String[] point;
        while (flag) {
            point = scanner.nextLine().split(" ");
            if (point[0].equals("back")) flag = false;
            else if (point.length != 5) System.out.println("Incorrect points format");
            else if (testPoints(point)) {
                try {
                    if (studentList.containsKey(Integer.parseInt(point[0]))) {
                        studentList.get(Integer.parseInt(point[0])).setJava(studentList.get(Integer.parseInt(point[0])).getJava() + Integer.parseInt(point[1]));
                        studentList.get(Integer.parseInt(point[0])).setDSA(studentList.get(Integer.parseInt(point[0])).getDSA() + Integer.parseInt(point[2]));
                        studentList.get(Integer.parseInt(point[0])).setDB(studentList.get(Integer.parseInt(point[0])).getDB() + Integer.parseInt(point[3]));
                        studentList.get(Integer.parseInt(point[0])).setSpring(studentList.get(Integer.parseInt(point[0])).getSpring() + Integer.parseInt(point[4]));
                        System.out.println("Points updated.");
                    } else {
                        System.out.printf("No student is found for id=%s", point[0]);
                    }
                } catch (Exception e) {
                    System.out.printf("No student is found for id=%s", point[0]);
                }
            } else {
                System.out.println("Incorrect points format");
            }
        }
    }

    public boolean testPoints(String[] str) {
        return ((Character.isDigit(str[1].charAt(0)) && Integer.parseInt((str[1])) >= 0) && (Character.isDigit(str[2].charAt(0)) && Integer.parseInt((str[2])) >= 0) && (Character.isDigit(str[3].charAt(0)) && Integer.parseInt((str[3])) >= 0) && (Character.isDigit(str[4].charAt(0)) && Integer.parseInt((str[4])) >= 0));
    }

    public void find() {
        System.out.println("Enter an id or 'back' to return");
        boolean flag = true;
        String ID;
        while (flag) {
            ID = scanner.nextLine();
            if (ID.equals("back")) flag = false;
            else if (!studentList.containsKey(Integer.parseInt(ID)))
                System.out.printf("No student is found for id=%s\n", ID);
            else {
                System.out.printf("%s points: Java=%d; DSA=%d; Databases=%d; Spring=%d\n", ID, studentList.get(Integer.parseInt(ID)).getJava(), studentList.get(Integer.parseInt(ID)).getDSA(), studentList.get(Integer.parseInt(ID)).getDB(), studentList.get(Integer.parseInt(ID)).getSpring());
            }
        }
    }

    public boolean testEmail(String str) {
        String regex = "^[a-zA-Z0-9.!#$%&'*+/=? ^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    public boolean testLastName(String str) {
        if (str.length() == 1) return false;
        String regex = "^(\\s)*[A-Za-z]+((\\s)?((\\'|\\-|\\.)?([A-Za-z])+))*(\\s)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    public boolean testFirstName(String str) {
        if (str.length() == 1) return false;
        String regex = "^(\\s)*[A-Za-z]+((\\s)?((\\'|\\-|\\.)?([A-Za-z])+))*(\\s)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    final Scanner scanner = new Scanner(System.in);
}
