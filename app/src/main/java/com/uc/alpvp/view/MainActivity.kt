//package com.uc.alpvp.view
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.itemsIndexed
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Add
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.lifecycle.ViewModelProvider
//import com.uc.alpvp.model.Data
//import com.uc.alpvp.ui.theme.AlpvpTheme
//import com.uc.alpvp.view.widgets.ProductsCard
//import com.uc.alpvp.viewModel.ProductsViewModel
//import dagger.hilt.android.AndroidEntryPoint
//
//@AndroidEntryPoint
//class MainActivity : ComponentActivity() {
//
//    private lateinit var pdtViewModel: ProductsViewModel
//
//    @OptIn(ExperimentalMaterial3Api::class)
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        val home = intent.getIntExtra("home", 1)
//
//        pdtViewModel = ViewModelProvider(this).get(ProductsViewModel::class.java)
//
//        if (home == 1){
//            pdtViewModel.getProducts()
//            pdtViewModel.products.observe(this) { response ->
//                setContent {
//                    Scaffold(
//                        floatingActionButton = {
//                            FloatingActionButton(onClick = { /*.*/ }) {
//                                Icon(Icons.Filled.Add, null)
//                            }
//                        },
//                        floatingActionButtonPosition = FabPosition.End
//                    ) {
//
//                    }
//                    AlpvpTheme {
//                        // A surface container using the 'background' color from the theme
//                        Surface(
//                            modifier = Modifier.fillMaxSize(),
//                            color = MaterialTheme.colorScheme.background
//                        ) {
//                            Column {
//                                ProductList(pdt = response)
//                            }
//                        }
//                    }
//                }
//            }
//
//        }else{
//            pdtViewModel.getProducts()
//            pdtViewModel.products.observe(this) { response ->
//                setContent {
//                    Scaffold(
//                        floatingActionButton = {
//                            FloatingActionButton(onClick = { /*.*/ }) {
//                                Icon(Icons.Filled.Add, null)
//                            }
//                        },
//                        floatingActionButtonPosition = FabPosition.End
//                    ) {
//
//                    }
//                    AlpvpTheme {
//                        // A surface container using the 'background' color from the theme
//                        Surface(
//                            modifier = Modifier.fillMaxSize(),
//                            color = MaterialTheme.colorScheme.background
//                        ) {
//                            Column {
//                                ProductList(pdt = response)
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//    }
//}
//
////@Composable
////fun Greeting(name: String) {
////    Text(text = "Hello $name!")
////}
////
////@Preview(showBackground = true)
////@Composable
////fun DefaultPreview() {
////    AlpvpTheme {
////        Greeting("Android")
////    }
////}
//
//@Composable
//fun ProductList(pdt: ArrayList<Data>){
//    LazyColumn(
//        modifier = Modifier.fillMaxWidth(),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ){
//        itemsIndexed(items = pdt){
//            index, item -> ProductsCard(products = item)
//        }
//    }
//}
//
////@Composable
////fun btnFilter(){
////    Column {
////        Filter()
////    }
////}