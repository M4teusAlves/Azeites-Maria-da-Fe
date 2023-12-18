package br.com.am.trabalhofinal.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.am.trabalhofinal.Screen
import br.com.am.trabalhofinal.model.DAO
import br.com.am.trabalhofinal.model.Produto
import br.com.am.trabalhofinal.model.Transition

@Composable
fun ListProdutoScreen(
    navController: NavController,
    dao:DAO
){
    val lista = dao.mostrarProdutos()

    Surface(modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background){

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Row(
                modifier = Modifier
                    .background(Color(0, 0, 132), RectangleShape)
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Rounded.ArrowBack, contentDescription = null, tint = Color.White, modifier = Modifier.clickable {
                    navController.navigate(Screen.Home.route)
                })
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Azeites Maria da Fé", color = Color.White)
            }

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ){
                Text(fontSize = 30.sp,text = "Lista de Clientes")
                Spacer(modifier = Modifier.height(30.dp))
                if(lista.isEmpty()){
                    Text(fontSize = 15.sp,text = "Lista vazia!!!")
                }
                LazyColumn {
                    items(lista) { p -> item(p = p, dao = dao, navController = navController)}
                }

                Spacer(modifier = Modifier.height(30.dp))
                Button(onClick = {
                    navController.navigate(Screen.InsertCliente.route)
                }) {
                    Text(text = "Adcionar Cliente")
                }
            }



        }


    }
}


@Composable
fun item(p:Produto, dao:DAO, navController: NavController){
    Row(modifier = Modifier
        .height(150.dp)
        .width(300.dp)
        .border(1.dp, Color.Gray, RoundedCornerShape(5)),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically){
        Column(){
            Text(text = "ID:")
            Text(text = p.id_produto)
            Text(text = "Descrição:")
            Text(text = p.descricao)

        }
        Spacer(modifier = Modifier.width(30.dp))
        Column(){
            Row {
                Icon(Icons.Rounded.Delete, contentDescription = null, modifier = Modifier.clickable {
                    dao.excluirProduto(p)
                    navController.navigate(Screen.ListProduto.route)
                })
                Spacer(modifier = Modifier.width(30.dp))
                Icon(Icons.Rounded.Edit, contentDescription = null, modifier = Modifier.clickable {
                    Transition.contexto = "Atualizar"
                    Transition.produto = p

                    navController.navigate(Screen.UpdateProduto.route)
                })
            }

            Spacer(modifier = Modifier.height(7.dp))
            Text(text = "Valor:")
            Text(text = "R$ "+p.valor.toString())

        }
    }
    Spacer(modifier = Modifier.height(20.dp))
}