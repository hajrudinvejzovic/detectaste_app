package com.example.detectasteproject

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.detectasteproject.ui.theme.DetectasteProjectTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DetectasteProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
               //  WelcomeScreenTest()
                 // SignUpScreenTest()
                 //   LoginScreenTest()
               //  RocketDockTest()
                //  MainScreenTest()
                  // TopFrameNameWithIconTest()
                 //   AllRecipesScreen()
                }
            }
        }
    }
}
//           Frontend nije baš responsive i emulator koji je koristen je Pixel 5 API 30 tako da ne mora bas biti responsive <<--

//-->> Sve funkcije sa nazivom test su funkcije bez parametara koje pozivaju istoimene funkcije sa prosljeđenimi parametrima <<--
data class Message(val welcome: String, val discover: String)
//                         -->> Funkcija za pozivanje Welcome (početnog) screena sa proslijeđenim parametrima <<--
@Composable
fun WelcomeScreenTest() {
    WelcomeTextWithImage(
        buttonOne = R.string.ButtonOne,
        buttonTwo = R.string.ButtonTwo,
        welcomeText = R.string.Welcome,
        discoverText = R.string.Discover ,
        toOurAppText =  R.string.ToOur,
        imagePizza = R.drawable.app_background,
        imagePizzaDesc = "PIZZA",

        )
}
//                       -->> Sve funkcije sa nazivom test su funkcije bez parametara koje pozivaju istoimene funkcije sa prosljeđenimi parametrima <<--
@Composable
fun LoginScreenTest(){
    LoginScreen(imagePizza =  R.drawable.app_background, imagePizzaDesc = "PIZZA", loginTextScreen =  R.string.Login )
}

//              -->> Funkcija za pozivanje login screena sa proslijeđenim parametrima <<--
@Composable
fun SignUpScreenTest( ){
    SignUpScreen(imagePizza = R.drawable.app_background,
        imagePizzaDesc = "PIZZA",
        loginTextScreen = R.string.Login,
    )

}
@Composable
fun MainScreenTest(){
    MainScreen(R.drawable.user_line, Username = R.string.username)
}
//                         -->>> IMPLEMENTACIJA WELCOME (PRVOG) SCREENA <<<--
@Composable
fun WelcomeTextWithImage(
    buttonOne: Int,
    buttonTwo: Int,
    welcomeText : Int,
    discoverText: Int,
    toOurAppText: Int,
    imagePizza: Int,
    imagePizzaDesc: String,

    ) {
    val image = painterResource(id = imagePizza)
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = image, contentDescription = imagePizzaDesc,
            modifier = Modifier
                .fillMaxSize()
                .scale(1.5f)
        )
        Column(

        ) {
            Spacer(modifier = Modifier.height(300.dp))
            WelcomeScreenTexts(welcomeText, discoverText, toOurAppText )
            Spacer(modifier = Modifier.height(30.dp))
                FirstYellowButton(buttonOne)
                Spacer(modifier = Modifier.height(30.dp))
                SecondBlackButton(buttonTwo)

        }
    }
    }
//                   -->>> IMPLEMENTACIJA LOGIN SCREENA <<<--
@Composable
fun SignUpScreen(imagePizza: Int,
                imagePizzaDesc: String,
                loginTextScreen: Int,
              //  shadow: Int,
                //shadowDesc: String
){
    val image = painterResource(id = imagePizza)
 //   val shadowImage = painterResource(id = shadow )
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = image, contentDescription = imagePizzaDesc,
            modifier = Modifier
                .fillMaxSize()
                .scale(1.5f)
        )
        LoginTexts(R.string.SignUp)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(Modifier.height(200.dp))
                TextFields(thislabel = R.string.emailAddress
                )
            Spacer(Modifier.height(40.dp))
                TextFields(thislabel = R.string.username,

                )
            Spacer(Modifier.height(40.dp))
                PassField(thislabel = R.string.Password,

                )
            Spacer(Modifier.height(60.dp))
            FirstYellowButton(buttonOne = R.string.SignUp)
            Spacer(Modifier.height(10.dp))
            BackupButton(sentence = R.string.DontHaveAcc)
            }
        }
    }
 //                           -->> Login Screen... <<--
