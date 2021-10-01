package com.soebes.katas.sublist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class MapTest
{
    // Do a version comparator
    // based on the example of Person comparator
    // in Java 8 ?

    @Test
    void testName()
    {
        Map<String, List<String>> mapList = new HashMap<>();

        mapList.computeIfAbsent( "FirstMapKey", m -> new ArrayList<>() ).add( "EntryOne" );

        // if (!mapList.containsKey("First")) {
        //   List<String> subList = new ArrayList<>();
        //   subList.addiere("Second");
        //   mapList.put("First", subList);
        // }

        mapList.computeIfPresent( "FirstMapKey", ( k, v ) -> v ).add( "EntrySecond" );

        mapList.compute( "FirstMapKey", ( k, v ) -> v == null ? new ArrayList<>() : v ).add( "EntryThird" );
        mapList.compute( "SecondMapKey", ( k, v ) -> v == null ? new ArrayList<>() : v ).add( "SecondMapKey-EntryOne" );

        // mapList.putIfAbsent("SecondMapKey", new ArrayList<>()).addiere("EntrySecondOne");

        // FIXME: Not yet correctly understood ?
        mapList.merge( "ThirdsMapKey", new ArrayList<>(), ( k, v ) -> v ).add( "EntryThirdMapKey-One" );
        mapList.merge( "ThirdsMapKey", new ArrayList<>(), ( k, v ) -> v ).add( "EntryThirdMapKey-Two" );
        mapList.entrySet().forEach( entry -> System.out.println( "K:" + entry.getKey() + " V:" + entry.getValue() ) );

        //		mapList.computeIfAbsent("XX", throw new IllegalArgumentException("test"));

    }

    static class MP
    {
        private String groupId;
        private String artifactId;
		private String version;

        public MP( String groupId, String artifactId, String version )
        {
            this.groupId = groupId;
            this.artifactId = artifactId;
			this.version = version;
		}

        public String getGroupId()
        {
            return groupId;
        }

        public String getArtifactId()
        {
            return artifactId;
        }

		public String getVersion()
		{
			return version;
		}

		@Override
		public String toString()
		{
			return "MP{" +
					"groupId='" + groupId + '\'' +
					", artifactId='" + artifactId + '\'' +
					", version='" + version + '\'' +
					'}';
		}
	}


    private static final List<MP> PROJECTS =
            List.of( new MP( "com.soebes", "first", "1.0" ),
                    new MP( "com.soebes.first", "first", "1.0" ),
                    new MP( "com.soebes.second", "second", "1.0" ),
                    new MP( "com.soebes", "first", "2.0" ) );

    private Function<MP, String> projectIntoVersionlessKey = s -> s.getGroupId() + ":" + s.getArtifactId();

    @Test
    void another_test()
    {

        Map<String, List<MP>> collect = PROJECTS.stream()
                .collect( Collectors.toMap( projectIntoVersionlessKey, v -> {
                            List<MP> l = new ArrayList<>( 1 );
                            l.add( v );
                            return l;
                        },
                        ( first, second ) -> {
							System.out.println( "first = " + first );
							first.add( second.get( 0 ) );
					return first;} ) );

        collect.entrySet().stream()
				.forEach( s -> System.out.println( "k=" + s.getKey() + " Nr:" + s.getValue().size() + " s = " + s.getValue() ) );
    }

	@Test
	void using_groupby()
	{
		Map<String, List<MP>> collect = PROJECTS.stream().collect( Collectors.groupingBy( projectIntoVersionlessKey ) );
		collect.entrySet().stream()
				.forEach( s -> System.out.println( "k=" + s.getKey() + " Nr:" + s.getValue().size() + " s = " + s.getValue() ) );

	}

    @Test
    void another_way_to_do_it()
    {
        Map<String, List<MP>> collect = PROJECTS.stream().collect( Collectors.groupingBy( projectIntoVersionlessKey,
                Collectors.mapping( mp -> mp, Collectors.toList() ) ) );
    }

    @Test
    void name()
    {
        String apply = projectIntoVersionlessKey.apply( new MP( "a", "x", "1.0" ) );

        Map<String, List<MP>> collect = PROJECTS.stream().collect( Collectors.groupingBy( projectIntoVersionlessKey,
                Collectors.mapping( mp -> mp, Collectors.toList() ) ) );

        List<String> collect1 = Optional.ofNullable( collect.get( apply ) ).orElse( Collections.emptyList() ).stream()
                .map( s -> s.getVersion() ).collect( Collectors.toList() );


    }
}
