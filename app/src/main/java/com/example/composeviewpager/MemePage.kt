package com.example.composeviewpager

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composeviewpager.model.memeList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
private fun onNextPress(pagerState : PagerState, context: Context, coroutineScope : CoroutineScope){
    if (pagerState.currentPage == 2) {
        Toast.makeText(context, "Aaj ke liye itna kafhi hey!!", Toast.LENGTH_LONG)
            .show()
    } else {
        coroutineScope.launch {
            pagerState.animateScrollToPage(
                pagerState.currentPage + 1
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
private fun onPrevPress(pagerState : PagerState, context: Context, coroutineScope : CoroutineScope){
    if (pagerState.currentPage == 0) {
        Toast.makeText(context, "Abey aghe bhi dekh le", Toast.LENGTH_LONG)
            .show()
    } else {
        coroutineScope.launch {
            pagerState.animateScrollToPage(
                pagerState.currentPage - 1
            )
        }
    }
}





@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MemePage(context : Context) {
    val pagerState = rememberPagerState(
        initialPage = 0
    )

    Column {
        MemePager(
            memes = memeList,
            pagerState = pagerState,
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            val coroutineScope = rememberCoroutineScope()
            ElevatedButton(
                onClick = {
                    onPrevPress(
                        pagerState = pagerState,
                        context = context,
                        coroutineScope = coroutineScope,
                    )
                },
            ) {
                Text(text = "Pichu",)
            }


            ElevatedButton(
                onClick = {
                    onNextPress(
                        pagerState = pagerState,
                        context = context,
                        coroutineScope = coroutineScope,
                    )
                }
            )
            {
                Text(text = "Aghe",)
            }
        }

        Row(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(3) { time ->
                val color =
                    if (pagerState.currentPage == time) MaterialTheme.colorScheme.primary else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(16.dp)
                )
            }
        }
    }
}