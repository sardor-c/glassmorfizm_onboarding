package com.scorp.glassmorfismonboarding.onboarding.domain.model

import androidx.compose.runtime.Immutable
import com.scorp.glassmorfismonboarding.R

@Immutable
data class Page(
    val title: String,
    val description: String,
    val image: Int
)

val pages = listOf(
    Page(
        title = "30 days Meditation Challenge",
        description = "100+ guided meditations covering anxiety, focus, stress, gratitude and more.",
        image = R.drawable.img1,
    ),
    Page(
        title = "Choose your top goal",
        description = "Practice your breathing, relax your body, listen the calming sound music make you feel better. ",
        image = R.drawable.img2,
    ),
    Page(
        title = "Listen the calming music help you sleep",
        description = "50+ music with the calming sound help you to fall asleep faster. Calm can change your life.",
        image = R.drawable.img3,
    ),
)