package com.example.mediunalbum

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import mediunalbum.composeapp.generated.resources.Res
import mediunalbum.composeapp.generated.resources.album_cover
import mediunalbum.composeapp.generated.resources.album_thumb_1
import mediunalbum.composeapp.generated.resources.album_thumb_10
import mediunalbum.composeapp.generated.resources.album_thumb_11
import mediunalbum.composeapp.generated.resources.album_thumb_12
import mediunalbum.composeapp.generated.resources.album_thumb_2
import mediunalbum.composeapp.generated.resources.album_thumb_3
import mediunalbum.composeapp.generated.resources.album_thumb_4
import mediunalbum.composeapp.generated.resources.album_thumb_5
import mediunalbum.composeapp.generated.resources.album_thumb_6
import mediunalbum.composeapp.generated.resources.album_thumb_7
import mediunalbum.composeapp.generated.resources.album_thumb_8
import mediunalbum.composeapp.generated.resources.album_thumb_9
import mediunalbum.composeapp.generated.resources.ic_arrow_left
import mediunalbum.composeapp.generated.resources.ic_share
import mediunalbum.composeapp.generated.resources.ic_bookmark
import mediunalbum.composeapp.generated.resources.ic_videocam

@Composable
@Preview
fun App() {
    MaterialTheme {
        val white = Color(0xFFFFFFFF)
        val textPrimary = Color(0xFF161722)
        val textSecondary = Color(0xFF86878B)
        val borderColor = Color(0xFFE3E3E4)
        val accent = Color(0xFFEA4359)

        val thumbs: List<DrawableResource> = listOf(
            Res.drawable.album_thumb_1,
            Res.drawable.album_thumb_2,
            Res.drawable.album_thumb_3,
            Res.drawable.album_thumb_4,
            Res.drawable.album_thumb_5,
            Res.drawable.album_thumb_6,
            Res.drawable.album_thumb_7,
            Res.drawable.album_thumb_8,
            Res.drawable.album_thumb_9,
            Res.drawable.album_thumb_10,
            Res.drawable.album_thumb_11,
            Res.drawable.album_thumb_12,
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(white)
                .padding(horizontal = 18.dp)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                // Top action row
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp, bottom = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(Res.drawable.ic_arrow_left),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                    Image(
                        painter = painterResource(Res.drawable.ic_share),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }
                TopSection(
                    title = "The Round",
                    artist = "Roddy Roundicch",
                    videos = "1.7M videos",
                    coverSize = 120.dp,
                    textPrimary = textPrimary,
                    textSecondary = textSecondary,
                    borderColor = borderColor
                )

                // Space for visual separation before grid
                Spacer(modifier = Modifier.height(8.dp))

                // Thumbnails grid - 3 columns, no spacing, cropped
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    verticalArrangement = Arrangement.spacedBy(0.dp),
                    horizontalArrangement = Arrangement.spacedBy(0.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    items(thumbs) { res ->
                        Image(
                            painter = painterResource(res),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(137f / 182f)
                        )
                    }
                }

                // Reserve space for the floating action button at bottom
                Spacer(modifier = Modifier.height(72.dp))
            }

            // Bottom primary button
            BottomPrimaryButton(
                text = "Use this sound",
                background = accent,
                textColor = white,
                cornerRadius = 26.dp,
                height = 52.dp,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 16.dp)
                ,
                leadingIcon = Res.drawable.ic_videocam
            )
        }
    }
}

@Composable
private fun TopSection(
    title: String,
    artist: String,
    videos: String,
    coverSize: Dp,
    textPrimary: Color,
    textSecondary: Color,
    borderColor: Color,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(Res.drawable.album_cover),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(coverSize)
                .clip(androidx.compose.foundation.shape.RoundedCornerShape(4.dp))
        )

        Spacer(modifier = Modifier.size(14.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                color = textPrimary,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = artist,
                color = textSecondary,
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = videos,
                color = textSecondary,
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Outlined button look
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(28.dp)
                    .clip(androidx.compose.foundation.shape.RoundedCornerShape(2.dp))
                    .background(Color.Transparent)
                    .border(1.dp, borderColor, androidx.compose.foundation.shape.RoundedCornerShape(2.dp)),
                contentAlignment = Alignment.Center
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(Res.drawable.ic_bookmark),
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        text = "Add to Favorites",
                        color = textPrimary,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                    )
                }
            }
        }
    }
}

@Composable
private fun BottomPrimaryButton(
    text: String,
    background: Color,
    textColor: Color,
    cornerRadius: Dp,
    height: Dp,
    modifier: Modifier = Modifier,
    leadingIcon: DrawableResource? = null,
) {
    Box(
        modifier = modifier
            .clip(androidx.compose.foundation.shape.RoundedCornerShape(cornerRadius))
            .background(background)
            .height(height)
            .padding(horizontal = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (leadingIcon != null) {
                Image(
                    painter = painterResource(leadingIcon),
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.size(8.dp))
            }
            Text(
                text = text,
                color = textColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}