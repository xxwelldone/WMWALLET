package br.com.wmwallet.android.componet

import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun AlertaGeral(
    showDialog: Boolean,
    usuario: String,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier
) {

    if (showDialog) {
        AlertDialog(
            modifier = modifier,
            onDismissRequest = onDismissRequest,
            title = { Text(text = "Ops!") },
            text = { Text(text = "$usuario") },

            confirmButton = {
                TextButton(onClick = onDismissRequest) {
                    Text(text = "OK")



                }

            },
            contentColor = Color.White,
            backgroundColor = Color(0xFF4CAF50),

        )


    }
}
@Preview
@Composable
fun AlertGeralComponent_Preview() {
   AlertaGeral(
        showDialog = true,
        usuario = "Teste",
        onDismissRequest = { /*TODO*/ })
}