package practice5;

public class Teacher {

    private String name;
    private String degree;

    public Teacher(String Name, String Degree) throws TeacherException {

        String tempName = Name.trim();
        String NameError = "";
        if (tempName.equals("")) {
            NameError = "Name was not filled";
        }

        String tempDegree = Degree.trim();
        String DegreeError = "";
        if (tempDegree.equals("")) {
            DegreeError = "Degree was not filled";
        }
        
        String Error = "";
        if (!NameError.equals("")) {
            Error += NameError + "\n";
        }
        if (!DegreeError.equals("")) {
            Error += DegreeError + "\n";
        }
        if (!Error.equals("")) {
            throw new TeacherException(Error);
        }

        name = tempName;
        degree = tempDegree;

    }

    @Override
    public String toString() {
        return "Name: " + name + ", Degree: " + degree;
    }

    public class TeacherException extends Exception {

        public TeacherException(String msg) {
            super(msg);
        }

        @Override
        public String getMessage() {
            return super.getMessage();
        }
    }
}
