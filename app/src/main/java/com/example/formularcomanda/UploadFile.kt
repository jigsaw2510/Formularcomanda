package com.example.formularcomanda

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class UploadFile : AppCompatActivity() {
    companion object {
        private const val REQUEST_SELECT_PHOTO = 1
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_file)

        val selectPhotoButton = findViewById<Button>(R.id.select_photo_button)

        selectPhotoButton.setOnClickListener {
            val photoPickerIntent = Intent(Intent.ACTION_PICK)
            photoPickerIntent.type = "image/*"
            startActivityForResult(photoPickerIntent, REQUEST_SELECT_PHOTO)
        }

        val homePageButton = findViewById<Button>(R.id.buttonFirstActivity)

        homePageButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val selectedPhotoImageView = findViewById<ImageView>(R.id.selected_photo_image_view)

        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_SELECT_PHOTO) {
            val selectedPhotoUri = data?.data
            // Do something with the selected photo URI, such as upload it to a server or display it in an ImageView.
            selectedPhotoImageView.setImageURI(selectedPhotoUri)
        }
    }


}