package sample;

import java.util.List;

/**
 * Created by kvdb on 23/03/16.
 */
public class School
{
    private String name;
    private String location;
    private List<Subject> subjectList;

    public School(String name, String location)
    {
        this.name = name;
        this.location = location;
    }

    public School(String name, String location, List<Subject> subjectList)
    {
        this.name = name;
        this.location = location;
        this.subjectList = subjectList;
    }

    public String getName()
    {
        return name;
    }

    public String getLocation()
    {
        return location;
    }

    public void addSubjectToSchool(Subject newSubject){
        subjectList.add(newSubject);

    }
}
