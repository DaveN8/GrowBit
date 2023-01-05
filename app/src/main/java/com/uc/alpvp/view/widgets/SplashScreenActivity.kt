package com.uc.alpvp.view.widgets

import android.app.ActionBar
import android.app.Activity
import android.content.Intent
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil.decode.ImageSource
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.google.android.material.snackbar.Snackbar
import com.uc.alpvp.ui.theme.AlpvpTheme
import com.uc.alpvp.ui.theme.Ijoroyoroyo
import com.uc.alpvp.view.LoginPage
import com.uc.alpvp.view.homepage
import kotlinx.coroutines.delay

class SplashScreenActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()
        setContent {
            AlpvpTheme {
                Surface {
                    AnimatedSplashScreen()
                }
            }
        }
    }
}

@Composable
fun AnimatedSplashScreen(){
    var startAnimation by remember {
        mutableStateOf(false)
    }

    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        )
    )

    val mContext = LocalContext.current as? Activity

    LaunchedEffect(key1 = true){
        startAnimation = true
        delay(4000)

        val intent = Intent(mContext, LoginPage::class.java)
        mContext?.startActivity(intent)
        mContext?.finish()
    }

    Splash(alphaAnim.value)

}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun Splash(alpha: Float){
    Box(modifier = Modifier
        .background(Color.White)
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        GlideImage(
            model = "https://drive.google.com/file/d/1fhKPWvBbpiA6e3HsrHRg9YiAoJiH_e9k/view?usp=sharing",
            contentDescription = null,
            modifier = Modifier
                .alpha(alpha = alpha)
                .size(100.dp)
        )
    }
}