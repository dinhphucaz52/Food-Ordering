package com.example.foodordering.util

object AuthHelper {

    fun validateEmail(email: String): Boolean {
        return email.matches(Regex("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))
    }

    fun validatePassword(password: String): Boolean {
        return password.matches(Regex("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{6,}$"))
    }

    fun validateName(name: String): Boolean {
        return name.matches(Regex("^[a-zA-Z ]+$"))
    }

    fun validatePhone(phone: String): Boolean {
        return phone.matches(Regex("^\\d{10}$"))
    }


}