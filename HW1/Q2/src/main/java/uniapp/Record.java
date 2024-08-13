package  uniapp;

import java.util.ArrayList;
import java.util.List;

class Record {
    int termId;
    int courseId;
    double grade;
    boolean isMehman;

    public Record(int termId, int courseId, double grade, boolean isMehman) {
        this.termId = termId;
        this.courseId = courseId;
        this.grade = grade;
        this.isMehman = isMehman;
    }
}