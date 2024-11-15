package org.example;

public record User(
        String firstName,
        String lastName,
        String email,
        String officeBuilding,
        String officeNumber,
        String favoriteColor
) {}