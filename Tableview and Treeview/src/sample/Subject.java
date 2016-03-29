package sample;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kvdb on 23/03/16.
 */
public class Subject
{
    private String name;
    private List<Teacher> teacherList;

    public Subject(String name)
    {
        this.name = name;
        this.teacherList = new ArrayList<>();
    }

    public Subject(String name, List<Teacher> teacherList)
    {
        this.name = name;
        this.teacherList = teacherList;
    }


    public String getName()
    {
        return name;
    }

    public List<Teacher> getTeacherList()
    {
        return teacherList;
    }

    public void addTeacherToSubject(Teacher newTeacher){
        teacherList.add(newTeacher);
    }

    @Override
    public String toString()
    {
        return name;
    }
}