@Composable
fun LoginScreen(imagePizza: Int,
                imagePizzaDesc: String,
                loginTextScreen: Int,
){
    val image = painterResource(id = imagePizza)
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = image, contentDescription = imagePizzaDesc,
            modifier = Modifier
                .fillMaxSize()
                .scale(1.5f)
        )
        LoginTexts(R.string.Login)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(Modifier.height(200.dp))
            TextFields(thislabel = R.string.emailAddress
            )
            Spacer(Modifier.height(40.dp))
            PassField(thislabel = R.string.Password,
                )
            Spacer(Modifier.height(60.dp))
            FirstYellowButton(buttonOne = R.string.SignUp)
            Spacer(Modifier.height(27.dp))
            BackupButton(sentence = R.string.DontHaveAcc)
        }
    }
}
//                -->> What would you like to cook, prvi screen nakon logina/signupa  <<--
@Composable
fun MainScreen(plusIconn:Int, Username:Int) {
    val plusIcon = painterResource(id = plusIconn)
    val hexColour = "#FFBF00"
    val nameOfUser = stringResource(id = Username)
    Column() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(170.dp)
                .background(color = Color.White)
        ) {
            Row() {
                Column() {
                    Text(text = "Welcome $nameOfUser", modifier = Modifier.padding(top = 10.dp, start = 20.dp)  )
                    Text(
                        text = stringResource(id = R.string.MainScreenText1), fontSize = 24.sp,
                        modifier = Modifier.padding(start = 20.dp, top = 3.dp)
                    )
                    Text(
                        text = stringResource(id = R.string.MainScreenText2), fontSize = 24.sp,
                        modifier = Modifier.padding(start = 20.dp, top = 0.dp)
                    )
                    Spacer(modifier = Modifier
                        .height(5.dp)
                        .width(45.dp))
            /*        Surface(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(start = 45.dp,top = 0.dp, bottom = 0.dp).height(55.dp),
                        shape = RoundedCornerShape(20.dp),
                        color = Color.Red
                    ) {*/
                        Box(modifier = Modifier.fillMaxWidth()) {
                            SearchBar(
                                thislabel = R.string.SearchAnyRecipes,
                            )
                        }
                  //  }
                }
            }
        }
    }


                
            
        
        RocketDockTest()

    }
@Composable
fun AllRecipesScreen(){
    Column {
        TopFrameworkDescWithIcon(frameName = R.string.Allrecipes)
        Text(text = stringResource(id = R.string.Categories)
            , fontSize = 24.sp
            , modifier = Modifier.padding(start = 15.dp, top = 10.dp, bottom = 15.dp))
        Row(){
            Box() {
                Button(
                    onClick = {}, modifier = Modifier
                        .size(100.dp, 80.dp)
                        .background(color = Color.White)
                        .padding(start = 10.dp, top = 0.dp, end = 10.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(android.graphics.Color.LTGRAY)
                    )
                ) {
                }
                Text(
                    text = stringResource(id = R.string.Breakfast),
                    modifier = Modifier
                        .background(color = Color.Transparent)
                        .padding(start = 15.dp, top = 40.dp),color = Color.Gray
                )
            }

            Box() {
                Button(
                    onClick = {}, modifier = Modifier
                        .size(100.dp, 80.dp)
                        .background(color = Color.White)
                        .padding(start = 10.dp, top = 0.dp, end = 10.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(android.graphics.Color.LTGRAY)
                    )
                ) {
                }
                Text(
                    text = stringResource(id = R.string.Lunch),
                    modifier = Modifier
                        .background(color = Color.Transparent)
                        .padding(start = 28.dp, top = 40.dp),color = Color.Gray
                )
            }

            Box() {
                Button(
                    onClick = {}, modifier = Modifier
                        .size(100.dp, 80.dp)
                        .background(color = Color.White)
                        .padding(start = 10.dp, top = 0.dp, end = 10.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(android.graphics.Color.LTGRAY)
                    )
                ) {
                }
                Text(
                    text = stringResource(id = R.string.Dinner),
                    modifier = Modifier
                        .background(color = Color.Transparent)
                        .padding(start = 25.dp, top = 40.dp),color = Color.Gray
                )
            }

            Box() {
                Button(
                    onClick = {}, modifier = Modifier
                        .size(100.dp, 80.dp)
                        .background(color = Color.White)
                        .padding(start = 2.dp, top = 0.dp, end = 10.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(android.graphics.Color.LTGRAY)
                    )
                ) {
                }
                Text(
                    text = stringResource(id = R.string.Dessert),
                    modifier = Modifier
                        .background(color = Color.Transparent)
                        .padding(start = 15.dp, top = 40.dp),color = Color.Gray
                )
            }
        }

        Spacer(modifier = Modifier.height(290.dp))
        RocketDockTest()

    }
}


//                  -->> Do ovog dijela su screenovi <<--
 //                 -->> A dole ispod su pomoćne funkcije i dijelovi koji se ponavljaju na screenovima <<--

