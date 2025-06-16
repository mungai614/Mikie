import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jeremy.mikie.model.OrderViewModel

@Composable
fun SavedOrdersScreen3(orderViewModel: OrderViewModel, navController: NavController) {
    val orders by orderViewModel.orders.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        if (orders.isEmpty()) {
            Text("No saved orders.", fontSize = 18.sp)
        } else {
            orders.forEach { order ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Name: ${order.name}", fontSize = 16.sp)
                        Text("Contact: ${order.contact}", fontSize = 16.sp)
                        Text("Location: ${order.location}", fontSize = 16.sp)
                    }
                }
            }
        }
    }
}
