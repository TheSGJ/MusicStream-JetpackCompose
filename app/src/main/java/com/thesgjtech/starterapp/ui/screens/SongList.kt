import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thesgjtech.starterapp.data.Song
import com.thesgjtech.starterapp.data.songsList
import com.thesgjtech.starterapp.ui.helper.SongHelper
import com.thesgjtech.starterapp.ui.screens.SongCard

@Composable
fun SongsList(songsList: List<Song>, onSongSelected: (song: Song) -> Unit) {
    var isSongSelected by remember { mutableStateOf(false) }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                bottom = if (isSongSelected) {
                    48.dp
                } else {
                    4.dp
                }
            )
    ) {
        items(songsList) { song ->
            SongCard(song = song) {
                isSongSelected = true
                SongHelper.stopStream()
                onSongSelected(song)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SongsListPreview() {
    SongsList(
        songsList = songsList,
        onSongSelected = {}
    )
}