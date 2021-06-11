package pt.project.logincontacts.dtos.login_error

data class LoginError(
    val error: Error,
    val success: Boolean
)