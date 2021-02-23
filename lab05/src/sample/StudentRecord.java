package sample;

public class StudentRecord{
    private String studentID;
    private float assignments;
    private float midterm;
    private float finalExam;
    private float finalMark;
    private String letterGrade;

    public StudentRecord(String studentID, float assignments, float midterm, float finalExam){
        this.studentID = studentID;
        this.assignments = assignments;
        this.midterm = midterm;
        this.finalExam = finalExam;
        this.finalMark = FinalMark();
        this.letterGrade = LetterGrade();
    }

    //calc final grade
    private float FinalMark(){
        return ((0.2f)*assignments) + ((0.3f)*midterm) + ((0.5f)*finalExam);
    }

    //letter of final grade
    private String LetterGrade(){
        String letter = "";
        if(finalMark < 50.0f){
            letter = "F";
        }
        else if(finalMark < 60.0f){
            letter = "D";
        }
        else if (finalMark < 70.0f){
            letter = "C";
        }
        else if (finalMark < 80.0f){
            letter = "B";
        }
        else if (finalMark < 100.1f){
            letter = "A";
        }
        return letter;
    }

    //getters
    public String getStudentID(){
        return studentID;
    }

    public float getMidterm(){
        return midterm;
    }

    public float getAssignments(){
        return assignments;
    }

    public float getFinalExam(){
        return finalExam;
    }

    public float getFinalMark(){
        return finalMark;
    }

    public String getLetterGrade(){
        return letterGrade;
    }
}
