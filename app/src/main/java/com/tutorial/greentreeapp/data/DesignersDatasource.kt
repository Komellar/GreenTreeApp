package com.tutorial.greentreeapp.data

import com.tutorial.greentreeapp.R
import com.tutorial.greentreeapp.model.Designer

class DesignersDatasource {

//    val designerName = arrayOf<Int>(
//        R.string.designer1,
//        R.string.designer2,
//        R.string.designer3,
//        R.string.designer4,
//        R.string.designer5,
//    )

    val designerName = arrayOf(
        "Maciek",
        "Ela",
        "Andrzej",
        "Marek",
        "Kasia i Basia",
        "Maciek",
        "Ela",
        "Andrzej",
        "Marek",
        "Kasia i Basia"
    )

    fun loadDesigners(): List<Designer> {
        return listOf<Designer>(
            Designer(R.drawable.designer1, designerName[0], R.string.designer_desc1),
            Designer(R.drawable.designer2, designerName[1], R.string.designer_desc2),
            Designer(R.drawable.designer3, designerName[2], R.string.designer_desc3),
            Designer(R.drawable.designer4, designerName[3], R.string.designer_desc4),
            Designer(R.drawable.designer5, designerName[4], R.string.designer_desc5)
        )
    }

//    fun loadDesigners(): List<Designer> {
//        return listOf<Designer>(
//            Designer(R.drawable.designer1, R.string.designer1,R.string.designer_desc1),
//            Designer(R.drawable.designer2, R.string.designer2,R.string.designer_desc2),
//            Designer(R.drawable.designer3, R.string.designer3,R.string.designer_desc3),
//            Designer(R.drawable.designer4, R.string.designer4,R.string.designer_desc4),
//            Designer(R.drawable.designer5, R.string.designer5,R.string.designer_desc5)
//        )
//    }
}