package sample;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kvdb on 23/03/16.
 */
public class Subject implements Nameable
{
    private String name;
    private ArrayList<Teacher> teacherList;

    public Subject(String name) {
        this.name = name;
        this.teacherList = new ArrayList<>();
    }

    public void addTeacherToSubject(Teacher newTeacher){
        teacherList.add(newTeacher);
    }

    @Override
    public String toString()
    {
        return name;
    }

    public String getName() {
        return name;
    }

    @Override
    public ArrayList<Teacher> getTeachers() {
        return teacherList;
    }

}
