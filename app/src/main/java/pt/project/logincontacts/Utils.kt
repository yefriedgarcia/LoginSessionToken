package pt.project.logincontacts

import android.util.Log
import java.math.BigInteger
import java.security.MessageDigest
import kotlin.experimental.and

class Utils {

    companion object{
        suspend fun md5(token: String): String {
            Log.d("TAG", "md5: "+token)
            val md = MessageDigest.getInstance("MD5")
            Log.d("TAG", "md5-16: "+BigInteger(1, md.digest(token.toByteArray())).toString(16))
            Log.d("TAG", "md5-0: "+BigInteger(1, md.digest(token.toByteArray())).toString())

            return BigInteger(1, md.digest(token.toByteArray())).toString(16)
        }

    }
}

