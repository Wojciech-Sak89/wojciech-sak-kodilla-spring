package com.kodilla.testing.forum.statistics;

import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatiscticsCalculatorTestSuite {

    int counter = 1;

    @Before
    public void before() {
        System.out.println("Test Case " + "#" + counter + " begins");
    }

    @After
    public void after() {
        System.out.println("Test Case " + "#" + counter + " has ended\n");
        counter++;
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }

    @Test
    public void testZeroPosts_CalculateAdvStatistics() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        ArrayList<String> marvelSpiders = new ArrayList<>();
        marvelSpiders.add("Auntie May");
        marvelSpiders.add("Uncle Ben");
        marvelSpiders.add("Spider-Man");
        marvelSpiders.add("Peter Parker");
        marvelSpiders.add("Mary Jane");
        marvelSpiders.add("Magneto");
        int spidersPosts = 0;
        int spidersComments = 7398;

        when(statisticsMock.usersNames()).thenReturn(marvelSpiders);
        when(statisticsMock.postsCount()).thenReturn(spidersPosts);
        when(statisticsMock.commentsCount()).thenReturn(spidersComments);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        statisticsCalculator.showStatistics();

        //When
        double postsPerUser = statisticsCalculator.getPostsPerUser();
        double commentsPerPost = statisticsCalculator.getCommentsPerPost();

        //Then
        assertEquals(0, postsPerUser, 0.01);
        assertEquals(-1, commentsPerPost, 0.01);

    }

    @Test
    public void testThousandPosts_CalculateAdvStatistics() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        ArrayList<String> marvelSpiders = new ArrayList<>();
        marvelSpiders.add("Auntie May");
        marvelSpiders.add("Uncle Ben");
        marvelSpiders.add("Spider-Man");
        marvelSpiders.add("Peter Parker");
        marvelSpiders.add("Mary Jane");
        marvelSpiders.add("Magneto");
        int spidersPosts = 1000;
        int spidersComments = 7398;

        when(statisticsMock.usersNames()).thenReturn(marvelSpiders);
        when(statisticsMock.postsCount()).thenReturn(spidersPosts);
        when(statisticsMock.commentsCount()).thenReturn(spidersComments);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        statisticsCalculator.showStatistics();

        //When
        double postsPerUser = statisticsCalculator.getPostsPerUser();
        double commentsPerPost = statisticsCalculator.getCommentsPerPost();

        //Then
        assertEquals(166.66, postsPerUser, 0.01);
        assertEquals(7.39, commentsPerPost, 0.01);
    }

    @Test
    public void testZeroComments_CalculateAdvStatistics() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        ArrayList<String> marvelSpiders = new ArrayList<>();
        marvelSpiders.add("Auntie May");
        marvelSpiders.add("Uncle Ben");
        marvelSpiders.add("Spider-Man");
        marvelSpiders.add("Peter Parker");
        marvelSpiders.add("Mary Jane");
        marvelSpiders.add("Magneto");
        int spidersPosts = 1000;
        int spidersComments = 0;

        when(statisticsMock.usersNames()).thenReturn(marvelSpiders);
        when(statisticsMock.postsCount()).thenReturn(spidersPosts);
        when(statisticsMock.commentsCount()).thenReturn(spidersComments);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        statisticsCalculator.showStatistics();

        //When
        double commentsPerUser = statisticsCalculator.getCommentsPerUser();
        double commentsPerPost = statisticsCalculator.getCommentsPerPost();

        //Then
