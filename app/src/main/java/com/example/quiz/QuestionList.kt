package com.example.quiz

object QuestionList {

    fun getQuestion():MutableList<Question>{
        val list = mutableListOf<Question>()
        list.add(Question(
            1,
            "Joqardagi suwrettin' bayraqtin' atin tabin'?",
            R.drawable.qaraqalpaq_flag,
            "Qazaqstan",
            "Ozbekistan",
            "Qaraqalpaqistan",
            "Turmenstan",
            3

        ))


        list.add(Question(
            2,
            "Joqardagi suwrettin' bayraqtin' atin tabin'?",
            R.drawable.qazaqstan_flag,
            "Qazaqstan",
            "Qirgizstan",
            "Tadjikistan",
            "Mongolia",
            1
        ))

        list.add(Question(
            3,
            "Joqardagi suwrettin' bayraqtin' atin tabin'?",
            R.drawable.usa_flag,
            "Rossia",
            "Turkia",
            "India",
            "USA",
            4
        ))

        list.add(
            Question(
                4,
                "Joqardaǵi suwrettegi bayraqtiń atin tabiń?",
                R.drawable.kanada_flag,
                "Mexico",
                "Brazil",
                "Canada",
                "England",
                3
            ))

        list.add(
            Question(
                5,
                "Joqardaǵi suwrettegi bayraqtiń atin tabiń?",
                R.drawable.germany_flag,
                "Germany",
                "Francia",
                "India",
                "Brazil",
                1
            ))

        list.add(Question(
            6,
            "Joqardaǵi suwrettegi bayraqtiń atin tabiń?",
            R.drawable.china_flag,
            "China",
            "Korea",
            "Russia",
            "Avganistan",
            1
        ))

        list.add(Question(
            7,
            "Joqarda berilgen bayraq qaysi juwapqa tiyisli?",
            R.drawable.kanada_flag,
            "Soudie Arabia",
            "Pakistan",
            "Turkye",
            "Spain",
            2
        ))
        return list
    }
}