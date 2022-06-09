package master.flame.danmaku.danmaku.model.padding

import android.util.Log

/**
 * 弹幕padding
 * @author guoyixiong
 */
class DanmuSize(
    var textWidth: Float = -1F,
    var textHeight: Float = -1F,
    var paddingStart: Int,
    var paddingTop: Int,
    var paddingEnd: Int,
    var paddingBottom: Int,
    var borderWidth: Int = 0,//文字边框
    var strokeWidth: Float = 0F,//文字描边
) {
    constructor(padding: Int) : this(
        paddingStart = padding,
        paddingTop = padding,
        paddingEnd = padding,
        paddingBottom = padding
    )

    val paddingHorizontal: Int
        get() = paddingStart + paddingEnd
    val paddingVertical: Int
        get() = paddingTop + paddingBottom

    /**
     * 弹幕总宽度
     * 逻辑来自 [master.flame.danmaku.danmaku.model.android.AndroidDisplayer.setDanmakuPaintWidthAndHeight]
     */
    val width: Float
        get() {
            if (textWidth == -1F) {
                Log.e(tag, "文本宽度未设置")
            }
            return textWidth + paddingHorizontal + 2 * borderWidth + strokeWidth
        }

    /**
     * 弹幕总高度
     * 逻辑来自 [master.flame.danmaku.danmaku.model.android.AndroidDisplayer.setDanmakuPaintWidthAndHeight]
     */
    val height: Float
        get() {
            if (textHeight == -1F) {
                Log.e(tag, "文本高度未设置")
            }
            return textHeight + paddingVertical + 2 * borderWidth
        }

    /**
     * 文本到弹幕左侧的间距
     */
    val textPaddingStart: Float
        get() = (paddingStart + borderWidth).toFloat()

    /**
     * 文本到弹幕顶端的间距
     */
    val textPaddingTop: Float
        get() = (paddingTop + borderWidth).toFloat()

    /**
     * 如果文本尺寸有设置，则有效
     */
    val isValid: Boolean
        get() = textWidth >= 0 && textHeight >= 0

    /**
     * 获取文字底部，比如用于绘制下划线
     * @param startY 起始Y坐标
     */
    fun getTextBottom(startY: Float): Float {
        return textPaddingTop + textHeight + startY
    }

    /**
     * 除去border
     */
    fun getContentStart(startX: Float): Float {
        return startX + borderWidth
    }

    /**
     * 除去border
     */
    fun getContentTop(startY: Float): Float {
        return startY + borderWidth
    }

    fun getContentEnd(startX: Float): Float {
        return startX + width - borderWidth
    }

    fun getContentBottom(startY: Float): Float {
        return startY + height - borderWidth
    }

    fun setPadding(padding: Int) {
        paddingStart = padding
        paddingTop = padding
        paddingEnd = padding
        paddingBottom = padding
    }

    fun setHorizontalPadding(padding: Int) {
        paddingStart = padding
        paddingEnd = padding
    }

    fun setVerticalPadding(padding: Int) {
        paddingTop = padding
        paddingBottom = padding
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DanmuSize

        if (textWidth != other.textWidth) return false
        if (textHeight != other.textHeight) return false
        if (paddingStart != other.paddingStart) return false
        if (paddingTop != other.paddingTop) return false
        if (paddingEnd != other.paddingEnd) return false
        if (paddingBottom != other.paddingBottom) return false
        if (borderWidth != other.borderWidth) return false
        if (strokeWidth != other.strokeWidth) return false

        return true
    }

    override fun hashCode(): Int {
        var result = textWidth.hashCode()
        result = 31 * result + textHeight.hashCode()
        result = 31 * result + paddingStart
        result = 31 * result + paddingTop
        result = 31 * result + paddingEnd
        result = 31 * result + paddingBottom
        result = 31 * result + borderWidth
        result = 31 * result + strokeWidth.hashCode()
        return result
    }


    companion object {
        const val tag = "DanmuSize"
    }
}