package br.com.wmwallet.android.home

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wmwallet.android.MyApplicationTheme
import br.com.wmwallet.android.componet.CenterTopBar
import br.com.wmwallet.android.componet.ListTransactions
import br.com.wmwallet.android.componet.TopBar
import br.com.wmwallet.android.componet.WMCardGroup
import br.com.wmwallet.model.TransactionType
import br.com.wmwallet.network.loadTransaction
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun HomeScreen(onBack: () -> Unit) {
    MyApplicationTheme() {
        Scaffold(topBar = {
            CenterTopBar(onProfileNavigation = {}, title = "WMWALLET")

        }) {
            //Good practice to make sure whe using bottom bar, that our content won't affect scroll
            Column(modifier = Modifier.padding(it)) {

                WMCardGroup()
                Text(
                    text = "Transações",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp),
                    textAlign = TextAlign.Center
                )
                val items = loadTransaction()
                LazyColumn {
                    items(items.size) {
                        val painter = rememberAsyncImagePainter(
                            model =
                            ImageRequest.Builder(LocalContext.current)
                                .data(items[it].logo)

                                .placeholder(R.drawable.ic_dialog_alert)
                                .build()
                        )

                        ListTransactions(

                            image = {
                                Image(
                                    painter = painter, contentDescription = "Transaction Image",
                                    contentScale = ContentScale.Fit,
                                    modifier = Modifier
                                        .height(56.dp)
                                        .width(56.dp)
                                        .clip(CircleShape)
                                        .background(Color.Magenta)
                                        .padding(10.dp)
                                        .clip(CircleShape)
                                )
                            },
                            title = items[it].title,

                            transactionType = items[it].transactionType,
                            value =  items[it].value

                        )
                    }
                }
            }
        }

    }

}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen() {}
}