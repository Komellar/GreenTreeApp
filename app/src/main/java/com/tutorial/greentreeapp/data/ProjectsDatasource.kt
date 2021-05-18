package com.tutorial.greentreeapp.data

import com.tutorial.greentreeapp.R
import com.tutorial.greentreeapp.model.Designer
import com.tutorial.greentreeapp.model.Project

class ProjectsDatasource {

    val projectImg = arrayOf<Int>(
        R.drawable.project1,
        R.drawable.project2,
        R.drawable.project3,
        R.drawable.project4,
        R.drawable.project5,
        R.drawable.project6,
        R.drawable.project7,
        R.drawable.project8,
        R.drawable.project9,
        R.drawable.project10,
    )
    val projectRating = arrayOf<String>(
        "5/5",
        "4.9/5",
        "5/5",
        "5/5",
        "4.8/5",
        "4.9/5",
        "5/5",
        "4.9/5",
        "5/5",
        "5/5",
    )

    fun getProjects(): ArrayList<Project> {
        val projectsList = ArrayList<Project>()

        val pro1 = Project(
            1,
            projectImg[0],
            projectRating[0],
            "Piękny ogród w stylu japońskim. Wyzwaniem było zagospodarowanie tego " +
                    "terenu, ponieważ teren nie był równy. Udało się tutaj wypełnić całą " +
                    "przestrzeń kwaitami oraz krzwami, by nie było tu zbyt wiele cienia."
        )
        projectsList.add(pro1)

        val pro2 = Project(
            2,
            projectImg[1],
            projectRating[1],
            "Kolejny ciekawy projekt, w którym głównym zadaniem było otoczenie jeziora" +
                    " różnorodną roślinnością, tak by jezioro prezentowało się jak " +
                    "najbardziej okazale."
        )
        projectsList.add(pro2)

        val pro3 = Project(
            3,
            projectImg[2],
            projectRating[2],
            "Projekt z cyklu 'ograniczony teren'. Przy urzyciu palm oraz roślin o" +
                    " dużych liściach udało nam się uchwycić ten tropikalny klimat." +
                    " Pływając w tym basenie można poczuć się jak na Hawajach."
        )
        projectsList.add(pro3)

        val pro4 = Project(
            4,
            projectImg[3],
            projectRating[3],
            "Klimatyczny japoński ogród przy restauracji. Klienci czekający na swoje" +
                    " zamówienia mogą uspokoić się wpatrując się w kamyczkowy wodospad. " +
                    "Sporo drzew oraz wysokie trawy dopełniają klimatu."
        )
        projectsList.add(pro4)

        val pro5 = Project(
            5,
            projectImg[4],
            projectRating[4],
            "Szybki projekt balkonu, w którym udało nam się upchać trochę zielenii, " +
                    "dzięki czemu nabrał on trochę kolorytu. "
        )
        projectsList.add(pro5)

        val pro6 = Project(
            6,
            projectImg[5],
            projectRating[5],
            "Piękny ogród, w którym umieściliśmy wiele kwiatów, krzewów oraz kilka " +
                    "drzew. Wszystko połączone w idealny sposób, tak by dodały one swojego " +
                    "unikalnego uroku."
        )
        projectsList.add(pro6)

        val pro7 = Project(
            7,
            projectImg[6],
            projectRating[6],
            "Piękny ogród, w którym umieściliśmy wiele kwiatów, krzewów oraz kilka " +
                    "drzew. Wszystko połączone w idealny sposób, tak by dodały one swojego " +
                    "unikalnego uroku."
        )
        projectsList.add(pro7)

        val pro8 = Project(
            8,
            projectImg[7],
            projectRating[7],
            "Piękny ogród, w którym umieściliśmy wiele kwiatów, krzewów oraz kilka " +
                    "drzew. Wszystko połączone w idealny sposób, tak by dodały one swojego " +
                    "unikalnego uroku."
        )
        projectsList.add(pro8)

        val pro9 = Project(
            9,
            projectImg[8],
            projectRating[8],
            "Piękny ogród, w którym umieściliśmy wiele kwiatów, krzewów oraz kilka " +
                    "drzew. Wszystko połączone w idealny sposób, tak by dodały one swojego " +
                    "unikalnego uroku."
        )
        projectsList.add(pro9)

        val pro10 = Project(
            10,
            projectImg[9],
            projectRating[9],
            "Piękny ogród, w którym umieściliśmy wiele kwiatów, krzewów oraz kilka " +
                    "drzew. Wszystko połączone w idealny sposób, tak by dodały one swojego " +
                    "unikalnego uroku."
        )
        projectsList.add(pro10)

        return projectsList
    }
}