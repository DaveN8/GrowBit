package com.uc.alpvp.view.widgets

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.uc.alpvp.model.Data
import com.uc.alpvp.model.Products
import com.uc.alpvp.ui.theme.Ijoroyoroyo


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ProductsCard(products: Data){
    val mContext = LocalContext.current as? Activity

    Surface(
        modifier = Modifier
            .padding(vertical = 5.dp)
            .width(380.dp),
        shape = RoundedCornerShape(13.dp), color = Ijoroyoroyo,
//        onClick = {
//            val intent = Intent(mContext, )
//        }
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 10.dp)
        ) {

            GlideImage(
                model = "https://via.placeholder.com/200x300.jpg",
                contentDescription = null
            )
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Text(
                    text = products.name,
                    modifier = Modifier
                        .padding(5.dp)
                )
                Text(
                    text = "Harga" + products.price,
                    modifier = Modifier
                        .padding(5.dp)
                )
            }
        }
    }

}