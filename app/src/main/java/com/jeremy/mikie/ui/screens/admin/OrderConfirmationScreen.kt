import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jeremy.mikie.model.OrderViewModel
import com.jeremy.mikie.navigation.ROUT_MPESA_STK
import com.jeremy.mikie.navigation.ROUT_SAVED_ORDER3

@Composable
fun OrderConfirmationScreen(orderViewModel: OrderViewModel, navController: NavController) {
    var name by remember { mutableStateOf("") }
    var contact by remember { mutableStateOf("") }
    var foodOrdered by remember { mutableStateOf("") } // ✅ New state for food ordered
    var location by remember { mutableStateOf("") }

    val isFormValid = name.isNotBlank() && contact.isNotBlank() && location.isNotBlank() && foodOrdered.isNotBlank()

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = contact,
            onValueChange = { contact = it },
            label = { Text("Contact") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // ✅ New input field for food ordered
        OutlinedTextField(
            value = foodOrdered,
            onValueChange = { foodOrdered = it },
            label = { Text("Food Ordered") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = location,
            onValueChange = { location = it },
            label = { Text("Location") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                orderViewModel.saveOrder(name, contact, location, foodOrdered) // you may want to include `foodOrdered`
                navController.navigate(ROUT_SAVED_ORDER3)
            },
            enabled = isFormValid,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit Order")
        }
    }
}
