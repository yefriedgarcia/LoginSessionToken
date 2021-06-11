package pt.project.crm_pruebatecnica.dtos.auth

data class AuthDetails(
        val expireTime: Int,
        val serverTime: Int,
        val token: String
)