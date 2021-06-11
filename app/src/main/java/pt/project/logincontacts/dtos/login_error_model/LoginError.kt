package pt.project.logincontacts.dtos.login_error_model

data class LoginError(
    val error: Error,
    val success: Boolean
)