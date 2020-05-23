package com.kodilla.testing.forum.statistics;

public class StatisticsCalculator {

   private double allUsers;
   private double allPosts;
   private double allComments;
   private double postsPerUser;
   private double commentsPerUser;
   private double commentsPerPost;

    public StatisticsCalculator() {
    }

    public void calculateAdvStatistics(Statistics statistics) {
       allUsers = statistics.usersNames().size();
       allPosts = statistics.postsCount();
       allComments = statistics.commentsCount();

       if (allUsers == 0) {
           postsPerUser = -1;
           commentsPerUser = -1;
       } else {
           postsPerUser = allPosts / allUsers;
           commentsPerUser = allComments / allUsers;
       }

       if (allPosts == 0) {
           commentsPerPost = -1;
       } else {
           commentsPerPost = allComments / allPosts;
       }
   }

   public void showStatistics() {
       System.out.println("Users: " + allUsers);
       System.out.println("Posts: " + allPosts);
       System.out.println("Comments: " + allComments);
       System.out.println("Posts per user: " + postsPerUser);
       System.out.println("Comments per user: " + commentsPerUser);
       System.out.println("Comments per posts: " + commentsPerPost);
   }


    public double getPostsPerUser() {
        return postsPerUser;
    }

    public double getCommentsPerUser() {
        return commentsPerUser;
    }

    public double getCommentsPerPost() {
        return commentsPerPost;
    }
}
