package com.vipulasri.jetinstagram.ui.favorite

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vipulasri.jetinstagram.data.StoriesRepository
import com.vipulasri.jetinstagram.model.Story
import com.vipulasri.jetinstagram.ui.home.StoryImage

@Composable
fun Favorite() {
    Scaffold(modifier = Modifier,
        topBar = { FavHeader()}
    ) { val stories by StoriesRepository.observeStories()
        Column {
            FavText()
            SearchBar()
            StoriesSection(stories)
        }
    }

}

@Composable
private fun FavHeader() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Icon(
            Icons.Default.Close,
            contentDescription = "Close icon",
            modifier = Modifier.align(alignment = Alignment.TopStart)
        )
        Text(
            text = "Favorites",
            modifier = Modifier.align(alignment = Alignment.Center)
        )
        Icon(
            Icons.Default.Add,
            contentDescription = "Add icon",
            modifier = Modifier.align(alignment = Alignment.TopEnd)
        )
    }


}

@Composable
private fun FavText(modifier: Modifier = Modifier.width(350.dp)
    .padding(start = 12.dp)
) {

    Row(
        modifier = Modifier,
    ) {
        Box(modifier = Modifier.weight(1f)) {
            Text(
                text = "New posts from your favorites will appear higher in feed. Only you can see who you add or remove. How it works",
                modifier.align(alignment = Alignment.Center)
            )
        }
    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier.width(380.dp)
        .padding(start = 12.dp)
) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
        placeholder = {
            Text("Search")
        },
        modifier = modifier
            .heightIn(min = 56.dp)
            .padding(start = 12.dp)
    )
    Spacer(modifier = Modifier.height(30.dp))
}

@Composable
private fun StoriesSection(stories: List<Story>) {
    Row(modifier = Modifier) {
        StoriesList(stories)
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
private fun StoriesList(stories: List<Story>) {
    LazyColumn(modifier = Modifier
    ) {
        itemsIndexed(stories) { index, story ->
            if (index == 0) {
                Spacer(modifier = Modifier.width(6.dp))
            }

            Row (modifier = Modifier.fillMaxWidth()
            ){
                Column(modifier = Modifier.weight(.65f)
                ) {
                    StoryImage(imageUrl = story.image)
                }
                Column(modifier = Modifier.weight(1.75f)){
                    Text(story.username, style = MaterialTheme.typography.h6)
                    Text(story.name, style = MaterialTheme.typography.caption)
                }
                Column(modifier = Modifier.weight(1f)){
                    Button(onClick = {},
                        modifier = Modifier.size(100.dp, 35.dp)) {
                        Text(text = "Add")
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

