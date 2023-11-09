package com.example.composeviewpager.model

import com.example.composeviewpager.R

data class MemeModel(
    val meme : String,
    val drawableId : Int,
)

 val memeList = listOf(
    MemeModel(
        meme = "Programmer is a person who fixed a problem that you don't know you have, in a way you don't understand",
        drawableId = R.drawable.meme1,
    ),

     MemeModel(
         meme = "Hardware is a part of a computer that you can kick",
         drawableId = R.drawable.meme2,
     ),

     MemeModel(
         meme = "I had like to make the world a better place...but they won't give me the source code.",
         drawableId = R.drawable.meme3,
     ),
)
