package dev.ya2048cc.data.preference.core.model

import dev.ya2048cc.data.preference.core.model.base.BasePreferenceModel
import kotlinx.serialization.Serializable

@Serializable
data class GridPreferenceModel(
    val size: Int,
    val current: MutableList<IntArray>,
): BasePreferenceModel