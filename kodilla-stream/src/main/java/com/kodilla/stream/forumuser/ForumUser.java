package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int id;
    private final String name;
    private final char sex;
    private final LocalDate birthYear;
    private final int postsPublished;

    public ForumUser(final int id, final String name, final char sex, final int yearOfBirth,
                     final int monthOfBirth, final int dayOfBirth, final int postsPublished) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthYear = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        this.postsPublished = postsPublished;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthYear() {
        return birthYear;
    }

    public int getPostsPublished() {
        return postsPublished;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", birthYear=" + birthYear +
                ", postsPublished=" + postsPublished +
                '}';
    }
}