//                             -->> Default preview svih funkcija do sada <<--
@Composable
fun RocketDockTest(){
    RocketDock(plusIconn = R.drawable.addwhiteicon)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DetectasteProjectTheme {
       SignUpScreenTest()
       // WelcomeScreenTest()
       // SignUpScreenTest()
       // WelcomeScreenTest()
    }
}
//                            -->> Žuti BUTTON <<--
@Composable
fun FirstYellowButton(buttonOne: Int) {
    val firstButton = stringResource(id = buttonOne)
    val hexColor = "#FFBF00"
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(
            onClick = { },
            modifier = Modifier
                .size(330.dp, 60.dp)
                .align(alignment = CenterHorizontally)
                .padding(start = 20.dp)
                .clip(RoundedCornerShape(60.dp))
                .border(1.5.dp, color = Color.Yellow, shape = RoundedCornerShape(30.dp)),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(
                    android.graphics.Color.parseColor(
                        hexColor
                    )
                )
            )

        ) {
            Text(text = firstButton, fontSize = 18.sp, color = Color.Black)
        }
    }
}
//                     -->> Crni button <<--
@Composable
fun SecondBlackButton( ButtonTwo: Int) {
       Column(horizontalAlignment = Alignment.CenterHorizontally) {
           val secondButton = stringResource(id = ButtonTwo)
           Button(
               onClick = { },
               modifier = Modifier
                   .size(330.dp, 60.dp)
                   .padding(start = 20.dp)
                   .clip(RoundedCornerShape(60.dp))
                   .border(1.5.dp, color = Color.Yellow, shape = RoundedCornerShape(30.dp)),
               colors = ButtonDefaults.buttonColors(
                   backgroundColor = Color(android.graphics.Color.BLACK)

               )
           ) {
               Text(text = secondButton, fontSize = 18.sp, color = Color.White)
           }
       }
    }
//                       -->> Text za Welcome (početni) screen <<--
@Composable
fun WelcomeScreenTexts(welcomeText: Int, discoverText: Int, toOurAppText: Int){
    val welcomeTextInApp = stringResource(id = welcomeText)
    val underHeading = stringResource(id = discoverText)
    val ourApp = stringResource(id = toOurAppText)
    Text(
        text = welcomeTextInApp,
        fontSize = 40.sp,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 20.dp, top = 30.dp, bottom = 0.dp)
    )
    Text(
        text = ourApp,
        fontSize = 40.sp,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 20.dp, top = 0.dp)
    )
    Text(
        text = underHeading,
        fontSize = 20.sp,
        color = Color.Gray,
        fontWeight = FontWeight.Normal,
        modifier = Modifier.padding(start = 20.dp)
    )
}
//                    -->> Text za LOGIN screen/ isključivo naslov <<--
@Composable
fun LoginTexts(loginTextScreen: Int){
    val loginText = stringResource(id = loginTextScreen)
    Text(text = loginText,fontSize = 40.sp,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 20.dp, top = 30.dp, bottom = 0.dp))
}
//
//                        -->> TextField za Password <<--
@Composable
fun PassField(thislabel: Int){
        Column(
    horizontalAlignment = Alignment.CenterHorizontally) {
            var inputVal by remember { mutableStateOf("")}

        TextField(value = inputVal, onValueChange = { inputVal = it },
            singleLine = true,
            keyboardOptions = KeyboardOptions(),
            visualTransformation = PasswordVisualTransformation(),
            label = { Text(text = stringResource(id = thislabel), fontSize = 20.sp, color = Color.LightGray) },
            modifier = Modifier
                .background(color = Color.Transparent, shape = RoundedCornerShape(30.dp))
                .size(330.dp, 60.dp)
                .border(1.5.dp, color = Color.Yellow, shape = RoundedCornerShape(30.dp))
                ,colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.White
                )
        )

        }

}
 //                     -->> Text field za LOGIN I SIGN UP SCREEN <<--
@Composable
fun TextFields(thislabel: Int){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally) {
        var inputVal by remember { mutableStateOf("")}

        TextField(value = inputVal, onValueChange = { inputVal = it },
            singleLine = true,
            keyboardOptions = KeyboardOptions(),
            label = { Text(text = stringResource(id = thislabel), fontSize = 20.sp, color = Color.LightGray) },
            modifier = Modifier
                .background(color = Color.Transparent, shape = RoundedCornerShape(30.dp))
                .size(330.dp, 60.dp)
                .border(1.5.dp, color = Color.Yellow, shape = RoundedCornerShape(30.dp))
            ,colors = TextFieldDefaults.textFieldColors(
                textColor = Color.White
            )
        )

    }

}



