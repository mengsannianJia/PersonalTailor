package com.smartlab411.personaltailor.base.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.Rect
import android.graphics.RectF
import android.util.AttributeSet
import androidx.cardview.widget.CardView
import com.smartlab411.personaltailor.base.R

/**
 *
 * @ProjectName:    PersonalTailor
 * @Package:        com.smartlab411.personaltailor.base.view
 * @ClassName:      TopRoundBottomSquareCard
 * @Description:    上圆下方的card
 * @Author:         jiajiangshan
 * @CreateDate:     2024/7/14 17:32
 * @UpdateUser:     更新者：
 * @UpdateDate:     2024/7/14 17:32
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 */
class TopRoundBottomSquareCard @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

    private var topLeftRadius: Float
    private var topRightRadius: Float

    init {
        topLeftRadius = context.resources.getDimensionPixelSize(R.dimen.default_top_left_radius.toInt()).toFloat()
        topRightRadius = context.resources.getDimensionPixelSize(R.dimen.default_top_right_radius.toInt()).toFloat()
    }

    override fun onDraw(canvas: Canvas) {
        val path = Path()
        val rectF = getRectF()

        // 设置圆角半径
        val radii = floatArrayOf(topLeftRadius, topLeftRadius, topRightRadius, topRightRadius, 0f, 0f, 0f, 0f)
        path.addRoundRect(rectF, radii, Path.Direction.CW)

        canvas.clipPath(path, android.graphics.Region.Op.INTERSECT)
        super.onDraw(canvas)
    }

    private fun getRectF(): RectF {
        val rect = Rect()
        getDrawingRect(rect)
        return RectF(rect.left.toFloat(), rect.top.toFloat(), rect.right.toFloat(), rect.bottom.toFloat())
    }
}