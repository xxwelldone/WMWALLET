package br.com.wmwallet.android.componet


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wmwallet.android.R
import br.com.wmwallet.model.Transaction
import br.com.wmwallet.model.TransactionType
import br.com.wmwallet.network.loadTransaction
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

@Composable
fun ListTransactions(
    image: @Composable () -> Unit,
    title: String,

    transactionType: TransactionType,
    value: Double,

    ) {
    Card(modifier = Modifier.padding(bottom = 0.5.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {


            image()

            Spacer(modifier = Modifier.width(20.dp))
            Column {
                Text(text = title, fontWeight = FontWeight.Bold, fontSize = 17.sp)
                Text(text = transactionType.description,fontWeight = FontWeight.SemiBold, fontSize = 13.sp )

            }
            Spacer(modifier = Modifier.weight(1f))

            val symbol = if (transactionType.description == "Entrada"){"+"} else {"-"}


            Text(text = "$symbol $value", color = (if (symbol == "+"){Color.Green} else{ Color.Red}),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp)

        }
    }

}


@Preview
@Composable
fun ListTransactions_Preview() {

    val painter = rememberAsyncImagePainter(
        model =
        ImageRequest.Builder(LocalContext.current)
            .data("https://st.depositphotos.com/37050820/58882/v/450/depositphotos_588825948-stock-illustration-spotify-vector-logo-vector-illustration.jpg")

            .placeholder(android.R.drawable.ic_dialog_alert)
            .build()
    )

    ListTransactions(

        image = {
            Image(
                painter = painter, contentDescription = "Transaction Iamge",
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
        title = "Spotify",

        transactionType = TransactionType.CREDIT,
        value = 17.0


    )

}
