package pt.project.logincontacts.dtos.login_error

data class Error(
    val code: String,
    val message: String,
    val xdebug_message: String
)