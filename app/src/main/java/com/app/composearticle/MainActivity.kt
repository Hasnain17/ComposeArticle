package com.app.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Scaffold (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(WindowInsets.systemBars.asPaddingValues()),
                    ){
                    ComposeArticle()
                }
            }
        }
    }
}


@Composable
fun ComposeArticle(){
    ArticleComposeCard(
        title = stringResource(R.string.heading),
        subTitle = stringResource(R.string.subHeading),
        body = stringResource(R.string.body),
        imagePainter = painterResource(R.drawable.bg_compose_background)
    )
}

@Composable
fun ArticleComposeCard(title: String, subTitle: String,body: String, imagePainter: Painter, modifier: Modifier = Modifier){

        Column(modifier = modifier){
            Image(
                painter = imagePainter,
                contentDescription = null)
            Text(
                text = title,
                fontSize=24.sp,
                modifier = Modifier.padding(16.dp)
            )

            Text(
                text = subTitle,
                textAlign = TextAlign.Justify
                ,modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )

            Text(
                text = body,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(16.dp)
            )
        }
}




@Preview(showBackground = true)
@Composable
fun ArticlePreview(){
    ComposeArticleTheme {
        ComposeArticle()
    }
}


