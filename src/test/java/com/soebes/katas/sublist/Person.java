package com.soebes.katas.sublist;

public class Person
{
    private String firstName;

    private String lastName;

    private Integer age;

    public Person( String firstName, String lastName, Integer age )
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public Integer getAge()
    {
        return age;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder( );
        sb.append( '[' );
        sb.append( "lastName:" );
        sb.append( lastName );
        sb.append( ", " );
        sb.append( "firstName:" );
        sb.append( firstName );
        sb.append( ", " );
        sb.append( "age:" );
        sb.append( age );
        sb.append( ']' );
        return sb.toString();
    }
}