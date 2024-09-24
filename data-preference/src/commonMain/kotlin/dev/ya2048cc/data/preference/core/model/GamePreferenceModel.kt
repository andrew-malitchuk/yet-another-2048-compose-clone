package dev.ya2048cc.data.preference.core.model

import dev.ya2048cc.data.preference.core.model.base.BasePreferenceModel
import kotlinx.serialization.Serializable

@Serializable
data class GamePreferenceModel(
    val grid: GridPreferenceModel
): BasePreferenceModel