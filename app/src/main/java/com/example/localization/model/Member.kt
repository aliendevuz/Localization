package com.example.localization.model

class Member(var fullname: String, var age: Int) {
    override fun toString(): String {
        return "Member{" +
                "fullname='" + fullname + "\'" +
                ", age=" + age +
                "}"
    }
}