//                     -->> Already have acc button from Sign Up screen or Dont have account from Login screen <<--
@Composable
fun BackupButton(sentence: Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent
            )
        ) {
            Text(text = stringResource(id = sentence), fontSize = 18.sp, color = Color.Gray)
        }
    }
}
//                         -->> Bottom menu bar na svim screenovima app <<--
@Composable
fun RocketDock(plusIconn: Int) {
    val plusIcon = painterResource(id = plusIconn)
    val hexColour = "#FFBF00"
    Column(verticalArrangement = Arrangement.Bottom) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(color = Color.White)
                .border(1.5.dp, color = Color.LightGray)
        ) {
            Button(
                onClick = { }, modifier = Modifier
                    .align(alignment = Center)
                    .size(65.dp, 65.dp)
                    .shadow(elevation = 13.dp, shape = CircleShape),
                shape = CircleShape,

                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(
                        android.graphics.Color.parseColor(
                            hexColour
                        )
                    )
                )
            ) {
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .background(color = Color.Transparent, shape = CircleShape)
                ) {
                    Icon(
                        painter = plusIcon,
                        contentDescription = "houseIcon",
                        modifier = Modifier
                            .fillMaxSize(), tint = Color.Unspecified
                    )

                }

            }

            Row(modifier = Modifier.padding(start = 15.dp,top = 20.dp)) {
                RocketDockIconButton(onClick = {}, IconValue = R.drawable.homefill)
                Spacer(modifier = Modifier.width(35.dp))
                RocketDockIconButton(onClick = { /*TODO*/ }, IconValue = R.drawable.searchicon)
                Spacer(modifier = Modifier.width(130.dp))
                RocketDockIconButton(onClick = { /*TODO*/ }, IconValue = R.drawable.saveikonica)
                Spacer(modifier = Modifier.width(32.dp))
                RocketDockIconButton(onClick = { /*TODO*/ }, IconValue = R.drawable.user_line)


            }
                    }

    }
}
//                     -->> Funkcija za pozivanje clickable ikonica <<--
@Composable
fun RocketDockIconButton(onClick: () ->Unit,IconValue: Int, modifier: Modifier = Modifier){
   val iconn = painterResource(id = IconValue)
    Icon(
       painter = iconn,
       contentDescription = "Icon",
        tint = Color.Gray,
       modifier = Modifier
           .size(40.dp, 40.dp)
           .background(color = Color.Transparent)
           .clickable { onClick() }
           )
}
//                       -->> Search bar za What would you like to cook today , za Main screen <<--
@Composable
fun SearchBar(thislabel: Int, modifier: Modifier = Modifier){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally) {
        var inputVal by remember { mutableStateOf("")}

            TextField(value = inputVal,
                onValueChange = { inputVal = it },
                singleLine = true,
                keyboardOptions = KeyboardOptions(),
                shape = RoundedCornerShape(40.dp),
                label = {
                    Text(
                        text = stringResource(id = thislabel),
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                },
                modifier = Modifier
                    .background(color = Color.Transparent, shape = RoundedCornerShape(0.dp))
                    .width(350.dp)
                    .border(1.5.dp, color = Color.White, shape = RoundedCornerShape(0.dp))
                    .padding(start = 20.dp)
                ,
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black
                ),
                leadingIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.searchicon),
                            contentDescription = "search",
                            modifier = Modifier.size(25.dp, 25.dp)
                        )
                    }
                }
            )

    }

}

@Composable
fun TopFrameNameWithIconTest(){
    TopFrameworkDescWithIcon(frameName = R.string.Allrecipes)
}
//                       -->> Gornji dio ALL RECIPES i SAVED RECIPES <<--
@Composable
fun TopFrameworkDescWithIcon(frameName: Int){
    val frameDesc = stringResource(id = frameName)
    Column(modifier = Modifier.background(color = Color.White)){
    Box(modifier = Modifier
        .height(70.dp)
        .fillMaxWidth()
        .background(color = Color.White)
        .border(1.5.dp, color = Color.Gray,)){
       Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 15.dp)){
             Spacer(modifier = Modifier
                 .height(15.dp)
                 .width(15.dp))
             RocketDockIconButton(
                 onClick = { /*TODO*/ },
                 IconValue = R.drawable.arrow_left_line
             )
           Spacer(modifier = Modifier.width(35.dp))
         Text(text = frameDesc,fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold)
    }
    }
    }
}


/*
* -> Napraviti jedan TextField i preko parametara prosljeđivati šta će da prima.
*                           -->> <<--
*                          -->> IMAM PROBLEM SA CENTRIRANJEM BUTTONA I TO POD HITNO RIJEŠIT ! <<--    //mogao bi biti problem da slike i funkcije scal
*  ----->>> Ubaciti Keyboard Options u text field  !  !  !
* */