//        assertEquals(166, postsPerUser, 0.01);
        assertEquals(0, commentsPerUser, 0.01);
        assertEquals(0, commentsPerPost, 0.01);
    }

    @Test
    public void testCommentsLessThanPosts_CalculateAdvStatistics() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        ArrayList<String> marvelSpiders = new ArrayList<>();
        marvelSpiders.add("Auntie May");
        marvelSpiders.add("Uncle Ben");
        marvelSpiders.add("Spider-Man");
        marvelSpiders.add("Peter Parker");
        marvelSpiders.add("Mary Jane");
        marvelSpiders.add("Magneto");
        int spidersPosts = 3888;
        int spidersComments = 500;

        when(statisticsMock.usersNames()).thenReturn(marvelSpiders);
        when(statisticsMock.postsCount()).thenReturn(spidersPosts);
        when(statisticsMock.commentsCount()).thenReturn(spidersComments);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        statisticsCalculator.showStatistics();

        //When
        double postsPerUser = statisticsCalculator.getPostsPerUser();
        double commentsPerUser = statisticsCalculator.getCommentsPerUser();
        double commentsPerPost = statisticsCalculator.getCommentsPerPost();

        //Then
        assertEquals(648, postsPerUser, 0.01);
        assertEquals(83.33, commentsPerUser, 0.01);
        assertEquals(0.12, commentsPerPost, 0.01);
    }

    @Test
    public void testCommentsMoreThanPosts_CalculateAdvStatistics() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        ArrayList<String> marvelSpiders = new ArrayList<>();
        marvelSpiders.add("Auntie May");
        marvelSpiders.add("Uncle Ben");
        marvelSpiders.add("Spider-Man");
        marvelSpiders.add("Peter Parker");
        marvelSpiders.add("Mary Jane");
        marvelSpiders.add("Magneto");
        int spidersPosts = 50;
        int spidersComments = 3000;

        when(statisticsMock.usersNames()).thenReturn(marvelSpiders);
        when(statisticsMock.postsCount()).thenReturn(spidersPosts);
        when(statisticsMock.commentsCount()).thenReturn(spidersComments);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        statisticsCalculator.showStatistics();

        //When
        double postsPerUser = statisticsCalculator.getPostsPerUser();
        double commentsPerUser = statisticsCalculator.getCommentsPerUser();
        double commentsPerPost = statisticsCalculator.getCommentsPerPost();

        //Then
        assertEquals(8.33, postsPerUser, 0.01);
        assertEquals(500, commentsPerUser, 0.01);
        assertEquals(60, commentsPerPost, 0.01);

    }

    @Test
    public void testZeroUsers_CalculateAdvStatistics() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        ArrayList<String> marvelSpiders = new ArrayList<>();
        int spidersPosts = 50;
        int spidersComments = 3000;

        when(statisticsMock.usersNames()).thenReturn(marvelSpiders);
        when(statisticsMock.postsCount()).thenReturn(spidersPosts);
        when(statisticsMock.commentsCount()).thenReturn(spidersComments);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        statisticsCalculator.showStatistics();

        //When
        double postsPerUser = statisticsCalculator.getPostsPerUser();
        double commentsPerUser = statisticsCalculator.getCommentsPerUser();
        double commentsPerPost = statisticsCalculator.getCommentsPerPost();

        //Then
        assertEquals(-1, postsPerUser, 0.01);
        assertEquals(-1, commentsPerUser, 0.01);
        assertEquals(60, commentsPerPost, 0.01);


    }

    @Test
    public void testHundredUsers_CalculateAdvStatistics() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        ArrayList<String> marvelSpiders = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            marvelSpiders.add("Name #" + i);
        }

        int spidersPosts = 100;
        int spidersComments = 1000;

        when(statisticsMock.usersNames()).thenReturn(marvelSpiders);
        when(statisticsMock.postsCount()).thenReturn(spidersPosts);
        when(statisticsMock.commentsCount()).thenReturn(spidersComments);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        statisticsCalculator.showStatistics();

        //When
        double postsPerUser = statisticsCalculator.getPostsPerUser();
        double commentsPerUser = statisticsCalculator.getCommentsPerUser();
        double commentsPerPost = statisticsCalculator.getCommentsPerPost();

        //Then
        assertEquals(1, postsPerUser, 0.01);
        assertEquals(10, commentsPerUser, 0.01);
        assertEquals(10, commentsPerPost, 0.01);


    }
}

