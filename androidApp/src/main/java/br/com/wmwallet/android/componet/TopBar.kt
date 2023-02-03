package br.com.wmwallet.android.componet

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview

import br.com.wmwallet.android.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenterTopBar(title: String, onProfileNavigation: () -> Unit = {}) {
    CenterAlignedTopAppBar(

        title = { Text(title) },
        actions = {
            IconButton(onClick = onProfileNavigation) {
                Image(
                    painter = painterResource(id = R.drawable.eu),
                    contentDescription = "profile picture"
                )
            }
        }
    )
}


@Composable
fun TopBar(title: String = "", onBack: () -> Unit, onProfileNavigation: () -> Unit) {
    TopAppBar(
        backgroundColor = Color.Transparent,


        title = { Text(text = title, color = Color.White) },


        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(
                    Icons.Filled.ArrowBack, "Back",
                    tint = Color.White
                )
            }

        },


        actions = {
            IconButton(onClick = onProfileNavigation) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "profile picture",

                    )
            }
        },


        )
}

@Composable
@Preview
fun CenterTopBar_Preview() {
    CenterTopBar(title = "WMWALLET", onProfileNavigation = {})
}


@Composable
@Preview
fun TopBar_Preview() {
    TopBar(title = "WMWALLET", onBack = {}) {}
}

