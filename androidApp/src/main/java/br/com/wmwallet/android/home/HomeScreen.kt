package br.com.wmwallet.android.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import br.com.wmwallet.android.MyApplicationTheme
import br.com.wmwallet.android.componet.CenterTopBar
import br.com.wmwallet.android.componet.TopBar
import br.com.wmwallet.android.componet.WMCardGroup

@Composable
fun HomeScreen(onBack: () -> Unit) {
    MyApplicationTheme() {
        Scaffold(topBar = {
            CenterTopBar(onProfileNavigation = {}, title = "WMWALLET")

        }) {
            //Good practice to make sure whe using bottom bar, that our content won't affect scroll
            Column(modifier = Modifier.padding(it)) {

                WMCardGroup()
                Text(text = "Transações")
            }
        }

    }

}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen() {}
}