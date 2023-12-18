package br.com.am.trabalhofinal

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.am.trabalhofinal.model.DAO
import br.com.am.trabalhofinal.screens.HomeScreen
import br.com.am.trabalhofinal.screens.InsertClienteScreen
import br.com.am.trabalhofinal.screens.InsertProdutoScreen
import br.com.am.trabalhofinal.screens.ListClienteScreen
import br.com.am.trabalhofinal.screens.ListProdutoScreen
import br.com.am.trabalhofinal.screens.UpdateClienteScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    dao: DAO,
){
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
    ){
        composable(
            route = Screen.Home.route
        ){
            HomeScreen(navController = navController, dao)
        }

        composable(
            route = Screen.InsertCliente.route
        ){
            InsertClienteScreen(navController = navController, dao)
        }

        composable(
            route = Screen.InsertProduto.route
        ){
            InsertProdutoScreen(navController = navController, dao = dao)
        }

        composable(
            route = Screen.ListCliente.route
        ){
            ListClienteScreen(navController = navController, dao)
        }

        composable(
            route = Screen.ListProduto.route
        ){
            ListProdutoScreen(navController = navController, dao)
        }

        composable(
            route = Screen.UpdateCliente.route
        ){
            UpdateClienteScreen(navController = navController, dao)
        }


    }
}


