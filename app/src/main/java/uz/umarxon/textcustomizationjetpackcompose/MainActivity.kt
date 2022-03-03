package uz.umarxon.textcustomizationjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.umarxon.textcustomizationjetpackcompose.ui.theme.TextCustomizationJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextCustomizationJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Column(modifier = Modifier.fillMaxSize()) {
                    CustomText()
                    CustomText2()
                    CustomText3()
                }
            }
        }
    }
}

@Composable
fun CustomText() {
    Text(
        text = "Text Customization",
        modifier = Modifier
            .background(MaterialTheme.colors.primary)
            .padding(20.dp)
            .fillMaxWidth(),
        color = Color.White,
        fontSize = MaterialTheme.typography.h5.fontSize,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Start
    )
}

@Composable
fun CustomText2() {
    Text(
        buildAnnotatedString {
            withStyle(style = ParagraphStyle(textAlign = TextAlign.Center)) {
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colors.primary,
                        fontSize = 50.sp,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("A")
                }
                append("B")
                append("C")
                append("D")
            }
        }, modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun CustomText3() {
    Text(
        text = "\t\tHello world!".repeat(500),
        overflow = TextOverflow.Visible,
        modifier = Modifier
            .padding(5.dp)
            .verticalScroll(
                rememberScrollState()
            )
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TextCustomizationJetpackComposeTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            CustomText()
            CustomText2()
            CustomText3()
        }
    }
}