package com.example.composeviewpager

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeviewpager.model.MemeModel


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MemePager(
    memes : List<MemeModel>,
    pagerState: PagerState
) {


    HorizontalPager(
        pageCount = 3,
        state = pagerState,
    ) {
            count ->
        PagerContent(
            meme = memes[count].meme,
            drawableId = memes[count].drawableId,
        )
    }
}

@Composable
fun PagerContent(
    meme: String,
    drawableId: Int,
) {
    Box (
        modifier = Modifier
            .height(600.dp)
            .fillMaxWidth()
    ){
        Column (
            modifier = Modifier.fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ){
            Image(
                modifier = Modifier
                    .height(300.dp)
                    .width(300.dp),
                painter = painterResource(
                    id = drawableId,
                ),
                contentDescription = "memeOne",
            )
            Text(text = meme)
        }
    }
}