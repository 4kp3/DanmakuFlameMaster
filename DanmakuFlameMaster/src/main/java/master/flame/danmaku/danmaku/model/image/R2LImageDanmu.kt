package master.flame.danmaku.danmaku.model.image

import master.flame.danmaku.danmaku.model.Duration
import master.flame.danmaku.danmaku.model.R2LDanmaku
import master.flame.danmaku.danmaku.model.image.IImage

/**
 * 从右向左类型的弹幕，支持左侧图片显示
 * 左侧图片将被垂直居中绘制在padding区间内，并靠左显示
 *
 * @author guoyixiong
 */
class R2LImageDanmu(
    val image: IImage,
    duration: Duration,
) : R2LDanmaku(duration) {

    private val logTag = "R2LImageDanmu"

    /**
     * 图片相对弹幕矩形的顶部高度
     * 确保图像居中绘制
     */
    val drawableTop: Float
        get() {
            return (size.height - image.drawableHeight) / 2F
        }

}