package dev.ya2048cc.data.preference.core.model

import dev.ya2048cc.data.preference.core.model.base.BasePreferenceModel
import kotlinx.serialization.Serializable

@Serializable
data class ScorePreferenceModel(
    val score: Int,
    val previousScore: Int,
    val highScore: Int,
    val moves: Int,
) : BasePreferenceModel