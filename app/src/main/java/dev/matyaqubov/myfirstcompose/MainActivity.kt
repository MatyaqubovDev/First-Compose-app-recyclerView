package dev.matyaqubov.myfirstcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.matyaqubov.myfirstcompose.model.Message
import dev.matyaqubov.myfirstcompose.ui.theme.MyFirstComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var list = ArrayList<Message>()
            list.add(Message("Azamat", "Salom man neshsiasuasdkgak hkvfiusg  shf shfs iag fi so gaosgf g sg asgf 8osgs isfg "))
            list.add(Message("Ogabek", "Man getdim"))
            list.add(Message("Zafar", "Qachon galasiz?"))
            list.add(Message("Azamat", "Salom"))
            list.add(Message("Ogabek", "Man getdim"))
            list.add(Message("Zafar", "Qachon galasiz?"))
            list.add(Message("Azamat", "Salom"))
            list.add(Message("Ogabek", "Man getdim"))
            list.add(Message("Zafar", "Qachon galasiz?"))
            list.add(Message("Azamat", "Salom"))
            list.add(Message("Ogabek", "Man getdim"))
            list.add(Message("Zafar", "Qachon galasiz?"))
            list.add(Message("Azamat", "Salom"))
            list.add(Message("Ogabek", "Man getdim"))
            list.add(Message("Zafar", "Qachon galasiz?"))
            list.add(Message("Azamat", "Salom"))
            list.add(Message("Ogabek", "Man getdim"))
            list.add(Message("Zafar", "Qachon galasiz?"))
            Conversation(messages = list)
        }
    }
}


@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(messages) { message ->
            ItemMessage(message = message)
        }
    }
}


//@Composable
//fun Greeting(name: String) {
//    Column() {
//        Text(text = "Hello $name!")
//        Text(text = "ddsddsds")
//    }
//}


@Composable
fun ItemMessage(message: Message) {
    var isExpanded = remember {
        mutableStateOf(false)
    }

    val surfaceColor: Color by animateColorAsState(
        if (isExpanded.value) MaterialTheme.colors.primary else MaterialTheme.colors.surface
    )
    Row(modifier = Modifier
        .padding(8.dp)
        .clickable {
            isExpanded.value = !isExpanded.value
        }.fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "",
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(20.dp))
                .border(
                    width = 1.5.dp, MaterialTheme.colors.secondaryVariant,
                    RoundedCornerShape(20.dp)
                )
        )
        Spacer(modifier = Modifier.width(13.dp))
        Column() {
            Text(
                text = message.fullName,
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.subtitle1, fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(2.dp))

            Surface(color = surfaceColor, shape = MaterialTheme.shapes.medium, elevation = 1.dp,
            modifier = Modifier.animateContentSize().padding(1.dp)) {
                Text(text = message.describtion,
                    style = MaterialTheme.typography.subtitle2,
                    maxLines = if (isExpanded.value) Int.MAX_VALUE else 1
                )
            }



        }
    }

}


@Composable
fun BorderAndBackground(){
    Column(modifier = Modifier
        .background(Color.Red)
        .fillMaxHeight(0.5f)
        .fillMaxWidth()
        .border(5.dp,Color.Magenta)
        .padding(5.dp)
        .background(Color.Green)
        .border(5.dp, Color.Cyan)
        .background(Color.Red)
        .border(5.dp,Color.Blue)
    ) {

    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyFirstComposeTheme {

    }
}