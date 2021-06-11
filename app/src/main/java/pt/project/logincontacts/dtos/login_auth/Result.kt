package pt.project.logincontacts.dtos.login_auth

data class Result(
    val sessionName: String,
    val userId: String,
    val version: String,
    val vtigerVersion: String
)