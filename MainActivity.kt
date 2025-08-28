package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.foundation.lazy.items


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                var telaAtual by remember { mutableStateOf("primeira") }

                when (telaAtual) {
                    "primeira" -> {
                        primeiraTela(
                            onGraduationClick = { telaAtual = "segunda" }
                        )
                    }
                    "segunda" -> {
                        SegundaTela(
                            onBackClick = { telaAtual = "primeira" }
                        )
                    }
                }
            }
        }
    }
}

// ========================================================================
// CÓDIGO DA PRIMEIRA TELA (VICTOR)
// ========================================================================

@Preview
@Composable
fun primeiraTela(onGraduationClick: () -> Unit = {}) {
    //    Chamando Meu Background
    background()

    val scroll = rememberScrollState()
    LaunchedEffect(Unit) { scroll.animateScrollTo(100) }

    val roxo = Color(0xFF512F7B)
    val laranja = Color(0xFFD78C64)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scroll)
            .padding(horizontal = 8.dp)
    ) {
        //  Header e Playlists
        header()

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Playlists",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(Modifier.height(10.dp))

        playlistsComIcones()

        Spacer(Modifier.height(10.dp))

        playlistsComIcones()


        Spacer(Modifier.height(20.dp))

        //  Texto Dos Recentes
        Row(

            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Recentes",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Mostrar tudo",
                color = Color.Gray,
                fontSize = 14.sp
            )
        }

        Spacer(Modifier.height(10.dp))

        // Artistas e Playlists
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ArtistasRecentes("Matue", "Artista")
            ArtistasRecentes("Alee", "Artista")
            PlaylistRecente("So As Braba", "Playlist - vihhz")
        }

        Spacer(Modifier.height(20.dp))

        //  Texto Dos Albuns
        Text(
            text = "Álbuns de artistas que você segue",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(10.dp))

        Spacer(Modifier.height(10.dp))

        // Albuns
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            AlbumCard("333", "Matue", onClick = {})
            AlbumCard("Meu Amigo Diario...", "Yunk Vinno", onClick = {})

            AlbumCard(
                titulo = "Graduation",
                subTitulo = "Kanye West",
                onClick = onGraduationClick,
                gradientStartColor = roxo,
                gradientEndColor = laranja
            )
        }

        Spacer(Modifier.height(20.dp))

        //  Texto Escolhido Para Você
        Text(
            text = "Escolhido para você",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(10.dp))

        //Album Do Escolhido Para Voce
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            colors = CardDefaults.cardColors(Color.DarkGray)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Capa do álbum
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.Black, shape = RoundedCornerShape(6.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = null,
                        tint = Color.Red,
                        modifier = Modifier.size(50.dp)
                    )
                }

                Spacer(Modifier.width(10.dp))

                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Álbum",
                        color = Color.Gray,
                        fontSize = 12.sp
                    )
                    Text(
                        "Dias Antes Do Caos",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Alee",
                        color = Color.Gray,
                        fontSize = 12.sp
                    )
                }

            }
        }

    }
}

@Composable
fun background() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        color = Color.Black
    ) {}
}

@Composable
fun header() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Black)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 8.dp, horizontal = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "header-menu",
                tint = Color.White,
                modifier = Modifier.size(40.dp)
            )
            Text(
                text = "My Music",
                color = Color.Cyan,
                style = MaterialTheme.typography.bodyLarge,
            )
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "header-perfil",
                tint = Color.White,
                modifier = Modifier.size(40.dp)
            )
        }
    }
}

@Composable
fun playlistsComIcones() {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IconCard("sunshine", Icons.Default.Favorite)
            IconCard("flawless ️", Icons.Default.Star)
        }

        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IconCard("Alee", Icons.Default.Favorite)
            IconCard("CAOS DLX", Icons.Default.Favorite)
        }
    }
}

@Composable
fun IconCard(title: String, icon: ImageVector) {
    Card(
        modifier = Modifier
            .width(170.dp)
            .height(100.dp),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Black, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = Color.Cyan,
                    modifier = Modifier.size(30.dp)
                )
            }
            Spacer(Modifier.height(8.dp))
            Text(
                text = title,
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun ArtistasRecentes(titulo: String, subTitulo: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.White, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Face,
                contentDescription = null,
                tint = Color.Red,
                modifier = Modifier.size(50.dp)
            )
        }
        Spacer(Modifier.height(6.dp))

        Text(
            titulo,
            color = Color.White,
            fontSize = 14.sp
        )
        Text(
            subTitulo,
            color = Color.Gray,
            fontSize = 12.sp
        )
    }
}


