package pt.project.logincontacts

import java.math.BigInteger
import java.security.MessageDigest
import kotlin.experimental.and

class Utils {

    companion object{
        suspend fun md5(token: String): String {
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(token.toByteArray())).toString()
        }

    }
}

