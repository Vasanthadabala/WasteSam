package com.example.wastesamaritanassignment.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.example.wastesamaritanassignment.screens.ItemDetailsScreen
import com.example.wastesamaritanassignment.screens.ItemsListScreen

@ExperimentalCoilApi
@ExperimentalComposeUiApi
@ExperimentalMaterial3Api
@Composable
fun MyNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ItemList.route)
    {
        composable(ItemList.route){
            ItemsListScreen(navController)
        }
        composable(
            "${ItemDetails.route}/{${ItemDetails.itemID}}",
            arguments = listOf(navArgument(ItemDetails.itemID) { type = NavType.IntType })
        ){
            val id = requireNotNull(it.arguments?.getInt(ItemDetails.itemID))
            ItemDetailsScreen(navController,id)
        }
    }
}