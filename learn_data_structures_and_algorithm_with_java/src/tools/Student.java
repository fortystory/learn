package tools;
public class Student {
    private String name;
    private int score;

    public Student(String studentname,int studentscore){
        name = studentname;
        score = studentscore;
    }

    @Override
    public String toString(){
        return String.format("Student(name : %s, score %d)", name, score);
    }
}
