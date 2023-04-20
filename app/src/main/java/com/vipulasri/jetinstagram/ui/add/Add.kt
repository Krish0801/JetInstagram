package com.vipulasri.jetinstagram.ui.add

import androidx.compose.compiler.plugins.kotlin.ComposeFqNames.remember
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vipulasri.jetinstagram.R
import com.vipulasri.jetinstagram.data.StoriesRepository
import com.vipulasri.jetinstagram.model.musics
import com.vipulasri.jetinstagram.model.places
import com.vipulasri.jetinstagram.ui.home.StoryImage


@Composable
fun Add() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    )
    {
        val stories by StoriesRepository.observeStories()
        var toggleState by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_back_ios_fill0_wght400_grad0_opsz48),
                    contentDescription = "My Drawable",
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "New post",
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Share",
                    style = MaterialTheme.typography.button,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Divider()

            Spacer(modifier = Modifier.height(16.dp))


            TextField(
                value = "",
                onValueChange = { /*TODO*/ },
//                    label = {
//                        Text(
//                            text = "Write a caption...",
//                            style = MaterialTheme.typography.caption
//                        )
//                    },
                placeholder = {
                    Text(
                        text = "Write a caption...",
                        style = MaterialTheme.typography.caption.copy(color = Color.Gray)
                    )
                },
                maxLines = 15,
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_instagram),
                        contentDescription = "Instagram logo",
                        modifier = Modifier
                            .size(90.dp)
                            .padding(15.dp)
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = Color.Black,
                    textColor = Color.Black
                )
            )




            Spacer(modifier = Modifier.height(16.dp))

            Divider()

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Tag people",
                    style = MaterialTheme.typography.h6.copy(fontSize = 16.sp),
                    color = Color.Black
                )
                Icon(
                    painter = painterResource(id = R.drawable.arrow_forward_ios_fill0_wght400_grad0_opsz48),
                    contentDescription = "My Drawable",
                    modifier = Modifier.size(16.dp)
                )

            }

            Spacer(modifier = Modifier.height(10.dp))
            Divider()

            Spacer(modifier = Modifier.height(10.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Add location",
                    style = MaterialTheme.typography.h6.copy(fontSize = 16.sp),
                    color = Color.Black
                )
                Icon(
                    painter = painterResource(id = R.drawable.arrow_forward_ios_fill0_wght400_grad0_opsz48),
                    contentDescription = "My Drawable",
                    modifier = Modifier.size(16.dp)
                )

            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Box(modifier = Modifier.fillMaxWidth()) {
                    LazyRow(
                        contentPadding = PaddingValues(horizontal = 0.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        items(places) { place ->
                            Card(
                                elevation = 5.dp,
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.padding(start = 8.dp, bottom = 8.dp)
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = place,
                                        style = MaterialTheme.typography.body1,
                                        color = Color.Black,
                                        modifier = Modifier.padding(
                                            horizontal = 12.dp,
                                            vertical = 5.dp
                                        )
                                    )
                                }
                            }
                        }
                    }
                }
            }

            Divider()

            Spacer(modifier = Modifier.height(10.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Add Music",
                    style = MaterialTheme.typography.h6.copy(fontSize = 16.sp),
                    color = Color.Black
                )
                Icon(
                    painter = painterResource(id = R.drawable.arrow_forward_ios_fill0_wght400_grad0_opsz48),
                    contentDescription = "My Drawable",
                    modifier = Modifier.size(16.dp)
                )

            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Box(modifier = Modifier.fillMaxWidth()) {
                    LazyRow(
                        contentPadding = PaddingValues(horizontal = 0.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        items(musics) { place ->
                            Card(
                                elevation = 5.dp,
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.padding(start = 8.dp, bottom = 8.dp)
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.music_solid),
                                        contentDescription = "Music",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(15.dp)
                                    )

                                    Text(
                                        text = place,
                                        style = MaterialTheme.typography.body1,
                                        color = Color.Black,
                                        modifier = Modifier.padding(start = 8.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))

            Divider()

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Add Fundraiser",
                    style = MaterialTheme.typography.h6.copy(fontSize = 16.sp),
                    color = Color.Black
                )
                Icon(
                    painter = painterResource(id = R.drawable.arrow_forward_ios_fill0_wght400_grad0_opsz48),
                    contentDescription = "My Drawable",
                    modifier = Modifier.size(16.dp)
                )

            }
            Spacer(modifier = Modifier.height(10.dp))

            Divider()

            Spacer(modifier = Modifier.height(5.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Post to other Instagram accounts",
                    style = MaterialTheme.typography.h6.copy(fontSize = 16.sp),
                    color = Color.Black
                )
            }
            Spacer(modifier = Modifier.height(5.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                StoryImage(imageUrl = stories.get(1).image)
                Text(
                    text = "namaste_maniac",
                    style = MaterialTheme.typography.h6.copy(fontSize = 16.sp),
                    color = Color.Black,
                    modifier = Modifier.weight(8f)
                )
                Switch(
                    checked = toggleState,
                    onCheckedChange = { isChecked -> toggleState = isChecked },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.White,
                        checkedTrackColor = Color.Blue
                    ),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Divider()

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Share to Facebook",
                    style = MaterialTheme.typography.h6.copy(fontSize = 16.sp),
                    color = Color.Black,
                    modifier = Modifier.weight(8f)
                )
                Switch(
                    checked = toggleState,
                    onCheckedChange = { isChecked -> toggleState = isChecked },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.White,
                        checkedTrackColor = Color.Blue
                    ),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }

            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Sharing as Krish Praveen.Audience is Friends.",
                    style = MaterialTheme.typography.h6.copy(fontSize = 12.sp),
                    color = Color.Black.copy(alpha = 0.5f)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Divider()

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Add Fundraiser",
                    style = MaterialTheme.typography.h6.copy(fontSize = 16.sp),
                    color = Color.Black
                )
                Icon(
                    painter = painterResource(id = R.drawable.arrow_forward_ios_fill0_wght400_grad0_opsz48),
                    contentDescription = "My Drawable",
                    modifier = Modifier.size(16.dp)
                )

            }


        }

    }
}

