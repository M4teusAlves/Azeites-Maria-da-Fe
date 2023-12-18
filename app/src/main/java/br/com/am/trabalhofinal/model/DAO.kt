package br.com.am.trabalhofinal.model

import android.util.Log
import br.com.am.trabalhofinal.model.Transition.Companion.listac
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.gson.Gson

class DAO(val database: FirebaseDatabase) {


    fun inserirCliente(cliente: Cliente){

        val minhaReferencia = database.getReference("Cliente")

        minhaReferencia.child(cliente.toString()).setValue(cliente)
    }

    fun mostrarClientes(){

        val minhaReferencia = database.getReference("Cliente")


        minhaReferencia.addValueEventListener(object : ValueEventListener
        {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists())
                {
                    var gson = Gson()
                    for (i in snapshot.children)
                    {
                        val json = gson.toJson(i.value)
                        val cliente = gson.fromJson(json, Cliente::class.java)

                        Log.i("Teste", cliente.nome)

                        listac.add(Cliente(cliente.cpf, cliente.nome, cliente.telefone, cliente.endereco))
                    }


                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.i("Teste", "Erro: $error")
            }
        })


    }

    fun excluirCliente(cliente: Cliente){
        val minhaReferencia = database.getReference("Cliente")
        minhaReferencia.child(cliente.cpf).removeValue()
    }

    fun atualizarCliente(cliente: Cliente){
        val minhaReferencia = database.getReference("Cliente")
        minhaReferencia.child(cliente.cpf.toString()).setValue(cliente)
    }


    fun inserirProduto(produto: Produto){

        val minhaReferencia = database.getReference("Produto")

        minhaReferencia.child(produto.toString()).setValue(produto)
    }

    fun mostrarProdutos(): ArrayList<Produto> {

        val minhaReferencia = database.getReference("Produto")

        val lista = ArrayList<Produto>()
        minhaReferencia.addValueEventListener(object : ValueEventListener
        {
            override fun onDataChange(snapshot: DataSnapshot)
            {
                if (snapshot.exists())
                {
                    var gson = Gson()
                    for (i in snapshot.children)
                    {
                        val json = gson.toJson(i.value)
                        val produto = gson.fromJson(json, Produto::class.java)

                        lista.add(Produto(produto.id_produto, produto.descricao, produto.valor))
                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {
                Log.i("Teste", "Erro: $error")
            }
        })

        return lista

    }

    fun excluirProduto(produto: Produto){
        val minhaReferencia = database.getReference("Produto")
        minhaReferencia.child(produto.id_produto).removeValue()
    }

    fun atualizarClieent(produto: Produto){
        val minhaReferencia = database.getReference("Produto")
        minhaReferencia.child(produto.id_produto.toString()).setValue(produto)
    }



    /*
    * fun mostrarBolos(minhaReferencia : DatabaseReference) = runBlocking { // this: CoroutineScope
    launch { // launch a new coroutine and continue
        //delay(5000L)
        val listaBolos = ArrayList<Bolo>()
        minhaReferencia.addValueEventListener(object : ValueEventListener
        {
            override fun onDataChange(snapshot: DataSnapshot)
            {
                if (snapshot.exists())
                {
                    var gson = Gson()
                    for (i in snapshot.children)
                    {
                        val json = gson.toJson(i.value)
                        val cake = gson.fromJson(json, Bolo::class.java)
                        Log.i("Teste", "-------------------")
                        Log.i("Teste", "Id: ${cake.id}")
                        Log.i("Teste", "Nome: ${cake.nome}")
                        Log.i("Teste", "Cobertura: ${cake.cobertura}")
                        Log.i("Teste", "Preço: ${cake.preco}")
                        Log.i("Teste", "-------------------")
                        listaBolos.add(Bolo(cake.id,cake.nome,cake.cobertura,cake.preco))
                    }
                    Log.i("Teste", "Array: ${listaBolos}")
                }
            }
            override fun onCancelled(error: DatabaseError) {
                Log.i("Teste", "Erro: $error")
            }
        })
    }
    Log.i("Teste", "Olá thread!")
}




    * */
}