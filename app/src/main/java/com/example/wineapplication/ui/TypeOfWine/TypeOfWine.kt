/*
 * Copyright (c) 2018 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 */

package com.raywenderlich.android.alltherecipes

import android.content.Context
import org.json.JSONException
import org.json.JSONObject


class TypeOfWine(
    val title: String,
   // val averageRating: Double,
    val price:String,
    val description: String,
    val link: String,
    val imageUrl: String) {

  companion object {

    fun ParseJsonToList(jsonString: String,context: Context): ArrayList<TypeOfWine> {
      val TypeOfWineList = ArrayList<TypeOfWine>()

      try {
        // Load data
        val json = JSONObject(jsonString)
        val Wines = json.getJSONArray("recommendedWines")

        // Get Recipe objects from data
        (0 until Wines.length()).mapTo(TypeOfWineList) {
          TypeOfWine(Wines.getJSONObject(it).getString("title"),
              //recipes.getJSONObject(it).getDouble("averageRating"),
              Wines.getJSONObject(it).getString("price"),
              Wines.getJSONObject(it).getString("description"),
                  Wines.getJSONObject(it).getString("link"),
              Wines.getJSONObject(it).getString("imageUrl"))
        }
      } catch (e: JSONException) {
        e.printStackTrace()
      }

      return TypeOfWineList
    }

  }
}