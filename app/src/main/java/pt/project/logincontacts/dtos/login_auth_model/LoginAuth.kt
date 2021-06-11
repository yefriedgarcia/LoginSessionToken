package pt.project.logincontacts.dtos.login_auth_model

import pt.project.logincontacts.dtos.login_error_model.Error

data class LoginAuth(
    val result: Result,
    val success: Boolean,
    val error: Error,
)