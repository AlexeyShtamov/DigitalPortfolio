package com.project.dp.models;

public enum Profession {
    BACK_DEV("Backend разработчик"),
    FRONT_DEV("Frontend разработчик"),
    DESIGNER("Дизайнер"),

    ANALYST("Агалитик"),
    TEAM_LEADER("Тимлидер");


    private String name;
    Profession(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
