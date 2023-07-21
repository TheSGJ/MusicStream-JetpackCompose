package com.thesgjtech.starterapp.ui.screens

import MediaPlayerCard
import SongsList
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thesgjtech.starterapp.data.Song
import com.thesgjtech.starterapp.data.songsList

@Composable
fun HomeScreen(songsList: List<Song>,innerContentPadding: PaddingValues) {
    var selectedSong by remember { mutableStateOf<Song?>(null) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerContentPadding)
            .background(Color.White)
    ) {
        SongsList(songsList = songsList, onSongSelected = { song ->
            selectedSong = song
        })
        selectedSong?.let {
            MediaPlayerCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(Color.Transparent),
                it
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        songsList = songsList,
        PaddingValues(0.dp)
    )
}