@Composable
fun PlaylistRecente(titulo: String, subTitulo: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.White, shape = RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = null,
                tint = Color.Magenta,
                modifier = Modifier.size(40.dp)
            )
        }

        Spacer(Modifier.height(6.dp))

        Text(
            titulo,
            color = Color.White,
            fontSize = 14.sp
        )
        Text(
            subTitulo,
            color = Color.Gray,
            fontSize = 12.sp
        )
    }
}

@Composable
fun AlbumCard(
    titulo: String,
    subTitulo: String,
    onClick: () -> Unit,
    gradientStartColor: Color? = null,
    gradientEndColor: Color? = null
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.clickable { onClick() }
    ) {
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(
                    brush = if (gradientStartColor != null && gradientEndColor != null) {
                        Brush.linearGradient(
                            colors = listOf(gradientStartColor, gradientEndColor),
                            start = Offset(0f, 0f),
                            end = Offset(1000f, 1000f)
                        )
                    } else {
                        SolidColor(Color.White)
                    },
                    shape = RoundedCornerShape(8.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            if (gradientStartColor == null && gradientEndColor == null) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = null,
                    tint = Color.Red,
                    modifier = Modifier.size(40.dp)
                )
            }
        }
        Spacer(Modifier.height(6.dp))
        Text(
            titulo,
            color = Color.White,
            fontSize = 14.sp, maxLines = 1
        )
        Text(
            subTitulo,
            color = Color.Gray,
            fontSize = 12.sp, maxLines = 1
        )
    }
}

// ========================================================================
// CÓDIGO DA SEGUNDA TELA (LUCAS)
// ========================================================================

@Preview
@Composable
fun SegundaTela(onBackClick: () -> Unit = {}) {
    Surface(color = Color(0xFF131313), modifier = Modifier.fillMaxSize()) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            headerPlaylist(onBackClick = onBackClick)

            Spacer(modifier = Modifier.height(16.dp))

            CapasPlaylist()

            Spacer(modifier = Modifier.height(24.dp))

            BodyPlaylistContent()

            Spacer(modifier = Modifier.height(16.dp))

            MusicaItem("Good Morning", "Kanye West")
            MusicaItem("Champion", "Kanye West")
            MusicaItem("Stronger", "Kanye West")
            MusicaItem("I Wonder", "Kanye West")
            MusicaItem("Good Life", "Kanye West, T-Pain")
            MusicaItem(titulo = "Can't Tell Me Nothing", artista = "Kanye West")
            MusicaItem(titulo = "Barry Bonds", artista = "Kanye West, Lil Wayne")
            MusicaItem(titulo = "Drunk and Hot Girls", artista = "Kanye West, Mos Def")
            MusicaItem(titulo = "Flashing Lights", artista = "Kanye West, Dwele")
            MusicaItem(titulo = "Everything I Am", artista = "DJ Premiere")
            MusicaItem(titulo = "Glory", artista = "Kanye West")
            MusicaItem(titulo = "Homecoming", artista = "Kanye West")
            MusicaItem(titulo = "Big Brother", artista = "Kanye West")

            Spacer(modifier = Modifier.height(40.dp))

            DetalhesAlbum()

            Spacer(modifier = Modifier.height(40.dp))
            recomendados()

            Spacer(modifier = Modifier.height(100.dp))
        }
        Footer()
    }
}

@Composable
fun headerPlaylist(onBackClick: () -> Unit){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
        colors = CardDefaults
            .cardColors(containerColor = Color.Transparent)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 8.dp, horizontal = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "back-to-menu",
                tint = Color.White,
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
                    .clickable { onBackClick() }
            )
        }
    }
}

@Composable
fun CapasPlaylist() {
    val roxo = Color(0xFF512F7B)
    val laranja = Color(0xFFD78C64)

    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Card(
            modifier = Modifier
                .width(250.dp)
                .height(250.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(roxo, laranja),
                            start = Offset.Infinite.copy(x = Float.POSITIVE_INFINITY, y = 0f),
                            end = Offset(0f, Float.POSITIVE_INFINITY)
                        )
                    )
            ) {
            }
        }
        Text(
            text = "Graduation",
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = "Kanye West",
            color = Color.White,
            style = MaterialTheme.typography.bodyMedium,
        )
        Text(
            text = "Álbum • 11 de set. de 2007",
            color = Color.LightGray,
            style = MaterialTheme.typography.bodySmall,
        )
    }
}

