package com.example.sampleMvvmCleanCompose.presentation.product.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.example.sampleMvvmCleanCompose.domain.model.Product

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ProductListItem (product: Product,onItemClick :(Product)->Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(product) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        
   /*     GlideImage(
            model = product.image, contentDescription = "",
            modifier  = Modifier
                .padding(2.dp)
                .height(40.dp)
                .width(40.dp),
            alignment = Alignment.Center,
            alpha = 1.0.toFloat(),
            contentScale =  ContentScale.Fit

        )*/
        
        Image(painter = rememberAsyncImagePainter(model = product.image),
            contentDescription =null ,
            modifier = Modifier
                .height(40.dp)
                .width(40.dp),
            contentScale = ContentScale.Fit,
        )
        
        Text(
            text = "${product.title}",
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Left,
            style = MaterialTheme.typography.bodyMedium)

        Text(
            text = "${product.price}",
            textAlign =TextAlign.Right,
            style = MaterialTheme.typography.bodyMedium,
            overflow = TextOverflow.Ellipsis
        
        )

    }
}
