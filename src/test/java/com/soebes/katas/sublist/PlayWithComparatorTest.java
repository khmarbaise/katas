package com.soebes.katas.sublist;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

public class PlayWithComparatorTest
{
    Comparator<Person> PersonComparator = new Comparator<Person>()
    {
        @Override
        public int compare( Person o1, Person o2 )
        {
            int lastName = o1.getLastName().compareTo( o2.getLastName() );
            if ( lastName == 0 )
            {
                int firstName = o1.getFirstName().compareTo( o2.getFirstName() );
                if ( firstName == 0 )
                {
                    return Integer.compare( o1.getAge(), o2.getAge() );
                }
                else
                {
                    return firstName;
                }
            }
            else
            {
                return lastName;
            }
        }
    };

    Person michael = new Person( "Michael", "Jackson", 51 );

    Person jarmaine = new Person( "Jarmaine", "Jackson", 61 );

    Person rod = new Person( "Rod", "Stuart", 65 );

    Person paul = new Person( "Paul", "McCartney", 74 );

    Person mick = new Person( "Mick", "Jagger", 73 );

    @Test
    void michaelAndJarmaineShould()
    {
        int result = PersonComparator.compare( michael, jarmaine );
        assertThat( result ).isGreaterThan( 0 );
    }

    @Test
    void jarmaineAndMichaelShould()
    {
        int result = PersonComparator.compare( jarmaine, michael );
        assertThat( result ).isLessThan( 0 );
    }

    @Test
    void michaelAndRod()
    {
        int result = PersonComparator.compare( michael, rod );
        assertThat( result ).isLessThan( 0 );
    }

    @Test
    void paulAndPaul()
    {
        int result = PersonComparator.compare( paul, paul );
        assertThat( result ).isEqualTo( 0 );
    }

    @Test
    void testName()
    {
        List<Person> personsList = Arrays.asList( rod, jarmaine, michael, paul, mick );

        personsList.sort( PersonComparator );

        personsList.forEach( System.out::println );
//        assertThat( PersonComparator.compare( michael, stuart ) ).isEqualTo( 0 );
    }
}
