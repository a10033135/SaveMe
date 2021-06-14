package idv.fanboat.saveme.util

import android.view.View

fun View.setVisible(visibility: Boolean) {
    this.visibility = if (visibility) View.VISIBLE else View.GONE
}
