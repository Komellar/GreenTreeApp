package com.tutorial.greentreeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pdfview.PDFView

class PdfActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf)

        findViewById<PDFView>(R.id.activityMainPdfView).fromAsset("dokument.pdf").show()
    }
}