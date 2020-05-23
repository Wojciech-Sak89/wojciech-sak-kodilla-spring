package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public class Forum {

    private final List<ForumUser> forumUsers = new ArrayList<>();

    public Forum() {
        forumUsers.add(new ForumUser(1001, "Neo One", 'M', 1970, 5, 12, 122));
        forumUsers.add(new ForumUser(1002, "Franek Kimono", 'M', 1960, 4, 10, 0));
        forumUsers.add(new ForumUser(1003, "Morning Star", 'F', 1997, 1, 22, 778));
        forumUsers.add(new ForumUser(1004, "Dancing Queen", 'F', 1987, 2, 4, 33));
        forumUsers.add(new ForumUser(1005, "Lindsay Stirling", 'F', 1984, 11, 1, 200));
        forumUsers.add(new ForumUser(1006, "Hini Houdini", 'M', 1922, 9, 19, 1));
        forumUsers.add(new ForumUser(1007, "Jack London", 'M', 2002, 4, 4, 990));
        forumUsers.add(new ForumUser(1008, "Dan Simmons", 'M', 1995, 1, 1, 100));
        forumUsers.add(new ForumUser(1009, "Clarie North", 'F', 2001, 8, 7, 7));
        forumUsers.add(new ForumUser(1010, "Trinity Black", 'F', 1975, 9, 2, 333));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(forumUsers);
    }
}
