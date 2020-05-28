package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User peter = new Millenials("Peter Parker");
        User laura = new YGeneration("Laura Palmer");
        User johnny = new ZGeneration("Johnny Cage");

        //When
        String petersSocialNetwork = peter.sharePost();
        System.out.println("Peter's social network: " + petersSocialNetwork);
        String laurasSocialNetwork = laura.sharePost();
        System.out.println("Laura's social network: " + laurasSocialNetwork);
        String johnnysSocialNetwork = johnny.sharePost();
        System.out.println("Johnny's social network: " + johnnysSocialNetwork);

        //Then
        Assert.assertEquals("I am using Facebook!", petersSocialNetwork);
        Assert.assertEquals("I am using Twitter!", laurasSocialNetwork);
        Assert.assertEquals("I am using Snapchat!", johnnysSocialNetwork);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User martin = new Millenials("Martin Scorsese");

        //When
        String martinsSocialNetwork = martin.sharePost();
        System.out.println("Martin's social network: " + martinsSocialNetwork);
        martin.setSocialPublisher(new SnapchatPublisher());
        martinsSocialNetwork = martin.sharePost();
        System.out.println("Martin's new social network: " + martinsSocialNetwork);

        //Then
        Assert.assertEquals("I am using Snapchat!", martinsSocialNetwork);
    }
}
