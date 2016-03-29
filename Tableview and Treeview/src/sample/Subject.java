package sample;

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
    }

    public Subject(String name, List<Teacher> teacherList)
    {
        this.name = name;
        this.teacherList = teacherList;
    }

    public void addTeacherToSubject(Teacher newTeacher){
        teacherList.add(newTeacher);
    }
}
