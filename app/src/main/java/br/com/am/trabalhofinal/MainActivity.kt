package br.com.am.trabalhofinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.am.trabalhofinal.model.DAO
import br.com.am.trabalhofinal.ui.theme.TrabalhoFinalTheme
import com.google.firebase.Firebase
import com.google.firebase.database.database


class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val database = Firebase.database
            val dao = DAO(database)

            navController = rememberNavController()
            SetupNavGraph(navController, dao)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TrabalhoFinalTheme {
        Greeting("Android")
    }
}