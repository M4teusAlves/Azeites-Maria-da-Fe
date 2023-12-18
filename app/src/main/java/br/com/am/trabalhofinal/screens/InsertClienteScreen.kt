package br.com.am.trabalhofinal.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.am.trabalhofinal.Screen
import br.com.am.trabalhofinal.model.Cliente
import br.com.am.trabalhofinal.model.DAO
import br.com.am.trabalhofinal.model.Transition


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InsertClienteScreen(
    navController: NavController,
    dao : DAO
){
    var cpf by remember{ mutableStateOf("") }
    var nome by remember{ mutableStateOf("") }
    var telefone by remember{ mutableStateOf("") }
    var endereco by remember{ mutableStateOf("") }





    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ){
            Row (modifier = Modifier
                .background(Color(0, 0, 132), RectangleShape)
                .fillMaxWidth()
                .height(50.dp)
                .padding(10.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically){
                Text(text = "Azeites Maria da Fé", color = Color.White)
            }
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){

                Text(fontSize = 30.sp,text = Transition.contexto +" Cliente")
                Spacer(modifier = Modifier.height(30.dp))



                TextField(
                    value = cpf,
                    onValueChange = {cpf = it},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    placeholder = { Text(text = "CPF") }
                )
                Spacer(modifier = Modifier.height(20.dp))
                TextField(
                    value = nome,
                    onValueChange = {nome = it},
                    placeholder = { Text(text = "Nome") }
                )
                Spacer(modifier = Modifier.height(20.dp))
                TextField(
                    value = telefone,
                    onValueChange = {telefone = it},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    placeholder = { Text(text = "Telefone") }
                )
                Spacer(modifier = Modifier.height(20.dp))
                TextField(
                    value = endereco,
                    onValueChange = {endereco = it},
                    placeholder = { Text(text = "Endereço") }
                )


                Spacer(modifier = Modifier.height(30.dp))
                Button(onClick = {

                    dao.inserirCliente(Cliente(cpf, nome, telefone, endereco))
                    navController.navigate(Screen.ListCliente.route)

                }) {
                    Text(text = "Cadastrar")
                }

            }

        }
    }


}