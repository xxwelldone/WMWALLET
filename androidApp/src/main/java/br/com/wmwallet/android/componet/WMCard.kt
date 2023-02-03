package br.com.wmwallet.android.componet

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.graphicsLayer



import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import br.com.wmwallet.android.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import kotlin.math.absoluteValue

@OptIn(ExperimentalPagerApi::class)
@Composable
fun WMCardGroup() {
    HorizontalPager(count = 3, contentPadding= PaddingValues(40.dp),
    modifier = Modifier.height(250.dp)) { page ->
        val pageOffSet = calculateCurrentOffsetForPage(page).absoluteValue
        Card(
            contentColor = Color.White,
            modifier = Modifier
//                .padding(10.dp)
                .graphicsLayer {
                    lerp(start = 0.90f, stop = 1f, fraction = 1f - pageOffSet.coerceIn(0f, 1f))
                        .also{ scale ->
                            scaleX = scale
                            scaleY = scale
                        }
                },
            shape = RoundedCornerShape(10.dp)
        ) {
            WMCardContent()
        }

    }

}

@Preview
@Composable
fun WMCardGroup_Preview() {
    WMCardGroup()
}

@Composable
fun WMCardContent() {
    val shadow = Shadow(Color.Black, offset = Offset(2f, 2f), blurRadius = 1f)
    Column(
        modifier = Modifier
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color(0xFF4A27F4),
                        Color(0xFF454BB2)
                    )
                )
            )
            .height(202.dp)
            .padding(30.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column() {
                Text(text = "Limite", color = Color.White, fontSize = 11.sp)
                Text(text = "R$18,24", color = Color.White, fontSize = 20.sp, style = TextStyle(shadow = shadow))

            }
            Spacer(modifier = Modifier.weight(1f))

            Image(
                painter = painterResource(id = R.drawable.visa),
                contentDescription = "Visa Card"
            )


        }
        Spacer(modifier = Modifier.weight(1f))

        Row {
            MutableList(3) {
                Text(text = "****", color = Color.White, fontSize = 20.sp, style = TextStyle(shadow = shadow))
                Spacer(modifier = Modifier.weight(1f))
            }

            Text(text = "6969", color = Color.White, fontSize = 20.sp, style = TextStyle(shadow = shadow))

        }
        Spacer(modifier = Modifier.weight(1f))

        Row {
            Column() {
                Text(text = "NOME:", color = Color.White, fontSize = 11.sp)
                Text(text = "Brenda Milk", color = Color.White, fontSize = 20.sp, style = TextStyle(shadow = shadow))
            }
            Spacer(modifier = Modifier.weight(1f))
            Column() {
                Text(text = "Validade:", color = Color.White, fontSize = 11.sp)
                Text(text = "11/24", color = Color.White, fontSize = 20.sp, style = TextStyle(shadow = shadow))
            }


        }


    }
}

@Preview
@Composable

fun WMCard_Preview() {
    WMCardContent()
}