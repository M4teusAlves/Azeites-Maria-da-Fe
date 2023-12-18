package br.com.am.trabalhofinal

sealed class Screen(val route:String){
    object Home: Screen("home_screen")
    object InsertCliente: Screen("insert_cliente_screen")
    object InsertProduto: Screen("insert_produto_screen")
    object ListCliente: Screen("list_cliente_screen")
    object ListProduto: Screen("list_produto_screen")
    object UpdateCliente: Screen("update_cliente_screen")
    object UpdateProduto: Screen("update_produto_screen")
}