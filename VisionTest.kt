package com.travels.searchtravels

import org.junit.Test
import com.travels.searchtravels.api.OnVisionApiListener
import com.travels.searchtravels.api.VisionApi
import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class VisionTest {
    @Test
    fun addition_isCorrect() {
        TestSinglePicture("beach.jpg", "beach")
        TestSinglePicture("mountain.jpg", "mountain")
        TestSinglePicture("sea.jpg", "sea")
        TestSinglePicture("snow.jpg", "snow")
        TestSinglePicture("ocean.jpg", "ocean")
    }

    private fun TestSinglePicture(name : String, picType : String){

        val img = Image("/imgs/"+name)
        Bitmap bitmap =(image.getDrawable() as BitmapDrawable).getBitmap()

        VisionApi.findLocation(
                bitmap,
                GetToken(),
                object : OnVisionApiListener {

                    override fun onSuccess(latLng: LatLng) {
                        Assert.assertTrue(true)
                    }

                    override fun onErrorPlace(category: String) {
                        Assert.assertEquals(picType, category)
                    }

                    override fun onError() {

                    }
                })
    }

    private fun GetToken():String{
        return "153654313221" //Print here your token
    }
}
