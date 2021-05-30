package idv.fanboat.saveme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.yokeyword.fragmentation.BuildConfig
import me.yokeyword.fragmentation.Fragmentation

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Fragmentation
                .builder()
                .stackViewMode(Fragmentation.BUBBLE)
                .debug(BuildConfig.DEBUG)
                .install()



    }
}