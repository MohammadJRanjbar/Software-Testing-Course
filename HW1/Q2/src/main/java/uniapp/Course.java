
package uniapp;

import java.util.List;

class Course {
    int id;
    List<Integer> pre;

    public Course(int id, List<Integer> pre) {
        this.id = id;
        this.pre = pre;
    }
}