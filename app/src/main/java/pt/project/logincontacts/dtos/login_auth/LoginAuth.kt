package pt.project.logincontacts.dtos.login_auth

import pt.project.logincontacts.dtos.login_error.Error

data class LoginAuth(
    val result: Result,
    val success: Boolean,
    val error: Error,
)