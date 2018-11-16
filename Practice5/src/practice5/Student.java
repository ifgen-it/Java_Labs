package practice5;

public class Student {

    private String name;
    private int age;

    public Student(String Name, String Age) throws StudentException {

        String tempName = Name.trim();
        String NameError = "";
        if (tempName.equals("")) {
            NameError = "Name was not filled";
        }

        int tempAge = 0;
        boolean AgeFail = false;
        String AgeError = "";
        try {
            tempAge = Integer.parseInt(Age);
        } catch (NumberFormatException ex) {
            AgeError = "Age must be an integer value";
            AgeFail = true;
        }
        if (!AgeFail) {
            if (tempAge < 12 || tempAge > 122) {
                AgeError = "Age must be between 12 and 122 years";
            }
        }

        String Error = "";
        if (!NameError.equals("")) {
            Error += NameError + "\n";
        }
        if (!AgeError.equals("")) {
            Error += AgeError + "\n";
        }
        if (!Error.equals("")) {
            throw new StudentException(Error);
        }

        name = tempName;
        age = tempAge;

    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }

    public class StudentException extends Exception {

        public StudentException(String msg) {
            super(msg);
        }

        @Override
        public String getMessage() {
            return super.getMessage();
        }
    }
}
