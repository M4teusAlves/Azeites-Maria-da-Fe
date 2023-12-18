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
import br.com.am.trabalhofinal.model.DAO
import br.com.am.trabalhofinal.model.Produto
import br.com.am.trabalhofinal.model.Transition


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InsertProdutoScreen(
    navController: NavController,
    dao : DAO
){
    var id by remember{ mutableStateOf("") }
    var descricao by remember{ mutableStateOf("") }
    var valor by remember{ mutableStateOf("") }





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
                    value = id,
                    onValueChange = {id = it},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    placeholder = { Text(text = "ID") }
                )
                Spacer(modifier = Modifier.height(20.dp))
                TextField(
                    value = descricao,
                    onValueChange = {descricao = it},
                    placeholder = { Text(text = "Descrição") }
                )
                Spacer(modifier = Modifier.height(20.dp))
                TextField(
                    value = valor,
                    onValueChange = {valor = it},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    placeholder = { Text(text = "Valor") }
                )


                Spacer(modifier = Modifier.height(30.dp))
                Button(onClick = {

                    dao.inserirProduto(Produto(id, descricao, valor.toDouble()))


                }) {
                    Text(text = "Cadastrar")
                }

            }

        }
    }


}