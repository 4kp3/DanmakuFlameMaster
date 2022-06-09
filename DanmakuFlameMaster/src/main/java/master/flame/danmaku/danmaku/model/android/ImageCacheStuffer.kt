package master.flame.danmaku.danmaku.model.android

import android.graphics.Canvas
import master.flame.danmaku.danmaku.model.image.R2LImageDanmu
import master.flame.danmaku.danmaku.model.BaseDanmaku
import master.flame.danmaku.danmaku.model.android.AndroidDisplayer.DisplayerConfig
import kotlin.math.ceil

/**
 * 支持图片的弹幕填充器
 * @see IImage
 * @author guoyixiong
 */
open class ImageCacheStuffer : SpannedCacheStuffer() {

    override fun drawDanmaku(
        danmaku: BaseDanmaku,
        canvas: Canvas,
        left: Float,
        top: Float,
        fromWorkerThread: Boolean,
        displayerConfig: DisplayerConfig
    ) {
        super.drawDanmaku(danmaku, canvas, left, top, fromWorkerThread, displayerConfig)
        //当前实现为图像在左侧，后续可改为可配置图像相对位置
        if (danmaku is R2LImageDanmu) {
            val size = danmaku.size

            danmaku.image.drawable.run {
                val l=size.getContentStart(left)
                val t = top + danmaku.drawableTop
                val r = l + danmaku.image.drawableWidth
                val b = t + danmaku.image.drawableHeight
                val sc = canvas.saveCount
                canvas.save()
                setBounds(ceil(l).toInt(), ceil(t).toInt(), ceil(r).toInt(), ceil(b).toInt())
                draw(canvas)
                canvas.restoreToCount(sc)
            }
        }

    }

}