@Composable
fun BodyPlaylistContent() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.AddCircle,
            contentDescription = "Adicionar",
            tint = Color.White,
            modifier = Modifier
                .size(40.dp)
                .clickable { /* ação futura */ }
        )
        Icon(
            imageVector = Icons.Default.KeyboardArrowDown,
            contentDescription = "Download",
            tint = Color.White,
            modifier = Modifier
                .size(40.dp)
                .clickable { /* ação futura */ }
        )
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "Mais opções",
            tint = Color.White,
            modifier = Modifier
                .size(40.dp)
                .clickable { /* ação futura */ }
        )
        Icon(
            imageVector = Icons.Default.Refresh,
            contentDescription = "Atualizar",
            tint = Color.White,
            modifier = Modifier
                .size(40.dp)
                .clickable { /* ação futura */ }
        )
        Icon(
            imageVector = Icons.Default.PlayArrow,
            contentDescription = "Tocar",
            tint = Color(0xFF1DD760),
            modifier = Modifier
                .size(60.dp)
                .clickable { /* ação futura */ }
        )
    }
}

@Composable
fun MusicaItem(titulo: String, artista: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = titulo,
                color = Color.White,
                fontSize = 16.sp,
                style = MaterialTheme.typography.bodyLarge
            )
            Row (horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                Icon(
                    imageVector = Icons.Default.Warning,
                    contentDescription = "back-to-menu",
                    tint = Color(0xFF9E9E9E),
                    modifier = Modifier
                        .height(9.dp)
                        .width(9.dp)
                )
                Text(modifier = Modifier.padding(start = 5.dp),
                    text = artista,
                    color = Color(0xFF5C5C5C),
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.bodyMedium
                )

            }
        }

        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "Mais opções",
            tint = Color.White
        )
    }
}

@Composable
fun Footer() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF111111))
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = Icons.Default.Home, contentDescription = "Home", tint = Color.White, modifier = Modifier.size(40.dp))
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search", tint = Color.White, modifier = Modifier.size(40.dp))
            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu", tint = Color.White, modifier = Modifier.size(40.dp))
            Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Cart", tint = Color.White, modifier = Modifier.size(40.dp))
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add", tint = Color.White, modifier = Modifier.size(40.dp))
        }
    }
}

@Preview
@Composable
fun DetalhesAlbum() {
    val roxo = Color(0xFF512F7B)
    val laranja = Color(0xFFD78C64)

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .width (340.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Box(
            modifier = Modifier
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(roxo, laranja),
                        start = Offset(0f, 0f),
                        end = Offset(1000f, 1000f)
                    )
                )
                .padding(16.dp)
        ) {
            Text(
                text = "Graduation é o terceiro álbum de estúdio do rapper estadunidense Kanye West. O seu lançamento ocorreu em 10 de setembro de 2007...",
                color = Color.White,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

data class AlbumRecomendado(
    val titulo: String,
    val artista: String,
    val corGradiente1: Color,
    val corGradiente2: Color
)

@Preview
@Composable
fun recomendados() {
    val listaRecomendados = listOf(
        AlbumRecomendado("The Life Of Pablo", "Kanye West", Color(0xFFF98F34), Color(0xFFB1D4E0)),
        AlbumRecomendado("My Beautiful Dar...", "Kanye West", Color(0xFFC00000), Color(0xFF000000)),
        AlbumRecomendado("808s & Heartbreak", "Kanye West", Color(0xFF8A8A8A), Color(0xFFE57777)),
        AlbumRecomendado("IGOR", "Tyler, The Creator", Color(0xFFF5A9B8), Color(0xFF965F6E)),
        AlbumRecomendado("Blonde", "Frank Ocean", Color(0xFFEAE7E2), Color(0xFF9C9A99))
    )

    Column {
        Text(
            text = "Recomendado para você",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(items = listaRecomendados) { album ->
                AlbumCard(
                    titulo = album.titulo,
                    subTitulo = album.artista,
                    onClick = { /* Ação futura ao clicar no recomendado */ },
                    gradientStartColor = album.corGradiente1,
                    gradientEndColor = album.corGradiente2
                )
            }
        }
    }
}
