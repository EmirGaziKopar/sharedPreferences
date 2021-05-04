package com.emirgazikopar.kotlin_ilk

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences : SharedPreferences //SharedPreferences'in içinin null olmayacağının teminatını verdik
   // var a : String değişkenler bu şekilde bırakılamaz ya initialize edilir ya abstrack olarak kullanılır
   var a : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //bu bir fonksiyon bunun  içindeki değişkenler bu fonksiyonla beraber silinir ancak globalse o zaman başka

        sharedPreferences = this.getSharedPreferences("com.emirgazikopar.kotlin_ilk",Context.MODE_PRIVATE)

        val ageFromPreferences = sharedPreferences.getInt("anahtar",0)

        textView.text = "yas: ${ageFromPreferences}"


        print("${a}") // hata alıyor mu ? kontrol ediyoruz program çökmedi 

    }

    fun viewAge(view: View){
        //SharedPreferences bunu kullanarak küçük verileri kaydedebiliyoruz
        //SharedPreferences aktiviteden üretiliyor ve biz this ile aktiviteye referans veriyorduk

        //  val sharedPreferences = this.getSharedPreferences("com.emirgazikopar.kotlin_ilk",Context.MODE_PRIVATE) name kısmına package name girmek zorunlu değil ama genelde böyle kullanılır
        // Modeprivate bu kucuk veritabanının içindeki bilgilere sadece uygulama içinden erişim olduğu durumlarda kullanılır
        var aldim = age.text.toString().toIntOrNull() //ya int olarak al ya null olarak al methodu yani int dısında herseyi null varsayacak
       if (aldim!=null){
           textView.text = "Değer : ${aldim}"

           sharedPreferences.edit().putInt("anahtar",aldim).apply()//Bu tercihler için, tercihlerdeki verilerde değişiklikler yapabileceğiniz ve bu değişiklikleri otomatik olarak SharedPreferences nesnesine geri gönderebileceğiniz yeni bir Düzenleyici oluşturun.



       }



    }

    fun delete (view : View){
        val ageFromPreferences = sharedPreferences.getInt("anahtar",-1)
        if (ageFromPreferences == -1){
            textView.text="kanka deger yok neyi siliyon"
        }

        else if (ageFromPreferences != -1){
            sharedPreferences.edit().remove("anahtar").apply()
            textView.text = "Your Age: "
        }





    }




}


