package app.shmehdi.quote.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import app.shmehdi.quote.Greeting
import android.widget.TextView
import androidx.activity.viewModels
import app.shmehdi.quote.android.ui.auth.AuthViewModel
import app.shmehdi.quote.models.dto.LoginRequest
import dagger.hilt.android.AndroidEntryPoint

fun greet(): String {
    return Greeting().greeting()
}

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val viewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = greet()

        viewModel.login(LoginRequest("mehdi@gmail.com", "password"))

        viewModel.isLoading.observe(this) {
            Log.d("TAG","Loading $it")
            tv.text = "Loading $it"
        }

        viewModel.error.observe(this) {
            Log.d("TAG","Error ${it.errorMessage} code ${it.errorCode}")
            tv.text = it.errorMessage
        }
    }
}
