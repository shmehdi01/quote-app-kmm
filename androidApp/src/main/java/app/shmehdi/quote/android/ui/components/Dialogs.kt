package app.shmehdi.quote.android.ui.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import app.shmehdi.quote.android.ui.states.UIState

@Composable
fun ErrorDialog(state: MutableState<UIState>, title: String = "Error") {
    if (state.value is UIState.Error) {
        val error = (state.value as UIState.Error).resource.errorMessage
        AlertDialog(onDismissRequest = {
            state.value = UIState.Idle
        }, title = {
            Text(text = title)
        }, text = {
            Text(text =  error)
        }, confirmButton = {
            TextButton(onClick = {
                state.value = UIState.Idle
            }) {
                Text(text = "Got It")
            }
        })
    }
}